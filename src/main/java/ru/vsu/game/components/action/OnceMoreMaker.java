package ru.vsu.game.components.action;

import ru.vsu.game.components.Mover;
import ru.vsu.game.components.MoverImpl;
import ru.vsu.game.model.Figure;
import ru.vsu.game.model.Game;
import ru.vsu.game.model.Player;

public class OnceMoreMaker extends ActionMakerAbstract{
    private final Mover mover;
    public OnceMoreMaker(){
        mover = new MoverImpl();
    }
    @Override
    public void doAction(Figure figure, Game game, Player who) {
        mover.doMove(who, game);
    }
}
