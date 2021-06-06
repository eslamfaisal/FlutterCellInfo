package com.airfore.cell_info.models.gsm

import com.airfore.cell_info.models.common.Network
import cz.mroczis.netmonster.core.model.cell.CellGsm

fun getGsm(cell: CellGsm): CellGSM {

    val cellGSM = CellGSM()
    cellGSM.type = "GSM"

    cellGSM.bandGSM = BandGSM()
    cellGSM.connectionStatus = cell.connectionStatus.toString()

    cellGSM.bandGSM = BandGSM()
    cell.band?.let {
        cellGSM.bandGSM.channelNumber = it.channelNumber
        cellGSM.bandGSM.number = it.number!!
        cellGSM.bandGSM.name = it.name!!
        cellGSM.bandGSM.arfcn = it.arfcn
    }

    cellGSM.network =
        Network()
    cell.network?.let {
        cellGSM.network.iso = it.iso
        cellGSM.network.mcc = it.mcc
        cellGSM.network.mnc = it.mnc
    }

    cellGSM.signalGSM = SignalGSM()
    cell.signal.let {
        cellGSM.signalGSM.bitErrorRate = cell.signal.bitErrorRate!!
        cellGSM.signalGSM.rssi = cell.signal.rssi!!
        cellGSM.signalGSM.timingAdvance = cell.signal.timingAdvance!!
        cellGSM.signalGSM.dbm = cell.signal.dbm!!
    }

    return cellGSM
}