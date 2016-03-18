/**
 * Lab 4: Programming Question 3: Think of a situation in daily life where you mi ght be inclined to write a java program using super
 * class and at least 2 subclasses. Explain it and write a Java program for it. Make the methods and objects in the super class private and use accessor methods to use them.
 * @author = 'Jenny Hamer'
 */

// defines the base class - TaskToComplete - for tasks on a (my) to-do list
class TaskToComplete {
    private String typeOfTask;
    private int timeToComplete;

    // default constructor for generic task
    TaskToComplete(){
        typeOfTask = "none";
        timeToComplete = 0;
    }

    // parametrized constructor for the generic task with type and time as parameters (time in minutes)
    TaskToComplete(String type, int time) {
        typeOfTask = type;
        timeToComplete = time;
    }

    // accessor methods for typeOfTask and timeToComplete
    String getTypeOfTask() {
        return typeOfTask;
    }

    int getTimeToComplete() {
        return timeToComplete;
    }
}

// sample subclass of TaskToComplete to demonstrate
class ThisTask extends TaskToComplete {
    private String nameOfTask;

    // default constructor for ThisTask
    ThisTask() {
        super();
    }
    // parametrized constructor for ThisTask
    ThisTask(String name, String type, int time) {
        super(type, time);
        nameOfTask = name;
    }

    // accessor method to get the nameOfTask
    String getNameOfTask() {
        return nameOfTask;
    }
}

class CleaningTask extends ThisTask {
    private boolean suppliesNeeded;
    private boolean glovesNeeded;
    private boolean broomNeeded;

    // parametrized constructor for CleaningTask
    CleaningTask(boolean supplies, boolean gloves, boolean broom, String name, String type, int time) {
        super(name, type, time);
        suppliesNeeded = supplies;
        glovesNeeded = gloves;
        broomNeeded = broom;
    }
    // accessor methods --> gets which supplies are needed
    boolean getSuppliesNeeded() {
        return suppliesNeeded;
    }
    boolean getGlovesNeeded() {
        return glovesNeeded;
    }
    boolean getBroomNeeded() {
        return broomNeeded;
    }

    void showDetails() {
        // to show the details about the CleaningTask
        System.out.println("Type of task: " + getTypeOfTask() + "\nTime to complete: " + getTimeToComplete() + " minutes.");
        if (getSuppliesNeeded() == true) {
            System.out.println(getNameOfTask() + " requires the following supplies: ");
            if (getGlovesNeeded() == true) {
                System.out.println(">> a pair of gloves");
            } else {
                System.out.print("");
            }
            if (getBroomNeeded() == true) {
                System.out.println(">> a broom");
            } else {
                System.out.print("");
            }
        } else { System.out.println("This cleaning task doesn't require any supplies!"); }

    }

    public static void main(String[] args) {
        CleaningTask dishes = new CleaningTask(true, true, false, "Dish-washing", "Cleaning", 45);
        System.out.println("All about this task: ");
        dishes.showDetails();
        System.out.println("===============================================");
        ThisTask createProgram = new ThisTask("Writing a programming demonstrating inheritance", "Homework", 30);
        System.out.println("Next task on the list: ");
        System.out.println(createProgram.getNameOfTask() + " is a task of " + createProgram.getTypeOfTask()
                + " and takes " + createProgram.getTimeToComplete() + " minutes to complete.");
    }
}


/* OUTPUT:
 * All about this task:
 * Type of task: Cleaning
 * Time to complete: 45 minutes.
 * Dish-washing requires the following supplies:
 * >> a pair of gloves
 * ===============================================
 * Next task on the list:
 * Writing a programming demonstrating inheritance is a task of Homework and takes 30 minutes to complete.
 */