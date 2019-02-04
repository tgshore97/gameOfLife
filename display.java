import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class display extends JPanel {
    //sets preferences for displaying data, contains buttons action listener to evolve
    public display(int[][] grid){
        JFrame frame = new JFrame();
        panel panel = new panel();

        frame.setTitle("Game of Life");
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());


        JButton button = new JButton("Evolve");
        //clicking the button moves the evolution on by one step
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                evolution.step(grid, Main.neighs, Main.arraySize);
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
    //creates grid lines and places 'cells' in each space where necessary
    public void paint(Graphics g, int[][] grid) {

        for (int i = 600/Main.arraySize; i < 600; i += 600/Main.arraySize){
            g.drawLine(0, i, 600, i);
        }
        for (int j = 600/Main.arraySize; j < 600; j += 600/Main.arraySize){
            g.drawLine(j, 0, j, 600);
        }
        for (int i = 0; i < Main.arraySize; i++){
            for (int j = 0; j < Main.arraySize; j++){
                if (grid[i][j] == 1){
                    g.fillOval(i*10+2, j*10+2, 5, 5);
                }
            }
        }
    }
    //clears panel and redraws new value
    public void evolveScreen(Graphics g, int[][] grid) {
        g.clearRect(0, 0, getWidth(), getHeight());
        paint(g, grid);
    }
}
