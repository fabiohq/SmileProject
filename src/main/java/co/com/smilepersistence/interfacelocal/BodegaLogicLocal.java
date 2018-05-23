package co.com.smilepersistence.interfacelocal;

import java.util.List;

import co.com.remoteinterface.modelo.BodegaDTO;

public interface BodegaLogicLocal {

	public void crear(BodegaDTO bodegaDTO)throws Exception;
	public void editar(BodegaDTO bodegaDTO)throws Exception;
	public void eliminar(BodegaDTO bodegaDTO)throws Exception;
	public BodegaDTO findId(Long idBodega)throws Exception;
	public List<BodegaDTO> findAll()throws Exception;
	public Object converterEntityADTO(Object object) throws Exception;
}
