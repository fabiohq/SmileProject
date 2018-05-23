package co.com.smilepersistence.session;

import co.com.smilepersistence.entity.EstadoVenta;
import co.com.smilepersistence.interfacelocal.EstadoVentaFacadeLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FABIO
 */
@Stateless
public class EstadoVentaFacade extends AbstractFacade<EstadoVenta> implements EstadoVentaFacadeLocal {

    @PersistenceContext(unitName = "SmilePersistence_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoVentaFacade() {
        super(EstadoVenta.class);
    }
    
}