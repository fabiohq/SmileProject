package co.com.smilepersistence.logic;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.CreateException;

import co.com.remoteinterface.modelo.ActorSistemaDTO;
import co.com.remoteinterface.modelo.ConsolidadoVentaDTO;
import co.com.remoteinterface.modelo.DetalleVentaDTO;
import co.com.remoteinterface.modelo.DocumentoDTO;
import co.com.remoteinterface.modelo.EncargoDTO;
import co.com.remoteinterface.modelo.PersonaDTO;
import co.com.remoteinterface.modelo.SaldoAFavorDTO;
import co.com.remoteinterface.modelo.TipoDocumentoDTO;
import co.com.remoteinterface.modelo.VentaPendienteDTO;
import co.com.smilepersistence.entity.ActorSistema;
import co.com.smilepersistence.entity.ConsolidadoVenta;
import co.com.smilepersistence.entity.DetalleVenta;
import co.com.smilepersistence.entity.Documento;
import co.com.smilepersistence.entity.Encargo;
import co.com.smilepersistence.entity.Persona;
import co.com.smilepersistence.entity.SaldoAFavor;
import co.com.smilepersistence.entity.TipoDocumento;
import co.com.smilepersistence.entity.VentaPendiente;
import co.com.smilepersistence.interfacelocal.DocumentoLogicLocal;

public class DocumentoLogic extends AbstractInject implements DocumentoLogicLocal{

	public void crear(DocumentoDTO documentoDTO) throws Exception, CreateException{
		
		validaNumDocumento(documentoDTO.getNumero(),5,20);
		validaLong(documentoDTO.getIdtipoDocumento().getIdtipoDocumento(), "Tipo Documento");
		validaLong(documentoDTO.getIdpersona().getIdPersona(),"Persona");
		
		Documento documento = new Documento();
		documento.setIddocumento(1L);
		TipoDocumento idtipoDocumento = tipoDocumentoFacadeEJB.find(documentoDTO.getIdtipoDocumento().getIdtipoDocumento());
		documento.setIdtipoDocumento(idtipoDocumento);
		Persona idpersona = personaFacadeEJB.find(documentoDTO.getIdpersona().getIdPersona());
		documento.setIdpersona(idpersona);
		documento.setNumero(documentoDTO.getNumero());
		TipoDocumento idTipoDocumento = new TipoDocumento();
		idTipoDocumento.setIdtipoDocumento(documentoDTO.getIdtipoDocumento().getIdtipoDocumento());
		documento.setIdtipoDocumento(idTipoDocumento);
		Persona idPersona = new Persona();
		idPersona.setIdpersona(documentoDTO.getIdpersona().getIdPersona());
		documento.setIdpersona(idPersona);
		
		documentoFacadeEJB.create(documento);
		
	}
	
	public void editar(DocumentoDTO documentoDTO) throws Exception, CreateException{
		
		validaNumDocumento(documentoDTO.getNumero(),5,20);
		validaLong(documentoDTO.getIdtipoDocumento().getIdtipoDocumento(), "Tipo Documento");
		validaLong(documentoDTO.getIdpersona().getIdPersona(),"Persona");
		
		Documento documento = documentoFacadeEJB.find(documentoDTO.getIddocumento());
		TipoDocumento idtipoDocumento = tipoDocumentoFacadeEJB.find(documentoDTO.getIdtipoDocumento().getIdtipoDocumento());
		documento.setIdtipoDocumento(idtipoDocumento);
		Persona idpersona = personaFacadeEJB.find(documentoDTO.getIdpersona().getIdPersona());
		documento.setIdpersona(idpersona);
		documento.setNumero(documentoDTO.getNumero());
		TipoDocumento idTipoDocumento = new TipoDocumento();
		idTipoDocumento.setIdtipoDocumento(documentoDTO.getIdtipoDocumento().getIdtipoDocumento());
		documento.setIdtipoDocumento(idTipoDocumento);
		Persona idPersona = new Persona();
		idPersona.setIdpersona(documentoDTO.getIdpersona().getIdPersona());
		documento.setIdpersona(idPersona);
		
		documentoFacadeEJB.edit(documento);
		
	}
	
	public void eliminar(DocumentoDTO documentoDTO) throws Exception, CreateException{

		Documento documento = documentoFacadeEJB.find(documentoDTO.getIddocumento());		
		documentoFacadeEJB.remove(documento);
		
	}
	
	public DocumentoDTO findId(Long idDocumento) throws Exception, CreateException{
		
		Documento documento = documentoFacadeEJB.find(idDocumento);		
		return (DocumentoDTO) converterEntityADTO(documento);
	}
	
	public List<DocumentoDTO> findAll() throws Exception, CreateException{
		
		List<Documento> documentoList = documentoFacadeEJB.findAll();
		List<DocumentoDTO> documentoListDTO = new ArrayList<DocumentoDTO>();
		for(Documento documento : documentoList){
			DocumentoDTO documentoDTO = (DocumentoDTO)converterEntityADTO(documento);
			documentoListDTO.add(documentoDTO);
		}
		return documentoListDTO;
	}

	@Override
	public void validaNumDocumento(String numDocumento, int minCaracteres, int maxCaracteres)throws Exception {
		super.validaNumDocumento(numDocumento, minCaracteres, maxCaracteres);
	}
	
