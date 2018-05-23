package co.com.smilepersistence.logic;

import java.util.ArrayList;
import java.util.List;

import co.com.remoteinterface.modelo.ActorSistemaDTO;
import co.com.remoteinterface.modelo.CampaniasPromocionalesDTO;
import co.com.remoteinterface.modelo.DetalleVentaDTO;
import co.com.remoteinterface.modelo.DocumentoDTO;
import co.com.remoteinterface.modelo.ProductoDTO;
import co.com.smilepersistence.entity.ActorSistema;
import co.com.smilepersistence.entity.CampaniasPromocionales;
import co.com.smilepersistence.entity.DetalleVenta;
import co.com.smilepersistence.entity.Documento;
import co.com.smilepersistence.entity.Producto;
import co.com.smilepersistence.interfacelocal.DetalleVentaLogicLocal;
import co.com.smilepersistence.utilidades.Util;

public class DetalleVentaLogic extends AbstractInject implements DetalleVentaLogicLocal {

	public void crear(DetalleVentaDTO detalleVentaDTO)throws Exception{
	
		DetalleVenta detalleVenta = new DetalleVenta();
		detalleVenta.setIddetalleVenta(1L);
		detalleVenta.setReferenciaVenta(detalleVentaDTO.getReferenciaVenta());
		detalleVenta.setFechaActual(Util.getDateFechaActualDDMMAAAA());
		detalleVenta.setHoraActual(Util.getStringHoraActualHHMMSS());
		detalleVenta.setValorProducto(detalleVentaDTO.getValorProducto());
		detalleVenta.setDescuentoPreferencial(detalleVentaDTO.getDescuentoPreferencial());
		detalleVenta.setObservacion(detalleVentaDTO.getObservacion());
		ActorSistema idactorSistema = actorSistemaFacadeEJB.find(detalleVentaDTO.getIdactorSistemaDTO().getIdactorSistema());
		detalleVenta.setIdactorSistema(idactorSistema);
		CampaniasPromocionales idcampaniasPromocionales = campaniasPromocionalesFacadeEJB.find(detalleVentaDTO.getIdcampaniasPromocionalesDTO().getIdcampaniasPromocionales());
		detalleVenta.setIdcampaniasPromocionales(idcampaniasPromocionales);
		Documento iddocumento = documentoFacadeEJB.find(detalleVentaDTO.getIddocumentoDTO().getIddocumento());
		detalleVenta.setIddocumento(iddocumento);
		Producto idproducto = productoFacadeEJB.find(detalleVentaDTO.getIdproductoDTO().getIdproducto());
		detalleVenta.setIdproducto(idproducto);
		detalleVentaFacadeEJB.create(detalleVenta);
	}
	
	public void editar(DetalleVentaDTO detalleVentaDTO)throws Exception{
		
		DetalleVenta detalleVenta = detalleVentaFacadeEJB.find(detalleVentaDTO.getIddetalleVenta());
		detalleVenta.setReferenciaVenta(detalleVentaDTO.getReferenciaVenta());
		detalleVenta.setFechaActual(Util.getDateFechaActualDDMMAAAA());
		detalleVenta.setHoraActual(Util.getStringHoraActualHHMMSS());
		detalleVenta.setValorProducto(detalleVentaDTO.getValorProducto());
		detalleVenta.setDescuentoPreferencial(detalleVentaDTO.getDescuentoPreferencial());
		detalleVenta.setObservacion(detalleVentaDTO.getObservacion());
		ActorSistema idactorSistema = actorSistemaFacadeEJB.find(detalleVentaDTO.getIdactorSistemaDTO().getIdactorSistema());
		detalleVenta.setIdactorSistema(idactorSistema);
		CampaniasPromocionales idcampaniasPromocionales = campaniasPromocionalesFacadeEJB.find(detalleVentaDTO.getIdcampaniasPromocionalesDTO().getIdcampaniasPromocionales());
		detalleVenta.setIdcampaniasPromocionales(idcampaniasPromocionales);
		Documento iddocumento = documentoFacadeEJB.find(detalleVentaDTO.getIddocumentoDTO().getIddocumento());
		detalleVenta.setIddocumento(iddocumento);
		Producto idproducto = productoFacadeEJB.find(detalleVentaDTO.getIdproductoDTO().getIdproducto());
		detalleVenta.setIdproducto(idproducto);
		detalleVentaFacadeEJB.edit(detalleVenta);
	}
	
	public void eliminar(DetalleVentaDTO detalleVentaDTO)throws Exception{
		
		DetalleVenta detalleVenta = detalleVentaFacadeEJB.find(detalleVentaDTO.getIddetalleVenta());		
		detalleVentaFacadeEJB.remove(detalleVenta);
	}
	
	public DetalleVentaDTO findId(Long idDetalleVenta)throws Exception{
		
		DetalleVenta detalleVenta = detalleVentaFacadeEJB.find(idDetalleVenta);		
		return (DetalleVentaDTO) converterEntityADTO(detalleVenta);
	}
	
	public List<DetalleVentaDTO> findAll()throws Exception{
		
		List<DetalleVenta> detalleVentaList = detalleVentaFacadeEJB.findAll();
		List<DetalleVentaDTO> detalleVentaListDTO = new ArrayList<DetalleVentaDTO>();
		for(DetalleVenta detalleVenta : detalleVentaList){
			DetalleVentaDTO detalleVentaDTO = (DetalleVentaDTO)converterEntityADTO(detalleVenta);
			detalleVentaListDTO.add(detalleVentaDTO);			
		}
		return detalleVentaListDTO;
	}
	
	@Override
	public Object converterEntityADTO(Object object) throws Exception {
		DetalleVenta detalleVenta =(DetalleVenta) object;
		
		ActorSistemaDTO idactorSistemaDTO =(ActorSistemaDTO) actorSistemaLogicEJB.converterEntityADTO(detalleVenta.getIdactorSistema());		
		CampaniasPromocionalesDTO idcampaniasPromocionalesDTO =(CampaniasPromocionalesDTO) campaniasPromocionalesLogicEJB.converterEntityADTO(detalleVenta.getIdcampaniasPromocionales());		
		DocumentoDTO iddocumentoDTO =(DocumentoDTO) documentoLogicEJB.converterEntityADTO(detalleVenta.getIddocumento());		
		ProductoDTO idproductoDTO = (ProductoDTO) productoLogicEJB.converterEntityADTO(detalleVenta.getIdproducto());
		
		DetalleVentaDTO detalleVentaDTO = new DetalleVentaDTO(detalleVenta.getIddetalleVenta(), detalleVenta.getReferenciaVenta(), detalleVenta.getFechaActual(), detalleVenta.getHoraActual(), detalleVenta.getValorProducto(), detalleVenta.getDescuentoPreferencial(), detalleVenta.getObservacion());
		detalleVentaDTO.setIdactorSistemaDTO(idactorSistemaDTO);
		detalleVentaDTO.setIdcampaniasPromocionalesDTO(idcampaniasPromocionalesDTO);
		detalleVentaDTO.setIddocumentoDTO(iddocumentoDTO);
		detalleVentaDTO.setIdproductoDTO(idproductoDTO);
		return detalleVentaDTO;
	}

}
