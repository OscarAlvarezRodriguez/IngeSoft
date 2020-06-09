package Control;

import DAO.CompraDAO;
import DAO.MedicamentoDAO;
import DAO.VenderDAO;
import Entidad.Cliente;
import Entidad.Compra;
import Entidad.Compramedicamento;
import Entidad.CompramedicamentoPK;
import Entidad.Drogueria;
import Entidad.Empleado;
import Entidad.Factura;
import Entidad.Facturamedicamentos;
import Entidad.Medicamento;
import java.util.ArrayList;
import java.util.List;

public class VenderMed {

    private MedicamentoDAO medicamentoDao = new MedicamentoDAO();
    private VenderDAO aO = new VenderDAO();

    public boolean validarCliente(String nombre) {
        if (nombre.length() > 4 && nombre.length() < 33 && !nombre.isEmpty()) {
            return true;
        }
        return false;
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
                int suma = medicamentoAntiguo.getStock() - cantidad.get(i) ;
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
}
