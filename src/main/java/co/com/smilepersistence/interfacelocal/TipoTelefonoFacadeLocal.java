package co.com.smilepersistence.interfacelocal;

import co.com.smilepersistence.entity.TipoTelefono;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FABIO
 */
@Local
public interface TipoTelefonoFacadeLocal {

    void create(TipoTelefono tipoTelefono);

    void edit(TipoTelefono tipoTelefono);

    void remove(TipoTelefono tipoTelefono);

    TipoTelefono find(Object id);

    List<TipoTelefono> findAll();

    List<TipoTelefono> findRange(int[] range);

    int count();
    
}