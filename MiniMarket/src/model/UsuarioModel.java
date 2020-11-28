package model;

import controller.DashboardController;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Table.Usuario;

public class UsuarioModel {

    private Conexion conexion;
    private String table;

    public UsuarioModel() {
        table = "TblUsuario";
        this.conexion = new Conexion();
    }

    public ArrayList<Usuario> getUsersSelect() {

        if (DashboardController.getUserInfo().getTblRol_RolId().equals("1") || DashboardController.getUserInfo().getTblRol_RolId().equals("2")) {
            ArrayList<Usuario> data = new ArrayList<>();
            try {
                PreparedStatement sentence = conexion.sentence("select UsuNombre1,UsuApellido1,UsuIdentificacion from TblUsuario where TblEstado_EstId = 1");
                ResultSet result = sentence.executeQuery();
                while (result.next()) {
                    Usuario u = new Usuario();
                    u.setUsuNombre1(result.getString("UsuNombre1"));
                    u.setUsuApellido1(result.getString("UsuApellido1"));
                    u.setUsuIdentificacion(result.getString("UsuIdentificacion"));
                    data.add(u);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return data;

        }

        return null;

    }

    public ArrayList<Usuario> getAll() {

        if (DashboardController.getUserInfo().getTblRol_RolId().equals("1") || DashboardController.getUserInfo().getTblRol_RolId().equals("2")) {
            ArrayList<Usuario> data = new ArrayList<>();

            try {
                PreparedStatement sentence = conexion.sentence("select * from " + table + " as u, TblEstado as e,TblTipoIdentificacion as ti,TblRol as r where e.EstId = u.TblEstado_EstId and u.TblTipoIdentificacion_TipId = ti.TipId and r.RolId = u.TblRol_RolId");
                ResultSet result = sentence.executeQuery();
                while (result.next()) {
                    Usuario u = new Usuario();
                    u.setUsuIdentificacion(result.getString("UsuIdentificacion"));
                    u.setUsuNombre1(result.getString("UsuNombre1"));
                    u.setUsuNombre2(result.getString("UsuNombre2"));
                    u.setUsuApellido1(result.getString("UsuApellido1"));
                    u.setUsuApellido2(result.getString("UsuApellido2"));
                    u.setUsuCelular(result.getString("UsuCelular"));
                    u.setUsuCorreo(result.getString("UsuCorreo"));
                    u.setTblTipoIdentificacion_TipId(result.getString("TblTipoIdentificacion_TipId"));
                    u.setTblEstado_EstId(result.getString("TblEstado_EstId"));
                    u.setTblRol_RolId(result.getString("TblRol_RolId"));
                    u.setTipNombre(result.getString("TipNombre"));
                    u.setRolNombre(result.getString("RolNombre"));
                    u.setEstEstado(result.getString("EstEstado"));

                    data.add(u);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return data;

        }

        return null;

    }

    public Usuario create(Usuario u) {

        if (DashboardController.getUserInfo().getTblRol_RolId().equals("1") || DashboardController.getUserInfo().getTblRol_RolId().equals("2")) {

            Usuario n = null;
            try {

                PreparedStatement sentence = conexion.sentence("insert into " + table + " values(?,md5(?),?,?,?,?,?,?,?,?,?,?)");
                sentence.setString(1, u.getUsuIdentificacion());
                sentence.setString(2, u.getUsuContrasenia());
                sentence.setString(3, u.getUsuNombre1());
                sentence.setString(4, u.getUsuNombre2());
                sentence.setString(5, u.getUsuApellido1());
                sentence.setString(6, u.getUsuApellido2());
                sentence.setString(7, u.getUsuCelular());
                sentence.setString(8, u.getUsuCorreo());
                sentence.setString(9, u.getTblTipoIdentificacion_TipId());
                sentence.setString(10, u.getTblEstado_EstId());

                if (DashboardController.getUserInfo().getTblRol_RolId().equals("1")) {
                    sentence.setString(11, u.getTblRol_RolId());
                } else {
                    sentence.setString(11, "3");
                }
                sentence.setString(12, null);

                sentence.execute();
                PreparedStatement s = conexion.sentence("select * from " + table + " as u,TblTipoIdentificacion as ti,"
                        + "TblEstado as e,TblRol as r where u.TblTipoIdentificacion_TipId = ti.TipId and "
                        + "u.TblEstado_EstId = e.EstId and u.TblRol_RolId = r.RolId  order by create_at desc limit 1");

                System.out.println(s);
                ResultSet r = s.executeQuery();
                if (r.next()) {
                    n = new Usuario();
                    n.setUsuNombre1(r.getString("UsuNombre1"));
                    n.setUsuNombre2(r.getString("UsuNombre2"));
                    n.setUsuApellido1(r.getString("UsuApellido1"));
                    n.setUsuApellido2(r.getString("UsuApellido2"));
                    n.setUsuIdentificacion(r.getString("UsuIdentificacion"));
                    n.setUsuCelular(r.getString("UsuCelular"));
                    n.setUsuCorreo(r.getString("UsuCorreo"));
                    n.setTblTipoIdentificacion_TipId(r.getString("TblTipoIdentificacion_TipId"));
                    n.setTblEstado_EstId(r.getString("TblEstado_EstId"));
                    n.setTblRol_RolId(r.getString("TblRol_RolId"));
                    n.setTipNombre(r.getString("TipNombre"));
                    n.setEstEstado(r.getString("EstEstado"));
                    n.setRolNombre(r.getString("RolNombre"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return n;

        }
        return null;
    }

    public boolean delete(Usuario u) {

        if (DashboardController.getUserInfo().getTblRol_RolId().equals("1")) {

            try {

                PreparedStatement sentence = conexion.sentence("update " + table + " set TblEstado_EstId = ? where UsuIdentificacion = ?");
                sentence.setString(1, u.getTblEstado_EstId());
                sentence.setString(2, u.getUsuIdentificacion());

                sentence.execute();

                return true;

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;

    }

    public boolean update(Usuario u) {

        if (DashboardController.getUserInfo().getTblRol_RolId().equals("1") || DashboardController.getUserInfo().getTblRol_RolId().equals("2")) {

            try {

                PreparedStatement sentence = conexion.sentence("update " + table + " set UsuNombre1 = ?, UsuNombre2 = ?,UsuApellido1 = ?, UsuApellido2 = ?,UsuCelular = ?, UsuCorreo = ?,TblEstado_EstId = ?, TblRol_RolId  = ?, TblTipoIdentificacion_TipId = ? where UsuIdentificacion = ?");

                sentence.setString(1, u.getUsuNombre1());
                sentence.setString(2, u.getUsuNombre2());
                sentence.setString(3, u.getUsuApellido1());
                sentence.setString(4, u.getUsuApellido2());
                sentence.setString(5, u.getUsuCelular());
                sentence.setString(6, u.getUsuCorreo());
                sentence.setString(7, u.getTblEstado_EstId());
                sentence.setString(8, u.getTblRol_RolId());
                sentence.setString(9, u.getTblTipoIdentificacion_TipId());
                sentence.setString(10, u.getUsuIdentificacion());

                sentence.execute();

                return true;

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

}
