package co.com.smilepersistence.logic;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.CreateException;

import co.com.remoteinterface.modelo.ActorSistemaDTO;
import co.com.remoteinterface.modelo.BodegaDTO;
import co.com.remoteinterface.modelo.FechaInDTO;
import co.com.smilepersistence.entity.ActorSistema;
import co.com.smilepersistence.entity.Bodega;
import co.com.smilepersistence.entity.FechaIn;
import co.com.smilepersistence.interfacelocal.FechaInLogicLocal;
import co.com.smilepersistence.utilidades.Util;

public class FechaInLogic extends AbstractInject implements FechaInLogicLocal{

	public void crear(FechaInDTO fechaInDTO)throws Exception{
		
		validaInteger(fechaInDTO.getCantidad(), "Cantidad");
		
		FechaIn fechaIn = new FechaIn();
		fechaIn.setIdfechaIn(1L);
		ActorSistema idactorSistema = actorSistemaFacadeEJB.find(fechaInDTO.getIdactorSistemaDTO().getIdactorSistema());
		fechaIn.setIdactorSistema(idactorSistema);
		Bodega idbodega = bodegaFacadeEJB.find(fechaInDTO.getIdbodegaDTO().getIdbodega());
		fechaIn.setIdbodega(idbodega);
		fechaIn.setFechaActual(Util.getDateFechaActualDDMMAAAA());
		fechaIn.setHoraActual(Util.getStringHoraActualHHMMSS());
		fechaIn.setCantidad(fechaInDTO.getCantidad());
		fechaIn.setObservacion(fechaInDTO.getObservacion());
		
		fechaInFacadeEJB.create(fechaIn);
	}
	public void editar(FechaInDTO fechaInDTO)throws Exception{
		
		validaInteger(fechaInDTO.getCantidad(), "Cantidad");
		
		FechaIn fechaIn = fechaInFacadeEJB.find(fechaInDTO.getIdfechaIn());
		ActorSistema idactorSistema = actorSistemaFacadeEJB.find(fechaInDTO.getIdactorSistemaDTO().getIdactorSistema());
		fechaIn.setIdactorSistema(idactorSistema);
		Bodega idbodega = bodegaFacadeEJB.find(fechaInDTO.getIdbodegaDTO().getIdbodega());
		fechaIn.setIdbodega(idbodega);
		fechaIn.setFechaActual(Util.getDateFechaActualDDMMAAAA());
		fechaIn.setHoraActual(Util.getStringHoraActualHHMMSS());
		fechaIn.setCantidad(fechaInDTO.getCantidad());
		fechaIn.setObservacion(fechaInDTO.getObservacion());
		
		fechaInFacadeEJB.edit(fechaIn);
	}
	public void eliminar(FechaInDTO fechaInDTO)throws Exception{
				
		FechaIn fechaIn = fechaInFacadeEJB.find(fechaInDTO.getIdfechaIn());				
		fechaInFacadeEJB.remove(fechaIn);
	}
	public FechaInDTO findId(Long idFechaIn)throws Exception{
		
		FechaIn fechaIn = fechaInFacadeEJB.find(idFechaIn);				
		return (FechaInDTO) converterEntityADTO(fechaIn);
	}
	public List<FechaInDTO> findAll()throws Exception{
		
		List<FechaIn> fechaInList = fechaInFacadeEJB.findAll();
		List<FechaInDTO> fechaInListDTO = new ArrayList<FechaInDTO>();
		for(FechaIn fechaIn : fechaInList){
			FechaInDTO fechaInDTO = (FechaInDTO) converterEntityADTO(fechaIn);
			fechaInListDTO.add(fechaInDTO);
		}
		return fechaInListDTO;
	}
	@Override
	public void validaInteger(Integer obj, String campo) throws Exception, CreateException {
		// TODO Auto-generated method stub
		super.validaInteger(obj, campo);
	}
	@Override
	public Object converterEntityADTO(Object object) throws Exception {
		FechaIn fechaIn =(FechaIn) object;
		ActorSistema idActorSistema = fechaIn.getIdactorSistema();
		ActorSistemaDTO idActorSistemaDTO = (ActorSistemaDTO)actorSistemaLogicEJB.converterEntityADTO(idActorSistema); 
		Bodega idBodega = fechaIn.getIdbodega();
		BodegaDTO idBodegaDTO = (BodegaDTO) bodegaLogicEJB.converterEntityADTO(idBodega);
		
		FechaInDTO fechaInDTO = new FechaInDTO(fechaIn.getIdfechaIn(), fechaIn.getFechaActual(), fechaIn.getHoraActual(), fechaIn.getCantidad(), fechaIn.getObservacion());
		fechaInDTO.setIdactorSistemaDTO(idActorSistemaDTO);
		fechaInDTO.setIdbodegaDTO(idBodegaDTO);
		return fechaInDTO;
	}

}
