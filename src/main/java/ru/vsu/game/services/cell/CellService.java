package ru.vsu.game.services.cell;

import ru.vsu.game.model.Cell;
import ru.vsu.game.model.Game;

public interface CellService {
    boolean isBlock(Cell cell, Game game);
}
