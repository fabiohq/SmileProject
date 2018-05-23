package co.com.smilepersistence.interfacelocal;


import co.com.smilepersistence.entity.Encargo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FABIO
 */
@Local
public interface EncargoFacadeLocal {

    void create(Encargo encargo);

    void edit(Encargo encargo);

    void remove(Encargo encargo);

    Encargo find(Object id);

    List<Encargo> findAll();

    List<Encargo> findRange(int[] range);

    int count();
    
}