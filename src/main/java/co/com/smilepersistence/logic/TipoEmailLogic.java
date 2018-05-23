package co.com.smilepersistence.logic;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.Stateless;

import co.com.remoteinterface.interfaces.TipoEmailLogicRemote;
import co.com.remoteinterface.modelo.EmailDTO;
import co.com.remoteinterface.modelo.TipoEmailDTO;
import co.com.smilepersistence.entity.Email;
import co.com.smilepersistence.entity.TipoEmail;
import co.com.smilepersistence.interfacelocal.TipoEmailLogicLocal;

@Stateless
public class TipoEmailLogic extends AbstractInject implements TipoEmailLogicLocal,TipoEmailLogicRemote{

	
	public void crear(TipoEmailDTO tipoMailDTO) throws Exception, CreateException{
		
		validaNombre(tipoMailDTO.getNombre(), 5, 50);
		TipoEmail tipoEmail = new TipoEmail();
		tipoEmail.setIdtipoEmail(1L);;
		tipoEmail.setNombre(tipoMailDTO.getNombre());
		tipoEmailFacadeEJB.create(tipoEmail);
	}
	
	public void editar(TipoEmailDTO tipoMailDTO) throws Exception, CreateException{
		
		validaNombre(tipoMailDTO.getNombre(), 5, 50);
		TipoEmail tipoEmail = tipoEmailFacadeEJB.find(tipoMailDTO.getIdTipoMail());
		tipoEmail.setNombre(tipoMailDTO.getNombre());
		tipoEmailFacadeEJB.edit(tipoEmail);
	}
	
	public void eliminar(TipoEmailDTO tipoMailDTO) throws Exception, CreateException{
		
		TipoEmail tipoEmail = tipoEmailFacadeEJB.find(tipoMailDTO.getIdTipoMail());
		tipoEmailFacadeEJB.remove(tipoEmail);
	}
	
	public TipoEmailDTO findId(Long id) throws Exception,CreateException{

		TipoEmail tipoEmail =  tipoEmailFacadeEJB.find(id);			
		return (TipoEmailDTO)converterEntityADTO(tipoEmail);
	}
	
	public List<TipoEmailDTO> findAll() throws Exception,CreateException{
		
		List<TipoEmailDTO> tipoEmailDTOList = new ArrayList<TipoEmailDTO>();
		List<TipoEmail> tipoEmailList = tipoEmailFacadeEJB.findAll();		
		for(TipoEmail tipoEmail : tipoEmailList){
			TipoEmailDTO tipoEmailDTO = (TipoEmailDTO)converterEntityADTO(tipoEmail);
			tipoEmailDTOList.add(tipoEmailDTO);
		}		
		return tipoEmailDTOList;
	}
	
	@Override
	public void validaNombre(String nombre, int minCaracteres, int maxCaracteres) throws Exception {
		// TODO Auto-generated method stub
		super.validaNombre(nombre, minCaracteres, maxCaracteres);
	}
		
	/*//OK
	public TipoEmailDTO converterEntityTipoEmailADTO(TipoEmail tipoEmail) throws Exception,CreateException{
		
		List<Email> lEmail = tipoEmail.getEmailList();
		List<EmailDTO> emailListDTO = new ArrayList<>();
		for(Email email: lEmail){			
			EmailDTO emailDTO = getEmailLogicEJB().converterEntityEmailADTO(email);			
			emailListDTO.add(emailDTO);			
		}
		TipoEmailDTO tipoEMailDTO = new TipoEmailDTO(tipoEmail.getIdtipoEmail(), tipoEmail.getNombre());
		tipoEMailDTO.setEmailList(emailListDTO);
		
		return tipoEMailDTO;
	}*/

	@Override
	public Object converterEntityADTO(Object object) throws Exception {

		TipoEmail tipoEmail = (TipoEmail) object;
		List<Email> lEmail = tipoEmail.getEmailList();
		List<EmailDTO> emailListDTO = new ArrayList<>();
		for(Email email: lEmail){			
			EmailDTO emailDTO = (EmailDTO) emailLogicEJB.converterEntityADTO(email);			
			emailListDTO.add(emailDTO);			
		}
		TipoEmailDTO tipoEMailDTO = new TipoEmailDTO(tipoEmail.getIdtipoEmail(), tipoEmail.getNombre());
		tipoEMailDTO.setEmailList(emailListDTO);
		
		return tipoEMailDTO;
	}
}
