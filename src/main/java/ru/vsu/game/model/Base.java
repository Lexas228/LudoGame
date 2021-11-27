package ru.vsu.game.model;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Base {
    private Set<Figure> figures;
    public Base(){
        figures = new HashSet<>();
    }

    public Set<Figure> getFigures() {
        return figures;
    }

    public void setFigures(Set<Figure> figures) {
        this.figures = figures;
    }
}
