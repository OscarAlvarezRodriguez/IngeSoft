package Control;

import Entidad.Cliente;
import DAO.ClienteDAO;

public class RegistrarCliente {
    private static String cn ="Número cedula no válido";
    private static String nn ="Lontigud nombre incorrecta";
    private static String tn ="Número telefónico no válido";
    private static String dn ="Longitud dirección incorrecta";
    private static String ddn = "Longitud descripción dirección incorrecta";
    private static String an ="Longitud apellido incorrecta";
    private static String co ="Correcto";

    public RegistrarCliente() {

    }

    public String ValidarDatos(Cliente cliente) {
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
        ClienteDAO nuevocliente = new ClienteDAO();
        nuevocliente.crear(cliente);
        return ("Cliente Registrado");
    }

    public String validarCedula(String cedula) {
        if (cedula.length() > 7 && cedula.length() < 12 && cedula.matches("\\d*") && !cedula.isEmpty()){
            return(co);
        }
        return (cn);
    }

    public String validarNombre(String nombre) {
        if (nombre.length() > 4 && nombre.length() < 21 && !nombre.isEmpty()){
            return(co);
        }
        return(nn);
    }

    public String validarTelefono(String telefono) {
        if (telefono.length() > 6 && telefono.length() < 16 && !telefono.isEmpty()){
            return(co);
        }
        return(tn);
    }

    public String validarDireccion(String direccion) {
        if (direccion.length() > 11 && direccion.length() < 16 && !direccion.isEmpty()){
            return(co);
        }
        return(dn);
    }

    public String validarDescripcionDir(String desdireccion) {
        if (desdireccion.length() <= 32){
            return(co);
        }
        return(ddn);
    }

    public String validarApellido(String apellido) {
        if (apellido.length() > 3 && apellido.length() < 21 && !apellido.isEmpty()){
            return(co);
        }
        return(an);
    }
}
