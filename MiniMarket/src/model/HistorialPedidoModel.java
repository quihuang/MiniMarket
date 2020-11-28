package model;

import controller.DashboardController;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Table.HistorialPedido;
import model.Table.Pedido;
import model.Table.Usuario;

public class HistorialPedidoModel {

    private final Conexion conexion;

    public HistorialPedidoModel() {

        this.conexion = new Conexion();

    }

    public ArrayList<HistorialPedido> getAllPedidos() {

        if (DashboardController.getUserInfo().getTblRol_RolId().equals("1") || DashboardController.getUserInfo().getTblRol_RolId().equals("2")) {
            ArrayList<HistorialPedido> data = new ArrayList<>();
            try {
                PreparedStatement sentence = conexion.sentence("select u.UsuIdentificacion,p.PedId,p.PedFecha,u.UsuNombre1,UsuApellido1 from TblPedido as p,TblUsuario as u where p.TblUsuario_UsuIdentificacion = u.UsuIdentificacion order by p.PedFecha desc");
                ResultSet result = sentence.executeQuery();
                while (result.next()) {
                    HistorialPedido hp = new HistorialPedido();
                    hp.setUsuIdentificacion(result.getString("UsuIdentificacion"));
                    hp.setUsuNombre1(result.getString("UsuNombre1"));
                    hp.setUsuApellido1(result.getString("UsuApellido1"));
                    hp.setPedFecha(result.getString("PedFecha"));
                    hp.setPedId(result.getString("PedId"));

                    data.add(hp);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return data;

        }

        return null;

    }

    public ArrayList<HistorialPedido> getAllPedidos(Usuario u) {
        ArrayList<HistorialPedido> data = new ArrayList<>();
        try {
            PreparedStatement sentence = conexion.sentence("select u.UsuIdentificacion,p.PedId,p.PedFecha,u.UsuNombre1,UsuApellido1 from TblPedido as p,TblUsuario as u where p.TblUsuario_UsuIdentificacion = u.UsuIdentificacion and p.TblUsuario_UsuIdentificacion = ?");
            sentence.setString(1, u.getUsuIdentificacion());
            ResultSet result = sentence.executeQuery();
            while (result.next()) {
                HistorialPedido ep = new HistorialPedido();
                ep.setUsuIdentificacion(result.getString("UsuIdentificacion"));
                ep.setUsuNombre1(result.getString("UsuNombre1"));
                ep.setUsuApellido1(result.getString("UsuApellido1"));
                ep.setPedFecha(result.getString("PedFecha"));
                ep.setPedId(result.getString("PedId"));
                data.add(ep);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;

    }

    public HistorialPedido getOne(Pedido p) {
        HistorialPedido ep = new HistorialPedido();
        try {
            PreparedStatement sentence = conexion.sentence("select u.UsuIdentificacion,p.PedId,p.PedFecha,u.UsuNombre1,UsuApellido1 from TblPedido as p,TblUsuario as u where p.TblUsuario_UsuIdentificacion = u.UsuIdentificacion and p.PedId = ?");
            sentence.setString(1, p.getPedId());
            ResultSet result = sentence.executeQuery();
            while (result.next()) {
                ep.setUsuIdentificacion(result.getString("UsuIdentificacion"));
                ep.setUsuNombre1(result.getString("UsuNombre1"));
                ep.setUsuApellido1(result.getString("UsuApellido1"));
                ep.setPedFecha(result.getString("PedFecha"));
                ep.setPedId(result.getString("PedId"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ep;

    }
}
