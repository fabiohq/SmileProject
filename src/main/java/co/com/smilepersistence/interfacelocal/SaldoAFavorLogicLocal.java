package co.com.smilepersistence.interfacelocal;

import java.util.List;

import co.com.remoteinterface.modelo.SaldoAFavorDTO;

public interface SaldoAFavorLogicLocal {

	public void crear(SaldoAFavorDTO saldoAFavorDTO) throws Exception;
	public void editar(SaldoAFavorDTO saldoAFavorDTO) throws Exception;
	public void eliminar(SaldoAFavorDTO saldoAFavorDTO) throws Exception;
	public SaldoAFavorDTO findId(Long idSaldoAFavor) throws Exception;
	public List<SaldoAFavorDTO> findAll() throws Exception;
	public Object converterEntityADTO(Object object) throws Exception;
}
