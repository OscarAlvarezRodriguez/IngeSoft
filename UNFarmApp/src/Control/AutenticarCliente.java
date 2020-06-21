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
        if (!validarCedula(cli).equals(co)) {
            return (cn);
        }
        if (!validarClienteReg(cli).equals(co)) {
            return (cr);
        }
        if (!validarClienteActivo(cli).equals(co)) {
            return (ci);
        }
        if (cliente.leer(cli) != null) {
            return (bi);
        }
        return (cnr);
    }

    public String validarCedula(String cedula) {
        if (cedula.length() > 6 && cedula.length() < 12 && cedula.matches("\\d*") && !cedula.isEmpty()) {
            return (co);
        }
        return (cn);
    }

    public String validarClienteReg(String cedula) {
        if (getCliente(cedula) == null) {
            return (co);
        }
        return (cr);
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

    public Cliente getCliente(String s) {
        Cliente c = new Cliente();
        ClienteDAO aO = new ClienteDAO();
        c = aO.leer(s);
        return c;
    }
}
