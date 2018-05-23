package co.com.smilepersistence.session;

import co.com.smilepersistence.entity.Bodega;
import co.com.smilepersistence.interfacelocal.BodegaFacadeLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FABIO
 */
@Stateless
public class BodegaFacade extends AbstractFacade<Bodega> implements BodegaFacadeLocal {

    @PersistenceContext(unitName = "SmilePersistence_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BodegaFacade() {
        super(Bodega.class);
    }
    
}