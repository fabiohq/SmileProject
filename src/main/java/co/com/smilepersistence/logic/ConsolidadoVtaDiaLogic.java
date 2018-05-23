package co.com.smilepersistence.logic;

import java.util.ArrayList;
import java.util.List;

import co.com.remoteinterface.modelo.ActorSistemaDTO;
import co.com.remoteinterface.modelo.ConsolidadoVtaDiaDTO;
import co.com.smilepersistence.entity.ActorSistema;
import co.com.smilepersistence.entity.ConsolidadoVtaDia;
import co.com.smilepersistence.interfacelocal.ConsolidadoVtaDiaLogicLocal;
import co.com.smilepersistence.utilidades.Util;

public class ConsolidadoVtaDiaLogic extends AbstractInject implements ConsolidadoVtaDiaLogicLocal{

	public void crear(ConsolidadoVtaDiaDTO consolidadoVtaDiaDTO)throws Exception{
	
		validaCampoValor(consolidadoVtaDiaDTO.getValor());
		
		ConsolidadoVtaDia consolidadoVtaDia = new ConsolidadoVtaDia();
		consolidadoVtaDia.setIdconsolidadoVtaDia(1L);
		consolidadoVtaDia.setFechaActual(Util.getDateFechaActualDDMMAAAA());
		consolidadoVtaDia.setValor(consolidadoVtaDiaDTO.getValor());
		ActorSistema idactorSistema = actorSistemaFacadeEJB.find(consolidadoVtaDiaDTO.getIdactorSistemaDTO().getIdactorSistema());
		consolidadoVtaDia.setIdactorSistema(idactorSistema);
		consolidadoVtaDiaFacadeEJB.create(consolidadoVtaDia);
	}
	
	public void editar(ConsolidadoVtaDiaDTO consolidadoVtaDiaDTO)throws Exception{
		
		validaCampoValor(consolidadoVtaDiaDTO.getValor());
		
		ConsolidadoVtaDia consolidadoVtaDia = consolidadoVtaDiaFacadeEJB.find(consolidadoVtaDiaDTO.getIdconsolidadoVtaDia());
		consolidadoVtaDia.setFechaActual(Util.getDateFechaActualDDMMAAAA());
		consolidadoVtaDia.setValor(consolidadoVtaDiaDTO.getValor());
		ActorSistema idactorSistema = actorSistemaFacadeEJB.find(consolidadoVtaDiaDTO.getIdactorSistemaDTO().getIdactorSistema());
		consolidadoVtaDia.setIdactorSistema(idactorSistema);
		consolidadoVtaDiaFacadeEJB.edit(consolidadoVtaDia);
	}
	
	public void eliminar(ConsolidadoVtaDiaDTO consolidadoVtaDiaDTO)throws Exception{
		
		ConsolidadoVtaDia consolidadoVtaDia = consolidadoVtaDiaFacadeEJB.find(consolidadoVtaDiaDTO.getIdconsolidadoVtaDia());		
		consolidadoVtaDiaFacadeEJB.remove(consolidadoVtaDia);
	}
	
	public ConsolidadoVtaDiaDTO findId(Long idConsolidadoVtaDia)throws Exception{
		
		ConsolidadoVtaDia consolidadoVtaDia = consolidadoVtaDiaFacadeEJB.find(idConsolidadoVtaDia);		
		return (ConsolidadoVtaDiaDTO) converterEntityADTO(consolidadoVtaDia);
	}
	
	public List<ConsolidadoVtaDiaDTO> findAll()throws Exception{
		
		List<ConsolidadoVtaDia> consolidadoVtaDiaList = consolidadoVtaDiaFacadeEJB.findAll();
		List<ConsolidadoVtaDiaDTO> consolidadoVtaDiaListDTO = new ArrayList<ConsolidadoVtaDiaDTO>();
		for(ConsolidadoVtaDia consolidadoVtaDia : consolidadoVtaDiaList){
			ConsolidadoVtaDiaDTO consolidadoVtaDiaDTO = (ConsolidadoVtaDiaDTO) converterEntityADTO(consolidadoVtaDia);
			consolidadoVtaDiaListDTO.add(consolidadoVtaDiaDTO);
		}
		return consolidadoVtaDiaListDTO;
	}
	@Override
	public Object converterEntityADTO(Object object) throws Exception {

		ConsolidadoVtaDia consolidadoVtaDia = (ConsolidadoVtaDia) object;
		ActorSistemaDTO idactorSistemaDTO = (ActorSistemaDTO)actorSistemaLogicEJB.converterEntityADTO(consolidadoVtaDia.getIdactorSistema());
		ConsolidadoVtaDiaDTO consolidadoVtaDiaDTO = new ConsolidadoVtaDiaDTO(consolidadoVtaDia.getIdconsolidadoVtaDia(), consolidadoVtaDia.getFechaActual(), consolidadoVtaDia.getValor());
		consolidadoVtaDiaDTO.setIdactorSistemaDTO(idactorSistemaDTO);
		return consolidadoVtaDiaDTO;
	}

}
