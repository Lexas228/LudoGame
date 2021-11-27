package ru.vsu.game;

import ru.vsu.game.model.*;
import ru.vsu.game.services.GameService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameServiceTest {
    private static final GameService gameService = new GameService();

    public static void main(String[] args){
        List<Player> playerList = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            playerList.add(new Player(PlayerType.Bot, "ja"+i));
        }
        Game game = gameService.createGame(playerList);
        gameService.playGame(game, 150);
        System.out.println("size: " + game.getPlayers().size());
        Map<Player, List<Move>> playerListMap = new HashMap<>();
        for(Player p : playerList){
          playerListMap.put(p, new ArrayList<>());
        }
        for(Move m : game.getMoveList()){
            playerListMap.get(m.player()).add(m);
        }

        for(var l : playerListMap.entrySet()){
            System.out.print(l.getKey().hashCode() + ": " );
            for(Move m : l.getValue()){
                for(Action act : m.actions()){
                    System.out.print(act + ", ");
                }
            }
            System.out.println("; ");
        }
    }
}
