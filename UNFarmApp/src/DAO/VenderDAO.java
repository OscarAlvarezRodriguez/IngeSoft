package DAO;

import Entidad.Factura;
import Entidad.Facturamedicamentos;
import Entidad.Medicamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VenderDAO {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("UNFarmAppPU");

    public int crear(Factura object) {
        int ID = -1;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            Query q = em.createQuery("SELECT MAX(m.idfactura) FROM Factura m");
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

    public List<Medicamento> leertodo() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT c FROM Factura m");
        List<Medicamento> resultados = null;
        try {
            resultados = q.getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
            return resultados;
        }
    }

    public Factura leer(Factura Factura) {
        EntityManager em = emf.createEntityManager();
        Factura consulta = null;
        Query q = em.createQuery("SELECT c FROM Factura c WHERE c.idfactura = :idFactura")
                .setParameter("idFactura", Factura.getIdfactura());
        try {
            consulta = (Factura) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            consulta = (Factura) q.getResultList().get(0);
        } catch (Exception e) {

        } finally {
            em.close();

            return consulta;
        }
    }

    public boolean actualizar(Factura Factura, Factura nuevaFactura) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            Factura = leer(Factura);
            em.merge(Factura);
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
    
    public List<Facturamedicamentos> leerfacturas(){
        EntityManager em  = emf.createEntityManager();
        Query q = em.createQuery("SELECT * FROM facturamedicamentos, factura, medicamento"+
                "where facturamedicamentos.idmedicamento=medicamento.idmedicamento AND "
                + "facturamedicamentos.idfactura=factura.idmedicamento");
        List<Facturamedicamentos> facturas= null;
        
        try{
            facturas = (List<Facturamedicamentos>) q.getResultList();
        } catch (Exception e){
            
        } finally{
            em.close();
        }
        return facturas;
    }
}
