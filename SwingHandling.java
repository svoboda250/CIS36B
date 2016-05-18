/* Spring 2016
 * CIS 36B: 
 * LAB: Chapter 22 - Swing Handling - Strings
 *
 * @author Jenny Hamer
 *
 * this code is in response to textbook questions 1-9: p.839-840
 */

package swinghandling;

import java.io.*;

public class SwingHandling {

    /* this method corresponds to question 2 */
    public static boolean emptyString(String s) {
        return s.length() <= 0;
    }

    public static void main(String[] args) throws IOException {
        /* this section corresponds to question 1 */
        String s = "bananas";
        int lenS = s.length();
        String newS = "";
        for (int count = 0; count < lenS - 1; count++) {
            newS += s.charAt(count);
        }
        System.out.println("===========\nQuestion 1:");
        System.out.println("*method 1: \noriginal: " + s + "\nsubstring of s: "
                + newS);
        String substringS = s.substring(0, lenS - 1);
        System.out.println("*method 2: \noriginal: " + s + "\nsubstring of s: "
                + substringS);

        /* question 2: */
        System.out.println("===========\nQuestion 2:");
        System.out.println("emptyString(\"true?\") returns --> " 
                + emptyString("true?"));

        /* question 3: */
        System.out.println("===========\nQuestion 4:\nconcatenating string "
                + "substringS & newS");
        System.out.println(substringS.concat(newS));

        /* question 5: */
        System.out.println("===========\nQuestion 5:");
        System.out.println("2 + 2 + ME" + "--> " + (2 + 2 + "ME"));

        /*question 9: --> find a sentence in which this method does not 
            correctly modify the male gender pronouns into female ones: */
        
        // create a BufferedReader using System.in
        System.out.println("===========\nQuestion 9:");
        BufferedReader br = 
                new BufferedReader(new InputStreamReader(System.in));
        String str;

        str = br.readLine();
        str = str.replace(" he ", " she ");
        str = str.replace(" him ", " her ");
        str = str.replace(" his ", " her ");
        str = str.replace("He ", "She ");
        str = str.replace("His ", "Her ");

        System.out.println("*original* --> he went to her house.");
        System.out.println("*after* --> " + str);
    }
}


/* 
===========
Question 1:
*method 1: 
original: bananas
substring of s: banana
*method 2: 
original: bananas
substring of s: banana
===========
Question 2:
emptyString("true?") returns --> false
===========
Question 4:
concatenating string substringS & newS
bananabanana
===========
Question 5:
2 + 2 + ME--> 4ME
===========
Question 9:
he went to her house.
*original* --> he went to his house.
*after* --> he went to her house.
#### should be --> she went to her house. ####
*/