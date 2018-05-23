package co.com.smilepersistence.interfacelocal;

import java.util.List;

import co.com.remoteinterface.modelo.EstadoVentaDTO;
import co.com.smilepersistence.entity.EstadoVenta;

public interface EstadoVentaLogicLocal {

	public void crear(EstadoVentaDTO estadoVentaDTO) throws Exception;
	public void editar(EstadoVentaDTO estadoVentaDTO) throws Exception;
	public void eliminar(EstadoVenta estadoVentaDTO)throws Exception;
	public EstadoVentaDTO findId(Long idEstadoVenta)throws Exception;
	public List<EstadoVentaDTO> findAll() throws Exception;
	public Object converterEntityADTO(Object object) throws Exception;
}
