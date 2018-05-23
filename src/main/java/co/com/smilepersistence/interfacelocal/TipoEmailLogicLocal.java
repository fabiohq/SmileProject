package co.com.smilepersistence.interfacelocal;

import java.util.List;
import javax.ejb.CreateException;
import co.com.remoteinterface.modelo.TipoEmailDTO;

public interface TipoEmailLogicLocal {

	public void crear(TipoEmailDTO tipoMailDTO) throws Exception, CreateException;
	
	public void editar(TipoEmailDTO tipoMailDTO) throws Exception, CreateException;
	
	public void eliminar(TipoEmailDTO tipoMailDTO) throws Exception, CreateException;
	
	public TipoEmailDTO findId(Long id) throws Exception,CreateException;
	
	public List<TipoEmailDTO> findAll() throws Exception,CreateException;
	
	public Object converterEntityADTO(Object object) throws Exception,CreateException;
}
