package co.com.smilepersistence.logic;

import java.util.ArrayList;
import java.util.List;

import co.com.remoteinterface.modelo.ActorSistemaDTO;
import co.com.remoteinterface.modelo.CredencialesDTO;
import co.com.smilepersistence.entity.ActorSistema;
import co.com.smilepersistence.entity.Credenciales;
import co.com.smilepersistence.interfacelocal.CredencialesLogicLocal;

public class CredencialesLogic extends AbstractInject implements CredencialesLogicLocal{

	public void crear(CredencialesDTO credencialesDTO) throws Exception{
		
		validaCampoUsuario(credencialesDTO.getUsuario(),5,50);
		validaCampoClave(credencialesDTO.getClave(),5,50);
		
		Credenciales credenciales = new Credenciales();
		credenciales.setIdcredenciales(1L);
		ActorSistema idactorSistema = actorSistemaFacadeEJB.find(credencialesDTO.getIdactorSistemaDTO().getIdactorSistema());
		credenciales.setIdactorSistema(idactorSistema);		
		credenciales.setUsuario(credencialesDTO.getUsuario());
		credenciales.setClave(credencialesDTO.getClave());
		
		credencialesFacadeEJB.create(credenciales);
	}
	
	public void editar(CredencialesDTO credencialesDTO) throws Exception{
		
		validaCampoUsuario(credencialesDTO.getUsuario(),5,50);
		validaCampoClave(credencialesDTO.getClave(),5,50);
		
		Credenciales credenciales = credencialesFacadeEJB.find(credencialesDTO.getIdcredenciales());
		ActorSistema idactorSistema = actorSistemaFacadeEJB.find(credencialesDTO.getIdactorSistemaDTO().getIdactorSistema());
		credenciales.setIdactorSistema(idactorSistema);
		credenciales.setUsuario(credencialesDTO.getUsuario());
		credenciales.setClave(credencialesDTO.getClave());
		
		credencialesFacadeEJB.edit(credenciales);
	}
	
	public void eliminar(CredencialesDTO credencialesDTO) throws Exception{
		
		Credenciales credenciales = credencialesFacadeEJB.find(credencialesDTO.getIdcredenciales());
		credencialesFacadeEJB.edit(credenciales);
	}
	
	public CredencialesDTO findId(Long idCredenciales)throws Exception{
		
		Credenciales credenciales = credencialesFacadeEJB.find(idCredenciales);
		return (CredencialesDTO) converterEntityADTO(credenciales);
	}
	
	public List<CredencialesDTO> findAll()throws Exception{
		
		List<Credenciales> credencialesList = credencialesFacadeEJB.findAll();
		List<CredencialesDTO> credencialesListDTO = new ArrayList<CredencialesDTO>();
		for(Credenciales credenciales : credencialesList){
			
			CredencialesDTO credencialesDTO = (CredencialesDTO) converterEntityADTO(credenciales);
			credencialesListDTO.add(credencialesDTO);
		}
		return credencialesListDTO;
	}
	
	public void validaCampoUsuario(String usuario,int minCaracteres,int maxCaracteres) throws Exception{		
		super.validaLogin(usuario, minCaracteres, maxCaracteres);
	}
	
	public void validaCampoClave(String clave, int minCaracteres,int maxCaracteres) throws Exception{
		super.validaClave(clave, minCaracteres, maxCaracteres);
	}
	
	@Override
	public Object converterEntityADTO(Object object) throws Exception {
		
		Credenciales credenciales = (Credenciales) object;
		ActorSistemaDTO idActorSistemaDTO = (ActorSistemaDTO) actorSistemaLogicEJB.converterEntityADTO(credenciales.getIdactorSistema());
		CredencialesDTO credencialesDTO = new CredencialesDTO(credenciales.getIdcredenciales(), credenciales.getUsuario(), credenciales.getClave());
		credencialesDTO.setIdactorSistemaDTO(idActorSistemaDTO);
		return credencialesDTO;
	}

}
