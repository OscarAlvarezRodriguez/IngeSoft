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
    public String validarDatos(Factura venta) {
        //como toca verificar la cantidad individual de cada medicamento sea la correcta, se llama la lista de medicamentos solicitados y se extraen lso datos a verificar
        // por ello se llama a getFacturamedicamentosList, la función recorre la lista y valida la contidad
        for (int i = 0; i < venta.getFacturamedicamentosList().size(); i++) {
            String val = validarCantidad(venta.getFacturamedicamentosList().get(i));
            if (!val.equals(co)) {
                return (val);
            }
        }
        //valida que el precio total no exceda los 10M
        if (!validarPrecio(venta.getPreciototal()).equals(co)) {
            return (si);
        }
        //finalmente si todo es correcto se hace la generación del id y la agregación de la misma
        int id = aO.crear(venta);
        if (id < 0) {
            return ("Error generación de ID");
        }
        return (fg);
    }

    public String validarCantidad(Facturamedicamentos venta) {
        // para eficiencia, primero valida si la cantidad vendida no excede las 2000 unidades
        if (venta.getCantidadvendida() > 2000 || venta.getCantidadvendida() <= 0) {
            return (ci);
        } // después verifica si la cantidad solicitada está disponible en el inventario de la droguería
        else if (venta.getMedicamento().getStock() < venta.getCantidadvendida()) { //en teoría según el JPA de puede tener la información del medicamento y sacar el stock sin necesidad de hacer la consulta en la DB, toca verificar si realmente funciona
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
