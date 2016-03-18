/**
 * Lab 4: Programming Question 1 (Ch. 7, No. 2) --> write a subclass of TwoDShape called Circle with an area() method
 * and a constructor that uses super to initialize the TwoDShape portion
 */
import java.lang.Math;

class TwoDShape {
    //two-d shape base class
    double width;
    double height;
    String name;

    public TwoDShape(double w, double h, String n) { // constructor for shape with equal width & height
        width = w;
        height = h;
        name = n;
    }

    public TwoDShape(double d, String n) { // constructor for shape with a circle (or a square)
        width = height = d;
        name = n;
    }

    void showDim() {
        System.out.println("Width and height are " + width + " and " + height  + ", respectively.");
    }
}

public class Circle extends TwoDShape { //subclass of TwoDShape which defines a circle
    //constructor for the Circle specifically
    Circle(double d) {
        super(d, "circle");
    }

    double area() { //method to calculate area of the circle
        double area = Math.pow(Math.PI * (width/2), 2.0);
        return area;
    }
    void showDim() { //overwritten showDim() method from base class to be more relevant for circle shape
        System.out.println("Radius and area are " + width/2 + " and " + area() + ", respectively.");
    }
    public static void main (String[] args) {
        Circle cir1 = new Circle(5);
        Circle cir2 = new Circle(10);
        System.out.println("This first circle is so interesting, here's some details on it: ");
        cir1.showDim();
        System.out.println("Here's the first circle's area, rounded : " + String.format( "%.2f", cir1.area()));
        System.out.println("This second circle is almost as interesting... its info: ");
        cir2.showDim();
        System.out.println("Here's the second circle's area, rounded : " + String.format( "%.2f", cir2.area()));
    }
}

/* OUTPUT:
 * This first circle is so interesting, here's some details on it:
 * Radius and area are 2.5 and 61.68502750680849, respectively.
 * Here's the first circle's area, rounded : 61,69
 * This second circle is almost as interesting... its info:
 * Radius and area are 5.0 and 246.74011002723395, respectively.
 * Here's the second circle's area, rounded : 246,74
 */