package Control;

import Entidad.Drogueria;
import DAO.DrogueriaDAO;

public class EditarDrogueria {

    private final DrogueriaDAO farm = new DrogueriaDAO();
    private final String rpn = "Longitud representante legal incorrecta";
    private final String nn = "Longitud nombre incorrecta";
    private final String tn = "Número telefónico no válido";
    private final String dn = "Longitud dirección incorrecta";
    private final String en = "Correo no válido";
    private final String co = "Correcto";
    private final String nitn = "Nit no válido";
    private final String dr = "No hay ninguna drogueria registrada";
    private final String re = "Registro exitoso";

    public EditarDrogueria() {
    }

    public String validarDatos(Drogueria drogapp) {
        if (farm.leer(drogapp) == null) {
            return (dr);
        }
        Drogueria antigua = farm.leer();
        if (!validarNombre_drogueria(drogapp.getNombredrogueria()).equals(co)) {
            return (nn);
        }
        if (!validarDireccion(drogapp.getDirecciondrogueria()).equals(co)) {
            return (dn);
        }
        if (!validarTelefono_drogueria(drogapp.getTelefono()).equals(co)) {
            return (tn);
        }
        if (!validarEmail(drogapp.getEmail()).equals(co)) {
            return (en);
        }
        if (!validarRepresentante(drogapp.getRepresentantelegal()).equals(co)) {
            return (rpn);
        }
        farm.actualizar(antigua, drogapp);
        return re;
    }

    public String validarNit(String nit) {
        if (nit.length() > 10 && nit.length() < 21 && !nit.isEmpty()) {
            return (co);
        }
        return (nitn);
    }

    public String validarNombre_drogueria(String nombred) {
        if (nombred.length() > 11 && nombred.length() < 33 && !nombred.isEmpty()) {
            return (co);
        }
        return (nn);
    }

    public String validarDireccion(String direccion) {
        if (direccion.length() > 11 && direccion.length() < 33 && !direccion.isEmpty()) {
            return (co);
        }
        return (dn);
    }

    public String validarTelefono_drogueria(String teldro) {
        if (teldro.length() > 6 && teldro.length() < 16 && !teldro.isEmpty()) {
            return (co);
        }
        return (tn);
    }

    public String validarEmail(String email) {
        if (email.length() > 8 && email.length() < 51 && email.matches(".+@.+\\..+") && !email.isEmpty()) {
            return (co);
        }
        return (en);
    }

    public String validarRepresentante(String representante) {
        if (representante.length() > 10 && representante.length() < 33 && !representante.isEmpty()) {
            return (co);
        }
        return (rpn);
    }

    public boolean verDrogueria() {
        Drogueria d = farm.leer();
        return (d != null);
    }
    
    public Drogueria obtenerDrogueria(){
        Drogueria d = farm.leer();
        return d;
    }
    
    
}
