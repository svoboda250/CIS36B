/* CIS 36B: Java Programming II
 * Lab 5: Series Interface and Shape Dimensions Implementation
 * Modified Series interface and SeriesDemo class from text
 * Calculate and print out areas of circles with successive radii of the values 1 - 5;
 * then values 15 - 20 & with areas of squares and volume of cubes with sides of the same dimens: 
 * 
 * @author Jenny Hamer
 */
package pkg36b_lab5;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

class SeriesDemo implements Series {

    int startValue;
    int value;

    SeriesDemo() { // default constructor for SeriesDemo with default values of 0
        startValue = 0;
        value = 0;
    }

    // implemented methods of the Series interface
    public int getNext() {
        value = value + 1;
        return value;
    }

    public void reset() {
        value = startValue;
    }

    public void setStart(int x) {
        startValue = x;
        value = x;
    }

    public static void main(String[] args) {
        SeriesDemo circleTest = new SeriesDemo();
        SeriesDemo squareTest = new SeriesDemo();
        SeriesDemo cubeTest = new SeriesDemo();

        // demonstrating the successive areas/volumes of three shapes with values 5 - 10
        circleTest.setStart(4); // for circles with radii 5 - 10 || A = PI * r^2
        squareTest.setStart(4); // for squares with side lengths 5 - 10 || A = l^2
        cubeTest.setStart(4); // for cubes with height lengths 5 - 10 || V = h^3

        for (int i = 0; i < 6; i++) {
            int currRadius = circleTest.getNext();
            int currSide = squareTest.getNext();
            int currLen = cubeTest.getNext();
            System.out.println("Radius value: " + currRadius + "  area of circle: " + PI * pow(currRadius, 2));
            System.out.println("Side length : " + currSide + "  area of square: " + pow(currSide, 2));
            System.out.println("Height value: " + currLen + "  area of cube: " + pow(currLen, 3) + '\n');
        }

        // demonstrating the successive areas/volumes of shapes with values 15 - 20
        circleTest.setStart(14);
        squareTest.setStart(14);
        cubeTest.setStart(14);

        for (int i = 0; i < 6; i++) {
            int currRadius = circleTest.getNext();
            int currSide = squareTest.getNext();
            int currLen = cubeTest.getNext();
            System.out.println("Radius value: " + currRadius + "  area of circle: " + PI * pow(currRadius, 2));
            System.out.println("Side length : " + currSide + "  area of square: " + pow(currSide, 2));
            System.out.println("Height value: " + currLen + "  area of cube: " + pow(currLen, 3) + '\n');
        }
    }
}
/*
 PROGRAM OUTPUT:
 Radius value: 5  area of circle: 78.53981633974483
 Side length : 5  area of square: 25.0
 Height value: 5  area of cube: 125.0

 Radius value: 6  area of circle: 113.09733552923255
 Side length : 6  area of square: 36.0
 Height value: 6  area of cube: 216.0

 Radius value: 7  area of circle: 153.93804002589985
 Side length : 7  area of square: 49.0
 Height value: 7  area of cube: 343.0

 Radius value: 8  area of circle: 201.06192982974676
 Side length : 8  area of square: 64.0
 Height value: 8  area of cube: 512.0

 Radius value: 9  area of circle: 254.46900494077323
 Side length : 9  area of square: 81.0
 Height value: 9  area of cube: 729.0

 Radius value: 10  area of circle: 314.1592653589793
 Side length : 10  area of square: 100.0
 Height value: 10  area of cube: 1000.0

 Radius value: 15  area of circle: 706.8583470577034
 Side length : 15  area of square: 225.0
 Height value: 15  area of cube: 3375.0

 Radius value: 16  area of circle: 804.247719318987
 Side length : 16  area of square: 256.0
 Height value: 16  area of cube: 4096.0

 Radius value: 17  area of circle: 907.9202768874502
 Side length : 17  area of square: 289.0
 Height value: 17  area of cube: 4913.0

 Radius value: 18  area of circle: 1017.8760197630929
 Side length : 18  area of square: 324.0
 Height value: 18  area of cube: 5832.0

 Radius value: 19  area of circle: 1134.1149479459152
 Side length : 19  area of square: 361.0
 Height value: 19  area of cube: 6859.0

 Radius value: 20  area of circle: 1256.6370614359173
 Side length : 20  area of square: 400.0
 Height value: 20  area of cube: 8000.0
 */
