package view;

import java.awt.Color;
import static java.awt.Color.orange;
import static java.awt.Color.white;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Font.BOLD;
import static java.awt.Font.CENTER_BASELINE;
import static java.awt.Frame.HAND_CURSOR;
import static java.awt.Image.SCALE_DEFAULT;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PagoTarjetaView extends JFrame {

    Container contenedor = getContentPane();
    JPanel main = new JPanel();
    JPanel img = new JPanel();

    JLabel Labeltitulo = new JLabel();
    JLabel Labeltitulo2 = new JLabel();
    JLabel aceptantarjetas = new JLabel();
    JLabel LabelPropietario = new JLabel();
    JLabel LabelNumTarjeta = new JLabel();
    JLabel LabelTipoTarjeta = new JLabel();
    JLabel visa = new JLabel();
    JLabel mastercard = new JLabel();
    JLabel americanExpress = new JLabel();
    JLabel LabelCVV = new JLabel();
    JLabel Labelfecha = new JLabel();
    JLabel mujerpago = new JLabel();
    JLabel pais = new JLabel();
    JLabel ciudad = new JLabel();
    JLabel direccion = new JLabel();
    JLabel codigoPostal = new JLabel();
    JLabel pagoseguro = new JLabel();

    JComboBox mes = new JComboBox();
    JComboBox año = new JComboBox();
    JComboBox tipoTarjeta = new JComboBox();

    JButton pagar = new JButton();
    JButton cancelar = new JButton();

    JTextField Fieldnombre = new JTextField();
    JTextField Fieldpais = new JTextField();
    JTextField Fieldciudad = new JTextField();
    JTextField Fielddireccion = new JTextField();
    JNumberField FieldcodigoPostal = new JNumberField();
    JCardField FieldNumber = new JCardField();
    JNumberField FieldCVV = new JNumberField();

    private final int x = 1135;
    private final int y = 800;

    public PagoTarjetaView() {

        setSize(x, y);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);

        main.setSize(x, y);
        main.setLocation(0, 0);
        main.setLayout(null);

        img.setSize(500, 800);
        img.setLocation(0, 0);
        img.setLayout(null);
        img.setBackground(Color.ORANGE);

        Labeltitulo.setSize(700, 50);
        Labeltitulo.setLocation(520, 10);
        Labeltitulo.setFont(new Font("Arial Black", BOLD, 32));
        Labeltitulo.setText("Agregar una tarjeta de crédito");

        Labeltitulo2.setSize(700, 50);
        Labeltitulo2.setLocation(520, 50);
        Labeltitulo2.setFont(new Font("Arial Black", BOLD, 32));
        Labeltitulo2.setText("o débito");

        aceptantarjetas.setSize(700, 50);
        aceptantarjetas.setLocation(520, 120);
        aceptantarjetas.setFont(new Font("Arial", BOLD, 20));
        aceptantarjetas.setText("Se aceptan las siguientes tarjetas : ");

        LabelPropietario.setSize(700, 50);
        LabelPropietario.setLocation(520, 250);
        LabelPropietario.setFont(new Font("Arial", BOLD, 23));
        LabelPropietario.setText("Nombre del titular de la tarjeta ");

        Fieldnombre.setSize(500, 40);
        Fieldnombre.setLocation(520, 300);
        Fieldnombre.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 23));

        LabelNumTarjeta.setSize(700, 50);
        LabelNumTarjeta.setLocation(520, 340);
        LabelNumTarjeta.setFont(new Font("Arial", BOLD, 23));
        LabelNumTarjeta.setText("Número de la tarjeta");

        FieldNumber.setSize(500, 40);
        FieldNumber.setLocation(520, 390);
        FieldNumber.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 23));

        Labelfecha.setSize(300, 50);
        Labelfecha.setLocation(520, 430);
        Labelfecha.setFont(new Font("Arial", BOLD, 23));
        Labelfecha.setText("Expira");

        mes.setSize(70, 30);
        mes.setLocation(520, 480);
        mes.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));
        mes.addItem("MES");

        for (int i = 1; i <= 12; i++) {
            mes.addItem(i);
        }

        año.setSize(70, 30);
        año.setLocation(610, 480);
        año.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));
        año.addItem("AÑO");

        for (int y = 22; y <= 70; y++) {
            año.addItem(y);
        }

        LabelCVV.setSize(80, 50);
        LabelCVV.setLocation(710, 430);
        LabelCVV.setFont(new Font("Arial", BOLD, 23));
        LabelCVV.setText("CVV");

        LabelTipoTarjeta.setSize(150, 50);
        LabelTipoTarjeta.setLocation(830, 430);
        LabelTipoTarjeta.setFont(new Font("Arial", BOLD, 23));
        LabelTipoTarjeta.setText("T. Tarjeta");

        tipoTarjeta.setSize(180, 30);
        tipoTarjeta.setLocation(830, 480);
        tipoTarjeta.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));
        tipoTarjeta.addItem("Seleccionar");

        tipoTarjeta.addItem(new JComboItem("2", "Debito"));
        tipoTarjeta.addItem(new JComboItem("3", "Credito"));

        FieldCVV.setSize(80, 30);
        FieldCVV.setLocation(710, 480);
        FieldCVV.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 23));

        pagar.setLocation(825, 740);
        pagar.setSize(280, 40);
        pagar.setBackground(orange);
        pagar.setForeground(white);
        pagar.setFocusable(false);
        pagar.setBorder(null);
        pagar.setFont(new Font("Arial Black", BOLD, 20));
        pagar.setText("Pagar");

        cancelar.setLocation(520, 740);
        cancelar.setSize(280, 40);
        cancelar.setBackground(orange);
        cancelar.setForeground(white);
        cancelar.setFocusable(false);
        cancelar.setBorder(null);
        cancelar.setFont(new Font("Arial Black", BOLD, 20));
        cancelar.setText("Cancelar");

        pais.setSize(700, 50);
        pais.setLocation(520, 520);
        pais.setFont(new Font("Arial", BOLD, 23));
        pais.setText("Pais");

        Fieldpais.setSize(250, 40);
        Fieldpais.setLocation(520, 570);
        Fieldpais.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 23));

        ciudad.setSize(700, 50);
        ciudad.setLocation(800, 520);
        ciudad.setFont(new Font("Arial", BOLD, 23));
        ciudad.setText("Ciudad");

        Fieldciudad.setSize(250, 40);
        Fieldciudad.setLocation(800, 570);
        Fieldciudad.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 23));

        direccion.setSize(700, 50);
        direccion.setLocation(520, 610);
        direccion.setFont(new Font("Arial", BOLD, 23));
        direccion.setText("Dirección");

        Fielddireccion.setSize(250, 40);
        Fielddireccion.setLocation(520, 660);
        Fielddireccion.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 23));

        codigoPostal.setSize(700, 50);
        codigoPostal.setLocation(800, 610);
        codigoPostal.setFont(new Font("Arial", BOLD, 23));
        codigoPostal.setText("Código postal");

        FieldcodigoPostal.setSize(250, 40);
        FieldcodigoPostal.setLocation(800, 660);
        FieldcodigoPostal.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 23));

        pagoseguro.setSize(200, 80);
        pagoseguro.setLocation(0, 719);
        ImageIcon imageCrearCateg = new ImageIcon(getClass().getResource("/imagenes/pagoseguro.png"));
        Icon iconCrearCateg = new ImageIcon(imageCrearCateg.getImage().getScaledInstance(pagoseguro.getWidth(), pagoseguro.getHeight(), SCALE_DEFAULT));
        pagoseguro.setIcon(iconCrearCateg);

        visa.setSize(60, 60);
        visa.setLocation(520, 180);
        ImageIcon imageCrearProduc = new ImageIcon(getClass().getResource("/imagenes/visa.png"));
        Icon iconCrearProduc = new ImageIcon(imageCrearProduc.getImage().getScaledInstance(visa.getWidth(), visa.getHeight(), SCALE_DEFAULT));
        visa.setIcon(iconCrearProduc);
        visa.setCursor(new Cursor(HAND_CURSOR));

        mastercard.setSize(60, 60);
        mastercard.setLocation(610, 180);
        ImageIcon imageCrearUsu = new ImageIcon(getClass().getResource("/imagenes/master.png"));
        Icon iconCrearUsu = new ImageIcon(imageCrearUsu.getImage().getScaledInstance(mastercard.getWidth(), mastercard.getHeight(), SCALE_DEFAULT));
        mastercard.setIcon(iconCrearUsu);
        mastercard.setCursor(new Cursor(HAND_CURSOR));

        americanExpress.setSize(60, 60);
        americanExpress.setLocation(700, 180);
        ImageIcon imageAdmin = new ImageIcon(getClass().getResource("/imagenes/american.png"));
        Icon iconAdmin = new ImageIcon(imageAdmin.getImage().getScaledInstance(americanExpress.getWidth(), americanExpress.getHeight(), SCALE_DEFAULT));
        americanExpress.setIcon(iconAdmin);
        americanExpress.setCursor(new Cursor(HAND_CURSOR));

        mujerpago.setSize(500, 800);
        mujerpago.setLocation(0, 0);
        ImageIcon imageminimize = new ImageIcon(getClass().getResource("/imagenes/mujerpago.png"));
        Icon iconminimize = new ImageIcon(imageminimize.getImage().getScaledInstance(mujerpago.getWidth(), mujerpago.getHeight(), SCALE_DEFAULT));
        mujerpago.setIcon(iconminimize);

        main.add(tipoTarjeta);
        main.add(LabelTipoTarjeta);
        main.add(FieldcodigoPostal);
        main.add(Fielddireccion);
        main.add(Fieldciudad);
        main.add(Fieldpais);
        main.add(codigoPostal);
        main.add(direccion);
        main.add(ciudad);
        main.add(pais);
        main.add(pagar);
        main.add(cancelar);
        main.add(FieldCVV);
        main.add(LabelCVV);
        main.add(año);
        main.add(mes);
        main.add(Labelfecha);
        main.add(FieldNumber);
        main.add(LabelNumTarjeta);
        main.add(Fieldnombre);
        main.add(LabelPropietario);
        main.add(americanExpress);
        main.add(mastercard);
        main.add(visa);
        main.add(aceptantarjetas);
        main.add(Labeltitulo2);
        main.add(Labeltitulo);
        img.add(pagoseguro);
        img.add(mujerpago);
        main.add(img);
        contenedor.add(main);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public JButton getPagar() {
        return pagar;
    }

    public JButton getCancelar() {
        return cancelar;
    }

    public JComboBox getMes() {
        return mes;
    }

    public JComboBox getAño() {
        return año;
    }

    public JTextField getFieldnombre() {
        return Fieldnombre;
    }

    public JTextField getFieldpais() {
        return Fieldpais;
    }

    public JTextField getFieldciudad() {
        return Fieldciudad;
    }

    public JTextField getFielddireccion() {
        return Fielddireccion;
    }

    public JNumberField getFieldcodigoPostal() {
        return FieldcodigoPostal;
    }

    public JCardField getFieldNumber() {
        return FieldNumber;
    }

    public JNumberField getFieldCVV() {
        return FieldCVV;
    }

    public JComboBox getTipoTarjeta() {
        return tipoTarjeta;
    }

}
