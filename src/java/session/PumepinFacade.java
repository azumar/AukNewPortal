
package session;

import entity.Pumepin;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Armayau
 */
@Stateless
public class PumepinFacade extends AbstractFacade<Pumepin> {
    @PersistenceContext(unitName = "AukNewPortalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PumepinFacade() {
        super(Pumepin.class);
    }
    
}
