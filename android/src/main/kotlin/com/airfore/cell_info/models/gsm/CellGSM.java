package com.airfore.cell_info.models.gsm;


import com.airfore.cell_info.models.common.Cell;

import java.io.Serializable;

public class CellGSM extends Cell implements Serializable {

    private Integer cid;
    private Integer lac;
    private Integer bsic;
    private Integer ncc;
    private Integer bcc;
    private Integer cgi;
    private BandGSM bandGSM;
    private SignalGSM signalGSM;


    public CellGSM() {
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getLac() {
        return lac;
    }

    public void setLac(Integer lac) {
        this.lac = lac;
    }

    public Integer getBsic() {
        return bsic;
    }

    public void setBsic(Integer bsic) {
        this.bsic = bsic;
    }

    public Integer getNcc() {
        return ncc;
    }

    public void setNcc(Integer ncc) {
        this.ncc = ncc;
    }

    public Integer getBcc() {
        return bcc;
    }

    public void setBcc(Integer bcc) {
        this.bcc = bcc;
    }

    public Integer getCgi() {
        return cgi;
    }

    public void setCgi(Integer cgi) {
        this.cgi = cgi;
    }

    public BandGSM getBandGSM() {
        return bandGSM;
    }

    public void setBandGSM(BandGSM bandGSM) {
        this.bandGSM = bandGSM;
    }

    public SignalGSM getSignalGSM() {
        return signalGSM;
    }

    public void setSignalGSM(SignalGSM signalGSM) {
        this.signalGSM = signalGSM;
    }
}

