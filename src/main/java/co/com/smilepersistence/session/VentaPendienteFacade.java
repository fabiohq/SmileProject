package co.com.smilepersistence.session;

import co.com.smilepersistence.entity.VentaPendiente;
import co.com.smilepersistence.interfacelocal.VentaPendienteFacadeLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FABIO
 */
@Stateless
public class VentaPendienteFacade extends AbstractFacade<VentaPendiente> implements VentaPendienteFacadeLocal {

    @PersistenceContext(unitName = "SmilePersistence_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentaPendienteFacade() {
        super(VentaPendiente.class);
    }
    
}