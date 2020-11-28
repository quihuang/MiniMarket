package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.Table.Usuario;
import view.CerrarSesionView;
import view.DashboardView;

public class DashboardController implements MouseListener {

    private int NumClick = 0;

    private DashboardView vista;
    private CategoryController controllerCreateCategory;
    private ProductController ControllerProduc;
    private UsuarioController usuarioController;
    private HacerPedidoController vistaPedido;
    private HistorialPedidoController vistaHistorial;
    private Usuario logged;
    private CerrarSesionView vistaCerrar;
    private EstadisticasController vistaEstadistica;
    private static Usuario userInfo;

    public DashboardController(Usuario logged) {

        this.logged = logged;
        userInfo = logged;

        vista = new DashboardView();
        vista.setLabelRol(this.logged.getRolNombre());
        vista.setLabelNameUser(this.logged.getUsuNombre1() + " " + this.logged.getUsuApellido1());

        if (logged.getTblRol_RolId().equals("1")) {

            controllerCreateCategory = new CategoryController();
            ControllerProduc = new ProductController();

        }

        if (logged.getTblRol_RolId().equals("1") || logged.getTblRol_RolId().equals("2")) {

            usuarioController = new UsuarioController(vista);

        }

        vistaHistorial = new HistorialPedidoController();
        vistaPedido = new HacerPedidoController(vista);
        vistaCerrar = new CerrarSesionView();
        vistaHistorial = new HistorialPedidoController();
        vistaEstadistica = new EstadisticasController();

        if (logged.getTblRol_RolId().equals("1")) {

            vista.getPicCrearCateg().addMouseListener(this);
            vista.getLabelCrearCateg().addMouseListener(this);
            vista.getPicCrearProduc().addMouseListener(this);
            vista.getLabelCrearProd().addMouseListener(this);

        }

        if (logged.getTblRol_RolId().equals("1") || logged.getTblRol_RolId().equals("2")) {

            vista.getPicCrearUsu().addMouseListener(this);
            vista.getLabelCrearUsu().addMouseListener(this);
        }
        vista.getLabelHacerPedido().addMouseListener(this);
        vista.getPicHacerPedido().addMouseListener(this);
        vista.getPicAdmin().addMouseListener(this);
        vista.getPicHistorial().addMouseListener(this);
        vista.getLabelHistorial().addMouseListener(this);
        vista.getPicEstadistica().addMouseListener(this);
        vista.getLabelEstadistica().addMouseListener(this);
        vistaCerrar.getCerrar().addMouseListener(this);
        vistaCerrar.getImg().addMouseListener(this);

        if (logged.getTblRol_RolId().equals("1")) {

            vista.getPagPrincipal().add(vistaEstadistica.getVista());

        } else if (logged.getTblRol_RolId().equals("2") || logged.getTblRol_RolId().equals("3")) {

            vista.getPagPrincipal().add(vistaPedido.getVista());
            vistaPedido.getVista().setLocation(370, 120);

        }

        vista.invalidate();
        vista.validate();
        vista.repaint();

    }

