package Control;

import Entidad.Cliente;
import DAO.ClienteDAO;

public class RegistrarCliente {

    private final ClienteDAO nuevocliente = new ClienteDAO();
    private final String cn = "Número cédula no válido";
    private final String nn = "Lontigud nombre incorrecta";
    private final String tn = "Número telefónico no válido";
    private final String dn = "Longitud dirección incorrecta";
    private final String ddn = "Longitud descripción dirección incorrecta";
    private final String an = "Longitud apellido incorrecta";
    private final String cr = "Cliente ya registrado";
    private final String re = "Registro exitoso";
    private final String co = "Correcto";

    public RegistrarCliente() {

    }

    public String ValidarDatos(Cliente cliente) {
        if (nuevocliente.leer(cliente) != null) {
            return (cr);
        }
        if (!validarCedula(cliente.getCedulaCliente()).equals(co)) {
            return (cn);
        }
        if (!validarNombre(cliente.getNombreCliente()).equals(co)) {
            return (nn);
        }
        if (!validarTelefono(cliente.getTelefonoCliente()).equals(co)) {
            return (tn);
        }
        if (!validarDireccion(cliente.getDireccionCliente()).equals(co)) {
            return (dn);
        }
        if (!validarDescripcionDir(cliente.getDescripcionDireccionCliente()).equals(co)) {
            return (ddn);
        }
        if (!validarApellido(cliente.getApellidoCliente()).equals(co)) {
            return (an);
        }
        nuevocliente.crear(cliente);
        return (re);
    }

    public String validarCedula(String cedula) {
        if (cedula.length() > 7 && cedula.length() < 12 && cedula.matches("\\d*") && !cedula.isEmpty()) {
            return (co);
        }
        return (cn);
    }

    public String validarNombre(String nombre) {
        if (nombre.length() > 4 && nombre.length() < 21 && !nombre.isEmpty()) {
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

    public String validarDescripcionDir(String desdireccion) {
        if (desdireccion.length() <= 32) {
            return (co);
        }
        return (ddn);
    }

    public String validarApellido(String apellido) {
        if (apellido.length() > 4 && apellido.length() < 21 && !apellido.isEmpty()) {
            return (co);
        }
        return (an);
    }
}
