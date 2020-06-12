package Control;

import Entidad.Medicamento;
import DAO.MedicamentoDAO;

public class EliminarMedicamento {

    private final String me = "Medicamento Eliminado";
    private final String mg = "Error al eliminar el medicamento";
    private final MedicamentoDAO medicamentoDAO = new MedicamentoDAO();

    public EliminarMedicamento() {
    }

    public String validarEliminacion(Medicamento droga) {
        Medicamento nuevadroga = droga;
        short nuevostock = -1;
        nuevadroga.setStock(nuevostock);
        if (medicamentoDAO.actualizar(droga, nuevadroga) == true) {
            return (me);
        } else {
            return (mg);
        }
    }
}
