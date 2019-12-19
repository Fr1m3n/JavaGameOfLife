package game;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Random;

public class Table {
    public static final int TABLE_WIDTH = 10;
    public static final int TABLE_HEIGHT = 10;

    private Cell[][] table = new Cell[TABLE_HEIGHT][TABLE_WIDTH];
    private Cell[][] buffer;

    public Table() {
        for (int i = 0; i < TABLE_HEIGHT; i++) {
            for (int j = 0; j < TABLE_WIDTH; j++) {
                table[i][j] = new Cell();
                if (new Random().nextBoolean()) {
                    table[i][j].changeStatus();
                }
            }
        }
    }

    public Cell getCell(int y, int x) {
        return table[y][x];
    }

    public Pair<Integer, Integer> checkNeighbours(int y, int x) {
        int alive = 0;
        int dead = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == j && i == 0) {
                    continue;
                }
                if (((y + i < TABLE_HEIGHT && y + i >= 0) && (x + j < TABLE_WIDTH && x + j >= 0))) {
                    if (buffer[y + i][x + j].getCellStatus() == CellStatus.ALIVE) {
                        alive += 1;
                    } else {
                        dead += 1;
                    }
                }
            }
        }
        return new Pair<>(alive, dead);
    }

    private void copyTableToBuffer() {
        buffer = new Cell[TABLE_HEIGHT][];
        for (int i = 0; i < TABLE_HEIGHT; i++) {
            buffer[i] = Arrays.copyOf(table[i], TABLE_WIDTH);
        }
    }

    public void tick() {
        copyTableToBuffer();
        for (int i = 0; i < TABLE_HEIGHT; i++) {
            for (int j = 0; j < TABLE_WIDTH; j++) {
                getCell(i, j).checkAndChangeIfNeed(checkNeighbours(i, j));
            }
        }
    }
}
