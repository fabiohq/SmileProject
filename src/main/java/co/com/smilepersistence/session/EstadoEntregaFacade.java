package co.com.smilepersistence.session;

import co.com.smilepersistence.entity.EstadoEntrega;
import co.com.smilepersistence.interfacelocal.EstadoEntregaFacadeLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FABIO
 */
@Stateless
public class EstadoEntregaFacade extends AbstractFacade<EstadoEntrega> implements EstadoEntregaFacadeLocal {

    @PersistenceContext(unitName = "SmilePersistence_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoEntregaFacade() {
        super(EstadoEntrega.class);
    }
    
}