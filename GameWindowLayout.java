import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Game window design.
 * 
 * @author Dennis-Cristian Baractaru
 * @studentID <1956957>
 * @author Mantas Juškauskas
 * @studentID <1954733>
 * @date 07/10/2023
 */
public class GameWindowLayout extends JPanel {
    public FocusableTable table;
    int attempts = 0; // User guess attempts.
    public static String targetWord; // This is secretWord.
    public static String guessString = ""; // This is a guess word.
    public static String[] guesses = new String[6]; // Guess array.
    public static long windowOpenTime = System.currentTimeMillis();
    public static long windowRunTime = 0;


    // Allowing user to only edit rows that match his attempt number.
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            if (row != attempts) {
                return false;
            }
            return true;
        }
    };

    /**
    * Constructor for application game window.
    */
    public GameWindowLayout(String[][] matrix) {
        // Matrix size X and Y
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        // Setting up a table according to the secret word length and game rules.
        model.setRowCount(rows);
        model.setColumnCount(columns);
        
        // Creating a JTable instance and adjusting settings to make the design better.
        table = new FocusableTable(model);
        table.setTableHeader(null); // Removing table header. It doesn't fit with the design.
        table.setRowHeight(70); // Setting row height.
        table.handleInput();

        // Used to display table.
        JScrollPane pane = new JScrollPane(table);
        
        //Setting borders.
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        add(pane);

        //Guess button creation
        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);
        JButton submitButton = new JButton("GUESS");
        submitButton.setPreferredSize(new Dimension(100, 70));
        buttonPanel.add(submitButton);

        // Button action and response
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(attempts);
                if (guessString.equals("")) {
                    reading();
                    progress();
                }
                //Recursion until all attempts are used up.
                if (attempts < 6 && !((targetWord.toLowerCase()).equals(guessString))) {
                    reading();
                    progress();
                    //Saving previous guesses
                    guesses[attempts] = guessString;  
                    attempts++;
                    table.row++;
                    table.col = 0;
                    table.changeSelection(table.row, table.col, true, true);
                    table.requestFocus();
                }
                //Defeat condition for DEFEAT.
                if (attempts >= 6 && !((targetWord.toLowerCase()).equals(guessString))) {
                    System.out.println("DEFEAT WINDOW APPEARS");
                    SwingUtilities.getWindowAncestor(GameWindowLayout.this).dispose();
                    windowRunTime = System.currentTimeMillis() - windowOpenTime;
                    windowRunTime = (System.currentTimeMillis() - windowOpenTime) / 1000;
                    VicotryWindow.mode = "defeat";
                    new VicotryWindow();
                    VicotryWindow.main(guesses);
                }
                //Victory condition for VICTORY.
                if ((targetWord.toLowerCase()).equals(guessString)) {
                    System.out.println("VICTORY WINDOW APPEARS");
                    SwingUtilities.getWindowAncestor(GameWindowLayout.this).dispose();
                    windowRunTime = (System.currentTimeMillis() - windowOpenTime) / 1000;
                    if (attempts == 0) {
                        guesses[attempts] = guessString; 
                    } 
                    System.out.println("Run time: " + windowRunTime);
                    VicotryWindow.mode = "victory";
                    new VicotryWindow();
                    VicotryWindow.main(guesses);

                }
            }
        });
    }

    public String[] rowData; //Stores user's row input.

    /**
     * This method reads the user input.
     */
    String reading() {
        String contents = "";
        for (int i = 0; i < table.getColumnCount(); i++) {
            contents += table.getValueAt(table.row, i);
        }

        guessString = contents.toLowerCase();
        return guessString;
    }

    /**
    * The method splits the secret word into a character array.
    */
    public char[] splitSecretWord() {
        char[] secretWordArray = new char[targetWord.length()];
        for (int i = 0; i < targetWord.length(); i++) {
            secretWordArray[i] = targetWord.toUpperCase(getLocale()).charAt(i);
        }
        return secretWordArray;
    }

    /**
     * The method splits user's guess into a character array.
     */
    public char[] splitGuess() {
        char[] guessStringArray = new char[guessString.length()];
        for (int i = 0; i < guessString.length(); i++) {
            guessStringArray[i] = guessString.toUpperCase(getLocale()).charAt(i);
        }
        return guessStringArray;
    }
    
    /**
     * The method updates the user's guessing progress hints based on his previous guesses.
     * It provides the user with a "Your Guessing Progress:" section.
     * After each correct letter and position input, the specific position in guessing progress
     * changes from "-" to the letter.
     */
    public void progress() {
        String[] guessingProgress = GeoWordle.guessingProgress;
        for (int i = 0; i < targetWord.length(); ++i) {
            System.out.print(guessingProgress[i] + " ");
        }
        char[] guessStringArray = splitGuess();
        char[] secretWordArray = splitSecretWord();
        for (int i = 0; i < targetWord.length(); ++i) {
            System.out.println("guessStringArray = " + guessStringArray[i]);
            System.out.println("secretWordArray = " + secretWordArray[i]);
        }
        for (int i = 0; i < guessStringArray.length; ++i) {
            if (guessStringArray[i] == secretWordArray[i]) {
                guessingProgress[i] = String.valueOf(secretWordArray[i]);
            }
        }
        
        for (int i = 0; i < targetWord.length(); i++) {
            if (guessingProgress[i] == null) {
                guessingProgress[i] = "-";
            }
            System.out.print(guessStringArray[i]);
        }
        String guessingProgressString = String.join(" ", guessingProgress);
        guessingProgressString = guessingProgressString.toUpperCase(getLocale());
        GeoWordle.resultLabel.setText("YOUR GUESSING PROGRESS: " + guessingProgressString);
    }

    /**
     *  Method that creates a matrix based on the length of the secret word and game rules.
     **/ 
    static String[][] createMatrix(String pickSecretWordy) {
        targetWord = pickSecretWordy;
        int rowLenght = 6; // According to the game rules.
        int columns = pickSecretWordy.length(); // Secret word length is equal to the column number.
        String[][] wordData = new String[rowLenght][columns];
        for (int i = 0; i < rowLenght; i++) { // Creating game matrix.
            for (int j = 0; j < columns; j++) {
                wordData[i][j] = " ";
            }
        }
        return wordData;
    }

    

    public static void main(String[] args) {
        
    }
}
