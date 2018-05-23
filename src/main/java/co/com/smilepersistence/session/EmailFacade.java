package co.com.smilepersistence.session;


import co.com.smilepersistence.entity.Email;
import co.com.smilepersistence.interfacelocal.EmailFacadeLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FABIO
 */
@Stateless
public class EmailFacade extends AbstractFacade<Email> implements EmailFacadeLocal {

    @PersistenceContext(unitName = "SmilePersistence_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmailFacade() {
        super(Email.class);
    }
    
}