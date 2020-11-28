package controller;

import model.EstadisticaModel;
import model.Table.ProductoEstadistica;
import view.EstadisticaView;

public class EstadisticasController {

    private EstadisticaView vista;
    private EstadisticaModel model;

    public EstadisticasController() {
        vista = new EstadisticaView();

        model = new EstadisticaModel();
        ProductoEstadistica mayor = model.getMayor();
        ProductoEstadistica menor = model.getMenor();
        ProductoEstadistica ConsultaPCIPSIP = model.getPrecio();

        vista.setResultadoMasVendido(mayor.getProNombre());
        vista.setResultadoMenosVendido(menor.getProNombre());
        vista.setResultadoVentaTotal("$ " + ConsultaPCIPSIP.getTotalConIVA());
        vista.setResultadoPromedio("$ " + ConsultaPCIPSIP.getPromedio());
        vista.setResultadoGanancia("$ " + ConsultaPCIPSIP.getTotalSinIVA());
    }

    public EstadisticaView getVista() {
        return vista;
    }

}
