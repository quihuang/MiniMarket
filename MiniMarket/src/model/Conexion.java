package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private Connection conexion;
    private PreparedStatement sentence;

    public Conexion() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            String host = "jdbc:mysql://localhost:3306/bd_mini_proyecto";
            String user = "root"; // root-admin
            String password = ""; //juliocruizt
            conexion = DriverManager.getConnection(host, user, password);

            /*
            if (conexion != null) {
                System.out.println("Conexión Exitosa");
            }
             */
        } catch (SQLException e) {

            conexion = null;
            JOptionPane.showMessageDialog(null, "No se ha podido establecer conexion con la base de datos, verifique que el servidor este encendido", "Error 404 : No se encontro la base de datos", JOptionPane.ERROR_MESSAGE);

            JOptionPane.showMessageDialog(null, "No se ha podido establecer conexion con la base de datos, verifique el servidor", "Error: Conexion a base de datos", JOptionPane.ERROR_MESSAGE);
            System.exit(0);

        } catch (ClassNotFoundException e) {

            conexion = null;

            JOptionPane.showMessageDialog(null, "No se ha podido establecer conexion con la base de datos, verifique que el servidor este encendido", "Error 404 : No se encontro la base de datos", JOptionPane.ERROR_MESSAGE);

            JOptionPane.showMessageDialog(null, "No se ha podido establecer conexion con la base de datos, verifique el servidor", "Error: Conexion a base de datos", JOptionPane.ERROR_MESSAGE);
            System.exit(0);

        }
    }

    public PreparedStatement sentence(String sql) throws SQLException {
        sentence = conexion.prepareStatement(sql);
        return sentence;
    }

}
