package ru.vsu.game.components.action;

import ru.vsu.game.model.*;

import java.util.Set;

public class HitMaker extends ActionMakerAbstract{

    @Override
    public void doAction(Figure figure, Game game, Player who) {
        Cell curr = game.getBoard().getFigureCellMap().get(figure);
        FigureInfo enemyFigureInfo = getEnemyFigure(who, game, curr);
        Board b = game.getBoard();
        if(enemyFigureInfo != null){
            b.getPlayerBaseMap().get(enemyFigureInfo.owner()).getFigures().add(enemyFigureInfo.figure());
            b.getCellFigureListMap().get(curr).remove(enemyFigureInfo.figure());
            b.getFigureCellMap().put(enemyFigureInfo.figure(), null);
        }

    }

    private FigureInfo getEnemyFigure(Player forWho, Game game, Cell cell){
        Set<Figure> figures = game.getBoard().getCellFigureListMap().get(cell);
        for(Figure f : figures){
            Player pl = getOwner(f, game);
            if(pl != forWho)return new FigureInfo(f, pl);
        }
        return null;
    }


}
