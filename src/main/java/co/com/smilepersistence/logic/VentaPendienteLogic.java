package co.com.smilepersistence.logic;

import java.util.ArrayList;
import java.util.List;

import co.com.remoteinterface.modelo.ActorSistemaDTO;
import co.com.remoteinterface.modelo.DocumentoDTO;
import co.com.remoteinterface.modelo.EstadoVentaDTO;
import co.com.remoteinterface.modelo.VentaPendienteDTO;
import co.com.smilepersistence.entity.ActorSistema;
import co.com.smilepersistence.entity.Documento;
import co.com.smilepersistence.entity.EstadoVenta;
import co.com.smilepersistence.entity.VentaPendiente;
import co.com.smilepersistence.interfacelocal.VentaPendienteLogicLocal;
import co.com.smilepersistence.utilidades.Util;

public class VentaPendienteLogic extends AbstractInject implements VentaPendienteLogicLocal {

	public void crear(VentaPendienteDTO ventaPendienteDTO)throws Exception{
		
		validaLong(ventaPendienteDTO.getReferenciaVenta(), "Referencia Venta");
		validaBigDecimal(ventaPendienteDTO.getTotalDescCampania(), "Total Desc Campania");
		validaBigDecimal(ventaPendienteDTO.getTotalDescPreferenc(), "Total Desc Preferenc");
		validaBigDecimal(ventaPendienteDTO.getDescALaVenta(), "Desc A La Venta");
		validaBigDecimal(ventaPendienteDTO.getTotalVenta(), "Total Venta");
		
		VentaPendiente ventaPendiente = new VentaPendiente();
		ventaPendiente.setIdventaPendiente(1L);
		ventaPendiente.setReferenciaVenta(ventaPendienteDTO.getReferenciaVenta());
		ventaPendiente.setFechaActual(Util.getDateFechaActualDDMMAAAA());
		ventaPendiente.setHoraActual(Util.getStringHoraActualHHMMSS());
		ventaPendiente.setTotalDescCampania(ventaPendienteDTO.getTotalDescCampania());
		ventaPendiente.setTotalDescPreferenc(ventaPendienteDTO.getTotalDescPreferenc());
		ventaPendiente.setDescALaVenta(ventaPendienteDTO.getDescALaVenta());
		ventaPendiente.setTotalVenta(ventaPendienteDTO.getTotalVenta());
		ventaPendiente.setObservacion(ventaPendienteDTO.getObservacion());
		ActorSistema idactorSistema = actorSistemaFacadeEJB.find(ventaPendiente.getIdactorSistema().getIdactorSistema());
		ventaPendiente.setIdactorSistema(idactorSistema);
		Documento iddocumento = documentoFacadeEJB.find(idactorSistema.getIddocumento().getIddocumento());
		ventaPendiente.setIddocumento(iddocumento);
		EstadoVenta idestadoVenta = estadoVentaFacadeEJB.find(ventaPendiente.getIdestadoVenta().getIdestadoVenta());
		ventaPendiente.setIdestadoVenta(idestadoVenta);
		ventaPendienteFacadeEJB.create(ventaPendiente);
	}
	
