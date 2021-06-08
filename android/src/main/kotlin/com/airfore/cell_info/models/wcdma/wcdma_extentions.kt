package com.airfore.cell_info.models.wcdma

import com.airfore.cell_info.models.common.Network
import cz.mroczis.netmonster.core.model.band.BandWcdma
import cz.mroczis.netmonster.core.model.cell.CellWcdma
import cz.mroczis.netmonster.core.model.connection.PrimaryConnection
import cz.mroczis.netmonster.core.model.signal.SignalWcdma

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


fun getWcdmaFake(
    cell: CellWcdma = CellWcdma(
        network = cz.mroczis.netmonster.core.model.Network(
            "",
            "",
            ""
        ),
        band = BandWcdma(
            downlinkUarfcn = 0,
            name = "",
            number = 0
        ),
        ci = 0,
        connectionStatus = PrimaryConnection(),
        lac = 0,
        psc = 0,
        signal = SignalWcdma(
            rssi = -100,
            bitErrorRate = 0,
            ecio = 0, ecno = 0, rscp = -100

        ),
        subscriptionId = 0
    )
): CellWCDMA {

    val cellGSM = CellWCDMA()
    cellGSM.type = "WCDMA"

    cellGSM.bandWCDMA = BandWCDMA()
    cellGSM.connectionStatus = "cell.connectionStatus.toString()"

    cellGSM.bandWCDMA = BandWCDMA()
    cell.band?.let {
        cellGSM.bandWCDMA.channelNumber = 0
        it.number?.let {
            cellGSM.bandWCDMA.number = 0
        }
        it.name?.let {
            cellGSM.bandWCDMA.name = "0"
        }
        cellGSM.bandWCDMA.downlinkUarfcn = 0
    }

    cellGSM.network =
        Network()
    cell.network?.let {
        cellGSM.network.iso = "it.iso"
        cellGSM.network.mcc = "it.mcc"
        cellGSM.network.mnc = "it.mnc"
    }

    cellGSM.signalWCDMA = SignalWCDMA()
    cell.signal.let {
        cell.signal.bitErrorRate?.let {
            cellGSM.signalWCDMA.bitErrorRate = 0
        }
        cell.signal.rssi?.let {
            cellGSM.signalWCDMA.rssi = 0
        }
        cell.signal.rscp?.let {
            cellGSM.signalWCDMA.rscp = 0
        }
        cell.signal.rscpAsu?.let {
            cellGSM.signalWCDMA.rscpAsu = 0
        }
        cell.signal.rssiAsu?.let {
            cellGSM.signalWCDMA.rssiAsu = 0
        }
        cell.signal.ecno?.let {
            cellGSM.signalWCDMA.ecno = 0
        }
        cell.signal.ecio?.let {
            cellGSM.signalWCDMA.ecio = 0
        }
        cell.signal.dbm?.let {
            cellGSM.signalWCDMA.dbm = 0
        }
    }

    return cellGSM
}