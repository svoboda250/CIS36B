/*
 * CIS 36B: Java Programming II - Lab 6
 * Questions 24
 * @author 'Jenny Hamer'
 */
package pkg36b_lab6;

public class Prog4 {

    public static void main(String[] args) {
        String[] data = {"Larry", "Moe", null, "Curly"};
        int sum = 0;

        for (String s : data) {
            sum += s.length();
        }
        System.out.println(sum);
    }
}
/* 
Output & explanation:
Since there is no exception catching clause in this program, the output is only
a NullPointerError, because the compiler does not know how to handle an element 
without a defined length unless it is hardcoded into a program.
Exception in thread "main" java.lang.NullPointerException
	at pkg36b_lab6.Prog4.main(Prog4.java:14)
*/
