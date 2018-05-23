package co.com.smilepersistence.logic;

import java.util.ArrayList;
import java.util.List;

import co.com.remoteinterface.modelo.PersonaDTO;
import co.com.remoteinterface.modelo.TelefonoDTO;
import co.com.remoteinterface.modelo.TipoTelefonoDTO;
import co.com.smilepersistence.entity.Persona;
import co.com.smilepersistence.entity.Telefono;
import co.com.smilepersistence.entity.TipoTelefono;
import co.com.smilepersistence.interfacelocal.TelefonoLogicLocal;
import co.com.smilepersistence.utilidades.Validacion;

public class TelefonoLogic extends AbstractInject implements TelefonoLogicLocal{

	public void crear(TelefonoDTO telefonoDTO) throws Exception{
		
		validaNumerotelefono(telefonoDTO.getNumero(),7,25);
		validaIdPersona(telefonoDTO.getIdpersonaDTO().getIdPersona());
		validaIdTipoTelefono(telefonoDTO.getIdtipoTelefonoDTO().getIdtipoTelefono());
		
		Telefono telefono = new Telefono();
		telefono.setIdtelefono(1L);
		Persona idpersona = personaFacadeEJB.find(telefonoDTO.getIdpersonaDTO().getIdPersona());
		telefono.setIdpersona(idpersona);
		TipoTelefono idtipoTelefono = tipoTelefonoFacadeEJB.find(telefonoDTO.getIdtipoTelefonoDTO().getIdtipoTelefono());
		telefono.setIdtipoTelefono(idtipoTelefono);
		telefono.setNumero(telefonoDTO.getNumero());
		Persona idPersona = new Persona();
		idPersona.setIdpersona(telefonoDTO.getIdpersonaDTO().getIdPersona());
		TipoTelefono idTipoTelefono = new TipoTelefono();
		idTipoTelefono.setIdtipoTelefono(telefonoDTO.getIdtipoTelefonoDTO().getIdtipoTelefono());
		telefono.setIdpersona(idPersona);
		telefono.setIdtipoTelefono(idTipoTelefono);
		
		telefonoFacadeEJB.create(telefono);
		
	}
	
	public void editar(TelefonoDTO telefonoDTO) throws Exception{
		
		validaNumerotelefono(telefonoDTO.getNumero(),7,25);
		validaIdPersona(telefonoDTO.getIdpersonaDTO().getIdPersona());
		validaIdTipoTelefono(telefonoDTO.getIdtipoTelefonoDTO().getIdtipoTelefono());
		
		Telefono telefono = telefonoFacadeEJB.find(telefonoDTO.getIdtelefono());
		Persona idpersona = personaFacadeEJB.find(telefonoDTO.getIdpersonaDTO().getIdPersona());
		telefono.setIdpersona(idpersona);
		TipoTelefono idtipoTelefono = tipoTelefonoFacadeEJB.find(telefonoDTO.getIdtipoTelefonoDTO().getIdtipoTelefono());
		telefono.setIdtipoTelefono(idtipoTelefono);
		telefono.setNumero(telefonoDTO.getNumero());
		Persona idPersona = new Persona();
		idPersona.setIdpersona(telefonoDTO.getIdpersonaDTO().getIdPersona());
		TipoTelefono idTipoTelefono = new TipoTelefono();
		idTipoTelefono.setIdtipoTelefono(telefonoDTO.getIdtipoTelefonoDTO().getIdtipoTelefono());
		telefono.setIdpersona(idPersona);
		telefono.setIdtipoTelefono(idTipoTelefono);
		
		telefonoFacadeEJB.edit(telefono);
		
	}
	
	public void eliminar(TelefonoDTO telefonoDTO) throws Exception{

		Telefono telefono = telefonoFacadeEJB.find(telefonoDTO.getIdtelefono());				
		telefonoFacadeEJB.remove(telefono);
		
	}
	
	public TelefonoDTO findId(Long idTelefono) throws Exception{
		
		Telefono telefono = telefonoFacadeEJB.find(idTelefono);
		return (TelefonoDTO)converterEntityADTO(telefono);
	}
	
	public List<TelefonoDTO> findAll() throws Exception{
		
		List<Telefono> telefonoList = telefonoFacadeEJB.findAll();
		List<TelefonoDTO> telefonoListDTO = new ArrayList<TelefonoDTO>();
		for(Telefono telefono : telefonoList){
			TelefonoDTO telefonoDTO = (TelefonoDTO)converterEntityADTO(telefono);
			telefonoListDTO.add(telefonoDTO);
		}
		return telefonoListDTO;
		
	}
	
	@Override
	public void validaNumerotelefono(String numeroTelefono, int minCaracteres, int maxCaracteres) throws Exception {
		super.validaNumerotelefono(numeroTelefono, minCaracteres, maxCaracteres);
	}
	
	public void validaIdPersona(Long idPersona) throws Exception{
		Validacion.validaLongNull(idPersona, "Persona");
		Validacion.validaLongValorCero(idPersona, "Persona");
	}
	
	public void validaIdTipoTelefono(Long idTipoTelefono) throws Exception{
		Validacion.validaLongNull(idTipoTelefono, "Tipo Telefono");
		Validacion.validaLongValorCero(idTipoTelefono, "Tipo Telefono");
	}
	
	/*public TelefonoDTO converterEntityTelefonoADTO(Telefono telefono)throws Exception{
		
		TelefonoDTO telefonoDTO = new TelefonoDTO(telefono.getIdtelefono(), telefono.getNumero());
		PersonaDTO idPersonaDTO = personaLogicEJB.converterEntityPersonaADTO(telefono.getIdpersona());
		TipoTelefonoDTO idTipoTelefonoDTO = tipoTelefonoLogicEJB.converterEntityTipoTelefonoADTO(telefono.getIdtipoTelefono()); 
		telefonoDTO.setIdpersonaDTO(idPersonaDTO);
		telefonoDTO.setIdtipoTelefonoDTO(idTipoTelefonoDTO);
		
		return telefonoDTO;
	}*/

	@Override
	public Object converterEntityADTO(Object object) throws Exception {

		Telefono telefono = (Telefono) object;		
		PersonaDTO idPersonaDTO = (PersonaDTO) personaLogicEJB.converterEntityADTO(telefono.getIdpersona());
		TipoTelefonoDTO idTipoTelefonoDTO = (TipoTelefonoDTO)tipoTelefonoLogicEJB.converterEntityADTO(telefono.getIdtipoTelefono()); 
		TelefonoDTO telefonoDTO = new TelefonoDTO(telefono.getIdtelefono(), telefono.getNumero());
		telefonoDTO.setIdpersonaDTO(idPersonaDTO);
		telefonoDTO.setIdtipoTelefonoDTO(idTipoTelefonoDTO);
		
		return telefonoDTO;
	}
}
