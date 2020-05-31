package Control;

import DAO.EmpleadoDAO;
import Entidad.Empleado;

public class AutenticarEmpleado {

    public final EmpleadoDAO empleado = new EmpleadoDAO();
    private final String cn = "Número cedula no válido";
    private final String con = "Longitud contraseña incorrecta";
    private final String conn = "Número en contraseña incorrecto";
    private final String comn = "Mayúscula en contraseña incorrecto";
    private final String co = "Correcto";
    private final String di = "Datos incorrectos";
    private final String bi = "Bienvenido";

    public AutenticarEmpleado() {
    }

    public String verificarLogin(Empleado emp) {
        if (!validarLongitudCedula(emp.getCedulaEmpleado()).equals(co)) {
            return (cn);
        }

        if (!validarLongitudContrasenia(emp.getContraseniaEmpleado()).equals(co)) {
            return (con);
        }
        if (!validarMayusculaContrasenia(emp.getContraseniaEmpleado()).equals(co)) {
            return (comn);
        }
        if (!validarNumeroContrasenia(emp.getContraseniaEmpleado()).equals(co)) {
            return (conn);
        }
        if (empleado.leer(emp) != null) {
            return (bi);
        }
        return (di);
    }

    public String validarLongitudCedula(String cedulaEmpleado) {
        if (cedulaEmpleado.length() > 6 && cedulaEmpleado.length() <= 11 && !cedulaEmpleado.isEmpty()) {
            return (co);
        }
        return (cn);
    }

    public String validarLongitudContrasenia(String contraseniaEmpleado) {
        if (contraseniaEmpleado.length() >= 5
                && contraseniaEmpleado.length() < 21
                && !contraseniaEmpleado.isEmpty()) {
            return (co);
        }
        return (con);
    }

    public String validarMayusculaContrasenia(String contraseniaEmpleado) {
        if (contraseniaEmpleado.matches("(?s).*[A-Z].*")) {
            return (co);
        }
        return (comn);
    }

    public String validarNumeroContrasenia(String contraseniaEmpleado) {
        if (contraseniaEmpleado.matches("(?s).*[0-9].*")) {
            return (co);
        }
        return (conn);
    }

}
