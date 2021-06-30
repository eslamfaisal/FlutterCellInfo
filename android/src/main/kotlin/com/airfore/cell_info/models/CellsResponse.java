package com.airfore.cell_info.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class CellsResponse implements Serializable {


    private List<CellType> primaryCellList  = new ArrayList<>();
    private List<CellType> neighboringCellList  = new ArrayList<>();
    private List<CellData> cellDataList  = new ArrayList<>();


    public CellsResponse() {
    }

    public List<CellType> getPrimaryCellList() {
        return primaryCellList;
    }

    public void setPrimaryCellList(List<CellType> primaryCellList) {
        this.primaryCellList = primaryCellList;
    }

    public List<CellType> getNeighboringCellList() {
        return neighboringCellList;
    }

    public void setNeighboringCellList(List<CellType> neighboringCellList) {
        this.neighboringCellList = neighboringCellList;
    }

    public List<CellData> getCellDataList() {
        return cellDataList;
    }

    public void setCellDataList(List<CellData> cellDataList) {
        this.cellDataList = cellDataList;
    }
}
