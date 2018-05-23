package co.com.smilepersistence.logic;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.Stateless;

import co.com.remoteinterface.modelo.DocumentoDTO;
import co.com.remoteinterface.modelo.TipoDocumentoDTO;
import co.com.smilepersistence.entity.Documento;
import co.com.smilepersistence.entity.TipoDocumento;
import co.com.smilepersistence.interfacelocal.TipoDocumentoLogicLocal;

@Stateless
public class TipoDocumentoLogic extends AbstractInject implements TipoDocumentoLogicLocal{

	public void crear (TipoDocumentoDTO tipoDocumentoDTO)throws Exception, CreateException{
		
		validaNombre(tipoDocumentoDTO.getNombre(),5,20);
		
		TipoDocumento tipoDocumento = new TipoDocumento();
		tipoDocumento.setIdtipoDocumento(1L);
		tipoDocumento.setNombre(tipoDocumentoDTO.getNombre());
		tipoDocumentoFacadeEJB.create(tipoDocumento);
	}
	
	public void editar (TipoDocumentoDTO tipoDocumentoDTO)throws Exception, CreateException{
		
		validaNombre(tipoDocumentoDTO.getNombre(),5,20);		
		TipoDocumento tipoDocumento = tipoDocumentoFacadeEJB.find(tipoDocumentoDTO.getIdtipoDocumento());
		tipoDocumento.setNombre(tipoDocumentoDTO.getNombre());
		tipoDocumentoFacadeEJB.edit(tipoDocumento);
	}
	
	public void eliminar (TipoDocumentoDTO tipoDocumentoDTO)throws Exception, CreateException{
		
		TipoDocumento tipoDocumento = tipoDocumentoFacadeEJB.find(tipoDocumentoDTO.getIdtipoDocumento());
		tipoDocumentoFacadeEJB.remove(tipoDocumento);
	}
	
	public TipoDocumentoDTO findId(TipoDocumentoDTO tipoDocumentoDTO) throws Exception, CreateException{
		
		TipoDocumento tipoDocumento = tipoDocumentoFacadeEJB.find(tipoDocumentoDTO.getIdtipoDocumento());		
		return (TipoDocumentoDTO) converterEntityADTO(tipoDocumento);
	}
	
	public List<TipoDocumentoDTO> findAll() throws Exception,CreateException{
		
		List<TipoDocumento> tipoDocumentoList = tipoDocumentoFacadeEJB.findAll();
		List<TipoDocumentoDTO> tipoDocumentoListDTO = new ArrayList<TipoDocumentoDTO>();
		for(TipoDocumento tipoDocumento: tipoDocumentoList){
			TipoDocumentoDTO tipoDocumentoDTO = (TipoDocumentoDTO) converterEntityADTO(tipoDocumento);
			tipoDocumentoListDTO.add(tipoDocumentoDTO);
		}
		return tipoDocumentoListDTO;
	}
	
	@Override
	public void validaNombre(String nombre, int minCaracteres, int maxCaracteres) throws Exception {
		// TODO Auto-generated method stub
		super.validaNombre(nombre, minCaracteres, maxCaracteres);
	}
	
	/*//Ok
	public TipoDocumentoDTO converterEntityTipoDocumentoADTO(TipoDocumento tipoDocumento)throws Exception, CreateException{
				
		List<Documento> documentoList = tipoDocumento.getDocumentoList();
		List<DocumentoDTO> documentoListDTO = new ArrayList<DocumentoDTO>();
		for(Documento documento: documentoList){
			DocumentoDTO documentoDTO = getDocumentoLogicEJB().converterEntityDocumentoADTO(documento);//new DocumentoDTO(documento.getIddocumento(), documento.getNumero());			
			documentoListDTO.add(documentoDTO);
		}
		TipoDocumentoDTO tipoDocumentoDTO = new TipoDocumentoDTO(tipoDocumento.getIdtipoDocumento(), tipoDocumento.getNombre());
		tipoDocumentoDTO.setDocumentoList(documentoListDTO);
		return tipoDocumentoDTO;
		
	}*/

	@Override
	public Object converterEntityADTO(Object object) throws Exception {

		TipoDocumento tipoDocumento = (TipoDocumento) object;
		List<Documento> documentoList = tipoDocumento.getDocumentoList();
		List<DocumentoDTO> documentoListDTO = new ArrayList<DocumentoDTO>();
		for(Documento documento: documentoList){
			DocumentoDTO documentoDTO = (DocumentoDTO) documentoLogicEJB.converterEntityADTO(documento);			
			documentoListDTO.add(documentoDTO);
		}
		TipoDocumentoDTO tipoDocumentoDTO = new TipoDocumentoDTO(tipoDocumento.getIdtipoDocumento(), tipoDocumento.getNombre());
		tipoDocumentoDTO.setDocumentoList(documentoListDTO);
		return tipoDocumentoDTO;
	}
}
