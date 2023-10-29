import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.*;

/**
 * Simple wordle game variation entitled GeoWordle.
 * @author Dennis-Cristian Baractaru
 * @studentID <1956957>
 * @author Mantas Juškauskas
 * @studentID <1954733>
 * @date 07/10/2023
 */

public class GeoWordle extends JFrame {
    //Displaying the interface (boxes + intro message)
    static String[] categories = new String[] {"Animals.txt", 
        "Capital Cities.txt", "Car brands.txt", 
        "Countries.txt", "Lakes.txt", "Mountain Ranges.txt",
        "Plants.txt", "Rivers.txt", "Seas.txt", "Volcanoes.txt"};
    
    public static int startCounter = 0;
    public static int chosenCategory = -1;
    
    /**
     * The method creates the Start menu window.
     */
    public static int startMenu() {
        //Displays a start menu
        StartLayout displayMenu = new StartLayout();
        displayMenu.main(categories);
        
        while (chosenCategory == -1) {
            chosenCategory = StartLayout.pickCategory;
            System.out.println(chosenCategory);
        }
        return chosenCategory;
    }

    /**
     * This method reads the category words from category file mentioned in startMenu.
     * It picks out a random word and creates a list to store all of the words
     * from the chosen category.
     */
    public static String secretWord(int chosenCategory) {
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

    public static JLabel resultLabel = new JLabel();
    public static String[] guessingProgress;
    
    /**
     * This method creates the gamewindow and its design.
     */
    public void gameWindow(String pickSecretWordy) { //Mantas
        //Displays the matrix, game name up top, GUESS button.
        //Interface
        guessingProgress = new String[targetWord.length()];
        JFrame frame = new JFrame("GeoWordle");
        frame.setLayout(new BorderLayout());
        GameWindowLayout gameWindow = 
            new GameWindowLayout(GameWindowLayout.createMatrix(pickSecretWordy));
        //Initial guessing progress output row of "-"
        String[] guessingProgress = new String[targetWord.length()];
        for (int i = 0; i < guessingProgress.length; i++) {
            guessingProgress[i] = "-";
        }
        String guessingProgressString = String.join(" ", guessingProgress);
        guessingProgressString = guessingProgressString.toUpperCase(getLocale());

        //Frame settings and matrix panel addition
        frame.setSize(700, 700); 
        JPanel matrixPanel = new JPanel();
        frame.add(matrixPanel, BorderLayout.NORTH);
        matrixPanel.add(gameWindow);
        frame.setResizable(false);

        //Disclaimer panel
        JPanel disclaimerPanel = new JPanel();
        JLabel disclaimerLabel = new JLabel("DO NOT LEAVE ANY EMPTY CELLS");
        disclaimerPanel.add(disclaimerLabel);
        frame.add(disclaimerPanel, BorderLayout.CENTER);

        //Guessing progress panel
        JPanel runPanel = new JPanel();
        resultLabel.setText("YOUR GUESSING PROGRESS: " + guessingProgressString);
        runPanel.add(resultLabel);
        frame.add(runPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
        StartLayout.frame.setVisible(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }

    /**
     * Attention window when empty row.
     */
    public void attention() {
        JFrame attention = new JFrame("Attention!");
        JLabel reminder = new JLabel("No empty rows!");
        attention.add(reminder);
        attention.setSize(250, 250);
        attention.setVisible(true);
    }
    
    public static int chosen = startMenu();
    public static String targetWord = secretWord(chosen);

    public static void main(String[] args) {
        new GeoWordle();
        GeoWordle.startMenu();
        new GeoWordle().gameWindow(targetWord);
    }
}