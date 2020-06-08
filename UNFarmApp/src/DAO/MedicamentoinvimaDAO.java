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
        Query q =em.createQuery("SELECT m FROM Medicamentoinvima m, Medicamento mi WHERE m.idmedicamentoinvima != mi.idmedicamentoinvima.idmedicamentoinvima");
        List<Medicamentoinvima> resultados= null;
        try {
            resultados=  q.getResultList();
        } catch (NonUniqueResultException e){
        } catch (Exception e){
        } finally{
            em.close();
            return resultados;
        }
    }
    public Medicamentoinvima leer(Medicamentoinvima par) {
        EntityManager em = emf.createEntityManager();
        Medicamentoinvima consulta = null;
        Query q = em.createQuery("SELECT m"
                + " FROM Medicamentoinvima e "
                + "WHERE m.idMedicamentoinvima = :idMedicamentoinvima"
        )
                .setParameter("idMedicamento", par.getIdmedicamentoinvima());
        try {
            consulta= (Medicamentoinvima) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            consulta = (Medicamentoinvima) q.getResultList().get(0);
        } catch (Exception e) {

        } finally {
            em.close();
            return consulta;
        }
    }
}
