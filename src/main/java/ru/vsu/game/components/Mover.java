package ru.vsu.game.components;

import ru.vsu.game.model.Game;
import ru.vsu.game.model.Player;

public interface Mover {
    void doMove(Player player, Game game);
}
