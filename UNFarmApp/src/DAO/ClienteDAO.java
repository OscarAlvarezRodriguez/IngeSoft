package DAO;

import Entidad.Cliente;

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
    
    public Cliente leer (Cliente par){
        EntityManager em = emf.createEntityManager();
        Cliente usuario = null;
        Query q = em.createQuery("SELECT c FROM Cliente c "
                + "WHERE c.cedulaCliente = :cedulaCliente")
                .setParameter("cedulaCliente", par.getCedulaCliente());
        try {
            usuario = (Cliente) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            usuario = (Cliente) q.getResultList().get(0);
        } catch (Exception e) {
            
        } finally {
            em.close();
            return usuario;
        }
    }
    
    public boolean actualizar(Cliente object, Cliente nuevoObjeto){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            object = leer(object);
            object.setCedulaCliente(nuevoObjeto.getCedulaCliente());
            object.setNombreCliente(nuevoObjeto.getNombreCliente());
            object.setTelefonoCliente(nuevoObjeto.getTelefonoCliente());
            object.setDireccionCliente(nuevoObjeto.getDireccionCliente());
            object.setDescripcionDireccionCliente(nuevoObjeto.getDescripcionDireccionCliente());
            object.setApellidoCliente(nuevoObjeto.getApellidoCliente());
            em.merge(object);
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
