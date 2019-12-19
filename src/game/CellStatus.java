package game;

import javafx.util.Pair;

import java.awt.*;

public enum CellStatus {
    DEAD(new Color(255, 255, 255)) {
        @Override
        public boolean check(int aliveNeighbours) {
            return aliveNeighbours == 3;
        }
    },
    ALIVE(new Color(189, 127, 83)) {
        @Override
        public boolean check(int aliveNeighbours) {
            return aliveNeighbours < 2 || aliveNeighbours > 3;
        }
    };

    Color color;

    CellStatus(Color c) {
        this.color = c;
    }

    public Color getColor() {
        return color;
    }

    public boolean check(int aliveNeighbours) {
        return true;
    }

    public CellStatus opposite() {
        return this == DEAD ? ALIVE : DEAD;
    }
}
