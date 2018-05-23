package co.com.smilepersistence.interfacelocal;

import java.util.List;

import co.com.remoteinterface.modelo.ConsolidadoVtaDiaDTO;

public interface ConsolidadoVtaDiaLogicLocal {

	public void crear(ConsolidadoVtaDiaDTO consolidadoVtaDiaDTO)throws Exception;
	public void editar(ConsolidadoVtaDiaDTO consolidadoVtaDiaDTO)throws Exception;
	public void eliminar(ConsolidadoVtaDiaDTO consolidadoVtaDiaDTO)throws Exception;
	public ConsolidadoVtaDiaDTO findId(Long idConsolidadoVtaDia)throws Exception;
	public List<ConsolidadoVtaDiaDTO> findAll()throws Exception;
	public Object converterEntityADTO(Object object) throws Exception;
}
