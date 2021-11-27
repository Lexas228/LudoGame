package ru.vsu.game.model;

import ru.vsu.game.services.BotService;
import ru.vsu.game.services.PlayerService;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Game {
    private Queue<Player> players;
    private GameStatus gameStatus;
    private Dice dice;
    private Board board;
    private List<Move> moveList;

    public Queue<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Queue<Player> players) {
        this.players = players;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMoveList() {
        return moveList;
    }

    public void setMoveList(List<Move> moveList) {
        this.moveList = moveList;
    }
}
