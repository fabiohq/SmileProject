package co.com.smilepersistence.interfacelocal;

import co.com.smilepersistence.entity.EstadoEntrega;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FABIO
 */
@Local
public interface EstadoEntregaFacadeLocal {

    void create(EstadoEntrega estadoEntrega);

    void edit(EstadoEntrega estadoEntrega);

    void remove(EstadoEntrega estadoEntrega);

    EstadoEntrega find(Object id);

    List<EstadoEntrega> findAll();

    List<EstadoEntrega> findRange(int[] range);

    int count();
    
}