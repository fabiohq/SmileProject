package co.com.smilepersistence.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.CreateException;

import co.com.remoteinterface.modelo.ActorSistemaDTO;
import co.com.remoteinterface.modelo.CampaniasPromocionalesDTO;
import co.com.remoteinterface.modelo.DetalleVentaDTO;
import co.com.remoteinterface.modelo.EncargoDTO;
import co.com.remoteinterface.modelo.ProductoDTO;
import co.com.smilepersistence.entity.ActorSistema;
import co.com.smilepersistence.entity.CampaniasPromocionales;
import co.com.smilepersistence.entity.DetalleVenta;
import co.com.smilepersistence.entity.Encargo;
import co.com.smilepersistence.entity.Producto;
import co.com.smilepersistence.interfacelocal.CampaniasPromocionalesLogicLocal;

public class CampaniasPromocionalesLogic extends AbstractInject implements CampaniasPromocionalesLogicLocal{

	
	public void crear(CampaniasPromocionalesDTO campaniasPromocionalesDTO)throws Exception{
	
		validaNombre(campaniasPromocionalesDTO.getNombre(), 5, 100);
		validaInteger(campaniasPromocionalesDTO.getDescuento(), "Descuento");
		validaFechaInicio(campaniasPromocionalesDTO.getFechaInicio());
		validaFechaFin(campaniasPromocionalesDTO.getFechaFin());
		
		CampaniasPromocionales campaniasPromocionales = new CampaniasPromocionales();
		ActorSistema idactorSistema = actorSistemaFacadeEJB.find(campaniasPromocionalesDTO.getIdactorSistemaDTO().getIdactorSistema());
		campaniasPromocionales.setIdactorSistema(idactorSistema);
		Producto idproducto = productoFacadeEJB.find(campaniasPromocionalesDTO.getIdproductoDTO().getIdproducto());
		campaniasPromocionales.setIdproducto(idproducto);
		campaniasPromocionales.setIdcampaniasPromocionales(1L);
		campaniasPromocionales.setNombre(campaniasPromocionalesDTO.getNombre());
		campaniasPromocionales.setDescuento(campaniasPromocionalesDTO.getDescuento());
		campaniasPromocionales.setFechaInicio(campaniasPromocionalesDTO.getFechaInicio());
		campaniasPromocionales.setFechaFin(campaniasPromocionales.getFechaFin());
		campaniasPromocionales.setDescripcion(campaniasPromocionales.getDescripcion());
		
		campaniasPromocionalesFacadeEJB.create(campaniasPromocionales);
	}

	public void editar(CampaniasPromocionalesDTO campaniasPromocionalesDTO)throws Exception{
		
		validaNombre(campaniasPromocionalesDTO.getNombre(), 5, 100);
		validaInteger(campaniasPromocionalesDTO.getDescuento(), "Descuento");
		validaFechaInicio(campaniasPromocionalesDTO.getFechaInicio());
		validaFechaFin(campaniasPromocionalesDTO.getFechaFin());
		
		CampaniasPromocionales campaniasPromocionales = campaniasPromocionalesFacadeEJB.find(campaniasPromocionalesDTO.getIdcampaniasPromocionales());
		ActorSistema idactorSistema = actorSistemaFacadeEJB.find(campaniasPromocionalesDTO.getIdactorSistemaDTO().getIdactorSistema());
		campaniasPromocionales.setIdactorSistema(idactorSistema);
		Producto idproducto = productoFacadeEJB.find(campaniasPromocionalesDTO.getIdproductoDTO().getIdproducto());
		campaniasPromocionales.setIdproducto(idproducto);
		campaniasPromocionales.setNombre(campaniasPromocionalesDTO.getNombre());
		campaniasPromocionales.setDescuento(campaniasPromocionalesDTO.getDescuento());
		campaniasPromocionales.setFechaInicio(campaniasPromocionalesDTO.getFechaInicio());
		campaniasPromocionales.setFechaFin(campaniasPromocionales.getFechaFin());
		campaniasPromocionales.setDescripcion(campaniasPromocionales.getDescripcion());
		
		campaniasPromocionalesFacadeEJB.edit(campaniasPromocionales);
	}
	
