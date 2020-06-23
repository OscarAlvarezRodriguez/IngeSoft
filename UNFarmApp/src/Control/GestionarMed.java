package Control;

import DAO.MedicamentoDAO;
import Entidad.Medicamento;
import java.util.List;

public class GestionarMed {

    MedicamentoDAO medicamentoDAO = new MedicamentoDAO();

    public List<Medicamento> listaDeMedicamentos() {
        List<Medicamento> Medicamentos = null;
        Medicamentos = medicamentoDAO.leertodo();
        return Medicamentos;
    }

    public List<Medicamento> listaDeMedicamentos(Medicamento medicamento) {
        List<Medicamento> Medicamentos = null;
        Medicamentos = medicamentoDAO.leertodo(medicamento);
        return Medicamentos;
    }

    public Medicamento leerMedicamento(short idMed) {
        Medicamento medicamento = null;
        medicamento = medicamentoDAO.leer(idMed);
        return medicamento;
    }

    public void actualizarMedicamento(Medicamento viejo, Medicamento nuevo) {
        medicamentoDAO.actualizar(viejo, nuevo);
    }

}
