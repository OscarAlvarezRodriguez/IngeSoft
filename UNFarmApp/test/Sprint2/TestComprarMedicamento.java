package Sprint2;

import Control.ComprarMedicamento;
import Entidad.Compra;
import Entidad.Compramedicamento;
import Entidad.CompramedicamentoPK;
import Entidad.Medicamento;
import Entidad.Medicamentoinvima;
import java.sql.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestComprarMedicamento {
    
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
     
          @Test
     public void crearCompra() {
         Compra c = new Compra();
         Date date = new Date(System.currentTimeMillis());
         c.setNombreproveedor("Drogas Calidad Maxima");
         c.setFecha(date);
         comprar.registroCompra(c);
     }
     
          @Test
     public void crearCompraMedicamento() {
         Compramedicamento cMedicamento = new Compramedicamento();
         Compra c = new Compra();
         c.setNombreproveedor("Drogas Bayer");
         cMedicamento.setCantidad((short)15);
         cMedicamento.setCompra(c);
         Date date = new Date(System.currentTimeMillis());
         c.setFecha(date);
         comprar.registroCompra(c);
         Medicamento m = new Medicamento();
         m.setIdmedicamento((short)2);
         m.setPrecioventa(5800);
         m.setStock((short)85);
         CompramedicamentoPK cCompramedicamentoPK = new CompramedicamentoPK((short)2, c.getIdcompra());
         cMedicamento.setCompramedicamentoPK(cCompramedicamentoPK);
         Medicamentoinvima idmediMedicamentoinvima = new Medicamentoinvima();
         idmediMedicamentoinvima.setDescripcion("CAJA PLEGADIZA POR 5 JERINGAS PRELLENADAS DE 0.8 ML");
         idmediMedicamentoinvima.setIdmedicamentoinvima((short)750);
         idmediMedicamentoinvima.setNombremedicamento("ENOXAPARINA SODICA JERINGAS PRELLENADAS 80 MG/0.8 ML");
         idmediMedicamentoinvima.setPresentacion("SOLUCION INYECTABLE");
         idmediMedicamentoinvima.setPrincipioactivo("ENOXOPARINA SODICA 80 MG/0.8 ML");
         idmediMedicamentoinvima.setTitular("PHARMA LAW COLOMBIA S.A.S");
         idmediMedicamentoinvima.setMedicamento(m);
         m.setIdmedicamentoinvima(idmediMedicamentoinvima);
         cMedicamento.setMedicamento(m);
         cMedicamento.setPreciounitario(9000);
         comprar.registroCompraMed(cMedicamento);
     }
     
     
}
