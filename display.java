import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;

class display extends JPanel {

    public display(){
        JFrame frame = new JFrame();
        panel panel = new panel();

        frame.setTitle("Game of Life");
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);

        frame.setLayout(new BorderLayout());


        JButton button = new JButton("Evolve");
        button.setBounds(100,100,140, 40);
        frame.add(button, BorderLayout.SOUTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }


    public static void createDisplay() {
        display display = new display();


    }

}

// create a panel that you can draw on.
class panel extends JPanel {
    public void paint(Graphics g) {
        for (int i = 10; i < 600; i += 10){
            g.drawLine(0, i, 600, i);
        }
        for (int j = 10; j < 600; j += 10){
            g.drawLine(j, 0, j, 600);
        }



    }

    evolving step = new evolving();

    /*
    public void repaintCells(Graphics g, int arraySize, int[][] grid){
        for (int i = 0; i < arraySize; i++){
            for (int j = 0; j < arraySize; j++){
                if (grid[i][j] == 1){
                    g.drawOval(i + 5, j + 5, 2, 2);
                }
            }
        }
    }*/

}


class evolving extends evolution {
    public void evolving(Graphics g, int arraySize, int[][] grid) {
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                if (grid[i][j] == 1){
                    g.drawOval(i + 5, j + 5, 2, 2);
                }
            }
        }
    }
}
