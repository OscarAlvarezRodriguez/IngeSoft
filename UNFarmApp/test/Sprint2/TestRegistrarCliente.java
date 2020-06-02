package Sprint2;

import Control.RegistrarCliente;
import DAO.ClienteDAO;
import Entidad.Cliente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestRegistrarCliente {
    
    private static final RegistrarCliente cliente = new RegistrarCliente();
    private static final ClienteDAO clienteDao = new ClienteDAO();
    private final String cn = "Número cédula no válido";
    private final String nn = "Lontigud nombre incorrecta";
    private final String tn = "Número telefónico no válido";
    private final String dn = "Longitud dirección incorrecta";
    private final String ddn = "Longitud descripción dirección incorrecta";
    private final String an = "Longitud apellido incorrecta";
    private final String cr = "Cliente ya registrado";
    private final String re = "Registro exitoso";
    
    
    public TestRegistrarCliente() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    /*  
        Cliente u = new Cliente();
        u.setCedulaCliente("123456789");
        u.setDescripcionDireccionCliente("Conjunto Residencial Mirador II");
        u.setDireccionCliente("Carrera 52 No 33b");
        u.setNombreCliente("Paula");
        u.setApellidoCliente("Cardenas");
        u.setTelefonoCliente("12345678"); 
        cliente.ValidarDatos(u);
       */
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
        u.setCedulaCliente("123456789");
        u.setDescripcionDireccionCliente("Conjunto Residencial Mirador II");
        u.setDireccionCliente("Carrera 52 No 33b");
        u.setNombreCliente("Paul");
        u.setApellidoCliente("Cardenas");
        u.setTelefonoCliente("12345678"); 

        assertEquals(cliente.validarNombre(u.getNombreCliente()), nn);

        u.setCedulaCliente("123456789");
        u.setDescripcionDireccionCliente("Conjunto Residencial Mirador II");
        u.setDireccionCliente("Carrera 52 No 33b");
        u.setNombreCliente("Paula Andrea Valencia");
        u.setApellidoCliente("Cardenas");
        u.setTelefonoCliente("12345678");

        assertEquals(cliente.validarNombre(u.getNombreCliente()), nn);
    }

    @Test
    public void LongitudApellido() {

        Cliente u = new Cliente();
        u.setCedulaCliente("123456789");
        u.setDescripcionDireccionCliente("Conjunto Residencial Mirador II");
        u.setDireccionCliente("Carrera 52 No 33b");
        u.setNombreCliente("Paula");
        u.setApellidoCliente("Caro");
        u.setTelefonoCliente("12345678"); 

        assertEquals(cliente.validarApellido(u.getApellidoCliente()), an);

        u.setCedulaCliente("123456789");
        u.setDescripcionDireccionCliente("Conjunto Residencial Mirador II");
        u.setDireccionCliente("Carrera 52 No 33b");
        u.setNombreCliente("Paula");
        u.setApellidoCliente("Cardenas Valencia Roa");
        u.setTelefonoCliente("12345678");

        assertEquals(cliente.validarApellido(u.getApellidoCliente()), an);
    }

    @Test
    public void LongitudCedula() {

        Cliente u = new Cliente();
        u.setCedulaCliente("123456");
        u.setDescripcionDireccionCliente("Conjunto Residencial Mirador II");
        u.setDireccionCliente("Carrera 52 No 33b");
        u.setNombreCliente("Paula");
        u.setApellidoCliente("Cardenas");
        u.setTelefonoCliente("12345678"); 

        assertEquals(cliente.validarCedula(u.getCedulaCliente()), cn);

        u.setCedulaCliente("123456789012");
        u.setDescripcionDireccionCliente("Conjunto Residencial Mirador II");
        u.setDireccionCliente("Carrera 52 No 33b");
        u.setNombreCliente("Paula");
        u.setApellidoCliente("Cardenas");
        u.setTelefonoCliente("12345678");

        assertEquals(cliente.validarCedula(u.getCedulaCliente()), cn);
    }

    @Test
    public void LongitudTelefono() {

        Cliente u = new Cliente();
        u.setCedulaCliente("123456789");
        u.setDescripcionDireccionCliente("Conjunto Residencial Mirador II");
        u.setDireccionCliente("Carrera 52 No 33b");
        u.setNombreCliente("Paula");
        u.setApellidoCliente("Cardenas");
        u.setTelefonoCliente("123456"); 

        assertEquals(cliente.validarTelefono(u.getTelefonoCliente()), tn);

        u.setCedulaCliente("123456789");
        u.setDescripcionDireccionCliente("Conjunto Residencial Mirador II");
        u.setDireccionCliente("Carrera 52 No 33b");
        u.setNombreCliente("Paula");
        u.setApellidoCliente("Cardenas");
        u.setTelefonoCliente("1234567890123456");

        assertEquals(cliente.validarTelefono(u.getTelefonoCliente()), tn);
        
    }

    @Test
    public void LongitudDireccion() {

        Cliente u = new Cliente();
        u.setCedulaCliente("123456789");
        u.setDescripcionDireccionCliente("Conjunto Residencial Mirador II");
        u.setDireccionCliente("Carrera 52");
        u.setNombreCliente("Paula");
        u.setApellidoCliente("Cardenas");
        u.setTelefonoCliente("12345678"); 

        assertEquals(cliente.validarDireccion(u.getDireccionCliente()), dn);

        u.setCedulaCliente("123456789");
        u.setDescripcionDireccionCliente("Conjunto Residencial Mirador II");
        u.setDireccionCliente("Carrera 8 No 33b - 83 Torre 5 603");
        u.setNombreCliente("Paula");
        u.setApellidoCliente("Cardenas");
        u.setTelefonoCliente("12345678");

        assertEquals(cliente.validarDireccion(u.getDireccionCliente()), dn);
    }

    @Test
    public void LongitudDescripcion() {

        Cliente u = new Cliente();
        u.setCedulaCliente("123456789");
        u.setDescripcionDireccionCliente("Conjunto Residencial Mirador II B");
        u.setDireccionCliente("Carrera 52 No 33b");
        u.setNombreCliente("Paula");
        u.setApellidoCliente("Cardenas");
        u.setTelefonoCliente("12345678");

        assertEquals(cliente.validarDescripcionDir(u.getDescripcionDireccionCliente()), ddn);
        
    }


    @Test
    public void Reg_Exitoso() {

        Cliente u = new Cliente();
        u.setCedulaCliente("324056782");
        u.setDescripcionDireccionCliente("Barrio Marina");
        u.setDireccionCliente("Calle 22  No 56a");
        u.setNombreCliente("Jessica");
        u.setApellidoCliente("Sanchez");
        u.setTelefonoCliente("46816746"); 
        assertEquals(cliente.ValidarDatos(u), re);
        clienteDao.eliminar(u);

    }

    @Test
    public void Ya_Registrado() {

        Cliente u = new Cliente();
        u.setCedulaCliente("123456789");
        u.setDescripcionDireccionCliente("Conjunto Residencial Mirador II");
        u.setDireccionCliente("Carrera 52 No 33b");
        u.setNombreCliente("Jessica");
        u.setApellidoCliente("Cardenas");
        u.setTelefonoCliente("12345678"); 
        assertEquals(cliente.ValidarDatos(u), cr);
    }


}
