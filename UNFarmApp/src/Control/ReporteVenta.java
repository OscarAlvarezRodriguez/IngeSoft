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

    public ReporteVenta() {
    }

    public List<Facturamedicamentos> obtenerfacturas() {
        List<Facturamedicamentos> facturas = null;
        facturas = FacturasDAO.leerfacturas();
        return facturas;
    }

    public List<Compramedicamento> obtenerInfoCompras() {
        List<Compramedicamento> compras = null;
        compras = comprasDAO.leercompras();
        return compras;
    }
}
