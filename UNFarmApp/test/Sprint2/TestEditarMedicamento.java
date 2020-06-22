package Sprint2;

import Control.AgregarMedicamento;
import Control.EditarMedicamento;
import DAO.MedicamentoDAO;
import DAO.MedicamentoinvimaDAO;
import Entidad.Medicamento;
import Entidad.Medicamentoinvima;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestEditarMedicamento {
    
    private  EditarMedicamento editar = new EditarMedicamento();
    private final String pi = "Precio de venta fuera de rango";
    private final String se = "Cantidad no válida";
    private final String ae = "Medicamento actualizado exitosamente";
    private final String ai = "Actualización medicamento incorrecta";
    private Medicamentoinvima idmediMedicamentoinvima = new Medicamentoinvima();
    private final Medicamento medicamento = new Medicamento();

    public TestEditarMedicamento() {         
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
    public void EditarPrecio() {
        
    Medicamento m = new Medicamento();
    m.setPrecioventa(99);
    m.setStock((short) 10);
    assertEquals(editar.validarPrecioventa(m.getPrecioventa()), pi);
    m.setPrecioventa(10000001);
    m.setStock((short) 10);
    assertEquals(editar.validarPrecioventa(m.getPrecioventa()), pi);
    }
    
    @Test
    public void EditarStock() {
    
    Medicamento m = new Medicamento();
    m.setStock((short)-1);
    m.setPrecioventa(10000);
    assertEquals(editar.validarStock(m.getStock()), se);
    m.setStock((short)2001);
    m.setPrecioventa(10000);
    assertEquals(editar.validarStock(m.getStock()), se);
    }
    
    @Test
    public void MedicamentoActualizado() {
    idmediMedicamentoinvima.setTitular("SANDOZ GMBH");
    idmediMedicamentoinvima.setDescripcion("MUESTRA MEDICA: CAJA POR 14 TABLETAS EN BLISTER PVC/PVDC/ALU");
    idmediMedicamentoinvima.setIdmedicamentoinvima((short)1);
    idmediMedicamentoinvima.setMedicamento(medicamento);
    idmediMedicamentoinvima.setNombremedicamento("SEROLUX® 100 MG");
    idmediMedicamentoinvima.setPresentacion("TABLETA RECUBIERTA");
    idmediMedicamentoinvima.setPrincipioactivo("SERTRALINA CLORHIDRATO 111.98 MG EQUIVALENTE A SERTRALINA BASE");
    Medicamento m = new Medicamento();
    Medicamento mantiguo = new Medicamento();
    m.setStock((short)10);
    m.setPrecioventa(10000);
    mantiguo.setIdmedicamento((short)1);
    mantiguo.setIdmedicamentoinvima(idmediMedicamentoinvima);
    mantiguo.setStock((short)23);
    mantiguo.setPrecioventa(10000);
    assertEquals(editar.validarDatos(mantiguo, m), ae);
    }
    
    @Test
    public void ActualizacionIncorrecta() {
    Medicamento m = new Medicamento();
    Medicamento mantiguo = new Medicamento();
    m.setStock((short)10);
    m.setPrecioventa(10000);
    assertEquals(editar.validarDatos(mantiguo, m), ai);
    }
}
