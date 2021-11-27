package ru.vsu.game.services.cell;

import ru.vsu.game.model.*;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public abstract class AbstractCellService implements CellService{

    protected boolean isBlock(BiPredicate<Player, Player> check, Game game, Cell cell){
        Board b = game.getBoard();
        Set<Figure> figures = b.getCellFigureListMap().get(cell);
        Player p = null;
        for(Figure f : figures){
            Optional<Player> s = b.getPlayerListMap().entrySet().stream()
                    .filter(entry-> entry.getValue().contains(f))
                    .map(Map.Entry::getKey).findFirst();
            if(s.isPresent()){
                Player pl = s.get();
                if(p == null){
                    p = pl;
                }else{
                    return check.test(p, pl);
                }
            }
        }
        return true;

    }
}
