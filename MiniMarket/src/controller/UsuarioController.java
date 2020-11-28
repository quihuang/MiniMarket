package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Table.Usuario;
import model.UsuarioModel;
import view.DashboardView;
import view.UsuarioView;

public class UsuarioController implements ActionListener {

    private UsuarioView vista;
    private DashboardView vistaD;
    private UsuarioModel model;

    public UsuarioController(DashboardView vistaD) {

        model = new UsuarioModel();
        vista = new UsuarioView(model.getAll());
        this.vistaD = vistaD;

        vista.getButtonCreateUsuario().addActionListener(this);
        vista.getButtonUpdateUsuario().addActionListener(this);
        vista.getButtonDeleteUsuario().addActionListener(this);

    }

    public UsuarioView getVista() {
        return vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getButtonCreateUsuario()) {

            vistaD.setVisible(false);

            CrearUsuarioController register = new CrearUsuarioController(vistaD, vista);
        } else if (e.getSource() == vista.getButtonUpdateUsuario()) {

            System.out.println(vista.getTableList().getTable().getSelectedRow());
            if (vista.getTableList().getTable().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
            } else {
                vistaD.setVisible(false);
                ActualizarUsuarioController register = new ActualizarUsuarioController(vistaD, vista.getTableList());
            }
        } else if (e.getSource().equals(vista.getButtonDeleteUsuario())) {
            if (vista.getTableList().getTable().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
            } else {
                Usuario u = (Usuario) vista.getTableList().getObject();

                u.setTblEstado_EstId("2");
                int valDelete = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este registro?", "Confirmacion", JOptionPane.YES_NO_OPTION);
                if (valDelete == JOptionPane.YES_NO_OPTION) {
                    if (model.delete(u)) {

                        vista.getTableList().getModel().removeRow(vista.getTableList().getTable().getSelectedRow());
                        JOptionPane.showMessageDialog(null, "Se ha Eliminado el usuario correctamente");

                    } else {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la Eliminacion", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
        }

    }

}
