package graphics;

import game.Table;

import javax.swing.*;
import java.awt.*;

public class MainForm {

    public static final int TICK_INTERVAL = 200;

    private static void createGUI() {
        JFrame frame = new JFrame("GameOfLife");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TableComponent tableComponent = new TableComponent();
        frame.getContentPane().add(tableComponent);

        frame.setPreferredSize(new Dimension(
                Table.TABLE_WIDTH * (GridRenderer.CELL_SIZE + 1) ,
                Table.TABLE_HEIGHT * (GridRenderer.CELL_SIZE + 2)
        ));

        frame.pack();
        frame.setVisible(true);
        Thread gameThread = new Thread(() -> {
            System.out.println("Thread started");
            while(true) {
                Table table = tableComponent.getTable();
                while (table.isHaveNextTick()) {
                    table.tick();
                    tableComponent.repaint();
                    try {
                        Thread.sleep(TICK_INTERVAL);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                tableComponent.resetTable();
            }
        });
        gameThread.start();
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        javax.swing.SwingUtilities.invokeLater(MainForm::createGUI);
    }
}
