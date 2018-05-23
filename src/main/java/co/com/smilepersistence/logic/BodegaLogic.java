package co.com.smilepersistence.logic;

import java.util.ArrayList;
import java.util.List;

import co.com.remoteinterface.modelo.ActorSistemaDTO;
import co.com.remoteinterface.modelo.BodegaDTO;
import co.com.remoteinterface.modelo.FechaInDTO;
import co.com.remoteinterface.modelo.FechaOutDTO;
import co.com.remoteinterface.modelo.ProductoDTO;
import co.com.smilepersistence.entity.ActorSistema;
import co.com.smilepersistence.entity.Bodega;
import co.com.smilepersistence.entity.FechaIn;
import co.com.smilepersistence.entity.FechaOut;
import co.com.smilepersistence.entity.Producto;
import co.com.smilepersistence.interfacelocal.BodegaLogicLocal;
import co.com.smilepersistence.utilidades.Util;

public class BodegaLogic extends AbstractInject implements BodegaLogicLocal{

	public void crear(BodegaDTO bodegaDTO)throws Exception{
		
		validaCampoCantidad(bodegaDTO.getCantidad());
		validaCampoTopeMax(bodegaDTO.getTopeMax());
		validaCampoTopeMin(bodegaDTO.getTopeMinimo());
		
		Bodega bodega = new Bodega();
		bodega.setIdbodega(1L);
		ActorSistema idactorSistema = actorSistemaFacadeEJB.find(bodegaDTO.getIdactorSistemaDTO().getIdactorSistema());
		bodega.setIdactorSistema(idactorSistema);
		Producto idproducto = productoFacadeEJB.find(bodegaDTO.getIdproductoDTO().getIdproducto());
		bodega.setIdproducto(idproducto);
		bodega.setCantidad(bodegaDTO.getCantidad());
		bodega.setFechaActual(Util.getDateFechaActualDDMMAAAA());
		bodega.setHoraActual(Util.getStringHoraActualHHMMSS());
		bodega.setTopeMax(bodegaDTO.getTopeMax());
		bodega.setTopeMinimo(bodegaDTO.getTopeMinimo());
		bodega.setObservaciones(bodegaDTO.getObservaciones());
		bodegaFacadeEJB.create(bodega);
	}
	
	public void editar(BodegaDTO bodegaDTO)throws Exception{
		
		validaCampoCantidad(bodegaDTO.getCantidad());
		validaCampoTopeMax(bodegaDTO.getTopeMax());
		validaCampoTopeMin(bodegaDTO.getTopeMinimo());
		
		Bodega bodega = bodegaFacadeEJB.find(bodegaDTO.getIdbodega());
		ActorSistema idactorSistema = actorSistemaFacadeEJB.find(bodegaDTO.getIdactorSistemaDTO().getIdactorSistema());
		bodega.setIdactorSistema(idactorSistema);
		Producto idproducto = productoFacadeEJB.find(bodegaDTO.getIdproductoDTO().getIdproducto());
		bodega.setIdproducto(idproducto);
		bodega.setCantidad(bodegaDTO.getCantidad());
		bodega.setFechaActual(Util.getDateFechaActualDDMMAAAA());
		bodega.setHoraActual(Util.getStringHoraActualHHMMSS());
		bodega.setTopeMax(bodegaDTO.getTopeMax());
		bodega.setTopeMinimo(bodegaDTO.getTopeMinimo());
		bodega.setObservaciones(bodegaDTO.getObservaciones());
		bodegaFacadeEJB.edit(bodega);
	}
	
	public void eliminar(BodegaDTO bodegaDTO)throws Exception{
		Bodega bodega = bodegaFacadeEJB.find(bodegaDTO.getIdbodega());		
		bodegaFacadeEJB.remove(bodega);
	}
	
	public BodegaDTO findId(Long idBodega)throws Exception{
		Bodega bodega = bodegaFacadeEJB.find(idBodega);
		return (BodegaDTO) converterEntityADTO(bodega);
	}
	public List<BodegaDTO> findAll()throws Exception{
		List<Bodega> bodegaList = bodegaFacadeEJB.findAll();
		List<BodegaDTO> bodegaListDTO = new ArrayList<BodegaDTO>();
		for(Bodega bodega : bodegaList){
			BodegaDTO bodegaDTO = (BodegaDTO) converterEntityADTO(bodega);
			bodegaListDTO.add(bodegaDTO);
		}
		return bodegaListDTO;
	}
	
	@Override
	public Object converterEntityADTO(Object object) throws Exception {
		Bodega bodega = (Bodega) object;
		
		List<FechaIn> fechaInList = bodega.getFechaInList();
		List<FechaInDTO> fechaInListDTO = new ArrayList<FechaInDTO>();
		for(FechaIn fechaIn : fechaInList){
			FechaInDTO fechaInDTO = (FechaInDTO) fechaInLogicEJB.converterEntityADTO(fechaIn);
			fechaInListDTO.add(fechaInDTO);
		}
		
		List<FechaOut> fechaOutList = bodega.getFechaOutList();
		List<FechaOutDTO> fechaOutListDTO = new ArrayList<FechaOutDTO>();
		for(FechaOut fechaOut : fechaOutList){
			FechaOutDTO fechaOutDTO = (FechaOutDTO) fechaOutLogicEJB.converterEntityADTO(fechaOut);
			fechaOutListDTO.add(fechaOutDTO);
		}
		
		ActorSistema idActorSistema = bodega.getIdactorSistema();
		ActorSistemaDTO idActorSistemaDTO = (ActorSistemaDTO) actorSistemaLogicEJB.converterEntityADTO(idActorSistema);
		
		Producto idProducto = bodega.getIdproducto();
		ProductoDTO idProductoDTO = (ProductoDTO) productoLogicEJB.converterEntityADTO(idProducto);
		
		BodegaDTO bodegaDTO = new BodegaDTO(bodega.getIdbodega(), bodega.getCantidad(), bodega.getFechaActual(), bodega.getHoraActual(), bodega.getTopeMax(), bodega.getTopeMinimo(), bodega.getObservaciones());
		bodegaDTO.setFechaInListDTO(fechaInListDTO);
		bodegaDTO.setFechaOutListDTO(fechaOutListDTO);
		bodegaDTO.setIdactorSistemaDTO(idActorSistemaDTO);
		bodegaDTO.setIdproductoDTO(idProductoDTO);
		
		return bodegaDTO;
	}

}
