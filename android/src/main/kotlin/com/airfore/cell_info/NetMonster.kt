package com.airfore.cell_info

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.airfore.cell_info.models.CellData
import com.airfore.cell_info.models.CellType
import com.airfore.cell_info.models.CellsResponse
import com.airfore.cell_info.models.cdma.getCdma
import com.airfore.cell_info.models.gsm.getGsm
import com.airfore.cell_info.models.lte.getLte
import com.airfore.cell_info.models.nr.getNr
import com.airfore.cell_info.models.tdscdma.getTdscdma
import com.airfore.cell_info.models.wcdma.getWcdma
import com.google.gson.Gson
import cz.mroczis.netmonster.core.factory.NetMonsterFactory
import cz.mroczis.netmonster.core.model.cell.*
import cz.mroczis.netmonster.core.model.connection.PrimaryConnection

class NetMonster {

    private val TAG = "NetMonster"

    private val primaryCellList: MutableList<CellType> = ArrayList()
    private val neighboringCellList: MutableList<CellType> = ArrayList()
    private val cellDataList: MutableList<CellData> = ArrayList()

    @SuppressLint("MissingPermission")
    fun requestData(
        context: Context,
        result: io.flutter.plugin.common.MethodChannel.Result? = null
    ): CellsResponse {
        NetMonsterFactory.get(context).apply {
            val merged = getCells()
            merged.forEach { cell ->

                when (cell) {

                    is CellNr -> {
                        Log.d(TAG, "requestData: NR")

                        val cellType = CellType()
                        val cellData = CellData()
                        cellType.nr = getNr(cell, cellData)
                        cellType.type = "NR"
                        when (cell.connectionStatus) {
                            is PrimaryConnection -> {
                                primaryCellList.add(cellType)
                            }
                            else -> {
                                neighboringCellList.add(cellType)
                            }
                        }
                        cellDataList.add(cellData)

                    }
                    is CellLte -> {
                        Log.d(TAG, "requestData: LTE")

                        val cellType = CellType()
                        val cellData = CellData()

                        cellType.lte = getLte(cell, cellData)
                        cellType.type = "LTE"
                        when (cell.connectionStatus) {
                            is PrimaryConnection -> {
                                primaryCellList.add(cellType)
                            }
                            else -> {
                                neighboringCellList.add(cellType)
                            }
                        }
                        cellDataList.add(cellData)
                    }
                    is CellWcdma -> {
                        Log.d(TAG, "requestData: WCDMA")

                        val cellType = CellType()
                        val cellData = CellData()

                        cellType.wcdma = getWcdma(cell, cellData)
                        cellType.type = "WCDMA"
                        when (cell.connectionStatus) {
                            is PrimaryConnection -> {
                                primaryCellList.add(cellType)
                            }
                            else -> {
                                neighboringCellList.add(cellType)
                            }
                        }
                        cellDataList.add(cellData)

                    }
                    is CellCdma -> {
                        Log.d(TAG, "requestData: CDMA")

                        val cellType = CellType()
                        val cellData = CellData()

                        cellType.cdma = getCdma(cell, cellData)
                        cellType.type = "WCDMA"
                        when (cell.connectionStatus) {
                            is PrimaryConnection -> {
                                primaryCellList.add(cellType)
                            }
                            else -> {
                                neighboringCellList.add(cellType)
                            }
                        }

                        cellDataList.add(cellData)
                    }
                    is CellGsm -> {
                        Log.d(TAG, "requestData: GSM")


                        val cellType = CellType()
                        val cellData = CellData()

                        cellType.gsm = getGsm(cell, cellData)
                        cellType.type = "GSM"
                        when (cell.connectionStatus) {
                            is PrimaryConnection -> {
                                primaryCellList.add(cellType)
                            }
                            else -> {
                                neighboringCellList.add(cellType)
                            }
                        }
                        cellDataList.add(cellData)
                    }
                    is CellTdscdma -> {
                        Log.d(TAG, "requestData: TDSCDMA")

                        val cellType = CellType()
                        val cellData = CellData()
                        cellType.tdscdma = getTdscdma(cell, cellData)
                        cellType.type = "TDSCDMA"
                        when (cell.connectionStatus) {
                            is PrimaryConnection -> {
                                primaryCellList.add(cellType)
                            }
                            else -> {
                                neighboringCellList.add(cellType)
                            }
                        }
                        cellDataList.add(cellData)
                    }

                    else -> {
                        Log.d(TAG, "requestData: ")
                    }

                }
            }
            Log.d("NTM-RES", " \n${merged.joinToString(separator = "\n")}")
        }

        val cellsResponse = CellsResponse()
        cellsResponse.neighboringCellList = neighboringCellList
        cellsResponse.primaryCellList = primaryCellList
        cellsResponse.cellDataList = cellDataList

        cellDataList.forEach {
            Log.d("it.subscriptionId", "requestData: ${it.type}")
            Log.d("it.subscriptionId", "requestData: ${it.subscriptionId}")
        }


        Log.d(TAG, "requestData: " + Gson().toJson(cellsResponse))
        result?.success(Gson().toJson(cellsResponse))
        return cellsResponse
    }
}


// region fake data
//
//        val wcdmaCellType = CellType()
//        wcdmaCellType.wcdma = getWcdmaFake()
//        wcdmaCellType.type = "WCDMA"
//        cellsResponse.neighboringCellList.add(wcdmaCellType)
//        cellsResponse.primaryCellList.add(wcdmaCellType)
//
//        val nrCellType = CellType()
//        nrCellType.nr = getNrFake()
//        nrCellType.type = "NR"
//        cellsResponse.neighboringCellList.add(nrCellType)
//        cellsResponse.primaryCellList.add(nrCellType)
//
//        val LTECellType = CellType()
//        LTECellType.lte = getLteFake()
//        LTECellType.type = "LTE"
//        cellsResponse.neighboringCellList.add(LTECellType)
//        cellsResponse.primaryCellList.add(LTECellType)
//
//
//        val gsmType = CellType()
//        gsmType.gsm = getGsmFake()
//        gsmType.type = "GSM"
//        cellsResponse.neighboringCellList.add(gsmType)
//        cellsResponse.primaryCellList.add(gsmType)
//
//        val tdscdmaCellType = CellType()
//        tdscdmaCellType.tdscdma = getTdscdmaFake()
//        tdscdmaCellType.type = "tdscdma"
//        cellsResponse.neighboringCellList.add(tdscdmaCellType)
//        cellsResponse.primaryCellList.add(tdscdmaCellType)
//
//
//        val cdmaCellType = CellType()
//        cdmaCellType.cdma = getCdmaFake()
//        cdmaCellType.type = "CDMA"
//        cellsResponse.neighboringCellList.add(cdmaCellType)
//        cellsResponse.primaryCellList.add(cdmaCellType)
//endregion
