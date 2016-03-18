/**
 * Lab Assignment 3: Question 3 - String palindrome checker
 */
public class Palindrome {
//    Scanner key = new Scanner(System.in);
//    String my_str = new String("abcdcba");
//    String another_str = new String("banana");

    public static void isPalindrome(String my_str) {
        String reverse_str = "";
        for (int i = my_str.length()-1; i >= 0; i--) {
            reverse_str = reverse_str + my_str.charAt(i);
        }
        if (my_str.equals(reverse_str)) {
            System.out.println(my_str + " is a palindrome!");
        } else {
            System.out.println(my_str + " is NOT a palindrome");
        }
    }

    public static void main(String[] args) {
        isPalindrome("abcdcba");
        isPalindrome("banana");
    }
}

/*
 * OUTPUT:
 * abcdcba is a palindrome!
 * banana is NOT a palindrome
 */
