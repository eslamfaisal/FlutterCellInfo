package com.airfore.cell_info.models.cdma

import com.airfore.cell_info.models.common.Band
import com.airfore.cell_info.models.common.Network
import cz.mroczis.netmonster.core.model.cell.CellCdma

fun getCdma(cell: CellCdma): CellCDMA {

    val cellCDMA = CellCDMA()
    cellCDMA.type = "CDMA"

    cellCDMA.bid = cell.bid
    cellCDMA.connectionStatus = cell.connectionStatus.toString()

    cellCDMA.band = Band()
    cell.band?.let {
        cellCDMA.band.channelNumber = it.channelNumber
        cellCDMA.band.number = it.number!!
        cellCDMA.band.name = it.name!!
    }

    cellCDMA.network =
        Network()
    cell.network?.let {
        cellCDMA.network.iso = it.iso
        cellCDMA.network.mcc = it.mcc
        cellCDMA.network.mnc = it.mnc
    }

    cellCDMA.signalCDMA = SignalCDMA()
    cell.signal.let {
        cellCDMA.signalCDMA.cdmaEcio = cell.signal.cdmaEcio!!
        cellCDMA.signalCDMA.cdmaRssi = cell.signal.cdmaRssi!!
        cellCDMA.signalCDMA.evdoRssi = cell.signal.evdoRssi!!
        cellCDMA.signalCDMA.evdoSnr = cell.signal.evdoSnr!!
        cellCDMA.signalCDMA.evdoEcio = cell.signal.evdoEcio!!
        cellCDMA.signalCDMA.dbm = cell.signal.dbm!!
    }

    return cellCDMA
}