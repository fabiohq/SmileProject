package co.com.smilepersistence.interfacelocal;

import java.util.List;

import co.com.remoteinterface.modelo.CampaniasPromocionalesDTO;

public interface CampaniasPromocionalesLogicLocal {

	public void crear(CampaniasPromocionalesDTO campaniasPromocionalesDTO)throws Exception;
	public void editar(CampaniasPromocionalesDTO campaniasPromocionalesDTO)throws Exception;
	public void eliminar(CampaniasPromocionalesDTO campaniasPromocionalesDTO)throws Exception;
	public CampaniasPromocionalesDTO findId(Long idcampaniasPromocionales)throws Exception;
	public List<CampaniasPromocionalesDTO> findIdAll()throws Exception;
	public Object converterEntityADTO(Object object) throws Exception;
}
