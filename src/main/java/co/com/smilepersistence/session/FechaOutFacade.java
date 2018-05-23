package co.com.smilepersistence.session;

import co.com.smilepersistence.entity.FechaOut;
import co.com.smilepersistence.interfacelocal.FechaOutFacadeLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FABIO
 */
@Stateless
public class FechaOutFacade extends AbstractFacade<FechaOut> implements FechaOutFacadeLocal {

    @PersistenceContext(unitName = "SmilePersistence_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FechaOutFacade() {
        super(FechaOut.class);
    }
    
}