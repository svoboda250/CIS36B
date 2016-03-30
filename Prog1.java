/*
 * CIS 36B: Java Programming II - Lab 6
 * Questions 21 - 25: Exception handling code snippets from text with explanations
 * Question 21: Prog1
 * @author 'Jenny Hamer'
 */
package pkg36b_lab6;

public class Prog1 {

    public static void main(String[] args) {
        String[] data = {"Larry", "Moe", null, "Curly"};
        try {
            for (String s : data) {
                System.out.println(s.length());
            }
        } catch (Exception exc) {
        }
    }
}
/* 
 Output & explanation:
 The program with output the lengths of the first two elements of the array 'data' as such -->
 5
 3
 and the program stops, because the third element - null - throws an exception, 
 because the compiler is attempting to evaluate its length as though it were an array,
 which is caught and finishes the program execution.
 */
