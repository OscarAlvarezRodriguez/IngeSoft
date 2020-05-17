package Control;

import Entidad.Cliente;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Coneccion {

    private static Connection con = null;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "";
    private static final String url = "jdbc:mysql://127.0.0.1/prueba";
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("UNFarmAppPU");

    public void conector() {
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, pass);
            if (con != null) {
                System.out.println("Coneccion Exitosa");
            }
        } catch (Exception e) {
            System.out.println("Error de Conexion: " + e);
        }
    }

}
