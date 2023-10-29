import java.awt.*;
import java.util.Timer;
import javax.swing.*;

class ResultPanel extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Defining fonts and colors for the result window design. 
        Font resultFont = new Font("", Font.BOLD, 50);
        Font wordleFont = new Font("", Font.BOLD, 30);
        Font guessFont = new Font("", Font.ITALIC, 30);
        Color victoryColor = new Color(50, 205, 50);
        Color defeatColor = new Color(136, 8, 8);
        Color wordleColor = new Color(200, 182, 83);

        // Printing game statistics.
        VicotryWindow getMode = new VicotryWindow();
        String modeParameter = getMode.returnMode();
        System.out.println("Mode: " + modeParameter);
        g.setFont(resultFont);
        if (modeParameter == "defeat") {
            g.setColor(defeatColor);
            g.drawString("DEFEAT", 155, 95);
        }
        if (modeParameter == "victory") {
            g.setColor(victoryColor);
            g.drawString("VICTORY", 155, 95);
            System.out.println(modeParameter);
        }
        
        g.setColor(wordleColor);
        g.setFont(wordleFont);
        g.drawString("PROGRAM RUNTIME: " + String.valueOf(GameWindowLayout.windowRunTime) 
            + " SECONDS", 25, 175);
        g.drawString("SECRET WORD: ", 25, 225);
        g.setColor(Color.white);
        g.setFont(guessFont);
        String secretWord = GameWindowLayout.targetWord;
        g.drawString(secretWord.toUpperCase(), 285, 225); 
        g.setFont(wordleFont);
        g.setColor(wordleColor);

        // Printing previous guesses.
        g.drawString("YOUR PREVIOUS GUESSES: ", 25, 275);
        g.setColor(Color.white);
        String[] guesses = GameWindowLayout.guesses;
        int length = guesses.length;
        int slider = 0;
        for (int i = 0; i < length; i++) {
            if (guesses[i] != null) {
                slider += 35;
                g.drawString("#", 30 + slider, 315 + i * 30);
                g.drawString(guesses[i], 50 + slider, 315 + i * 30);
            }
        }
    }
}

/**
 * Game results design.
 */
public class VicotryWindow {
    public static String mode;

    public String returnMode() {
        return mode;
    }

    JFrame frame;
    ResultPanel resultPanel;
    Timer timer;

    /**
     * Creating result window.
     */
    void resultWindow() {
        frame = new JFrame("GeoWordle");
        resultPanel = new ResultPanel();
        Color backgroundColor = new Color(0, 0, 0);
        resultPanel.setBackground(backgroundColor);
        frame.add(resultPanel);
        frame.setSize(580, 580);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new VicotryWindow().resultWindow();
        
    }
}