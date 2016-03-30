/*
 *
 * CIS 36B: Java Programming II - Lab 6
 * Questions 22
 * @author 'Jenny Hamer'
 */
package pkg36b_lab6;

public class Prog2 {

    public static void main(String[] args) {
        String[] data = {"Larry", "Moe", null, "Carly"};
        int sum = 0;

        try {
            for (String s : data) {
                sum += s.length();
            }
        } catch (Exception exc) {
            System.out.println(sum);
        }
    }
}
/*
 Output & explanation:
 As the program runs, it calculates the lengths of the elements in 'data' and adds 
 them to the variable 'sum' until it reaches the third (2eth) element - null - which has no length
 and throws and exception, which is caught by the program and stops its execution. 
 The output is 8 (length of "Larry" + length of "Moe")
 */
