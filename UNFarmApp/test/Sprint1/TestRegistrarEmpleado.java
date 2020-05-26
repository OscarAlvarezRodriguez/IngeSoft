package Sprint1;

import Control.RegistrarEmpleado;
import DAO.EmpleadoDAO;
import Entidad.Empleado;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestRegistrarEmpleado {

    private static final RegistrarEmpleado empleado = new RegistrarEmpleado();
    private static final EmpleadoDAO empleadoDao = new EmpleadoDAO();

    private final String cn = "Cédula no válida";
    private final String con = "Longitud contraseña incorrecta";
    private final String conn = "Número en contraseña incorrecto";
    private final String comn = "Mayúscula en contraseña incorrecto";
    private final String nn = "Longitud nombre incorrecta";
    private final String tn = "Número telefónico no válido";
    private final String dn = "Longitud dirección incorrecta";
    private final String an = "Longitud apellido incorrecta";
    private final String en = "Correo no válido";
    private final String re = "Registro exitoso";
    private final String co = "Correcto";
    private final String rs = "El empleado ya está registrado";

    public TestRegistrarEmpleado() {

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
    public void LongitudNombre() {

        Empleado u = new Empleado();
        u.setNombreEmpleado("Dan");
        u.setApellidoEmpleado("Corredor");
        u.setCedulaEmpleado("123456789");
        u.setTelefonoEmpleado("12345678");
        u.setDireccionEmpleado("Carrera 32 No 78b");
        u.setCorreoEmpleado("adolfo@mymail.com");
        u.setContraseniaEmpleado("Dan123");

        assertEquals(empleado.validarDatos(u), nn);

        u.setNombreEmpleado("DanielSantiagoCorredor");
        u.setApellidoEmpleado("Corredor");
        u.setCedulaEmpleado("123456789");
        u.setTelefonoEmpleado("12345678");
        u.setDireccionEmpleado("Carrera 32 No 78b");
        u.setCorreoEmpleado("adolfo@mymail.com");
        u.setContraseniaEmpleado("Dan123");

        assertEquals(empleado.validarDatos(u), nn);
    }

    @Test
    public void LongitudApellido() {

        Empleado u = new Empleado();
        u.setNombreEmpleado("Daniel");
        u.setApellidoEmpleado("Roa");
        u.setCedulaEmpleado("123456789");
        u.setTelefonoEmpleado("12345678");
        u.setDireccionEmpleado("Carrera 32 No 78b");
        u.setCorreoEmpleado("adolfo@mymail.com");
        u.setContraseniaEmpleado("Dan123");

        assertEquals(empleado.validarDatos(u), an);

        u.setNombreEmpleado("Daniel");
        u.setApellidoEmpleado("CorredorRuizGaleanoSuarez");
        u.setCedulaEmpleado("123456789");
        u.setTelefonoEmpleado("12345678");
        u.setDireccionEmpleado("Carrera 32 No 78b");
        u.setCorreoEmpleado("adolfo@mymail.com");
        u.setContraseniaEmpleado("Dan123");
        assertEquals(empleado.validarDatos(u), an);
    }

    @Test
    public void LongitudCedula() {

        Empleado u = new Empleado();

        u.setNombreEmpleado("Daniel");
        u.setApellidoEmpleado("Corredor");
        u.setCedulaEmpleado("123456");
        u.setTelefonoEmpleado("12345678");
        u.setDireccionEmpleado("Carrera 32 No 78b");
        u.setCorreoEmpleado("adolfo@mymail.com");
        u.setContraseniaEmpleado("Dan123");

        assertEquals(empleado.validarDatos(u), cn);

        u.setNombreEmpleado("Daniel");
        u.setApellidoEmpleado("Corredor");
        u.setCedulaEmpleado("123456567856");
        u.setTelefonoEmpleado("12345678");
        u.setDireccionEmpleado("Carrera 32 No 78b");
        u.setCorreoEmpleado("adolfo@mymail.com");
        u.setContraseniaEmpleado("Dan123");
        assertEquals(empleado.validarDatos(u), cn);
    }

    @Test
    public void LongitudTelefono() {

        Empleado u = new Empleado();
        u.setNombreEmpleado("Daniel");
        u.setApellidoEmpleado("Corredor");
        u.setCedulaEmpleado("123456789");
        u.setTelefonoEmpleado("123456");
        u.setDireccionEmpleado("Carrera 32 No 78b");
        u.setCorreoEmpleado("adolfo@mymail.com");
        u.setContraseniaEmpleado("Dan123");

        assertEquals(empleado.validarDatos(u), tn);

        u.setNombreEmpleado("Daniel");
        u.setApellidoEmpleado("Corredor");
        u.setCedulaEmpleado("123456789");
        u.setTelefonoEmpleado("1234561243254671");
        u.setDireccionEmpleado("Carrera 32 No 78b");
        u.setCorreoEmpleado("adolfo@mymail.com");
        u.setContraseniaEmpleado("Dan123");
        assertEquals(empleado.validarDatos(u), tn);
    }

    @Test
    public void LongitudDireccion() {

        Empleado u = new Empleado();
        u.setNombreEmpleado("Daniel");
        u.setApellidoEmpleado("Corredor");
        u.setCedulaEmpleado("123456789");
        u.setTelefonoEmpleado("12345678");
        u.setDireccionEmpleado("Carrera 32A");
        u.setCorreoEmpleado("adolfo@mymail.com");
        u.setContraseniaEmpleado("Dan123");

        assertEquals(empleado.validarDatos(u), dn);

        u.setNombreEmpleado("Daniel");
        u.setApellidoEmpleado("Corredor");
        u.setCedulaEmpleado("123456789");
        u.setTelefonoEmpleado("12345678");
        u.setDireccionEmpleado("“Carrera 32A, Número 159, bis 89 b");
        u.setCorreoEmpleado("adolfo@mymail.com");
        u.setContraseniaEmpleado("Dan123");
        assertEquals(empleado.validarDatos(u), dn);
    }

    @Test
    public void Correo() {

        Empleado u = new Empleado();
        u.setNombreEmpleado("Daniel");
        u.setApellidoEmpleado("Corredor");
        u.setCedulaEmpleado("123456789");
        u.setTelefonoEmpleado("12345678");
        u.setDireccionEmpleado("Carrera 32 No 78b");
        u.setCorreoEmpleado("a@ml.com");
        u.setContraseniaEmpleado("Dan123");

        assertEquals(empleado.validarDatos(u), en);

        u.setNombreEmpleado("Daniel");
        u.setApellidoEmpleado("Corredor");
        u.setCedulaEmpleado("123456789");
        u.setTelefonoEmpleado("12345678");
        u.setDireccionEmpleado("Carrera 32 No 78b");
        u.setCorreoEmpleado("adolfoestrella1995eldolfzapateromartinez@mymail.com");
        u.setContraseniaEmpleado("Dan123");
        assertEquals(empleado.validarDatos(u), en);

        u.setNombreEmpleado("Daniel");
        u.setApellidoEmpleado("Corredor");
        u.setCedulaEmpleado("123456789");
        u.setTelefonoEmpleado("12345678");
        u.setDireccionEmpleado("Carrera 32 No 78b");
        u.setCorreoEmpleado("adolfo#mymail.com");
        u.setContraseniaEmpleado("Dan123");
        assertEquals(empleado.validarDatos(u), en);

        u.setNombreEmpleado("Daniel");
        u.setApellidoEmpleado("Corredor");
        u.setCedulaEmpleado("123456789");
        u.setTelefonoEmpleado("12345678");
        u.setDireccionEmpleado("Carrera 32 No 78b");
        u.setCorreoEmpleado("adolfo@mymailcom");
        u.setContraseniaEmpleado("Dan123");
        assertEquals(empleado.validarDatos(u), en);

        u.setNombreEmpleado("Daniel");
        u.setApellidoEmpleado("Corredor");
        u.setCedulaEmpleado("123456789");
        u.setTelefonoEmpleado("12345678");
        u.setDireccionEmpleado("Carrera 32 No 78b");
        u.setCorreoEmpleado("adolfomymailcom");
        u.setContraseniaEmpleado("Dan123");
        assertEquals(empleado.validarDatos(u), en);

    }

    @Test
    public void Contrasenia() {

        Empleado u = new Empleado();
        u.setNombreEmpleado("Daniel");
        u.setApellidoEmpleado("Corredor");
        u.setCedulaEmpleado("123456789");
        u.setTelefonoEmpleado("12345678");
        u.setDireccionEmpleado("Carrera 32 No 78b");
        u.setCorreoEmpleado("adolfo@mymail.com");
        u.setContraseniaEmpleado("Dan1");

        assertEquals(empleado.validarDatos(u), con);

        u.setNombreEmpleado("Daniel");
        u.setApellidoEmpleado("Corredor");
        u.setCedulaEmpleado("123456789");
        u.setTelefonoEmpleado("12345678");
        u.setDireccionEmpleado("Carrera 32 No 78b");
        u.setCorreoEmpleado("adolfo@mymail.com");
        u.setContraseniaEmpleado("Dani12345678901234567");
        assertEquals(empleado.validarDatos(u), con);

        u.setNombreEmpleado("Daniel");
        u.setApellidoEmpleado("Corredor");
        u.setCedulaEmpleado("123456789");
        u.setTelefonoEmpleado("12345678");
        u.setDireccionEmpleado("Carrera 32 No 78b");
        u.setCorreoEmpleado("adolfo@mymail.com");
        u.setContraseniaEmpleado("dan123");
        assertEquals(empleado.validarDatos(u), comn);

        u.setNombreEmpleado("Daniel");
        u.setApellidoEmpleado("Corredor");
        u.setCedulaEmpleado("123456789");
        u.setTelefonoEmpleado("12345678");
        u.setDireccionEmpleado("Carrera 32 No 78b");
        u.setCorreoEmpleado("adolfo@mymail.com");
        u.setContraseniaEmpleado("Daniel");
        assertEquals(empleado.validarDatos(u), conn);
    }

    @Test
    public void Reg_Exitoso() {

        Empleado u = new Empleado();
        u.setNombreEmpleado("Santiago");
        u.setApellidoEmpleado("Galindo");
        u.setCedulaEmpleado("198765432");
        u.setTelefonoEmpleado("31386946978");
        u.setDireccionEmpleado("Calle 59, No 98 - 32");
        u.setCorreoEmpleado("santiago@mymail.com");
        u.setContraseniaEmpleado("San123");
        assertEquals(empleado.validarDatos(u), re);
        empleadoDao.eliminar(u);

    }

    @Test
    public void Ya_Registrado() {

        Empleado u = new Empleado();
        u.setNombreEmpleado("Daniel");
        u.setApellidoEmpleado("Corredor");
        u.setCedulaEmpleado("123456789");
        u.setTelefonoEmpleado("12345678");
        u.setDireccionEmpleado("Carrera 32 No 78b");
        u.setCorreoEmpleado("adolfo@mymail.com");
        u.setContraseniaEmpleado("Dan123");
        assertEquals(empleado.validarDatos(u), rs);

    }

}
