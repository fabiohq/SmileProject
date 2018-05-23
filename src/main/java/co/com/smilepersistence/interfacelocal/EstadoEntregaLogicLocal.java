package co.com.smilepersistence.interfacelocal;

import java.util.List;

import co.com.remoteinterface.modelo.EstadoEntregaDTO;

public interface EstadoEntregaLogicLocal {

	public void crear(EstadoEntregaDTO estadoEntregaDTO)throws Exception;
	public void editar(EstadoEntregaDTO estadoEntregaDTO)throws Exception;
	public void eliminar(EstadoEntregaDTO estadoEntregaDTO) throws Exception;
	public EstadoEntregaDTO findId(Long idEstadoEntrega)throws Exception;
	public List<EstadoEntregaDTO> findAll() throws Exception;
	public Object converterEntityADTO(Object object) throws Exception;
}
