import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    String title;
    MyFrame(String title){
        this.setTitle(title);
        this.setVisible(true);
        this.setSize(550,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        ImageIcon image = new ImageIcon("src/main/fvgen.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(Color.white); //new Color(RGB albo cmyk whatever)
    }
}
