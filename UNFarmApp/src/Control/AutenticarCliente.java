package Control;

import DAO.ClienteDAO;
import Entidad.Cliente;

public class AutenticarCliente {

    private final ClienteDAO cliente = new ClienteDAO();
    private final String cn = "Número cédula no válido";
    private final String cr = "Cliente no registrado";
    private final String bi = "Bienvenido";
    private final String co = "Correcto";

    public AutenticarCliente() {
    }

    public String verificarLogin(String cli) {
        if (!validarCedula(cli).equals(co)) {
            return (cn);
        }
        if (cliente.leer(cli) != null) {
            return (bi);
        }
        return (cr);
    }

    public String validarCedula(String cedula) {
        if (cedula.length() > 6 && cedula.length() < 12 && cedula.matches("\\d*") && !cedula.isEmpty()) {
            return (co);
        }
        return (cn);
    }

    public Cliente getCliente(String s) {
        Cliente c = new Cliente();
        ClienteDAO aO = new ClienteDAO();
        c = aO.leer(s);
        return c;
    }
}
