package com.airfore.cell_info.models.lte

import com.airfore.cell_info.models.common.Network
import cz.mroczis.netmonster.core.model.cell.CellLte


fun getLte(cell: CellLte): CellLTE{
    val cellLTE = CellLTE()
    cellLTE.type = "LTE"

    cellLTE.bandwidth = cell.bandwidth
    cellLTE.connectionStatus = cell.connectionStatus.toString()

    cellLTE.bandLTE = BandLTE()
    cell.band?.let {
        cellLTE.bandLTE.channelNumber = it.channelNumber
        cellLTE.bandLTE.number = it.number!!
        cellLTE.bandLTE.downlinkEarfcn = it.downlinkEarfcn
        cellLTE.bandLTE.name = it.name!!
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
        cellLTE.signalLTE.cqi = cell.signal.cqi!!
        cellLTE.signalLTE.rsrpAsu = cell.signal.rsrpAsu!!
        cellLTE.signalLTE.rssiAsu = cell.signal.rssiAsu!!
        cellLTE.signalLTE.snr = cell.signal.snr!!
        cellLTE.signalLTE.timingAdvance = cell.signal.timingAdvance!!
        cellLTE.signalLTE.dbm = cell.signal.dbm!!
        cellLTE.signalLTE.rssi = cell.signal.rssi!!
        cellLTE.signalLTE.rsrp = cell.signal.rsrp!!
    }

    cellLTE.eci = cell.eci
    cellLTE.cid = cell.cid
    cellLTE.enb = cell.enb
    cellLTE.tac = cell.tac
    cellLTE.pci = cell.pci
    cellLTE.subscriptionId = cell.subscriptionId

    return cellLTE
}