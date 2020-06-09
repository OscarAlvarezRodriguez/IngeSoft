
package Sprint2;

import Control.AgregarMedicamento;
import Entidad.Medicamento;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestAgregarMedicamento {
    private final AgregarMedicamento medicamento = new AgregarMedicamento();
    private final String ma = "Medicamento ya agregado";
    private final String me = "Medicamento agregado exitosamente";
    private final String pi = "Precio fuera de rango";
    private final String mr = "Medicamento restaurado";
    private final String mre = "Error al restaurar medicamento";
    
    
    public TestAgregarMedicamento() {       
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
    public void PrecioRango() {
    
    Medicamento m = new Medicamento();
    m.setPrecioventa(99);
    assertEquals(medicamento.validarPrecioventa(m.getPrecioventa()), pi);
    
    m.setPrecioventa(10000001);
    assertEquals(medicamento.validarPrecioventa(m.getPrecioventa()), pi);
    }
    
    @Test
    public void YaRegistrado() {
    
    Medicamento m = new Medicamento();
    m.setPrecioventa(10000);
//Necesito Datos de Medicamento Invima    assertEquals(medicamento.validarDatos(m), ma);
    }
    
}
