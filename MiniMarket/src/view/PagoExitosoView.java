package view;

import java.awt.Color;
import static java.awt.Color.white;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Font.BOLD;
import static java.awt.Frame.HAND_CURSOR;
import static java.awt.Image.SCALE_DEFAULT;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PagoExitosoView extends JFrame {

    Container contenedor = getContentPane();
    JPanel main = new JPanel();
    JPanel fondoT = new JPanel();

    JLabel PicPagoExitoso = new JLabel();
    JLabel fondo = new JLabel();
    JLabel ver = new JLabel();
    JLabel descargar = new JLabel();

    JButton Ok = new JButton();

    private final int x = 1430;
    private final int y = 900;

    public PagoExitosoView() {

        setSize(x, y);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);

        fondoT.setSize(x, y);
        fondoT.setLocation(0, 0);
        fondoT.setLayout(null);

        main.setSize(800, 800);
        main.setLocation(300, 50);
        main.setLayout(null);
        main.setBackground(Color.orange);

        Ok.setLocation(300, 400);
        Ok.setSize(200, 50);
        Ok.setBackground(Color.darkGray);
        Ok.setForeground(white);
        Ok.setFocusable(false);
        Ok.setBorder(null);
        Ok.setFont(new Font("Arial Black", BOLD, 30));
        Ok.setText("Aceptar");

        fondo.setSize(1430, 900);
        fondo.setLocation(0, 0);
        ImageIcon imageCrearCateg = new ImageIcon(getClass().getResource("/imagenes/fondoTransparente.png"));
        Icon iconCrearCateg = new ImageIcon(imageCrearCateg.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), SCALE_DEFAULT));
        fondo.setIcon(iconCrearCateg);

        PicPagoExitoso.setSize(600, 239);
        PicPagoExitoso.setLocation(100, 100);
        ImageIcon imageCrearProduc = new ImageIcon(getClass().getResource("/imagenes/PagoExitoso.png"));
        Icon iconCrearProduc = new ImageIcon(imageCrearProduc.getImage().getScaledInstance(PicPagoExitoso.getWidth(), PicPagoExitoso.getHeight(), SCALE_DEFAULT));
        PicPagoExitoso.setIcon(iconCrearProduc);

        ver.setSize(120, 160);
        ver.setLocation(200, 550);
        ImageIcon imageAdmin = new ImageIcon(getClass().getResource("/imagenes/ver.png"));
        Icon iconAdmin = new ImageIcon(imageAdmin.getImage().getScaledInstance(ver.getWidth(), ver.getHeight(), SCALE_DEFAULT));
        ver.setIcon(iconAdmin);
        ver.setCursor(new Cursor(HAND_CURSOR));

        descargar.setSize(120, 160);
        descargar.setLocation(450, 550);
        ImageIcon imageHacerPedido = new ImageIcon(getClass().getResource("/imagenes/descargar.png"));
        Icon iconHacerPedido = new ImageIcon(imageHacerPedido.getImage().getScaledInstance(descargar.getWidth(), descargar.getHeight(), SCALE_DEFAULT));
        descargar.setIcon(iconHacerPedido);
        descargar.setCursor(new Cursor(HAND_CURSOR));

        main.add(descargar);
        main.add(ver);
        main.add(Ok);
        main.add(PicPagoExitoso);
        fondoT.add(main);
        fondoT.add(fondo);
        contenedor.add(fondoT);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public JButton getOk() {
        return Ok;
    }

    public JLabel getVer() {
        return ver;
    }

    public void setVer(JLabel ver) {
        this.ver = ver;
    }

    public JLabel getDescargar() {
        return descargar;
    }

    public void setDescargar(JLabel descargar) {
        this.descargar = descargar;
    }

}
