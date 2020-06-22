package Control;

import DAO.MedicamentoDAO;
import DAO.VenderDAO;
import Entidad.Factura;
import Entidad.Facturamedicamentos;
import Entidad.Medicamento;
import java.util.ArrayList;
import java.util.List;

public class VenderMed {

    private MedicamentoDAO medicamentoDao = new MedicamentoDAO();
    private VenderDAO aO = new VenderDAO();
    private final String ci = "Cantidad del medicamento no permitida";
    private final String si = "La compra excede el límite del precio";
    private final String co = "Correcto";
    private final String fg = "Factura Generada Exitosamente";
    private final String ca = "La cantidad solicitada es superior al inventario disponible";

    // la clase control funciona mandando la clase venta que se desea agregar, la función validar datos se encargara de comprobar el stock y la cantidad
    // todas las funciones son string y retornan el texto que especifica el error o el exito de la operación
    // si se desea validar individualmente cada campo las otras funciones están públicas
    // para hacer toda la validación solo es necesario llamar a validarDatos, y en caso de que sea exitosa la validación la misma clase control se comunica con la clase DAO y la agrega a la DB
    //en la linea 55 de código de experimenta una función que evita crear una consulta en la clase dao, en caso de no funcionar, eliminar esta función
    public String validarDatos(Factura factura, Facturamedicamentos facturamedicamentos, short idMed) {
        if (!validarLongitudCantidad(facturamedicamentos).equals(co)) {
            return ci;
        }
        if (!validarCantidad(facturamedicamentos, idMed).equals(co)) {
            return ca;
        }
        if (!validarPrecio(factura.getPreciototal()).equals(co)) {
            return si;
        }
        return fg;
    }

    public String validarLongitudCantidad(Facturamedicamentos venta) {
        // para eficiencia, primero valida si la cantidad vendida no excede las 2000 unidades
        if (venta.getCantidadvendida() > 2000 || venta.getCantidadvendida() <= 0) {
            return (ci);
        }
        return (co);
    }

    public String validarCantidad(Facturamedicamentos venta, short idMed) {
        // después verifica si la cantidad solicitada está disponible en el inventario de la droguería
        Medicamento medicamento = medicamentoDao.leer(idMed);
        venta.setMedicamento(medicamento);
        if (venta.getMedicamento().getStock() - venta.getCantidadvendida() < 0) { //en teoría según el JPA de puede tener la información del medicamento y sacar el stock sin necesidad de hacer la consulta en la DB, toca verificar si realmente funciona
            return (ca);
        }
        return (co);
    }

    public String validarPrecio(long precio) {
        if (precio < 10000000) {
            return (co);
        }
        return (si);
    }

    public List<Medicamento> obtenerTodosMedicamentos() {
        List<Medicamento> medicamentos = medicamentoDao.leertodo();
        return medicamentos;
    }

    public List<Medicamento> filtrarMedicamentos(Medicamento medicamento) {
        List<Medicamento> medicamentos = medicamentoDao.leertodo(medicamento);
        return medicamentos;
    }

    public boolean vender(ArrayList<Short> cantidad, ArrayList<Short> idMedicamento) {
        boolean isCompra = false;
        try {
            for (int i = 0; i < cantidad.size(); i++) {
                Medicamento medicamentoAntiguo = medicamentoDao.leer(idMedicamento.get(i));
                Medicamento medicamentoNuevo = medicamentoAntiguo;
                int suma = medicamentoAntiguo.getStock() - cantidad.get(i);
                medicamentoNuevo.setStock(Short.parseShort(String.valueOf(suma)));
                isCompra = medicamentoDao.actualizar(medicamentoAntiguo, medicamentoNuevo);
            }
        } catch (NumberFormatException e) {
        }
        return isCompra;
    }

    public int registrarFactura(Factura c) {
        int ID = aO.crear(c);
        return ID;
    }

    public void RegistrarFacturaMed(Facturamedicamentos c) {
        aO.crearFactura(c);
    }

    public Medicamento obtenerMed(short Id) {
        return medicamentoDao.leer(Id);
    }
}
