package ru.vsu.game.model;

import java.util.List;

public record Move(Figure figure, List<Action> actions, Player player) {

}
