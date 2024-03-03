/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Groups;
import entity.Users;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Armayau
 */
@Stateless
public class GroupsFacade extends AbstractFacade<Groups> {
    @PersistenceContext(unitName = "AukNewPortalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GroupsFacade() {
        super(Groups.class);
    }
    public Groups findGroupByUserName(String  username)
    {
        Query query = em.createNamedQuery("Groups.findByUsername");
            query.setParameter("username", username);
        return (Groups) query.getSingleResult();
    }
    
}
