package ru.vsu.game.services;

import ru.vsu.game.model.Figure;
import ru.vsu.game.model.Game;
import ru.vsu.game.model.Move;
import ru.vsu.game.model.Player;

public interface PlayerService {
    Move createMove(Player player, Game game);
    void doMove(Game game, Move move);
    boolean isValidMove(Move move);
}
