package Control;

import DAO.EmpleadoDAO;
import Entidad.Empleado;

public class AutenticarEmpleado {

    private EmpleadoDAO empleado = new EmpleadoDAO();

    public AutenticarEmpleado() {
    }

    public String verificarLogin(Empleado emp) {
        if (!verificarLongitudCedula(emp.getCedulaEmpleado())) {
            return ("Longitud de cedula incorrecta");
        }

        if (!verificarLongitudContrasenia(emp.getContraseniaEmpleado())) {
            return ("Longitud de contraseña incorrecta");
        }

        if (!verificarMayuscula(emp.getContraseniaEmpleado())) {
            return ("La contraseña debe contener almenos una mayuscula");
        }

        if (!verificarNumero(emp.getContraseniaEmpleado())) {
            return ("La contraseña debe contener al menos un numero");
        }

        if (empleado.leer(emp) != null) {
            return ("Bienvenido");
        }
        return ("Datos incorrectos");
    }

    private boolean verificarLongitudCedula(String cedulaEmpleado) {
        return (cedulaEmpleado.length() > 6 && cedulaEmpleado.length() <= 11);
    }

    private boolean verificarLongitudContrasenia(String contraseniaEmpleado) {
        return (contraseniaEmpleado.length() >= 5 && contraseniaEmpleado.length() < 13);
    }

    private boolean verificarMayuscula(String contraseniaEmpleado) {
        return (contraseniaEmpleado.matches("(?s).*[A-Z].*"));
    }

    private boolean verificarNumero(String contraseniaEmpleado) {
        return (contraseniaEmpleado.matches("(?s).*[0-9].*"));
    }

}
