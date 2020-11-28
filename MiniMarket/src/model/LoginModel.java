package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Table.Usuario;

public class LoginModel {

    private Conexion conexion;
    private String tabla;
    private Usuario userInfo;

    public LoginModel() {

        tabla = "TblUsuario";
        conexion = new Conexion();

    }

    public boolean login(String user, String pass) {

        ResultSet registro = null;
        try {

            PreparedStatement sentence = conexion.sentence("select * from " + tabla + ",TblRol,TblTipoIdentificacion where TblRol_RolId = RolId and TblTipoIdentificacion_TipId = TipId and UsuIdentificacion = ? and UsuContrasenia = md5(?) and TblEstado_EstId = 1");
            sentence.setString(1, user);
            sentence.setString(2, pass);
            registro = sentence.executeQuery();
            if (registro.next()) {

                userInfo = new Usuario();
                userInfo.setUsuNombre1(registro.getString("UsuNombre1"));
                userInfo.setUsuNombre2(registro.getString("UsuNombre2"));
                userInfo.setUsuApellido1(registro.getString("UsuApellido1"));
                userInfo.setUsuApellido2(registro.getString("UsuApellido1"));
                userInfo.setUsuIdentificacion(registro.getString("UsuIdentificacion"));
                userInfo.setUsuCelular(registro.getString("UsuCelular"));
                userInfo.setUsuCorreo(registro.getString("UsuCorreo"));
                userInfo.setTblTipoIdentificacion_TipId(registro.getString("TblTipoIdentificacion_TipId"));
                userInfo.setTblEstado_EstId(registro.getString("TblEstado_EstId"));
                userInfo.setTblRol_RolId(registro.getString("TblRol_RolId"));
                userInfo.setTipNombre(registro.getString("TipNombre"));
                userInfo.setRolNombre(registro.getString("RolNombre"));

                return true;

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;

    }

    public Usuario getInfo() {
        return userInfo;
    }

}
