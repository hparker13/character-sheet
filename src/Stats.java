import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Stats extends JFrame {


    private JPanel pnlStats;
    private JButton btnRoll;
    private JRadioButton rbRoll;
    private JTextField tfRoll1;
    private JTextField tfRoll2;
    private JTextField tfRoll3;
    private JTextField tfRoll4;
    private JLabel lblResult1;
    private JLabel lblResult2;
    private JLabel lblResult3;
    private JLabel lblResult4;
    private JLabel lblResult6;
    private JLabel lblResult5;
    private JButton btnNext;
    private JLabel lblTotal1;
    private JLabel lblTotal2;
    private JLabel lblTotal3;
    private JLabel lblTotal4;
    private JLabel lblTotal5;
    private JLabel lblTotal6;
    private JRadioButton rbStandard;
    private JRadioButton rbPoints;
    private int roll = 0;
    private List<Integer> lstRoll;
    private List<Integer> lstRolledTotals;
    private List<Integer> lstStandard;

    private Random random = new Random();

    Stats() {
        this.setContentPane(pnlStats);

        ButtonGroup group = new ButtonGroup();
        group.add(rbRoll);
        group.add(rbStandard);
        group.add(rbPoints);

        lstRoll = new ArrayList<>();
        lstRolledTotals = new ArrayList<>();
        lstStandard = new ArrayList<>();
        lstStandard.add(15);
        lstStandard.add(14);
        lstStandard.add(13);
        lstStandard.add(12);
        lstStandard.add(10);
        lstStandard.add(8);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Determine Ability Scores");

        this.pack();
        this.setVisible(true);
        btnRoll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value;
                roll++;
                lstRoll.clear();
                int sum = 0;
                if (roll <= 6) {
                    for (int i = 0; i < 4; i++) {
                        value = random.nextInt(6 - 1 + 1) + 1;
                        lstRoll.add(value);
                    }
                    System.out.println(roll);
                    Collections.sort(lstRoll);
                    tfRoll1.setText(String.valueOf(lstRoll.get(0)));
                    tfRoll2.setText(String.valueOf(lstRoll.get(1)));
                    tfRoll3.setText(String.valueOf(lstRoll.get(2)));
                    tfRoll4.setText(String.valueOf(lstRoll.get(3)));
                }
                for (int i = 1; i < lstRoll.size(); i++) {
                    sum = sum + lstRoll.get(i);
                }
                lstRolledTotals.add(sum);
                System.out.println(lstRolledTotals);
                if (roll == 1) {
                    lblTotal1.setText("Roll 1: " + String.valueOf(lstRolledTotals.get(0)));
                }
                if (roll == 2) {
                    lblTotal2.setText("Roll 2: " + String.valueOf(lstRolledTotals.get(1)));
                }
                if (roll == 3) {
                    lblTotal3.setText("Roll 3: " + String.valueOf(lstRolledTotals.get(2)));
                }
                if (roll == 4) {
                    lblTotal4.setText("Roll 4: " + String.valueOf(lstRolledTotals.get(3)));
                }
                if (roll == 5) {
                    lblTotal5.setText("Roll 5: " + String.valueOf(lstRolledTotals.get(4)));
                }
                if (roll == 6) {
                    lblTotal6.setText("Roll 6: " + String.valueOf(lstRolledTotals.get(5)));
                    btnRoll.setEnabled(false);
                }
                rolledTotalsUpdate();
            }
        });
        rbRoll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblResult1.setText("0");
                lblResult2.setText("0");
                lblResult3.setText("0");
                lblResult4.setText("0");
                lblResult5.setText("0");
                lblResult6.setText("0");
                rolledTotalsUpdate();
            }
        });
        rbStandard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblResult1.setText(String.valueOf(lstStandard.get(0)));
                lblResult2.setText(String.valueOf(lstStandard.get(1)));
                lblResult3.setText(String.valueOf(lstStandard.get(2)));
                lblResult4.setText(String.valueOf(lstStandard.get(3)));
                lblResult5.setText(String.valueOf(lstStandard.get(4)));
                lblResult6.setText(String.valueOf(lstStandard.get(5)));
            }
        });
    }

    public void rolledTotalsUpdate() {
        if (rbRoll.isSelected()) {
            if (lstRolledTotals.size() >= 1) {
                lblResult1.setText(String.valueOf(lstRolledTotals.get(0)));
            }
            if (lstRolledTotals.size() >= 2) {
                lblResult2.setText(String.valueOf(lstRolledTotals.get(1)));
            }
            if (lstRolledTotals.size() >= 3) {
                lblResult3.setText(String.valueOf(lstRolledTotals.get(2)));
            }
            if (lstRolledTotals.size() >= 4) {
                lblResult4.setText(String.valueOf(lstRolledTotals.get(3)));
            }
            if (lstRolledTotals.size() >= 5) {
                lblResult5.setText(String.valueOf(lstRolledTotals.get(4)));
            }
            if (lstRolledTotals.size() >= 6) {
                lblResult6.setText(String.valueOf(lstRolledTotals.get(5)));
            }
        }
    }
}
