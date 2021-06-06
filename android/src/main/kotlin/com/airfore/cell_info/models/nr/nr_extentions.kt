package com.airfore.cell_info.models.nr

import com.airfore.cell_info.models.common.Network
import cz.mroczis.netmonster.core.model.cell.CellNr

fun getNr(cell: CellNr): CellNR {

    val cellNR = CellNR()
    cellNR.type = "NR"

    cellNR.nci = cell.nci
    cellNR.pci = cell.pci
    cellNR.tac = cell.tac
    cellNR.connectionStatus = cell.connectionStatus.toString()

    cellNR.bandNR = BandNR()
    cell.band?.let {
        cellNR.bandNR.channelNumber = it.channelNumber
        cellNR.bandNR.number = it.number!!
        cellNR.bandNR.downlinkArfcn = it.downlinkArfcn
        cellNR.bandNR.downlinkFrequency = it.downlinkFrequency
        cellNR.bandNR.name = it.name!!
    }

    cellNR.network =
        Network()
    cell.network?.let {
        cellNR.network.iso = it.iso
        cellNR.network.mcc = it.mcc
        cellNR.network.mnc = it.mnc
    }

    cellNR.signalNR = SignalNR()
    cell.signal.let {
        cellNR.signalNR.csiRsrp = cell.signal.csiRsrp!!
        cellNR.signalNR.csiRsrpAsu = cell.signal.csiRsrpAsu!!
        cellNR.signalNR.csiRsrq = cell.signal.csiRsrq!!
        cellNR.signalNR.csiSinr = cell.signal.csiSinr!!
        cellNR.signalNR.ssRsrq = cell.signal.ssRsrp!!
        cellNR.signalNR.dbm = cell.signal.dbm!!
        cellNR.signalNR.ssRsrp = cell.signal.ssRsrp
        cellNR.signalNR.ssRsrpAsu = cell.signal.ssRsrpAsu!!
    }

    return cellNR
}