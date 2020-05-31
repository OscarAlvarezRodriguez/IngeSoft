/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.ClienteDAO;
import Entidad.Cliente;


public class EditarCliente {
    private final ClienteDAO actCliente = new ClienteDAO();
    private final String cn = "Número cedula no válido";
    private final String nn = "Lontigud nombre incorrecta";
    private final String tn = "Número telefónico no válido";
    private final String dn = "Longitud dirección incorrecta";
    private final String ddn = "Longitud descripción dirección incorrecta";
    private final String an = "Longitud apellido incorrecta";
    private final String cr = "Cliente no registrado";
    private final String re = "Actualización correcta";
    private final String co = "Correcto";

    public EditarCliente() {
        
    }
    
    public String ValidarDatos(Cliente clienteAct, String cedulaCliente) {
        if (actCliente.leer(cedulaCliente) == null) {
            return (cr);
        }
        actCliente.actualizar(clienteAct,cedulaCliente);
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
        if (direccion.length() > 11 && direccion.length() < 16 && !direccion.isEmpty()) {
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
        if (apellido.length() > 3 && apellido.length() < 21 && !apellido.isEmpty()) {
            return (co);
        }
        return (an);
    }
    
}
