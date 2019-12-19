package graphics;

import game.Table;

import javax.swing.*;
import java.awt.*;

public class MainForm {

    private static void createGUI() {
        JFrame frame = new JFrame("GameOfLife");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TableComponent tableComponent = new TableComponent();
        frame.getContentPane().add(tableComponent);

        frame.setPreferredSize(new Dimension(Table.TABLE_WIDTH * GridRenderer.CELL_SIZE, Table.TABLE_HEIGHT * GridRenderer.CELL_SIZE));

        frame.pack();
        frame.setVisible(true);
        Thread gameThread = new Thread(() -> {
            System.out.println("Thread started");
            while (true) {
                tableComponent.getTable().tick();
//                tableComponent.getTable().getCell(0,0).getCellStatus().;
                tableComponent.repaint();
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        gameThread.start();
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });
    }
}
