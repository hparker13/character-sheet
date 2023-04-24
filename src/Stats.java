import javax.swing.*;
import java.awt.*;

public class Stats extends JFrame {


    private JPanel pnlStats;

    Stats() {
        this.setContentPane(pnlStats);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Determine Ability Scores");
        this.setMinimumSize(new Dimension(750, 300));
        this.setSize(750, 300);
        this.setMaximumSize(new Dimension(750, 300));
        this.pack();
        this.setVisible(true);
    }
}
