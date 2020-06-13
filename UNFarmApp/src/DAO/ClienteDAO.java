package DAO;

import Entidad.Cliente;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ClienteDAO {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("UNFarmAppPU");

    public boolean crear(Cliente object) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean valid = true;
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            valid = false;
        } finally {
            em.close();
        }
        return valid;
    }
    
    public boolean verificarExistencia(Cliente object){
        EntityManager em = emf.createEntityManager();
        Cliente verif = null;
        Query q = em.createQuery("SELECT c FROM Cliente c WHERE c.cedulacliente=:cedulacliente")
                .setParameter("cedulacliente", object.getCedulacliente());
        try{
            verif = (Cliente) q.getSingleResult();
        } catch (NonUniqueResultException e){
            verif = (Cliente) q.getResultList().get(0);
        } catch (Exception e){
            
        } finally {
            em.close();
        }
        if(verif == null){
            return false;
        }
        return true;
    }
            
    public boolean editarestado(Cliente cliente, Boolean estado) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            cliente.setEliminado(estado);
            em.merge(cliente);
            em.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            return ret;
        }
    }

    public List<Cliente> leer(Cliente cliente) {
        EntityManager em = emf.createEntityManager();
        List<Cliente> clientes = null;
        Query q = em.createQuery("SELECT c FROM Cliente c WHERE"
                + " c.cedulacliente LIKE CONCAT('%',:cedulacliente,'%') AND"
                + " c.nombre LIKE CONCAT('%',:nombre,'%') AND"
                + " c.apellido LIKE CONCAT('%',:apellido,'%') AND"
                + " c.telefono LIKE CONCAT('%',:telefono,'%') AND"
                + " c.direccioncliente LIKE CONCAT('%',:direccioncliente,'%') AND"
                + " c.descripciondireccion LIKE CONCAT('%',:descripciondireccion,'%') AND"
                + " c.eliminado = :eliminado")
                .setParameter("cedulacliente", cliente.getCedulacliente())
                .setParameter("nombre", cliente.getNombre())
                .setParameter("apellido", cliente.getApellido())
                .setParameter("telefono", cliente.getTelefono())
                .setParameter("direccioncliente", cliente.getDireccioncliente())
                .setParameter("descripciondireccion", cliente.getDescripciondireccion())
                .setParameter("eliminado", cliente.getEliminado());

        try {
            clientes = q.getResultList();
        } catch (NonUniqueResultException e) {
            clientes = q.getResultList();
        } catch (Exception e) {

        } finally {
            em.close();
            return clientes;
        }
    }

    public Cliente leer(String par) {
        EntityManager em = emf.createEntityManager();
        Cliente cliente = null;
        Query q = em.createQuery("SELECT c FROM Cliente c "
                + "WHERE c.cedulacliente = :parameter")
                .setParameter("parameter", par);
        try {
            cliente = (Cliente) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            cliente = (Cliente) q.getResultList().get(0);
        } catch (Exception e) {
        } finally {
            em.close();
            return cliente;
        }
    }

    public List<Cliente> todoActivos() {
        EntityManager em = emf.createEntityManager();
        List<Cliente> clientes = null;
        Query q = em.createQuery("SELECT c FROM Cliente c WHERE c.eliminado = FALSE");
        clientes = q.getResultList();
        return clientes;
    }

    public List<Cliente> todos() {
        EntityManager em = emf.createEntityManager();
        List<Cliente> clientes = null;
        Query q = em.createQuery("SELECT c FROM Cliente c");
        clientes = q.getResultList();
        return clientes;
    }

    public boolean actualizar(String ced, Cliente nuevoObjeto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        Cliente antiguo;
        try {
            antiguo = leer(ced);
            if (antiguo == null) {
                return false;
            }
            antiguo.setNombre(nuevoObjeto.getNombre());
            antiguo.setTelefono(nuevoObjeto.getTelefono());
            antiguo.setDireccioncliente(nuevoObjeto.getDireccioncliente());
            antiguo.setDescripciondireccion(nuevoObjeto.getDescripciondireccion());
            antiguo.setApellido(nuevoObjeto.getApellido());
            antiguo.setEliminado(nuevoObjeto.getEliminado());
            em.merge(antiguo);
            em.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            return ret;
        }
    }
}
