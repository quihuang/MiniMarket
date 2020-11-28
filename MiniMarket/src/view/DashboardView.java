package view;

import controller.DashboardController;
import java.awt.*;
import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static java.awt.Color.orange;
import static java.awt.Font.BOLD;
import static java.awt.Image.SCALE_DEFAULT;
import java.awt.event.*;
import static java.lang.System.exit;
import javax.swing.*;
import static javax.swing.SwingConstants.CENTER;


public class DashboardView extends JFrame implements MouseListener {

    Container contenedor = getContentPane();

    //PANELES 
    JPanel pagPrincipal = new JPanel();
    JPanel menu = new JPanel();
    JPanel panelCerrar = new JPanel();
    JPanel panelNameUsu = new JPanel();

    //ETIQUETAS
    JLabel labelNameUser = new JLabel("", SwingConstants.RIGHT);
    JLabel labelCrearProd = new JLabel();
    JLabel labelCrearUsu = new JLabel();
    JLabel labelCrearCateg = new JLabel();
    JLabel labelHacerPedido = new JLabel();
    JLabel labelMenu = new JLabel();
    JLabel labelBienvenida = new JLabel();
    JLabel labelRol = new JLabel();
    JLabel picAdmin = new JLabel();
    JLabel close = new JLabel();
    JLabel minimize = new JLabel();
    JLabel picCrearUsu = new JLabel();
    JLabel picCrearProduc = new JLabel();
    JLabel picCrearCateg = new JLabel();
    JLabel picHacerPedido = new JLabel();

    JLabel indicador = new JLabel();
    JLabel MenuIndicador = new JLabel();

    JLabel labelEstadistica = new JLabel();
    JLabel labelHistorial = new JLabel();
    JLabel PicEstadistica = new JLabel();
    JLabel PicHistorial = new JLabel();

    //CAJA DE TEXTO
    JTextField xs = new JTextField();

    //ComboBox
    JComboBox fieldRol = new JComboBox();

    //VARIABLES
    private final int x = 1430;
    private final int y = 900;

    private boolean presset = false;

    public DashboardView() {

        //setTitle("MiniMarket");
        setSize(x, y);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);

        //Diseño
        pagPrincipal.setSize(x, y);
        pagPrincipal.setLocation(0, 0);
        pagPrincipal.setLayout(null);

        panelCerrar.setSize(120, 40);
        panelCerrar.setLocation(1220, 100);
        panelCerrar.setLayout(null);

        menu.setSize(300, 1430);
        menu.setLayout(null);
        menu.setLocation(0, 0);
        menu.setBackground(orange);
        menu.addMouseListener(this);

        MenuIndicador.setSize(300, 1430);
        MenuIndicador.setLayout(null);
        MenuIndicador.setLocation(0, 0);
        MenuIndicador.addMouseListener(this);

        indicador.setSize(300, 40);
        indicador.setLocation(0, 1000);
        ImageIcon imagelogo = new ImageIcon(getClass().getResource("/imagenes/indicador.png"));
        Icon iconlogo = new ImageIcon(imagelogo.getImage().getScaledInstance(indicador.getWidth(), indicador.getHeight(), SCALE_DEFAULT));
        indicador.setIcon(iconlogo);

        labelMenu.setForeground(WHITE);
        labelMenu.setSize(300, 40);
        labelMenu.setLocation(0, 20);
        labelMenu.setHorizontalAlignment(CENTER);
        labelMenu.setFont(new Font("Arial Black", BOLD, 30));
        labelMenu.setText("Menú");

        if (DashboardController.getUserInfo().getTblRol_RolId().equals("1")) {

            labelCrearProd.setForeground(WHITE);
            labelCrearProd.setSize(300, 40);
            labelCrearProd.setLocation(80, 140);
            labelCrearProd.setFont(new Font("Arial", BOLD, 20));
            labelCrearProd.setText("Gestionar Producto");
            labelCrearProd.setCursor(new Cursor(HAND_CURSOR));
            labelCrearProd.addMouseListener(this);

            labelCrearCateg.setForeground(WHITE);
            labelCrearCateg.setSize(300, 40);
            labelCrearCateg.setLocation(80, 180);
            labelCrearCateg.setFont(new Font("Arial", BOLD, 20));
            labelCrearCateg.setText("Gestionar Categoria");
            labelCrearCateg.setCursor(new Cursor(HAND_CURSOR));
            labelCrearCateg.addMouseListener(this);

        }

