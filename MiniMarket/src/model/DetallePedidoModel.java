package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Table.Factura;
import model.Table.HistorialPedido;
import model.Table.ProductoPedido;

public class DetallePedidoModel {

    private final Conexion conexion;
    private final String table;

    public DetallePedidoModel() {

        table = "TblProductoPedido";
        this.conexion = new Conexion();

    }

    public void create(ProductoPedido p) {

        try {

            PreparedStatement sentence = conexion.sentence("insert into " + table + " values(?,?,?,?)");
            sentence.setString(1, null);
            sentence.setString(2, p.getProPedCantidad());
            sentence.setString(3, p.getTblProducto_ProRef());
            sentence.setString(4, p.getTblPedido_PedId());
            sentence.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Factura> listItemPedido(HistorialPedido p) {

        ArrayList<Factura> data = new ArrayList<>();
        try {
            PreparedStatement sentence = conexion.sentence("SELECT TblProducto_ProRef,ProNombre,ProPrecio, sum(ProPedCantidad) as ProCantidad FROM TblProductoPedido,tblproducto where tblproducto_ProRef = ProRef and  TblPedido_PedId = ? GROUP BY ProRef");
            sentence.setString(1, p.getPedId());
            ResultSet result = sentence.executeQuery();
            while (result.next()) {
                Factura f = new Factura();
                f.setCantidad(result.getString("ProCantidad"));
                f.setPrecioUnidad(result.getString("ProPrecio"));
                f.setProducto(result.getString("ProNombre"));

                data.add(f);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
}
