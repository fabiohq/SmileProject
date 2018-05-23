package co.com.smilepersistence.logic;

import java.util.ArrayList;
import java.util.List;

import co.com.remoteinterface.modelo.ActorSistemaDTO;
import co.com.remoteinterface.modelo.ConsolidadoVentaDTO;
import co.com.remoteinterface.modelo.DocumentoDTO;
import co.com.smilepersistence.entity.ActorSistema;
import co.com.smilepersistence.entity.ConsolidadoVenta;
import co.com.smilepersistence.entity.Documento;
import co.com.smilepersistence.interfacelocal.ConsolidadoVentaLogicLocal;
import co.com.smilepersistence.utilidades.Util;

public class ConsolidadoVentaLogic extends AbstractInject implements ConsolidadoVentaLogicLocal {

	public void crear(ConsolidadoVentaDTO consolidadoVentaDTO)throws Exception{
		
		ConsolidadoVenta consolidadoVenta = new ConsolidadoVenta();
		consolidadoVenta.setIdconsolidadoVenta(1L);
		consolidadoVenta.setReferenciaVenta(consolidadoVentaDTO.getReferenciaVenta());
		consolidadoVenta.setFechaActual(Util.getDateFechaActualDDMMAAAA());
		consolidadoVenta.setHoraActual(Util.getStringHoraActualHHMMSS());
		consolidadoVenta.setTotalDescCampania(consolidadoVentaDTO.getTotalDescCampania());
		consolidadoVenta.setTotalDescPreferenc(consolidadoVentaDTO.getTotalDescPreferenc());
		consolidadoVenta.setDescALaVenta(consolidadoVentaDTO.getDescALaVenta());
		consolidadoVenta.setTotalVenta(consolidadoVenta.getTotalVenta());
		consolidadoVenta.setObservacion(consolidadoVentaDTO.getObservacion());
		ActorSistema idactorSistema = actorSistemaFacadeEJB.find(consolidadoVentaDTO.getIdactorSistemaDTO().getIdactorSistema());
		consolidadoVenta.setIdactorSistema(idactorSistema);
		Documento iddocumento = documentoFacadeEJB.find(consolidadoVentaDTO.getIddocumentoDTO().getIddocumento());
		consolidadoVenta.setIddocumento(iddocumento);
		consolidadoVentaFacadeEJB.create(consolidadoVenta);
	}
	
	public void editar(ConsolidadoVentaDTO consolidadoVentaDTO)throws Exception{
		
		ConsolidadoVenta consolidadoVenta = consolidadoVentaFacadeEJB.find(consolidadoVentaDTO.getIdconsolidadoVenta());
		consolidadoVenta.setReferenciaVenta(consolidadoVentaDTO.getReferenciaVenta());
		consolidadoVenta.setFechaActual(Util.getDateFechaActualDDMMAAAA());
		consolidadoVenta.setHoraActual(Util.getStringHoraActualHHMMSS());
		consolidadoVenta.setTotalDescCampania(consolidadoVentaDTO.getTotalDescCampania());
		consolidadoVenta.setTotalDescPreferenc(consolidadoVentaDTO.getTotalDescPreferenc());
		consolidadoVenta.setDescALaVenta(consolidadoVentaDTO.getDescALaVenta());
		consolidadoVenta.setTotalVenta(consolidadoVenta.getTotalVenta());
		consolidadoVenta.setObservacion(consolidadoVentaDTO.getObservacion());
		ActorSistema idactorSistema = actorSistemaFacadeEJB.find(consolidadoVentaDTO.getIdactorSistemaDTO().getIdactorSistema());
		consolidadoVenta.setIdactorSistema(idactorSistema);
		Documento iddocumento = documentoFacadeEJB.find(consolidadoVentaDTO.getIddocumentoDTO().getIddocumento());
		consolidadoVenta.setIddocumento(iddocumento);
		consolidadoVentaFacadeEJB.edit(consolidadoVenta);
	}
	
	public void eliminar(ConsolidadoVentaDTO consolidadoVentaDTO)throws Exception{
		
		ConsolidadoVenta consolidadoVenta = consolidadoVentaFacadeEJB.find(consolidadoVentaDTO.getIdconsolidadoVenta());		
		consolidadoVentaFacadeEJB.remove(consolidadoVenta);
	}
	
	public ConsolidadoVentaDTO findId(ConsolidadoVentaDTO consolidadoVentaDTO)throws Exception{
		
		ConsolidadoVenta consolidadoVenta = consolidadoVentaFacadeEJB.find(consolidadoVentaDTO.getIdconsolidadoVenta());		
		return (ConsolidadoVentaDTO) converterEntityADTO(consolidadoVenta);
	}
	
	public List<ConsolidadoVentaDTO> findAll()throws Exception{
		
		List<ConsolidadoVenta> consolidadoVentaList = consolidadoVentaFacadeEJB.findAll();
		List<ConsolidadoVentaDTO> consolidadoVentaListDTO = new ArrayList<ConsolidadoVentaDTO>();
		for(ConsolidadoVenta consolidadoVenta : consolidadoVentaList){
			ConsolidadoVentaDTO consolidadoVentaDTO = (ConsolidadoVentaDTO) converterEntityADTO(consolidadoVenta);
			consolidadoVentaListDTO.add(consolidadoVentaDTO);
		}
		return consolidadoVentaListDTO;
	}
	
	@Override
	public Object converterEntityADTO(Object object) throws Exception {
		ConsolidadoVenta consolidadoVenta = (ConsolidadoVenta) object;		
		ActorSistemaDTO idactorSistemaDTO =(ActorSistemaDTO) actorSistemaLogicEJB.converterEntityADTO(consolidadoVenta.getIdactorSistema());		
		DocumentoDTO iddocumentoDTO =(DocumentoDTO) documentoLogicEJB.converterEntityADTO(consolidadoVenta.getIddocumento());		
		ConsolidadoVentaDTO consolidadoVentaDTO = new ConsolidadoVentaDTO(consolidadoVenta.getIdconsolidadoVenta(), consolidadoVenta.getReferenciaVenta(), consolidadoVenta.getFechaActual(), consolidadoVenta.getHoraActual(), consolidadoVenta.getTotalDescCampania(), consolidadoVenta.getTotalDescPreferenc(), consolidadoVenta.getDescALaVenta(), consolidadoVenta.getTotalVenta(), consolidadoVenta.getObservacion());
		consolidadoVentaDTO.setIdactorSistemaDTO(idactorSistemaDTO);
		consolidadoVentaDTO.setIddocumentoDTO(iddocumentoDTO);
		return consolidadoVentaDTO;
	}

}
