package com.airfore.cell_info

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.airfore.cell_info.models.cdma.getCdma
import com.airfore.cell_info.models.gsm.getGsm
import com.airfore.cell_info.models.lte.getLte
import com.airfore.cell_info.models.nr.getNr
import com.airfore.cell_info.models.tdscdma.getTdscdma
import com.airfore.cell_info.models.wcdma.getWcdma
import com.google.gson.Gson
import cz.mroczis.netmonster.core.factory.NetMonsterFactory
import cz.mroczis.netmonster.core.model.cell.*

class NetMonster {

    private val TAG = "NetMonster"

    val cells: MutableList<Any> = ArrayList()


    private val transformer = object : ICellProcessor<Unit> {

        override fun processLte(cell: CellLte) {
            cells.add(getLte(cell))
        }

        override fun processCdma(cell: CellCdma) {
            cells.add(getCdma(cell))
        }

        override fun processGsm(cell: CellGsm) {
            cells.add(getGsm(cell))

        }

        override fun processNr(cell: CellNr) {
            cells.add(getNr(cell))
        }

        override fun processTdscdma(cell: CellTdscdma) {
            cells.add(getTdscdma(cell))
        }

        override fun processWcdma(cell: CellWcdma) {
            cells.add(getWcdma(cell))
        }

    }

    @SuppressLint("MissingPermission")
    fun requestData(context: Context, result: io.flutter.plugin.common.MethodChannel.Result) {
        NetMonsterFactory.get(context).apply {
            val merged = getCells()
            merged.forEach {
                it.let(processor = transformer)
            }
            Log.d("NTM-RES", " \n${merged.joinToString(separator = "\n")}")
        }

        result.success("Your dbm is : ${Gson().toJson(cells)}")

    }
}