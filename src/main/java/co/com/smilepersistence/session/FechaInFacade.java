package co.com.smilepersistence.session;


import co.com.smilepersistence.entity.FechaIn;
import co.com.smilepersistence.interfacelocal.FechaInFacadeLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FABIO
 */
@Stateless
public class FechaInFacade extends AbstractFacade<FechaIn> implements FechaInFacadeLocal {

    @PersistenceContext(unitName = "SmilePersistence_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FechaInFacade() {
        super(FechaIn.class);
    }
    
}
