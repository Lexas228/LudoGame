package ru.vsu.game.services;

import ru.vsu.game.components.action.*;
import ru.vsu.game.model.*;
import ru.vsu.game.services.cell.CellService;
import ru.vsu.game.services.cell.SimpleCellService;
import ru.vsu.game.services.cell.StarterCellService;

import java.util.*;

public class FigureService {
    private static final Map<CellType, CellService> cellServiceMap;
    private static final Map<Action, ActionMaker> actionMakerMap;

    static{
        cellServiceMap = Map.of(
                CellType.Simple, new SimpleCellService(),
                CellType.Starter, new StarterCellService()
        );

        actionMakerMap = Map.of(
                Action.Go, new GoMaker(),
                Action.FromBase, new FromBaseMaker(),
                Action.Hit, new HitMaker(),
                Action.Jump, new JumpMaker(),
                Action.toHome, new ToHomeMaker(),
                Action.OnceMoreMove, new OnceMoreMaker()
        );
    }


    public void doMove(Move move, Game game){
        List<Action> actions = move.actions();
        actions.forEach(action -> {
            ActionMaker actionMaker = actionMakerMap.get(action);
            actionMaker.doAction(move.figure(), game, move.player());
        });
    }

    public Move getPossibleMove(Figure figure, Game game, Player player){
        if(atHome(figure, game, player)) return null;
        if(atBase(figure, game, player) && game.getDice().getMax() == game.getDice().getCurrPoints()) {
            List<Action> actions = new ArrayList<>();
            actions.add(Action.FromBase);
            return new Move(figure, actions, player);
        }
        Board board = game.getBoard();
        int points = game.getDice().getCurrPoints();
        List<Action> actions = new ArrayList<>();
        Cell curr = board.getFigureCellMap().get(figure);
        for(int i = 0; i < points; i++){
            if(curr != null) {
                curr = curr.getNextCell().get(player);
                if(curr == null){
                    if(points - i > 1) return null;
                    else actions.add(Action.toHome); //about finish
                }else { //if not finish
                    Set<Figure> fs = board.getCellFigureListMap().get(curr);
                    if (fs.isEmpty()) {
                        actions.add(Action.Go); //empty cell - just go
                    } else if (fs.size() < 2) {
                        actions.add(Action.Go); //one figure on cell - go, and if it is enemy and our last move - bit it
                        if (hasEnemy(fs, board, player) && points - i < 2) {
                            actions.add(Action.Hit);
                        }
                    } else {//if two figures
                        CellService cs = cellServiceMap.get(curr.getCellType());
                        if(cs.isBlock(curr, game)){ //look if block, we can't move at all
                            return null;
                        }else{
                            actions.add(Action.Jump); //if not - we need to jump - so jumping
                            curr = curr.getNextCell().get(player); //we skip one cell
                        }
                    }
                }
            }
        }
        return new Move(figure, actions, player);
    }


    private boolean atHome(Figure figure, Game game, Player player){
        Set<Figure> figureSet = game.getBoard().getPlayerHomeMap().get(player).getFigures();
        return figureSet.contains(figure);
    }

    private boolean hasEnemy(Set<Figure> figures, Board board, Player forWho){
        for(Figure f : figures){
            Set<Figure> fr = board.getPlayerListMap().get(forWho);
            if(!fr.contains(f)) return true;
        }
        return false;
    }

    private boolean atBase(Figure figure, Game game, Player player){
        Set<Figure> figureSet = game.getBoard().getPlayerBaseMap().get(player).getFigures();
        return figureSet.contains(figure);
    }



}
