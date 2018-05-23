package co.com.smilepersistence.interfacelocal;

import java.util.List;

import co.com.remoteinterface.modelo.ProductoDTO;

public interface ProductoLogicLocal {
	
	public void crear(ProductoDTO productoDTO)throws Exception;
	public void editar(ProductoDTO productoDTO)throws Exception;
	public void eliminar(ProductoDTO productoDTO)throws Exception;
	public ProductoDTO findId(Long idProducto)throws Exception;
	public List<ProductoDTO> findAll()throws Exception;
	public Object converterEntityADTO(Object object) throws Exception;

}
