import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * The class is used to create the Table functionality and improve user experience.
 * 
 * @author Dennis-Cristian Baractaru
 * @studentID <1956957>
 * @author Mantas Juškauskas
 * @studentID <1954733>
 * @date 07/10/2023
 */
public class FocusableTable extends JTable implements KeyListener {

    public int col = 0; //The currently focused column index.
    public int row = 0; //The currently focused row index.
    
    /**
     * Constructs a new `FocusableTable` with the specified `DefaultTableModel` as its
     * data model. This constructor initializes the table and sets up the necessary
     * configurations for keyboard input handling and cell editing.
     */
    public FocusableTable(DefaultTableModel model) {
        super(model);
        // Remove the default cell editor to allow custom cell editing behavior.
        this.setDefaultEditor(this.getColumnClass(0), null);
        // Add a KeyListener to this table for handling keyboard input.
        this.addKeyListener(this);
    }

    /**
     * Focuses the table and updates the cell selection to the current `row` and `col`.
     * This method is typically called when initiating cell editing.
     */
    public void handleInput() {
        this.requestFocusInWindow();

        this.changeSelection(row, col, true, true);
    }

    /**
     * Handles the keyTyped event when a key is pressed and released. It allows for
     * editing table cells by accepting alphanumeric characters and backspace.
     */
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == '\s') {
            return;
        }

        if (e.getKeyChar() == '\b') {
            this.setValueAt("", row, col);
            if (this.col == 0) {
                return;
            }

            this.col--;
            this.changeSelection(row, col, false, false);
            return;
        }

        this.setValueAt(e.getKeyChar(), row, col);
        if (this.col < this.getColumnCount() - 1) {
            this.col++;
        } 
        this.changeSelection(row, col, true, true);
    }

    //Unused key event handler.
    @Override
    public void keyPressed(KeyEvent e) {
        return;
    }
    
    //Unused key event handler.
    @Override
    public void keyReleased(KeyEvent e) {
        return;
    }
}
