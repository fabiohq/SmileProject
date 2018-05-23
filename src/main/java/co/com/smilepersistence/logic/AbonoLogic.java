package co.com.smilepersistence.logic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.CreateException;

import co.com.remoteinterface.modelo.AbonoDTO;
import co.com.remoteinterface.modelo.VentaPendienteDTO;
import co.com.smilepersistence.entity.Abono;
import co.com.smilepersistence.entity.VentaPendiente;
import co.com.smilepersistence.interfacelocal.AbonoLogicLocal;
import co.com.smilepersistence.utilidades.Util;

public class AbonoLogic extends AbstractInject implements AbonoLogicLocal {

	public void crear(AbonoDTO abonoDTO)throws Exception{
		
		validaCampoValor(abonoDTO.getValor());
		Abono abono = new Abono();
		abono.setIdabono(1L);
		abono.setFechaActual(Util.getDateFechaActualDDMMAAAA());
		abono.setHoraActual(Util.getStringHoraActualHHMMSS());
		abono.setValor(abonoDTO.getValor());
		abono.setObservacion(abonoDTO.getObservacion());
		VentaPendiente idventaPendiente = ventaPendienteFacadeEJB.find(abonoDTO.getIdventaPendienteDTO().getIdventaPendiente());
		abono.setIdventaPendiente(idventaPendiente);
		
		abonoFacadeEJB.create(abono);
	}
	
	public void editar(AbonoDTO abonoDTO)throws Exception{
		
		validaCampoValor(abonoDTO.getValor());
		Abono abono = abonoFacadeEJB.find(abonoDTO.getIdabono());
		abono.setFechaActual(Util.getDateFechaActualDDMMAAAA());
		abono.setHoraActual(Util.getStringHoraActualHHMMSS());
		abono.setValor(abonoDTO.getValor());
		abono.setObservacion(abonoDTO.getObservacion());
		VentaPendiente idventaPendiente = ventaPendienteFacadeEJB.find(abonoDTO.getIdventaPendienteDTO().getIdventaPendiente());
		abono.setIdventaPendiente(idventaPendiente);
		
		abonoFacadeEJB.edit(abono);
	}
	
	public void eliminar(AbonoDTO abonoDTO)throws Exception{		
		Abono abono = abonoFacadeEJB.find(abonoDTO.getIdabono());				
		abonoFacadeEJB.remove(abono);
	}
	
	public AbonoDTO findId(Long idAbono)throws Exception{		
		Abono abono = abonoFacadeEJB.find(idAbono);
		return (AbonoDTO) converterEntityADTO(abono);
	}
	
	public List<AbonoDTO> findAll()throws Exception{		
		List<Abono> abonoList = abonoFacadeEJB.findAll();
		List<AbonoDTO> abonoListDTO = new ArrayList<AbonoDTO>();
		for(Abono abono : abonoList){
			AbonoDTO abonoDTO = (AbonoDTO) converterEntityADTO(abono);
			abonoListDTO.add(abonoDTO);
		}
		return abonoListDTO;
	}
	
	@Override
	public void validaCampoValor(BigDecimal valor) throws Exception, CreateException {
		// TODO Auto-generated method stub
		super.validaCampoValor(valor);
	}
	@Override
	public Object converterEntityADTO(Object object) throws Exception {
		Abono abono = (Abono) object;
		VentaPendiente idVentaPendiente = abono.getIdventaPendiente();
		VentaPendienteDTO idventaPendienteDTO = (VentaPendienteDTO) ventaPendienteLogicEJB.converterEntityADTO(idVentaPendiente);
		
		AbonoDTO abonoDTO = new AbonoDTO(abono.getIdabono(), abono.getFechaActual(), abono.getHoraActual(), abono.getValor(), abono.getObservacion());
		abonoDTO.setIdventaPendienteDTO(idventaPendienteDTO);
		return abonoDTO;
	}

}
