package ru.vsu.game.components;


import ru.vsu.game.model.*;
import ru.vsu.game.services.BotService;
import ru.vsu.game.services.PlayerService;
import ru.vsu.game.services.PrintService;

import java.util.List;
import java.util.Map;

public class MoverImpl implements Mover {
    private final Map<PlayerType, PlayerService> playerServiceMap;
    public static final PrintService printService = new PrintService();
    public MoverImpl(){
        playerServiceMap = Map.of(PlayerType.Bot, new BotService());
    }

    @Override
    public void doMove(Player player, Game game) {
        PlayerService pl = playerServiceMap.get(player.playerType());
        Move m = pl.createMove(player, game);
        if(pl.isValidMove(m)){
            Figure f = m.figure();
            f.setPoints(game.getDice().getCurrPoints());
            List<Action> actionList = m.actions();
            Action lastAction = actionList.get(actionList.size()-1);
            if(lastAction == Action.FromBase || lastAction == Action.Hit || lastAction == Action.toHome)
                actionList.add(Action.OnceMoreMove);
            game.getMoveList().add(m);
            pl.doMove(game, m);
            if(lastAction == Action.toHome){
                Home h = game.getBoard().getPlayerHomeMap().get(player);
                if(h.getFigures().size() >= 4) game.setGameStatus(GameStatus.End);
            }

        }
    }
}
