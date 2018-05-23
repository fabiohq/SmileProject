package co.com.smilepersistence.logic;

import java.util.ArrayList;
import java.util.List;

import co.com.remoteinterface.modelo.EncargoDTO;
import co.com.remoteinterface.modelo.EstadoEntregaDTO;
import co.com.smilepersistence.entity.Encargo;
import co.com.smilepersistence.entity.EstadoEntrega;
import co.com.smilepersistence.interfacelocal.EstadoEntregaLogicLocal;

public class EstadoEntregaLogic extends AbstractInject implements EstadoEntregaLogicLocal{

	public void crear(EstadoEntregaDTO estadoEntregaDTO)throws Exception{
		
		validaNombre(estadoEntregaDTO.getNombre(), 5, 50);
		EstadoEntrega estadoEntrega = new EstadoEntrega();
		estadoEntrega.setIdestadoEntrega(1L);
		estadoEntrega.setNombre(estadoEntregaDTO.getNombre());
		estadoEntregaFacadeEJB.create(estadoEntrega);
	}
	
	public void editar(EstadoEntregaDTO estadoEntregaDTO)throws Exception{
		
		validaNombre(estadoEntregaDTO.getNombre(), 5, 50);
		EstadoEntrega estadoEntrega = estadoEntregaFacadeEJB.find(estadoEntregaDTO.getIdestadoEntrega());
		estadoEntrega.setNombre(estadoEntregaDTO.getNombre());
		estadoEntregaFacadeEJB.edit(estadoEntrega);
	}
	
	public void eliminar(EstadoEntregaDTO estadoEntregaDTO) throws Exception{
		EstadoEntrega estadoEntrega = estadoEntregaFacadeEJB.find(estadoEntregaDTO.getIdestadoEntrega());
		estadoEntregaFacadeEJB.remove(estadoEntrega);
	}
	
	public EstadoEntregaDTO findId(Long idEstadoEntrega)throws Exception{
		
		EstadoEntrega estadoEntrega = estadoEntregaFacadeEJB.find(idEstadoEntrega);
		return (EstadoEntregaDTO) converterEntityADTO(estadoEntrega);
	}
	
	public List<EstadoEntregaDTO> findAll() throws Exception{
		
		List<EstadoEntrega> estadoEntregaList = estadoEntregaFacadeEJB.findAll();
		List<EstadoEntregaDTO> estadoEntregaListDTO = new ArrayList<EstadoEntregaDTO>();
		for(EstadoEntrega estadoEntrega : estadoEntregaList){
			EstadoEntregaDTO estadoEntregaDTO= (EstadoEntregaDTO) converterEntityADTO(estadoEntrega);
			estadoEntregaListDTO.add(estadoEntregaDTO);
		}
		return estadoEntregaListDTO;
	}
	@Override
	public Object converterEntityADTO(Object object) throws Exception {
		EstadoEntrega estadoEntrega = (EstadoEntrega) object;
		List<Encargo> encargoList = estadoEntrega.getEncargoList();
		List<EncargoDTO> encargoListDTO = new ArrayList<EncargoDTO>();
		for(Encargo encargo : encargoList){
			EncargoDTO encargoDTO =(EncargoDTO) encargoLogicEJB.converterEntityADTO(encargo);
			encargoListDTO.add(encargoDTO);
		}
		
		EstadoEntregaDTO estadoEntregaDTO = new EstadoEntregaDTO(estadoEntrega.getIdestadoEntrega(), estadoEntrega.getNombre());
		estadoEntregaDTO.setEncargoList(encargoListDTO);
		return estadoEntregaDTO;
	}

}
