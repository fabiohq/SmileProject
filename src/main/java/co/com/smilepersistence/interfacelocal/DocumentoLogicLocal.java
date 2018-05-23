package co.com.smilepersistence.interfacelocal;

import javax.ejb.CreateException;

import co.com.remoteinterface.modelo.DocumentoDTO;

public interface DocumentoLogicLocal {

	public void crear(DocumentoDTO documentoDTO) throws Exception, CreateException;
	
	public void editar(DocumentoDTO documentoDTO) throws Exception, CreateException;
	
	public void eliminar(DocumentoDTO documentoDTO) throws Exception, CreateException;
	
	public Object converterEntityADTO(Object object) throws Exception;
}
