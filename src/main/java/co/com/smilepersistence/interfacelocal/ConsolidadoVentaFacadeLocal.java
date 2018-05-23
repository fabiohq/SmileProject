package co.com.smilepersistence.interfacelocal;


import co.com.smilepersistence.entity.ConsolidadoVenta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FABIO
 */
@Local
public interface ConsolidadoVentaFacadeLocal {

    void create(ConsolidadoVenta consolidadoVenta);

    void edit(ConsolidadoVenta consolidadoVenta);

    void remove(ConsolidadoVenta consolidadoVenta);

    ConsolidadoVenta find(Object id);

    List<ConsolidadoVenta> findAll();

    List<ConsolidadoVenta> findRange(int[] range);

    int count();
    
}