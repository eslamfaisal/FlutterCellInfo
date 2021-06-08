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

fun getLteFake(cell: CellLte? = null): CellLTE {

    val cellLTE = CellLTE()
    cellLTE.type = "LTE"

    cellLTE.bandwidth = 0
    cellLTE.connectionStatus = " cell.connectionStatus.toString()"

    cellLTE.bandLTE = BandLTE()
    cellLTE.bandLTE.channelNumber = 0
    cellLTE.bandLTE.number = 0
    cellLTE.bandLTE.name = ""
    cellLTE.bandLTE.downlinkEarfcn = 0


    cellLTE.network =
        Network()

    cellLTE.network.iso = ""
    cellLTE.network.mcc = "it.mcc"
    cellLTE.network.mnc = ""

    cellLTE.signalLTE = SignalLTE()
    cellLTE.signalLTE.cqi = 0
    cellLTE.signalLTE.rsrpAsu = 0
    cellLTE.signalLTE.rssiAsu = 0
    cellLTE.signalLTE.snr = 0.0
    cellLTE.signalLTE.timingAdvance = 0
    cellLTE.signalLTE.dbm = 0
    cellLTE.signalLTE.rssi = 0
    cellLTE.signalLTE.rsrp = 0.0


    cellLTE.eci = 0
    cellLTE.cid = 0
    cellLTE.enb = 0
    cellLTE.tac = 0
    cellLTE.pci = 0
    cellLTE.subscriptionId = 0

    return cellLTE
}