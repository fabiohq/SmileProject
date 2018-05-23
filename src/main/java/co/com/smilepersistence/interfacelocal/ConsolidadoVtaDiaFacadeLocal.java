package co.com.smilepersistence.interfacelocal;

import co.com.smilepersistence.entity.ConsolidadoVtaDia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FABIO
 */
@Local
public interface ConsolidadoVtaDiaFacadeLocal {

    void create(ConsolidadoVtaDia consolidadoVtaDia);

    void edit(ConsolidadoVtaDia consolidadoVtaDia);

    void remove(ConsolidadoVtaDia consolidadoVtaDia);

    ConsolidadoVtaDia find(Object id);

    List<ConsolidadoVtaDia> findAll();

    List<ConsolidadoVtaDia> findRange(int[] range);

    int count();
    
}