        if (DashboardController.getUserInfo().getTblRol_RolId().equals("1") || DashboardController.getUserInfo().getTblRol_RolId().equals("2")) {

            labelCrearUsu.setForeground(WHITE);
            labelCrearUsu.setSize(300, 40);
            labelCrearUsu.setLocation(80, 100);
            labelCrearUsu.setFont(new Font("Arial", BOLD, 20));
            labelCrearUsu.setText("Gestionar Usuario");
            labelCrearUsu.setCursor(new Cursor(HAND_CURSOR));
            labelCrearUsu.addMouseListener(this);

        }

        labelHistorial.setForeground(WHITE);
        labelHistorial.setSize(300, 40);
        labelHistorial.setFont(new Font("Arial", BOLD, 20));
        labelHistorial.setText("Historial Pedidos");
        labelHistorial.setCursor(new Cursor(HAND_CURSOR));
        labelHistorial.addMouseListener(this);

        labelHacerPedido.setForeground(WHITE);
        labelHacerPedido.setSize(300, 40);
        labelHacerPedido.setFont(new Font("Arial", BOLD, 20));
        labelHacerPedido.setText("Hacer Pedido");
        labelHacerPedido.setCursor(new Cursor(HAND_CURSOR));
        labelHacerPedido.addMouseListener(this);

        if (DashboardController.getUserInfo().getTblRol_RolId().equals("1")) {

            labelEstadistica.setForeground(WHITE);
            labelEstadistica.setSize(300, 40);
            labelEstadistica.setLocation(80, 820);
            labelEstadistica.setFont(new Font("Arial", BOLD, 20));
            labelEstadistica.setText("Estadisticas");
            labelEstadistica.setCursor(new Cursor(HAND_CURSOR));
            labelEstadistica.addMouseListener(this);

        }
        labelBienvenida.setForeground(BLACK);
        labelBienvenida.setSize(300, 40);
        labelBienvenida.setLocation(350, 35);
        labelBienvenida.setFont(new Font("Segoe UI Light", BOLD, 30));
        labelBienvenida.setText("Bienvenido");

        labelRol.setForeground(BLACK);
        labelRol.setSize(300, 40);
        labelRol.setLocation(520, 35);
        labelRol.setFont(new Font("Segoe UI Light", BOLD, 30));
        labelRol.setText("Administrador");

        labelNameUser.setForeground(BLACK);
        labelNameUser.setSize(400, 40);
        labelNameUser.setLocation(0, 0);
        labelNameUser.setFont(new Font("Segoe UI Light", BOLD, 30));

        panelNameUsu.setSize(400, 40);
        panelNameUsu.setLocation(850, 35);
        panelNameUsu.setLayout(null);

        if (DashboardController.getUserInfo().getTblRol_RolId().equals("1")) {

            picAdmin.setSize(70, 70);
            picAdmin.setLocation(1260, 20);
            ImageIcon imageAdmin = new ImageIcon(getClass().getResource("/imagenes/admin.png"));
            Icon iconAdmin = new ImageIcon(imageAdmin.getImage().getScaledInstance(picAdmin.getWidth(), picAdmin.getHeight(), SCALE_DEFAULT));
            picAdmin.setIcon(iconAdmin);
            picAdmin.setCursor(new Cursor(HAND_CURSOR));
            picAdmin.addMouseListener(this);

        } else if (DashboardController.getUserInfo().getTblRol_RolId().equals("2")) {

            picAdmin.setSize(60, 60);
            picAdmin.setLocation(1260, 20);
            ImageIcon imageAdmin = new ImageIcon(getClass().getResource("/imagenes/vendedor.png"));
            Icon iconAdmin = new ImageIcon(imageAdmin.getImage().getScaledInstance(picAdmin.getWidth(), picAdmin.getHeight(), SCALE_DEFAULT));
            picAdmin.setIcon(iconAdmin);
            picAdmin.setCursor(new Cursor(HAND_CURSOR));
            picAdmin.addMouseListener(this);

        } else if (DashboardController.getUserInfo().getTblRol_RolId().equals("3")) {

            picAdmin.setSize(70, 70);
            picAdmin.setLocation(1260, 20);
            ImageIcon imageAdmin = new ImageIcon(getClass().getResource("/imagenes/cliente.png"));
            Icon iconAdmin = new ImageIcon(imageAdmin.getImage().getScaledInstance(picAdmin.getWidth(), picAdmin.getHeight(), SCALE_DEFAULT));
            picAdmin.setIcon(iconAdmin);
            picAdmin.setCursor(new Cursor(HAND_CURSOR));
            picAdmin.addMouseListener(this);

        }

