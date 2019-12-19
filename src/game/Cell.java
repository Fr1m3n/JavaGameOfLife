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

    public boolean checkAndChangeIfNeed(int aliveNeighbours) {
        if (cellStatus.check(aliveNeighbours)) {
            changeStatus();
            return true;
        }
        return false;
    }

    public void changeStatus() {
        cellStatus = cellStatus.opposite();
    }
}
