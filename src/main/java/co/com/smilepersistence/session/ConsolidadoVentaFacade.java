package co.com.smilepersistence.session;

import co.com.smilepersistence.entity.ConsolidadoVenta;
import co.com.smilepersistence.interfacelocal.ConsolidadoVentaFacadeLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FABIO
 */
@Stateless
public class ConsolidadoVentaFacade extends AbstractFacade<ConsolidadoVenta> implements ConsolidadoVentaFacadeLocal {

    @PersistenceContext(unitName = "SmilePersistence_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConsolidadoVentaFacade() {
        super(ConsolidadoVenta.class);
    }
    
}