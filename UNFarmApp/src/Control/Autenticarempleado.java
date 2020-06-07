package Control;

import DAO.EmpleadoDAO;
import Entidad.Empleado;

public class Autenticarempleado {

    public final EmpleadoDAO empleado = new EmpleadoDAO();
    private final String cn = "Número cedula no válido";
    private final String con = "Longitud contraseña incorrecta";
    private final String conn = "Número en contraseña incorrecto";
    private final String comn = "Mayúscula en contraseña incorrecto";
    private final String co = "Correcto";
    private final String di = "Datos incorrectos";
    private final String bi = "Bienvenido";
    private final String el = "empleado Inactivo o Suspendido";
    public Autenticarempleado() {
    }

    public String verificarLogin(Empleado emp) {
        if (!validarLongitudCedula(emp.getCedulaempleado()).equals(co)) {
            return (cn);
        }
        if (!validarLongitudContrasenia(emp.getContrasenia()).equals(co)) {
            return (con);
        }
        if (!validarMayusculaContrasenia(emp.getContrasenia()).equals(co)) {
            return (comn);
        }
        if (!validarNumeroContrasenia(emp.getContrasenia()).equals(co)) {
            return (conn);
        }
        if (empleado.leer(emp) != null) {
            Empleado veresempleado = empleado.leer(emp);
            if(veresempleado.getEstado().equals("SUSPENDIDO") || veresempleado.getEstado().equals("INACTIVO")){
                return(el);
            }
            return (bi);
        }
        return (di);
    }

    public String validarLongitudCedula(String cedulaempleado) {
        if (cedulaempleado.length() > 6 && cedulaempleado.length() <= 11 && !cedulaempleado.isEmpty()) {
            return (co);
        }
        return (cn);
    }

    public String validarLongitudContrasenia(String contraseniaempleado) {
        if (contraseniaempleado.length() >= 5
                && contraseniaempleado.length() < 21
                && !contraseniaempleado.isEmpty()) {
            return (co);
        }
        return (con);
    }

    public String validarMayusculaContrasenia(String contraseniaempleado) {
        if (contraseniaempleado.matches("(?s).*[A-Z].*")) {
            return (co);
        }
        return (comn);
    }

    public String validarNumeroContrasenia(String contraseniaempleado) {
        if (contraseniaempleado.matches("(?s).*[0-9].*")) {
            return (co);
        }
        return (conn);
    }

}
