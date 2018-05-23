package co.com.smilepersistence.interfacelocal;

import java.util.List;

import javax.ejb.CreateException;

import co.com.remoteinterface.modelo.TipoDocumentoDTO;

public interface TipoDocumentoLogicLocal {

	public void crear (TipoDocumentoDTO tipoDocumentoDTO)throws Exception, CreateException;
	
	public void editar (TipoDocumentoDTO tipoDocumentoDTO)throws Exception, CreateException;
	
	public void eliminar (TipoDocumentoDTO tipoDocumentoDTO)throws Exception, CreateException;
	
	public TipoDocumentoDTO findId(TipoDocumentoDTO tipoDocumentoDTO) throws Exception, CreateException;
	
	public List<TipoDocumentoDTO> findAll() throws Exception,CreateException;
	
	public Object converterEntityADTO(Object object)throws Exception, CreateException;
}
