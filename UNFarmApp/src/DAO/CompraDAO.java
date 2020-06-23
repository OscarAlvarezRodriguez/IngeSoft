package DAO;

import Entidad.Compra;
import Entidad.Compramedicamento;
import Entidad.Medicamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CompraDAO {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("UNFarmAppPU");

    public int crear(Compra object) {
        int ID = -1;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            Query q = em.createQuery("SELECT MAX(m.idcompra) FROM Compra m");
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

    public void crearCompra(Compramedicamento object) {
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

    public boolean eliminar(Compra med) {
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
        Query q = em.createQuery("SELECT c FROM Compra m");
        List<Medicamento> resultados = null;
        try {
            resultados = q.getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
            return resultados;
        }
    }

    public Compra leer(Compra compra) {
        EntityManager em = emf.createEntityManager();
        Compra consulta = null;
        Query q = em.createQuery("SELECT c FROM Compra c WHERE c.idcompra = :idcompra")
                .setParameter("idcompra", compra.getIdcompra());
        try {
            consulta = (Compra) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            consulta = (Compra) q.getResultList().get(0);
        } catch (Exception e) {

        } finally {
            em.close();

            return consulta;
        }
    }

    public boolean actualizar(Compra compra, Compra nuevaCompra) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            compra = leer(compra);
            em.merge(compra);
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

    public List<Compramedicamento> leercompras() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT c FROM Compramedicamento c");

        List<Compramedicamento> compras = null;

        try {
            compras = (List<Compramedicamento>) q.getResultList();
        } catch (Exception e) {

        } finally {
            em.close();
        }
        return compras;
    }
}
