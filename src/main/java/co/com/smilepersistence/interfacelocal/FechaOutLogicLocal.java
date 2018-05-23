package co.com.smilepersistence.interfacelocal;

import java.util.List;

import co.com.remoteinterface.modelo.FechaOutDTO;

public interface FechaOutLogicLocal {
	public void crear(FechaOutDTO fechaOutDTO)throws Exception;
	public void editar(FechaOutDTO fechaOutDTO)throws Exception;
	public void eliminar(FechaOutDTO fechaOutDTO)throws Exception;
	public FechaOutDTO findId(Long idFechaOut)throws Exception;
	public List<FechaOutDTO> findAll()throws Exception;
	public Object converterEntityADTO(Object object) throws Exception;

}
