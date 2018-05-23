package co.com.smilepersistence.interfacelocal;

import co.com.smilepersistence.entity.Credenciales;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FABIO
 */
@Local
public interface CredencialesFacadeLocal {

    void create(Credenciales credenciales);

    void edit(Credenciales credenciales);

    void remove(Credenciales credenciales);

    Credenciales find(Object id);

    List<Credenciales> findAll();

    List<Credenciales> findRange(int[] range);

    int count();
    
}