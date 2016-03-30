/*
 * CIS 36B: Java Programming II - Lab 6
 * Questions 23
 * @author 'Jenny Hamer'
 */
package pkg36b_lab6;

public class Prog3 {

    public static void main(String[] args) {
        String[] data = {"Larry", "Moe", null, "Curly"};
        int sum = 0;

        try {
            for (String s : data) {
                sum += s.length();
                System.out.println(sum);
            }
        } catch (Exception exc) {
        }
    }
}
/* 
Output & explanation:
As the program runs, it calculates the elements' length, adding and printing the 
sum one-by-one to the 'sum' variable. It prints 5 (length of "Larry"), then 8 ("Larry" + "Moe"), 
but stops at the null element when it catches the exception and finishes the program's execution.
*/
