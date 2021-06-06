package com.airfore.cell_info.models.wcdma;

import com.airfore.cell_info.models.common.Band;

import java.io.Serializable;

public class BandWCDMA extends Band implements Serializable {

    private int downlinkUarfcn;

    public BandWCDMA() {
    }

    public int getDownlinkUarfcn() {
        return downlinkUarfcn;
    }

    public void setDownlinkUarfcn(int downlinkUarfcn) {
        this.downlinkUarfcn = downlinkUarfcn;
    }
    
}
