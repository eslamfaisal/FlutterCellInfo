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

fun getNrFake(cell: CellNr? = null): CellNR {

    val cellNR = CellNR()
    cellNR.type = "NR"

    cellNR.nci = 0
    cellNR.pci = 0
    cellNR.tac = 0
    cellNR.connectionStatus = " cell.connectionStatus.toString()"

    cellNR.bandNR = BandNR()

    cellNR.bandNR.channelNumber = 0
    cellNR.bandNR.number = 0
    cellNR.bandNR.downlinkArfcn = 0
    cellNR.bandNR.downlinkFrequency = 0
    cellNR.bandNR.name = "it.name!!"

    cellNR.network =
        Network()
    cellNR.network.iso = "0"
    cellNR.network.mcc = "0"
    cellNR.network.mnc = "0"

    cellNR.signalNR = SignalNR()
    cellNR.signalNR.csiRsrp = 0
    cellNR.signalNR.csiRsrpAsu = 0
    cellNR.signalNR.csiRsrq = 0
    cellNR.signalNR.csiSinr = 0
    cellNR.signalNR.ssRsrq = 0
    cellNR.signalNR.dbm = 0
    cellNR.signalNR.ssRsrp = 0
    cellNR.signalNR.ssRsrpAsu = 0

    return cellNR
}