	public void editar(VentaPendienteDTO ventaPendienteDTO)throws Exception{
		
		validaLong(ventaPendienteDTO.getReferenciaVenta(), "Referencia Venta");
		validaBigDecimal(ventaPendienteDTO.getTotalDescCampania(), "Total Desc Campania");
		validaBigDecimal(ventaPendienteDTO.getTotalDescPreferenc(), "Total Desc Preferenc");
		validaBigDecimal(ventaPendienteDTO.getDescALaVenta(), "Desc A La Venta");
		validaBigDecimal(ventaPendienteDTO.getTotalVenta(), "Total Venta");
		
		VentaPendiente ventaPendiente = ventaPendienteFacadeEJB.find(ventaPendienteDTO.getIdventaPendiente());
		ventaPendiente.setReferenciaVenta(ventaPendienteDTO.getReferenciaVenta());
		ventaPendiente.setFechaActual(Util.getDateFechaActualDDMMAAAA());
		ventaPendiente.setHoraActual(Util.getStringHoraActualHHMMSS());
		ventaPendiente.setTotalDescCampania(ventaPendienteDTO.getTotalDescCampania());
		ventaPendiente.setTotalDescPreferenc(ventaPendienteDTO.getTotalDescPreferenc());
		ventaPendiente.setDescALaVenta(ventaPendienteDTO.getDescALaVenta());
		ventaPendiente.setTotalVenta(ventaPendienteDTO.getTotalVenta());
		ventaPendiente.setObservacion(ventaPendienteDTO.getObservacion());
		ActorSistema idactorSistema = actorSistemaFacadeEJB.find(ventaPendiente.getIdactorSistema().getIdactorSistema());
		ventaPendiente.setIdactorSistema(idactorSistema);
		Documento iddocumento = documentoFacadeEJB.find(idactorSistema.getIddocumento().getIddocumento());
		ventaPendiente.setIddocumento(iddocumento);
		EstadoVenta idestadoVenta = estadoVentaFacadeEJB.find(ventaPendiente.getIdestadoVenta().getIdestadoVenta());
		ventaPendiente.setIdestadoVenta(idestadoVenta);
		ventaPendienteFacadeEJB.edit(ventaPendiente);
	}
	
	public void eliminar(VentaPendienteDTO ventaPendienteDTO)throws Exception{

		VentaPendiente ventaPendiente = ventaPendienteFacadeEJB.find(ventaPendienteDTO.getIdventaPendiente());		
		ventaPendienteFacadeEJB.remove(ventaPendiente);
	}
	
	public VentaPendienteDTO findId(Long idVentaPendiente)throws Exception{
		
		VentaPendiente ventaPendiente = ventaPendienteFacadeEJB.find(idVentaPendiente);		
		return (VentaPendienteDTO) converterEntityADTO(ventaPendiente);
	}
	
	public List<VentaPendienteDTO> findAll()throws Exception{
		
		List<VentaPendiente> ventaPendienteList = ventaPendienteFacadeEJB.findAll();
		List<VentaPendienteDTO> ventaPendienteListDTO = new ArrayList<VentaPendienteDTO>();
		for(VentaPendiente ventaPendiente : ventaPendienteList){
			VentaPendienteDTO ventaPendienteDTO = (VentaPendienteDTO) converterEntityADTO(ventaPendiente);
			ventaPendienteListDTO.add(ventaPendienteDTO);
		}
		return ventaPendienteListDTO;
	}
	
	@Override
	public Object converterEntityADTO(Object object) throws Exception {

		VentaPendiente ventaPendiente = (VentaPendiente) object;
		
		ActorSistemaDTO idactorSistemaDTO = (ActorSistemaDTO) actorSistemaLogicEJB.converterEntityADTO(ventaPendiente.getIdactorSistema());
		DocumentoDTO iddocumentoDTO = (DocumentoDTO ) documentoLogicEJB.converterEntityADTO(ventaPendiente.getIddocumento());
		EstadoVentaDTO idestadoVentaDTO = (EstadoVentaDTO) estadoVentaLogicEJB.converterEntityADTO(ventaPendiente.getIdestadoVenta());
		
		VentaPendienteDTO ventaPendienteDTO = new VentaPendienteDTO(ventaPendiente.getIdventaPendiente(), ventaPendiente.getReferenciaVenta(), ventaPendiente.getFechaActual(), ventaPendiente.getHoraActual(), ventaPendiente.getTotalDescCampania(), ventaPendiente.getTotalDescPreferenc(), ventaPendiente.getDescALaVenta(), ventaPendiente.getTotalVenta(), ventaPendiente.getObservacion());
		ventaPendienteDTO.setIdactorSistemaDTO(idactorSistemaDTO);
		ventaPendienteDTO.setIddocumentoDTO(iddocumentoDTO);
		ventaPendienteDTO.setIdestadoVentaDTO(idestadoVentaDTO);
		return ventaPendienteDTO;
	}

}
