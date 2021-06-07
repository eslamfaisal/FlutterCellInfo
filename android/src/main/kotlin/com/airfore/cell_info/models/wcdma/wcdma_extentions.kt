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
        it.number?.let {
            cellGSM.bandWCDMA.number = it
        }
        it.name?.let {
            cellGSM.bandWCDMA.name = it
        }
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
        cell.signal.bitErrorRate?.let {
            cellGSM.signalWCDMA.bitErrorRate = it
        }
        cell.signal.rssi?.let {
            cellGSM.signalWCDMA.rssi = it
        }
        cell.signal.rscp?.let {
            cellGSM.signalWCDMA.rscp = it
        }
        cell.signal.rscpAsu?.let {
            cellGSM.signalWCDMA.rscpAsu = it
        }
        cell.signal.rssiAsu?.let {
            cellGSM.signalWCDMA.rssiAsu = it
        }
        cell.signal.ecno?.let {
            cellGSM.signalWCDMA.ecno = it
        }
        cell.signal.ecio?.let {
            cellGSM.signalWCDMA.ecio = it
        }
        cell.signal.dbm?.let {
            cellGSM.signalWCDMA.dbm = it
        }
    }

    return cellGSM
}