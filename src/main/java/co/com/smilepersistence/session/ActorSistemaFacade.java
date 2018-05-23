package co.com.smilepersistence.session;


import co.com.smilepersistence.entity.ActorSistema;
import co.com.smilepersistence.interfacelocal.ActorSistemaFacadeLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FABIO
 */
@Stateless
public class ActorSistemaFacade extends AbstractFacade<ActorSistema> implements ActorSistemaFacadeLocal {

    @PersistenceContext(unitName = "SmilePersistence_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActorSistemaFacade() {
        super(ActorSistema.class);
    }
    
}
