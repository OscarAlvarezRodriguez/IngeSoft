package Control;

import Entidad.Factura;
import DAO.VenderDAO;
import java.util.List;


public class ReporteVenta {
    private final VenderDAO FacturasDAO = new VenderDAO();
    private final String va = "No hay facturas registradas";
    private List<Factura> facturas = null;
    
    public ReporteVenta(){
    }
    
    public List<Factura> obtenerfacturas(){
        facturas = FacturasDAO.leerfacturas();
        if (facturas == null){
            System.out.println(va);
        }
        return facturas;
    }
}
