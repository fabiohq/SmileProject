package co.com.smilepersistence.interfacelocal;

import co.com.smilepersistence.entity.EstadoVenta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FABIO
 */
@Local
public interface EstadoVentaFacadeLocal {

    void create(EstadoVenta estadoVenta);

    void edit(EstadoVenta estadoVenta);

    void remove(EstadoVenta estadoVenta);

    EstadoVenta find(Object id);

    List<EstadoVenta> findAll();

    List<EstadoVenta> findRange(int[] range);

    int count();
    
}