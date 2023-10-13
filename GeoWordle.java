import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JTextField;
import java.util.Scanner;

/**
 * Simple wordle game variation entitled GeoWordle.
 * @name Dennis-Cristian Baractaru
 * @studentID <1956957>
 * @name
 * @studentID
 * @date 07/10/2023
 */

 
public class GeoWordle {
    Scanner sc = new Scanner(System.in);
    //Displaying the interface (boxes + intro message)
    String[] categories = new String[] {"Animals.txt", "Capital Cities.txt", "Car brands.txt", 
        "Countries.txt", "Lakes.txt", "Mountain Ranges.txt", "Plants.txt", 
        "Rivers.txt", "Seas.txt", "Volcanoes.txt"};
    
    public int startMenu() { //Dennis
        //Displays a start menu
        int chosenCategory = 1;
        return chosenCategory;
    }

    public void gameWindow() { //Mantas
        //Displays the matrix, game name up top, GUESS button.
        //Interface
    }

    public String secretWord(int chosenCategory) { //Dennis
        //Read category words from category file mentioned in startMenu.
        //Pick out a random word.

        //List created to store all the words from the chosen category.
        List<String> categoryArray = new ArrayList<String>();
        //Try/catch needed in order to prevent dangerous code
        try { 
            //File reader
            BufferedReader reader = new BufferedReader(new FileReader(categories[chosenCategory]));
            String line = reader.readLine();
            while (line != null) { //The loops fill the list with the words from the file.
                String[] categoryArrayLine = line.split(" ");
                for (String word : categoryArrayLine) {
                    categoryArray.add(word);
                }
                line = reader.readLine();
            }
            reader.close(); //Closes reader operation.
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.shuffle(categoryArray); //Shuffles the arrray.
        String pickSecretWord = categoryArray.get(0);
        return pickSecretWord;
    }

    //Solution checker
    public boolean solution() { //Mantas
        //Takes input of each guess (check for length)
        //recursion algorithm to check for guessed word = secretWord
        //Remember to save number of guesses, time and previous guesses.
        return true;
    }

    public char[] splitSecretWord(String pickSecretWord) {
        char[] secretWordArray = new char[pickSecretWord.length()];
        for (int i = 0; i < pickSecretWord.length(); i++) {
            secretWordArray[i] = pickSecretWord.charAt(i);
        }
        return secretWordArray;
    }

    /**
     * Analysis of input: if guessed letter is the same as the secretword letter
     * or/and if the position of the guessed letter is the same as the position of the secretword letter.
     **/
    public boolean inputCorrectness(char[] secretWordArray, String pickSecretWord) { //Dennis
        boolean correctLetter;
        boolean correctPosition;
        for (int i = 0; i < pickSecretWord.length(); i++) {
            for (int j = 0; j < guess.length(); j++) {
                if (guessedLetter[i].equals(secretWordArray[j]) && i == j) {
                    return correctLetter && correctPosition;
                } else if (guessedLetter[i].equals(secretWordArray[j])) {
                    return correctLetter && !correctPosition;
                }
            }
        }
        return !correctLetter && !correctPosition;
    }
    
    public void guessEffect() { //Dennis
        //if correct letter but !correctposition, then: orange
        //if correct letter and correct position, then: green
    }

    public void victoryWindow() { //Mantas
        //if solution = true, start victoryWindow
    }

    public void defeatWindow() { //Dennis
        //if solution = false, start defeatWindow
    }

    public static void main(String[] args) {
        new GeoWordle().startMenu();
    }
}