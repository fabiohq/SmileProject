package co.com.smilepersistence.interfacelocal;

import co.com.smilepersistence.entity.VentaPendiente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FABIO
 */
@Local
public interface VentaPendienteFacadeLocal {

    void create(VentaPendiente ventaPendiente);

    void edit(VentaPendiente ventaPendiente);

    void remove(VentaPendiente ventaPendiente);

    VentaPendiente find(Object id);

    List<VentaPendiente> findAll();

    List<VentaPendiente> findRange(int[] range);

    int count();
    
}