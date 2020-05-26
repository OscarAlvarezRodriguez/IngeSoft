package DAO;

import Entidad.Empleado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EmpleadoDAO {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("UNFarmAppPU");

    public void crear(Empleado object) {

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

    //Esta funcion no borra, por favor corregir (lo necesitamos para las pruebas, no sean malitos 
    public boolean eliminar(Empleado object) {
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

    public Empleado leer(Empleado par) {
        EntityManager em = emf.createEntityManager();
        Empleado usuario = null;
        Query q = em.createQuery("SELECT e"
                + " FROM Empleado e "
                + "WHERE e.cedula_Empleado = :cedula_Empleado"
                + " AND e.contrasenia = :contrasenia")
                .setParameter("contrasenia", par.getContraseniaEmpleado())
                .setParameter("cedula_Empleado", par.getCedulaEmpleado());
        try {
            usuario = (Empleado) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            usuario = (Empleado) q.getResultList().get(0);
        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            em.close();
            return usuario;
        }
    }
    
    public Empleado leerex(Empleado par){
        EntityManager em = emf.createEntityManager();
        Empleado usuario = null;
        Query q = em.createQuery("SELECT e"
                + " FROM Empleado e "
                + "WHERE e.cedula_Empleado = :cedula_Empleado")
                .setParameter("cedula_Empleado", par.getCedulaEmpleado());
        try {
            usuario = (Empleado) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            usuario = (Empleado) q.getResultList().get(0);
        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            em.close();
            return usuario;
        }
    }

    public boolean actualizar(Empleado object, Empleado nuevoObjeto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            object = leer(object);
            object.setCedulaEmpleado(nuevoObjeto.getCedulaEmpleado());
            object.setApellidoEmpleado(nuevoObjeto.getApellidoEmpleado());
            object.setContraseniaEmpleado(nuevoObjeto.getContraseniaEmpleado());
            object.setCorreoEmpleado(nuevoObjeto.getCorreoEmpleado());
            object.setNombreEmpleado(nuevoObjeto.getNombreEmpleado());
            object.setTelefonoEmpleado(nuevoObjeto.getTelefonoEmpleado());
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
