package co.com.smilepersistence.logic;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.CreateException;

import co.com.remoteinterface.modelo.ActorSistemaDTO;
import co.com.remoteinterface.modelo.BodegaDTO;
import co.com.remoteinterface.modelo.FechaOutDTO;
import co.com.smilepersistence.entity.ActorSistema;
import co.com.smilepersistence.entity.Bodega;
import co.com.smilepersistence.entity.FechaOut;
import co.com.smilepersistence.interfacelocal.FechaOutLogicLocal;
import co.com.smilepersistence.utilidades.Util;

public class FechaOutLogic extends AbstractInject implements FechaOutLogicLocal{

	public void crear(FechaOutDTO fechaOutDTO)throws Exception{
		
		validaInteger(fechaOutDTO.getCantidad(), "Cantidad");
		
		FechaOut fechaOut = new FechaOut();
		fechaOut.setIdfechaOut(1L);
		ActorSistema idactorSistema = actorSistemaFacadeEJB.find(fechaOutDTO.getIdactorSistemaDTO().getIdactorSistema());
		fechaOut.setIdactorSistema(idactorSistema);
		Bodega idbodega = bodegaFacadeEJB.find(fechaOutDTO.getIdbodegaDTO().getIdbodega());
		fechaOut.setIdbodega(idbodega);
		fechaOut.setFechaActual(Util.getDateFechaActualDDMMAAAA());
		fechaOut.setHoraActual(Util.getStringHoraActualHHMMSS());
		fechaOut.setCantidad(fechaOutDTO.getCantidad());
		fechaOut.setObservacion(fechaOutDTO.getObservacion());
		
		fechaOutFacadeEJB.create(fechaOut);
	}
	public void editar(FechaOutDTO fechaOutDTO)throws Exception{
		
		validaInteger(fechaOutDTO.getCantidad(), "Cantidad");
		
		FechaOut fechaOut = fechaOutFacadeEJB.find(fechaOutDTO.getIdfechaOut());
		ActorSistema idactorSistema = actorSistemaFacadeEJB.find(fechaOutDTO.getIdactorSistemaDTO().getIdactorSistema());
		fechaOut.setIdactorSistema(idactorSistema);
		Bodega idbodega = bodegaFacadeEJB.find(fechaOutDTO.getIdbodegaDTO().getIdbodega());
		fechaOut.setIdbodega(idbodega);
		fechaOut.setFechaActual(Util.getDateFechaActualDDMMAAAA());
		fechaOut.setHoraActual(Util.getStringHoraActualHHMMSS());
		fechaOut.setCantidad(fechaOutDTO.getCantidad());
		fechaOut.setObservacion(fechaOutDTO.getObservacion());
		
		fechaOutFacadeEJB.edit(fechaOut);
	}
	public void eliminar(FechaOutDTO fechaOutDTO)throws Exception{
				
		FechaOut fechaOut = fechaOutFacadeEJB.find(fechaOutDTO.getIdfechaOut());				
		fechaOutFacadeEJB.remove(fechaOut);
	}
	public FechaOutDTO findId(Long idFechaOut)throws Exception{
		
		FechaOut fechaOut = fechaOutFacadeEJB.find(idFechaOut);				
		return (FechaOutDTO) converterEntityADTO(fechaOut);
	}
	public List<FechaOutDTO> findAll()throws Exception{
		
		List<FechaOut> fechaOutList = fechaOutFacadeEJB.findAll();
		List<FechaOutDTO> fechaOutListDTO = new ArrayList<FechaOutDTO>();
		for(FechaOut fechaOut : fechaOutList){
			FechaOutDTO fechaOutDTO = (FechaOutDTO) converterEntityADTO(fechaOut);
			fechaOutListDTO.add(fechaOutDTO);
		}
		return fechaOutListDTO;
	}
	@Override
	public void validaInteger(Integer obj, String campo) throws Exception, CreateException {
		// TODO Auto-generated method stub
		super.validaInteger(obj, campo);
	}
	@Override
	public Object converterEntityADTO(Object object) throws Exception {
		FechaOut fechaOut =(FechaOut) object;
		ActorSistema idActorSistema = fechaOut.getIdactorSistema();
		ActorSistemaDTO idActorSistemaDTO = (ActorSistemaDTO)actorSistemaLogicEJB.converterEntityADTO(idActorSistema); 
		Bodega idBodega = fechaOut.getIdbodega();
		BodegaDTO idBodegaDTO = (BodegaDTO) bodegaLogicEJB.converterEntityADTO(idBodega);
		
		FechaOutDTO fechaOutDTO = new FechaOutDTO(fechaOut.getIdfechaOut(), fechaOut.getFechaActual(), fechaOut.getHoraActual(), fechaOut.getCantidad(), fechaOut.getObservacion());
		fechaOutDTO.setIdactorSistemaDTO(idActorSistemaDTO);
		fechaOutDTO.setIdbodegaDTO(idBodegaDTO);
		return fechaOutDTO;
	}

}
