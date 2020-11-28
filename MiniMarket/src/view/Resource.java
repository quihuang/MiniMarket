package view;

import static java.lang.Integer.parseInt;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;

public class Resource {

    public static String transformFecha(String fecha) {

        String mes[] = {"Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov",
            "Dic"};
        String arr[] = fecha.split("-");
        int mesSelected = parseInt(arr[1]) - 1;
        String response = arr[2] + " de " + mes[mesSelected] + " del " + arr[0];
        return response;

    }

    public static void setSelectedCombobox(JComboBox select, String txt) {

        for (int i = 0; i < select.getModel().getSize(); i++) {
            if (select.getItemAt(i).toString().trim().equalsIgnoreCase(txt)) {
                select.setSelectedIndex(i);
                break;
            }
        }

    }

    public static void setSelectedRadioButton(ButtonGroup buttonGroup, String txt) {

        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.getText().trim().equalsIgnoreCase(txt)) {
                button.setSelected(true);
                break;
            }
        }

    }

}
