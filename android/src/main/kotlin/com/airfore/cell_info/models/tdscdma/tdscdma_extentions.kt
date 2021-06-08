package com.airfore.cell_info.models.tdscdma

import com.airfore.cell_info.models.common.Network
import cz.mroczis.netmonster.core.model.cell.CellTdscdma

fun getTdscdma(cell: CellTdscdma): CellTDSCDMA {

    val cellGSM = CellTDSCDMA()
    cellGSM.type = "TDSCDMA"

    cellGSM.bandTDSCDMA = BandTDSCDMA()
    cellGSM.connectionStatus = cell.connectionStatus.toString()

    cellGSM.bandTDSCDMA = BandTDSCDMA()
    cell.band?.let {
        cellGSM.bandTDSCDMA.channelNumber = it.channelNumber
        cellGSM.bandTDSCDMA.number = it.number!!
        cellGSM.bandTDSCDMA.name = it.name!!
        cellGSM.bandTDSCDMA.downlinkUarfcn = it.downlinkUarfcn
    }

    cellGSM.network =
        Network()
    cell.network?.let {
        cellGSM.network.iso = it.iso
        cellGSM.network.mcc = it.mcc
        cellGSM.network.mnc = it.mnc
    }

    cellGSM.signalTDSCDMA = SignalTDSCDMA()
    cell.signal.let {
        cellGSM.signalTDSCDMA.bitErrorRate = cell.signal.bitErrorRate!!
        cellGSM.signalTDSCDMA.rssi = cell.signal.rssi!!
        cellGSM.signalTDSCDMA.rscp = cell.signal.rscp!!
        cellGSM.signalTDSCDMA.rscpAsu = cell.signal.rscpAsu!!
        cellGSM.signalTDSCDMA.rssiAsu = cell.signal.rssiAsu!!
        cellGSM.signalTDSCDMA.dbm = cell.signal.dbm!!
    }

    return cellGSM
}

fun getTdscdmaFake(cell: CellTdscdma? = null): CellTDSCDMA {

    val cellGSM = CellTDSCDMA()
    cellGSM.type = "TDSCDMA"

    cellGSM.bandTDSCDMA = BandTDSCDMA()
    cellGSM.connectionStatus = "cell.connectionStatus.toString()"

    cellGSM.bandTDSCDMA = BandTDSCDMA()
    cellGSM.bandTDSCDMA.channelNumber = 0
    cellGSM.bandTDSCDMA.number = 0
    cellGSM.bandTDSCDMA.name = " it.name!!"
    cellGSM.bandTDSCDMA.downlinkUarfcn = 0

    cellGSM.network =
        Network()
    cellGSM.network.iso = ""
    cellGSM.network.mcc = ""
    cellGSM.network.mnc = ""

    cellGSM.signalTDSCDMA = SignalTDSCDMA()
    cellGSM.signalTDSCDMA.bitErrorRate = 0
    cellGSM.signalTDSCDMA.rssi = 0
    cellGSM.signalTDSCDMA.rscp = 0
    cellGSM.signalTDSCDMA.rscpAsu = 0
    cellGSM.signalTDSCDMA.rssiAsu = 0
    cellGSM.signalTDSCDMA.dbm = 0

    return cellGSM
}
