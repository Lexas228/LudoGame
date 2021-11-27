package ru.vsu.game.services;

import ru.vsu.game.components.DiceRotator;
import ru.vsu.game.components.DiceRotatorImpl;
import ru.vsu.game.model.*;
import java.util.Set;

import static ru.vsu.game.components.MoverImpl.printService;

public class BotService implements PlayerService {
    private static final DiceRotator diceRotator = new DiceRotatorImpl();
    private static final FigureService figureService = new FigureService();


    @Override
    public Move createMove(Player player, Game game) {
        diceRotator.rotate(game.getDice());
        Set<Figure> figures = game.getBoard().getPlayerListMap().get(player);
        for(Figure f : figures){
            Move move = figureService.getPossibleMove(f, game, player);
            if(move != null && !move.actions().isEmpty()){
                return move;
            }
        }
        return null;
    }

    @Override
    public void doMove(Game game, Move move) {
        if(isValidMove(move)){
            printService.print(game);
            figureService.doMove(move, game);
        }
    }

    @Override
    public boolean isValidMove(Move move) {
        return move != null;
    }

}
