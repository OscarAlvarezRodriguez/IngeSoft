package Control;

import Entidad.Cliente;
import DAO.ClienteDAO;

public class AutenticarCliente {

    private final ClienteDAO cliente = new ClienteDAO();
    private final String cn = "Número cedula no válido";
    private final String cr = "Cliente no registrado";
    private final String bi = "Bienvenido";
    private final String co = "Correcto";

    public AutenticarCliente() {
    }

    public String verificarLogin(Cliente cli) {
        if (!validarCedula(cli.getCedulaCliente()).equals(co)) {
            return (cn);
        }
        if (cliente.leer(cli.getCedulaCliente()) != null) {
            return (bi);
        }
        return (cr);
    }

    public String validarCedula(String cedula) {
        if (cedula.length() > 7 && cedula.length() < 11 && cedula.matches("\\d*") && !cedula.isEmpty()) {
            return (co);
        }
        return (cn);
    }
}
