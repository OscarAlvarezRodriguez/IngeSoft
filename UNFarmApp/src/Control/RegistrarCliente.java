package Control;

import Entidad.Cliente;

public class RegistrarCliente {

    public RegistrarCliente() {

    }

    public String ValidarDatos(Cliente cliente) {
        if (!validarCedula(cliente.getCedulaCliente())) {
            return ("Número cedula no válido");
        }
        if (!validarNombre(cliente.getNombreCliente())) {
            return ("Longitud nombre incorrecta");
        }
        if (!validarTelefono(cliente.getTelefonoCliente())) {
            return ("Número telefónico no válido");
        }
        if (!validarDireccion(cliente.getDireccionCliente())) {
            return ("Longitud dirección incorrecta");
        }
        if (!validarDescripcionDir(cliente.getDescripcionDireccionCliente())) {
            return ("Longitud descripción dirección incorrecta");
        }
        if (!validarApellido(cliente.getApellidoCliente())) {
            return ("Longitud apellido incorrecta");
        }
        return ("Cliente Registrado");
    }

    private boolean validarCedula(String cedula) {
        return (cedula.length() > 7 && cedula.length() < 11 && cedula.matches("\\d*"));
    }

    private boolean validarNombre(String nombre) {
        return (nombre.length() > 4 && nombre.length() < 21);
    }

    private boolean validarTelefono(String telefono) {
        return (telefono.length() > 6 && telefono.length() < 16);
    }

    private boolean validarDireccion(String direccion) {
        return (direccion.length() > 11 && direccion.length() < 16);
    }

    private boolean validarDescripcionDir(String desdireccion) {
        return (desdireccion.length() <= 32);
    }

    private boolean validarApellido(String apellido) {
        return (apellido.length() > 3 && apellido.length() < 21);
    }
}
