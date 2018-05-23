package co.com.smilepersistence.session;

import co.com.smilepersistence.entity.SaldoAFavor;
import co.com.smilepersistence.interfacelocal.SaldoAFavorFacadeLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FABIO
 */
@Stateless
public class SaldoAFavorFacade extends AbstractFacade<SaldoAFavor> implements SaldoAFavorFacadeLocal {

    @PersistenceContext(unitName = "SmilePersistence_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SaldoAFavorFacade() {
        super(SaldoAFavor.class);
    }
    
}