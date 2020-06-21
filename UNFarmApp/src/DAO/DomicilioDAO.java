package DAO;

import Entidad.Domicilio;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DomicilioDAO {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("UNFarmAppPU");

    public boolean crear(Domicilio object) {
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
    
    public boolean verificarExistencia(Domicilio object){
        EntityManager em = emf.createEntityManager();
        Domicilio verif = null;
        Query q = em.createQuery("SELECT d FROM Domicilio d WHERE d.iddomicilio=:iddomicilio")
                .setParameter("iddomicilio", object.getIddomicilio());
        try{
            verif = (Domicilio) q.getSingleResult();
        } catch (NonUniqueResultException e){
            verif = (Domicilio) q.getResultList().get(0);
        } catch (Exception e){
            
        } finally {
            em.close();
        }
        if(verif == null){
            return false;
        }
        return true;
    }
            
    public boolean editarestado(Domicilio Domicilio, short estado) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            Domicilio.setEstado(estado);
            em.merge(Domicilio);
            em.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            return ret;
        }
    }

    public List<Domicilio> leer(Domicilio Domicilio) {
        EntityManager em = emf.createEntityManager();
        List<Domicilio> Domicilios = null;
        Query q = em.createQuery("SELECT d FROM Domicilio d WHERE"
                + " d.iddomicilio LIKE CONCAT('%',:iddomicilio,'%') AND"
                + " d.idfactura LIKE CONCAT('%',:idfactura,'%') AND"
                + " d.apellido LIKE CONCAT('%',:apellido,'%')")
                .setParameter("iddomicilio", Domicilio.getIddomicilio())
                .setParameter("idfactura", Domicilio.getIdfactura())
                .setParameter("estado", Domicilio.getEstado());



        try {
            Domicilios = q.getResultList();
        } catch (NonUniqueResultException e) {
            Domicilios = q.getResultList();
        } catch (Exception e) {

        } finally {
            em.close();
            return Domicilios;
        }
    }

    public Domicilio leer(String iddomicilio) {
        EntityManager em = emf.createEntityManager();
        Domicilio domicilio = null;
        Query q = em.createQuery("SELECT d FROM Domicilio d "
                + "WHERE d.iddomicilio = :iddomicilio")
                .setParameter("iddomicilio", Integer.parseInt(iddomicilio));
        try {
            domicilio = (Domicilio) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            domicilio = (Domicilio) q.getResultList().get(0);
        } catch (Exception e) {
        } finally {
            em.close();
            return domicilio;
        }
    }

    public List<Domicilio> todoEstados(short estadoDomicilio) {
        EntityManager em = emf.createEntityManager();
        List<Domicilio> Domicilios = null;
        Query q = em.createQuery("SELECT d FROM Domicilio d WHERE d.estado = estadoDomicilio")
              .setParameter("estadoDomicilio", estadoDomicilio);

        Domicilios = q.getResultList();
        return Domicilios;
    }

    public List<Domicilio> todos() {
        EntityManager em = emf.createEntityManager();
        List<Domicilio> Domicilios = null;
        Query q = em.createQuery("SELECT d FROM Domicilio d");
        Domicilios = q.getResultList();
        return Domicilios;
    }

    public boolean actualizar(String id, Domicilio nuevoObjeto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        Domicilio antiguo;
        try {
            antiguo = leer(id);
            if (antiguo == null) {
                return false;
            }
            antiguo.setIddomicilio(nuevoObjeto.getIddomicilio());
            antiguo.setIdfactura(nuevoObjeto.getIdfactura());
            antiguo.setEstado(nuevoObjeto.getEstado());
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
