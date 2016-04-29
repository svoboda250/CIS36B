/*
 * CIS 36B: Quiz
 * @author Jenny Hamer
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class WhichLang implements ActionListener {

    JLabel langLabel;
    JRadioButton lang1;
    JRadioButton lang2;
    JRadioButton lang3;

    WhichLang() {  // constructor

        // create the frame, layout mngr --> FlowLayout, setSize, JLabel;
        // default termination --> close on exit
        JFrame myFrame = new JFrame("Language Chooser");
        myFrame.setLayout(new FlowLayout());
        myFrame.setSize(500, 200);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // create & add JLabel --> begin selected on 'English' mode
        // this will change upon language selection
        // make frame visible
        langLabel = new JLabel();
        langLabel.setText("Welcome to the USA");
        
        // create and add buttons to the window
        lang1 = new JRadioButton();
        lang1.setText("English");
        lang1.setActionCommand("English");
        lang1.setSelected(true);
        
        lang2 = new JRadioButton();
        lang2.setText("German");
        lang2.setActionCommand("German");
        
        lang3 = new JRadioButton();
        lang3.setText("Spanish");
        lang3.setActionCommand("Spanish");

        ButtonGroup langGroup = new ButtonGroup();
        langGroup.add(lang1);
        langGroup.add(lang2);
        langGroup.add(lang3);

        lang1.addActionListener(this);
        lang2.addActionListener(this);
        lang3.addActionListener(this);

        myFrame.add(lang1);
        myFrame.add(lang2);
        myFrame.add(lang3);

        myFrame.add(langLabel);
        myFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("German")) {
            lang2.setSelected(true);
            langLabel.setText("Willkommen in Deutschland");
        } else if (ae.getActionCommand().equals("Spanish")) {
            lang3.setSelected(true);
            langLabel.setText("Bienvenido a Espana");
        } else {
            lang1.setSelected(true);
            langLabel.setText("Welcome to the USA");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WhichLang();
            }
        });
    }
}
