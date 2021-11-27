package ru.vsu.game.components.action;

import ru.vsu.game.model.Figure;
import ru.vsu.game.model.Game;
import ru.vsu.game.model.Player;

public interface ActionMaker {
    void doAction(Figure figure, Game game, Player who);
}
