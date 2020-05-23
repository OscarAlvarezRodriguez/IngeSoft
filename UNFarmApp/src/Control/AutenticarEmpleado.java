package Control;

import DAO.EmpleadoDAO;
import Entidad.Empleado;

public class AutenticarEmpleado {

    private EmpleadoDAO empleado = new EmpleadoDAO();
    private static String cn ="Número cedula no válido";
    private static String co ="Correcto";

    public AutenticarEmpleado() {
    }

    public String verificarLogin(Empleado emp) {
        if (!verificarLongitudCedula(emp.getCedulaEmpleado()).equals(co)) {
            return (cn);
        }

        if (!verificarLongitudContrasenia(emp.getContraseniaEmpleado()).equals(co)) {
            return ("Longitud de contraseña incorrecta");
        }

        if (!verificarMayuscula(emp.getContraseniaEmpleado()).equals(co)) {
            return ("La contraseña debe contener almenos una mayuscula");
        }

        if (!verificarNumero(emp.getContraseniaEmpleado()).equals(co)) {
            return ("La contraseña debe contener al menos un numero");
        }
        if (empleado.leer(emp) != null) {
            return ("Bienvenido");
        }
        return ("Datos incorrectos");
    }

    public String verificarLongitudCedula(String cedulaEmpleado) {
        if (cedulaEmpleado.length() > 6 && cedulaEmpleado.length() <= 11 && !cedulaEmpleado.isEmpty()){
            return (co);
        }
        return (cn);
    }

    public String verificarLongitudContrasenia(String contraseniaEmpleado) {
        if (contraseniaEmpleado.length() >= 5 && contraseniaEmpleado.length() < 13 && !contraseniaEmpleado.isEmpty()){
            return(co);
        }
        return("Longitud de contraseña incorrecta");
    }

    public String verificarMayuscula(String contraseniaEmpleado) {
        if (contraseniaEmpleado.matches("(?s).*[A-Z].*")){
            return(co);
        }
        return("La contraseña debe contener almenos una mayuscula");
    }

    public String verificarNumero(String contraseniaEmpleado) {
        if (contraseniaEmpleado.matches("(?s).*[0-9].*")){
            return(co);
        }
        return("La contraseña debe contener al menos un numero");
    }

}
