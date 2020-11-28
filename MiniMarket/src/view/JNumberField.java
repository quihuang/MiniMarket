package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.String.valueOf;
import javax.swing.JTextField;

public class JNumberField extends JTextField implements KeyListener {

    boolean decimal = false;

    public JNumberField() {
        super();
        super.addKeyListener(this);

    }

    public JNumberField(boolean decimal) {
        super();
        super.addKeyListener(this);
        this.decimal = decimal;
    }

    public void validateNumber(KeyEvent e) {

        String txt = valueOf(e.getKeyChar());

        if (!decimal) {
            if (!(txt.equals("0") || txt.equals("1") || txt.equals("2") || txt.equals("3")
                    || txt.equals("4") || txt.equals("5") || txt.equals("6") || txt.equals("7")
                    || txt.equals("8") || txt.equals("9") || e.getKeyCode() == 8)) {

                e.consume();

            }
        } else {
            if (!(txt.equals("0") || txt.equals("1") || txt.equals("2") || txt.equals("3")
                    || txt.equals("4") || txt.equals("5") || txt.equals("6") || txt.equals("7")
                    || txt.equals("8") || txt.equals("9") || e.getKeyCode() == 8 || (txt.equals(".") && !this.getText().contains(".")))) {
                e.consume();

            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        validateNumber(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        validateNumber(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        validateNumber(e);
    }

}
