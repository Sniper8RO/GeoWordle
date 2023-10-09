/**
 * Simple wordle game variation entitled GeoWordle.
 * @name Dennis-Cristian Baractaru
 * @studentID <1956957>
 * @name
 * @studentID
 * @date 07/10/2023
 */

public class GeoWordle {
    //Displaying the interface (boxes + intro message)
    public void startMenu() { //Dennis
        //Displays a start menu
    }

    public void gameWindow() { //Mantas
        //Displays the matrix, game name up top, GUESS button.
        //Interface
    }

    public String secretWord() { //Dennis
        //Read category words from category file mentioned in startMenu.
        //Pick out a random word.
        return "fml";
    }

    //Solution checker
    public boolean solution() { //Mantas
        //Takes input of each guess (check for length)
        //recursion algorithm to check for guessed word = secretWord
        //Remember to save number of guesses, time and previous guesses.
        return true;
    }

    //Analysis of input: displaying the colours
    public boolean correctLetter() { //Dennis

        return true;
    }

    public boolean correctPosition() { //Dennis

        return true;
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
        System.out.println();
    }
}