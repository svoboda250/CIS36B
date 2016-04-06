/*
 * CIS 36B: Java Programming II
 * Lab 7: Q8 - Program which copies a text file, converting all spaces into hyphens 
 * using the character stream file classe - FileReader / FileWriter classes
 * program uses try-with-resources statement to close the file
 * @author 'Jenny Hamer'
 */

import java.io.*;

public class CharacterReader {

    public static void main(String[] args) {
        int i;
        // check: files [their names] must be specified as command-line arguments
        if (args.length != 2) {
            System.out.println("Usage: CharacterReader File");            
        }
        
        try (FileReader fileIn = new FileReader("Poem.txt"); FileWriter fileOut = new FileWriter("Hyphen2.txt")) 
        { // try-with-resources block, use args[0] & args[1] in place of specific files & command-line args if desired
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
        }
    }
}
/* OUTPUT:
Le-Serpent-qui-danse
Que-j'aime-voir,-chère-indolente,
De-ton-corps-si-beau,
Comme-une-étoffe-vacillante,
Miroiter-la-peau!

Sur-ta-chevelure-profonde
Aux-âcres-parfums,
Mer-odorante-et-vagabonde
Aux-flots-bleus-et-bruns...
=================================
ORIGINAL:
Le Serpent qui danse

Que j'aime voir, chère indolente,
De ton corps si beau,
Comme une étoffe vacillante,
Miroiter la peau!

Sur ta chevelure profonde
Aux âcres parfums,
Mer odorante et vagabonde
Aux flots bleus et bruns ...
*/
          
