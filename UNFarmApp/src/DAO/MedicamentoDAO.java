package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import Entidad.Medicamento;
import Entidad.Medicamentoinvima;
import java.util.ArrayList;
import java.util.List;

public class MedicamentoDAO {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("UNFarmAppPU");

    public void crear(Medicamento object) {
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

    public boolean eliminar(Medicamento med) {
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
        Query q = em.createQuery("SELECT m FROM Medicamento m");
        List<Medicamento> resultados = null;
        try {
            resultados = q.getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
            return resultados;
        }
    }

    public List<Medicamento> leertodo(Medicamento m) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT m FROM Medicamento m "
                + "WHERE"
                + " m.idmedicamentoinvima.nombremedicamento LIKE CONCAT('%',:nombreMedicamento,'%')"
                + " AND  m.idmedicamentoinvima.titular LIKE CONCAT('%',:titular,'%')"
                + " AND  m.idmedicamentoinvima.descripcion LIKE CONCAT('%',:descripcion,'%')"
                + " AND m.idmedicamentoinvima.presentacion LIKE CONCAT('%',:presentacion,'%')"
                + " AND m.idmedicamentoinvima.principioactivo LIKE CONCAT('%',:principioActivo,'%')")
                .setParameter("nombreMedicamento", m.getIdmedicamentoinvima().getNombremedicamento())
                .setParameter("titular", m.getIdmedicamentoinvima().getTitular())
                .setParameter("descripcion", m.getIdmedicamentoinvima().getDescripcion())
                .setParameter("presentacion", m.getIdmedicamentoinvima().getPresentacion())
                .setParameter("principioActivo", m.getIdmedicamentoinvima().getPrincipioactivo());
        List<Medicamento> resultados = null;
        try {
            resultados = (List<Medicamento>) q.getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
            return resultados;
        }
    }

    public Medicamento leer(Medicamento par) {
        EntityManager em = emf.createEntityManager();
        Medicamento consulta = null;
        Query q = em.createQuery("SELECT m"
                + " FROM Medicamento e "
                + "WHERE m.idMedicamento = :idMedicamento"
        )
                .setParameter("idMedicamento", par.getIdmedicamento());
        try {
            consulta = (Medicamento) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            consulta = (Medicamento) q.getResultList().get(0);
        } catch (Exception e) {

        } finally {
            em.close();
            return consulta;
        }
    }

    public Medicamento leer(int idLibro) {
        EntityManager em = emf.createEntityManager();
        Medicamento consulta = null;
        Query q = em.createQuery("SELECT m"
                + " FROM Medicamento e "
                + "WHERE m.idMedicamento = :idMedicamento")
                .setParameter("idMedicamento", idLibro);
        try {
            consulta = (Medicamento) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            consulta = (Medicamento) q.getResultList().get(0);
        } catch (Exception e) {

        } finally {
            em.close();
            return consulta;
        }
    }

    public boolean actualizar(Medicamento med, Medicamento nuevomed) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            med = leer(med);
            med.setStock(nuevomed.getStock());
            med.setPrecioventa(nuevomed.getPrecioventa());
            em.merge(med);
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
