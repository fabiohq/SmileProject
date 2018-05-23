package co.com.smilepersistence.interfacelocal;

import co.com.smilepersistence.entity.TipoEmail;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FABIO
 */
@Local
public interface TipoEmailFacadeLocal {

    void create(TipoEmail tipoEmail);

    void edit(TipoEmail tipoEmail);

    void remove(TipoEmail tipoEmail);

    TipoEmail find(Object id);

    List<TipoEmail> findAll();

    List<TipoEmail> findRange(int[] range);

    int count();
    
}