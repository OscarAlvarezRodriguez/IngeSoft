
package Sprint2;

import Control.EditarCliente;
import Entidad.Cliente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestEditarCliente {
    
    private static final EditarCliente cliente = new EditarCliente();
    private final String cn = "Número cédula no válido";
    private final String nn = "Lontigud nombre incorrecta";
    private final String tn = "Número telefónico no válido";
    private final String dn = "Longitud dirección incorrecta";
    private final String ddn = "Longitud descripción dirección incorrecta";
    private final String an = "Longitud apellido incorrecta";
    private final String cr = "Cliente no registrado";
    private final String re = "Actualización correcta";
    
    public TestEditarCliente() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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

        Cliente u = new Cliente();
        u.setCedulacliente("123456789");
        u.setDescripciondireccion("Conjunto Residencial Mirador II");
        u.setDireccioncliente("Carrera 52 No 33b");
        u.setNombre("Paul");
        u.setApellido("Cardenas");
        u.setTelefono("12345678"); 

        assertEquals(cliente.validarNombre(u.getNombre()), nn);

        u.setCedulacliente("123456789");
        u.setDescripciondireccion("Conjunto Residencial Mirador II");
        u.setDireccioncliente("Carrera 52 No 33b");
        u.setNombre("Paula Andrea Valencia");
        u.setApellido("Cardenas");
        u.setTelefono("12345678");

        assertEquals(cliente.validarNombre(u.getNombre()), nn);
    }

    @Test
    public void LongitudApellido() {

        Cliente u = new Cliente();
        u.setCedulacliente("123456789");
        u.setDescripciondireccion("Conjunto Residencial Mirador II");
        u.setDireccioncliente("Carrera 52 No 33b");
        u.setNombre("Paula");
        u.setApellido("Caro");
        u.setTelefono("12345678"); 
        assertEquals(cliente.validarApellido(u.getApellido()), an);

        u.setCedulacliente("123456789");
        u.setDescripciondireccion("Conjunto Residencial Mirador II");
        u.setDireccioncliente("Carrera 52 No 33b");
        u.setNombre("Paula");
        u.setApellido("Cardenas Valencia Roa");
        u.setTelefono("12345678");
        assertEquals(cliente.validarApellido(u.getApellido()), an);
    }

    @Test
    public void LongitudCedula() {

        Cliente u = new Cliente();
        u.setCedulacliente("123456");
        u.setDescripciondireccion("Conjunto Residencial Mirador II");
        u.setDireccioncliente("Carrera 52 No 33b");
        u.setNombre("Paula");
        u.setApellido("Cardenas");
        u.setTelefono("12345678"); 

        assertEquals(cliente.validarCedula(u.getCedulacliente()), cn);

        u.setCedulacliente("123456789012");
        u.setDescripciondireccion("Conjunto Residencial Mirador II");
        u.setDireccioncliente("Carrera 52 No 33b");
        u.setNombre("Paula");
        u.setApellido("Cardenas");
        u.setTelefono("12345678");

        assertEquals(cliente.validarCedula(u.getCedulacliente()), cn);
    }

    @Test
    public void LongitudTelefono() {

        Cliente u = new Cliente();
        u.setCedulacliente("123456789");
        u.setDescripciondireccion("Conjunto Residencial Mirador II");
        u.setDireccioncliente("Carrera 52 No 33b");
        u.setNombre("Paula");
        u.setApellido("Cardenas");
        u.setTelefono("123456"); 

        assertEquals(cliente.validarTelefono(u.getTelefono()), tn);

        u.setCedulacliente("123456789");
        u.setDescripciondireccion("Conjunto Residencial Mirador II");
        u.setDireccioncliente("Carrera 52 No 33b");
        u.setNombre("Paula");
        u.setApellido("Cardenas");
        u.setTelefono("1234567890123456");

        assertEquals(cliente.validarTelefono(u.getTelefono()), tn);
        
    }

    @Test
    public void LongitudDireccion() {

        Cliente u = new Cliente();
        u.setCedulacliente("123456789");
        u.setDescripciondireccion("Conjunto Residencial Mirador II");
        u.setDireccioncliente("Carrera 52");
        u.setNombre("Paula");
        u.setApellido("Cardenas");
        u.setTelefono("12345678"); 

        assertEquals(cliente.validarDireccion(u.getDireccioncliente()), dn);

        u.setCedulacliente("123456789");
        u.setDescripciondireccion("Conjunto Residencial Mirador II");
        u.setDireccioncliente("Carrera 8 No 33b - 83 Torre 5 603");
        u.setNombre("Paula");
        u.setApellido("Cardenas");
        u.setTelefono("12345678");

        assertEquals(cliente.validarDireccion(u.getDireccioncliente()), dn);
    }

    @Test
    public void LongitudDescripcion() {

        Cliente u = new Cliente();
        u.setCedulacliente("123456789");
        u.setDescripciondireccion("Conjunto Residencial Mirador II B");
        u.setDireccioncliente("Carrera 52 No 33b");
        u.setNombre("Paula");
        u.setApellido("Cardenas");
        u.setTelefono("12345678");

        assertEquals(cliente.validarDescripcionDir(u.getDescripciondireccion()), ddn);
        
    }
    
        @Test
    public void ActualizacionCorrecta() {

        Cliente u = new Cliente();
        u.setCedulacliente("123456789");
        u.setDescripciondireccion("Conjunto Residencial Mirador II");
        u.setDireccioncliente("Carrera 52 No 33b");
        u.setNombre("Paula");
        u.setApellido("Cardenas");
        u.setTelefono("12345678"); 
        assertEquals(cliente.ValidarDatos("9876543", u), re);

    }

    @Test
    public void No_Registrado() {

        Cliente u = new Cliente();
        u.setCedulacliente("10101010");
        u.setDescripciondireccion("Conjunto Residencial Mirador II");
        u.setDireccioncliente("Carrera 52 No 33b");
        u.setNombre("Jessica");
        u.setApellido("Cardenas");
        u.setTelefono("12345678"); 
        assertEquals(cliente.ValidarDatos(u.getCedulacliente() ,u), cr);
   
    }
}
