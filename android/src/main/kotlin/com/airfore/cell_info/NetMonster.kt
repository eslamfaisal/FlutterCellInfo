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

                is CellNr -> {
                    Log.d(TAG, "requestData: NR")

                    cells.add(getNr(cell))
                }
                is CellLte -> {
                    Log.d(TAG, "requestData: LTE")
                    cells.add(getLte(cell))

                }
                is CellWcdma -> {
                    Log.d(TAG, "requestData: WCDMA")
                    cells.add(getWcdma(cell))
                }
                is CellCdma -> {
                    Log.d(TAG, "requestData: CDMA")

                    cells.add(getCdma(cell))
                }
                is CellGsm -> {
                    Log.d(TAG, "requestData: GSM")

                    cells.add(getGsm(cell))
                }
                is CellTdscdma -> {
                    Log.d(TAG, "requestData: TDSCDMA")

                    cells.add(getTdscdma(cell))
                }

            }


        }

        result.success("Your dbm is : ${Gson().toJson(cells)}")

    }
}