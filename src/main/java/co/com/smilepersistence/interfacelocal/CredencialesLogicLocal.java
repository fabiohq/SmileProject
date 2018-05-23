package co.com.smilepersistence.interfacelocal;

import java.util.List;

import co.com.remoteinterface.modelo.CredencialesDTO;

public interface CredencialesLogicLocal {
	
	public Object converterEntityADTO(Object object) throws Exception;
	
	public List<CredencialesDTO> findAll()throws Exception;
	
	public CredencialesDTO findId(Long idCredenciales)throws Exception;
	
	public void eliminar(CredencialesDTO credencialesDTO) throws Exception;
	
	public void editar(CredencialesDTO credencialesDTO) throws Exception;
	
	public void crear(CredencialesDTO credencialesDTO) throws Exception;

}
