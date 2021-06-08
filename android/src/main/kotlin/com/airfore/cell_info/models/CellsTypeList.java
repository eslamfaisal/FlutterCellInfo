package com.airfore.cell_info.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CellsTypeList implements Serializable {

    private List<CellType> primaryCellList = new ArrayList<>();

    public CellsTypeList() {
    }

    public List<CellType> getPrimaryCellList() {
        return primaryCellList;
    }

    public void setPrimaryCellList(List<CellType> primaryCellList) {
        this.primaryCellList = primaryCellList;
    }
}
