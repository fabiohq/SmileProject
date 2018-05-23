package co.com.smilepersistence.session;

import co.com.smilepersistence.entity.TipoEmail;
import co.com.smilepersistence.interfacelocal.TipoEmailFacadeLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FABIO
 */
@Stateless
public class TipoEmailFacade extends AbstractFacade<TipoEmail> implements TipoEmailFacadeLocal {

    @PersistenceContext(unitName = "SmilePersistence_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoEmailFacade() {
        super(TipoEmail.class);
    }
    
}