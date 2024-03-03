/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Users;
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
public class UsersFacade extends AbstractFacade<Users> {
    @PersistenceContext(unitName = "AukNewPortalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    public Users findUserByUserName(String  username)
    {
        Query query = em.createNamedQuery("Users.findByUsername");
            query.setParameter("username", username);
        return (Users) query.getSingleResult();
    }
    
    public List<Users> findUsersByType (String userType){
        
     Query query = em.createNamedQuery("Users.findByUsertype");
            query.setParameter("usertype", userType);
            return query.getResultList();
    }
    
}
