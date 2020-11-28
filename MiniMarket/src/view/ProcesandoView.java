package view;

import java.awt.Container;
import static java.awt.Image.SCALE_DEFAULT;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProcesandoView extends JFrame {

    Container contenedor = getContentPane();
    JPanel main = new JPanel();
    JLabel procesando = new JLabel();

    private final int x = 760;
    private final int y = 200;

    public ProcesandoView() {

        setSize(x, y);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);

        procesando.setSize(x, y);
        procesando.setLocation(0, 0);
        ImageIcon imageProcesando = new ImageIcon(getClass().getResource("/imagenes/loading.gif"));
        Icon iconProcesando = new ImageIcon(imageProcesando.getImage().getScaledInstance(procesando.getWidth(), procesando.getHeight(), SCALE_DEFAULT));
        procesando.setIcon(iconProcesando);

        contenedor.add(procesando);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

}
