package view;

import java.awt.*;
import static java.awt.Color.WHITE;
import static java.awt.Color.orange;
import static java.awt.Color.red;
import static java.awt.Font.BOLD;
import static java.awt.Image.SCALE_DEFAULT;
import java.awt.event.*;
import static java.lang.System.exit;
import javax.swing.*;
import static javax.swing.SwingConstants.CENTER;

public class LoginView extends JFrame implements MouseListener {

    Container contenedor = getContentPane();

    //PANELES 
    JPanel background = new JPanel();
    JPanel mainPanelLogo = new JPanel();
    JPanel mainPanel = new JPanel();

    //ETIQUETAS 
    JLabel fondobackground = new JLabel();
    JLabel logo = new JLabel();
    JLabel title = new JLabel();
    JLabel title2 = new JLabel();
    JLabel PicUser = new JLabel();
    JLabel PicPass = new JLabel();
    JLabel labelError = new JLabel();
    JLabel minimize = new JLabel();
    JLabel close = new JLabel();

    //CAJA DE TEXTO
    JNumberField fieldUser = new JNumberField();
    JPasswordField fieldPass = new JPasswordField();

    JTextField iniUser = new JTextField();
    JTextField iniPass = new JTextField();

    //BOTONES
    JButton buttonSubmit = new JButton();

    //VARIAVLES
    private final int x = 1280;
    private final int y = 800;

    public LoginView() {

        setSize(x, y);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);

        //Diseño
        background.setSize(x, y);
        background.setLocation(0, 0);
        background.setLayout(null);

        fondobackground.setSize(x, y);
        fondobackground.setLocation(0, 0);
        ImageIcon imagefondobackground = new ImageIcon(getClass().getResource("/imagenes/fondoverduras.jpg"));
        Icon iconfondobackground = new ImageIcon(imagefondobackground.getImage().getScaledInstance(fondobackground.getWidth(), fondobackground.getHeight(), SCALE_DEFAULT));
        fondobackground.setIcon(iconfondobackground);

