package Control;

import Entidad.Empleado;
import DAO.EmpleadoDAO;

public class RegistrarEmpleado {

    private static String con = "Contraseña no válida";
    private static String nn = "Longitud nombre incorrecta";
    private static String tn = "Número telefónico no válido";
    private static String dn = "Longitud dirección incorrecta";
    private static String an = "Longitud apellido incorrecta";
    private static String en = "Correo no válido";
    private static String co = "Correcto";
    private static String cn = "Cédula nó valida";

    public RegistrarEmpleado() {
    }

    public String validarDatos(Empleado empleado) {

        if (!validarNombre(empleado.getNombreEmpleado()).equals(co)) {
            return (nn);
        }
        if (!validarTelefono(empleado.getTelefonoEmpleado()).equals(co)) {
            return (tn);
        }
        if (!validarDireccion(empleado.getDireccionEmpleado()).equals(co)) {
            return (dn);
        }
        if (!validarApellido(empleado.getApellidoEmpleado()).equals(co)) {
            return (an);
        }
        if (!validarContrasenia(empleado.getContraseniaEmpleado()).equals(co)) {
            return (con);
        }
        if (!validarCorreo(empleado.getCorreoEmpleado()).equals(co)) {
            return (en);
        }
        EmpleadoDAO nuevoempleado = new EmpleadoDAO();
        nuevoempleado.crear(empleado);
        return ("Registro exitoso");
    }

    public String validarCedula(String cedula) {
        if (cedula.length() > 7 && cedula.length() < 11 && cedula.matches("\\d*") && !cedula.isEmpty()) {
            return (co);
        }
        return (cn);
    }

    public String validarNombre(String nombre) {
        if (nombre.length() > 4 && nombre.length() < 15 && !nombre.isEmpty()) {
            return (co);
        }
        return (nn);
    }

    public String validarTelefono(String telefono) {
        if (telefono.length() > 6 && telefono.length() < 16 && !telefono.isEmpty()) {
            return (co);
        }
        return (tn);
    }

    public String validarDireccion(String direccion) {
        if (direccion.length() > 11 && direccion.length() < 33 && !direccion.isEmpty()) {
            return (co);
        }
        return (dn);
    }

    public String validarApellido(String apellido) {
        if (apellido.length() > 3 && apellido.length() < 21 && !apellido.isEmpty()) {
            return (co);
        }
        return (an);
    }

    public String validarContrasenia(String contrasenia) {
        if (contrasenia.length() > 4 && contrasenia.length() < 13 && contrasenia.matches("\\w*") && contrasenia.matches("\\w*") && contrasenia.matches(".*[A-Z].*") && contrasenia.matches(".*[0-9].*") && !contrasenia.isEmpty()) {
            return (co);
        }
        return (con);
    }

    public String validarCorreo(String correo) {
        if (correo.length() > 8 && correo.length() < 33 && correo.matches(".+@.+") && !correo.isEmpty()) {
            return (co);
        }
        return (en);
    }
}
