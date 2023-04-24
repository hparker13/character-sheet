import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RaceClass extends JFrame {
    private JComboBox cbRace;
    private JComboBox cbSubrace;
    private JComboBox cbClass;
    private JTextArea taSubrace;
    private JTextArea taClass;
    private JTextArea taRace;
    private JPanel pnlRCMain;
    private JButton btnNext;
    private String race = "Dwarf";
    private String subrace = "Hill Dwarf";
    private String type = "Cleric";


    RaceClass() {
        this.setContentPane(pnlRCMain);

        taRace.setWrapStyleWord(true);
        taClass.setWrapStyleWord(true);
        taSubrace.setWrapStyleWord(true);


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Character Creation");

        this.pack();
        this.setVisible(true);


        // * * * * Action Listeners * * * *
        cbRace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (cbRace.getSelectedItem() == "Dwarf") {
                    cbSubrace.removeAllItems();
                    cbSubrace.addItem("Hill Dwarf");
                    cbSubrace.addItem("Mountain Dwarf");
                    cbSubrace.setEnabled(true);
                    taRace.setText("Ability score increase:\nConstitution +2\n\n" +
                            "Speed: 25ft\n\n" +
                            "Dwarven Resilience: \nYou have advantage on saving throws against poison, and you have " +
                            "resistance against poison damage \n\n" +
                            "Dwarven Combat Training: You have proficiency with the battleaxe, handaxe, light hammer, " +
                            "and warhammer.\n");

                } else if (cbRace.getSelectedItem() == "Elf") {
                    cbSubrace.removeAllItems();
                    cbSubrace.addItem("High Elf");
                    cbSubrace.addItem("Wood Elf");
                    cbSubrace.setEnabled(true);
                    taRace.setText("Ability score increase:  \nDexterity +2\n\n" +
                            "Speed: 30ft\n\n" +
                            "Keen Senses: \nYou have proficiency in the Perception skill.\n\n" +
                            "Fey Ancestry: \nYou have advantage on saving throws against being charmed, and magic can’t " +
                            "put you to sleep\n\n" +
                            "Elf Weapon Training: \nYou have proficiency with the longsword, shortsword, shortbow, and " +
                            "longbow.\n");

                } else if (cbRace.getSelectedItem() == "Halfling") {
                    cbSubrace.removeAllItems();
                    cbSubrace.addItem("Lightfoot");
                    cbSubrace.addItem("Stout");
                    cbSubrace.setEnabled(true);
                    taRace.setText("Ability score increase:  \nDexterity: +2\n\n" +
                            "Speed: 25ft\n\n" +
                            "Lucky: \nWhen you roll a 1 on the d20 for an attack roll, ability check, or saving throw, " +
                            "you can reroll the die and must use the new roll.\n");

                } else if (cbRace.getSelectedItem() == "Human") {
                    cbSubrace.removeAllItems();
                    cbSubrace.addItem("None");
                    cbSubrace.setEnabled(false);
                    taRace.setText("Ability score increase:  \nAll: +1\n\n" +
                            "Speed: 30ft\n");
                    taSubrace.setText("Humans do not have a subrace.");
                }
                race = cbRace.getSelectedItem().toString();
                System.out.println(race);
            }
        });
        cbSubrace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cbSubrace.getSelectedItem() == "Hill Dwarf") {
                    taSubrace.setText("Ability score increase:  \nWisdom +1\n\n" +
                            "Dwarven Toughness: \nYour hit point maximum increases by 1, and it increases by 1 every " +
                            "time you gain a level.\n");
                } else if (cbSubrace.getSelectedItem() == "Mountain Dwarf") {
                    taSubrace.setText("Ability score increase:  \nStrength +2\n\n" +
                            "Dwarven Armor Training: \nYou have proficiency with light and medium armor.\n");
                } else if (cbSubrace.getSelectedItem() == "High Elf") {
                    taSubrace.setText("Ability score increase:  \nIntelligence +1\n\n" +
                            "Cantrip: \nYou know one cantrip of your choice from the wizard spell list. Intelligence is " +
                            "your spellcasting ability for it.\n");
                } else if (cbSubrace.getSelectedItem() == "Wood Elf") {
                    taSubrace.setText("Ability score increase:  \nWisdom +1\n\n" +
                            "Speed: 35ft\n");
                } else if (cbSubrace.getSelectedItem() == "Lightfoot") {
                    taSubrace.setText("Ability score increase:  \nCharisma: +1\n");
                } else if (cbSubrace.getSelectedItem() == "Stout") {
                    taSubrace.setText("Ability score increase:  \nConstitution: +1\n\n" +
                            "Stout Resilience: \nYou have advantage on saving throws against poison, and you have " +
                            "resistance against poison damage.\n");
                } else if (cbSubrace.getSelectedItem() == "none") {
                    taSubrace.setText("Humans do not have a subrace.");
                }
                if (cbSubrace.getSelectedItem() != null) {
                    subrace = cbSubrace.getSelectedItem().toString();
                    System.out.println(subrace);
                }
            }
        });
        cbClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cbClass.getSelectedItem() == "Cleric") {
                    taClass.setText("Hit die: d8\n\n" +
                            "Primary Stat: Wisdom\n\n" +
                            "Saving Throw: \nWisdom & Charisma \n\n" +
                            "Armour & Weapons Proficiencies: \nLight and medium armor, shields, simple weapons\n\n" +
                            "Skills: \nChoose two from History, Insight, Medicine, Persuasion, and Religion\n");
                } else if (cbClass.getSelectedItem() == "Fighter") {
                    taClass.setText("Hit die: d10\n\n" +
                            "Primary Stat: Strength or Dexterity\n\n" +
                            "Saving Throw: \nStrength & Constitution\n\n" +
                            "Armour & Weapons Proficiencies: \nAll armor, shields, simple and martial weapons\n");
                } else if (cbClass.getSelectedItem() == "Rogue") {
                    taClass.setText("Hit die: d8\n\n" +
                            "Primary Stat: Dexterity\n\n" +
                            "Saving Throw: \nDexterity & Intelligence\n\n" +
                            "Armour & Weapons Proficiencies: \nLight armor, simple weapons, hand crossbows, longswords, rapiers, shortswords\n");
                } else if (cbClass.getSelectedItem() == "Wizard") {
                    taClass.setText("Hit die: d6\n\n" +
                            "Primary Stat: Intelligence \n\n" +
                            "Saving Throw: \nIntelligence & Wisdom\n\n" +
                            "Armour & Weapons Proficiencies:  \nDaggers, darts, slings, quarterstaffs, light crossbows\n");
                }
            }
        });
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Stats stats = new Stats();
                dispose();
            }
        });
    }


}