        logo.setSize(400, 400);
        logo.setLocation(0, 60);
        ImageIcon imagelogo = new ImageIcon(getClass().getResource("/imagenes/logo.png"));
        Icon iconlogo = new ImageIcon(imagelogo.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), SCALE_DEFAULT));
        logo.setIcon(iconlogo);

        mainPanel.setSize(400, 500);
        mainPanel.setLayout(null);
        mainPanel.setLocation(250, 145);
        mainPanel.setBackground(WHITE);

        mainPanelLogo.setSize(400, 500);
        mainPanelLogo.setLayout(null);
        mainPanelLogo.setLocation(650, 145);
        mainPanelLogo.setBackground(orange);

        //Titulotext
        title.setForeground(new Color(56, 17, 70));
        title.setSize(330, 30);
        title.setLocation(55, 60);
        title.setFont(new Font("Rubik Black", BOLD, 22));
        title.setText("BIENVENIDO A MINIMARKET");

        title2.setForeground(new Color(56, 17, 70));
        title2.setSize(330, 30);
        title2.setLocation(170, 100);
        title2.setFont(new Font("Rubik Black", BOLD, 22));
        title2.setText("SING IN");

        //CedulaImage
        PicUser.setSize(40, 40);
        PicUser.setLocation(50, 195);
        ImageIcon imagePicUser = new ImageIcon(getClass().getResource("/imagenes/usuario.png"));
        Icon iconPicUser = new ImageIcon(imagePicUser.getImage().getScaledInstance(PicUser.getWidth(), PicUser.getHeight(), SCALE_DEFAULT));
        PicUser.setIcon(iconPicUser);

        //ContraseñaImage      
        PicPass.setSize(40, 40);
        PicPass.setLocation(50, 275);
        ImageIcon imagePicPass = new ImageIcon(getClass().getResource("/imagenes/candado.png"));
        Icon iconPicPass = new ImageIcon(imagePicPass.getImage().getScaledInstance(PicPass.getWidth(), PicPass.getHeight(), SCALE_DEFAULT));
        PicPass.setIcon(iconPicPass);

        //Caja texto Cedula
        iniUser.setSize(200, 35);
        iniUser.setLocation(110, 200);
        iniUser.setBorder(null);
        iniUser.setBackground(new Color(221, 221, 221));
        iniUser.setFont(new Font("Rubik Black", BOLD, 20));
        iniUser.setText("Cedula");
        iniUser.setForeground(WHITE);
        iniUser.setEditable(false);
        iniUser.setHorizontalAlignment(CENTER);
        iniUser.addMouseListener(this);

        fieldUser.setSize(200, 35);
        fieldUser.setLocation(110, 200);
        fieldUser.setBorder(null);
        fieldUser.setBackground(new Color(221, 221, 221));
        fieldUser.setFont(new Font("Rubik Black", BOLD, 20));
        fieldUser.setForeground(WHITE);
        fieldUser.setHorizontalAlignment(CENTER);
        fieldUser.addMouseListener(this);

        //Caja texto Password
        iniPass.setSize(200, 35);
        iniPass.setLocation(110, 277);
        iniPass.setBorder(null);
        iniPass.setBackground(new Color(221, 221, 221));
        iniPass.setFont(new Font("Rubik Black", BOLD, 20));
        iniPass.setText("Contraseña");
        iniPass.setForeground(WHITE);
        iniPass.setEditable(false);
        iniPass.setHorizontalAlignment(CENTER);
        iniPass.addMouseListener(this);

        fieldPass.setSize(200, 35);
        fieldPass.setLocation(110, 277);
        fieldPass.setBorder(null);
        fieldPass.setBackground(new Color(221, 221, 221));
        fieldPass.setFont(new Font("Rubik Black", BOLD, 20));
        fieldPass.setForeground(WHITE);
        fieldPass.setHorizontalAlignment(CENTER);
        fieldPass.addMouseListener(this);

        //Etiq Boton enviar
        buttonSubmit.setSize(110, 40);
        buttonSubmit.setLocation(155, 380);
        buttonSubmit.setText("Iniciar sesion");
        buttonSubmit.setBackground(new Color(255, 190, 1));
        buttonSubmit.setOpaque(true);
        buttonSubmit.setCursor(new Cursor(HAND_CURSOR));
        buttonSubmit.setHorizontalAlignment(CENTER);
        buttonSubmit.setForeground(WHITE);
        buttonSubmit.addMouseListener(this);
        buttonSubmit.setFocusPainted(false);
        buttonSubmit.setBorder(null);
        buttonSubmit.setFont(new Font("Rubik Black", BOLD, 15));

        //textError
        labelError.setSize(280, 30);
        labelError.setLocation(65, 330);
        labelError.setHorizontalAlignment(CENTER);
        labelError.setFont(new Font("Segoe UI Light", BOLD, 15));
        labelError.setForeground(red);

        close.setSize(20, 20);
        close.setLocation(1230, 20);
        ImageIcon imageclose = new ImageIcon(getClass().getResource("/imagenes/Cerrar.png"));
        Icon iconclose = new ImageIcon(imageclose.getImage().getScaledInstance(close.getWidth(), close.getHeight(), SCALE_DEFAULT));
        close.setIcon(iconclose);
        close.setCursor(new Cursor(HAND_CURSOR));
        close.addMouseListener(this);

        minimize.setSize(20, 20);
        minimize.setLocation(1200, 20);
        ImageIcon imageminimize = new ImageIcon(getClass().getResource("/imagenes/minimizar.png"));
        Icon iconminimize = new ImageIcon(imageminimize.getImage().getScaledInstance(minimize.getWidth(), minimize.getHeight(), SCALE_DEFAULT));
        minimize.setIcon(iconminimize);
        minimize.setCursor(new Cursor(HAND_CURSOR));
        minimize.addMouseListener(this);

        //Agregar
        background.add(minimize);
        background.add(close);
        mainPanel.add(labelError);
        mainPanelLogo.add(logo);
        mainPanel.add(buttonSubmit);
        mainPanel.add(iniPass);
        mainPanel.add(iniUser);
        mainPanel.add(PicUser);
        mainPanel.add(PicPass);
        mainPanel.add(title2);
        mainPanel.add(title);
        background.add(mainPanelLogo);
        background.add(mainPanel);
        background.add(fondobackground);
        contenedor.add(background);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == minimize) {
            setState(ICONIFIED);
        }
        if (me.getSource() == close) {
            exit(0);
        }

    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getSource() == buttonSubmit) {
            buttonSubmit.setBackground(new Color(255, 190, 1));
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (me.getSource() == buttonSubmit) {
            buttonSubmit.setBackground(new Color(255, 190, 1));
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {

        if (me.getSource() == buttonSubmit) {
            buttonSubmit.setBackground(orange);
        }

        if (me.getSource() == iniUser) {

            iniUser.setVisible(false);

            mainPanel.invalidate();
            mainPanel.validate();
            mainPanel.repaint();

            mainPanel.add(fieldUser);
        }

        if (me.getSource() == iniPass) {

            iniPass.setVisible(false);

            mainPanel.invalidate();
            mainPanel.validate();
            mainPanel.repaint();

            mainPanel.add(fieldPass);
        }

    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == buttonSubmit) {
            buttonSubmit.setBackground(new Color(255, 190, 1));
        }

        if (me.getSource() == fieldUser) {

            if (fieldUser.getText().isEmpty()) {

                iniUser.setVisible(true);

                mainPanel.invalidate();
                mainPanel.validate();
                mainPanel.repaint();

                mainPanel.remove(fieldUser);
            }
        }

        if (me.getSource() == fieldPass) {

            if (fieldPass.getText().isEmpty()) {

                iniPass.setVisible(true);

                mainPanel.invalidate();
                mainPanel.validate();
                mainPanel.repaint();

                mainPanel.remove(fieldPass);
            }
        }

    }

    public void setLabelError(String labelError) {
        this.labelError.setText(labelError);
    }

    public JTextField getFieldUser() {
        return fieldUser;
    }

    public JPasswordField getFieldPass() {
        return fieldPass;
    }

    public JButton getButtonSubmit() {
        return buttonSubmit;
    }
}
