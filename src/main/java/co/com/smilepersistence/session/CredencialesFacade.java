package co.com.smilepersistence.session;

import co.com.smilepersistence.entity.Credenciales;
import co.com.smilepersistence.interfacelocal.CredencialesFacadeLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FABIO
 */
@Stateless
public class CredencialesFacade extends AbstractFacade<Credenciales> implements CredencialesFacadeLocal {

    @PersistenceContext(unitName = "SmilePersistence_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CredencialesFacade() {
        super(Credenciales.class);
    }
    
}