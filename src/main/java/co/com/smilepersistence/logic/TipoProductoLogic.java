package co.com.smilepersistence.logic;

import java.util.ArrayList;
import java.util.List;

import co.com.remoteinterface.modelo.ProductoDTO;
import co.com.remoteinterface.modelo.TipoProductoDTO;
import co.com.smilepersistence.entity.Producto;
import co.com.smilepersistence.entity.TipoProducto;
import co.com.smilepersistence.interfacelocal.TipoProductoLogicLocal;

public class TipoProductoLogic extends AbstractInject implements TipoProductoLogicLocal{

	public void crear(TipoProductoDTO tipoProductoDTO) throws Exception{
		
		validaNombre(tipoProductoDTO.getNombre(), 5, 100);
		TipoProducto tipoProducto = new TipoProducto();
		tipoProducto.setIdtipoProducto(1L);
		tipoProducto.setNombre(tipoProductoDTO.getNombre());
		tipoProducto.setDescripcion(tipoProductoDTO.getDescripcion());
		
		tipoProductoFacadeEJB.create(tipoProducto);
	}
	
	public void editar(TipoProductoDTO tipoProductoDTO) throws Exception{
		
		validaNombre(tipoProductoDTO.getNombre(), 5, 100);
		TipoProducto tipoProducto = tipoProductoFacadeEJB.find(tipoProductoDTO.getIdtipoProducto());
		tipoProducto.setNombre(tipoProductoDTO.getNombre());
		tipoProducto.setDescripcion(tipoProductoDTO.getDescripcion());
		
		tipoProductoFacadeEJB.edit(tipoProducto);
	}
	
	public void eliminar(TipoProductoDTO tipoProductoDTO) throws Exception{
		
		TipoProducto tipoProducto = tipoProductoFacadeEJB.find(tipoProductoDTO.getIdtipoProducto());		
		tipoProductoFacadeEJB.edit(tipoProducto);
	}

	public TipoProductoDTO findId(Long idTipoProducto)throws Exception{
		
		TipoProducto tipoProducto = tipoProductoFacadeEJB.find(idTipoProducto);
		return (TipoProductoDTO) converterEntityADTO(tipoProducto);
	}
	
	public List<TipoProductoDTO> findAll() throws Exception{
		
		List<TipoProducto> tipoProductoList = tipoProductoFacadeEJB.findAll();
		List<TipoProductoDTO> tipoProductoListDTO = new ArrayList<TipoProductoDTO>();
		for(TipoProducto tipoProducto : tipoProductoList){
			TipoProductoDTO tipoProductoDTO = (TipoProductoDTO) converterEntityADTO(tipoProducto);
			tipoProductoListDTO.add(tipoProductoDTO);
		}
		return tipoProductoListDTO;
	}
	
	@Override
	public void validaNombre(String nombre, int minCaracteres, int maxCaracteres) throws Exception {
		super.validaNombre(nombre, minCaracteres, maxCaracteres);
	}
	@Override
	public Object converterEntityADTO(Object object) throws Exception {
		TipoProducto tipoProducto = (TipoProducto) object;
		List<Producto> productoList = tipoProducto.getProductoList();
		List<ProductoDTO> productoListDTO = new ArrayList<ProductoDTO>();
		for(Producto producto : productoList){
			ProductoDTO productoDTO =(ProductoDTO) productoLogicEJB.converterEntityADTO(producto);
			productoListDTO.add(productoDTO);
		}
		
		TipoProductoDTO tipoProductoDTO = new TipoProductoDTO(tipoProducto.getIdtipoProducto(), tipoProducto.getNombre(), tipoProducto.getDescripcion());
		tipoProductoDTO.setProductoListDTO(productoListDTO);;
		return tipoProductoDTO;
	}

}
