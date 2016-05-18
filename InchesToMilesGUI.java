/*
 * CIS 36B: Dialogs Test --> 
 *
 * objective: generate a window (frame) with one button ("Click here")
 * upon user-click, open an input dialop prompting user for a [large] number of 
 * inches (int) --> if a valid integer (check using parseInt() ), return that 
 * value converted to miles; otherzise, return an error message
 *  
 * @author Jenny Hamer
 *
 */

package inchestomilesgui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class InchesToMilesGUI {

    JLabel label;
    JButton click;
    JFrame frame;
    
    InchesToMilesGUI() {
        
        // create the components of the JFrame
        frame = new JFrame("Inches to Miles Converter");
        frame.setLayout(new FlowLayout());
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        label = new JLabel();
        
        // click button's action listener
        click = new JButton("Click here for a fun math conversion!");
        click.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                // inputDialog for the user to enter a number
                String inches = JOptionPane.showInputDialog("Enter a whole number --> the bigger the better!");
                
                // if the user doesn't enter a valid integer value, return error
                if (inches == null) {
                    label.setText("Fun input...terminated (dialog was closed)");
                }
                else if (Integer.parseInt(inches) <= 0) {
                    label.setText("An invalid number or input was entered.");
                }
                else {
                    int newInches = Integer.parseInt(inches);
                    float inchToFoot = 12;     // 12 inches => 1 foot
                    float footToMile = 5280;   // 5280 feet => 1 mile

                    float miles = newInches / inchToFoot / footToMile;
                    label.setText(inches + " inches is the same as "
                            + miles + " miles!");
                }
            }
        });
        
        // add the fully-loaded button and label to the window
        frame.add(click);
        frame.add(label);

        frame.setVisible(true);
    }

 
    
    public static void main(String[] args) {
        // create da GUI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InchesToMilesGUI();
            }
        });
    }
}
