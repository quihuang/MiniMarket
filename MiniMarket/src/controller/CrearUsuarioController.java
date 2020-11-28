package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import model.Table.Usuario;
import model.UsuarioModel;
import view.CrearUsuarioView;
import view.DashboardView;
import view.LoginView;
import view.UsuarioView;

public class CrearUsuarioController implements MouseListener, ActionListener {

    private CrearUsuarioView vista;
    private DashboardView vistaD;
    private UsuarioModel model;
    private UsuarioView vistaU;

    public CrearUsuarioController(DashboardView vistaD, UsuarioView vistaU) {

        vista = new CrearUsuarioView();
        model = new UsuarioModel();
        this.vistaD = vistaD;
        this.vistaU = vistaU;

        vista.getClose().addMouseListener(this);
        vista.getMinimize().addMouseListener(this);
        vista.getButtonCancelUser().addMouseListener(this);
        vista.getButtonCreateUser().addActionListener(this);

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
        if (me.getSource() == vista.getButtonCancelUser()) {
            vista.dispose();
            vistaD.setVisible(true);
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

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(vista.getButtonCreateUser())) {

            if (vista.getFieldName().getText().isEmpty() || vista.getFieldLastName().getText().isEmpty()
                    || vista.getFieldnumIdentificacion().getText().isEmpty() || vista.getTipoRol().getSelectedIndex() == 0
                    || vista.getFieldPass().getText().isEmpty() || vista.getFieldConfirmPass().getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Falta diligenciar algunos campos obligatorios (*)", "Verifique los Datos", JOptionPane.WARNING_MESSAGE);

            } else {

                if (vista.getFieldPass().getText().equals(vista.getFieldConfirmPass().getText())) {

                    String rolSelected = "";
                    if (vista.getCc().isSelected()) {
                        rolSelected = "1";
                    } else if (vista.getCt().isSelected()) {
                        rolSelected = "2";
                    } else if (vista.getTi().isSelected()) {
                        rolSelected = "3";
                    }

                    Usuario u = new Usuario();
                    u.setUsuIdentificacion(vista.getFieldnumIdentificacion().getText());
                    u.setUsuContrasenia(vista.getFieldPass().getText());
                    u.setUsuNombre1(vista.getFieldName().getText());
                    u.setUsuNombre2(vista.getFieldSecondName().getText());
                    u.setUsuApellido1(vista.getFieldLastName().getText());
                    u.setUsuApellido2(vista.getFieldSecondLastName().getText());
                    u.setUsuCelular(vista.getFieldCel().getText());
                    u.setUsuCorreo(vista.getFieldEmail().getText());
                    u.setTblTipoIdentificacion_TipId(rolSelected);
                    u.setTblRol_RolId(String.valueOf(vista.getTipoRol().getSelectedItem().hashCode()));
                    u.setTblEstado_EstId("1");

                    u.setUsuNombre1(u.getUsuNombre1().trim());
                    u.setUsuNombre2(u.getUsuNombre2().trim());
                    u.setUsuApellido1(u.getUsuApellido1().trim());
                    u.setUsuApellido2(u.getUsuApellido2().trim());
                    u.setUsuCelular(u.getUsuCelular().trim());
                    u.setUsuCorreo(u.getUsuCorreo().trim());

                    u = model.create(u);

                    if (u != null) {
                        Object rs[] = {u, u.getTipNombre(), u.getUsuIdentificacion(), u.getUsuNombre1(), u.getUsuNombre2(),
                            u.getUsuApellido1(), u.getUsuApellido2(), u.getUsuCelular(), u.getUsuCorreo(),
                            u.getRolNombre(), u.getEstEstado()};

                        JOptionPane.showMessageDialog(null, "Se ha creado el usuario de manera correcta");
                        vista.dispose();
                        vistaD.setVisible(true);
                        vistaU.getTableList().getModel().addRow(rs);
                    } else {
                        JOptionPane.showMessageDialog(null, " Ha ocurrido un error en la insercion");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Verifique la contraseña", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

    }
}