        if (DashboardController.getUserInfo().getTblRol_RolId().equals("1") || DashboardController.getUserInfo().getTblRol_RolId().equals("2")) {

            picCrearUsu.setSize(30, 30);
            picCrearUsu.setLocation(40, 100);
            ImageIcon imageCrearUsu = new ImageIcon(getClass().getResource("/imagenes/CrearUsuario.png"));
            Icon iconCrearUsu = new ImageIcon(imageCrearUsu.getImage().getScaledInstance(picCrearUsu.getWidth(), picCrearUsu.getHeight(), SCALE_DEFAULT));
            picCrearUsu.setIcon(iconCrearUsu);
            picCrearUsu.setCursor(new Cursor(HAND_CURSOR));
            picCrearUsu.addMouseListener(this);

        }

        PicHistorial.setSize(30, 30);
        ImageIcon imageHistorial = new ImageIcon(getClass().getResource("/imagenes/historial.png"));
        Icon iconHistorial = new ImageIcon(imageHistorial.getImage().getScaledInstance(PicHistorial.getWidth(), PicHistorial.getHeight(), SCALE_DEFAULT));
        PicHistorial.setIcon(iconHistorial);
        PicHistorial.setCursor(new Cursor(HAND_CURSOR));
        PicHistorial.addMouseListener(this);

        if (DashboardController.getUserInfo().getTblRol_RolId().equals("1")) {
            PicHistorial.setLocation(39, 225);
            labelHistorial.setLocation(80, 220);
            picHacerPedido.setLocation(39, 265);
            labelHacerPedido.setLocation(80, 260);

        } else if (DashboardController.getUserInfo().getTblRol_RolId().equals("2")) {
            PicHistorial.setLocation(39, 145);
            labelHistorial.setLocation(80, 140);
            picHacerPedido.setLocation(40, 187);
            labelHacerPedido.setLocation(80, 180);

        } else if (DashboardController.getUserInfo().getTblRol_RolId().equals("3")) {
            PicHistorial.setLocation(40, 105);
            labelHistorial.setLocation(80, 100);
            picHacerPedido.setLocation(40, 145);
            labelHacerPedido.setLocation(80, 140);

        }

        picHacerPedido.setSize(30, 30);
        ImageIcon imageHacerPedido = new ImageIcon(getClass().getResource("/imagenes/pedido.png"));
        Icon iconHacerPedido = new ImageIcon(imageHacerPedido.getImage().getScaledInstance(picHacerPedido.getWidth(), picHacerPedido.getHeight(), SCALE_DEFAULT));
        picHacerPedido.setIcon(iconHacerPedido);
        picHacerPedido.setCursor(new Cursor(HAND_CURSOR));
        picHacerPedido.addMouseListener(this);

        PicEstadistica.setSize(30, 30);
        PicEstadistica.setLocation(39, 820);
        ImageIcon imageEstadistica = new ImageIcon(getClass().getResource("/imagenes/estadistica.png"));
        Icon iconEstadistica = new ImageIcon(imageEstadistica.getImage().getScaledInstance(PicEstadistica.getWidth(), PicEstadistica.getHeight(), SCALE_DEFAULT));
        PicEstadistica.setIcon(iconEstadistica);
        PicEstadistica.setCursor(new Cursor(HAND_CURSOR));
        PicEstadistica.addMouseListener(this);

