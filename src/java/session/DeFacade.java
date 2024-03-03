/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.De;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Armayau
 */
@Stateless
public class DeFacade extends AbstractFacade<De> {
    @PersistenceContext(unitName = "AukNewPortalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DeFacade() {
        super(De.class);
    }
      public De findByJambNo(String jambNo) {
        Query query = em.createNamedQuery("De.findByJambNo");
        query.setParameter("jambNo", jambNo);
        return (De) query.getSingleResult();
    }
    
}
