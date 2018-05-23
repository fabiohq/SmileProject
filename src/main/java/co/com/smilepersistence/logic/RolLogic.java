package co.com.smilepersistence.logic;

import java.util.ArrayList;
import java.util.List;

import co.com.remoteinterface.modelo.ActorSistemaDTO;
import co.com.remoteinterface.modelo.RolDTO;
import co.com.smilepersistence.entity.ActorSistema;
import co.com.smilepersistence.entity.Rol;
import co.com.smilepersistence.interfacelocal.RolLogicLocal;

public class RolLogic extends AbstractInject implements RolLogicLocal{

	public void crear(RolDTO rolDTO) throws Exception{
		
		validaNombre(rolDTO.getNombre(),5,100);
		Rol rol = new Rol();
		rol.setIdrol(1L);
		rol.setNombre(rolDTO.getNombre());
		rol.setObservacion(rolDTO.getObservacion());
		rolFacadeEJB.create(rol);
	}
	
	public void editar(RolDTO rolDTO) throws Exception{
		
		validaNombre(rolDTO.getNombre(),5,100);
		
		Rol rol = rolFacadeEJB.find(rolDTO.getIdrol());
		rol.setNombre(rolDTO.getNombre());
		rol.setObservacion(rolDTO.getObservacion());
		rolFacadeEJB.edit(rol);
	}
	
	public void eliminar(RolDTO rolDTO) throws Exception{
	
		Rol rol = rolFacadeEJB.find(rolDTO.getIdrol());
		rolFacadeEJB.remove(rol);
	}
	
	public RolDTO findId(Long idRol) throws Exception{
		
		Rol rol = rolFacadeEJB.find(idRol);
		return (RolDTO) converterEntityADTO(rol);
	}
	
	public List<RolDTO> findAll() throws Exception{
		
		List<Rol> rolList = rolFacadeEJB.findAll();
		List<RolDTO> rolListDTO = new ArrayList<RolDTO>();
		for(Rol rol : rolList){
			RolDTO rolDTO = (RolDTO) converterEntityADTO(rol);
			rolListDTO.add(rolDTO);
		}
		return rolListDTO;
	}
	
	@Override
	public void validaNombre(String nombre, int minCaracteres, int maxCaracteres) throws Exception {
		// TODO Auto-generated method stub
		super.validaNombre(nombre, minCaracteres, maxCaracteres);
	}
	
	/*public RolDTO converterEntityRolADTO(Rol rol) throws Exception{
		
		List<ActorSistema> actorSistemaList = rol.getActorSistemaList();
		List<ActorSistemaDTO> actorSistemaListDTO = new ArrayList<ActorSistemaDTO>();
		for(ActorSistema actorSistema : actorSistemaList){
			ActorSistemaDTO actorSistemaDTO = actorSistemLogicEJB.converterEntityActorSistemaADTO(actorSistema);
			actorSistemaListDTO.add(actorSistemaDTO);
		}
		RolDTO rolDTO = new RolDTO(rol.getIdrol(),rol.getNombre());
		rolDTO.setActorSistemaListDTO(actorSistemaListDTO);
		
		return rolDTO;
	}
*/
	@Override
	public Object converterEntityADTO(Object object) throws Exception {
		
		Rol rol = (Rol) object;
		List<ActorSistema> actorSistemaList = rol.getActorSistemaList();
		List<ActorSistemaDTO> actorSistemaListDTO = new ArrayList<ActorSistemaDTO>();
		for(ActorSistema actorSistema : actorSistemaList){
			ActorSistemaDTO actorSistemaDTO = (ActorSistemaDTO)actorSistemaLogicEJB.converterEntityADTO(actorSistema);
			actorSistemaListDTO.add(actorSistemaDTO);
		}
		RolDTO rolDTO = new RolDTO(rol.getIdrol(),rol.getNombre());
		rolDTO.setActorSistemaListDTO(actorSistemaListDTO);
		
		return rolDTO;
	}
}
