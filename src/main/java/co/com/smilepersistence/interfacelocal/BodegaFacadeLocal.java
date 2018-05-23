package co.com.smilepersistence.interfacelocal;


import co.com.smilepersistence.entity.Bodega;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FABIO
 */
@Local
public interface BodegaFacadeLocal {

    void create(Bodega bodega);

    void edit(Bodega bodega);

    void remove(Bodega bodega);

    Bodega find(Object id);

    List<Bodega> findAll();

    List<Bodega> findRange(int[] range);

    int count();
}