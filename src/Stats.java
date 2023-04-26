import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class Stats extends JFrame {


    private JPanel          pnlStats;
    private JButton         btnRoll;
    private JRadioButton    rbRoll;
    private JTextField      tfRoll1;
    private JTextField      tfRoll2;
    private JTextField      tfRoll3;
    private JTextField      tfRoll4;
    private JLabel          lblResult1;
    private JLabel          lblResult2;
    private JLabel          lblResult3;
    private JLabel          lblResult4;
    private JLabel          lblResult6;
    private JLabel          lblResult5;
    private JButton         btnNext;
    private JLabel          lblTotal1;
    private JLabel          lblTotal2;
    private JLabel          lblTotal3;
    private JLabel          lblTotal4;
    private JLabel          lblTotal5;
    private JLabel          lblTotal6;
    private JRadioButton    rbStandard;
    private JRadioButton    rbPoints;
    private JLabel          lblMod1;
    private JLabel          lblMod2;
    private JLabel          lblMod3;
    private JLabel          lblMod4;
    private JLabel          lblMod5;
    private JLabel          lblMod6;
    private JSpinner        spn1;
    private JSpinner        spn2;
    private JSpinner        spn3;
    private JSpinner        spn4;
    private JSpinner        spn5;
    private JSpinner        spn6;
    private JLabel          lblPoints;
    private JButton btnPoints1Up;
    private JButton btnPoints1Down;
    private JLabel lblPoints1;
    private JLabel lblPoints2;
    private JLabel lblPoints3;
    private JLabel lblPoints4;
    private JLabel lblPoints5;
    private JLabel lblPoints6;
    private JButton btnPoints2Up;
    private JButton btnPoints3Up;
    private JButton btnPoints4Up;
    private JButton btnPoints5Up;
    private JButton btnPoints6Up;
    private JButton btnPoints2Down;
    private JButton btnPoints3Down;
    private JButton btnPoints4Down;
    private JButton btnPoints5Down;
    private JButton btnPoints6Down;
    private int             roll        = 0;
    private int             points      = 27;
    private int             previous1    = 8;
    private int             previous2    = 8;
    private int             previous3    = 8;
    private int             previous4    = 8;
    private int             previous5    = 8;
    private int             previous6    = 8;

    private List<Integer>   lstRoll;
    private List<Integer>   lstRolledTotals;
    private List<Integer>   lstStandard;

    private Random          random      = new Random();

    Stats() {
        this.setContentPane(pnlStats);

        ButtonGroup group   = new ButtonGroup();
        group.add(rbRoll);
        group.add(rbStandard);
        group.add(rbPoints);

        lstRoll             = new ArrayList<>();
        lstRolledTotals     = new ArrayList<>();
        lstStandard         = new ArrayList<>();
        lstStandard.add(15);
        lstStandard.add(14);
        lstStandard.add(13);
        lstStandard.add(12);
        lstStandard.add(10);
        lstStandard.add(8);

        lblPoints.setText(String.valueOf(points));

//        spn1 = new JSpinner(new SpinnerNumberModel(8, 8, 15, 1));

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        this.setLocationRelativeTo(null);
        this.setTitle("Determine Ability Scores");

        this.pack();
        this.setVisible(true);

        // * * * Action Listeners * * *
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
                updateModifiers();
            }
        });
        rbPoints.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblResult1.setText(lblPoints1.getText());
                lblResult2.setText(lblPoints2.getText());
                lblResult3.setText(lblPoints3.getText());
                lblResult4.setText(lblPoints4.getText());
                lblResult5.setText(lblPoints5.getText());
                lblResult6.setText(lblPoints6.getText());
                updateModifiers();
            }
        });
        btnPoints1Up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(lblPoints1.getText());
                if (value < 13 && points > 0) {
                    value++;
                    points--;
                } else if (value == 13 && points > 1) {
                    value++;
                    points = points - 2;
                } else if (value == 14 && points > 1) {
                    value++;
                    points = points - 2;
                    btnPoints1Up.disable();
                }
                lblPoints1.setText(String.valueOf(value));
                lblPoints.setText(String.valueOf(points));
                if (rbPoints.isSelected()) {
                    lblResult1.setText(String.valueOf(value));
                    updateModifiers();
                }
            }
        });
        btnPoints1Down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(lblPoints1.getText());
                if (value == 15 && points < 26) {
                    value--;
                    points = points + 2;
                } else if (value == 14 && points < 26) {
                    value--;
                    points = points + 2;
                } else if (value > 8 && points < 27) {
                    value--;
                    points++;
                    btnPoints1Down.disable();
                }
                lblPoints1.setText(String.valueOf(value));
                lblPoints.setText(String.valueOf(points));
                if (rbPoints.isSelected()) {
                    lblResult1.setText(String.valueOf(value));
                    updateModifiers();
                }
            }
        });
        btnPoints2Up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(lblPoints2.getText());
                if (value < 13 && points > 0) {
                    value++;
                    points--;
                } else if (value == 13 && points > 1) {
                    value++;
                    points = points - 2;
                } else if (value == 14 && points > 1) {
                    value++;
                    points = points - 2;
                    btnPoints2Up.disable();
                }
                lblPoints2.setText(String.valueOf(value));
                lblPoints.setText(String.valueOf(points));
                if (rbPoints.isSelected()) {
                    lblResult2.setText(String.valueOf(value));
                    updateModifiers();
                }
            }
        });
        btnPoints2Down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(lblPoints2.getText());
                if (value == 15 && points < 26) {
                    value--;
                    points = points + 2;
                } else if (value == 14 && points < 26) {
                    value--;
                    points = points + 2;
                } else if (value > 8 && points < 27) {
                    value--;
                    points++;
                    btnPoints2Down.disable();
                }
                lblPoints2.setText(String.valueOf(value));
                lblPoints.setText(String.valueOf(points));
                if (rbPoints.isSelected()) {
                    lblResult2.setText(String.valueOf(value));
                    updateModifiers();
                }
            }
        });
        btnPoints3Up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(lblPoints3.getText());
                if (value < 13 && points > 0) {
                    value++;
                    points--;
                } else if (value == 13 && points > 1) {
                    value++;
                    points = points - 2;
                } else if (value == 14 && points > 1) {
                    value++;
                    points = points - 2;
                    btnPoints1Up.disable();
                }
                lblPoints3.setText(String.valueOf(value));
                lblPoints.setText(String.valueOf(points));
                if (rbPoints.isSelected()) {
                    lblResult3.setText(String.valueOf(value));
                    updateModifiers();
                }
            }
        });
        btnPoints3Down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(lblPoints3.getText());
                if (value == 15 && points < 26) {
                    value--;
                    points = points + 2;
                } else if (value == 14 && points < 26) {
                    value--;
                    points = points + 2;
                } else if (value > 8 && points < 27) {
                    value--;
                    points++;
                    btnPoints1Down.disable();
                }
                lblPoints3.setText(String.valueOf(value));
                lblPoints.setText(String.valueOf(points));
                if (rbPoints.isSelected()) {
                    lblResult3.setText(String.valueOf(value));
                    updateModifiers();
                }
            }
        });
        btnPoints4Up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(lblPoints4.getText());
                if (value < 13 && points > 0) {
                    value++;
                    points--;
                } else if (value == 13 && points > 1) {
                    value++;
                    points = points - 2;
                } else if (value == 14 && points > 1) {
                    value++;
                    points = points - 2;
                    btnPoints4Up.disable();
                }
                lblPoints4.setText(String.valueOf(value));
                lblPoints.setText(String.valueOf(points));
                if (rbPoints.isSelected()) {
                    lblResult4.setText(String.valueOf(value));
                    updateModifiers();
                }
            }
        });
        btnPoints4Down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(lblPoints4.getText());
                if (value == 15 && points < 26) {
                    value--;
                    points = points + 2;
                } else if (value == 14 && points < 26) {
                    value--;
                    points = points + 2;
                } else if (value > 8 && points < 27) {
                    value--;
                    points++;
                    btnPoints4Down.disable();
                }
                lblPoints4.setText(String.valueOf(value));
                lblPoints.setText(String.valueOf(points));
                if (rbPoints.isSelected()) {
                    lblResult4.setText(String.valueOf(value));
                    updateModifiers();
                }
            }
        });
        btnPoints5Up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(lblPoints5.getText());
                if (value < 13 && points > 0) {
                    value++;
                    points--;
                } else if (value == 13 && points > 1) {
                    value++;
                    points = points - 2;
                } else if (value == 14 && points > 1) {
                    value++;
                    points = points - 2;
                    btnPoints5Up.disable();
                }
                lblPoints5.setText(String.valueOf(value));
                lblPoints.setText(String.valueOf(points));
                if (rbPoints.isSelected()) {
                    lblResult5.setText(String.valueOf(value));
                    updateModifiers();
                }
            }
        });
        btnPoints5Down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(lblPoints5.getText());
                if (value == 15 && points < 26) {
                    value--;
                    points = points + 2;
                } else if (value == 14 && points < 26) {
                    value--;
                    points = points + 2;
                } else if (value > 8 && points < 27) {
                    value--;
                    points++;
                    btnPoints5Down.disable();
                }
                lblPoints5.setText(String.valueOf(value));
                lblPoints.setText(String.valueOf(points));
                if (rbPoints.isSelected()) {
                    lblResult5.setText(String.valueOf(value));
                    updateModifiers();
                }
            }
        });
        btnPoints6Up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(lblPoints6.getText());
                if (value < 13 && points > 0) {
                    value++;
                    points--;
                } else if (value == 13 && points > 1) {
                    value++;
                    points = points - 2;
                } else if (value == 14 && points > 1) {
                    value++;
                    points = points - 2;
                    btnPoints6Up.disable();
                }
                lblPoints6.setText(String.valueOf(value));
                lblPoints.setText(String.valueOf(points));
                if (rbPoints.isSelected()) {
                    lblResult6.setText(String.valueOf(value));
                    updateModifiers();
                }
            }
        });
        btnPoints6Down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(lblPoints6.getText());
                if (value == 15 && points < 26) {
                    value--;
                    points = points + 2;
                } else if (value == 14 && points < 26) {
                    value--;
                    points = points + 2;
                } else if (value > 8 && points < 27) {
                    value--;
                    points++;
                    btnPoints6Down.disable();
                }
                lblPoints6.setText(String.valueOf(value));
                lblPoints.setText(String.valueOf(points));
                if (rbPoints.isSelected()) {
                    lblResult6.setText(String.valueOf(value));
                    updateModifiers();
                }
            }
        });
        spn1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value   = (int) spn1.getValue();
                int current = value;

                if (current > previous1 && points > 0) {
                    if (current < 14) {
                        points--;
                    } else {
                        points = points - 2;
                    }
                } else if (current < previous1) {
                    if (current > 12) {
                        points = points + 2;
                    } else {
                        points++;
                    }
                }
                lblPoints.setText(String.valueOf(points));
                lblResult1.setText(String.valueOf(value));
                updateModifiers();
                previous1 = current;
            }
        });
        spn2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value   = (int) spn2.getValue();
                int current = value;

                if (current > previous2 && points > 0) {
                    if (current < 14) {
                        points--;
                    } else {
                        points = points - 2;
                    }
                } else if (current < previous2) {
                    if (current > 12) {
                        points = points + 2;
                    } else {
                        points++;
                    }
                }
                lblPoints.setText(String.valueOf(points));
                lblResult2.setText(String.valueOf(value));
                updateModifiers();
                previous2 = current;
            }
        });
        spn3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value   = (int) spn3.getValue();
                int current = value;

                if (current > previous3 && points > 0) {
                    if (current < 14) {
                        points--;
                    } else {
                        points = points - 2;
                    }
                } else if (current < previous3) {
                    if (current > 12) {
                        points = points + 2;
                    } else {
                        points++;
                    }
                }
                lblPoints.setText(String.valueOf(points));
                lblResult3.setText(String.valueOf(value));
                updateModifiers();
                previous3 = current;
            }
        });
        spn4.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value   = (int) spn4.getValue();
                int current = value;

                if (current > previous4 && points > 0) {
                    if (current < 14) {
                        points--;
                    } else {
                        points = points - 2;
                    }
                } else if (current < previous4) {
                    if (current > 12) {
                        points = points + 2;
                    } else {
                        points++;
                    }
                }
                lblPoints.setText(String.valueOf(points));
                lblResult4.setText(String.valueOf(value));
                updateModifiers();
                previous4 = current;
            }
        });
        spn5.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value   = (int) spn5.getValue();
                int current = value;

                if (current > previous5 && points > 0) {
                    if (current < 14) {
                        points--;
                    } else {
                        points = points - 2;
                    }
                } else if (current < previous5) {
                    if (current > 12) {
                        points = points + 2;
                    } else {
                        points++;
                    }
                }
                lblPoints.setText(String.valueOf(points));
                lblResult5.setText(String.valueOf(value));
                updateModifiers();
                previous5 = current;
            }
        });
        spn6.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value   = (int) spn6.getValue();
                int current = value;

                if (current > previous6 && points > 0) {
                    if (current < 14) {
                        points--;
                    } else {
                        points = points - 2;
                    }
                } else if (current < previous6) {
                    if (current > 12) {
                        points = points + 2;
                    } else {
                        points++;
                    }
                }
                lblPoints.setText(String.valueOf(points));
                lblResult6.setText(String.valueOf(value));
                updateModifiers();
                previous6 = current;
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
            updateModifiers();
        }
    }

    public void setModifiers(JLabel lblResult, JLabel lblMod) {
        int modifier;
        String value = lblResult.getText();

        switch (value) {
            case "3":
                modifier = -4;
                break;
            case "4":
            case "5":
                modifier = -3;
                break;
            case "6":
            case "7":
                modifier = -2;
                break;
            case "8":
            case "9":
                modifier = -1;
                break;
            case "10":
            case "11":
                modifier = 0;
                break;
            case "12":
            case "13":
                modifier = 1;
                break;
            case "14":
            case "15":
                modifier = 2;
                break;
            case "16":
            case "17":
                modifier = 3;
                break;
            case "18":
            case "19":
                modifier = 4;
                break;
            default:
                modifier = 0;
        }

        if (modifier >= 0) {
            lblMod.setText("+" + String.valueOf(modifier));
        } else {
            lblMod.setText(String.valueOf(modifier));
        }
    }

    public void updateModifiers() {
        setModifiers(lblResult1, lblMod1);
        setModifiers(lblResult2, lblMod2);
        setModifiers(lblResult3, lblMod3);
        setModifiers(lblResult4, lblMod4);
        setModifiers(lblResult5, lblMod5);
        setModifiers(lblResult6, lblMod6);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        SpinnerNumberModel sm1 = new SpinnerNumberModel(8, 8, 15, 1);
        spn1 = new JSpinner(sm1);
        SpinnerNumberModel sm2 = new SpinnerNumberModel(8, 8, 15, 1);
        spn2 = new JSpinner(sm2);
        SpinnerNumberModel sm3 = new SpinnerNumberModel(8, 8, 15, 1);
        spn3 = new JSpinner(sm3);
        SpinnerNumberModel sm4 = new SpinnerNumberModel(8, 8, 15, 1);
        spn4 = new JSpinner(sm4);
        SpinnerNumberModel sm5 = new SpinnerNumberModel(8, 8, 15, 1);
        spn5 = new JSpinner(sm5);
        SpinnerNumberModel sm6 = new SpinnerNumberModel(8, 8, 15, 1);
        spn6 = new JSpinner(sm6);
    }
}
