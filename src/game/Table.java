package game;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Random;

public class Table {
    public static final int TABLE_WIDTH = 30;
    public static final int TABLE_HEIGHT = 30;

    private Cell[][] table = new Cell[TABLE_HEIGHT][TABLE_WIDTH];
    private Cell[][] buffer;
    private boolean haveNextTick;

    public Table() {
        for (int i = 0; i < TABLE_HEIGHT; i++) {
            for (int j = 0; j < TABLE_WIDTH; j++) {
                table[i][j] = new Cell();
                if (new Random().nextBoolean()) {
                    table[i][j].changeStatus();
                }
            }
        }
        haveNextTick = true;
    }

    public Cell getCell(int y, int x) {
        return table[y][x];
    }

    public int checkNeighbours(int y, int x) {
        int alive = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (((y + i < TABLE_HEIGHT && y + i >= 0) && (x + j < TABLE_WIDTH && x + j >= 0))) {
                    if (buffer[y + i][x + j].getCellStatus() == CellStatus.ALIVE) {
                        alive += 1;
                    }
                }
            }
        }
        return alive;
    }

    private void copyTableToBuffer() {
        buffer = new Cell[TABLE_HEIGHT][];
        for (int i = 0; i < TABLE_HEIGHT; i++) {
            buffer[i] = Arrays.copyOf(table[i], TABLE_WIDTH);
        }
    }

    public boolean isHaveNextTick() {
        return haveNextTick;
    }

    public void tick() {
        copyTableToBuffer();
        haveNextTick = false;
        for (int i = 0; i < TABLE_HEIGHT; i++) {
            for (int j = 0; j < TABLE_WIDTH; j++) {
                haveNextTick |= getCell(i, j).checkAndChangeIfNeed(checkNeighbours(i, j));
            }
        }
    }
}
