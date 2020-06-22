package Control;

import DAO.CompraDAO;
import Entidad.Factura;
import DAO.VenderDAO;
import Entidad.Compramedicamento;
import Entidad.Facturamedicamentos;
import java.util.List;


public class ReporteVenta {
    private final VenderDAO FacturasDAO = new VenderDAO();
    private final CompraDAO comprasDAO = new CompraDAO();
    private final String va = "No hay facturas registradas";
    private final String nc = "No hay facturas registradas";
    private List<Facturamedicamentos> facturas = null;
    private List<Compramedicamento> compras = null;
    
    public ReporteVenta(){
    }
    
    public List<Facturamedicamentos> obtenerfacturas(){
        facturas = FacturasDAO.leerfacturas();
        if (facturas == null){
            System.out.println(va);
        }
        return facturas;
    }
    
    public List<Compramedicamento> obtenerInfoCompras(){
        compras = comprasDAO.leercompras();
        if (compras == null){
            System.out.println(nc);
        }
        return compras;
    }
}
