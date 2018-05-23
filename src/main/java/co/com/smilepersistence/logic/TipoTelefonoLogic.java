package co.com.smilepersistence.logic;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.CreateException;

import co.com.remoteinterface.modelo.TelefonoDTO;
import co.com.remoteinterface.modelo.TipoTelefonoDTO;
import co.com.smilepersistence.entity.Telefono;
import co.com.smilepersistence.entity.TipoTelefono;
import co.com.smilepersistence.interfacelocal.TipoTelefonoLogicLocal;

public class TipoTelefonoLogic extends AbstractInject implements TipoTelefonoLogicLocal{

	public void crear(TipoTelefonoDTO tipoTelefonoDTO)  throws Exception, CreateException{
		
		validaNombre(tipoTelefonoDTO.getNombre(),4,50);
		
		TipoTelefono tipoTelefono = new TipoTelefono();
		tipoTelefono.setIdtipoTelefono(1L);
		tipoTelefono.setNombre(tipoTelefonoDTO.getNombre());
		
		tipoTelefonoFacadeEJB.create(tipoTelefono);
	
	}
	
	public void editar(TipoTelefonoDTO tipoTelefonoDTO)  throws Exception, CreateException{
		
		validaNombre(tipoTelefonoDTO.getNombre(),4,50);
		
		TipoTelefono tipoTelefono = tipoTelefonoFacadeEJB.find(tipoTelefonoDTO.getIdtipoTelefono());
		tipoTelefono.setNombre(tipoTelefonoDTO.getNombre());
		
		tipoTelefonoFacadeEJB.edit(tipoTelefono);
	
	}

	public void eliminar(TipoTelefonoDTO tipoTelefonoDTO)  throws Exception, CreateException{
				
		TipoTelefono tipoTelefono = tipoTelefonoFacadeEJB.find(tipoTelefonoDTO.getIdtipoTelefono());
		tipoTelefonoFacadeEJB.remove(tipoTelefono);
	
	}
	
	public TipoTelefonoDTO finId(Long idTipoTelefono)throws Exception{
		
		TipoTelefono tipoTelefono = tipoTelefonoFacadeEJB.find(idTipoTelefono);		
		return (TipoTelefonoDTO) converterEntityADTO(tipoTelefono);
	}
	
	public List<TipoTelefonoDTO> findAll() throws Exception{
		
		List<TipoTelefono> tipoTelefonoList = tipoTelefonoFacadeEJB.findAll();
		List<TipoTelefonoDTO> tipoTelefonoListDTO = new ArrayList<TipoTelefonoDTO>();
		for(TipoTelefono tipoTelefono : tipoTelefonoList){
			TipoTelefonoDTO tipoTelefonoDTO = (TipoTelefonoDTO) converterEntityADTO(tipoTelefono);
			tipoTelefonoListDTO.add(tipoTelefonoDTO);
		}
		return tipoTelefonoListDTO;
	}
	
	
	@Override
	public void validaNombre(String nombre, int minCaracteres, int maxCaracteres) throws Exception {
		super.validaNombre(nombre, minCaracteres, maxCaracteres);
	}
		
	/*public TipoTelefonoDTO converterEntityTipoTelefonoADTO(TipoTelefono tipoTelefono) throws Exception{
		
		TipoTelefonoDTO tipoTelefonoDTO = new TipoTelefonoDTO(tipoTelefono.getIdtipoTelefono(), tipoTelefono.getNombre());
		List<Telefono> telefonoList = tipoTelefono.getTelefonoList();
		List<TelefonoDTO> telefonoListDTO = new ArrayList<TelefonoDTO>();
		for(Telefono telefono : telefonoList){
			TelefonoDTO telefonoDTO = telefonoLogicEJB.converterEntityTelefonoADTO(telefono);
			telefonoListDTO.add(telefonoDTO);
		}
		tipoTelefonoDTO.setTelefonoListDTO(telefonoListDTO);
		return tipoTelefonoDTO;
	}*/

	@Override
	public Object converterEntityADTO(Object object) throws Exception {

		TipoTelefono tipoTelefono = (TipoTelefono)object;
		
		List<Telefono> telefonoList = tipoTelefono.getTelefonoList();
		List<TelefonoDTO> telefonoListDTO = new ArrayList<TelefonoDTO>();
		for(Telefono telefono : telefonoList){
			TelefonoDTO telefonoDTO = (TelefonoDTO)telefonoLogicEJB.converterEntityADTO(telefono);
			telefonoListDTO.add(telefonoDTO);
		}
		TipoTelefonoDTO tipoTelefonoDTO = new TipoTelefonoDTO(tipoTelefono.getIdtipoTelefono(), tipoTelefono.getNombre());
		tipoTelefonoDTO.setTelefonoListDTO(telefonoListDTO);
		return tipoTelefonoDTO;
	}
}
