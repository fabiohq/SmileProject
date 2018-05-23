package co.com.smilepersistence.interfacelocal;

import java.util.List;

import co.com.remoteinterface.modelo.RolDTO;

public interface RolLogicLocal {
	
	public void crear(RolDTO rolDTO) throws Exception;
	public void editar(RolDTO rolDTO) throws Exception;
	public void eliminar(RolDTO rolDTO) throws Exception;
	public RolDTO findId(Long idRol) throws Exception;
	public List<RolDTO> findAll() throws Exception;
	public Object converterEntityADTO(Object object) throws Exception;

}
