package ru.vsu.game.services;

import ru.vsu.game.components.Mover;
import ru.vsu.game.components.MoverImpl;
import ru.vsu.game.model.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GameService {
    private static final BoardService boardService = new BoardService();
    private static final Mover mover = new MoverImpl();

    public Game createGame(List<Player> playerList){
        Game g = new Game();
        Queue<Player> players = new LinkedList<>(playerList);
        Board b = boardService.createBoard(players);
        g.setPlayers(players);
        g.setBoard(b);
        g.setDice(new Dice(1, 6));
        g.setMoveList(new ArrayList<>());
        g.setGameStatus(GameStatus.Ok);
        return g;
    }

    public void playGame(Game game, int numOfMovers){
        int count = 0;
        while(game.getGameStatus() == GameStatus.Ok && count < numOfMovers){
            Player curr = game.getPlayers().poll();
            mover.doMove(curr, game);
            game.getPlayers().add(curr);
            count++;
        }
    }
}
