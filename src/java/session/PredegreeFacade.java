/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Predegree;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Armayau
 */
@Stateless
public class PredegreeFacade extends AbstractFacade<Predegree> {
    @PersistenceContext(unitName = "AukNewPortalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
     public Predegree findPredegreeByGsm(String gsm){
        Query query = em.createNamedQuery("Predegree.findByGsm");
        query.setParameter("gsm", gsm);
        return (Predegree)query.getSingleResult();
    }

    public PredegreeFacade() {
        super(Predegree.class);
    }
    
}
