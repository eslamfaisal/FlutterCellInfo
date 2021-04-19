package com.airfore.cell_info

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import cz.mroczis.netmonster.core.factory.NetMonsterFactory
import cz.mroczis.netmonster.core.model.cell.*
import java.util.*
import io.flutter.plugin.common.MethodChannel.Result

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
    fun requestData(context: Context,  result: io.flutter.plugin.common.MethodChannel.Result) {
        NetMonsterFactory.get(context).apply {
            val merged = getCells()
            merged.forEach {
                it.let(processor = transformer)
            }
            Log.d("NTM-RES", " \n${merged.joinToString(separator = "\n")}")
        }

//        if(list[0] is CellLte)
        Log.d(TAG, "requestData list siz: ${list.size}")

        when {
            list[0] is CellLte -> result.success("Your dbm is : ${(list[0] as CellLte).signal.dbm}")
            list[0] is CellCdma -> result.success("Your dbm is : ${(list[0] as CellCdma).signal.dbm}")
            list[0] is CellGsm -> result.success("Your dbm is : ${(list[0] as CellGsm).signal.dbm}")
            list[0] is CellNr -> result.success("Your dbm is : ${(list[0] as CellNr).signal.dbm}")
            list[0] is CellTdscdma -> result.success("Your dbm is : ${(list[0] as CellTdscdma).signal.dbm}")
            list[0] is CellWcdma -> result.success("Your dbm is : ${(list[0] as CellWcdma).signal.dbm}")
        }
    }
}