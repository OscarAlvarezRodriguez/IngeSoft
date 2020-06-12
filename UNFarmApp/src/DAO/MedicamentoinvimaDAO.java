package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import Entidad.Medicamentoinvima;
import java.util.List;

public class MedicamentoinvimaDAO {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("UNFarmAppPU");

    public List<Medicamentoinvima> leertodo(Medicamentoinvima med) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT m FROM Medicamentoinvima m"
                + " WHERE"
                + " m.descripcion LIKE CONCAT('%',:descripcion,'%')"
                + " AND m.nombremedicamento LIKE CONCAT('%',:nombremedicamento,'%')"
                + " AND m.presentacion LIKE CONCAT('%',:presentacion,'%')"
                + " AND m.principioactivo LIKE CONCAT('%',:principioactivo,'%')"
                + " AND m.titular LIKE CONCAT('%',:titular,'%')")
                .setParameter("descripcion", med.getDescripcion())
                .setParameter("nombremedicamento", med.getNombremedicamento())
                .setParameter("principioactivo", med.getPrincipioactivo())
                .setParameter("titular", med.getTitular())
                .setParameter("presentacion", med.getPresentacion());
        List<Medicamentoinvima> resultados = null;
        try {
            resultados = q.getResultList();
        } catch (NonUniqueResultException e) {
        } catch (Exception e) {
        } finally {
            em.close();
            return resultados;
        }
    }

    public List<Medicamentoinvima> leertodo() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT m FROM Medicamentoinvima m");
        List<Medicamentoinvima> resultados = null;
        try {
            resultados = (List<Medicamentoinvima>) q.getResultList();
        } catch (NonUniqueResultException e) {
        } catch (Exception e) {
        } finally {
            em.close();
            return resultados;
        }
    }

    public Medicamentoinvima leer(short par) {
        EntityManager em = emf.createEntityManager();
        Medicamentoinvima consulta = null;
        Query q = em.createQuery("SELECT m FROM Medicamentoinvima m WHERE m.idmedicamentoinvima = :id")
                .setParameter("id", par);
        try {
            consulta = (Medicamentoinvima) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            consulta = (Medicamentoinvima) q.getResultList().get(0);
        } catch (Exception e) {

        } finally {
            em.close();
            return consulta;
        }
    }
}
