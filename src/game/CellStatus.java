package game;

import javafx.util.Pair;

import java.awt.*;

public enum CellStatus {
    DEAD(new Color(255, 255, 255)) {
        @Override
        public boolean check(Pair<Integer, Integer> neighbours) {
            return neighbours.getKey() == 3;
        }
    },
    ALIVE(new Color(0,0,0)) {
        @Override
        public boolean check(Pair<Integer, Integer> neighbours) {
            return neighbours.getValue() < 2 || neighbours.getValue() > 3;
        }
    };

    Color color;

    CellStatus(Color c) {
        this.color = c;
    }

    public Color getColor() {
        return color;
    }

    public boolean check(Pair<Integer, Integer> neighbours) {
        return true;
    }

    public CellStatus opposite() {
        return this == DEAD ? ALIVE : DEAD;
    }
}
