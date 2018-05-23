package co.com.smilepersistence.session;


import co.com.smilepersistence.entity.CampaniasPromocionales;
import co.com.smilepersistence.interfacelocal.CampaniasPromocionalesFacadeLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FABIO
 */
@Stateless
public class CampaniasPromocionalesFacade extends AbstractFacade<CampaniasPromocionales> implements CampaniasPromocionalesFacadeLocal {

    @PersistenceContext(unitName = "SmilePersistence_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CampaniasPromocionalesFacade() {
        super(CampaniasPromocionales.class);
    }
    
}
