package com.airfore.cell_info

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.airfore.cell_info.models.cdma.getCdma
import com.airfore.cell_info.models.common.Network
import com.airfore.cell_info.models.gsm.getGsm
import com.airfore.cell_info.models.lte.getLte
import com.airfore.cell_info.models.nr.BandNR
import com.airfore.cell_info.models.nr.CellNR
import com.airfore.cell_info.models.nr.SignalNR
import com.airfore.cell_info.models.nr.getNr
import com.google.gson.Gson
import cz.mroczis.netmonster.core.factory.NetMonsterFactory
import cz.mroczis.netmonster.core.model.cell.*

class NetMonster {

    private val TAG = "NetMonster"

    val list: MutableList<Any> = ArrayList()
    private val transformer = object : ICellProcessor<Unit> {

        override fun processLte(cell: CellLte) {
            list.add(cell)
            Log.d(TAG, "processLte: ")
        }

        override fun processCdma(cell: CellCdma) {

            list.add(cell)
        }

        override fun processGsm(cell: CellGsm) {
            list.add(cell)

        }

        override fun processNr(cell: CellNr) {
            list.add(cell)

        }

        override fun processTdscdma(cell: CellTdscdma) {

            list.add(cell)
        }

        override fun processWcdma(cell: CellWcdma) {
            list.add(cell)

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

//        if(list[0] is CellLte)
        Log.d(TAG, "requestData list siz: ${list.size}")

        val cells: MutableList<Any> = ArrayList()
        list.forEach { cell ->

            when (cell) {
                is CellLte -> {
                    cells.add(getLte(cell))
                }
                is CellNr -> {
                    cells.add(getNr(cell))
                }
                is CellCdma -> {
                    cells.add(getCdma(cell))
                }
                is CellGsm -> {
                    cells.add(getGsm(cell))
                }

//                is CellTdscdma -> result.success("Your dbm is : ${(list[0] as CellTdscdma).signal.dbm}")
//                is CellWcdma -> result.success("Your dbm is : ${(list[0] as CellWcdma).signal.dbm}")
            }


        }

        result.success("Your dbm is : ${Gson().toJson(cells)}")

    }
}