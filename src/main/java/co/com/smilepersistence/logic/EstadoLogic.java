package co.com.smilepersistence.logic;

import java.util.ArrayList;
import java.util.List;

import co.com.remoteinterface.modelo.ActorSistemaDTO;
import co.com.remoteinterface.modelo.EstadoDTO;
import co.com.smilepersistence.entity.ActorSistema;
import co.com.smilepersistence.entity.Estado;
import co.com.smilepersistence.interfacelocal.EstadoLogicLocal;

public class EstadoLogic extends AbstractInject implements EstadoLogicLocal{

	public void crear(EstadoDTO estadoDTO) throws Exception{
		validaNumDocumento(estadoDTO.getNombre(), 6, 100);
		
		Estado estado = new Estado();
		estado.setIdestado(1L);
		estado.setNombre(estadoDTO.getNombre());
		estado.setObservacion(estadoDTO.getObservacion());
		
		estadoFacadeEJB.create(estado);
	}
	
	public void editar(EstadoDTO estadoDTO) throws Exception{
		validaNumDocumento(estadoDTO.getNombre(), 6, 100);
		
		Estado estado = estadoFacadeEJB.find(estadoDTO.getIdestado());
		estado.setNombre(estadoDTO.getNombre());
		estado.setObservacion(estadoDTO.getObservacion());
		
		estadoFacadeEJB.create(estado);
	}
	
	public void eliminar(EstadoDTO estadoDTO) throws Exception{
		
		Estado estado = estadoFacadeEJB.find(estadoDTO.getIdestado());
		estadoFacadeEJB.create(estado);
	}
	
	public EstadoDTO findId(Long idEstado) throws Exception{
		
		Estado estado = estadoFacadeEJB.find(idEstado);
		return (EstadoDTO)converterEntityADTO(estado);		
	}
	
	public List<EstadoDTO> findAll() throws Exception{
		
		List<Estado> estadoList = estadoFacadeEJB.findAll();
		List<EstadoDTO> estadoListDTO = new ArrayList<EstadoDTO>();
		for(Estado estado : estadoList){
			EstadoDTO estadoDTO = (EstadoDTO)converterEntityADTO(estado);
			estadoListDTO.add(estadoDTO);
		}
		return estadoListDTO;
		
	}
	
	@Override
	public void validaNombre(String nombre, int minCaracteres, int maxCaracteres) throws Exception {
		super.validaNombre(nombre, minCaracteres, maxCaracteres);
	}
	
	/*public EstadoDTO converterEntityEstadoADTO(Estado estado) throws Exception{
		
		List<ActorSistema> actorSistemaList = estado.getActorSistemaList();
		List<ActorSistemaDTO> actorSistemaListDTO = new ArrayList<ActorSistemaDTO>();
		for(ActorSistema actorSistema : actorSistemaList){
			ActorSistemaDTO actorSistemaDTO = converterEntityActorSystemaADTO(actorSistema);
			actorSistemaListDTO.add(actorSistemaDTO);
		}
		EstadoDTO estadoDTO = new EstadoDTO(estado.getIdestado(), estado.getNombre(), estado.getObservacion());
		estadoDTO.setActorSistemaListDTO(actorSistemaListDTO);
		
		return estadoDTO;
	}*/

	@Override
	public Object converterEntityADTO(Object object) throws Exception {
		
		Estado estado =(Estado) object;
		
		List<ActorSistema> actorSistemaList = estado.getActorSistemaList();
		List<ActorSistemaDTO> actorSistemaListDTO = new ArrayList<ActorSistemaDTO>();
		for(ActorSistema actorSistema : actorSistemaList){
			ActorSistemaDTO actorSistemaDTO = (ActorSistemaDTO) actorSistemaLogicEJB.converterEntityADTO(actorSistema);
			actorSistemaListDTO.add(actorSistemaDTO);
		}
		EstadoDTO estadoDTO = new EstadoDTO(estado.getIdestado(), estado.getNombre(), estado.getObservacion());
		estadoDTO.setActorSistemaListDTO(actorSistemaListDTO);
		
		return estadoDTO;
	}
}
