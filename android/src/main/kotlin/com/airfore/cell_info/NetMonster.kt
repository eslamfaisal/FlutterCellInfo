package com.airfore.cell_info

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
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
    fun requestData(context: Context) {
        NetMonsterFactory.get(context).apply {
            val merged = getCells()
            merged.forEach {
                it.let(processor = transformer)
            }
            Log.d("NTM-RES", " \n${merged.joinToString(separator = "\n")}")
        }

        Log.d(TAG, "requestData: ${list.size}")
    }
}