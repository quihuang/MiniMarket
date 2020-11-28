package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Table.Pedido;

public class PedidoModel {

    private final Conexion conexion;
    private final String table;

    public PedidoModel() {
        table = "TblPedido";
        this.conexion = new Conexion();
    }

    public ArrayList<Pedido> getAll() {
        ArrayList<Pedido> data = new ArrayList<>();
        try {
            PreparedStatement sentence = conexion.sentence("select * from " + table + ", TblUsuario,TblMetodoPago where TblUsuario_UsuIdentificacion = UsuIdentificacion and TblMetodoPago_MetId = MedId");
            ResultSet result = sentence.executeQuery();
            while (result.next()) {
                Pedido p = new Pedido();
                p.setPedId(result.getString("PedId"));
                p.setPedFecha(result.getString("PedFecha"));
                p.setTblUsuario_UsuIdentificacion("TblUsuario_UsuIdentificacion");
                p.setTblMetodoPago_MetId(result.getString("TblMetodoPago_MetId"));
                data.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;

    }

    public Pedido create(Pedido p) {

        Pedido n = null;
        try {

            PreparedStatement sentence = conexion.sentence("insert into " + table + " values(?,?,?,?)");
            sentence.setString(1, null);
            sentence.setString(2, p.getPedFecha());
            sentence.setString(3, p.getTblUsuario_UsuIdentificacion());
            sentence.setString(4, p.getTblMetodoPago_MetId());

            sentence.execute();

            PreparedStatement s = conexion.sentence("select PedId from " + table + " order by PedId desc limit 1");
            ResultSet r = s.executeQuery();
            if (r.next()) {
                n = new Pedido();
                n.setPedId(r.getString("PedId"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n;
    }

}
