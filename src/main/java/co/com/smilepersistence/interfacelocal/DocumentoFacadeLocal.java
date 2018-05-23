package co.com.smilepersistence.interfacelocal;

import co.com.smilepersistence.entity.Documento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FABIO
 */
@Local
public interface DocumentoFacadeLocal {

    void create(Documento documento);

    void edit(Documento documento);

    void remove(Documento documento);

    Documento find(Object id);

    List<Documento> findAll();

    List<Documento> findRange(int[] range);

    int count();
    
}