package ru.vsu.game.components.action;

import ru.vsu.game.model.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class GoMaker extends ActionMakerAbstract{

    @Override
    public void doAction(Figure figure, Game game, Player who) {
        Board b = game.getBoard();
        Map<Figure, Cell> figureCellMap = b.getFigureCellMap();
        Map<Cell, Set<Figure>> cellListMap = b.getCellFigureListMap();
        Cell from = figureCellMap.get(figure);
        Cell next = from.getNextCell().get(who);
        cellListMap.get(from).remove(figure);
        figureCellMap.put(figure, next);
        cellListMap.get(next).add(figure);
        minusPoints(figure);

    }
}
