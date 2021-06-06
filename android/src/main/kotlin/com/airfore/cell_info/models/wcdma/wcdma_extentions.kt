package com.airfore.cell_info.models.wcdma

import com.airfore.cell_info.models.common.Network
import cz.mroczis.netmonster.core.model.cell.CellWcdma

fun getWcdma(cell: CellWcdma): CellWCDMA {

    val cellGSM = CellWCDMA()
    cellGSM.type = "WCDMA"

    cellGSM.bandWCDMA = BandWCDMA()
    cellGSM.connectionStatus = cell.connectionStatus.toString()

    cellGSM.bandWCDMA = BandWCDMA()
    cell.band?.let {
        cellGSM.bandWCDMA.channelNumber = it.channelNumber
        cellGSM.bandWCDMA.number = it.number!!
        cellGSM.bandWCDMA.name = it.name!!
        cellGSM.bandWCDMA.downlinkUarfcn = it.downlinkUarfcn
    }

    cellGSM.network =
        Network()
    cell.network?.let {
        cellGSM.network.iso = it.iso
        cellGSM.network.mcc = it.mcc
        cellGSM.network.mnc = it.mnc
    }

    cellGSM.signalWCDMA = SignalWCDMA()
    cell.signal.let {
        cellGSM.signalWCDMA.bitErrorRate = cell.signal.bitErrorRate!!
        cellGSM.signalWCDMA.rssi = cell.signal.rssi!!
        cellGSM.signalWCDMA.rscp = cell.signal.rscp!!
        cellGSM.signalWCDMA.rscpAsu = cell.signal.rscpAsu!!
        cellGSM.signalWCDMA.rssiAsu = cell.signal.rssiAsu!!
        cellGSM.signalWCDMA.ecno = cell.signal.ecno!!
        cellGSM.signalWCDMA.ecio = cell.signal.ecio!!
        cellGSM.signalWCDMA.dbm = cell.signal.dbm!!
    }

    return cellGSM
}