	public void eliminar(CampaniasPromocionalesDTO campaniasPromocionalesDTO)throws Exception{
		
		CampaniasPromocionales campaniasPromocionales = campaniasPromocionalesFacadeEJB.find(campaniasPromocionalesDTO.getIdcampaniasPromocionales());		
		campaniasPromocionalesFacadeEJB.remove(campaniasPromocionales);
	}
	
	public CampaniasPromocionalesDTO findId(Long idcampaniasPromocionales)throws Exception{		
		CampaniasPromocionales campaniasPromocionales = campaniasPromocionalesFacadeEJB.find(idcampaniasPromocionales); 
		return (CampaniasPromocionalesDTO)converterEntityADTO(campaniasPromocionales);
	}
	
	public List<CampaniasPromocionalesDTO> findIdAll()throws Exception{
		List<CampaniasPromocionales> campaniasPromocionalesList = campaniasPromocionalesFacadeEJB.findAll();
		List<CampaniasPromocionalesDTO> campaniasPromocionalesListDTO = new ArrayList<CampaniasPromocionalesDTO>();
		for(CampaniasPromocionales campaniasPromocionales : campaniasPromocionalesList){
			CampaniasPromocionalesDTO campaniasPromocionalesDTO = (CampaniasPromocionalesDTO) converterEntityADTO(campaniasPromocionales);
			campaniasPromocionalesListDTO.add(campaniasPromocionalesDTO);
		}
		return campaniasPromocionalesListDTO;
	}

	@Override
	public void validaNombre(String nombre, int minCaracteres, int maxCaracteres) throws Exception {
		super.validaNombre(nombre, minCaracteres, maxCaracteres);
	}
	
	@Override
	public void validaInteger(Integer obj, String campo) throws Exception, CreateException {
		// TODO Auto-generated method stub
		super.validaInteger(obj, campo);
	}
	
	@Override
	public void validaFechaInicio(Date obj) throws Exception, CreateException {
		// TODO Auto-generated method stub
		super.validaFechaInicio(obj);
	}
	
	@Override
	public void validaFechaFin(Date obj) throws Exception, CreateException {
		// TODO Auto-generated method stub
		super.validaFechaFin(obj);
	}
	
	@Override
	public Object converterEntityADTO(Object object) throws Exception{
		CampaniasPromocionales campaniasPromocionales = (CampaniasPromocionales)object;
		
		List<Encargo> encargoList = campaniasPromocionales.getEncargoList();
		List<EncargoDTO> encargoListDTO = new ArrayList<EncargoDTO>();
		for(Encargo encargo : encargoList){
			EncargoDTO encargoDTO =(EncargoDTO) encargoLogicEJB.converterEntityADTO(encargo);
			encargoListDTO.add(encargoDTO);
		}				
	    
		ActorSistemaDTO idactorSistemaDTO = (ActorSistemaDTO) actorSistemaLogicEJB.converterEntityADTO(campaniasPromocionales.getIdactorSistema());
	    
		ProductoDTO idproductoDTO = (ProductoDTO) productoLogicEJB.converterEntityADTO(campaniasPromocionales.getIdproducto());
	    
	    List<DetalleVenta> detalleVentaList = campaniasPromocionales.getDetalleVentaList();	
	    List<DetalleVentaDTO> detalleVentaListDTO = new ArrayList<DetalleVentaDTO>();
	    for(DetalleVenta detalleVenta : detalleVentaList){
	    	DetalleVentaDTO detalleVentaDTO = (DetalleVentaDTO) detalleVentaLogicEJB.converterEntityADTO(detalleVenta);
	    	detalleVentaListDTO.add(detalleVentaDTO);
	    }
		
	    CampaniasPromocionalesDTO campaniasPromocionalesDTO = new CampaniasPromocionalesDTO(campaniasPromocionales.getIdcampaniasPromocionales(), campaniasPromocionales.getNombre(), campaniasPromocionales.getDescuento(), campaniasPromocionales.getFechaInicio(), campaniasPromocionales.getFechaFin(), campaniasPromocionales.getDescripcion());
	    campaniasPromocionalesDTO.setEncargoListDTO(encargoListDTO);
	    campaniasPromocionalesDTO.setIdactorSistemaDTO(idactorSistemaDTO);
	    campaniasPromocionalesDTO.setIdproductoDTO(idproductoDTO);
	    campaniasPromocionalesDTO.setDetalleVentaListDTO(detalleVentaListDTO);
	    
	    return campaniasPromocionalesDTO;
	}

}
