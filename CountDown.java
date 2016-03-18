/**
 * Lab Assignment 3: Question 4: Recursive countDown() method
 * @author = 'Jenny Hamer'
 */
public class CountDown {
    public static int countDown(int n) {
        // prints the integers from n down to 0, line by line, followed by 'Blast off!'
        if (n == 0) {
            System.out.println(n + "\nBlast off!");
            return 0;
        } else {
            System.out.println(n);
            return countDown(n-1);
        }
    }


    public static void main(String[] args) {
        countDown(10);
        countDown(5);
    }
}

/* OUTPUT:
 * 10
 * 9
 * 8
 * 7
 * 6
 * 5
 * 4
 * 3
 * 2
 * 1
 * 0
 * Blast off!
 * ==================
 * 5
 * 4
 * 3
 * 2
 * 1
 * 0
 * Blast off!
 */