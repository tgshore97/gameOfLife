import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class display extends JPanel {
    public display(int[][] grid){
        JFrame frame = new JFrame();
        panel panel = new panel();

        frame.setTitle("Game of Life");
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JButton button = new JButton("Evolve");

       button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                evolution.step(grid, Main.grid2, Main.neighs, Main.arraySize);
                panel.evolveScreen(panel.getGraphics(), grid);
            }
        });

        button.setBounds(100,100,140, 40);
        frame.add(button, BorderLayout.SOUTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public static void createDisplay(int[][] grid) {
        display display = new display(grid);
    }

}

// create a panel that you can draw on.
class panel extends JPanel {

    public void paint(Graphics g, int[][] grid) {
        for (int i = 10; i < 600; i += 10){
            g.drawLine(0, i, 600, i);
        }
        for (int j = 10; j < 600; j += 10){
            g.drawLine(j, 0, j, 600);
        }
        for (int i = 0; i < Main.arraySize; i++){
            for (int j = 0; j < Main.arraySize; j++){
                if (grid[i][j] == 1){ //SET TO 0 to test array values
                    g.fillOval(i*10+2, j*10+2, 5, 5);
                }
            }
        }
    }

    public void evolveScreen(Graphics g, int[][] grid) {
        g.clearRect(0, 0, getWidth(), getHeight());
        paint(g, grid);
    }
}
