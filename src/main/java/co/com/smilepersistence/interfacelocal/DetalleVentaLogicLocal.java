package co.com.smilepersistence.interfacelocal;

import java.util.List;

import co.com.remoteinterface.modelo.DetalleVentaDTO;

public interface DetalleVentaLogicLocal {

	public void crear(DetalleVentaDTO detalleVentaDTO)throws Exception;
	public void editar(DetalleVentaDTO detalleVentaDTO)throws Exception;
	public void eliminar(DetalleVentaDTO detalleVentaDTO)throws Exception;
	public DetalleVentaDTO findId(Long idDetalleVenta)throws Exception;
	public List<DetalleVentaDTO> findAll()throws Exception;
	public Object converterEntityADTO(Object object) throws Exception;
}
