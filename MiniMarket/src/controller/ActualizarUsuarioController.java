package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import model.Table.Usuario;
import model.UsuarioModel;
import view.ActualizarUsuarioView;
import view.DashboardView;
import view.JTableComponent;
import view.LoginView;
import view.Resource;

public class ActualizarUsuarioController implements MouseListener {

    private ActualizarUsuarioView vista;
    private DashboardView vistaD;
    private UsuarioModel model;
    private JTableComponent Tabla;

    public ActualizarUsuarioController(DashboardView vistaD, JTableComponent Tabla) {

        vista = new ActualizarUsuarioView();
        model = new UsuarioModel();

        this.Tabla = Tabla;
        this.vistaD = vistaD;

        Usuario u = (Usuario) Tabla.getObject();

        if (DashboardController.getUserInfo().getUsuIdentificacion().equals(u.getUsuIdentificacion())) {
            vista.getEstado().setEnabled(false);
            vista.getTipoRol().setEnabled(false);
        }

        vista.setFieldnumIdentificacion(u.getUsuIdentificacion());
        vista.setFieldName(u.getUsuNombre1());
        vista.setFieldSecondName(u.getUsuNombre2());
        vista.setFieldLastName(u.getUsuApellido1());
        vista.setFieldSecondLastName(u.getUsuApellido2());
        vista.setFieldCel(u.getUsuCelular());
        vista.setFieldEmail(u.getUsuCorreo());
        Resource.setSelectedCombobox(vista.getTipoRol(), u.getRolNombre());
        Resource.setSelectedCombobox(vista.getEstado(), u.getEstEstado());
        Resource.setSelectedRadioButton(vista.getTipIdentificacion(), u.getTipNombre());
        vista.getClose().addMouseListener(this);
        vista.getMinimize().addMouseListener(this);
        vista.getCancelar().addMouseListener(this);
        vista.getGuardar().addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == vista.getMinimize()) {
            vista.setState(LoginView.ICONIFIED);
        }
        if (me.getSource() == vista.getClose()) {
            vista.dispose();
            vistaD.setVisible(true);
        }
        if (me.getSource() == vista.getCancelar()) {
            vista.dispose();
            vistaD.setVisible(true);
        }

        if (me.getSource() == vista.getGuardar()) {

            if (vista.getFieldName().getText().isEmpty() || vista.getFieldLastName().getText().isEmpty()
                    || vista.getFieldnumIdentificacion().getText().isEmpty() || vista.getTipoRol().getSelectedIndex() == 0 || vista.getEstado().getSelectedIndex() == 0) {

                JOptionPane.showMessageDialog(null, "Falta diligenciar algunos campos obligatorios (*)", "Verifique los Datos", JOptionPane.WARNING_MESSAGE);

            } else {

                String TipoIdentifiSelected = "";
                String TipoSelected = "";
                if (vista.getCc().isSelected()) {
                    TipoSelected = "1";
                    TipoIdentifiSelected = "C.C";
                } else if (vista.getCt().isSelected()) {
                    TipoSelected = "2";
                    TipoIdentifiSelected = "C.T";
                } else if (vista.getTi().isSelected()) {
                    TipoSelected = "3";
                    TipoIdentifiSelected = "T.I";
                }

                Usuario r = (Usuario) Tabla.getObject();
                String rolAnterior = r.getTblRol_RolId();

                Usuario u = new Usuario();
                u.setUsuIdentificacion(vista.getFieldnumIdentificacion().getText());
                u.setUsuNombre1(vista.getFieldName().getText());
                u.setUsuNombre2(vista.getFieldSecondName().getText());
                u.setUsuApellido1(vista.getFieldLastName().getText());
                u.setUsuApellido2(vista.getFieldSecondLastName().getText());
                u.setUsuCelular(vista.getFieldCel().getText());
                u.setUsuCorreo(vista.getFieldEmail().getText());
                u.setTblTipoIdentificacion_TipId(TipoSelected);
                u.setTblRol_RolId(String.valueOf(vista.getTipoRol().getSelectedItem().hashCode()));
                u.setTblEstado_EstId(String.valueOf(vista.getEstado().getSelectedItem().hashCode()));
                u.setRolNombre(vista.getTipoRol().getSelectedItem().toString());
                u.setEstEstado(vista.getEstado().getSelectedItem().toString());

                u.setTipNombre(TipoIdentifiSelected);

                u.setUsuNombre1(u.getUsuNombre1().trim());
                u.setUsuNombre2(u.getUsuNombre2().trim());
                u.setUsuApellido1(u.getUsuApellido1().trim());
                u.setUsuApellido2(u.getUsuApellido2().trim());
                u.setUsuCelular(u.getUsuCelular().trim());
                u.setUsuCorreo(u.getUsuCorreo().trim());

                if (model.update(u)) {

                    Tabla.getModel().setValueAt(u, Tabla.getTable().getSelectedRow(), 0);
                    Tabla.getModel().setValueAt(u.getTipNombre(), Tabla.getTable().getSelectedRow(), 1);
                    Tabla.getModel().setValueAt(u.getUsuIdentificacion(), Tabla.getTable().getSelectedRow(), 2);
                    Tabla.getModel().setValueAt(u.getUsuNombre1(), Tabla.getTable().getSelectedRow(), 3);
                    Tabla.getModel().setValueAt(u.getUsuNombre2(), Tabla.getTable().getSelectedRow(), 4);
                    Tabla.getModel().setValueAt(u.getUsuApellido1(), Tabla.getTable().getSelectedRow(), 5);
                    Tabla.getModel().setValueAt(u.getUsuApellido2(), Tabla.getTable().getSelectedRow(), 6);
                    Tabla.getModel().setValueAt(u.getUsuCelular(), Tabla.getTable().getSelectedRow(), 7);
                    Tabla.getModel().setValueAt(u.getUsuCorreo(), Tabla.getTable().getSelectedRow(), 8);
                    Tabla.getModel().setValueAt(u.getRolNombre(), Tabla.getTable().getSelectedRow(), 9);
                    Tabla.getModel().setValueAt(u.getEstEstado(), Tabla.getTable().getSelectedRow(), 10);

                    JOptionPane.showMessageDialog(null, "Se ha Actualizado el usuario de manera correcta");
                    vista.dispose();
                    if (!rolAnterior.equals(u.getTblTipoIdentificacion_TipId()) && DashboardController.getUserInfo().getUsuIdentificacion().equals(u.getUsuIdentificacion())) {

                        JOptionPane.showMessageDialog(null, "La sesión ha caducado razón : \n Se ha cambiado de rol, vuelva a iniciar sesión \n", "Error Inicio de Sesion", JOptionPane.ERROR_MESSAGE);
                        vistaD.dispose();
                        LoginController inicio = new LoginController();

                    } else {
                        vistaD.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, " Ha ocurrido un error en la insercion");
                }

                System.out.println("si funciona");
            }
        }
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
