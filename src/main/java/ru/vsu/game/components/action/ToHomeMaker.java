package ru.vsu.game.components.action;

import ru.vsu.game.model.*;

public class ToHomeMaker extends ActionMakerAbstract{
    @Override
    public void doAction(Figure figure, Game game, Player who) {
        Board b = game.getBoard();
        Cell from = b.getFigureCellMap().get(figure);
        b.getPlayerBaseMap().get(who).getFigures().add(figure);
        b.getCellFigureListMap().get(from).remove(figure);
        b.getFigureCellMap().put(figure, null);
    }
}
