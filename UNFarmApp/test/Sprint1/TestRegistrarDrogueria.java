package Sprint1;

import Control.RegistrarDrogueria;
import DAO.DrogueriaDAO;
import Entidad.Drogueria;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestRegistrarDrogueria {

    private static final RegistrarDrogueria drogueria = new RegistrarDrogueria();
    private static final DrogueriaDAO drogueriaDAOs = new DrogueriaDAO();

    private final String rpn = "Longitud representante legal incorrecta";
    private final String nn = "Longitud nombre incorrecta";
    private final String tn = "Número telefónico no válido";
    private final String dn = "Longitud dirección incorrecta";
    private final String en = "Correo no válido";
    private final String co = "Correcto";
    private final String nitn = "Nit no válido";
    private final String re = "Registro exitoso";
    private final String dr = "La droguería ya está registrada";

    public TestRegistrarDrogueria() {
    }

    @BeforeClass
    public static void setUpClass() {
        Drogueria d = new Drogueria();
        d.setDireccionDrogueria("Carrera 89 No 83a");
        d.setEmailDrogueria("drogueriacr@mymail.com");
        d.setNitDrogueria("1234567890123");
        d.setNombreDrogueria("Droguería Cruz Roja");
        d.setRepresentanteLegalDrogueria("Andrés Palacio");
        d.setTelefonoDrogueria("123456789");
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
        d.setDireccionDrogueria("Carrera 89 No 83a");
        d.setEmailDrogueria("drogueriacr@mymail.com");
        d.setNitDrogueria("1234567890123");
        d.setNombreDrogueria("Droguería A");
        d.setRepresentanteLegalDrogueria("Andrés Palacio");
        d.setTelefonoDrogueria("123456789");
        assertEquals(drogueria.validarDatos(d), nn);

        d.setDireccionDrogueria("Carrera 89 No 83a");
        d.setEmailDrogueria("drogueriacr@mymail.com");
        d.setNitDrogueria("1234567890123");
        d.setNombreDrogueria("Droguería  Roja, Blanca y Naranja");
        d.setRepresentanteLegalDrogueria("Andrés Palacio");
        d.setTelefonoDrogueria("123456789");
        assertEquals(drogueria.validarDatos(d), nn);
    }

    @Test
    public void LongitudNit() {
        Drogueria d = new Drogueria();
        d.setDireccionDrogueria("Carrera 89 No 83a");
        d.setEmailDrogueria("drogueriacr@mymail.com");
        d.setNitDrogueria("1234567890");
        d.setNombreDrogueria("Droguería Cruz Roja");
        d.setRepresentanteLegalDrogueria("Andrés Palacio");
        d.setTelefonoDrogueria("123456789");
        assertEquals(drogueria.validarDatos(d), nitn);

        d.setDireccionDrogueria("Carrera 89 No 83a");
        d.setEmailDrogueria("drogueriacr@mymail.com");
        d.setNitDrogueria("123456789012345678901");
        d.setNombreDrogueria("Droguería Cruz Roja");
        d.setRepresentanteLegalDrogueria("Andrés Palacio");
        d.setTelefonoDrogueria("123456789");
        assertEquals(drogueria.validarDatos(d), nitn);
    }

    @Test
    public void LongitudDireccion() {
        Drogueria d = new Drogueria();
        d.setDireccionDrogueria("Carrera 89a");
        d.setEmailDrogueria("drogueriacr@mymail.com");
        d.setNitDrogueria("1234567890123");
        d.setNombreDrogueria("Droguería Cruz Roja");
        d.setRepresentanteLegalDrogueria("Andrés Palacio");
        d.setTelefonoDrogueria("123456789");
        assertEquals(drogueria.validarDatos(d), dn);

        d.setDireccionDrogueria("Carrera 89b No 83a 24 C.C Mirador");
        d.setEmailDrogueria("drogueriacr@mymail.com");
        d.setNitDrogueria("1234567890123");
        d.setNombreDrogueria("Droguería Cruz Roja");
        d.setRepresentanteLegalDrogueria("Andrés Palacio");
        d.setTelefonoDrogueria("123456789");
        assertEquals(drogueria.validarDatos(d), dn);
    }

    @Test
    public void LongitudTelefono() {
        Drogueria d = new Drogueria();
        d.setDireccionDrogueria("Carrera 89 No 83a");
        d.setEmailDrogueria("drogueriacr@mymail.com");
        d.setNitDrogueria("1234567890123");
        d.setNombreDrogueria("Droguería Cruz Roja");
        d.setRepresentanteLegalDrogueria("Andrés Palacio");
        d.setTelefonoDrogueria("123456");
        assertEquals(drogueria.validarDatos(d), tn);

        d.setDireccionDrogueria("Carrera 89 No 83a");
        d.setEmailDrogueria("drogueriacr@mymail.com");
        d.setNitDrogueria("1234567890123");
        d.setNombreDrogueria("Droguería Cruz Roja");
        d.setRepresentanteLegalDrogueria("Andrés Palacio");
        d.setTelefonoDrogueria("1234567890123456");
        assertEquals(drogueria.validarDatos(d), tn);
    }

    @Test
    public void ValidarCorreo() {
        Drogueria d = new Drogueria();
        d.setDireccionDrogueria("Carrera 89 No 83a");
        d.setEmailDrogueria("d@ml.com");
        d.setNitDrogueria("1234567890123");
        d.setNombreDrogueria("Droguería Cruz Roja");
        d.setRepresentanteLegalDrogueria("Andrés Palacio");
        d.setTelefonoDrogueria("123456789");
        assertEquals(drogueria.validarDatos(d), en);

        d.setDireccionDrogueria("Carrera 89 No 83a");
        d.setEmailDrogueria("drogueriacruzroja.andrescorredor.mirador@mymail.com");
        d.setNitDrogueria("1234567890123");
        d.setNombreDrogueria("Droguería Cruz Roja");
        d.setRepresentanteLegalDrogueria("Andrés Palacio");
        d.setTelefonoDrogueria("123456789");
        assertEquals(drogueria.validarDatos(d), en);

        d.setDireccionDrogueria("Carrera 89 No 83a");
        d.setEmailDrogueria("drogueriacrmymail.com");
        d.setNitDrogueria("1234567890123");
        d.setNombreDrogueria("Droguería Cruz Roja");
        d.setRepresentanteLegalDrogueria("Andrés Palacio");
        d.setTelefonoDrogueria("123456789");
        assertEquals(drogueria.validarDatos(d), en);

        d.setDireccionDrogueria("Carrera 89 No 83a");
        d.setEmailDrogueria("drogueriacr@mymailcom");
        d.setNitDrogueria("1234567890123");
        d.setNombreDrogueria("Droguería Cruz Roja");
        d.setRepresentanteLegalDrogueria("Andrés Palacio");
        d.setTelefonoDrogueria("123456789");
        assertEquals(drogueria.validarDatos(d), en);

        d.setDireccionDrogueria("Carrera 89 No 83a");
        d.setEmailDrogueria("drogueriacrmymailcom");
        d.setNitDrogueria("1234567890123");
        d.setNombreDrogueria("Droguería Cruz Roja");
        d.setRepresentanteLegalDrogueria("Andrés Palacio");
        d.setTelefonoDrogueria("123456789");
        assertEquals(drogueria.validarDatos(d), en);
    }

    @Test
    public void LongitudRepresentante() {
        Drogueria d = new Drogueria();
        d.setDireccionDrogueria("Carrera 89 No 83a");
        d.setEmailDrogueria("drogueriacr@mymail.com");
        d.setNitDrogueria("1234567890123");
        d.setNombreDrogueria("Droguería Cruz Roja");
        d.setRepresentanteLegalDrogueria("Andrés Roa");
        d.setTelefonoDrogueria("123456789");
        assertEquals(drogueria.validarDatos(d), rpn);

        d.setDireccionDrogueria("Carrera 89 No 83a");
        d.setEmailDrogueria("drogueriacr@mymail.com");
        d.setNitDrogueria("1234567890123");
        d.setNombreDrogueria("Droguería Cruz Roja");
        d.setRepresentanteLegalDrogueria("Andrés Palacios Murillo Velasquez");
        d.setTelefonoDrogueria("123456789");
        assertEquals(drogueria.validarDatos(d), rpn);
    }

    @Test
    public void YaRegistrado() {
        Drogueria d = new Drogueria();
        d.setDireccionDrogueria("Carrera 89 No 83a");
        d.setEmailDrogueria("drogueriacr@mymail.com");
        d.setNitDrogueria("1234567890123");
        d.setNombreDrogueria("Droguería Cruz Roja");
        d.setRepresentanteLegalDrogueria("Andrés Palacio");
        d.setTelefonoDrogueria("123456789");
        assertEquals(drogueria.validarDatos(d), dr);
    }

    @Test
    public void RegistroExistoso() {
        Drogueria d = new Drogueria();
        d.setDireccionDrogueria("Carrera 32 No 24a");
        d.setEmailDrogueria("drogueriacb@mymail.com");
        d.setNitDrogueria("1234567890124");
        d.setNombreDrogueria("Droguería Cruz Blanca");
        d.setRepresentanteLegalDrogueria("Felipe Chaparro");
        d.setTelefonoDrogueria("12345678902");
        assertEquals(drogueria.validarDatos(d), re);
        drogueriaDAOs.eliminar(d);
    }
}
