package ru.vsu.game.components.action;

import ru.vsu.game.model.*;

public class JumpMaker extends ActionMakerAbstract{
    @Override
    public void doAction(Figure figure, Game game, Player who) {
        Board board = game.getBoard();
        Cell curr = board.getFigureCellMap().get(figure);
        Cell nextNext = curr.getNextCell().get(who).getNextCell().get(who);
        board.getFigureCellMap().put(figure, nextNext);
        board.getCellFigureListMap().get(curr).remove(figure);
        minusPoints(figure);
    }

}
