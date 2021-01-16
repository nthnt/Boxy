import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window extends Canvas {
    
    public Window (int width, int length, String title, Boxy block) {
        JFrame box = new JFrame(title);
        
        box.setPreferredSize(new Dimension (width, length));
        box.setMaximumSize(new Dimension (width, length));
        box.setMinimumSize(new Dimension (width, length));
        
        box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        box.setResizable(false);
        box.setLocationRelativeTo(null);
        box.add(block);
        box.setVisible(true);
        block.start();
    }
}
