package co.com.smilepersistence.interfacelocal;

import java.util.List;

import co.com.remoteinterface.modelo.EstadoDTO;

public interface EstadoLogicLocal {
	
	public void crear(EstadoDTO estadoDTO) throws Exception;
	public void editar(EstadoDTO estadoDTO) throws Exception;
	public void eliminar(EstadoDTO estadoDTO) throws Exception;
	public EstadoDTO findId(Long idEstado) throws Exception;
	public List<EstadoDTO> findAll() throws Exception;
	public Object converterEntityADTO(Object object) throws Exception;

}
