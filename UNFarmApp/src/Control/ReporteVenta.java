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

    public List<Facturamedicamentos> obtenerfacturas(String fecha) {
        List<Facturamedicamentos> facturas = null;
        facturas = FacturasDAO.leerfacturas(fecha);
        return facturas;
    }

    public List<Compramedicamento> obtenerInfoCompras(String fecha) {
        List<Compramedicamento> compras = null;
        compras = comprasDAO.leercompras(fecha);
        return compras;
    }
}
