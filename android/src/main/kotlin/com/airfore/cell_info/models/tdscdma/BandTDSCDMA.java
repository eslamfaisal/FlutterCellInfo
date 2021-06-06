package com.airfore.cell_info.models.tdscdma;

import com.airfore.cell_info.models.common.Band;

import java.io.Serializable;

public class BandTDSCDMA extends Band implements Serializable {

    private int downlinkUarfcn;

    public BandTDSCDMA() {
    }

    public int getDownlinkUarfcn() {
        return downlinkUarfcn;
    }

    public void setDownlinkUarfcn(int downlinkUarfcn) {
        this.downlinkUarfcn = downlinkUarfcn;
    }
    
}