	@Override
	public void validaLong(Long pParametro, String campo) throws Exception, CreateException {
		// TODO Auto-generated method stub
		super.validaLong(pParametro, campo);
	}
		
	/*public DocumentoDTO converterEntityDocumentoADTO(Documento documento)throws Exception, CreateException{
				
		PersonaDTO idPersonaDTO = null; //personaLogicEJB.converterEntityTipoEmailADTO(documento.getIdpersona());
		TipoDocumentoDTO idTipoDocumentoDTO = getTipoDocumentoLogicEJB().converterEntityTipoDocumentoADTO(documento.getIdtipoDocumento());
		//List<Encargo>
		//List<ActorSistema>
		//List<ConsolidadoVenta>
		//List<VentaPendiente>
		//List<DetalleVenta>
		//List<SaldoAFavorDTO>
		
		DocumentoDTO documentoDTO = new DocumentoDTO(documento.getIddocumento(), documento.getNumero());
		documentoDTO.setIdpersona(idPersonaDTO);
		documentoDTO.setIdtipoDocumento(idTipoDocumentoDTO);
		return documentoDTO;		
	}*/

	@Override
	public Object converterEntityADTO(Object object) throws Exception {
		
		Documento documento = (Documento) object;
		PersonaDTO idPersonaDTO =(PersonaDTO) personaLogicEJB.converterEntityADTO(documento.getIdpersona());
		TipoDocumentoDTO idTipoDocumentoDTO = (TipoDocumentoDTO)tipoDocumentoLogicEJB.converterEntityADTO(documento.getIdtipoDocumento());
		
		List<Encargo> encargoList = documento.getEncargoList();
		List<EncargoDTO> encargoListDTO = new ArrayList<EncargoDTO>();
		for(Encargo encargo : encargoList){
			EncargoDTO encargoDTO = (EncargoDTO) encargoLogicEJB.converterEntityADTO(encargo);
			encargoListDTO.add(encargoDTO);
		}
		
		List<ActorSistema> actorSistemaList = documento.getActorSistemaList();
		List<ActorSistemaDTO> actorSistemaListDTO = new ArrayList<ActorSistemaDTO>();
		for(ActorSistema actorSistema : actorSistemaList){
			ActorSistemaDTO actorSistemaDTO = (ActorSistemaDTO) actorSistemaLogicEJB.converterEntityADTO(actorSistema);
			actorSistemaListDTO.add(actorSistemaDTO);
		}
		
		List<ConsolidadoVenta> consolidadoVentaList = documento.getConsolidadoVentaList();
		List<ConsolidadoVentaDTO> consolidadoVentaListDTO = new ArrayList<ConsolidadoVentaDTO>();
		for(ConsolidadoVenta consolidadoVenta : consolidadoVentaList){
			ConsolidadoVentaDTO consolidadoVentaDTO = (ConsolidadoVentaDTO) consolidadoVentaLogicEJB.converterEntityADTO(consolidadoVenta);
			consolidadoVentaListDTO.add(consolidadoVentaDTO);
		}
		
		List<VentaPendiente> ventaPendienteList = documento.getVentaPendienteList();
		List<VentaPendienteDTO> ventaPendienteListDTO = new ArrayList<VentaPendienteDTO>();
		for(VentaPendiente ventaPendiente : ventaPendienteList){
			VentaPendienteDTO ventaPendienteDTO = (VentaPendienteDTO) ventaPendienteLogicEJB.converterEntityADTO(ventaPendiente);
			ventaPendienteListDTO.add(ventaPendienteDTO);
		}
		
		List<DetalleVenta> detalleVentaList = documento.getDetalleVentaList();
		List<DetalleVentaDTO> detalleVentaListDTO = new ArrayList<DetalleVentaDTO>();
		for(DetalleVenta detalleVenta : detalleVentaList){
			DetalleVentaDTO detalleVentaDTO = (DetalleVentaDTO) detalleVentaLogicEJB.converterEntityADTO(detalleVenta);
			detalleVentaListDTO.add(detalleVentaDTO);
		}
		
		List<SaldoAFavor> saldoAFavorList = documento.getSaldoAFavorList();
		List<SaldoAFavorDTO> saldoAFavorListDTO = new ArrayList<SaldoAFavorDTO>();
		for(SaldoAFavor saldoAFavor : saldoAFavorList){
			SaldoAFavorDTO saldoAFavorDTO = (SaldoAFavorDTO) saldoAFavorLogicEJB.converterEntityADTO(saldoAFavor);
			saldoAFavorListDTO.add(saldoAFavorDTO);
		}
		
		DocumentoDTO documentoDTO = new DocumentoDTO(documento.getIddocumento(), documento.getNumero());
		documentoDTO.setEncargoListDTO(encargoListDTO);
		documentoDTO.setActorSistemaListDTO(actorSistemaListDTO);
		documentoDTO.setConsolidadoVentaListDTO(consolidadoVentaListDTO);
		documentoDTO.setVentaPendienteListDTO(ventaPendienteListDTO);
		documentoDTO.setDetalleVentaListDTO(detalleVentaListDTO);
		documentoDTO.setSaldoAFavorListDTO(saldoAFavorListDTO);
		documentoDTO.setIdpersona(idPersonaDTO);
		documentoDTO.setIdtipoDocumento(idTipoDocumentoDTO);
		return documentoDTO;		
	}

}