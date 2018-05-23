package co.com.smilepersistence.interfacelocal;

import javax.ejb.CreateException;

import co.com.remoteinterface.modelo.EmailDTO;

public interface EmailLogicLocal {

	public void crear(EmailDTO emailDTO) throws Exception,CreateException;
	
	public void editar(EmailDTO emailDTO) throws Exception,CreateException;
	
	public void eliminar(EmailDTO emailDTO) throws Exception,CreateException;
	
	public EmailDTO findId(Long id) throws Exception,CreateException;
	
	public Object converterEntityADTO(Object object) throws Exception;
}
