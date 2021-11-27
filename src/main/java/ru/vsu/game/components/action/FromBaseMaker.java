package ru.vsu.game.components.action;

import ru.vsu.game.components.Mover;
import ru.vsu.game.model.Cell;
import ru.vsu.game.model.Figure;
import ru.vsu.game.model.Game;
import ru.vsu.game.model.Player;


public class FromBaseMaker extends ActionMakerAbstract{

    @Override
    public void doAction(Figure figure, Game game, Player who) {
        game.getBoard().getPlayerBaseMap().get(who).getFigures().remove(figure);
        figure.setPoints(0);
        Cell c = game.getBoard().getPlayerSaveCellMap().get(who);
        game.getBoard().getFigureCellMap().put(figure, c);
    }

}
