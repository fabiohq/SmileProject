package co.com.smilepersistence.logic;

import java.util.ArrayList;
import java.util.List;

import co.com.remoteinterface.modelo.DocumentoDTO;
import co.com.remoteinterface.modelo.EmailDTO;
import co.com.remoteinterface.modelo.PersonaDTO;
import co.com.remoteinterface.modelo.TelefonoDTO;
import co.com.smilepersistence.entity.Documento;
import co.com.smilepersistence.entity.Email;
import co.com.smilepersistence.entity.Persona;
import co.com.smilepersistence.entity.Telefono;
import co.com.smilepersistence.interfacelocal.PersonaLogicLocal;

public class PersonaLogic extends AbstractInject implements PersonaLogicLocal{

	public void crear(PersonaDTO personaDTO)throws Exception{
		
		validaNombre(personaDTO.getNombre1(), 3, 50);
		validaString(personaDTO.getApellido1(), 3, 50, "Apellido1");
		
		Persona persona = new Persona();
		persona.setIdpersona(1L);
		persona.setNombre1(personaDTO.getNombre1());
		persona.setApellido1(personaDTO.getNombre2());
		persona.setApellido1(personaDTO.getApellido1());
		persona.setApellido2(personaDTO.getApellido2());
		persona.setObservacion(personaDTO.getObservacion());
		//persona.setFechaRegistro();
		
		personaFacadeEJB.create(persona);
	}
	
	public void editar(PersonaDTO personaDTO)throws Exception{
		
		validaNombre(personaDTO.getNombre1(), 3, 50);
		validaString(personaDTO.getApellido1(), 3, 50, "Apellido1");
		
		Persona persona = personaFacadeEJB.find(personaDTO.getIdPersona());
		persona.setNombre1(personaDTO.getNombre1());
		persona.setApellido1(personaDTO.getNombre2());
		persona.setApellido1(personaDTO.getApellido1());
		persona.setApellido2(personaDTO.getApellido2());
		persona.setObservacion(personaDTO.getObservacion());
		
		personaFacadeEJB.edit(persona);
	}
	
	public void eliminar(PersonaDTO personaDTO)throws Exception{

		Persona persona = personaFacadeEJB.find(personaDTO.getIdPersona());		
		personaFacadeEJB.remove(persona);
	}
	
	public PersonaDTO finId(Long idPersona)throws Exception{
		
		Persona persona = personaFacadeEJB.find(idPersona);
		return (PersonaDTO) converterEntityADTO(persona);
		
	}
	
	public List<PersonaDTO> findAll() throws Exception{
		List<Persona> personaList = personaFacadeEJB.findAll();
		List<PersonaDTO> personaListDTO = new ArrayList<PersonaDTO>();
		for(Persona persona : personaList){
			PersonaDTO personaDTO = (PersonaDTO)converterEntityADTO(persona);
			personaListDTO.add(personaDTO);
		}
		return personaListDTO;
	}
	
	@Override
	public void validaNombre(String nombre, int minCaracteres, int maxCaracteres) throws Exception {
		// TODO Auto-generated method stub
		super.validaNombre(nombre, minCaracteres, maxCaracteres);
	}
	
	/*public PersonaDTO converterEntityPersonaADTO(Persona persona) throws Exception{
		
		List<Documento> documentoList = persona.getDocumentoList();
		List<DocumentoDTO> documentoListDTO = new ArrayList<DocumentoDTO>();
		for(Documento documento : documentoList){
			DocumentoDTO documentoDTO = documentoLogicEJB.converterEntityDocumentoADTO(documento);
			documentoListDTO.add(documentoDTO);
		}
		List<Telefono> telefonoList = persona.getTelefonoList();
		List<TelefonoDTO> telefonoListDTO = new ArrayList<TelefonoDTO>();
		for(Telefono telefono : telefonoList){
			TelefonoDTO telefonoDTO = telefonoLogicEJB.converterEntityTelefonoADTO(telefono);
			telefonoListDTO.add(telefonoDTO);
		}
		List<Email> emailList = persona.getEmailList();
		List<EmailDTO> emailListDTO = new ArrayList<EmailDTO>();
		for(Email email : emailList){
			EmailDTO emailDTO = emailLogicEJB.converterEntityEmailADTO(email);
			emailListDTO.add(emailDTO);
		}
		PersonaDTO personaDTO = new PersonaDTO(persona.getIdpersona(), persona.getNombre1(), persona.getNombre2(), persona.getApellido1(), persona.getApellido2(), persona.getObservacion(), persona.getFechaRegistro());
		personaDTO.setDocumentoListDTO(documentoListDTO);
		personaDTO.setTelefonoListDTO(telefonoListDTO);
		personaDTO.setEmailListDTO(emailListDTO);
		
		return personaDTO;
	}*/

	@Override
	public Object converterEntityADTO(Object object) throws Exception {
		
		Persona persona = (Persona) object;

		List<Documento> documentoList = persona.getDocumentoList();
		List<DocumentoDTO> documentoListDTO = new ArrayList<DocumentoDTO>();
		for(Documento documento : documentoList){
			DocumentoDTO documentoDTO = (DocumentoDTO) documentoLogicEJB.converterEntityADTO(documento);
			documentoListDTO.add(documentoDTO);
		}
		List<Telefono> telefonoList = persona.getTelefonoList();
		List<TelefonoDTO> telefonoListDTO = new ArrayList<TelefonoDTO>();
		for(Telefono telefono : telefonoList){
			TelefonoDTO telefonoDTO = (TelefonoDTO) telefonoLogicEJB.converterEntityADTO(telefono);
			telefonoListDTO.add(telefonoDTO);
		}
		List<Email> emailList = persona.getEmailList();
		List<EmailDTO> emailListDTO = new ArrayList<EmailDTO>();
		for(Email email : emailList){
			EmailDTO emailDTO = (EmailDTO) emailLogicEJB.converterEntityADTO(email);
			emailListDTO.add(emailDTO);
		}
		PersonaDTO personaDTO = new PersonaDTO(persona.getIdpersona(), persona.getNombre1(), persona.getNombre2(), persona.getApellido1(), persona.getApellido2(), persona.getObservacion(), persona.getFechaRegistro());
		personaDTO.setDocumentoListDTO(documentoListDTO);
		personaDTO.setTelefonoListDTO(telefonoListDTO);
		personaDTO.setEmailListDTO(emailListDTO);
		
		return personaDTO;
	}
}
