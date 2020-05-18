package Control;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Coneccion {

    private Connection con = null;
    private final String driver = "com.mysql.jdbc.Driver";
    private final String user = "root";
    private final String pass = "";
    private final String url = "jdbc:mysql://localhost:3306/mysql";
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("UNFarmAppPU");

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
