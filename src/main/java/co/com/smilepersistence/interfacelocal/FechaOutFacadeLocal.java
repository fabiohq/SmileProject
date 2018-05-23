package co.com.smilepersistence.interfacelocal;

import co.com.smilepersistence.entity.FechaOut;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FABIO
 */
@Local
public interface FechaOutFacadeLocal {

    void create(FechaOut fechaOut);

    void edit(FechaOut fechaOut);

    void remove(FechaOut fechaOut);

    FechaOut find(Object id);

    List<FechaOut> findAll();

    List<FechaOut> findRange(int[] range);

    int count();
    
}