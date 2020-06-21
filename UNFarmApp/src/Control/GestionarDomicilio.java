package Control;

import DAO.DomicilioDAO;
import Entidad.Cliente;
import Entidad.Domicilio;
import Entidad.Factura;
import java.util.List;

public class GestionarDomicilio {

    DomicilioDAO DomicilioDAO = new DomicilioDAO();
    
    
    
    public List<Domicilio> listaDeDomicilios() {
        List<Domicilio> Domicilios = null;
        Domicilios = DomicilioDAO.todos();
        return Domicilios;
    }

    public List<Domicilio> listaDeDomiciliosSegunEstado(short estado) {
        List<Domicilio> Domicilios = null;
        Domicilios = DomicilioDAO.todoEstados(estado); //Estado 1 se define como 1, 2 pendientes y 3 Finalizado
        return Domicilios;
    }

    public short actualizarEstado(Domicilio d) {
        short estado;
        estado = d.getEstado();
        if(estado<2 && estado >= 0){
            DomicilioDAO.editarestado(d, (short)(d.getEstado()+1)); 
            return (short)(d.getEstado()+1);
        }
        
        return estado;
    }
    
    public Cliente Cliente_Domicilio(Domicilio d){
        Factura factura = new Factura();
        factura = d.getIdfactura();
        
        return factura.getCedulacliente();
    }

    public List<Domicilio> listaDeDomiciliosActivos(Domicilio d) {
        List<Domicilio> Domicilios = null;
        Domicilios = DomicilioDAO.leer(d);
        return Domicilios;
    }
    
    public Domicilio getDomicilio(String id) {
        return DomicilioDAO.leer(id);
    }

    public List <Domicilio> getDomicilio(Domicilio d) {
        return DomicilioDAO.leer(d);
    }
}
