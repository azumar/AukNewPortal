/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Combination;
import entity.Ijmb;
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
public class IjmbFacade extends AbstractFacade<Ijmb> {
    @PersistenceContext(unitName = "AukNewPortalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IjmbFacade() {
        super(Ijmb.class);
    }
     public int countByName(Combination combination) {
        Query query = em.createQuery("SELECT i FROM Ijmb i WHERE i.combinationId = :combination");
        query.setParameter("combination", combination);
        Collection<Combination> applicants = query.getResultList();
        return applicants.size();
    }
  public Ijmb finfByRefNum(String ref) {
        Query query = em.createNamedQuery("Ijmb.findByAppref");
        query.setParameter("appref", ref);
       
        return  (Ijmb)query.getSingleResult();
    }
}
