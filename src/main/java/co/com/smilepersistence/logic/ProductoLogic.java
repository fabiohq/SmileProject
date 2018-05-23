package co.com.smilepersistence.logic;

import java.util.ArrayList;
import java.util.List;

import co.com.remoteinterface.modelo.BodegaDTO;
import co.com.remoteinterface.modelo.CampaniasPromocionalesDTO;
import co.com.remoteinterface.modelo.DetalleVentaDTO;
import co.com.remoteinterface.modelo.EncargoDTO;
import co.com.remoteinterface.modelo.ProductoDTO;
import co.com.remoteinterface.modelo.TipoProductoDTO;
import co.com.smilepersistence.entity.Bodega;
import co.com.smilepersistence.entity.CampaniasPromocionales;
import co.com.smilepersistence.entity.DetalleVenta;
import co.com.smilepersistence.entity.Encargo;
import co.com.smilepersistence.entity.Producto;
import co.com.smilepersistence.entity.TipoProducto;
import co.com.smilepersistence.interfacelocal.ProductoLogicLocal;
import co.com.smilepersistence.utilidades.Util;

public class ProductoLogic extends AbstractInject implements ProductoLogicLocal{

	public void crear(ProductoDTO productoDTO)throws Exception{
		
		validaCampoValor(productoDTO.getValor());
		validaCampoNombre(productoDTO.getNombre(), 5, 50);
		
		Producto producto = new Producto();
		producto.setIdproducto(1L);
		TipoProducto idtipoProducto = tipoProductoFacadeEJB.find(productoDTO.getIdtipoProductoDTO().getIdtipoProducto());
		producto.setIdtipoProducto(idtipoProducto);
		producto.setNombre(productoDTO.getNombre());
		producto.setDescripcion(productoDTO.getDescripcion());
		producto.setValor(productoDTO.getValor());
		producto.setFechaLote(productoDTO.getFechaLote());
		producto.setFechaRegistro(Util.getDateFechaActualDDMMAAAA());
		productoFacadeEJB.create(producto);
	}
	
	public void editar(ProductoDTO productoDTO)throws Exception{
		
		validaCampoValor(productoDTO.getValor());
		validaCampoNombre(productoDTO.getNombre(), 5, 50);
		
		Producto producto = productoFacadeEJB.find(productoDTO.getIdproducto());
		TipoProducto idtipoProducto = tipoProductoFacadeEJB.find(productoDTO.getIdtipoProductoDTO().getIdtipoProducto());
		producto.setIdtipoProducto(idtipoProducto);
		producto.setNombre(productoDTO.getNombre());
		producto.setDescripcion(productoDTO.getDescripcion());
		producto.setValor(productoDTO.getValor());
		producto.setFechaLote(productoDTO.getFechaLote());
		producto.setFechaRegistro(Util.getDateFechaActualDDMMAAAA());
		productoFacadeEJB.edit(producto);
	}
	
	public void eliminar(ProductoDTO productoDTO)throws Exception{
		
		Producto producto = productoFacadeEJB.find(productoDTO.getIdproducto());		
		productoFacadeEJB.edit(producto);
	}
	
	public ProductoDTO findId(Long idProducto)throws Exception{
		
		Producto producto = productoFacadeEJB.find(idProducto);
		return (ProductoDTO) converterEntityADTO(producto);
	}
	
	public List<ProductoDTO> findAll()throws Exception{
		
		List<Producto> productoList = productoFacadeEJB.findAll();
		List<ProductoDTO> productoListDTO = new ArrayList<ProductoDTO>();
		for(Producto producto : productoList){
			ProductoDTO productoDTO = (ProductoDTO) converterEntityADTO(producto);
			productoListDTO.add(productoDTO);
		}
		return productoListDTO;
	}
	
	@Override
	public Object converterEntityADTO(Object object) throws Exception {

		Producto producto = (Producto) object;
		
		TipoProducto idTipoProducto = producto.getIdtipoProducto();
		TipoProductoDTO idTipoProductoDTO = (TipoProductoDTO) tipoProductoLogicEJB.converterEntityADTO(idTipoProducto);
		
		List<Encargo> encargoList = producto.getEncargoList();
		List<EncargoDTO> encargoListDTO = new ArrayList<EncargoDTO>();
		for(Encargo encargo : encargoList){
			EncargoDTO encargoDTO = (EncargoDTO) encargoLogicEJB.converterEntityADTO(encargo);
			encargoListDTO.add(encargoDTO);
		}
		
		List<CampaniasPromocionales> campaniasPromocionalesList = producto.getCampaniasPromocionalesList();
		List<CampaniasPromocionalesDTO> campaniasPromocionalesListDTO = new ArrayList<CampaniasPromocionalesDTO>();
		for(CampaniasPromocionales campaniasPromocionales : campaniasPromocionalesList){
			CampaniasPromocionalesDTO campaniasPromocionalesDTO = (CampaniasPromocionalesDTO)campaniasPromocionalesLogicEJB.converterEntityADTO(campaniasPromocionales);
			campaniasPromocionalesListDTO.add(campaniasPromocionalesDTO);
		}
		
		List<Bodega> bodegaList = producto.getBodegaList();
		List<BodegaDTO> bodegaListDTO = new ArrayList<BodegaDTO>();
		for(Bodega bodega : bodegaList){
			BodegaDTO bodegaDTO = (BodegaDTO) bodegaLogicEJB.converterEntityADTO(bodega);
			bodegaListDTO.add(bodegaDTO);
		}
		
		List<DetalleVenta> detalleVentaList = producto.getDetalleVentaList();
		List<DetalleVentaDTO> detalleVentaListDTO = new ArrayList<DetalleVentaDTO>();
		for(DetalleVenta detalleVenta : detalleVentaList){
			DetalleVentaDTO detalleVentaDTO = (DetalleVentaDTO) detalleVentaLogicEJB.converterEntityADTO(detalleVenta);
			detalleVentaListDTO.add(detalleVentaDTO);
		}
		
		ProductoDTO productoDTO = new ProductoDTO(producto.getIdproducto(), producto.getNombre(), producto.getDescripcion(), producto.getValor(), producto.getFechaLote(), producto.getFechaRegistro());
		productoDTO.setIdtipoProductoDTO(idTipoProductoDTO);
		productoDTO.setEncargoListDTO(encargoListDTO);
		productoDTO.setCampaniasPromocionalesListDTO(campaniasPromocionalesListDTO);
		productoDTO.setBodegaListDTO(bodegaListDTO);
		productoDTO.setDetalleVentaListDTO(detalleVentaListDTO);
		return productoDTO;
	}

}
