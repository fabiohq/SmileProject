package co.com.smilepersistence.logic;

import java.util.ArrayList;
import java.util.List;

import co.com.remoteinterface.modelo.ActorSistemaDTO;
import co.com.remoteinterface.modelo.BodegaDTO;
import co.com.remoteinterface.modelo.CampaniasPromocionalesDTO;
import co.com.remoteinterface.modelo.ConsolidadoVentaDTO;
import co.com.remoteinterface.modelo.ConsolidadoVtaDiaDTO;
import co.com.remoteinterface.modelo.CredencialesDTO;
import co.com.remoteinterface.modelo.DetalleVentaDTO;
import co.com.remoteinterface.modelo.DocumentoDTO;
import co.com.remoteinterface.modelo.EncargoDTO;
import co.com.remoteinterface.modelo.EstadoDTO;
import co.com.remoteinterface.modelo.FechaInDTO;
import co.com.remoteinterface.modelo.FechaOutDTO;
import co.com.remoteinterface.modelo.RolDTO;
import co.com.remoteinterface.modelo.VentaPendienteDTO;
import co.com.smilepersistence.entity.ActorSistema;
import co.com.smilepersistence.entity.Bodega;
import co.com.smilepersistence.entity.CampaniasPromocionales;
import co.com.smilepersistence.entity.ConsolidadoVenta;
import co.com.smilepersistence.entity.ConsolidadoVtaDia;
import co.com.smilepersistence.entity.Credenciales;
import co.com.smilepersistence.entity.DetalleVenta;
import co.com.smilepersistence.entity.Documento;
import co.com.smilepersistence.entity.Encargo;
import co.com.smilepersistence.entity.Estado;
import co.com.smilepersistence.entity.FechaIn;
import co.com.smilepersistence.entity.FechaOut;
import co.com.smilepersistence.entity.Rol;
import co.com.smilepersistence.entity.VentaPendiente;
import co.com.smilepersistence.interfacelocal.ActorSistemaLogicLocal;
import co.com.smilepersistence.utilidades.Util;

public class ActorSistemaLogic extends AbstractInject implements ActorSistemaLogicLocal{

	public void crear(ActorSistemaDTO actorSistemaDTO)throws Exception{
		
		ActorSistema actorSistema = new ActorSistema();
		actorSistema.setIdactorSistema(1L);
		Documento idDocumento = documentoFacadeEJB.find(actorSistemaDTO.getIddocumentoDTO().getIddocumento());
		actorSistema.setIddocumento(idDocumento);
		Estado idEstado = estadoFacadeEJB.find(actorSistemaDTO.getIdestadoDTO().getIdestado());
		actorSistema.setIdestado(idEstado);
		Rol idRol = rolFacadeEJB.find(actorSistemaDTO.getIdrolDTO().getIdrol());
		actorSistema.setIdrol(idRol);
		actorSistema.setObservacion(actorSistemaDTO.getObservacion());
		actorSistema.setFechaRegistro(Util.getDateFechaActualDDMMAAAA());
		
		actorSistemaFacadeEJB.create(actorSistema);
	}
	
	public void editar(ActorSistemaDTO actorSistemaDTO)throws Exception{
		
		ActorSistema actorSistema = actorSistemaFacadeEJB.find(actorSistemaDTO.getIdactorSistema());
		Documento idDocumento = documentoFacadeEJB.find(actorSistemaDTO.getIddocumentoDTO().getIddocumento());
		actorSistema.setIddocumento(idDocumento);
		Estado idEstado = estadoFacadeEJB.find(actorSistemaDTO.getIdestadoDTO().getIdestado());
		actorSistema.setIdestado(idEstado);
		Rol idRol = rolFacadeEJB.find(actorSistemaDTO.getIdrolDTO().getIdrol());
		actorSistema.setIdrol(idRol);
		actorSistema.setObservacion(actorSistemaDTO.getObservacion());
		actorSistema.setFechaRegistro(actorSistemaDTO.getFechaRegistro());
		
		actorSistemaFacadeEJB.edit(actorSistema);
	}
	
