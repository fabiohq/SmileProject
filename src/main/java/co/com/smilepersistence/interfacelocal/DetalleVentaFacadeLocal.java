package co.com.smilepersistence.interfacelocal;

import co.com.smilepersistence.entity.DetalleVenta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FABIO
 */
@Local
public interface DetalleVentaFacadeLocal{

    void create(DetalleVenta detalleVenta);

    void edit(DetalleVenta detalleVenta);

    void remove(DetalleVenta detalleVenta);

    DetalleVenta find(Object id);

    List<DetalleVenta> findAll();

    List<DetalleVenta> findRange(int[] range);

    int count();
    
}