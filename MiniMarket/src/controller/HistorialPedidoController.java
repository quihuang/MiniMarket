package controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import model.DetallePedidoModel;
import model.HistorialPedidoModel;
import model.Table.Factura;
import model.Table.HistorialPedido;
import model.Table.Usuario;
import view.FacturaFormat;
import view.HistorialPedidoView;

public class HistorialPedidoController implements ActionListener {

    private HistorialPedidoView vista;
    private HistorialPedidoModel model;

    public HistorialPedidoController() {

        model = new HistorialPedidoModel();
        ArrayList<HistorialPedido> data;
        if (DashboardController.getUserInfo().getTblRol_RolId().equals("1") || DashboardController.getUserInfo().getTblRol_RolId().equals("2")) {
            data = model.getAllPedidos();
        } else {
            Usuario a = new Usuario();
            a.setUsuIdentificacion(DashboardController.getUserInfo().getUsuIdentificacion());
            data = model.getAllPedidos(a);
        }

        vista = new HistorialPedidoView(data);
        vista.getButtonVerPedido().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(vista.getButtonVerPedido())) {
            if (vista.getTableList().getTable().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
            } else {

                HistorialPedido a = (HistorialPedido) vista.getTableList().getObject();
                DetallePedidoModel dp = new DetallePedidoModel();

                ArrayList<Factura> f = dp.listItemPedido(a);

                String n = FacturaFormat.setFactura(a.getPedId(), "factura/", a.getUsuNombre1() + " " + a.getUsuApellido1(), a.getUsuIdentificacion(), a.getPedFecha(), f);

                try {
                    Desktop.getDesktop().open(new File(n));
                } catch (IOException ex) {

                }
            }
        }
    }

    public HistorialPedidoView getVista() {
        return vista;
    }

}
