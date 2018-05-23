package co.com.smilepersistence.interfacelocal;

import java.util.List;
import javax.ejb.CreateException;
import co.com.remoteinterface.modelo.TipoTelefonoDTO;

public interface TipoTelefonoLogicLocal {

	public void crear(TipoTelefonoDTO tipoTelefonoDTO)  throws Exception, CreateException;
	public void editar(TipoTelefonoDTO tipoTelefonoDTO)  throws Exception, CreateException;
	public void eliminar(TipoTelefonoDTO tipoTelefonoDTO)  throws Exception, CreateException;
	public TipoTelefonoDTO finId(Long idTipoTelefono)throws Exception;
	public List<TipoTelefonoDTO> findAll() throws Exception;
	public Object converterEntityADTO(Object object) throws Exception;
}
