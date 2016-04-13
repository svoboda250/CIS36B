/* 
 * CIS 36B: Lab 8 - Chapter 12 Multithreaded Programming
 * Question 8: Change the TickTock class so that it keeps time, ie. have each
 * tick & tock take one half second each ( = one whole second) 
 * ignore the time required to switch tasks
 * 
 * @author Jenny Hamer
 */

package multithreaded_programming;

import static java.lang.Thread.sleep;

public class TickTock {

    String state; // contains the state of the clock, ie. tick or tock
    
    synchronized void tick(boolean running) {
        if (!running) { // if not running, stop the clock
            state = "ticked";
            notify(); // notify any threads waiting to be run
            return;
        }
        System.out.print("Tick ");
        
        state = "ticked"; // set the current state to ticked
        notify(); // let tock() run <<--- tick() notifies tock()
        try {
            Thread.sleep(500); // pauses for 500ms or one half second
            while(!state.equals("tocked")) {
                wait(); // wait for tock to complete
            }
        } catch (InterruptedException exc) {
            System.out.println("Thread interrupted!!!");
        }
    }
    
    synchronized void tock(boolean running) {
        
        if (!running) { // if not running, stop the clock
            state = "tocked";
            notify(); // notify any waiting threads
            return;
        }

        System.out.println("Tock");
        state = "tocked"; // set the current state to tocked
        
        notify(); // let tick() run now
        try {
            Thread.sleep(500); // pauses for 500ms or one half second
            while (!state.equals("ticked")) {
                wait(); // wait for tick to complete <<-- tock() waits for tick()
            }
        } catch (InterruptedException exc) {
            System.out.println("Thread interruped!!!");
            
        }
    }
}

class MyThread implements Runnable {
    Thread thrd;
    TickTock ttOb;
    
    // construct a new thread
    MyThread (String name, TickTock tt) {
        thrd = new Thread(this, name);
        ttOb = tt;
        thrd.start(); // starts the thread
    }
    
    // start the execturion o the new thread
    public void run() {
        if (thrd.getName().compareTo("Tick") == 0) {
            for (int i = 0; i < 5; i++) { 
                ttOb.tick(true);
            }
            ttOb.tick(false);
        }
        else {
            for (int i = 0; i < 5; i++) {
                ttOb.tock(true);
            }
            ttOb.tock(false);
        }
    }
}
    
class ThreadCom {
    
    public static void main(String[] args) {
        TickTock ticktock = new TickTock();
        MyThread mythread1 = new MyThread("Tick", ticktock);
        MyThread mythread2 = new MyThread("Tock", ticktock);
        try  {
            mythread1.thrd.join();
            mythread2.thrd.join();
        } catch (InterruptedException exc) {
            System.out.println("Main thread interrupted, oh nooo!");
        }
    }
}

/* OUTPUT SAMPLE:
 *
 * run:
 * Tick Tock
 * Tick Tock
 * Tick Tock
 * Tick Tock
 * Tick Tock
 * BUILD SUCCESSFUL (total time: 6 seconds)
*/