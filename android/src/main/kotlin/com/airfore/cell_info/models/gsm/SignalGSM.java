package com.airfore.cell_info.models.gsm;

import com.airfore.cell_info.models.common.Signal;

import java.io.Serializable;

public class SignalGSM extends Signal implements Serializable {

    private int rssi;
    private int bitErrorRate;
    private int timingAdvance;


    public SignalGSM() {
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public int getBitErrorRate() {
        return bitErrorRate;
    }

    public void setBitErrorRate(int bitErrorRate) {
        this.bitErrorRate = bitErrorRate;
    }

    public int getTimingAdvance() {
        return timingAdvance;
    }

    public void setTimingAdvance(int timingAdvance) {
        this.timingAdvance = timingAdvance;
    }
}
