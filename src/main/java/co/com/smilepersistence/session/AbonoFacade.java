package co.com.smilepersistence.session;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.smilepersistence.entity.Abono;
import co.com.smilepersistence.interfacelocal.AbonoFacadeLocal;

/**
 *
 * @author FABIO
 */
@Stateless
public class AbonoFacade extends AbstractFacade<Abono> implements AbonoFacadeLocal {

    @PersistenceContext(unitName = "SmilePersistence_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AbonoFacade() {
        super(Abono.class);
    }
    
}