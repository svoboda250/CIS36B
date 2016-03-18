/**
 * Lab Assignment 3: Question 22 --> 2-Dimensional Triangular Array
 * @author = 'Jenny Hamer'
 *
 */
public class Triangular {
    public static void main(String[] args){
        System.out.println("Voilà a beautiful triangle, the contents of a 2-D array!");
        int [][] A = new int[10][];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < i + 1; j++) {
                A[i] = new int[j + 1]; //number of columns increases by one with every row
                A[i][j] = i + j;
                System.out.print(A[i][j]);
            }
            System.out.println();
        }
    }
}

/* OUTPUT:
 * Voilà a beautiful triangle, the contents of a 2-D array!
 * 0
 * 12
 * 234
 * 3456
 * 45678
 * 5678910
 * 6789101112
 * 7891011121314
 * 8910111213141516
 * 9101112131415161718
 */