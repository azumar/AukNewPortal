/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Olevelsubject;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Armayau
 */
@Stateless
public class OlevelsubjectFacade extends AbstractFacade<Olevelsubject> {
    @PersistenceContext(unitName = "AukNewPortalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OlevelsubjectFacade() {
        super(Olevelsubject.class);
    }
    
}
