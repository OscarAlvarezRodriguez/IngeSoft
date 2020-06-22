package Sprint3;

import Control.RegistrarAdministrador;
import DAO.EmpleadoDAO;
import Entidad.Empleado;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestRegistrarAdministrador {
    
    private static  RegistrarAdministrador administrador = new RegistrarAdministrador();
    private final String cn = "Cédula no válida";
    private final String con = "Longitud contraseña incorrecta";
    private final String conn = "Número en contraseña incorrecto";
    private final String comn = "Mayúscula en contraseña incorrecto";
    private final String nn = "Longitud nombre incorrecta";
    private final String tn = "Número telefónico no válido";
    private final String dn = "Longitud dirección incorrecta";
    private final String an = "Longitud apellido incorrecta";
    private final String en = "Correo no válido";
    private final String er = "El empleado ya está registrado";
    private final String re = "Registro exitoso";
    
    public TestRegistrarAdministrador() {
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
        u.setEstado("ADMINISTRADOR");
        administrador.validarDatos(u);
        
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
        u.setNombreempleado("Dan");
        u.setApellidoempleado("Corredor");
        u.setCedulaempleado("123456789");
        u.setTelefono("12345678");
        u.setDireccionempleado("Carrera 32 No 78b");
        u.setCorreo("adolfo@mymail.com");
        u.setContrasenia("Dan123");
        u.setEstado("ADMINISTRADOR");

        assertEquals(administrador.validarNombre(u.getNombreempleado()), nn);

        u.setNombreempleado("DanielSantiagoCorredor");
        u.setApellidoempleado("Corredor");
        u.setCedulaempleado("123456789");
        u.setTelefono("12345678");
        u.setDireccionempleado("Carrera 32 No 78b");
        u.setCorreo("adolfo@mymail.com");
        u.setContrasenia("Dan123");
        u.setEstado("ADMINISTRADOR");

        assertEquals(administrador.validarNombre(u.getNombreempleado()), nn);
    }

    @Test
    public void LongitudApellido() {

        Empleado u = new Empleado();
        u.setNombreempleado("Daniel");
        u.setApellidoempleado("Roa");
        u.setCedulaempleado("123456789");
        u.setTelefono("12345678");
        u.setDireccionempleado("Carrera 32 No 78b");
        u.setCorreo("adolfo@mymail.com");
        u.setContrasenia("Dan123");
        u.setEstado("ADMINISTRADOR");

        assertEquals(administrador.validarApellido(u.getApellidoempleado()), an);

        u.setNombreempleado("Daniel");
        u.setApellidoempleado("CorredorRuizGaleanoSuarez");
        u.setCedulaempleado("123456789");
        u.setTelefono("12345678");
        u.setDireccionempleado("Carrera 32 No 78b");
        u.setCorreo("adolfo@mymail.com");
        u.setContrasenia("Dan123");
        u.setEstado("ADMINISTRADOR");
        assertEquals(administrador.validarApellido(u.getApellidoempleado()), an);
    }

    @Test
    public void LongitudCedula() {

        Empleado u = new Empleado();

        u.setNombreempleado("Daniel");
        u.setApellidoempleado("Corredor");
        u.setCedulaempleado("123456");
        u.setTelefono("12345678");
        u.setDireccionempleado("Carrera 32 No 78b");
        u.setCorreo("adolfo@mymail.com");
        u.setContrasenia("Dan123");
        u.setEstado("ADMINISTRADOR");

        assertEquals(administrador.validarCedula(u.getCedulaempleado()), cn);

        u.setNombreempleado("Daniel");
        u.setApellidoempleado("Corredor");
        u.setCedulaempleado("123456567856");
        u.setTelefono("12345678");
        u.setDireccionempleado("Carrera 32 No 78b");
        u.setCorreo("adolfo@mymail.com");
        u.setContrasenia("Dan123");
        u.setEstado("ADMINISTRADOR");
        assertEquals(administrador.validarCedula(u.getCedulaempleado()), cn);
    }

    @Test
    public void LongitudTelefono() {

        Empleado u = new Empleado();
        u.setNombreempleado("Daniel");
        u.setApellidoempleado("Corredor");
        u.setCedulaempleado("123456789");
        u.setTelefono("123456");
        u.setDireccionempleado("Carrera 32 No 78b");
        u.setCorreo("adolfo@mymail.com");
        u.setContrasenia("Dan123");
        u.setEstado("ADMINISTRADOR");

        assertEquals(administrador.validarTelefono(u.getTelefono()), tn);

        u.setNombreempleado("Daniel");
        u.setApellidoempleado("Corredor");
        u.setCedulaempleado("123456789");
        u.setTelefono("1234561243254671");
        u.setDireccionempleado("Carrera 32 No 78b");
        u.setCorreo("adolfo@mymail.com");
        u.setContrasenia("Dan123");
        u.setEstado("ADMINISTRADOR");
        assertEquals(administrador.validarTelefono(u.getTelefono()), tn);
    }

    @Test
    public void LongitudDireccion() {

        Empleado u = new Empleado();
        u.setNombreempleado("Daniel");
        u.setApellidoempleado("Corredor");
        u.setCedulaempleado("123456789");
        u.setTelefono("12345678");
        u.setDireccionempleado("Carrera 32A");
        u.setCorreo("adolfo@mymail.com");
        u.setContrasenia("Dan123");
        u.setEstado("ADMINISTRADOR");

        assertEquals(administrador.validarDireccion(u.getDireccionempleado()), dn);

        u.setNombreempleado("Daniel");
        u.setApellidoempleado("Corredor");
        u.setCedulaempleado("123456789");
        u.setTelefono("12345678");
        u.setDireccionempleado("“Carrera 32A, Número 159, bis 89 b");
        u.setCorreo("adolfo@mymail.com");
        u.setContrasenia("Dan123");
        u.setEstado("ADMINISTRADOR");
        assertEquals(administrador.validarDireccion(u.getDireccionempleado()), dn);
    }

    @Test
    public void Correo() {

        Empleado u = new Empleado();
        u.setNombreempleado("Daniel");
        u.setApellidoempleado("Corredor");
        u.setCedulaempleado("123456789");
        u.setTelefono("12345678");
        u.setDireccionempleado("Carrera 32 No 78b");
        u.setCorreo("a@ml.com");
        u.setContrasenia("Dan123");
        u.setEstado("ADMINISTRADOR");

        assertEquals(administrador.validarCorreo(u.getCorreo()), en);

        u.setNombreempleado("Daniel");
        u.setApellidoempleado("Corredor");
        u.setCedulaempleado("123456789");
        u.setTelefono("12345678");
        u.setDireccionempleado("Carrera 32 No 78b");
        u.setCorreo("adolfoestrella1995eldolfzapateromartinez@mymail.com");
        u.setContrasenia("Dan123");
        u.setEstado("ADMINISTRADOR");
        assertEquals(administrador.validarCorreo(u.getCorreo()), en);

        u.setNombreempleado("Daniel");
        u.setApellidoempleado("Corredor");
        u.setCedulaempleado("123456789");
        u.setTelefono("12345678");
        u.setDireccionempleado("Carrera 32 No 78b");
        u.setCorreo("adolfo#mymail.com");
        u.setContrasenia("Dan123");
        u.setEstado("ADMINISTRADOR");
        assertEquals(administrador.validarCorreo(u.getCorreo()), en);

        u.setNombreempleado("Daniel");
        u.setApellidoempleado("Corredor");
        u.setCedulaempleado("123456789");
        u.setTelefono("12345678");
        u.setDireccionempleado("Carrera 32 No 78b");
        u.setCorreo("adolfo@mymailcom");
        u.setContrasenia("Dan123");
        u.setEstado("ADMINISTRADOR");
        assertEquals(administrador.validarCorreo(u.getCorreo()), en);

        u.setNombreempleado("Daniel");
        u.setApellidoempleado("Corredor");
        u.setCedulaempleado("123456789");
        u.setTelefono("12345678");
        u.setDireccionempleado("Carrera 32 No 78b");
        u.setCorreo("adolfomymailcom");
        u.setContrasenia("Dan123");
        u.setEstado("ADMINISTRADOR");
        assertEquals(administrador.validarCorreo(u.getCorreo()), en);

    }

    @Test
    public void Contrasenia() {

        Empleado u = new Empleado();
        u.setNombreempleado("Daniel");
        u.setApellidoempleado("Corredor");
        u.setCedulaempleado("123456789");
        u.setTelefono("12345678");
        u.setDireccionempleado("Carrera 32 No 78b");
        u.setCorreo("adolfo@mymail.com");
        u.setContrasenia("Dan1");
        u.setEstado("ADMINISTRADOR");

        assertEquals(administrador.validarLongitudContrasenia(u.getContrasenia()), con);

        u.setNombreempleado("Daniel");
        u.setApellidoempleado("Corredor");
        u.setCedulaempleado("123456789");
        u.setTelefono("12345678");
        u.setDireccionempleado("Carrera 32 No 78b");
        u.setCorreo("adolfo@mymail.com");
        u.setContrasenia("Dani12345678901234567");
        u.setEstado("ADMINISTRADOR");
        assertEquals(administrador.validarLongitudContrasenia(u.getContrasenia()), con);

        u.setNombreempleado("Daniel");
        u.setApellidoempleado("Corredor");
        u.setCedulaempleado("123456789");
        u.setTelefono("12345678");
        u.setDireccionempleado("Carrera 32 No 78b");
        u.setCorreo("adolfo@mymail.com");
        u.setContrasenia("dan123");
        u.setEstado("ADMINISTRADOR");

        assertEquals(administrador.validarMayusculaContrasenia(u.getContrasenia()), comn);

        u.setNombreempleado("Daniel");
        u.setApellidoempleado("Corredor");
        u.setCedulaempleado("123456789");
        u.setTelefono("12345678");
        u.setDireccionempleado("Carrera 32 No 78b");
        u.setCorreo("adolfo@mymail.com");
        u.setContrasenia("Daniel");
        u.setEstado("ADMINISTRADOR");

        assertEquals(administrador.validarNumeroContrasenia(u.getContrasenia()), conn);
    }

   /* @Test
    public void Reg_Exitoso() {

        Empleado u = new Empleado();
        u.setNombreempleado("Santiago");
        u.setApellidoempleado("Galindo");
        u.setCedulaempleado("198765432");
        u.setTelefono("31386946978");
        u.setDireccionempleado("Calle 59, No 98 - 32");
        u.setCorreo("santiago@mymail.com");
        u.setContrasenia("San123");
        u.setEstado("ADMINISTRADOR");
        assertEquals(administrador.validarDatos(u), re);

    }*/

   @Test
    public void Ya_Registrado() {

        Empleado u = new Empleado();
        u.setNombreempleado("Daniel");
        u.setApellidoempleado("Corredor");
        u.setCedulaempleado("123456789");
        u.setTelefono("12345678");
        u.setDireccionempleado("Carrera 32 No 78b");
        u.setCorreo("adolfo@mymail.com");
        u.setContrasenia("Dan123");
        u.setEstado("ADMINISTRADOR");
        assertEquals(administrador.validarDatos(u), er);
    }

}
