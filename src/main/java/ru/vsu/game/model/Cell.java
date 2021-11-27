package ru.vsu.game.model;

import java.util.HashMap;
import java.util.Map;

public class Cell {
    private Map<Player, Cell> nextCell;
    private CellType cellType;

    public Cell(CellType cellType){
        this.cellType = cellType;
        this.nextCell = new HashMap<>();
    }

    public Map<Player, Cell> getNextCell() {
        return nextCell;
    }

    public void setNextCell(Map<Player, Cell> nextCell) {
        this.nextCell = nextCell;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }
}
