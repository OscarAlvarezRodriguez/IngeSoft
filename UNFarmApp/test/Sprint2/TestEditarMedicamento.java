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
    
    private final EditarMedicamento editar = new EditarMedicamento();
    private final String pi = "Precio de venta fuera de rango";
    private final String se = "Cantidad no válida";
    private final String co = "correcto";

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
    assertEquals(editar.validarPrecioventa(m.getPrecioventa()), pi);
    m.setPrecioventa(10000001);
    assertEquals(editar.validarPrecioventa(m.getPrecioventa()), pi);
    m.setPrecioventa(10000);
    assertEquals(editar.validarPrecioventa(m.getPrecioventa()), co);
    }
    
    @Test
    public void EditarStock() {
    
    Medicamento m = new Medicamento();
    m.setStock((short)-1);
    assertEquals(editar.validarStock(m.getStock()), se);
    m.setStock((short)2001);
    assertEquals(editar.validarStock(m.getStock()), se);
    m.setStock((short)10);
    assertEquals(editar.validarStock(m.getStock()), co);
    }
    
}
