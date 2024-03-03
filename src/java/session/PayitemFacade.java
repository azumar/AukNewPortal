/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Payitem;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Armayau
 */
@Stateless
public class PayitemFacade extends AbstractFacade<Payitem> {
    @PersistenceContext(unitName = "AukNewPortalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PayitemFacade() {
        super(Payitem.class);
    }
    public Payitem findServiceName(String itemname){
        Query query = em.createNamedQuery("Payitem.findByItemname");
        query.setParameter("itemname", itemname);
        return (Payitem)query.getSingleResult();
    }
}
