package Control;

import DAO.DomicilioDAO;
import Entidad.Domicilio;
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

    public short actualizarEstado(Domicilio d, short estado) {
        short estadoActualizado = 0;
        switch (estado) {
            case 1:
                estadoActualizado = 2;
                DomicilioDAO.editarestado(d, estadoActualizado);
                break;
            case 2:
                estadoActualizado = 3;
                DomicilioDAO.editarestado(d, estadoActualizado);
                break;
            case 3:
                //Estado ya finalizado.
                break;
        }
        return estadoActualizado;
    }

    public List<Domicilio> listaDeDomiciliosActivos(Domicilio d) {
        List<Domicilio> Domicilios = null;
        Domicilios = DomicilioDAO.leer(d);
        return Domicilios;
    }

}
