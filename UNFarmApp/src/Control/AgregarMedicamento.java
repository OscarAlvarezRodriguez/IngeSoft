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

    public boolean yaAgregado(Medicamento m) {
        if (m == null) {
            return false;
        }
        return true;
    }

    public boolean Stock(Medicamento m) { 
            if (m.getStock() == -1) {
                return true;
            } else {
                return false;
            }
    }

    public Medicamento registrarMed(Medicamentoinvima medicamentoinvima) {
        Medicamento m = new Medicamento(0, (short) 0);
        m.setIdmedicamentoinvima(medicamentoinvima);
        medicamentoDAO.crear(m);
        return m;
    }
}
