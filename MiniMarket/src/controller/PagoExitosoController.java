package controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.DetallePedidoModel;
import model.HistorialPedidoModel;
import model.Table.Factura;
import model.Table.HistorialPedido;
import model.Table.Pedido;
import view.FacturaFormat;
import view.PagoExitosoView;

public class PagoExitosoController implements ActionListener, MouseListener {

    private PagoExitosoView vista;
    private Pedido pp;

    public PagoExitosoController(Pedido pp) {

        vista = new PagoExitosoView();
        vista.getOk().addActionListener(this);
        vista.getDescargar().addMouseListener(this);
        vista.getVer().addMouseListener(this);
        this.pp = pp;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == vista.getOk()) {

            vista.dispose();
            DashboardController gui = new DashboardController(DashboardController.getUserInfo());

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource().equals(vista.getVer())) {

            HistorialPedidoModel z = new HistorialPedidoModel();
            HistorialPedido a = z.getOne(pp);

            DetallePedidoModel dp = new DetallePedidoModel();
            ArrayList<Factura> f = dp.listItemPedido(a);

            String n = FacturaFormat.setFactura(a.getPedId(), "factura/", a.getUsuNombre1() + " " + a.getUsuApellido1(), a.getUsuIdentificacion(), a.getPedFecha(), f);

            try {
                Desktop.getDesktop().open(new File(n));
                JOptionPane.showMessageDialog(null, "En unos momentos se visualizara la factura");

            } catch (IOException ex) {

            }
        } else if (e.getSource().equals(vista.getDescargar())) {

            HistorialPedidoModel z = new HistorialPedidoModel();
            HistorialPedido a = z.getOne(pp);

            DetallePedidoModel dp = new DetallePedidoModel();
            ArrayList<Factura> f = dp.listItemPedido(a);

            String home = System.getProperty("user.home") + "/Descargas/";
            String n = FacturaFormat.setFactura(a.getPedId(), home, a.getUsuNombre1() + " " + a.getUsuApellido1(), a.getUsuIdentificacion(), a.getPedFecha(), f);

            File file = new File(n);

            if (file != null) {
                JOptionPane.showMessageDialog(null, "Se ha descargado correctamente la factura \nruta: " + n);
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
