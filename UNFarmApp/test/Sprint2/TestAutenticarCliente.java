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
    private final String bi = "Bienvenido";
    private final String cnr = "Cliente no registrado";
    private final String ci = "Cliente inactivo";
    
    public TestAutenticarCliente() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        Cliente u = new Cliente();
        u.setCedulacliente("123456789");
        u.setDescripciondireccion("Conjunto Residencial Mirador II");
        u.setDireccioncliente("Carrera 52 No 33b");
        u.setNombre("Paula");
        u.setApellido("Cardenas");
        u.setTelefono("12345678"); 
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

        u.setCedulacliente("123456");
        assertEquals(usuario.validarCedula(u.getCedulacliente()), cn);

        u.setCedulacliente("123456567856");
        assertEquals(usuario.validarCedula(u.getCedulacliente()), cn);

    }
    
    @Test
    public void Inactivo() {

        Cliente u = new Cliente();
        u.setCedulacliente("19432162");
        assertEquals(usuario.verificarLogin(u.getCedulacliente()), ci);
    }
    
    @Test
    public void UsuarioRegistrado() {

        Cliente u = new Cliente();
        u.setCedulacliente("123456789");
        assertEquals(usuario.verificarLogin(u.getCedulacliente()), bi);
    }
    
    @Test
    public void NoRegistrado() {

        Cliente u = new Cliente();
        u.setCedulacliente("1032455541");
        assertEquals(usuario.verificarLogin(u.getCedulacliente()), cnr);
    }
    
    
}