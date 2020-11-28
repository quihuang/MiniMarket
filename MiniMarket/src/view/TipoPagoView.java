package view;

import java.awt.Color;
import static java.awt.Color.WHITE;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Font.BOLD;
import static java.awt.Frame.HAND_CURSOR;
import static java.awt.Image.SCALE_DEFAULT;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.SwingConstants.CENTER;

public class TipoPagoView extends JFrame {

    Container contenedor = getContentPane();
    JPanel main = new JPanel();
    JPanel fondoT = new JPanel();

    JLabel PicEfectivo = new JLabel();
    JLabel PicTarjeta = new JLabel();
    JLabel PicCancel = new JLabel();
    JLabel minimize = new JLabel();
    JLabel close = new JLabel();
    JLabel titulo = new JLabel();
    JLabel fondo = new JLabel();

    JLabel TextEfectivo = new JLabel();
    JLabel TextTarjeta = new JLabel();
    JLabel TextCancelar = new JLabel();

    private final int x = 1430;
    private final int y = 900;

    public TipoPagoView() {

        setSize(x, y);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);

        fondoT.setSize(x, y);
        fondoT.setLocation(0, 0);
        fondoT.setLayout(null);

        main.setSize(600, 400);
        main.setLocation(400, 250);
        main.setLayout(null);
        main.setBackground(Color.orange);

        titulo.setForeground(WHITE);
        titulo.setSize(300, 40);
        titulo.setLocation(0, 20);
        titulo.setHorizontalAlignment(CENTER);
        titulo.setFont(new Font("Arial Black", BOLD, 32));
        titulo.setText("Tipo de Pago");

        fondo.setSize(1430, 900);
        fondo.setLocation(0, 0);
        ImageIcon imageCrearCateg = new ImageIcon(getClass().getResource("/imagenes/fondoTransparente.png"));
        Icon iconCrearCateg = new ImageIcon(imageCrearCateg.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), SCALE_DEFAULT));
        fondo.setIcon(iconCrearCateg);

        PicEfectivo.setSize(70, 70);
        PicEfectivo.setLocation(100, 100);
        ImageIcon imageAdmin = new ImageIcon(getClass().getResource("/imagenes/efectivo.png"));
        Icon iconAdmin = new ImageIcon(imageAdmin.getImage().getScaledInstance(PicEfectivo.getWidth(), PicEfectivo.getHeight(), SCALE_DEFAULT));
        PicEfectivo.setIcon(iconAdmin);
        PicEfectivo.setCursor(new Cursor(HAND_CURSOR));

        TextEfectivo.setForeground(WHITE);
        TextEfectivo.setSize(250, 80);
        TextEfectivo.setLocation(150, 95);
        TextEfectivo.setHorizontalAlignment(CENTER);
        TextEfectivo.setFont(new Font("Arial Black", BOLD, 30));
        TextEfectivo.setText("Efectivo");
        TextEfectivo.setCursor(new Cursor(HAND_CURSOR));

        PicTarjeta.setSize(70, 70);
        PicTarjeta.setLocation(100, 200);
        ImageIcon imageCrearUsu = new ImageIcon(getClass().getResource("/imagenes/tarjeta.png"));
        Icon iconCrearUsu = new ImageIcon(imageCrearUsu.getImage().getScaledInstance(PicTarjeta.getWidth(), PicTarjeta.getHeight(), SCALE_DEFAULT));
        PicTarjeta.setIcon(iconCrearUsu);
        PicTarjeta.setCursor(new Cursor(HAND_CURSOR));

        TextTarjeta.setForeground(WHITE);
        TextTarjeta.setSize(450, 80);
        TextTarjeta.setLocation(110, 195);
        TextTarjeta.setHorizontalAlignment(CENTER);
        TextTarjeta.setFont(new Font("Arial Black", BOLD, 30));
        TextTarjeta.setText("Tarjeta Credito");
        TextTarjeta.setCursor(new Cursor(HAND_CURSOR));

        PicCancel.setSize(70, 70);
        PicCancel.setLocation(100, 300);
        ImageIcon imageCrearProduc = new ImageIcon(getClass().getResource("/imagenes/cancelar.png"));
        Icon iconCrearProduc = new ImageIcon(imageCrearProduc.getImage().getScaledInstance(PicCancel.getWidth(), PicCancel.getHeight(), SCALE_DEFAULT));
        PicCancel.setIcon(iconCrearProduc);
        PicCancel.setCursor(new Cursor(HAND_CURSOR));

        TextCancelar.setForeground(WHITE);
        TextCancelar.setSize(250, 80);
        TextCancelar.setLocation(150, 295);
        TextCancelar.setHorizontalAlignment(CENTER);
        TextCancelar.setFont(new Font("Arial Black", BOLD, 30));
        TextCancelar.setText("Cancelar");
        TextCancelar.setCursor(new Cursor(HAND_CURSOR));

        close.setSize(20, 20);
        close.setLocation(560, 20);
        ImageIcon imageclose = new ImageIcon(getClass().getResource("/imagenes/Cerrar.png"));
        Icon iconclose = new ImageIcon(imageclose.getImage().getScaledInstance(close.getWidth(), close.getHeight(), SCALE_DEFAULT));
        close.setIcon(iconclose);
        close.setCursor(new Cursor(HAND_CURSOR));

        minimize.setSize(20, 20);
        minimize.setLocation(530, 20);
        ImageIcon imageminimize = new ImageIcon(getClass().getResource("/imagenes/minimizar.png"));
        Icon iconminimize = new ImageIcon(imageminimize.getImage().getScaledInstance(minimize.getWidth(), minimize.getHeight(), SCALE_DEFAULT));
        minimize.setIcon(iconminimize);
        minimize.setCursor(new Cursor(HAND_CURSOR));

        main.add(titulo);
        main.add(close);
        main.add(minimize);
        main.add(TextTarjeta);
        main.add(TextCancelar);
        main.add(TextEfectivo);
        main.add(PicCancel);
        main.add(PicTarjeta);
        main.add(PicEfectivo);
        fondoT.add(main);
        fondoT.add(fondo);
        contenedor.add(fondoT);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public JLabel getPicEfectivo() {
        return PicEfectivo;
    }

    public JLabel getPicTarjeta() {
        return PicTarjeta;
    }

    public JLabel getPicCancel() {
        return PicCancel;
    }

    public JLabel getMinimize() {
        return minimize;
    }

    public JLabel getClose() {
        return close;
    }

    public JLabel getTextEfectivo() {
        return TextEfectivo;
    }

    public JLabel getTextTarjeta() {
        return TextTarjeta;
    }

    public JLabel getTextCancelar() {
        return TextCancelar;
    }
}
