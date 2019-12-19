package graphics;

import game.Cell;
import game.Table;

import java.awt.*;

public class GridRenderer {
    // длина стороны клетки в пикселях (клетка квадратная)
    public static final int CELL_SIZE = 50;
    public static final Color EDGES_COLOR = new Color(0,0,0);

    public void render(Graphics2D g, Table table) {
        for (int i = 0; i < Table.TABLE_HEIGHT; i++) {
            for (int j = 0; j < Table.TABLE_WIDTH; j++) {
                Cell cell = table.getCell(i, j);
                g.setColor(cell.getCellStatus().getColor());
                g.fillRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                g.setColor(EDGES_COLOR);
                g.drawRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
    }


}
