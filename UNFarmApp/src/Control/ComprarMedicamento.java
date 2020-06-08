package Control;

import DAO.CompraDAO;
import DAO.MedicamentoDAO;
import Entidad.Compra;
import Entidad.Compramedicamento;
import Entidad.CompramedicamentoPK;
import Entidad.Medicamento;
import java.util.ArrayList;
import java.util.List;

public class ComprarMedicamento {

    private MedicamentoDAO medicamentoDao = new MedicamentoDAO();
    private CompraDAO aO = new CompraDAO();

    public boolean validarProveedor(String nombre) {
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

    public boolean comprar(ArrayList<Short> cantidad, ArrayList<Short> idMedicamento) {
        boolean isCompra = false;
        try {
            for (int i = 0; i < cantidad.size(); i++) {
                Medicamento medicamentoAntiguo = medicamentoDao.leer(idMedicamento.get(i));
                Medicamento medicamentoNuevo = medicamentoAntiguo;
                int suma = cantidad.get(i) + medicamentoAntiguo.getStock();
                medicamentoNuevo.setStock(Short.parseShort(String.valueOf(suma)));
                isCompra = medicamentoDao.actualizar(medicamentoAntiguo, medicamentoNuevo);
            }
        } catch (NumberFormatException e) {
        }
        return isCompra;
    }

    public int registroCompra(Compra c) {
        int ID = aO.crear(c);
        return ID;
    }

    public void registroCompraMed(Compramedicamento c) {
        aO.crearCompra(c);
    }
}
