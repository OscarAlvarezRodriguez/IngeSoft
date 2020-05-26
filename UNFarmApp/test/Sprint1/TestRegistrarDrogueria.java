package Sprint1;

import Control.RegistrarDrogueria;
import Control.RegistrarEmpleado;
import DAO.DrogueriaDAO;
import DAO.EmpleadoDAO;
import Entidad.Drogueria;
import Entidad.Empleado;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestRegistrarDrogueria {

    private static final RegistrarDrogueria drogueria = new RegistrarDrogueria();
    private static final DrogueriaDAO drogueriaDAOs = new DrogueriaDAO();

    private final String rpn = "Lontigud represetante legal incorrecta";
    private final String nn = "Longitud nombre incorrecta";
    private final String tn = "Número telefónico no válido";
    private final String dn = "Longitud dirección incorrecta";
    private final String en = "Correo no válido";
    private final String co = "Correcto";
    private final String nitn = "Nit no válido";
    private final String re = "Registro exitoso";

    public TestRegistrarDrogueria() {
    }

    @BeforeClass
    public static void setUpClass() {
        Drogueria d = new Drogueria();
        d.setDireccionDrogueria("Carrera 32 No 78b");
        d.setEmailDrogueria("adolfo@mymail.com");
        d.setNitDrogueria("12345678901011");
        d.setNombreDrogueria("MiDroueria123");
        d.setRepresentanteLegalDrogueria("Daniel");
        d.setTelefonoDrogueria("12345678901");
        drogueria.validarDatos(d);

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void LongitudNombre() {
        Drogueria d = new Drogueria();
        d.setDireccionDrogueria("Carrera 32 No 78b");
        d.setEmailDrogueria("adolfo@mymail.com");
        d.setNitDrogueria("12345678901011");
        d.setNombreDrogueria("MiD");
        d.setRepresentanteLegalDrogueria("Daniel");
        d.setTelefonoDrogueria("12345678901");

        assertEquals(drogueria.validarDatos(d), nn);
    }
}
