package Control;

import Entidad.Drogueria;
import DAO.DrogueriaDAO;

public class RegistrarDrogueria {
    private static String rpn ="Lontigud represetante legal incorrecta";
    private static String nn ="Longitud nombre incorrecta";
    private static String tn ="Número telefónico no válido";
    private static String dn ="Longitud dirección incorrecta";
    private static String en ="Correo no válido";
    private static String co ="Correcto";
    private static String nitn ="Nit no válido";

    public RegistrarDrogueria() {
    }

    public String ValidarDatos(Drogueria drogapp) {
        if (!validarNit(drogapp.getNitDrogueria()).equals(co)) {
            return (nitn);
        }
        if (!validarNombre_drogueria(drogapp.getNombreDrogueria()).equals(co)) {
            return (nn);
        }
        if (!validarDireccion(drogapp.getDireccionDrogueria()).equals(co)) {
            return (dn);
        }
        if (!validarTelefono_drogueria(drogapp.getTelefonoDrogueria()).equals(co)) {
            return (tn);
        }
        if (!validarEmail(drogapp.getEmailDrogueria()).equals(co)) {
            return (en);
        }
        if (!validarRepresentante(drogapp.getRepresentanteLegalDrogueria()).equals(co)) {
            return (rpn);
        }
        DrogueriaDAO farm = new DrogueriaDAO();
        farm.crear(drogapp);
        return ("Registro exitoso");
    }

    public String validarNit(String nit) {
        if (nit.length() > 10 && nit.length() < 21 && !nit.isEmpty()){
            return(co);
        }
        return(nitn);
    }

    public String validarNombre_drogueria(String nombred) {
        if (nombred.length() > 11 && nombred.length() < 33 && !nombred.isEmpty()){
            return(co);
        }
        return(nn);
    }

    public String validarDireccion(String direccion) {
        if (direccion.length() > 11 && direccion.length() < 33 && !direccion.isEmpty()){
            return(co);
        }
        return(dn);
    }

    public String validarTelefono_drogueria(String teldro) {
        if (teldro.length() > 5 && teldro.length() < 12 && !teldro.isEmpty()){
            return(co);
        }
        return(tn);
    }

    public String validarEmail(String email) {
        if (email.length() > 8 && email.length() < 26 && email.matches(".+@.+") && !email.isEmpty()){
            return(co);
        }
        return(en);
    }

    public String validarRepresentante(String representante) {
        if (representante.length() > 10 && representante.length() < 33 && !representante.isEmpty()){
            return(co);
        }
        return(rpn);
    }
}
