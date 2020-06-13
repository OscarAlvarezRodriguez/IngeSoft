package DAO;

import Entidad.Empleado;
import java.sql.PreparedStatement;
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
    
    public Empleado leerAdmin(){
        EntityManager em = emf.createEntityManager();
        Empleado emple = null;  
        String admin = "ADMINISTRADOR";
        Query q = em.createQuery("SELECT e"
                + " FROM Empleado e "
                + "WHERE e.estado = :estado")
                .setParameter("estado",admin); 
        try{   
            emple = (Empleado)q.getSingleResult();
        }catch(NonUniqueResultException e){
            System.out.println("Esta imprimiendo mas de una cosa ");
        }catch (Exception e){
            System.out.println("Esta dando otro tipo de error");
        }finally{
            em.close();
            return emple;
        }
    }

    
}
