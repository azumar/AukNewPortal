

package session;

import entity.Predegree;
import entity.Program;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class ProgramFacade extends AbstractFacade<Program> {
    @PersistenceContext(unitName = "AukNewPortalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProgramFacade() {
        super(Program.class);
    }
    public Program findProgramByName(String programName){
        Query query = em.createNamedQuery("Program.findByProgramName");
        query.setParameter("programName", programName);
        return (Program)query.getSingleResult();
    }
    //findpreDegree()
    public List<Predegree> findpreDegree(){
        Query query = em.createQuery("SELECT p FROM Program p WHERE p.level = :level");
        query.setParameter("level", 0);
        return query.getResultList();
    }
}
