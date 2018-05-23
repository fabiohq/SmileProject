package co.com.smilepersistence.session;

import co.com.smilepersistence.entity.ConsolidadoVtaDia;
import co.com.smilepersistence.interfacelocal.ConsolidadoVtaDiaFacadeLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FABIO
 */
@Stateless
public class ConsolidadoVtaDiaFacade extends AbstractFacade<ConsolidadoVtaDia> implements ConsolidadoVtaDiaFacadeLocal {

    @PersistenceContext(unitName = "SmilePersistence_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConsolidadoVtaDiaFacade() {
        super(ConsolidadoVtaDia.class);
    }
    
}