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
        it.number?.let {
            cellGSM.bandGSM.number = it
        }
        it.name?.let {
            cellGSM.bandGSM.name = it
        }
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
        cell.signal.bitErrorRate?.let {
            cellGSM.signalGSM.bitErrorRate = it
        }
        cell.signal.rssi?.let {
            cellGSM.signalGSM.rssi = it
        }
        cell.signal.timingAdvance?.let {
            cellGSM.signalGSM.timingAdvance = it
        }
        cell.signal.dbm?.let {
            cellGSM.signalGSM.dbm = it
        }
    }

    return cellGSM
}