    /*-----------------------------------------------*/
    @Override
    public void mouseClicked(MouseEvent me) {

        if (me.getSource() == vista.getPicAdmin()) {

            if (NumClick == 0) {

                vista.getPanelCerrar().add(vistaCerrar);

                vistaCerrar.repaint();
                vistaCerrar.validate();
                vistaCerrar.invalidate();

                NumClick = 1;

            } else if (NumClick == 1) {

                vista.getPanelCerrar().remove(vistaCerrar);

                vista.repaint();
                vista.validate();
                vista.invalidate();

                NumClick = 0;

            }

        }

        if (me.getSource() == vistaCerrar.getCerrar() || me.getSource() == vistaCerrar.getImg()) {

            vista.dispose();

            LoginController login = new LoginController();

        }

        if (logged.getTblRol_RolId().equals("1")) {

            if (me.getSource() == vista.getPicCrearCateg() || me.getSource() == vista.getLabelCrearCateg()) {

                vista.getPagPrincipal().remove(usuarioController.getVista());
                vista.getPagPrincipal().remove(ControllerProduc.getVista());
                vista.getPagPrincipal().remove(vistaPedido.getVista());
                vista.getPagPrincipal().remove(vistaHistorial.getVista());
                vista.getPagPrincipal().remove(vistaEstadistica.getVista());

                vista.getPagPrincipal().add(controllerCreateCategory.getVista());

                vista.invalidate();
                vista.validate();
                vista.repaint();

                controllerCreateCategory.getVista().setLocation(370, 120);

            }

            if (me.getSource() == vista.getPicCrearProduc() || me.getSource() == vista.getLabelCrearProd()) {

                vista.getPagPrincipal().remove(usuarioController.getVista());
                vista.getPagPrincipal().remove(controllerCreateCategory.getVista());
                vista.getPagPrincipal().remove(vistaPedido.getVista());
                vista.getPagPrincipal().remove(vistaHistorial.getVista());
                vista.getPagPrincipal().remove(vistaEstadistica.getVista());

                vista.getPagPrincipal().add(ControllerProduc.getVista());

                vista.invalidate();
                vista.validate();
                vista.repaint();

                ControllerProduc.getVista().setLocation(370, 120);
            }

        }

        if (me.getSource() == vista.getPicCrearUsu() || me.getSource() == vista.getLabelCrearUsu()) {

            if (logged.getTblRol_RolId().equals("1")) {
                vista.getPagPrincipal().remove(controllerCreateCategory.getVista());
                vista.getPagPrincipal().remove(ControllerProduc.getVista());
                vista.getPagPrincipal().remove(vistaEstadistica.getVista());
                vista.getPagPrincipal().remove(vistaHistorial.getVista());
                vista.getPagPrincipal().remove(vistaPedido.getVista());
            }

            if (logged.getTblRol_RolId().equals("2")) {
                vista.getPagPrincipal().remove(vistaHistorial.getVista());
                vista.getPagPrincipal().remove(vistaPedido.getVista());
            }

            vista.getPagPrincipal().add(usuarioController.getVista());

            vista.invalidate();
            vista.validate();
            vista.repaint();

        }

        if (me.getSource() == vista.getPicHistorial() || me.getSource() == vista.getLabelHistorial()) {

            if (logged.getTblRol_RolId().equals("1")) {
                vista.getPagPrincipal().remove(controllerCreateCategory.getVista());
                vista.getPagPrincipal().remove(ControllerProduc.getVista());
                vista.getPagPrincipal().remove(vistaEstadistica.getVista());
                vista.getPagPrincipal().remove(usuarioController.getVista());
                vista.getPagPrincipal().remove(vistaPedido.getVista());
            }

            if (logged.getTblRol_RolId().equals("2")) {

                vista.getPagPrincipal().remove(usuarioController.getVista());
                vista.getPagPrincipal().remove(vistaPedido.getVista());

            }

            if (logged.getTblRol_RolId().equals("3")) {

                vista.getPagPrincipal().remove(vistaPedido.getVista());
            }

            vista.getPagPrincipal().add(vistaHistorial.getVista());

            vista.invalidate();
            vista.validate();
            vista.repaint();

        }

        if (me.getSource() == vista.getPicHacerPedido() || me.getSource() == vista.getLabelHacerPedido()) {

            if (logged.getTblRol_RolId().equals("1")) {

                vista.getPagPrincipal().remove(controllerCreateCategory.getVista());
                vista.getPagPrincipal().remove(ControllerProduc.getVista());
                vista.getPagPrincipal().remove(vistaHistorial.getVista());
                vista.getPagPrincipal().remove(vistaEstadistica.getVista());
                vista.getPagPrincipal().remove(usuarioController.getVista());

            }

            if (logged.getTblRol_RolId().equals("1") || logged.getTblRol_RolId().equals("2")) {

                vista.getPagPrincipal().remove(usuarioController.getVista());
                vista.getPagPrincipal().remove(vistaHistorial.getVista());

            }

            if (logged.getTblRol_RolId().equals("3")) {

                vista.getPagPrincipal().remove(vistaHistorial.getVista());

            }

            vista.getPagPrincipal().add(vistaPedido.getVista());

            vista.invalidate();
            vista.validate();
            vista.repaint();

            vistaPedido.getVista().setLocation(370, 120);

        }

        if (me.getSource() == vista.getPicEstadistica() || me.getSource() == vista.getLabelEstadistica()) {

            if (logged.getTblRol_RolId().equals("1")) {

                vista.getPagPrincipal().remove(controllerCreateCategory.getVista());
                vista.getPagPrincipal().remove(ControllerProduc.getVista());
                vista.getPagPrincipal().remove(vistaHistorial.getVista());
                vista.getPagPrincipal().remove(vistaPedido.getVista());
                vista.getPagPrincipal().remove(usuarioController.getVista());

            }

            vista.getPagPrincipal().add(vistaEstadistica.getVista());

            vista.invalidate();
            vista.validate();
            vista.repaint();

        }

    }

    public static Usuario getUserInfo() {
        return userInfo;
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

}
