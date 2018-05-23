package co.com.smilepersistence.logic;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.Stateless;

import co.com.remoteinterface.modelo.EmailDTO;
import co.com.remoteinterface.modelo.PersonaDTO;
import co.com.remoteinterface.modelo.TipoEmailDTO;
import co.com.smilepersistence.entity.Email;
import co.com.smilepersistence.entity.Persona;
import co.com.smilepersistence.entity.TipoEmail;
import co.com.smilepersistence.interfacelocal.EmailLogicLocal;

@Stateless
public class EmailLogic extends AbstractInject implements EmailLogicLocal{

	
	public void crear(EmailDTO emailDTO) throws Exception,CreateException{
		validaEmail(emailDTO.getMail(),5,200);
		validaLong(emailDTO.getIdpersona().getIdPersona(),"Persona");
		
		Email email = new Email();
		email.setIdemail(1L);
		TipoEmail idtipoEmail = tipoEmailFacadeEJB.find(emailDTO.getIdtipoEmail().getIdTipoMail());
		email.setIdtipoEmail(idtipoEmail);
		Persona idpersona = personaFacadeEJB.find(emailDTO.getIdpersona().getIdPersona());
		email.setIdpersona(idpersona);
		email.setMail(emailDTO.getMail());
		Persona persona = new Persona();
		persona.setIdpersona(emailDTO.getIdpersona().getIdPersona());
		email.setIdpersona(persona);
		emailFacadeEJB.create(email);		
	}
	
	public void editar(EmailDTO emailDTO) throws Exception,CreateException{
		validaEmail(emailDTO.getMail(),5,200);
		validaLong(emailDTO.getIdpersona().getIdPersona(),"Persona");
		
		Email email = emailFacadeEJB.find(emailDTO.getIdemail());
		TipoEmail idtipoEmail = tipoEmailFacadeEJB.find(emailDTO.getIdtipoEmail().getIdTipoMail());
		email.setIdtipoEmail(idtipoEmail);
		Persona idpersona = personaFacadeEJB.find(emailDTO.getIdpersona().getIdPersona());
		email.setIdpersona(idpersona);
		email.setMail(emailDTO.getMail());
		Persona persona = new Persona();
		persona.setIdpersona(emailDTO.getIdpersona().getIdPersona());
		email.setIdpersona(persona);
		emailFacadeEJB.edit(email);		
	}
	
	public void eliminar(EmailDTO emailDTO) throws Exception,CreateException{
		Email email = emailFacadeEJB.find(emailDTO.getIdemail());
		emailFacadeEJB.remove(email);
	}
	
	public EmailDTO findId(Long id) throws Exception,CreateException{
		
		Email email = emailFacadeEJB.find(id);		
		return (EmailDTO)converterEntityADTO(email);
	}
	
	public List<EmailDTO> findAll() throws Exception,CreateException{
				
		List<Email> emailList = emailFacadeEJB.findAll();
		List<EmailDTO> emailListDTO = new ArrayList<EmailDTO>();
		for(Email email: emailList){
			EmailDTO emailDTO = (EmailDTO) converterEntityADTO(email);
			emailListDTO.add(emailDTO);
		}
		return emailListDTO;
	}

	@Override
	public void validaEmail(String pParametro, int minCaracteres, int maxCaracteres) throws Exception, CreateException {
		super.validaEmail(pParametro, minCaracteres, maxCaracteres);
	}
	
	@Override
	public void validaLong(Long pParametro, String campo) throws Exception, CreateException {
		super.validaLong(pParametro, campo);
	}
	
	
	/*//Ok
	public EmailDTO converterEntityEmailADTO(Email email) throws Exception,CreateException{
		
		EmailDTO emailDTO = new EmailDTO(email.getIdemail(),email.getMail());
		
		PersonaDTO idPersonaDTO = null; //personaLogicEJB.converterEntityTipoEmailADTO(email.getIdpersona());		
		TipoEmailDTO idTipoEmail = getTipoEmailLogicEJB().converterEntityTipoEmailADTO(email.getIdtipoEmail());//new TipoEmailDTO(email.getIdtipoEmail().getIdtipoEmail(), email.getIdtipoEmail().getNombre());
		
		emailDTO.setIdpersona(idPersonaDTO);		
		emailDTO.setIdtipoEmail(idTipoEmail);
		
		return emailDTO;
	}*/

	@Override
	public Object converterEntityADTO(Object object) throws Exception {
		
		Email email = (Email) object;		
		PersonaDTO idPersonaDTO = (PersonaDTO)personaLogicEJB.converterEntityADTO(email.getIdpersona());		
		TipoEmailDTO idTipoEmail = (TipoEmailDTO)tipoEmailLogicEJB.converterEntityADTO(email.getIdtipoEmail());//new TipoEmailDTO(email.getIdtipoEmail().getIdtipoEmail(), email.getIdtipoEmail().getNombre());
		EmailDTO emailDTO = new EmailDTO(email.getIdemail(),email.getMail());
		emailDTO.setIdpersona(idPersonaDTO);		
		emailDTO.setIdtipoEmail(idTipoEmail);
		
		return emailDTO;
	}

}
