package Sprint3;

import Control.VenderMed;
import Entidad.Cliente;
import Entidad.Domicilio;
import Entidad.Drogueria;
import Entidad.Empleado;
import Entidad.Factura;
import Entidad.Facturamedicamentos;
import Entidad.Medicamento;
import Entidad.Medicamentoinvima;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestVenderMed {
    
    private VenderMed medicamento = new VenderMed();
    private final String ci = "Cantidad del medicamento no permitida";
    private final String si = "La compra excede el límite del precio";
    private final String fg = "Factura Generada Exitosamente";
    private final String ca = "La cantidad solicitada es superior al inventario disponible";
    
    public TestVenderMed() {
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
        public void CantidadNoDisponible() {

        Medicamento m = new Medicamento();
        m.setIdmedicamento((short) 6);
        m.setPrecioventa(8000);
        m.setStock((short) -1);
        Medicamentoinvima idmediMedicamentoinvima = new Medicamentoinvima();
        idmediMedicamentoinvima.setDescripcion("CAJA POR 100 TABLETAS EN BLISTER DE PVDC/PE/PVC INCOLORO/ALUMINIO.");
        idmediMedicamentoinvima.setIdmedicamentoinvima((short) 777);
        idmediMedicamentoinvima.setNombremedicamento("CETIRIZINA DICLORHIDRATO 10 MG TABLETA RECUBIERTA");
        idmediMedicamentoinvima.setPresentacion("TABLETA RECUBIERTA");
        idmediMedicamentoinvima.setPrincipioactivo("CETIRIZINA DICLORHIDRATO");
        idmediMedicamentoinvima.setTitular("AMERICAN GENERICS S.A.S.");
        idmediMedicamentoinvima.setMedicamento(m);
        m.setIdmedicamentoinvima(idmediMedicamentoinvima);
        Domicilio domicilio = new Domicilio(3);
        Factura factura = new Factura(1502);
        domicilio.setIdfactura(factura);
        factura.setDomicilio(domicilio);
        Facturamedicamentos facturamedicamentos = new Facturamedicamentos(m.getIdmedicamento(), factura.getIdfactura());
        facturamedicamentos.setCantidadvendida((short) 1);
        facturamedicamentos.setFactura(factura);
        facturamedicamentos.setMedicamento(m);
        List<Facturamedicamentos> facturamedicamentosList = new ArrayList<>(); 
        facturamedicamentosList.add(facturamedicamentos);
        factura.setFacturamedicamentosList(facturamedicamentosList);
        assertEquals(medicamento.validarDatos(factura, facturamedicamentos, m.getIdmedicamento()), ca);
    }
    
     @Test
    public void CantidadMedicamentoLimite() {

        Medicamento m = new Medicamento();
        m.setIdmedicamento((short) 6);
        m.setPrecioventa(8000);
        m.setStock((short) 10);
        Medicamentoinvima idmediMedicamentoinvima = new Medicamentoinvima();
        idmediMedicamentoinvima.setDescripcion("CAJA POR 100 TABLETAS EN BLISTER DE PVDC/PE/PVC INCOLORO/ALUMINIO.");
        idmediMedicamentoinvima.setIdmedicamentoinvima((short) 777);
        idmediMedicamentoinvima.setNombremedicamento("CETIRIZINA DICLORHIDRATO 10 MG TABLETA RECUBIERTA");
        idmediMedicamentoinvima.setPresentacion("TABLETA RECUBIERTA");
        idmediMedicamentoinvima.setPrincipioactivo("CETIRIZINA DICLORHIDRATO");
        idmediMedicamentoinvima.setTitular("AMERICAN GENERICS S.A.S.");
        idmediMedicamentoinvima.setMedicamento(m);
        m.setIdmedicamentoinvima(idmediMedicamentoinvima);
        Domicilio domicilio = new Domicilio(3);
        Factura factura = new Factura(1502);
        domicilio.setIdfactura(factura);
        factura.setDomicilio(domicilio);
        Facturamedicamentos facturamedicamentos = new Facturamedicamentos(m.getIdmedicamento(), factura.getIdfactura());
        facturamedicamentos.setCantidadvendida((short) 2001);
        facturamedicamentos.setFactura(factura);
        facturamedicamentos.setMedicamento(m);
        List<Facturamedicamentos> facturamedicamentosList = new ArrayList<>(); 
        facturamedicamentosList.add(facturamedicamentos);
        factura.setFacturamedicamentosList(facturamedicamentosList);
        assertEquals(medicamento.validarDatos(factura, facturamedicamentos, m.getIdmedicamento()), ci);
    }
    
    @Test
        public void CompraLimitePrecio() {

        Medicamento m = new Medicamento();
        m.setIdmedicamento((short) 10);
        m.setPrecioventa(10000001);
        m.setStock((short) 199);
        Medicamentoinvima idmediMedicamentoinvima = new Medicamentoinvima();
        idmediMedicamentoinvima.setDescripcion("CAJA POR 100 TABLETAS EN BLISTER DE PVDC/PE/PVC INCOLORO/ALUMINIO.");
        idmediMedicamentoinvima.setIdmedicamentoinvima((short) 777);
        idmediMedicamentoinvima.setNombremedicamento("CETIRIZINA DICLORHIDRATO 10 MG TABLETA RECUBIERTA");
        idmediMedicamentoinvima.setPresentacion("TABLETA RECUBIERTA");
        idmediMedicamentoinvima.setPrincipioactivo("CETIRIZINA DICLORHIDRATO");
        idmediMedicamentoinvima.setTitular("AMERICAN GENERICS S.A.S.");
        idmediMedicamentoinvima.setMedicamento(m);
        m.setIdmedicamentoinvima(idmediMedicamentoinvima);
        Domicilio domicilio = new Domicilio(2);
        Factura factura = new Factura(1501);
        domicilio.setIdfactura(factura);
        factura.setDomicilio(domicilio);
        Facturamedicamentos facturamedicamentos = new Facturamedicamentos(m.getIdmedicamento(), factura.getIdfactura());
        facturamedicamentos.setCantidadvendida((short) 11);
        facturamedicamentos.setFactura(factura);
        facturamedicamentos.setMedicamento(m);
        List<Facturamedicamentos> facturamedicamentosList = new ArrayList<>(); 
        facturamedicamentosList.add(facturamedicamentos);
        factura.setFacturamedicamentosList(facturamedicamentosList);
        assertEquals(medicamento.validarDatos(factura, facturamedicamentos, m.getIdmedicamento()), si);
    }
    
    
    @Test
        public void FacturaGenerada() {

        Medicamento m = new Medicamento();
        m.setIdmedicamento((short) 9);
        m.setPrecioventa(1250);
        m.setStock((short) 90);
        Medicamentoinvima idmediMedicamentoinvima = new Medicamentoinvima();
        idmediMedicamentoinvima.setDescripcion("CAJA POR 20 TABLETAS RECUBIERTAS EN BLISTER DE PVC TRANSPARENTE/ALUMINIO POR 10 TABLETAS CADA UNO");
        idmediMedicamentoinvima.setIdmedicamentoinvima((short) 345);
        idmediMedicamentoinvima.setNombremedicamento("IBUPROFENO TABLETA RECUBIERTA X 400 MG");
        idmediMedicamentoinvima.setPresentacion("TABLETA RECUBIERTA");
        idmediMedicamentoinvima.setPrincipioactivo("IBUPROFENO (GRANULADO 66%)");
        idmediMedicamentoinvima.setTitular("LABORATORIOS LA SANTÉ S.A.");
        idmediMedicamentoinvima.setMedicamento(m);
        m.setIdmedicamentoinvima(idmediMedicamentoinvima);
        Domicilio domicilio = new Domicilio(4);
        Factura factura = new Factura(1503);
        domicilio.setIdfactura(factura);
        factura.setDomicilio(domicilio);
        Facturamedicamentos facturamedicamentos = new Facturamedicamentos(m.getIdmedicamento(), factura.getIdfactura());
        facturamedicamentos.setCantidadvendida((short) 10);
        facturamedicamentos.setFactura(factura);
        facturamedicamentos.setMedicamento(m);
        List<Facturamedicamentos> facturamedicamentosList = new ArrayList<>(); 
        facturamedicamentosList.add(facturamedicamentos);
        factura.setFacturamedicamentosList(facturamedicamentosList);
        assertEquals(medicamento.validarDatos(factura, facturamedicamentos, m.getIdmedicamento()), fg);
    }    
        
}
