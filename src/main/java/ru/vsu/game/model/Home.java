package ru.vsu.game.model;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Home {
    private Set<Figure> figures;
    public Home(){
        figures = new HashSet<>();
    }

    public Set<Figure> getFigures() {
        return figures;
    }

    public void setFigures(Set<Figure> figures) {
        this.figures = figures;
    }
}
