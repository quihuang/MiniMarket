package view;

import static java.awt.Color.orange;
import static java.awt.Color.white;
import java.awt.Font;
import static java.awt.Font.BOLD;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jdatepicker.impl.JDatePickerImpl;

public final class JDatePicker extends JDatePickerImpl implements ChangeListener {

    private final String defaultText = "Seleccionar Fecha";
    private String date;

    public JDatePicker() {
        super(JDatePickerSetting.getDatePanel(), JDatePickerSetting.getDateFormatter());
        super.setButtonFocusable(false);
        super.getJFormattedTextField().setForeground(white);
        super.getJFormattedTextField().setAlignmentX(10);
        super.getJFormattedTextField().setText(defaultText);
        super.getJFormattedTextField().setFont(new Font("Arial Black", BOLD, 12));
        super.getJFormattedTextField().setBorder(null);
        super.getJFormattedTextField().setHorizontalAlignment(JTextField.CENTER);
        super.getModel().addChangeListener(this);
        Border border = new LineBorder(orange, 1, false);
        super.setBorder(border);
        super.setBackground(orange);
        super.getJFormattedTextField().setBackground(orange);
    }

    public void setDate(String date) {

        String arr[] = date.split("-");
        super.getModel().setDate(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
        super.getJFormattedTextField().setText(super.getModel().getYear() + "-" + (super.getModel().getMonth() + 1) + "-" + super.getModel().getDay());
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDefaultText() {
        super.getJFormattedTextField().setText(defaultText);
        date = null;
    }

    public void setDefaultText(boolean is) {
        if (!is) {
            super.getJFormattedTextField().setText("");
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {

        String textDate = super.getModel().getYear() + "-" + (super.getModel().getMonth() + 1) + "-" + super.getModel().getDay();
        this.date = textDate;

    }

}
