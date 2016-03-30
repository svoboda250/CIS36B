/* CIS 36B: Java Programming II
 * Lab 5: Series Interface and Shape Dimensions Implementation
 * Modified Series interface and SeriesDemo class from text
 * Calculate and print out areas of circles with successive radii of the values 1 - 5;
 * then values 15 - 20 & with areas of squares and volume of cubes with sides of the same dimens: 
 * 
 * @author Jenny Hamer
 */
package pkg36b_lab5;

public interface Series {
    int getNext();
    void reset();
    void setStart(int x); // 
}
