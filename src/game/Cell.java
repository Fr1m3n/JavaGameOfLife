package game;

import javafx.util.Pair;

public class Cell {

    private CellStatus cellStatus;

    public Cell() {
        this.cellStatus = CellStatus.DEAD;
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }

    public void checkAndChangeIfNeed(Pair<Integer, Integer> neighbors) {
        if (cellStatus.check(neighbors)) {
            changeStatus();
        }
    }

    public void changeStatus() {
        cellStatus = cellStatus.opposite();
    }
}
