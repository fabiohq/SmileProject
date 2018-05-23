package co.com.smilepersistence.interfacelocal;

import java.util.List;

import co.com.remoteinterface.modelo.ConsolidadoVentaDTO;

public interface ConsolidadoVentaLogicLocal {

	public void crear(ConsolidadoVentaDTO consolidadoVentaDTO)throws Exception;
	public void editar(ConsolidadoVentaDTO consolidadoVentaDTO)throws Exception;
	public void eliminar(ConsolidadoVentaDTO consolidadoVentaDTO)throws Exception;
	public ConsolidadoVentaDTO findId(ConsolidadoVentaDTO consolidadoVentaDTO)throws Exception;
	public List<ConsolidadoVentaDTO> findAll()throws Exception;
	public Object converterEntityADTO(Object object) throws Exception;
}
