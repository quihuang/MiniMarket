package view;

import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Font.CENTER_BASELINE;
import static java.awt.Frame.HAND_CURSOR;
import static java.awt.Image.SCALE_DEFAULT;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CerrarSesionView extends JPanel {

    JLabel Cerrar = new JLabel();
    JLabel img = new JLabel();

    private final int x = 120;
    private final int y = 40;

    public CerrarSesionView() {

        setSize(x, y);
        setLayout(null);

        Cerrar.setText("Salir");
        Cerrar.setLocation(50, 5);
        Cerrar.setSize(120, 30);
        Cerrar.setFont(new Font("Arial Black", CENTER_BASELINE, 20));
        Cerrar.setCursor(new Cursor(HAND_CURSOR));

        img.setSize(30, 30);
        img.setLocation(15, 5);
        ImageIcon imageminimize = new ImageIcon(getClass().getResource("/imagenes/desconectar.png"));
        Icon iconminimize = new ImageIcon(imageminimize.getImage().getScaledInstance(img.getWidth(), img.getHeight(), SCALE_DEFAULT));
        img.setIcon(iconminimize);
        img.setCursor(new Cursor(HAND_CURSOR));

        add(img);
        add(Cerrar);

    }

    public JLabel getCerrar() {
        return Cerrar;
    }

    public JLabel getImg() {
        return img;
    }

}
