package co.com.smilepersistence.session;

import co.com.smilepersistence.entity.TipoTelefono;
import co.com.smilepersistence.interfacelocal.TipoTelefonoFacadeLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FABIO
 */
@Stateless
public class TipoTelefonoFacade extends AbstractFacade<TipoTelefono> implements TipoTelefonoFacadeLocal {

    @PersistenceContext(unitName = "SmilePersistence_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoTelefonoFacade() {
        super(TipoTelefono.class);
    }
    
}