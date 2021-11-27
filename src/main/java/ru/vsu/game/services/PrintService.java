package ru.vsu.game.services;

import ru.vsu.game.model.*;

import java.util.LinkedList;
import java.util.Set;

public class PrintService {
    public void print(Game game){
        System.out.println("Game status: " + game.getGameStatus());
        Board b = game.getBoard();
        game.getPlayers().forEach(player -> {
            System.out.println("Player: " + player.name());
            System.out.println("At base: " + b.getPlayerBaseMap().get(player).getFigures().size());
            System.out.println("At home: " + b.getPlayerHomeMap().get(player).getFigures().size());
            Cell start = b.getPlayerSaveCellMap().get(player);
            while(start != null){
                Set<Figure> figureSet = b.getCellFigureListMap().get(start);
                System.out.print("|");
                figureSet.forEach(figure -> System.out.print("o"));
                System.out.print("| ");
                start = start.getNextCell().get(player);
            }
            System.out.println();
            System.out.println("Last actions: ");
            LinkedList<Move> ls = new LinkedList<>();
            int k = game.getMoveList().size()-1;
            while(k >= 0 && game.getMoveList().get(k).player() == player){
                ls.addFirst(game.getMoveList().get(k));
                k--;
            }
            for(Move m : ls){
                System.out.print(m.actions());
                System.out.println();
            }
            System.out.println();
            System.out.println("-----------------------");
        });
    }
}
