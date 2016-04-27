/*
 * CIS 36B: Lab Assignment 9
 * Jenny Hamer
 * ID: 10876522
 *
 * Chapter 13: Exercise 4 - Upgrade the TrafficLightSimulator class 
 * store the duration of each color in the TrafficLightColor enum constants
 * add a constructor, a private instance variable, & method called getDelay()
 * red --> 12s, green --> 10s, yellow --> 2s
 */

package LabCh13_14_enums_autobox_annot;

enum TrafficLightColor {
    RED(12000), GREEN(10000), YELLOW(2000);
    
    private int lightDuration; // duration of each traffic light color
    
    // Constructor
    TrafficLightColor(int lD) { lightDuration = lD;} 
    
    // getter method for delay of each light
    int getDelay() { return lightDuration; }
}

class TrafficLightSimulator implements Runnable {
    private Thread mythread; // this will store the thread that controls simul.
    private TrafficLightColor tlc; // holds the current light color
    boolean stop = false;          // true to stop the simulation
    boolean changed = false;       // true when the light has changed
    
    TrafficLightSimulator(TrafficLightColor init) {
        tlc = init;
        
        mythread = new Thread(this);
        mythread.start();
    }
    
    TrafficLightSimulator() {
        tlc = TrafficLightColor.RED;
        
        mythread = new Thread(this);
        mythread.start();
    }
    // start the light
    public void run() {
        while(!stop) {
            try {
                Thread.sleep(tlc.getDelay()); // getDelay of GREEN
            } catch(InterruptedException exc) {
                System.out.println(exc);
            }
            changeColor();
        }
    }
    // change light color
    synchronized void changeColor() {
        switch(tlc) {
            case RED:
                tlc = TrafficLightColor.GREEN;
                break;
            case YELLOW:
                tlc = TrafficLightColor.RED;
                break;
            case GREEN:
                tlc = TrafficLightColor.YELLOW;
                break;
        }
        changed = true; // color has changed
        notify(); // signal to thread that light has changed
    }
    
    // wait for a light change to happen
    synchronized void waitForChange() {
        try {
            while(!changed) {
                wait(); // wait for light to change until it has
            }
            changed = false;
        } catch(InterruptedException exc) {
            System.out.println(exc);
        }
    }
    
    // return the current color
    synchronized TrafficLightColor getColor() {
        return tlc;
    }
    
    // stop the traffic light
    synchronized void cancel() {
        stop = true;
    }
}

class TrafficLightDemo {
    public static void main(String[] args) {
        TrafficLightSimulator tl = 
                new TrafficLightSimulator(TrafficLightColor.GREEN);
        
        for (int i = 0; i < 9; i++) {
            System.out.println(tl.getColor());
            tl.waitForChange();
        }
        tl.cancel();
    }
}

/* SAMPLE OUTPUT:
run:
GREEN
YELLOW
RED
GREEN
YELLOW
RED
GREEN
YELLOW
RED
BUILD SUCCESSFUL (total time: 1 minute 26 seconds)
*/


  