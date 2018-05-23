package co.com.smilepersistence.interfacelocal;


import co.com.smilepersistence.entity.FechaIn;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FABIO
 */
@Local
public interface FechaInFacadeLocal {

    void create(FechaIn fechaIn);

    void edit(FechaIn fechaIn);

    void remove(FechaIn fechaIn);

    FechaIn find(Object id);

    List<FechaIn> findAll();

    List<FechaIn> findRange(int[] range);

    int count();
    
}
