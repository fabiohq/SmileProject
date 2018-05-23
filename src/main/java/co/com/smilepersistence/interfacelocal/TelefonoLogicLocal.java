package co.com.smilepersistence.interfacelocal;

import co.com.remoteinterface.modelo.TelefonoDTO;

public interface TelefonoLogicLocal {
	
	public void crear(TelefonoDTO telefonoDTO) throws Exception;
	public void editar(TelefonoDTO telefonoDTO) throws Exception;
	public void eliminar(TelefonoDTO telefonoDTO) throws Exception;
	public TelefonoDTO findId(Long idTelefono) throws Exception;
	public Object converterEntityADTO(Object object)throws Exception;

}
