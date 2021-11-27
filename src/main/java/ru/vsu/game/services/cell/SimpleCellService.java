package ru.vsu.game.services.cell;

import ru.vsu.game.model.Cell;
import ru.vsu.game.model.Game;

public class SimpleCellService extends AbstractCellService {
    @Override
    public boolean isBlock(Cell cell, Game game) {
        return isBlock(((player, player2) -> player == player2), game, cell);
    }
}
