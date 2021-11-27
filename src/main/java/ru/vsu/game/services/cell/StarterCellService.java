package ru.vsu.game.services.cell;

import ru.vsu.game.model.*;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class StarterCellService extends AbstractCellService {

    @Override
    public boolean isBlock(Cell cell, Game game) {
        return isBlock(((player, player2) -> player != player2), game, cell);
    }

}
