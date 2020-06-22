package Sprint2;

import Control.EliminarMedicamento;
import Entidad.Medicamento;
import Entidad.Medicamentoinvima;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestEliminarMedicamento {
    
    private final String me = "Medicamento Eliminado";
    private EliminarMedicamento eliminar = new EliminarMedicamento();
    private Medicamentoinvima idmediMedicamentoinvima = new Medicamentoinvima();
    private Medicamento medicamento = new Medicamento();
    public TestEliminarMedicamento() {
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
    public void MedicamentoEliminado() {
    Medicamento m = new Medicamento();
    
    idmediMedicamentoinvima.setTitular("SANDOZ GMBH");
    idmediMedicamentoinvima.setDescripcion("MUESTRA MEDICA: CAJA POR 14 TABLETAS EN BLISTER PVC/PVDC/ALU");
    idmediMedicamentoinvima.setIdmedicamentoinvima((short)1);
    idmediMedicamentoinvima.setMedicamento(m);
    idmediMedicamentoinvima.setNombremedicamento("SEROLUX® 100 MG");
    idmediMedicamentoinvima.setPresentacion("TABLETA RECUBIERTA");
    idmediMedicamentoinvima.setPrincipioactivo("SERTRALINA CLORHIDRATO 111.98 MG EQUIVALENTE A SERTRALINA BASE");
    m.setStock((short)10);
    m.setPrecioventa(10000);
    m.setIdmedicamento((short)1);
    m.setIdmedicamentoinvima(idmediMedicamentoinvima);
    assertEquals(eliminar.validarEliminacion(m), me);    
    }

}
