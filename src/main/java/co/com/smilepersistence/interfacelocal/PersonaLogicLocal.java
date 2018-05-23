package co.com.smilepersistence.interfacelocal;

import co.com.remoteinterface.modelo.PersonaDTO;

public interface PersonaLogicLocal {
	
	public void crear(PersonaDTO personaDTO)throws Exception;
	public void editar(PersonaDTO personaDTO)throws Exception;
	public void eliminar(PersonaDTO personaDTO)throws Exception;
	
	public Object converterEntityADTO(Object object)throws Exception; 

}
