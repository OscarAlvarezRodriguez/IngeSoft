package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import Entidad.Medicamento;
import Entidad.MedicamentoInvima;
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

    public List<MedicamentoInvima> leertodo() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT m FROM MedicamentoInvima m");
        List<MedicamentoInvima> resultados = null;
        try {
            resultados = q.getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
            return resultados;
        }
    }

    public List<MedicamentoInvima> leertodo(MedicamentoInvima mi) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT m FROM MedicamentoInvima m "
                + "WHERE"
                + " m.nombreMedicamento LIKE CONCAT(:nombreMedicamento,'%') AND "
                + " m.titular LIKE CONCAT(:titular,'%') AND "
                + " m.Descripcion LIKE CONCAT(:descripcion,'%') AND "
                + " m.presentacion LIKE CONCAT(:presentacion,'%') AND "
                + " m.principioActivo LIKE CONCAT(:principioActivo,'%')")
                .setParameter("nombreMedicamento", mi.getNombreMedicamento())
                .setParameter("titular", mi.getTitular())
                .setParameter("descripcion", mi.getDescripcion())
                .setParameter("presentacion", mi.getPresentacion())
                .setParameter("principioActivo", mi.getPrincipioActivo());
        List<MedicamentoInvima> resultados = null;
        try {
            resultados = (List<MedicamentoInvima>) q.getResultList();
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
                .setParameter("idMedicamento", par.getIdMedicamento());
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
            med.setStockMedicamento(nuevomed.getStockMedicamento());
            med.setPrecioVentaMedicamento(nuevomed.getPrecioVentaMedicamento());
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

    public static class CombinacionMed extends MedicamentoInvima {

        private Short stock;
        private int precioVenta;

        public CombinacionMed(String nombreMedicamento, String titular, String Descripcion, String presentacion, String principioActivo, Short stock, int precioVenta) {
            super(nombreMedicamento, titular, Descripcion, presentacion, principioActivo);
            this.stock = stock;
            this.precioVenta = precioVenta;
        }

        public CombinacionMed() {
        }

        public Short getStock() {
            return stock;
        }

        public void setStock(Short stock) {
            this.stock = stock;
        }

        public int getPrecioVenta() {
            return precioVenta;
        }

        public void setPrecioVenta(int precioVenta) {
            this.precioVenta = precioVenta;
        }

        public ArrayList<CombinacionMed> selectAll(CombinacionMed c) {
            EntityManager em = emf.createEntityManager();
             List<Object[]> result = null;
            ArrayList<CombinacionMed> out = new ArrayList<>();
            Query q = em.createQuery("SELECT Mi.nombreMedicamento, Mi.titular, Mi.Descripcion, Mi.principioActivo, Mi.presentacion, M.stock, M.precioVenta"
                    + " FROM MedicamentoInvima Mi, Medicamento M"
                    + " WHERE M.idMedicamento = Mi.idMedicamentoInvima AND "
                    + " Mi.nombreMedicamento LIKE CONCAT('%',:nombreMedicamento,'%') AND"
                    + " Mi.titular LIKE CONCAT('%',:titular,'%') AND"
                    + " Mi.Descripcion LIKE CONCAT('%',:Descripcion,'%') AND"
                    + " Mi.principioActivo LIKE CONCAT('%',:principioActivo,'%') AND"
                    + " Mi.presentacion LIKE CONCAT('%',:presentacion,'%')")
                    .setParameter("nombreMedicamento", c.getNombreMedicamento())
                    .setParameter("titular", c.getTitular())
                    .setParameter("Descripcion", c.getDescripcion())
                    .setParameter("principioActivo", c.getPrincipioActivo())
                    .setParameter("presentacion", c.getPresentacion());
           
            try {
                result = q.getResultList();
            } catch (Exception e) {
            } finally {
                em.close();
            }
            for (Object[] o : result) {
                CombinacionMed concat = new CombinacionMed(
                        (String) o[0],
                        (String) o[1],
                        (String) o[2],
                        (String) o[3],
                        (String) o[4],
                        (Short) o[5],
                        (Integer) o[6]);
                out.add(concat);
            }
             return out;
        }

        public ArrayList<CombinacionMed> selectAll() {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("UNFarmAppPU");
            EntityManager em = emf.createEntityManager();
            List<Object[]> result = null;
            ArrayList<CombinacionMed> out = new ArrayList<>();
            Query q = em.createQuery("SELECT Mi.nombreMedicamento, Mi.titular, Mi.Descripcion, Mi.principioActivo, Mi.presentacion, M.stock, M.precioVenta"
                    + " FROM MedicamentoInvima Mi, Medicamento M"
                    + " WHERE M.idMedicamento = Mi.idMedicamentoInvima");
            try {
                result = q.getResultList();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                em.close();

            }
            for (Object[] o : result) {
                CombinacionMed concat = new CombinacionMed(
                        (String) o[0],
                        (String) o[1],
                        (String) o[2],
                        (String) o[3],
                        (String) o[4],
                        (Short) o[5],
                        (Integer) o[6]);
                out.add(concat);
            }
            return out;
        }
    }
}
