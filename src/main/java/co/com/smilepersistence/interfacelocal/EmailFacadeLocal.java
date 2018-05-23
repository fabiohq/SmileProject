package co.com.smilepersistence.interfacelocal;

import co.com.smilepersistence.entity.Email;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FABIO
 */
@Local
public interface EmailFacadeLocal {

    void create(Email email);

    void edit(Email email);

    void remove(Email email);

    Email find(Object id);

    List<Email> findAll();

    List<Email> findRange(int[] range);

    int count();
    
}