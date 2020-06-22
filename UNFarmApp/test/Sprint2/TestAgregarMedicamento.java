package Sprint2;

import Control.AgregarMedicamento;
import Entidad.Medicamento;
import Entidad.Medicamentoinvima;
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
    private final String mre = "Error al restaurar medicamento";
    private Medicamentoinvima idmediMedicamentoinvima = new Medicamentoinvima();

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
    public void AgregadoExistoso() {

        Medicamento m = null;
        assertEquals(medicamento.validarDatos(m, 10000, (short)20), me);
    }

    @Test
    public void YaAgregado() {

        Medicamento m = new Medicamento();
        m.setIdmedicamento((short) 2);
        m.setPrecioventa(5800);
        m.setStock((short) 85);

        idmediMedicamentoinvima.setDescripcion("CAJA PLEGADIZA POR 5 JERINGAS PRELLENADAS DE 0.8 ML");
        idmediMedicamentoinvima.setIdmedicamentoinvima((short) 750);
        idmediMedicamentoinvima.setNombremedicamento("ENOXAPARINA SODICA JERINGAS PRELLENADAS 80 MG/0.8 ML");
        idmediMedicamentoinvima.setPresentacion("SOLUCION INYECTABLE");
        idmediMedicamentoinvima.setPrincipioactivo("ENOXOPARINA SODICA 80 MG/0.8 ML");
        idmediMedicamentoinvima.setTitular("PHARMA LAW COLOMBIA S.A.S");
        idmediMedicamentoinvima.setMedicamento(m);
        m.setIdmedicamentoinvima(idmediMedicamentoinvima);
        assertEquals(medicamento.validarDatos(m, m.getPrecioventa(), m.getIdmedicamentoinvima().getIdmedicamentoinvima()), ma);
    }

    @Test
    public void PrecioRango() {

        Medicamento m = new Medicamento();
        m.setPrecioventa(99);
        m.setStock((short) 10);
        assertEquals(medicamento.validarDatos(m, m.getPrecioventa(), (short) 10), pi);

        m.setPrecioventa(10000001);
        m.setStock((short) 10);
        assertEquals(medicamento.validarDatos(m, m.getPrecioventa(), (short) 10), pi);
    }

}
