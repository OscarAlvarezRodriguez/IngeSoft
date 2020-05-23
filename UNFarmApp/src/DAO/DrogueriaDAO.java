package DAO;

import Entidad.Drogueria;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DrogueriaDAO {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("UNFarmAppPU");

    public void crear(Drogueria object) {

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

    public boolean eliminar(Drogueria object) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
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

    public Drogueria leer(Drogueria object) {
        EntityManager em = emf.createEntityManager();
        Drogueria drogueria = null;
        Query q = em.createQuery("SELECT d FROM Drogueria d "
                + "WHERE d.nitDrogueria = :nitDrogueria") 
                .setParameter("nitDrogueria", object.getNitDrogueria())
                .setParameter("nombreDrogueria", object.getNombreDrogueria())
                .setParameter("direccionDrogueria", object.getDireccionDrogueria())
                .setParameter("telefonoDrogueria", object.getTelefonoDrogueria())
                .setParameter("emailDrogueria", object.getEmailDrogueria())
                .setParameter("representanteLegalDrogueria", object.getRepresentanteLegalDrogueria());
        try {
            drogueria = (Drogueria) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            drogueria = (Drogueria) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return drogueria;
        }
    }

    public boolean actualizar(Drogueria object, Drogueria nuevoObjeto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            object = leer(object);
            object.setNitDrogueria(nuevoObjeto.getNitDrogueria());
            object.setNombreDrogueria(nuevoObjeto.getNombreDrogueria());
            object.setDireccionDrogueria(nuevoObjeto.getDireccionDrogueria());
            object.setTelefonoDrogueria(nuevoObjeto.getTelefonoDrogueria());
            object.setEmailDrogueria(nuevoObjeto.getEmailDrogueria());
            object.setRepresentanteLegalDrogueria(nuevoObjeto.getRepresentanteLegalDrogueria());
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
