package Control;

import Entidad.Cliente;
import DAO.ClienteDAO;

public class AutenticarCliente {
    
    private ClienteDAO cliente = new ClienteDAO();
    private static String cn ="Número cedula no válido";
    private static String co ="Correcto";
    
    public AutenticarCliente(){
    }
    
    public String verificarLogin(Cliente cli){
        if (!validarCedula(cli.getCedulaCliente()).equals(co)){
            return (cn);
        }
        if (cliente.leer(cli) != null) {
            return ("Bienvenido");
        }
        return("Cliente no registrado");
    }
    
    public String validarCedula(String cedula) {
        if (cedula.length() > 7 && cedula.length() < 11 && cedula.matches("\\d*") && !cedula.isEmpty()){
            return(co);
        }
        return (cn);
    }
}
