/*
 * CIS 36B: Prof. Abboud
 * 
 * Lab Assignment 10: Chapter 17 Swing Fundamentals
 * Question 10 from text: Upgrading the stopwatch example to require one button
 * that switches between Start & Stop
 * 
 * @author Jenny Hamer
 */
package pkg36b_lab10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class StopWatch implements ActionListener {
    
    JLabel myLabel;
    JButton switchButton;
    long start; // stores the start time in ms
    
    StopWatch() { // constructor
        // create the JFrame container for our window
        JFrame myFrame = new JFrame("An Upgrade To A Simple Stopwatch");
        
        // set the FlowLayout for the layout manager
        myFrame.setLayout(new FlowLayout());
        
        // set the initial frame size
        myFrame.setSize(240, 100);
        
        // set default program termination --> user clicks 'x' to close
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // create a single button to hold the two options: START || STOP
        // setActionCommand & setText to change functionality & appearance
        switchButton = new JButton(); 
        switchButton.setText("Start");
        switchButton.setActionCommand("Start");
        
        // add action listeners to the button
        switchButton.addActionListener(this);
        
        // create a label --> displays a message to the user
        myLabel = new JLabel("Press Start to begin timing.");
        
        // add button & label to the content page, make frame visible
        myFrame.add(switchButton);
        myFrame.add(myLabel);
        myFrame.setVisible(true);
    }
    
    // event handling
    public void actionPerformed(ActionEvent ae) {
        // fetch current system time
        Calendar calend = Calendar.getInstance();
        
        // if start is clicked, begin timing
        if (ae.getActionCommand().equals("Start")) {
            start = calend.getTimeInMillis();
            switchButton.setText("Stop the watch");
            switchButton.setActionCommand("Stop");
            myLabel.setText("The stopwatch is running...");
        }
        else { // when 'stop' is clicked, compute the elapsed time
            myLabel.setText("Elapsed time is " 
                    + (double) (calend.getTimeInMillis() - start)/1000 + "sec");
        }
    }
    
    public static void main(String[] args) {
        // create the frame on the event dispatching thread (anon method)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StopWatch();
            }
        });
    }
}
