package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import Entidad.Factura;
import Entidad.Facturamedicamentos;

public class FacturaDAO {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("UNFarmAppPU");
    
    public int crear(Factura object) {
        int ID = -1;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            Query q = em.createQuery("SELECT MAX(m.idcompra) FROM Factura m");
            ID = (int) q.getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return ID;
    }
    
    public void crearFactura(Facturamedicamentos object) {
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
    
    public boolean eliminar(Factura med) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            if (!em.contains(med)) {
                med = em.merge(med);
            }
            em.remove(med);
            em.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            return ret;
        }
    }
    
    public List<Factura> leertodo(){
        EntityManager em = emf.createEntityManager();
        List<Factura> consulta = null;
        Query q = em.createQuery("Select f From Factura");
        try{
            consulta= (List<Factura>) q.getResultList();
        } catch(Exception e){
        } finally{
            em.close();
            return consulta;
        }
    }
    
    public Factura leer(Factura fac){
        EntityManager em = emf.createEntityManager();
        Factura consulta = null;
        Query q = em.createQuery("SELECT f FROM Factura f WHERE f.idfactura = :idfactura")
                .setParameter("idfactura", fac.getIdfactura());
        try{
            consulta = (Factura) q.getSingleResult();
        } catch(NonUniqueResultException e){
            consulta = (Factura) q.getResultList().get(0);
        } catch (Exception e){
        } finally{
            em.close();
            return consulta;
        }
    }
    public List<Facturamedicamentos> leerList(Factura fac){
        EntityManager em = emf.createEntityManager();
        List<Facturamedicamentos> consulta = null;
        Query q = em.createQuery("SELECT f FROM Facturamedicamentos WHERE f.idfactura")
                .setParameter("idfactura", fac);
        try{
            consulta = (List<Facturamedicamentos>) q.getSingleResult();
        } catch(NonUniqueResultException e){
            consulta = (List<Facturamedicamentos>) q.getResultList().get(0);
        } catch (Exception e){
        } finally{
            em.close();
            return consulta;
        }
    }
}