        close.setSize(20, 20);
        close.setLocation(1390, 20);
        ImageIcon imageclose = new ImageIcon(getClass().getResource("/imagenes/CerrarN.png"));
        Icon iconclose = new ImageIcon(imageclose.getImage().getScaledInstance(close.getWidth(), close.getHeight(), SCALE_DEFAULT));
        close.setIcon(iconclose);
        close.setCursor(new Cursor(HAND_CURSOR));
        close.addMouseListener(this);

        minimize.setSize(20, 20);
        minimize.setLocation(1360, 20);
        ImageIcon imageminimize = new ImageIcon(getClass().getResource("/imagenes/minimizarN.png"));
        Icon iconminimize = new ImageIcon(imageminimize.getImage().getScaledInstance(minimize.getWidth(), minimize.getHeight(), SCALE_DEFAULT));
        minimize.setIcon(iconminimize);
        minimize.setCursor(new Cursor(HAND_CURSOR));
        minimize.addMouseListener(this);

        menu.add(PicHistorial);
        menu.add(labelHistorial);
        menu.add(picHacerPedido);
        menu.add(labelHacerPedido);

        if (DashboardController.getUserInfo().getTblRol_RolId().equals("1")) {

            picCrearProduc.setSize(30, 30);
            picCrearProduc.setLocation(40, 145);
            ImageIcon imageCrearProduc = new ImageIcon(getClass().getResource("/imagenes/CrearProducto.png"));
            Icon iconCrearProduc = new ImageIcon(imageCrearProduc.getImage().getScaledInstance(picCrearProduc.getWidth(), picCrearProduc.getHeight(), SCALE_DEFAULT));
            picCrearProduc.setIcon(iconCrearProduc);
            picCrearProduc.setCursor(new Cursor(HAND_CURSOR));
            picCrearProduc.addMouseListener(this);

            picCrearCateg.setSize(30, 30);
            picCrearCateg.setLocation(40, 187);
            ImageIcon imageCrearCateg = new ImageIcon(getClass().getResource("/imagenes/categoria.png"));
            Icon iconCrearCateg = new ImageIcon(imageCrearCateg.getImage().getScaledInstance(picCrearCateg.getWidth(), picCrearCateg.getHeight(), SCALE_DEFAULT));
            picCrearCateg.setIcon(iconCrearCateg);
            picCrearCateg.setCursor(new Cursor(HAND_CURSOR));
            picCrearCateg.addMouseListener(this);

            menu.add(picCrearCateg);
            menu.add(labelCrearCateg);
            menu.add(picCrearProduc);
            menu.add(labelCrearProd);
            menu.add(PicEstadistica);
            menu.add(labelEstadistica);
        }

        if (DashboardController.getUserInfo().getTblRol_RolId().equals("1") || DashboardController.getUserInfo().getTblRol_RolId().equals("2")) {
            menu.add(picCrearUsu);
            menu.add(labelCrearUsu);

        }

