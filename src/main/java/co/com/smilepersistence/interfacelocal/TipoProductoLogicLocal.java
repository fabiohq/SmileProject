package co.com.smilepersistence.interfacelocal;

import java.util.List;

import co.com.remoteinterface.modelo.TipoProductoDTO;

public interface TipoProductoLogicLocal {
	
	public void crear(TipoProductoDTO tipoProductoDTO) throws Exception;
	public void editar(TipoProductoDTO tipoProductoDTO) throws Exception;
	public void eliminar(TipoProductoDTO tipoProductoDTO) throws Exception;
	public TipoProductoDTO findId(Long idTipoProducto)throws Exception;
	public List<TipoProductoDTO> findAll() throws Exception;
	public Object converterEntityADTO(Object object) throws Exception;

}
