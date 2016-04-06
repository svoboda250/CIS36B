/*
 * CIS 36B: Java Programming II
 * Lab 7: Q7 - Program which copies a text file, converting all spaces into hyphens using the byte stream file classes
 * program explicitly calls close() to flose the file
 * @author 'Jenny Hamer'
 */

import java.io.*;

public class ByteFileReader {

    public static void main(String[] args) {
        int i;
        FileInputStream fileIn = null; // read / incoming file
        FileOutputStream fileOut = null; // written / outgoing file
        // check: files [their names] must be specified

        if (args.length != 2) {
            System.out.println("Usage: ByteFileReader File");
        }
        
        try {
            fileIn = new FileInputStream(args[0]);
            fileOut = new FileOutputStream(args[1]);
        // files to be read[0] & to be written to [1]
            do {
                i = fileIn.read(); // reads bytes from the fileIn
                char space = ' ';
                if (i == space) { // wherever a space is found, replace it with a hyphen
                    i = '-';
                }
                if (i != -1) { // while there's stuff (bytes) to read, write to the fileOut
                    fileOut.write(i);
                }
            } while (i != -1);
        }
        catch(IOException exc) {
                System.out.println("I/O Error: " + exc);
        } finally { // in case of error in closing either fileIn or fileOut (input or output files)
            try {
                if (fileIn != null) { fileIn.close(); } // if the file had been specified, close it after reading
                    
            } catch(IOException exc) {
                            System.out.println("There was an error closing the input file - it does not exist.");
            }
            try {
                if (fileOut != null) { fileOut.close(); }
            } catch (IOException exc) {
                System.out.println("There was an error closing the output file - it does not exist.");
            }
        }
    }
}
          
/* PROGRAM OUTPUT: (using input file GoldenZen.txt & writing to HyphenZen.txt)
The-Golden-Age-of-Zen

Spring-has-its-hundred-flowers
Autumn-its-moon
Summer-has-its-cooling-breezes
Winter-its-snow
If-you-allow-no-idle-concerns
To-weight-on-your-heart
Your-whole-life-will-be-one
Perennial-good-season
==============================
original:
The Golden Age of Zen

Spring has its hundred flowers
Autumn its moon
Summer has its cooling breezes
Winter its snow
If you allow no idle concerns
To weight on your heart
Your whole life will be one
Perennial good season
*/