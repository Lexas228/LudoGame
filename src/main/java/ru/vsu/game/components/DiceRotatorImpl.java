package ru.vsu.game.components;

import ru.vsu.game.model.Dice;

import java.security.SecureRandom;
import java.util.Random;

public class DiceRotatorImpl implements DiceRotator{
    private static final Random RND = new SecureRandom();
    @Override
    public void rotate(Dice dice) {
        int opt = dice.getMin()+ 1 + RND.nextInt(dice.getMax()-dice.getMin());
        dice.setCurrPoints(opt);
    }
}
