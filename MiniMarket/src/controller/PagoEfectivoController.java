package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import model.Table.Pedido;
import view.DashboardView;
import view.PagoEfectivoView;
import view.ProcesandoView;

public class PagoEfectivoController extends TimerTask implements ActionListener {

    private PagoEfectivoView vista;
    private TipoPagoController vistaT;
    private DashboardView vistaD;
    private ProcesandoView carga;
    private boolean valid = false;
    private Pedido p;

    public PagoEfectivoController(DashboardView vistaD) {

        vista = new PagoEfectivoView();
        vista.getFieldTotal().setText(HacerPedidoController.getTotalPagar());
        this.vistaD = vistaD;
        validPrecio();
        vista.getFieldRecibido().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                validPrecio();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                validPrecio();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                validPrecio();
            }

        });

        vista.getCancelar().addActionListener(this);
        vista.getPagar().addActionListener(this);

    }

    private void validPrecio() {
        String c = "";
        if (!vista.getFieldRecibido().getText().isEmpty()) {

            double l = Double.parseDouble(vista.getFieldRecibido().getText()) - Double.parseDouble(vista.getFieldTotal().getText());
            c = String.valueOf(l);
            valid = l >= 0;

        } else {
            c = String.valueOf(0 - Double.parseDouble(vista.getFieldTotal().getText()));
            valid = false;
        }

        if (!valid) {
            vista.getFieldCambio().setForeground(Color.red);
            vista.getLabelCambio().setText("Faltan");
        } else {
            vista.getFieldCambio().setForeground(Color.BLACK);
            vista.getLabelCambio().setText("Cambio");
        }

        vista.setFieldCambio(c);
    }

    @Override
    public void actionPerformed(ActionEvent me) {
        if (me.getSource() == vista.getCancelar()) {
            vista.setVisible(false);
            vistaT = new TipoPagoController(vistaD);
            vistaT.getVista();

        }

        if (me.getSource() == vista.getPagar()) {

            if (!valid) {

                JOptionPane.showMessageDialog(null, "El efectivo actual no es suficiente para realizar el pedido");

            } else {
                carga = new ProcesandoView();
                Timer contadorCarga = new Timer();
                contadorCarga.schedule(this, 5000);
                p = HacerPedidoController.createPedido("1");
            }

        }
    }

    @Override
    public void run() {
        carga.dispose();
        vistaD.dispose();
        vista.dispose();
        PagoExitosoController pagoOk = new PagoExitosoController(p);

    }

}
