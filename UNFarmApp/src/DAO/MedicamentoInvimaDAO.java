package DAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import Entidad.MedicamentoInvima;
import java.util.List;

public class MedicamentoInvimaDAO {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("UNFarmAppPU");
    public List<MedicamentoInvima> leertodo(MedicamentoInvima med) {
        EntityManager em = emf.createEntityManager();
        Query q =em.createQuery("SELECT m FROM MedicamentoInvima m");
        List<MedicamentoInvima> resultados= null;
        try {
            resultados=  q.getResultList();
        } catch (NonUniqueResultException e){
        } catch (Exception e){
        } finally{
            em.close();
            return resultados;
        }
    }
    public MedicamentoInvima leer(MedicamentoInvima par) {
        EntityManager em = emf.createEntityManager();
        MedicamentoInvima consulta = null;
        Query q = em.createQuery("SELECT m"
                + " FROM MedicamentoInvima e "
                + "WHERE m.idMedicamentoInvima = :idMedicamentoInvima"
        )
                .setParameter("idMedicamento", par.getIdMedicamentoInvima());
        try {
            consulta= (MedicamentoInvima) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            consulta = (MedicamentoInvima) q.getResultList().get(0);
        } catch (Exception e) {

        } finally {
            em.close();
            return consulta;
        }
    }
}
