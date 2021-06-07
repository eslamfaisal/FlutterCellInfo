package com.airfore.cell_info.models.lte

import com.airfore.cell_info.models.common.Network
import cz.mroczis.netmonster.core.model.cell.CellLte


fun getLte(cell: CellLte): CellLTE {
    val cellLTE = CellLTE()
    cellLTE.type = "LTE"

    cellLTE.bandwidth = cell.bandwidth
    cellLTE.connectionStatus = cell.connectionStatus.toString()

    cellLTE.bandLTE = BandLTE()
    cell.band?.let {
        cellLTE.bandLTE.channelNumber = it.channelNumber
        it.number?.let {
            cellLTE.bandLTE.number = it
        }
        cellLTE.bandLTE.downlinkEarfcn = it.downlinkEarfcn
        it.name?.let {
            cellLTE.bandLTE.name = it
        }
    }

    cellLTE.network =
        Network()
    cell.network?.let {
        cellLTE.network.iso = it.iso
        cellLTE.network.mcc = it.mcc
        cellLTE.network.mnc = it.mnc
    }

    cellLTE.signalLTE = SignalLTE()
    cell.signal.let {
        cell.signal.cqi?.let {
            cellLTE.signalLTE.cqi = it
        }
        cell.signal.rsrpAsu?.let {
            cellLTE.signalLTE.rsrpAsu = it
        }
        cell.signal.rssiAsu?.let {
            cellLTE.signalLTE.rssiAsu = it
        }
        cell.signal.snr?.let {
            cellLTE.signalLTE.snr = it
        }
        cell.signal.timingAdvance?.let {
            cellLTE.signalLTE.timingAdvance = it
        }
        cell.signal.dbm?.let {
            cellLTE.signalLTE.dbm = it
        }
        cell.signal.rssi?.let {
            cellLTE.signalLTE.rssi = it
        }
        cell.signal.rsrp?.let {
            cellLTE.signalLTE.rsrp = it
        }
    }

    cellLTE.eci = cell.eci
    cellLTE.cid = cell.cid
    cellLTE.enb = cell.enb
    cellLTE.tac = cell.tac
    cellLTE.pci = cell.pci
    cellLTE.subscriptionId = cell.subscriptionId

    return cellLTE
}