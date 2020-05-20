package Control;

import Entidad.Empleado;

public class RegistrarEmpleado {

    public RegistrarEmpleado() {
    }

    public String validarDatos(Empleado empleado) {
        if (!validarCedula(empleado.getCedulaEmpleado())) {
            return ("Número de Cedula no valido");
        }
        if (!validarNombre(empleado.getNombreEmpleado())) {
            return ("Longitud nombre incorrecta");
        }
        if (!validarTelefono(empleado.getTelefonoEmpleado())) {
            return ("Número de telefono no valido");
        }
        if (!validarDireccion(empleado.getDireccionEmpleado())) {
            return ("Longitud dirección incorrecta");
        }
        if (!validarDescripcionDir(empleado.getDescripcionDireccionEmpleado())) {
            return ("Longitud descripción dirección incorrecta");
        }
        if (!validarApellido(empleado.getApellidoEmpleado())) {
            return ("Longitud apellido incorrecta");
        }
        if (!validarContrasenia(empleado.getContraseniaEmpleado())) {
            return ("Contraseña no valida");
        }
        if (!validarCorreo(empleado.getCorreoEmpleado())) {
            return ("Correo no valido");
        }
        return ("Registro exitoso");
    }

    private boolean validarCedula(String cedula) {
        return (cedula.length() > 7 && cedula.length() < 11 && cedula.matches("\\d*"));
    }

    private boolean validarNombre(String nombre) {
        return (nombre.length() > 4 && nombre.length() < 15);
    }

    private boolean validarTelefono(String telefono) {
        return (telefono.length() > 6 && telefono.length() < 16);
    }

    private boolean validarDireccion(String direccion) {
        return (direccion.length() > 11 && direccion.length() < 33);
    }

    private boolean validarDescripcionDir(String desdireccion) {
        return (desdireccion.length() >= 25);
    }

    private boolean validarApellido(String apellido) {
        return (apellido.length() > 3 && apellido.length() < 21);
    }

    private boolean validarContrasenia(String contrasenia) {
        return (contrasenia.length() > 4 && contrasenia.length() < 13 && contrasenia.matches("\\w*") && contrasenia.matches("\\w*") && contrasenia.matches(".*[A-Z].*") && contrasenia.matches(".*[0-9].*"));
    }

    private boolean validarCorreo(String correo) {
        return (correo.length() > 8 && correo.length() < 33 && correo.matches(".+@.+"));
    }
}
