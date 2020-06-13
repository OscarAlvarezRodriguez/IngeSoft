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
    private final String rf = "Error registrando el cliente, intente de nuevo";
    private final String co = "Correcto";
    private final String ec = "Estado de cliente incorrecto";

    public RegistrarCliente() {

    }

    public String ValidarDatos(Cliente cliente) {
        //Tenemos dos casos en caso de estar registrado el cliente, el primero es que esté registrado y activo, el segundo que esté registrado e inactivo
        //Creamos la clase cliente existente para verificar si esta registrado y en caso afirmativo, tener los datos del Cliente de manera temporal
        //Por precaución mandamos primero la validación dde la cedula antes de registro, ya que de lo contrario si mandamos a consultar una cedula con el tipo de dato incorrecto puede generar conflictos en el JPA
        if (!validarCedula(cliente.getCedulacliente()).equals(co)) {
            return (cn);
        }
        if (nuevocliente.verificarExistencia(cliente)) {
            return (cr);
        }
        if (!validarNombre(cliente.getNombre()).equals(co)) {
            return (nn);
        }
        if (!validarTelefono(cliente.getTelefono()).equals(co)) {
            return (tn);
        }
        if (!validarDireccion(cliente.getDireccioncliente()).equals(co)) {
            return (dn);
        }
        if (!validarDescripcionDir(cliente.getDescripciondireccion()).equals(co)) {
            return (ddn);
        }
        if (!validarApellido(cliente.getApellido()).equals(co)) {
            return (an);
        }
        if (!validarEstado(cliente.getEliminado()).equals(co)) {
            return (ec);
        }
        if(!nuevocliente.crear(cliente)){
            return(rf);
        }
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

    public String validarApellido(String apellido) {
        if (apellido.length() > 4 && apellido.length() < 21 && !apellido.isEmpty()) {
            return (co);
        }
        return (an);
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

    public String validarEstado(Boolean estado) {
        if (estado == false) {
            return (co);
        }
        return (ec);
    }
}
