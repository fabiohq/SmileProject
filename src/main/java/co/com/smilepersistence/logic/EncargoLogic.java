package co.com.smilepersistence.logic;

import java.util.ArrayList;
import java.util.List;

import co.com.remoteinterface.modelo.ActorSistemaDTO;
import co.com.remoteinterface.modelo.CampaniasPromocionalesDTO;
import co.com.remoteinterface.modelo.DocumentoDTO;
import co.com.remoteinterface.modelo.EncargoDTO;
import co.com.remoteinterface.modelo.EstadoEntregaDTO;
import co.com.remoteinterface.modelo.ProductoDTO;
import co.com.smilepersistence.entity.ActorSistema;
import co.com.smilepersistence.entity.CampaniasPromocionales;
import co.com.smilepersistence.entity.Documento;
import co.com.smilepersistence.entity.Encargo;
import co.com.smilepersistence.entity.EstadoEntrega;
import co.com.smilepersistence.entity.Producto;
import co.com.smilepersistence.interfacelocal.EncargoLogicLocal;
import co.com.smilepersistence.utilidades.Util;

public class EncargoLogic extends AbstractInject implements EncargoLogicLocal {

	public void crear(EncargoDTO encargoDTO)throws Exception{
		
		Encargo encargo = new Encargo();
		encargo.setIdencargo(1L);
		encargo.setFechaActual(Util.getDateFechaActualDDMMAAAA());
		encargo.setHoraActual(Util.getStringHoraActualHHMMSS());
		encargo.setValorProducto(encargoDTO.getValorProducto());
		encargo.setDescuentoPreferencial(encargoDTO.getDescuentoPreferencial());
		encargo.setObservacion(encargoDTO.getObservacion());
		ActorSistema idactorSistema = actorSistemaFacadeEJB.find(encargo.getIdactorSistema().getIdactorSistema());
		encargo.setIdactorSistema(idactorSistema);
		CampaniasPromocionales idcampaniasPromocionales = campaniasPromocionalesFacadeEJB.find(encargo.getIdcampaniasPromocionales().getIdcampaniasPromocionales());
		encargo.setIdcampaniasPromocionales(idcampaniasPromocionales);
		Documento iddocumento = documentoFacadeEJB.find(encargo.getIddocumento().getIddocumento());
		encargo.setIddocumento(iddocumento);
		EstadoEntrega idestadoEntrega = estadoEntregaFacadeEJB.find(encargo.getIdestadoEntrega().getIdestadoEntrega());
		encargo.setIdestadoEntrega(idestadoEntrega);
		Producto idproducto = productoFacadeEJB.find(encargo.getIdproducto().getIdproducto());
		encargo.setIdproducto(idproducto);
		encargoFacadeEJB.create(encargo);
		
	}
	
	public void editar(EncargoDTO encargoDTO)throws Exception{
		
		Encargo encargo = encargoFacadeEJB.find(encargoDTO.getIdencargo());
		encargo.setFechaActual(Util.getDateFechaActualDDMMAAAA());
		encargo.setHoraActual(Util.getStringHoraActualHHMMSS());
		encargo.setValorProducto(encargoDTO.getValorProducto());
		encargo.setDescuentoPreferencial(encargoDTO.getDescuentoPreferencial());
		encargo.setObservacion(encargoDTO.getObservacion());
		ActorSistema idactorSistema = actorSistemaFacadeEJB.find(encargo.getIdactorSistema().getIdactorSistema());
		encargo.setIdactorSistema(idactorSistema);
		CampaniasPromocionales idcampaniasPromocionales = campaniasPromocionalesFacadeEJB.find(encargo.getIdcampaniasPromocionales().getIdcampaniasPromocionales());
		encargo.setIdcampaniasPromocionales(idcampaniasPromocionales);
		Documento iddocumento = documentoFacadeEJB.find(encargo.getIddocumento().getIddocumento());
		encargo.setIddocumento(iddocumento);
		EstadoEntrega idestadoEntrega = estadoEntregaFacadeEJB.find(encargo.getIdestadoEntrega().getIdestadoEntrega());
		encargo.setIdestadoEntrega(idestadoEntrega);
		Producto idproducto = productoFacadeEJB.find(encargo.getIdproducto().getIdproducto());
		encargo.setIdproducto(idproducto);
		encargoFacadeEJB.edit(encargo);
		
	}
	
	public void eliminar(EncargoDTO encargoDTO)throws Exception{
		
		Encargo encargo = encargoFacadeEJB.find(encargoDTO.getIdencargo());		
		encargoFacadeEJB.remove(encargo);		
	}
	
	public EncargoDTO findId(EncargoDTO encargoDTO)throws Exception{
		Encargo encargo = encargoFacadeEJB.find(encargoDTO.getIdencargo());
		return (EncargoDTO) converterEntityADTO(encargo);
	}
	
	public List<EncargoDTO> findAll()throws Exception{
		List<Encargo> encargoList = encargoFacadeEJB.findAll();
		List<EncargoDTO> encargoListDTO = new ArrayList<EncargoDTO>();
		for(Encargo encargo : encargoList){
			EncargoDTO encargoDTO = (EncargoDTO) converterEntityADTO(encargo);
			encargoListDTO.add(encargoDTO);
		}
		return encargoListDTO;
	}
	
	@Override
	public Object converterEntityADTO(Object object) throws Exception {
		Encargo encargo = (Encargo) object;		
		ActorSistemaDTO idactorSistemaDTO = (ActorSistemaDTO)actorSistemaLogicEJB.converterEntityADTO(encargo.getIdactorSistema());		
		CampaniasPromocionalesDTO idcampaniasPromocionalesDTO = (CampaniasPromocionalesDTO)campaniasPromocionalesLogicEJB.converterEntityADTO(encargo.getIdcampaniasPromocionales());		
		DocumentoDTO iddocumentoDTO = (DocumentoDTO) documentoLogicEJB.converterEntityADTO(encargo.getIddocumento());		
		EstadoEntregaDTO idestadoEntregaDTO = (EstadoEntregaDTO)estadoEntregaLogicEJB.converterEntityADTO(encargo.getIdestadoEntrega());		
		ProductoDTO idproductoDTO = (ProductoDTO) productoLogicEJB.converterEntityADTO(encargo.getIdproducto());
		EncargoDTO encargoDTO = new EncargoDTO(encargo.getIdencargo(), encargo.getFechaActual(), encargo.getHoraActual(), encargo.getValorProducto(), encargo.getDescuentoPreferencial(), encargo.getObservacion());
		encargoDTO.setIdactorSistemaDTO(idactorSistemaDTO);
		encargoDTO.setIdcampaniasPromocionalesDTO(idcampaniasPromocionalesDTO);
		encargoDTO.setIddocumentoDTO(iddocumentoDTO);
		encargoDTO.setIdestadoEntregaDTO(idestadoEntregaDTO);
		encargoDTO.setIdproductoDTO(idproductoDTO);
		return encargoDTO;
	}

}
