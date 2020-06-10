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
        u.setNombreempleado("Daniel");
        u.setApellidoempleado("Corredor");
        u.setCedulaempleado("123456789");
        u.setTelefono("12345678");
        u.setDireccionempleado("Carrera 32 No 78b");
        u.setCorreo("adolfo@mymail.com");
        u.setContrasenia("Dan123");
        u.setEstado("ACTIVO");
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

        u.setCedulaempleado("123456");
        u.setContrasenia("Dan123");

        assertEquals(usuario.validarLongitudCedula(u.getCedulaempleado()), cn);

        u.setCedulaempleado("123456567856");
        u.setContrasenia("Dan123");

        assertEquals(usuario.validarLongitudCedula(u.getCedulaempleado()), cn);

    }

    @Test
    public void ValidarContrasenia() {

        Empleado u = new Empleado();

        u.setCedulaempleado("123456789");
        u.setContrasenia("Dan1");
        assertEquals(usuario.validarLongitudContrasenia(u.getContrasenia()), con);

        u.setCedulaempleado("123456789");
        u.setContrasenia("Dani12345678901234567");
        assertEquals(usuario.validarLongitudContrasenia(u.getContrasenia()), con);

        u.setCedulaempleado("123456789");
        u.setContrasenia("dan123");
        assertEquals(usuario.validarMayusculaContrasenia(u.getContrasenia()), comn);

        u.setCedulaempleado("123456789");
        u.setContrasenia("Daniel");

        assertEquals(usuario.validarNumeroContrasenia(u.getContrasenia()), conn);
    }

    @Test
    public void NoRegistrado() {

        Empleado u = new Empleado();

        u.setCedulaempleado("1032455541");
        u.setContrasenia("Contra123");

        assertEquals(usuario.verificarLogin(u), di);

    }

    @Test
    public void UsuarioRegistrado() {

        Empleado u = new Empleado();

        u.setNombreempleado("Daniel");
        u.setApellidoempleado("Corredor");
        u.setCedulaempleado("123456789");
        u.setTelefono("12345678");
        u.setDireccionempleado("Carrera 32 No 78b");
        u.setCorreo("adolfo@mymail.com");
        u.setContrasenia("Dan123");
        u.setEstado("ACTIVO");

        assertEquals(usuario.verificarLogin(u), bi);
    }

}
