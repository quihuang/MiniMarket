package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.String.valueOf;
import javax.swing.JTextField;

public class JCardField extends JTextField implements KeyListener {

    public JCardField() {
        super(10);
        super.addKeyListener(this);

    }

    public void validateNumber(KeyEvent e) {

        String txt = valueOf(e.getKeyChar());

        if (!(txt.equals("0") || txt.equals("1") || txt.equals("2") || txt.equals("3")
                || txt.equals("4") || txt.equals("5") || txt.equals("6") || txt.equals("7")
                || txt.equals("8") || txt.equals("9") || e.getKeyCode() == 8)) {

            e.consume();

        } else {

            if (this.getText().length() % 5 == 0) {
                if (this.getText().length() < 20) {
                    this.setText(this.getText() + " ");
                } else {
                    e.consume();
                }
            }

        }

        if (!(txt.equals("0") || txt.equals("1") || txt.equals("2") || txt.equals("3")
                || txt.equals("4") || txt.equals("5") || txt.equals("6") || txt.equals("7")
                || txt.equals("8") || txt.equals("9"))) {

            char a[] = this.getText().toCharArray();
            if (a.length > 0) {
                if (a[a.length - 1] == ' ' && a.length > 1) {
                    this.setText(this.getText().substring(0, this.getText().length() - 1));
                }
            }

        }

    }

    public boolean isValido() {
        return this.getText().length() < 20;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        validateNumber(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
