/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Pg;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Armayau
 */
@Stateless
public class PgFacade extends AbstractFacade<Pg> {
    @PersistenceContext(unitName = "AukNewPortalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PgFacade() {
        super(Pg.class);
    }
     public Pg findByrefNo(String ref) {
        Query query = em.createNamedQuery("Pg.findByAppref");
        query.setParameter("appref", ref);
        
         return  (Pg)query.getSingleResult();
    }
     public int countByName(String program) {
        Query query = em.createNamedQuery("Pg.findByProgram");
        query.setParameter("program", program);
        //query.setParameter("ayear", ayear);
       Collection<Pg> pgs =  query.getResultList();
         return pgs .size();
    }
}
