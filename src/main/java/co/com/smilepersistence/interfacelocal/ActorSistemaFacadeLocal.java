package co.com.smilepersistence.interfacelocal;

import co.com.smilepersistence.entity.ActorSistema;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FABIO
 */
@Local
public interface ActorSistemaFacadeLocal {

    void create(ActorSistema actorSistema);

    void edit(ActorSistema actorSistema);

    void remove(ActorSistema actorSistema);

    ActorSistema find(Object id);

    List<ActorSistema> findAll();

    List<ActorSistema> findRange(int[] range);

    int count();
    
}
