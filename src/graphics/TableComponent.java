package graphics;

import game.Table;

import javax.swing.*;
import java.awt.*;

public class TableComponent extends JComponent {
    private Table table;

    public TableComponent() {
        table = new Table();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        new GridRenderer().render(g, table);
    }

    public Table getTable() {
        return table;
    }
}
