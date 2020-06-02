package Sprint2;

import Control.AutenticarCliente;
import Control.RegistrarCliente;
import Entidad.Cliente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestAutenticarCliente {
    
    private static final AutenticarCliente usuario = new AutenticarCliente();
    private static final RegistrarCliente cliente = new RegistrarCliente();
    
    private final String cn = "Número cédula no válido";
    private final String cr = "Cliente no registrado";
    private final String bi = "Bienvenido";
    
    public TestAutenticarCliente() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        Cliente u = new Cliente();
        u.setCedulaCliente("123456789");
        u.setDescripcionDireccionCliente("Conjunto Residencial Mirador II");
        u.setDireccionCliente("Carrera 52 No 33b");
        u.setNombreCliente("Paula");
        u.setApellidoCliente("Cardenas");
        u.setTelefonoCliente("12345678"); 
        cliente.ValidarDatos(u);
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

        Cliente u = new Cliente();

        u.setCedulaCliente("123456");
        assertEquals(usuario.validarCedula(u.getCedulaCliente()), cn);

        u.setCedulaCliente("123456567856");
        assertEquals(usuario.validarCedula(u.getCedulaCliente()), cn);

    }
    
    @Test
    public void NoRegistrado() {

        Cliente u = new Cliente();
        u.setCedulaCliente("1032455541");
        assertEquals(usuario.verificarLogin(u), cr);
    }
    
    @Test
    public void UsuarioRegistrado() {

        Cliente u = new Cliente();

        u.setCedulaCliente("123456789");
        assertEquals(usuario.verificarLogin(u), bi);

    }
    
    
}