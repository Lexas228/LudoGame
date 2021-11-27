package ru.vsu.game;

import ru.vsu.game.model.Board;
import ru.vsu.game.model.Cell;
import ru.vsu.game.model.Player;
import ru.vsu.game.model.PlayerType;
import ru.vsu.game.services.BoardService;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class BoardServiceTest {
    private static final BoardService boardService = new BoardService();

    public static void main(String[] args){
        Queue<Player> players = new LinkedList<>();
        for(int i = 0; i < 4; i++){
            players.add(new Player(PlayerType.Bot, "ha"+i));
        }
        Board b = boardService.createBoard(players);
        boolean checkNum = numOfCellsCheck(b, 89);
        System.out.println(checkNum);
    }

    private static boolean numOfCellsCheck(Board board, int num){
        int count = 0;
        for(Cell c : board.getCellFigureListMap().keySet()){
            count++;
        }
        System.out.println(count);
        return num==count;
    }

}
