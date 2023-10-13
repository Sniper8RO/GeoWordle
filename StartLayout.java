import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.net.URL;

/**
 * Start menu design.
 */


public class StartLayout extends JPanel {

    /**
     * Constructor.
    */
    ImageIcon backgroundGif;
    StartLayout() { 
        setLayout(new GridLayout(5, 2, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        buttonCreation();

        URL background = getClass().getResource("circle.gif");
        backgroundGif = new ImageIcon(background);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = getWidth() / 4;
        int y = getHeight() / 4;
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        g.drawImage(backgroundGif.getImage(), x, y, width, height, this);
    }
    /**
     * Create initial menu buttons.
     */
    public void buttonCreation() {
        JButton modeAnimals = new JButton("Animals");
        JButton modeCapitalCities = new JButton("Capital Cities");
        JButton modeCarBrands = new JButton("Car Brands");
        JButton modeCountries = new JButton("Countries");
        JButton modeLakes = new JButton("Lakes");
        JButton modeMountainRanges = new JButton("Mountain Ranges");
        JButton modePlants = new JButton("Plants");
        JButton modeRivers = new JButton("Rivers");
        JButton modeSeas = new JButton("Seas");
        JButton modeVolcanoes = new JButton("Volcanoes");

        modeAnimals.setContentAreaFilled(false);
        modeCapitalCities.setContentAreaFilled(false);
        modeCarBrands.setContentAreaFilled(false);
        modeCountries.setContentAreaFilled(false);
        modeLakes.setContentAreaFilled(false);
        modeMountainRanges.setContentAreaFilled(false);
        modePlants.setContentAreaFilled(false);
        modeRivers.setContentAreaFilled(false);    
        modeSeas.setContentAreaFilled(false);
        modeVolcanoes.setContentAreaFilled(false);

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
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GeoWordle");
        StartLayout panel = new StartLayout();

        frame.add(panel);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
