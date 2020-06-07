package Control;

import DAO.MedicamentoDAO;
import Entidad.Medicamento;
import java.util.ArrayList;
import java.util.List;

public class ComprarMedicamento {

    MedicamentoDAO medicamentoDao = new MedicamentoDAO();

    public List<Medicamento> obtenerTodosMedicamentos() {
        List<Medicamento> medicamentos = medicamentoDao.leertodo();
        return medicamentos;
    }

    public List<Medicamento> filtrarMedicamentos(Medicamento medicamento) {
        List<Medicamento> medicamentos = medicamentoDao.leertodo(medicamento);
        return medicamentos;
    }

    public void comprar(ArrayList<Short> cantidad, ArrayList<Short> idMedicamento) {
        boolean r = false;
        for (int i = 0; i < cantidad.size(); i++) {
            Medicamento medicamentoAntiguo = medicamentoDao.leer(idMedicamento.get(i));
            Medicamento medicamentoNuevo = medicamentoAntiguo;
            int suma = cantidad.get(i) + medicamentoAntiguo.getStock();
            medicamentoNuevo.setStock(Short.parseShort(String.valueOf(suma)));
            r = medicamentoDao.actualizar(medicamentoAntiguo, medicamentoNuevo);
        }

    }

}
