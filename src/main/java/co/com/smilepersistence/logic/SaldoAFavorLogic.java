package co.com.smilepersistence.logic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import co.com.remoteinterface.modelo.DocumentoDTO;
import co.com.remoteinterface.modelo.SaldoAFavorDTO;
import co.com.smilepersistence.entity.Documento;
import co.com.smilepersistence.entity.SaldoAFavor;
import co.com.smilepersistence.interfacelocal.SaldoAFavorLogicLocal;
import co.com.smilepersistence.utilidades.Util;

public class SaldoAFavorLogic extends AbstractInject implements SaldoAFavorLogicLocal{

	public void crear(SaldoAFavorDTO saldoAFavorDTO) throws Exception{
		
		validaSaldo(saldoAFavorDTO.getSaldo());
		
		SaldoAFavor saldoAFavor = new SaldoAFavor();
		saldoAFavor.setIdsaldoAFavor(1L);
		Documento iddocumento = documentoFacadeEJB.find(saldoAFavorDTO.getIddocumentoDTO().getIddocumento());
		saldoAFavor.setIddocumento(iddocumento);
		saldoAFavor.setFechaActual(Util.getDateFechaActualDDMMAAAA());
		saldoAFavor.setHoraActual(Util.getStringHoraActualHHMMSS());
		saldoAFavor.setSaldo(saldoAFavorDTO.getSaldo());
		
		saldoAFavorFacadeEJB.create(saldoAFavor);
	}
	
	public void editar(SaldoAFavorDTO saldoAFavorDTO) throws Exception{
		
		validaSaldo(saldoAFavorDTO.getSaldo());
		
		SaldoAFavor saldoAFavor = saldoAFavorFacadeEJB.find(saldoAFavorDTO.getIdsaldoAFavor());
		Documento iddocumento = documentoFacadeEJB.find(saldoAFavorDTO.getIddocumentoDTO().getIddocumento());
		saldoAFavor.setIddocumento(iddocumento);
		saldoAFavor.setFechaActual(Util.getDateFechaActualDDMMAAAA());
		saldoAFavor.setHoraActual(Util.getStringHoraActualHHMMSS());
		saldoAFavor.setSaldo(saldoAFavorDTO.getSaldo());
		
		saldoAFavorFacadeEJB.edit(saldoAFavor);
	}
	
	public void eliminar(SaldoAFavorDTO saldoAFavorDTO) throws Exception{

		SaldoAFavor saldoAFavor = saldoAFavorFacadeEJB.find(saldoAFavorDTO.getIdsaldoAFavor());			
		saldoAFavorFacadeEJB.remove(saldoAFavor);
	}
	
	public SaldoAFavorDTO findId(Long idSaldoAFavor) throws Exception{
		
		SaldoAFavor saldoAFavor = saldoAFavorFacadeEJB.find(idSaldoAFavor);
		return (SaldoAFavorDTO) converterEntityADTO(saldoAFavor);
	}
	
	public List<SaldoAFavorDTO> findAll() throws Exception{
		List<SaldoAFavor> saldoAFavorList = saldoAFavorFacadeEJB.findAll();
		List<SaldoAFavorDTO> saldoAFavorListDTO = new ArrayList<SaldoAFavorDTO>();
		for(SaldoAFavor saldoAFavor : saldoAFavorList){
			SaldoAFavorDTO saldoAFavorDTO = (SaldoAFavorDTO) converterEntityADTO(saldoAFavor);
			saldoAFavorListDTO.add(saldoAFavorDTO);
		}
		
		return saldoAFavorListDTO;
	}
	
	public void validaSaldo(BigDecimal saldo)throws Exception{
		
	}	

	@Override
	public Object converterEntityADTO(Object object) throws Exception {
		SaldoAFavor saldoAFavor = (SaldoAFavor) object;		
		DocumentoDTO iddocumentoDTO = (DocumentoDTO) documentoLogicEJB.converterEntityADTO(saldoAFavor.getIddocumento());
		SaldoAFavorDTO saldoAFavorDTO = new SaldoAFavorDTO(saldoAFavor.getIdsaldoAFavor(), saldoAFavor.getFechaActual(), saldoAFavor.getHoraActual(), saldoAFavor.getSaldo());
		saldoAFavorDTO.setIddocumentoDTO(iddocumentoDTO);
		return saldoAFavorDTO;
	}
}
