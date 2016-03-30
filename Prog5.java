/*
 * CIS 36B: Java Programming II - Lab 6
 * Question 25: Prog5
 * @author 'Jenny Hamer'
 */
package pkg36b_lab6;

public class Prog5 {

    public static void main(String[] args) {
        Object[] data = {"Larry", new Prog5(), "Moe", null, "Curly"};
        try {
            for (Object s : data) {
                System.out.println((String) s);
            }
        } catch (Exception exc) {
        }
    }
}
/* 
 Output & explanation:
 As the program runs, it evaluates the first element of the Object array, and since
 it is both an Object and a String, it prints "Larry" to the console. When it reaches 
 the next element, which is an Object, but not a String, an exception is thrown and 
 successfully caught and the program terminates.
 */
