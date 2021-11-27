package ru.vsu.game.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Board {
    private Map<Figure, Cell> figureCellMap;
    private Map<Cell, Set<Figure>> cellFigureListMap;
    private Map<Player, Home> playerHomeMap;
    private Map<Player, Base> playerBaseMap;
    private Map<Player, Set<Figure>> playerListMap;
    private Map<Player, Cell> playerSaveCellMap;

    public Map<Player, Cell> getPlayerSaveCellMap() {
        return playerSaveCellMap;
    }

    public void setPlayerSaveCellMap(Map<Player, Cell> playerSaveCellMap) {
        this.playerSaveCellMap = playerSaveCellMap;
    }

    public Map<Player, Base> getPlayerBaseMap() {
        return playerBaseMap;
    }

    public void setPlayerBaseMap(Map<Player, Base> playerBaseMap) {
        this.playerBaseMap = playerBaseMap;
    }

    public Map<Player, Set<Figure>> getPlayerListMap() {
        return playerListMap;
    }

    public void setPlayerListMap(Map<Player, Set<Figure>> playerListMap) {
        this.playerListMap = playerListMap;
    }

    public Map<Figure, Cell> getFigureCellMap() {
        return figureCellMap;
    }

    public void setFigureCellMap(Map<Figure, Cell> figureCellMap) {
        this.figureCellMap = figureCellMap;
    }

    public Map<Cell, Set<Figure>> getCellFigureListMap() {
        return cellFigureListMap;
    }

    public void setCellFigureListMap(Map<Cell, Set<Figure>> cellFigureListMap) {
        this.cellFigureListMap = cellFigureListMap;
    }

    public Map<Player, Home> getPlayerHomeMap() {
        return playerHomeMap;
    }

    public void setPlayerHomeMap(Map<Player, Home> playerHomeMap) {
        this.playerHomeMap = playerHomeMap;
    }
}
