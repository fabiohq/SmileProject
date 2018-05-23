package co.com.smilepersistence.interfacelocal;

import co.com.smilepersistence.entity.Producto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FABIO
 */
@Local
public interface ProductoFacadeLocal {

    void create(Producto producto);

    void edit(Producto producto);

    void remove(Producto producto);

    Producto find(Object id);

    List<Producto> findAll();

    List<Producto> findRange(int[] range);

    int count();
    
}