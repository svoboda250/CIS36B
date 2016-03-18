/**
 * Lab 4: Programming Assignment 2: Person class with private instance variables for the person's name and DOB
 * @author = 'Jenny Hamer'
 */

class Person {
    private String name;
    private String birthDate;

    //Person constructor with parameters
    Person(String n, String b) {
        name = n;
        birthDate = b;
    }

    //accessor methods for name and birthDate:
    String getName() {
        return name;
    }
    String getBirthDate() {
        return birthDate;
    }

    void showPersonDetails() {
        System.out.println("This person's name is " + getName() + " and was born on " + getBirthDate());
    }
}

class CollegeGraduate extends Person {
    private double gPA;
    private int gradYear;

    //parametrized constructor for the CollegeGraduate class
    CollegeGraduate(String n, String b, double gP, int gY) {
        super(n, b);
        gPA = gP;
        gradYear = gY;
    }

    double getGPA() {
        return gPA;
    }

    int getGradYear() {
        return gradYear;
    }
    public static void main(String[] args) {
        Person myPerson = new Person("Suzie Q", "June 15");
        Person yourPerson = new Person("Billy Bob", "December 1");
        CollegeGraduate myGrad = new CollegeGraduate("Erika Mantiply", "December 15", 3.5, 2007);
        CollegeGraduate yourGrad = new CollegeGraduate("Jilly Higgins", "February 3", 3.65, 2008);

        //testing the classes and their accessor methods
        System.out.println(myPerson.getName() + "'s birthday is the " + myPerson.getBirthDate() + ".");
        System.out.println(yourPerson.getName() + "'s birthday is the " + yourPerson.getBirthDate() + ".");
        System.out.println(myGrad.getName() + "'s birthday is the " + myGrad.getBirthDate() + ".");
        System.out.println(myGrad.getName() + " earned a " + myGrad.getGPA() + " GPA and graduated in " + myGrad.getGradYear() + ".");
        System.out.println(yourGrad.getName() + "'s birthday is the " + yourGrad.getBirthDate() + ".");
        System.out.println(yourGrad.getName() + " earned a " + yourGrad.getGPA() + " GPA and graduated in " + yourGrad.getGradYear() + ".");
    }
}

/* OUTPUT:
 * Suzie Q's birthday is the June 15.
 * Billy Bob's birthday is the December 1.
 * Erika Mantiply's birthday is the December 15.
 * Erika Mantiply earned a 3.5 GPA and graduated in 2007.
 * Jilly Higgins's birthday is the February 3.
 * Jilly Higgins earned a 3.65 GPA and graduated in 2008.
 */