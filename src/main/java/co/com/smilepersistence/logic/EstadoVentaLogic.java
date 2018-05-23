package co.com.smilepersistence.logic;

import java.util.ArrayList;
import java.util.List;

import co.com.remoteinterface.modelo.EstadoVentaDTO;
import co.com.remoteinterface.modelo.VentaPendienteDTO;
import co.com.smilepersistence.entity.EstadoVenta;
import co.com.smilepersistence.entity.VentaPendiente;
import co.com.smilepersistence.interfacelocal.EstadoVentaLogicLocal;

public class EstadoVentaLogic extends AbstractInject implements EstadoVentaLogicLocal{

	public void crear(EstadoVentaDTO estadoVentaDTO) throws Exception{
		
		validaNombre(estadoVentaDTO.getNombre(), 5, 50);
		
		EstadoVenta estadoVenta = new EstadoVenta();
		estadoVenta.setIdestadoVenta(1L);
		estadoVenta.setNombre(estadoVentaDTO.getNombre());
		estadoVentaFacadeEJB.create(estadoVenta);
	}
	
	public void editar(EstadoVentaDTO estadoVentaDTO) throws Exception{
		
		validaNombre(estadoVentaDTO.getNombre(), 5, 50);
		
		EstadoVenta estadoVenta = estadoVentaFacadeEJB.find(estadoVentaDTO.getIdestadoVenta());
		estadoVenta.setNombre(estadoVentaDTO.getNombre());
		estadoVentaFacadeEJB.edit(estadoVenta);
	}
	
	public void eliminar(EstadoVenta estadoVentaDTO)throws Exception{
		
		EstadoVenta estadoVenta = estadoVentaFacadeEJB.find(estadoVentaDTO.getIdestadoVenta());
		estadoVentaFacadeEJB.remove(estadoVenta);
	}
	
	public EstadoVentaDTO findId(Long idEstadoVenta)throws Exception{
		EstadoVenta estadoVenta = estadoVentaFacadeEJB.find(idEstadoVenta);
		return (EstadoVentaDTO) converterEntityADTO(estadoVenta);
	}
	
	public List<EstadoVentaDTO> findAll() throws Exception{
		List<EstadoVenta> estadoVentaList = estadoVentaFacadeEJB.findAll();
		List<EstadoVentaDTO> estadoVentaListDTO = new ArrayList<EstadoVentaDTO>();
		for(EstadoVenta estadoVenta : estadoVentaList){
			EstadoVentaDTO estadoVentaDTO = (EstadoVentaDTO) converterEntityADTO(estadoVenta);
			estadoVentaListDTO.add(estadoVentaDTO);			
		}
		return estadoVentaListDTO;
	}
	
	@Override
	public Object converterEntityADTO(Object object) throws Exception {
		EstadoVenta estadoVenta = (EstadoVenta) object;
		List<VentaPendiente> ventaPendienteList = estadoVenta.getVentaPendienteList();
		List<VentaPendienteDTO> ventaPendienteListDTO = new ArrayList<VentaPendienteDTO>();
		for(VentaPendiente ventaPendiente : ventaPendienteList){
			VentaPendienteDTO ventaPendienteDTO = (VentaPendienteDTO) ventaPendienteLogicEJB.converterEntityADTO(ventaPendiente);
			ventaPendienteListDTO.add(ventaPendienteDTO);
		}
		EstadoVentaDTO estadoVentaDTO = new EstadoVentaDTO(estadoVenta.getIdestadoVenta(), estadoVenta.getNombre());
		estadoVentaDTO.setVentaPendienteListDTO(ventaPendienteListDTO);
		return estadoVentaDTO;
	}

}
