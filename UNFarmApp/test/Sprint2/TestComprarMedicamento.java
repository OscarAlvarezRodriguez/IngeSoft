package Sprint2;

import Control.ComprarMedicamento;
import Entidad.Compra;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestComprarMedicamento {
    
    private final Compra compra = new Compra();
    private final ComprarMedicamento comprar = new ComprarMedicamento();
    
    public TestComprarMedicamento() {
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
     public void validarProveedor() {
     
         Compra c = new Compra();
         c.setNombreproveedor("Drog");
         assertEquals(comprar.validarProveedor(c.getNombreproveedor()), false);
         c.setNombreproveedor("Drogas Calidad Maxima Garantizado");         
         assertEquals(comprar.validarProveedor(c.getNombreproveedor()), false);
         c.setNombreproveedor("Drogas Calidad Maxima");
         assertEquals(comprar.validarProveedor(c.getNombreproveedor()), true);
     }
}