	public void eliminar(ActorSistemaDTO actorSistemaDTO)throws Exception{
		
		ActorSistema actorSistema = actorSistemaFacadeEJB.find(actorSistemaDTO.getIdactorSistema());
				
		actorSistemaFacadeEJB.remove(actorSistema);
	}
	
	public ActorSistemaDTO findId(Long idActorSistema) throws Exception{
		
		ActorSistema actorSistema = actorSistemaFacadeEJB.find(idActorSistema);
		return (ActorSistemaDTO) converterEntityADTO(actorSistema);
	}
	
	public List<ActorSistemaDTO> findIdAll() throws Exception{
		
		List<ActorSistema> actorSistemaList = actorSistemaFacadeEJB.findAll();
		List<ActorSistemaDTO> actorSistemaListDTO = new ArrayList<ActorSistemaDTO>();
		for(ActorSistema actorSistema : actorSistemaList){
			
			ActorSistemaDTO actorSistemaDTO = (ActorSistemaDTO) converterEntityADTO(actorSistema);
			actorSistemaListDTO.add(actorSistemaDTO);
		}
		return actorSistemaListDTO;
	}
	
	@Override
	public Object converterEntityADTO(Object object) throws Exception {
		
		ActorSistema actorSistema = (ActorSistema) object;		
		DocumentoDTO idDocumentoDTO = (DocumentoDTO) documentoLogicEJB.converterEntityADTO(actorSistema.getIddocumento());
		EstadoDTO idEstadoDTO = (EstadoDTO) estadoLogicEJB.converterEntityADTO(actorSistema.getIdestado());
		RolDTO idRolDTO = (RolDTO) rolLogicEJB.converterEntityADTO(actorSistema.getIdrol());
		
		List<FechaIn> fechaInList = actorSistema.getFechaInList();		
		List<FechaInDTO> fechaInListDTO = new ArrayList<FechaInDTO>();
		for(FechaIn fechaIn : fechaInList){
			FechaInDTO fechaInDTO = (FechaInDTO) fechaInLogicEJB.converterEntityADTO(fechaIn);
			fechaInListDTO.add(fechaInDTO);
		}
		List<FechaOut> fechaOutList = actorSistema.getFechaOutList();
		List<FechaOutDTO> fechaOutListDTO = new ArrayList<FechaOutDTO>();
		for(FechaOut fechaOut : fechaOutList){
			FechaOutDTO fechaOutDTO = (FechaOutDTO) fechaOutLogicEJB.converterEntityADTO(fechaOut);
			fechaOutListDTO.add(fechaOutDTO);
		}
		
		List<Encargo> encargoList = actorSistema.getEncargoList();
		List<EncargoDTO> encargoListDTO = new ArrayList<EncargoDTO>();
		for(Encargo encargo : encargoList){
			EncargoDTO encargoDTO = (EncargoDTO) encargoLogicEJB.converterEntityADTO(encargo);
			encargoListDTO.add(encargoDTO);
		}
		
		List<CampaniasPromocionales> campaniasPromocionalesList = actorSistema.getCampaniasPromocionalesList();
		List<CampaniasPromocionalesDTO> campaniasPromocionalesListDTO = new ArrayList<CampaniasPromocionalesDTO>();
		for(CampaniasPromocionales campaniasPromocionales : campaniasPromocionalesList){
			CampaniasPromocionalesDTO campaniasPromocionalesDTO = (CampaniasPromocionalesDTO) campaniasPromocionalesLogicEJB.converterEntityADTO(campaniasPromocionales);
			campaniasPromocionalesListDTO.add(campaniasPromocionalesDTO);
		}
		
		List<Credenciales> credencialesList = actorSistema.getCredencialesList();
		List<CredencialesDTO> credencialesListDTO = new ArrayList<CredencialesDTO>();
		for(Credenciales credenciales : credencialesList){
			CredencialesDTO credencialesDTO = (CredencialesDTO) credencialesLogicEJB.converterEntityADTO(credenciales);
			credencialesListDTO.add(credencialesDTO);
		}
		
		List<ConsolidadoVenta> consolidadoVentaList = actorSistema.getConsolidadoVentaList(); 
		List<ConsolidadoVentaDTO> consolidadoVentaListDTO = new ArrayList<ConsolidadoVentaDTO>();
		for(ConsolidadoVenta consolidadoVenta : consolidadoVentaList){
			ConsolidadoVentaDTO consolidadoVentaDTO = (ConsolidadoVentaDTO) consolidadoVentaLogicEJB.converterEntityADTO(consolidadoVenta);
			consolidadoVentaListDTO.add(consolidadoVentaDTO);
		}
		
		List<ConsolidadoVtaDia> consolidadoVtaDiaList = actorSistema.getConsolidadoVtaDiaList();
		List<ConsolidadoVtaDiaDTO> consolidadoVtaDiaListDTO = new ArrayList<ConsolidadoVtaDiaDTO>();
		for(ConsolidadoVtaDia consolidadoVtaDia : consolidadoVtaDiaList){
			ConsolidadoVtaDiaDTO consolidadoVtaDiaDTO = (ConsolidadoVtaDiaDTO) consolidadoVtaDiaLogicEJB.converterEntityADTO(consolidadoVtaDia);
			consolidadoVtaDiaListDTO.add(consolidadoVtaDiaDTO);
		}
		
		List<VentaPendiente> ventaPendienteList = actorSistema.getVentaPendienteList();
		List<VentaPendienteDTO> ventaPendienteListDTO = new ArrayList<VentaPendienteDTO>();
		for(VentaPendiente ventaPendiente : ventaPendienteList){
			VentaPendienteDTO ventaPendienteDTO = (VentaPendienteDTO) ventaPendienteLogicEJB.converterEntityADTO(ventaPendiente);
			ventaPendienteListDTO.add(ventaPendienteDTO);
		}
		
		List<Bodega> bodegaList = actorSistema.getBodegaList();
		List<BodegaDTO> bodegaListDTO = new ArrayList<BodegaDTO>();
		for(Bodega bodega : bodegaList){
			BodegaDTO bodegaDTO = (BodegaDTO) bodegaLogicEJB.converterEntityADTO(bodega);
			bodegaListDTO.add(bodegaDTO);
		}
		
		List<DetalleVenta> detalleVentaList = actorSistema.getDetalleVentaList();
		List<DetalleVentaDTO> detalleVentaListDTO = new ArrayList<DetalleVentaDTO>();
		for(DetalleVenta detalleVenta : detalleVentaList){
			DetalleVentaDTO detalleVentaDTO = (DetalleVentaDTO) detalleVentaLogicEJB.converterEntityADTO(detalleVenta);
			detalleVentaListDTO.add(detalleVentaDTO);
		}
		
		ActorSistemaDTO actorSistemaDTO = new ActorSistemaDTO(actorSistema.getIdactorSistema(), actorSistema.getObservacion(), actorSistema.getFechaRegistro());
		
		actorSistemaDTO.setFechaInListDTO(fechaInListDTO);
		actorSistemaDTO.setFechaOutListDTO(fechaOutListDTO);
		actorSistemaDTO.setEncargoListDTO(encargoListDTO);
		actorSistemaDTO.setCampaniasPromocionalesListDTO(campaniasPromocionalesListDTO);
		actorSistemaDTO.setCredencialesListDTO(credencialesListDTO);
		actorSistemaDTO.setConsolidadoVentaListDTO(consolidadoVentaListDTO);
		actorSistemaDTO.setConsolidadoVtaDiaListDTO(consolidadoVtaDiaListDTO);
		actorSistemaDTO.setVentaPendienteListDTO(ventaPendienteListDTO);
		actorSistemaDTO.setBodegaListDTO(bodegaListDTO);
		actorSistemaDTO.setDetalleVentaListDTO(detalleVentaListDTO);
		actorSistemaDTO.setIdestadoDTO(idEstadoDTO);
		actorSistemaDTO.setIddocumentoDTO(idDocumentoDTO);
		actorSistemaDTO.setIdrolDTO(idRolDTO);
		
		return actorSistemaDTO;
	}

}
