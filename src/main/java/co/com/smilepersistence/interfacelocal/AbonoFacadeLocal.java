package co.com.smilepersistence.interfacelocal;

import co.com.smilepersistence.entity.Abono;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FABIO
 */
@Local
public interface AbonoFacadeLocal {

    void create(Abono abono);

    void edit(Abono abono);

    void remove(Abono abono);

    Abono find(Object id);

    List<Abono> findAll();

    List<Abono> findRange(int[] range);

    int count();
    
}