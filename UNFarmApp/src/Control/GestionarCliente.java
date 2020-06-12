package Control;

import DAO.ClienteDAO;
import Entidad.Cliente;
import java.util.List;

public class GestionarCliente {

    ClienteDAO clienteDAO = new ClienteDAO();

    public List<Cliente> listaDeClientes() {
        List<Cliente> clientes = null;
        clientes = clienteDAO.todos();
        return clientes;
    }

    public List<Cliente> listaDeClientesActivos() {
        List<Cliente> clientes = null;
        clientes = clienteDAO.todoActivos();
        return clientes;
    }

    public List<Cliente> listaDeClientesActivos(Cliente c) {
        List<Cliente> clientes = null;
        clientes = clienteDAO.leer(c);
        return clientes;
    }

}
