package co.com.smilepersistence.session;


import co.com.smilepersistence.entity.Encargo;
import co.com.smilepersistence.interfacelocal.EncargoFacadeLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FABIO
 */
@Stateless
public class EncargoFacade extends AbstractFacade<Encargo> implements EncargoFacadeLocal {

    @PersistenceContext(unitName = "SmilePersistence_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EncargoFacade() {
        super(Encargo.class);
    }
    
}