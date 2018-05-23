package co.com.smilepersistence.interfacelocal;

import java.util.List;

import co.com.remoteinterface.modelo.FechaInDTO;

public interface FechaInLogicLocal {
	public void crear(FechaInDTO fechaInDTO)throws Exception;
	public void editar(FechaInDTO fechaInDTO)throws Exception;
	public void eliminar(FechaInDTO fechaInDTO)throws Exception;
	public FechaInDTO findId(Long idFechaIn)throws Exception;
	public List<FechaInDTO> findAll()throws Exception;
	public Object converterEntityADTO(Object object) throws Exception;
}
