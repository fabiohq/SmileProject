package co.com.smilepersistence.interfacelocal;

import co.com.smilepersistence.entity.TipoProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FABIO
 */
@Local
public interface TipoProductoFacadeLocal {

    void create(TipoProducto tipoProducto);

    void edit(TipoProducto tipoProducto);

    void remove(TipoProducto tipoProducto);

    TipoProducto find(Object id);

    List<TipoProducto> findAll();

    List<TipoProducto> findRange(int[] range);

    int count();
    
}