package ru.vsu.game.services;

import ru.vsu.game.model.*;

import java.util.*;

public class BoardService {

    public Board createBoard(Queue<Player> players){
        Board board = new Board();
        Map<Player, Home> playerHomeMap = new HashMap<>();
        Map<Player, Base> playerBaseMap = new HashMap<>();
        Map<Player, Set<Figure>> playerSetMap = new HashMap<>();
        Map<Figure, Cell> figureCellMap = new HashMap<>();
        players.forEach(player -> {
            Home home = new Home();
            Base base = new Base();
            playerHomeMap.put(player, home);
            playerBaseMap.put(player, base);
            Set<Figure> playerFigures = new HashSet<>();
            for(int i = 0; i < 4; i++){
                Figure f = new Figure();
                figureCellMap.put(f, null);
                playerFigures.add(f);
                base.getFigures().add(f);
            }
            playerSetMap.put(player, playerFigures);
        });
        board.setFigureCellMap(figureCellMap);
        board.setPlayerBaseMap(playerBaseMap);
        board.setPlayerListMap(playerSetMap);
        board.setPlayerHomeMap(playerHomeMap);
        setField(board, players);
        return board;
    }
    private void setField(Board board, Queue<Player> players) {
        Map<Cell, Set<Figure>> cellSetMap = new HashMap<>();
        Map<Player, Cell> saveCellPlayer = new HashMap<>();
        Cell[] cells = new Cell[68];
        cells[0] = new Cell(CellType.Simple);
        cellSetMap.put(cells[0], new HashSet<>());
        for (int i = 1; i < 68; i++) {
            Cell curr = new Cell(CellType.Simple);
            cells[i] = curr;
            for(Player p : players){
                cells[i-1].getNextCell().put(p, curr);
            }
            cellSetMap.put(curr, new HashSet<>());
        }
        for(Player p : players){
            cells[cells.length-1].getNextCell().put(p, cells[0]);
        }

        for(int i = 16, k = 4; i < 68 || k < 68; i+=17, k+=17){
            Player p = players.poll();
            Cell save = cells[k];
            save.setCellType(CellType.Starter);
            saveCellPlayer.put(p, save);
            if(i < 68) {
                Cell pr = cells[i];
                for (int j = 0; j < 7; j++) {
                    Cell c = new Cell(CellType.Simple);
                    pr.getNextCell().put(players.peek(), c);
                    pr = c;
                    cellSetMap.put(c, new HashSet<>());
                }
                pr.getNextCell().put(players.peek(), null);
            }
            players.add(p);
        }
        board.setPlayerSaveCellMap(saveCellPlayer);
        board.setCellFigureListMap(cellSetMap);
    }

}
