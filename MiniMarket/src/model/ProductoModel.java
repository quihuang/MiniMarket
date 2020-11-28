package model;

import controller.DashboardController;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Table.Producto;

public class ProductoModel {

    private final Conexion conexion;
    private final String table;

    public ProductoModel() {
        table = "TblProducto";
        this.conexion = new Conexion();
    }

    public ArrayList<Producto> getAll() {

        ArrayList<Producto> data = new ArrayList<>();
        try {
            PreparedStatement sentence = conexion.sentence("select * from " + table + " as p, TblEstado as e,TblTipoProducto as tp where e.EstId = p.TblEstado_EstId and tp.TipProId = p.TblTipoProducto_TipId and p.TblEstado_EstId = 1");
            ResultSet result = sentence.executeQuery();
            while (result.next()) {
                Producto p = new Producto();
                p.setProRef(result.getString("ProRef"));
                p.setProNombre(result.getString("ProNombre"));
                p.setProStock(result.getString("ProStock"));
                p.setProPrecio(result.getString("ProPrecio"));
                p.setProFechaVencimiento(result.getString("ProFechaVencimiento"));
                p.setTblTipoProducto_TipId(result.getString("TblTipoProducto_TipId"));
                p.setTipProNombre(result.getString("TipProNombre"));
                p.setTblEstado_EstId(result.getString("EstId"));
                p.setTblEstado_EstEstado(result.getString("EstEstado"));
                p.setTblTipoProducto_TipProIva(result.getString("TipProIva"));
                double iva = (Double.parseDouble(p.getProPrecio()) * Double.parseDouble(p.getTblTipoProducto_TipProIva()) / 100) + Double.parseDouble(p.getProPrecio());
                p.setProPrecio(String.valueOf(iva));

                data.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;

    }

    public Producto create(Producto p) {
        if (DashboardController.getUserInfo().getTblRol_RolId().equals("1")) {

            Producto n = null;
            try {

                PreparedStatement sentence = conexion.sentence("insert into " + table + " values(?,?,?,?,?,?,?)");
                sentence.setString(1, null);
                sentence.setString(2, p.getProNombre());
                sentence.setString(3, p.getProPrecio());
                sentence.setString(4, p.getProStock());
                sentence.setString(5, p.getProFechaVencimiento());
                sentence.setString(6, p.getTblTipoProducto_TipId());
                sentence.setString(7, "1");

                sentence.execute();
                PreparedStatement s = conexion.sentence("select * from " + table + ",TblTipoProducto where TblTipoProducto_TipId = TipProId  order by ProRef desc limit 1");
                ResultSet r = s.executeQuery();
                if (r.next()) {
                    n = new Producto();
                    n.setProRef(r.getString("ProRef"));
                    n.setProNombre(r.getString("ProNombre"));
                    n.setProPrecio(r.getString("ProPrecio"));
                    n.setProStock(r.getString("ProStock"));
                    n.setTblEstado_EstId(r.getString("TblEstado_EstId"));
                    n.setTblTipoProducto_TipId(r.getString("TblTipoProducto_TipId"));
                    n.setTipProNombre(r.getString("TipProNombre"));
                    n.setProFechaVencimiento(r.getString("ProFechaVencimiento"));
                    n.setTblTipoProducto_TipProIva(r.getString("TipProIva"));

                    double iva = (Double.parseDouble(n.getProPrecio()) * Double.parseDouble(n.getTblTipoProducto_TipProIva()) / 100) + Double.parseDouble(n.getProPrecio());
                    n.setProPrecio(String.valueOf(iva));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n;

        }

        return null;
    }

    public boolean update(Producto p) {

        if (DashboardController.getUserInfo().getTblRol_RolId().equals("1")) {

            try {

                PreparedStatement sentence = conexion.sentence("update " + table + " set ProNombre = ?, ProPrecio = ?, ProStock = ?, ProFechaVencimiento = ?, TblTipoProducto_TipId = ?, TblEstado_EstId = ? where ProRef = ?");
                sentence.setString(1, p.getProNombre());
                sentence.setString(2, p.getProPrecio());
                sentence.setString(3, p.getProStock());
                sentence.setString(4, p.getProFechaVencimiento());
                sentence.setString(5, p.getTblTipoProducto_TipId());
                sentence.setString(6, p.getTblEstado_EstId());
                sentence.setString(7, p.getProRef());

                double iva = (Double.parseDouble(p.getProPrecio()) * Double.parseDouble(p.getTblTipoProducto_TipProIva()) / 100) + Double.parseDouble(p.getProPrecio());
                p.setProPrecio(String.valueOf(iva));
                sentence.execute();

                return true;

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }
}
