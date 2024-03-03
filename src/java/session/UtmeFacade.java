
package session;

import entity.Utme;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Armayau
 */
@Stateless
public class UtmeFacade extends AbstractFacade<Utme> {
    @PersistenceContext(unitName = "AukNewPortalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtmeFacade() {
        super(Utme.class);
    }
     public boolean validUtme(String jambNo, HttpServletRequest request) {
        boolean errorFlag = false;

        if (recordExist(jambNo)) {
            errorFlag = true;
        }
        return errorFlag;

    }

    public boolean recordExist(String jambNo) {
      Query query = em.createNamedQuery("Utme.findByJambNo");
        query.setParameter("jambNo", jambNo);
         int i = query.getResultList().size();
         if (i>0){
             return true;
         } else {
             return false;
         }
    }
     public Utme findByJambNo(String jambNo) {
         String jamb = jambNo.trim();
        Query query = em.createNamedQuery("Utme.findByJambNo");
        query.setParameter("jambNo", jamb);
        return (Utme) query.getSingleResult();
    }
       public Utme findBygsmNo(String gsmNo) {
        Query query = em.createNamedQuery("Utme.findByGsm");
        query.setParameter("gsm", gsmNo);
        return (Utme) query.getSingleResult();
    }
       public Utme findBygsmandJambNo(String jambNo, String gsmNo) {
        Query query = em.createQuery("SELECT u FROM Utme u WHERE u.gsm = :gsm  AND u.utmePK.jambNo = :jambNo");
        query.setParameter("gsm", gsmNo);
        query.setParameter("jambNo", jambNo);
        return (Utme) query.getSingleResult();
    }

    public List<Utme> findByProgram(String program) {
        Query query = em.createQuery("SELECT u FROM Utme u WHERE u.program.programName = :program");
        query.setParameter("program", program);
        return query.getResultList();
    }

    public List<Utme> findBySession(String session) {
        //Utme.findBySession
        Query query = em.createNamedQuery("Utme.findBySession");
        query.setParameter("session", session);
        return query.getResultList();
    }

    public List<Utme> findByProgramAndSession(String session, String program) {
        //Utme.findBySession
        Query query = em.createQuery("SELECT u FROM Utme u WHERE u.program.programName = :program AND u.session =:session");
        query.setParameter("session", session);
        query.setParameter("program", program);
        return query.getResultList();
    }

    public List<Utme> findByProgramTypeAndSession(String session, String program, String applicationType) {
        //Utme.findBySession
        Query query = em.createQuery("SELECT u FROM Utme u WHERE u.program.programName = :program AND u.session =:session and u.type.typeName=:applicationType");
        query.setParameter("session", session);
        query.setParameter("program", program);
        query.setParameter("applicationType", applicationType);
        return query.getResultList();
    }

    public List<Utme> findByProgramAndType(String program, String applicationType) {
        //Utme.findBySession
        Query query = em.createQuery("SELECT u FROM Utme u WHERE u.program.programName = :program AND u.type.typeName=:applicationType");

        query.setParameter("program", program);
        query.setParameter("applicationType", applicationType);
        return query.getResultList();
    }

    public List<Utme> findBySessionAndType(String session, String applicationType) {
        //Utme.findBySession
        Query query = em.createQuery("SELECT u FROM Utme u WHERE u.session =:session AND u.type.typeName=:applicationType");

        query.setParameter("session", session);
        query.setParameter("applicationType", applicationType);
        return query.getResultList();
    }
       public List<Utme> findByType(String typeName) {
        //Utme.findType
        Query query = em.createQuery("SELECT u FROM Utme u WHERE u.typeId.typeName = :typeName");
        query.setParameter("typeName", typeName);
        return query.getResultList();
    }
    
}