        pagPrincipal.add(panelCerrar);
        panelNameUsu.add(labelNameUser);
        pagPrincipal.add(panelNameUsu);
        pagPrincipal.add(labelRol);
        pagPrincipal.add(labelBienvenida);
        menu.add(indicador);
        menu.add(labelMenu);
        menu.add(MenuIndicador);
        pagPrincipal.add(picAdmin);
        pagPrincipal.add(close);
        pagPrincipal.add(minimize);
        pagPrincipal.add(menu);
        contenedor.add(pagPrincipal);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent me
    ) {
        if (me.getSource() == minimize) {
            setState(ICONIFIED);
        }
        if (me.getSource() == close) {
            exit(0);
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

        if (DashboardController.getUserInfo().getTblRol_RolId().equals("1")) {
            if (me.getSource() == picCrearUsu || me.getSource() == labelCrearUsu) {
                indicador.setLocation(0, 100);
                menu.add(indicador);
                presset = true;
            }
            if (me.getSource() == picCrearProduc || me.getSource() == labelCrearProd) {
                indicador.setLocation(0, 140);
                menu.add(indicador);
                presset = true;
            }
            if (me.getSource() == picCrearCateg || me.getSource() == labelCrearCateg) {
                indicador.setLocation(0, 180);
                menu.add(indicador);
                presset = true;
            }

            if (me.getSource() == PicHistorial || me.getSource() == labelHistorial) {
                indicador.setLocation(0, 220);
                menu.add(indicador);
                presset = true;
            }
            if (me.getSource() == picHacerPedido || me.getSource() == labelHacerPedido) {
                indicador.setLocation(0, 260);
                menu.add(indicador);
                presset = true;
            }
            if (me.getSource() == PicEstadistica || me.getSource() == labelEstadistica) {
                indicador.setLocation(0, 820);
                menu.add(indicador);
                presset = true;
            }
        }

        if (DashboardController.getUserInfo().getTblRol_RolId().equals("2")) {
            if (me.getSource() == picCrearUsu || me.getSource() == labelCrearUsu) {
                indicador.setLocation(0, 100);
                menu.add(indicador);
                presset = true;
            }
            if (me.getSource() == PicHistorial || me.getSource() == labelHistorial) {
                indicador.setLocation(0, 140);
                menu.add(indicador);
                presset = true;
            }
            if (me.getSource() == picHacerPedido || me.getSource() == labelHacerPedido) {
                indicador.setLocation(0, 180);
                menu.add(indicador);
                presset = true;
            }
        }
        if (DashboardController.getUserInfo().getTblRol_RolId().equals("3")) {

            if (me.getSource() == PicHistorial || me.getSource() == labelHistorial) {
                indicador.setLocation(0, 100);
                menu.add(indicador);
                presset = true;
            }
            if (me.getSource() == picHacerPedido || me.getSource() == labelHacerPedido) {
                indicador.setLocation(0, 140);
                menu.add(indicador);
                presset = true;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

        if (DashboardController.getUserInfo().getTblRol_RolId().equals("1")) {

            if (!presset) {

                if (me.getSource() == picCrearUsu || me.getSource() == labelCrearUsu) {
                    indicador.setLocation(0, 100);
                    menu.add(indicador);
                }

                if (me.getSource() == picCrearProduc || me.getSource() == labelCrearProd) {
                    indicador.setLocation(0, 140);
                    menu.add(indicador);
                }
                if (me.getSource() == picCrearCateg || me.getSource() == labelCrearCateg) {
                    indicador.setLocation(0, 180);
                    menu.add(indicador);
                }
                if (me.getSource() == PicHistorial || me.getSource() == labelHistorial) {
                    indicador.setLocation(0, 220);
                    menu.add(indicador);
                }
                if (me.getSource() == picHacerPedido || me.getSource() == labelHacerPedido) {
                    indicador.setLocation(0, 260);
                    menu.add(indicador);
                }
                if (me.getSource() == PicEstadistica || me.getSource() == labelEstadistica) {
                    indicador.setLocation(0, 820);
                    menu.add(indicador);
                }

                if (me.getSource() == MenuIndicador) {
                    indicador.setLocation(1000, 780);
                    menu.add(indicador);
                }
            }
        }

        if (DashboardController.getUserInfo().getTblRol_RolId().equals("2")) {
            if (!presset) {
                if (me.getSource() == picCrearUsu || me.getSource() == labelCrearUsu) {
                    indicador.setLocation(0, 100);
                    menu.add(indicador);
                }
                if (me.getSource() == PicHistorial || me.getSource() == labelHistorial) {
                    indicador.setLocation(0, 140);
                    menu.add(indicador);
                }
                if (me.getSource() == picHacerPedido || me.getSource() == labelHacerPedido) {
                    indicador.setLocation(0, 180);
                    menu.add(indicador);
                }
            }
        }
        if (DashboardController.getUserInfo().getTblRol_RolId().equals("3")) {
            if (!presset) {
                if (me.getSource() == PicHistorial || me.getSource() == labelHistorial) {
                    indicador.setLocation(0, 100);
                    menu.add(indicador);

                }
                if (me.getSource() == picHacerPedido || me.getSource() == labelHacerPedido) {
                    indicador.setLocation(0, 140);
                    menu.add(indicador);
                }
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {

        if (DashboardController.getUserInfo().getTblRol_RolId().equals("1")) {

            if (!presset) {

                if (me.getSource() == picCrearUsu || me.getSource() == labelCrearUsu) {
                    menu.remove(indicador);
                    indicador.setLocation(0, 100);
                    menu.add(indicador);
                }

                if (me.getSource() == picCrearProduc || me.getSource() == labelCrearProd) {
                    menu.remove(indicador);
                    indicador.setLocation(0, 140);
                    menu.add(indicador);
                }
                if (me.getSource() == picCrearCateg || me.getSource() == labelCrearCateg) {
                    menu.remove(indicador);
                    indicador.setLocation(0, 180);
                    menu.add(indicador);
                }
                if (me.getSource() == PicHistorial || me.getSource() == labelHistorial) {
                    menu.remove(indicador);
                    indicador.setLocation(0, 220);
                    menu.add(indicador);
                }
                if (me.getSource() == picHacerPedido || me.getSource() == labelHacerPedido) {
                    menu.remove(indicador);
                    indicador.setLocation(0, 260);
                    menu.add(indicador);
                }
                if (me.getSource() == PicEstadistica || me.getSource() == labelEstadistica) {
                    menu.remove(indicador);
                    indicador.setLocation(0, 820);
                    menu.add(indicador);

                }
            }
        }
        if (DashboardController.getUserInfo().getTblRol_RolId().equals("2")) {
            if (!presset) {
                if (me.getSource() == picCrearUsu || me.getSource() == labelCrearUsu) {
                    menu.remove(indicador);
                    indicador.setLocation(0, 100);
                    menu.add(indicador);
                }
                if (me.getSource() == PicHistorial || me.getSource() == labelHistorial) {
                    menu.remove(indicador);
                    indicador.setLocation(0, 140);
                    menu.add(indicador);
                }
                if (me.getSource() == picHacerPedido || me.getSource() == labelHacerPedido) {
                    menu.remove(indicador);
                    indicador.setLocation(0, 180);
                    menu.add(indicador);
                }
            }
        }
        if (DashboardController.getUserInfo().getTblRol_RolId().equals("3")) {
            if (!presset) {
                if (me.getSource() == PicHistorial || me.getSource() == labelHistorial) {
                    menu.remove(indicador);
                    indicador.setLocation(0, 100);
                    menu.add(indicador);

                }
                if (me.getSource() == picHacerPedido || me.getSource() == labelHacerPedido) {
                    menu.remove(indicador);
                    indicador.setLocation(0, 140);
                    menu.add(indicador);
                }
            }
        }
    }

    //Metodos Getters 
    public JLabel getLabelEstadistica() {
        return labelEstadistica;
    }

    public JLabel getLabelHistorial() {
        return labelHistorial;
    }

    public JLabel getPicEstadistica() {
        return PicEstadistica;
    }

    public JLabel getPicHistorial() {
        return PicHistorial;
    }

    public JPanel getPanelCerrar() {
        return panelCerrar;
    }

    public JPanel getMenu() {
        return menu;
    }

    public JPanel getPagPrincipal() {
        return pagPrincipal;
    }

    public JLabel getLabelNameUser() {
        return labelNameUser;
    }

    public JLabel getLabelCrearProd() {
        return labelCrearProd;
    }

    public JLabel getLabelCrearUsu() {
        return labelCrearUsu;
    }

    public JLabel getLabelCrearCateg() {
        return labelCrearCateg;
    }

    public JLabel getLabelHacerPedido() {
        return labelHacerPedido;
    }

    public JLabel getPicAdmin() {
        return picAdmin;
    }

    public JLabel getPicCrearUsu() {
        return picCrearUsu;
    }

    public JLabel getPicCrearProduc() {
        return picCrearProduc;
    }

    public JLabel getPicCrearCateg() {
        return picCrearCateg;
    }

    public JLabel getPicHacerPedido() {
        return picHacerPedido;
    }

    public void setLabelNameUser(String labelNameUser) {
        this.labelNameUser.setText(labelNameUser);
    }

    public void setLabelRol(String labelRol) {
        this.labelRol.setText(labelRol);
    }

}
