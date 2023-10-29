import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Start menu design.
 * 
 * @author Dennis-Cristian Baractaru
 * @studentID <1956957>
 * @author Mantas Juškauskas
 * @studentID <1954733>
 * @date 07/10/2023
 */
public class StartLayout extends JPanel {
    /**
     * Displaying the name of this game.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Defining fonts and colors for the result window design. 
        Font resultFont = new Font("", Font.BOLD, 50);
        Color geoColor = new Color(50, 205, 50);
        Color wordleColor = new Color(136, 8, 8);

        // Printing "GEOWORDLE" on the top of the window.
        g.setFont(resultFont);
        g.setColor(wordleColor);
        g.drawString("Wordle", 390, 95);
        
        g.setColor(geoColor);
        g.drawString("Geo", 285, 95);
    }
    
    /**
     * Constructor for application starting menu.
    */
    StartLayout() { 
        setLayout(new GridLayout(5, 2, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        buttonCreation();
    }

    public static int pickCategory = -1;
    /**
     * Create initial menu buttons.
     */
    public JButton modeAnimals = new JButton("Animals");
    public JButton modeCapitalCities = new JButton("Capital Cities");
    public JButton modeCarBrands = new JButton("Car Brands");
    public JButton modeCountries = new JButton("Countries");
    public JButton modeLakes = new JButton("Lakes");
    public JButton modeMountainRanges = new JButton("Mountain Ranges");
    public JButton modePlants = new JButton("Plants");
    public JButton modeRivers = new JButton("Rivers");
    public JButton modeSeas = new JButton("Seas");
    public JButton modeVolcanoes = new JButton("Volcanoes");

    /**
     * Creating buttons for the menu window and also making them work (after one of the 
     *  buttons is pressed new window opens).
     */
    public void buttonCreation() {
        //Boundaries
        modeAnimals.setBounds(200, 100, 100, 50);
        modeCapitalCities.setBounds(200, 100, 100, 50);
        modeCarBrands.setBounds(200, 100, 100, 50);
        modeCountries.setBounds(200, 100, 100, 50);
        modeLakes.setBounds(200, 100, 100, 50);
        modeMountainRanges.setBounds(200, 100, 100, 50);
        modePlants.setBounds(200, 100, 100, 50);
        modeRivers.setBounds(200, 100, 100, 50);
        modeSeas.setBounds(200, 100, 100, 50);
        modeVolcanoes.setBounds(200, 100, 100, 50);

        //Set all 10 buttons transparent for design.
        modeAnimals.setContentAreaFilled(true);
        modeCapitalCities.setContentAreaFilled(true);
        modeCarBrands.setContentAreaFilled(true);
        modeCountries.setContentAreaFilled(true);
        modeLakes.setContentAreaFilled(true);
        modeMountainRanges.setContentAreaFilled(true);
        modePlants.setContentAreaFilled(true);
        modeRivers.setContentAreaFilled(true);    
        modeSeas.setContentAreaFilled(true);
        modeVolcanoes.setContentAreaFilled(true);

        //Get rid of the borders around the textbox for design.
        modeAnimals.setFocusable(false);
        modeCapitalCities.setFocusable(false);
        modeCarBrands.setFocusable(false);
        modeCountries.setFocusable(false);
        modeLakes.setFocusable(false);
        modeMountainRanges.setFocusable(false);
        modePlants.setFocusable(false);
        modeRivers.setFocusable(false);
        modeSeas.setFocusable(false);
        modeVolcanoes.setFocusable(false);

        //Adding all buttons
        this.add(modeAnimals);
        this.add(modeCapitalCities);
        this.add(modeCarBrands);
        this.add(modeCountries);
        this.add(modeLakes);
        this.add(modeMountainRanges);
        this.add(modePlants);
        this.add(modeRivers);
        this.add(modeSeas);
        this.add(modeVolcanoes);

        //Adding functionality
        modeAnimals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pickCategory = 0;
                SwingUtilities.getWindowAncestor(StartLayout.this).dispose();
            }
        });
        modeCapitalCities.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pickCategory = 1;
                SwingUtilities.getWindowAncestor(StartLayout.this).dispose();
            }
        });
        modeCarBrands.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pickCategory = 2;
                SwingUtilities.getWindowAncestor(StartLayout.this).dispose();
            }
        });
        modeCountries.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pickCategory = 3;
                SwingUtilities.getWindowAncestor(StartLayout.this).dispose();
            }
        });
        modeLakes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pickCategory = 4;
                SwingUtilities.getWindowAncestor(StartLayout.this).dispose();
            }
        });
        modeMountainRanges.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pickCategory = 5;
                SwingUtilities.getWindowAncestor(StartLayout.this).dispose();
            }
        });
        modePlants.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pickCategory = 6;
                SwingUtilities.getWindowAncestor(StartLayout.this).dispose();
            }
        });
        modeRivers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pickCategory = 7;
                SwingUtilities.getWindowAncestor(StartLayout.this).dispose();
            }
        });
        modeSeas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pickCategory = 8;
                SwingUtilities.getWindowAncestor(StartLayout.this).dispose();
            }
        });
        modeVolcanoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pickCategory = 9;
                SwingUtilities.getWindowAncestor(StartLayout.this).dispose();
            }
        });
    }

    int startCounter = 0;
    public static JFrame frame = new JFrame("GeoWordle");

    public void main(String[] args) {
        
        StartLayout panel = new StartLayout();
        
        //Frame parameters
        Color backgroundColor = new Color(0, 0, 0);
        modeAnimals.setForeground(Color.red);
        panel.setBackground(backgroundColor);
        frame.add(panel);
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startCounter++;
    }
}
