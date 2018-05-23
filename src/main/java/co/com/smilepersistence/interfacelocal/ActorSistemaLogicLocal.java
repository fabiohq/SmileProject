package co.com.smilepersistence.interfacelocal;

import java.util.List;

import co.com.remoteinterface.modelo.ActorSistemaDTO;

public interface ActorSistemaLogicLocal {

	public void crear(ActorSistemaDTO actorSistemaDTO)throws Exception;
	public void editar(ActorSistemaDTO actorSistemaDTO)throws Exception;	
	public void eliminar(ActorSistemaDTO actorSistemaDTO)throws Exception;
	public ActorSistemaDTO findId(Long idActorSistema) throws Exception;
	public List<ActorSistemaDTO> findIdAll() throws Exception;
	public Object converterEntityADTO(Object object) throws Exception;
}
