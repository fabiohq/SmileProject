package co.com.smilepersistence.interfacelocal;


import co.com.smilepersistence.entity.CampaniasPromocionales;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FABIO
 */
@Local
public interface CampaniasPromocionalesFacadeLocal {

    void create(CampaniasPromocionales campaniasPromocionales);

    void edit(CampaniasPromocionales campaniasPromocionales);

    void remove(CampaniasPromocionales campaniasPromocionales);

    CampaniasPromocionales find(Object id);

    List<CampaniasPromocionales> findAll();

    List<CampaniasPromocionales> findRange(int[] range);

    int count();
    
}