package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Table.ProductoEstadistica;

public class EstadisticaModel {

    private Conexion conexion;

    public EstadisticaModel() {
        conexion = new Conexion();
    }

    public ProductoEstadistica getMayor() {

        ProductoEstadistica data = new ProductoEstadistica();
        try {
            PreparedStatement sentence = conexion.sentence("SELECT TblProducto_ProRef,ProNombre, sum(ProPedCantidad) as ProPedCantidad FROM TblProductoPedido,TblProducto where ProRef = TblProducto_ProRef GROUP BY TblProducto_ProRef order by ProPedCantidad desc limit 1");
            ResultSet result = sentence.executeQuery();
            while (result.next()) {
                data.setTblProducto_ProRef(result.getString("TblProducto_ProRef"));
                data.setProNombre(result.getString("ProNombre"));
                data.setProPedCantidad(result.getString("ProPedCantidad"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;

    }

    public ProductoEstadistica getMenor() {

        ProductoEstadistica data = new ProductoEstadistica();
        try {
            PreparedStatement sentence = conexion.sentence("SELECT TblProducto_ProRef,ProNombre, sum(ProPedCantidad) as ProPedCantidad FROM TblProductoPedido,TblProducto where ProRef = TblProducto_ProRef GROUP BY TblProducto_ProRef order by ProPedCantidad asc limit 1");
            ResultSet result = sentence.executeQuery();
            while (result.next()) {
                data.setTblProducto_ProRef(result.getString("TblProducto_ProRef"));
                data.setProNombre(result.getString("ProNombre"));
                data.setProPedCantidad(result.getString("ProPedCantidad"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;

    }

    public ProductoEstadistica getPrecio() {

        ProductoEstadistica data = new ProductoEstadistica();
        try {
            PreparedStatement sentence = conexion.sentence("select FLOOR(TotalConIva) as TotalConIva,FLOOR(TotalSinIva) as TotalSinIva,FLOOR((TotalConIva/ProPedCantidad)) as Promedio from (select sum(PrecioIva*ProPedCantidad) as TotalConIva,sum(ProPedCantidad) as ProPedCantidad, sum(ProPrecio*ProPedCantidad) as TotalSinIva from (SELECT TblProducto_ProRef,ProNombre,ProPrecio,((ProPrecio*TipProIva/100)+ProPrecio) as PrecioIva,TipProIva,sum(ProPedCantidad) as ProPedCantidad FROM TblProductoPedido,TblProducto,tbltipoproducto where ProRef = TblProducto_ProRef and TipProId = TblTipoProducto_TipId GROUP BY TblProducto_ProRef) as estadistica) as final");
            ResultSet result = sentence.executeQuery();
            while (result.next()) {
                data.setTotalConIVA(result.getString("TotalConIva"));
                data.setPromedio(result.getString("Promedio"));
                data.setTotalSinIVA(result.getString("TotalSinIva"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;

    }

}
