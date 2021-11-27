package ru.vsu.game.model;

public class Dice {
    private final int min;
    private final int max;
    private int currPoints;

    public Dice(int min, int max){
        currPoints = min;
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getCurrPoints() {
        return currPoints;
    }

    public void setCurrPoints(int currPoints) {
        if(currPoints >= min && currPoints <= max)
        this.currPoints = currPoints;
    }
}
