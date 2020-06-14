package DAO;

import Entidad.Empleado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EmpleadoDAO {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("UNFarmAppPU");

    public boolean crear(Empleado object) { //para gestionar mejor el control de errores es bueno que esta función sea booleana, retorna true si el registro fue exitoso y si por algún motivo falla, devuelve false

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

    public boolean editarestado(Empleado empleado, String estado) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            if (estado.equals("SUSPENDIDO")) {
                empleado.setEstado(estado);
            } else if (estado.equals("INACTIVO")) {
                empleado.setEstado(estado);
            } else if (estado.equals("ACTIVO")) {
                empleado.setEstado(estado);
            } else {
                return ret;
            }
            em.merge(empleado);
            em.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
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
                + "WHERE e.cedulaempleado = :cedulaempleado"
                + " AND e.contrasenia = :contrasenia")
                .setParameter("contrasenia", par.getContrasenia())
                .setParameter("cedulaempleado", par.getCedulaempleado());
        try {
            usuario = (Empleado) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            usuario = (Empleado) q.getResultList().get(0);
        } catch (Exception e) {

        } finally {
            em.close();
            return usuario;
        }
    }

    public Boolean verificarExistencia(Empleado par) {
        EntityManager em = emf.createEntityManager();
        Empleado verif = null;
        Query q = em.createQuery("SELECT e FROM Empleado e WHERE e.cedulaempleado=:cedulaempleado")
                .setParameter("cedulaempleado", par.getCedulaempleado());
        try {
            verif = (Empleado) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            verif = (Empleado) q.getResultList().get(0);
        } catch (Exception e) {

        } finally {
            em.close();
        }
        if (verif == null) {
            return false;
        }
        return true;
    }

    public boolean actualizar(Empleado object, Empleado nuevoObjeto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            object = leer(object);
            object.setCedulaempleado(nuevoObjeto.getCedulaempleado());
            object.setApellidoempleado(nuevoObjeto.getApellidoempleado());
            object.setContrasenia(nuevoObjeto.getContrasenia());
            object.setCorreo(nuevoObjeto.getCorreo());
            object.setNombreempleado(nuevoObjeto.getNombreempleado());
            object.setTelefono(nuevoObjeto.getTelefono());
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

    public Empleado leerAdmin() {
        EntityManager em = emf.createEntityManager();
        Empleado emple = null;
        String admin = "ADMINISTRADOR";
        Query q = em.createQuery("SELECT e FROM Empleado e WHERE e.estado = :estado")
                .setParameter("estado", admin);
        try {
            emple = (Empleado) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            //Esta imprimiendo mas de una cosa 
            emple = (Empleado) q.getResultList().get(0);
        } finally {
            em.close();
            return emple;
        }
    }

}
