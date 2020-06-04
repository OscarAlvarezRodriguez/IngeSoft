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
    
    public void crear(Cliente object){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public boolean eliminar(Cliente object){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            if (!em.contains(object)) {
                object = em.merge(object);
            }
            em.remove(object);
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
    
    public List<Cliente> leerLista(String par){
        EntityManager em = emf.createEntityManager();
        List<Cliente> clientes = null;
        Query q = em.createQuery("SELECT c FROM Cliente c "
                + "WHERE c.cedulaCliente LIKE CONCAT(:parameter,'%')")
                .setParameter("parameter", par);
                
        try {
            clientes =  q.getResultList();
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
                + "WHERE c.cedulaCliente = :parameter")
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
    
    public List<Cliente> todos(){
        EntityManager em = emf.createEntityManager();
        List<Cliente> clientes = null;
        Query q = em.createQuery("SELECT c FROM Cliente c");
        clientes = q.getResultList();
        return clientes;
    }
    
    
    public boolean actualizar(String ced, Cliente nuevoObjeto){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        Cliente antiguo;
        try {
            antiguo = leer(ced);
            antiguo.setCedulaCliente(nuevoObjeto.getCedulaCliente());
            antiguo.setNombreCliente(nuevoObjeto.getNombreCliente());
            antiguo.setTelefonoCliente(nuevoObjeto.getTelefonoCliente());
            antiguo.setDireccionCliente(nuevoObjeto.getDireccionCliente());
            antiguo.setDescripcionDireccionCliente(nuevoObjeto.getDescripcionDireccionCliente());
            antiguo.setApellidoCliente(nuevoObjeto.getApellidoCliente());
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
