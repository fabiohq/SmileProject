package co.com.smilepersistence.interfacelocal;

import co.com.smilepersistence.entity.SaldoAFavor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FABIO
 */
@Local
public interface SaldoAFavorFacadeLocal {

    void create(SaldoAFavor saldoAFavor);

    void edit(SaldoAFavor saldoAFavor);

    void remove(SaldoAFavor saldoAFavor);

    SaldoAFavor find(Object id);

    List<SaldoAFavor> findAll();

    List<SaldoAFavor> findRange(int[] range);

    int count();
    
}