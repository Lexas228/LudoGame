package ru.vsu.game.components.action;

import ru.vsu.game.model.Figure;
import ru.vsu.game.model.Game;
import ru.vsu.game.model.Player;

public abstract class ActionMakerAbstract implements ActionMaker{

    protected Player getOwner(Figure figure, Game game){
        for(var l : game.getBoard().getPlayerListMap().entrySet()){
            if(l.getValue().contains(figure)) return l.getKey();
        }
        return null;
    }
    protected void minusPoints(Figure figure){
        if(figure.getPoints() > 0) figure.setPoints(figure.getPoints()-1);
    }
}
