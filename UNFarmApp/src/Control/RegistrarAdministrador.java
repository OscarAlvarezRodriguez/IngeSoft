package Control;

import Entidad.Empleado;
import DAO.EmpleadoDAO;

public class RegistrarAdministrador {

    private EmpleadoDAO emple = new EmpleadoDAO();
    private final EmpleadoDAO nuevoempleado = new EmpleadoDAO();
    private final String cn = "Cédula no válida";
    private final String con = "Longitud contraseña incorrecta";
    private final String conn = "Número en contraseña incorrecto";
    private final String comn = "Mayúscula en contraseña incorrecto";
    private final String nn = "Longitud nombre incorrecta";
    private final String tn = "Número telefónico no válido";
    private final String dn = "Longitud dirección incorrecta";
    private final String an = "Longitud apellido incorrecta";
    private final String en = "Correo no válido";
    private final String er = "El empleado ya está registrado";
    private final String re = "Registro exitoso";
    private final String co = "Correcto";

    public RegistrarAdministrador() {
    }

    public String validarDatos(Empleado empleado) {
        if (nuevoempleado.leerAdmin() != null) {
            return (er);
        }
        if (!validarNombre(empleado.getNombreempleado()).equals(co)) {
            return (nn);
        }
        if (!validarTelefono(empleado.getTelefono()).equals(co)) {
            return (tn);
        }
        if (!validarDireccion(empleado.getDireccionempleado()).equals(co)) {
            return (dn);
        }
        if (!validarApellido(empleado.getApellidoempleado()).equals(co)) {
            return (an);
        }
        if (!validarLongitudContrasenia(empleado.getContrasenia()).equals(co)) {
            return (con);
        }
        if (!validarMayusculaContrasenia(empleado.getContrasenia()).equals(co)) {
            return (comn);
        }
        if (!validarNumeroContrasenia(empleado.getContrasenia()).equals(co)) {
            return (conn);
        }
        if (!validarCorreo(empleado.getCorreo()).equals(co)) {
            return (en);
        }
        nuevoempleado.crear(empleado);
        return (re);
    }

    public String validarCedula(String cedula) {
        if (cedula.length() > 6 && cedula.length() < 12
                && cedula.matches("\\d*") && !cedula.isEmpty()) {
            return (co);
        }
        return (cn);
    }

    public String validarNombre(String nombre) {
        if (nombre.length() > 4 && nombre.length() < 21
                && !nombre.isEmpty()) {
            return (co);
        }
        return (nn);
    }

    public String validarTelefono(String telefono) {
        if (telefono.length() > 6 && telefono.length() < 16
                && !telefono.isEmpty()) {
            return (co);
        }
        return (tn);
    }

    public String validarDireccion(String direccion) {
        if (direccion.length() > 11 && direccion.length() < 33
                && !direccion.isEmpty()) {
            return (co);
        }
        return (dn);
    }

    public String validarApellido(String apellido) {
        if (apellido.length() > 4 && apellido.length() < 21
                && !apellido.isEmpty()) {
            return (co);
        }
        return (an);
    }

    public String validarCorreo(String correo) {
        if (correo.length() > 8 && correo.length() < 50
                && correo.matches(".+@.+\\..+")
                && !correo.isEmpty()) {
            return (co);
        }
        return (en);
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

    public boolean compararContrasenia(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        return false;
    }

    public boolean registrarAdministrador() {
        Empleado result = emple.leerAdmin();
        return (result == null);
    }

}
