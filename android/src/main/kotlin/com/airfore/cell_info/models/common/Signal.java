package com.airfore.cell_info.models.common;

import java.io.Serializable;

public class Signal implements Serializable {

    private int dbm;

    public Signal() {
    }

    public int getDbm() {
        return dbm;
    }

    public void setDbm(int dbm) {
        this.dbm = dbm;
    }
}
