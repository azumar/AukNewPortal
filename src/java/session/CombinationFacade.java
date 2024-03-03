

package session;

import entity.Combination;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CombinationFacade extends AbstractFacade<Combination> {
    @PersistenceContext(unitName = "AukNewPortalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CombinationFacade() {
        super(Combination.class);
    }
     public Combination findProgramByName(String subjects) {
               Query query = em.createNamedQuery("Combination.findBySubjects");
        query.setParameter("subjects", subjects);
        return (Combination) query.getSingleResult();
    }
}
