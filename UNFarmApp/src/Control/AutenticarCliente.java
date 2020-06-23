package Control;

import DAO.ClienteDAO;
import Entidad.Cliente;

public class AutenticarCliente {

    private final ClienteDAO cliente = new ClienteDAO();
    private final String cn = "Número cédula no válido";
    private final String cnr = "Cliente no registrado";
    private final String cr = "Cliente ya registrado";
    private final String ci = "Cliente inactivo";
    private final String bi = "Bienvenido";
    private final String co = "Correcto";

    public AutenticarCliente() {
    }

    public String verificarLogin(String cli) {
        
        //Valida la longitud de la cedula
        if (!validarCedula(cli).equals(co)) {
            return (cn);
        }
        //Devuelve "ci" si el cliente esta inactivo o "cr" si el cliente no esta registrado
        if (!validarClienteActivo(cli).equals(co) && !validarClienteActivo(cli).equals(cr)) {
            return (ci);
        }
        //Devuelve "cnr" si el cliente no esta registrado
        if (!validarClienteReg(cli).equals(co)) {
            return (cnr);
        }
        
        return (bi);
    }

    public String validarCedula(String cedula) {
        if (cedula.length() > 6 && cedula.length() < 12 && cedula.matches("\\d*") && !cedula.isEmpty()) {
            return (co);
        }
        return (cn);
    }

    public String validarClienteReg(String cedula) {
        if (getCliente(cedula) == null) {
            return (cnr);
        }
        return (co);
    }

    public String validarClienteActivo(String cedula) {
        Cliente c = getCliente(cedula);
        if (c != null) {
            if (!c.getEliminado()) {
                return co;
            } else {
                return ci;
            }
        } else {
            return cr;
        }
    }
    
    // Obtiene el cliente que corresponde a la cedula digitada
    public Cliente getCliente(String s) {
        Cliente c = new Cliente();
        ClienteDAO aO = new ClienteDAO();
        c = aO.leer(s);
        return c;
    }
}
