package Control;

import Entidad.Medicamento;
import DAO.MedicamentoDAO;
import DAO.MedicamentoinvimaDAO;
import Entidad.Medicamentoinvima;
import java.util.List;

public class AgregarMedicamento {

    public final MedicamentoDAO medicamentoDAO = new MedicamentoDAO();
    public final MedicamentoinvimaDAO medicamentoinvimaDAO = new MedicamentoinvimaDAO();
    private final String ma = "Medicamento ya agregado";
    private final String me = "Medicamento agregado exitosamente";
    private final String pi = "Precio fuera de rango";
    private final String co = "correcto";
    private final String mr = "Medicamento restaurado";
    private final String mre = "Error al restaurar medicamento";

    public AgregarMedicamento() {
    }

    public String validarDatos(Medicamento droga) {
        if (medicamentoDAO.existencia(droga.getIdmedicamentoinvima().getIdmedicamentoinvima()) != null) {
            if (droga.getStock() == -1) {
                short nuevostock = 0;
                Medicamento nuevadroga = droga;
                nuevadroga.setStock(nuevostock);
                if (medicamentoDAO.actualizar(droga, nuevadroga)) {
                    return (mr);
                }
                return (mre);
            }
            return (ma);
        }

        if (!validarPrecioventa(droga.getPrecioventa()).equals(co)) {
            return (pi);
        }
        medicamentoDAO.crear(droga);
        return (me);
    }

    public String validarPrecioventa(int precioventa) {
        if (precioventa >= 100 && precioventa < 10000000) {
            return (co);
        }
        return (pi);
    }

    public List<Medicamentoinvima> leerTodos(Medicamentoinvima m) {
        return medicamentoinvimaDAO.leertodo(m);
    }

    public List<Medicamentoinvima> leerTodos() {
        return medicamentoinvimaDAO.leertodo();
    }

    public Medicamentoinvima leerMed(String idMed) {
        return medicamentoinvimaDAO.leer(idMed);
    }
}
