/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Pin;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Armayau
 */
@Stateless
public class PinFacade extends AbstractFacade<Pin> {
    @PersistenceContext(unitName = "AukNewPortalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PinFacade() {
        super(Pin.class);
    }
     public Pin finPinByPinId(int pin)
    {
        Query query = em.createNamedQuery("Pin.findByPinId");
            query.setParameter("pinId", pin);
        return (Pin) query.getSingleResult();
    }
    
    public List< Pin> finPinByCreator(String name)
    {
        Query query = em.createNamedQuery("Pin.findByCreator");
            query.setParameter("creator", name);
        return query.getResultList();
    }
    
}
