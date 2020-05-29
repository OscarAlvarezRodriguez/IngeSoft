package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

    private PreparedStatement statement;
    private Connection connection;
    /*
        url = a que base de datos me estoy conectando
        user = usuario
        password = contraseña
     */
    private final String url = "jdbc:mysql://localhost:3306/unfarmapp";
    private final String user = "root";
    private final String password = "";

    public PreparedStatement prepareScript(String SQL) {
        try {
            //se obtiene la conexion con la base de datos desde el DriverManager
            connection = DriverManager.getConnection(url, user, password);
            //se prepara wl PreparedStatement con la sentencia SQL
            statement = connection.prepareStatement(SQL);
        } catch (SQLException e) {
        }
        //se retorna el PreparedStatement listo para ser ejecutado
        return statement;
    }
}
