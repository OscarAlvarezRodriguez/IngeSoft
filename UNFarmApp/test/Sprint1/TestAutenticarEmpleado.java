package Sprint1;

import Control.AutenticarEmpleado;
import Control.RegistrarEmpleado;
import Entidad.Empleado;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestAutenticarEmpleado {

    private static final AutenticarEmpleado usuario = new AutenticarEmpleado();
    private static final RegistrarEmpleado empleado = new RegistrarEmpleado();

    private final String cn = "Número cedula no válido";
    private final String con = "Longitud contraseña incorrecta";
    private final String conn = "Número en contraseña incorrecto";
    private final String comn = "Mayúscula en contraseña incorrecto";
    private final String di = "Datos incorrectos";
    private final String bi = "Bienvenido";

    public TestAutenticarEmpleado() {
    }

    @BeforeClass
    public static void setUpClass() {
        Empleado u = new Empleado();
        u.setNombreEmpleado("Daniel");
        u.setApellidoEmpleado("Corredor");
        u.setCedulaEmpleado("123456789");
        u.setTelefonoEmpleado("12345678");
        u.setDireccionEmpleado("Carrera 32 No 78b");
        u.setCorreoEmpleado("adolfo@mymail.com");
        u.setContraseniaEmpleado("Dan123");
        empleado.validarDatos(u);
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
    public void LongitudCedula() {

        Empleado u = new Empleado();

        u.setCedulaEmpleado("123456");
        u.setContraseniaEmpleado("Dan123");

        assertEquals(usuario.validarLongitudCedula(u.getCedulaEmpleado()), cn);

        u.setCedulaEmpleado("123456567856");
        u.setContraseniaEmpleado("Dan123");

        assertEquals(usuario.validarLongitudCedula(u.getCedulaEmpleado()), cn);

    }

    @Test
    public void ValidarContrasenia() {

        Empleado u = new Empleado();

        u.setCedulaEmpleado("123456789");
        u.setContraseniaEmpleado("Dan1");
        assertEquals(usuario.validarLongitudContrasenia(u.getContraseniaEmpleado()), con);

        u.setCedulaEmpleado("123456789");
        u.setContraseniaEmpleado("Dani12345678901234567");
        assertEquals(usuario.validarLongitudContrasenia(u.getContraseniaEmpleado()), con);

        u.setCedulaEmpleado("123456789");
        u.setContraseniaEmpleado("dan123");
        assertEquals(usuario.validarMayusculaContrasenia(u.getContraseniaEmpleado()), comn);

        u.setCedulaEmpleado("123456789");
        u.setContraseniaEmpleado("Daniel");

        assertEquals(usuario.validarNumeroContrasenia(u.getContraseniaEmpleado()), conn);
    }

    @Test
    public void NoRegistrado() {

        Empleado u = new Empleado();

        u.setCedulaEmpleado("1032455541");
        u.setContraseniaEmpleado("Contra123");

        assertEquals(usuario.verificarLogin(u), di);

    }

    @Test
    public void UsuarioRegistrado() {

        Empleado u = new Empleado();

        u.setNombreEmpleado("Daniel");
        u.setApellidoEmpleado("Corredor");
        u.setCedulaEmpleado("123456789");
        u.setTelefonoEmpleado("12345678");
        u.setDireccionEmpleado("Carrera 32 No 78b");
        u.setCorreoEmpleado("adolfo@mymail.com");
        u.setContraseniaEmpleado("Dan123");
        assertEquals(usuario.verificarLogin(u), bi);
    }

}
