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

    public String validarDatos(Medicamento m, int precio, short IdInvima) {
        if (!validarPrecioventa(precio).equals(co)) {
            return pi;
        }
        if (validarStock(m, precio).equals(mr)) {
            return mr;
        }
        if (!validarMed(m).equals(co)) {
            return ma;
        }
        if (!registrarMed(IdInvima, precio).equals(me)) {
            return co;
        }
        return me;
    }

    private String validarPrecioventa(int precioventa) {
        if (precioventa >= 100 && precioventa < 10000000) {
            return (co);
        }
        return (pi);
    }

    private String validarMed(Medicamento m) {
        if (m == null) {
            return co;
        }
        return ma;
    }

    private String validarStock(Medicamento m, int precio) {
        if (m.getStock() == -1) {
            Medicamento nuevo = new Medicamento(precio, (short) 0);
            medicamentoDAO.actualizar(m, nuevo);
            return mr;
        }
        return mre;

    }

    private String registrarMed(short idMedinvima, int precio) {
        Medicamento m = new Medicamento(precio, (short) 0);
        m.setIdmedicamentoinvima(medicamentoinvimaDAO.leer(idMedinvima));
        medicamentoDAO.crear(m);
        return me;
    }

    public Medicamento leerMed(Medicamentoinvima mi) {
        Medicamento m = medicamentoDAO.existencia(mi.getIdmedicamentoinvima());
        return m;
    }

    public List<Medicamentoinvima> leerTodos(Medicamentoinvima m) {
        return medicamentoinvimaDAO.leertodo(m);
    }

    public List<Medicamentoinvima> leerTodos() {
        return medicamentoinvimaDAO.leertodo();
    }

    public Medicamentoinvima leerMed(short idMed) {
        return medicamentoinvimaDAO.leer(idMed);
    }
}
