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