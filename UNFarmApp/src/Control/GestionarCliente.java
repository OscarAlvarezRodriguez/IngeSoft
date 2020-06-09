/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.ClienteDAO;
import Entidad.Cliente;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class GestionarCliente {
    
    ClienteDAO clienteDAO = new ClienteDAO();

    public List<Cliente> listaDeClientes(){
        List<Cliente> clientes = null;
        clientes = clienteDAO.todos();
        return clientes;
    }
    
    
    
    
}
