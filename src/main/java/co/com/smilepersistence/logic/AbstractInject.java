package co.com.smilepersistence.logic;

import java.math.BigDecimal;
import java.util.Date;

import javax.ejb.CreateException;
import javax.inject.Inject;

import co.com.smilepersistence.interfacelocal.AbonoFacadeLocal;
import co.com.smilepersistence.interfacelocal.AbonoLogicLocal;
import co.com.smilepersistence.interfacelocal.ActorSistemaFacadeLocal;
import co.com.smilepersistence.interfacelocal.ActorSistemaLogicLocal;
import co.com.smilepersistence.interfacelocal.BodegaFacadeLocal;
import co.com.smilepersistence.interfacelocal.BodegaLogicLocal;
import co.com.smilepersistence.interfacelocal.CampaniasPromocionalesFacadeLocal;
import co.com.smilepersistence.interfacelocal.CampaniasPromocionalesLogicLocal;
import co.com.smilepersistence.interfacelocal.ConsolidadoVentaFacadeLocal;
import co.com.smilepersistence.interfacelocal.ConsolidadoVentaLogicLocal;
import co.com.smilepersistence.interfacelocal.ConsolidadoVtaDiaFacadeLocal;
import co.com.smilepersistence.interfacelocal.ConsolidadoVtaDiaLogicLocal;
import co.com.smilepersistence.interfacelocal.CredencialesFacadeLocal;
import co.com.smilepersistence.interfacelocal.CredencialesLogicLocal;
import co.com.smilepersistence.interfacelocal.DetalleVentaFacadeLocal;
import co.com.smilepersistence.interfacelocal.DetalleVentaLogicLocal;
import co.com.smilepersistence.interfacelocal.DocumentoFacadeLocal;
import co.com.smilepersistence.interfacelocal.DocumentoLogicLocal;
import co.com.smilepersistence.interfacelocal.EmailFacadeLocal;
import co.com.smilepersistence.interfacelocal.EmailLogicLocal;
import co.com.smilepersistence.interfacelocal.EncargoFacadeLocal;
import co.com.smilepersistence.interfacelocal.EncargoLogicLocal;
import co.com.smilepersistence.interfacelocal.EstadoEntregaFacadeLocal;
import co.com.smilepersistence.interfacelocal.EstadoEntregaLogicLocal;
import co.com.smilepersistence.interfacelocal.EstadoFacadeLocal;
import co.com.smilepersistence.interfacelocal.EstadoLogicLocal;
import co.com.smilepersistence.interfacelocal.EstadoVentaFacadeLocal;
import co.com.smilepersistence.interfacelocal.EstadoVentaLogicLocal;
import co.com.smilepersistence.interfacelocal.FechaInFacadeLocal;
import co.com.smilepersistence.interfacelocal.FechaInLogicLocal;
import co.com.smilepersistence.interfacelocal.FechaOutFacadeLocal;
import co.com.smilepersistence.interfacelocal.FechaOutLogicLocal;
import co.com.smilepersistence.interfacelocal.PersonaFacadeLocal;
import co.com.smilepersistence.interfacelocal.PersonaLogicLocal;
import co.com.smilepersistence.interfacelocal.ProductoFacadeLocal;
import co.com.smilepersistence.interfacelocal.ProductoLogicLocal;
import co.com.smilepersistence.interfacelocal.RolFacadeLocal;
import co.com.smilepersistence.interfacelocal.RolLogicLocal;
import co.com.smilepersistence.interfacelocal.SaldoAFavorFacadeLocal;
import co.com.smilepersistence.interfacelocal.SaldoAFavorLogicLocal;
import co.com.smilepersistence.interfacelocal.TelefonoFacadeLocal;
import co.com.smilepersistence.interfacelocal.TelefonoLogicLocal;
import co.com.smilepersistence.interfacelocal.TipoDocumentoFacadeLocal;
import co.com.smilepersistence.interfacelocal.TipoDocumentoLogicLocal;
import co.com.smilepersistence.interfacelocal.TipoEmailFacadeLocal;
import co.com.smilepersistence.interfacelocal.TipoEmailLogicLocal;
import co.com.smilepersistence.interfacelocal.TipoProductoFacadeLocal;
import co.com.smilepersistence.interfacelocal.TipoProductoLogicLocal;
import co.com.smilepersistence.interfacelocal.TipoTelefonoFacadeLocal;
import co.com.smilepersistence.interfacelocal.TipoTelefonoLogicLocal;
import co.com.smilepersistence.interfacelocal.VentaPendienteFacadeLocal;
import co.com.smilepersistence.interfacelocal.VentaPendienteLogicLocal;
import co.com.smilepersistence.utilidades.Validacion;

public abstract class AbstractInject {

	@Inject protected DocumentoFacadeLocal documentoFacadeEJB;
	@Inject protected DocumentoLogicLocal documentoLogicEJB;
	@Inject protected EmailFacadeLocal emailFacadeEJB;
	@Inject protected EmailLogicLocal emailLogicEJB;
	@Inject protected TipoEmailFacadeLocal tipoEmailFacadeEJB;
	@Inject protected TipoEmailLogicLocal tipoEmailLogicEJB;	
	@Inject protected TipoDocumentoFacadeLocal tipoDocumentoFacadeEJB;
	@Inject protected TipoDocumentoLogicLocal tipoDocumentoLogicEJB;
	@Inject protected TipoTelefonoFacadeLocal tipoTelefonoFacadeEJB;
	@Inject protected TipoTelefonoLogicLocal tipoTelefonoLogicEJB;
	@Inject protected TelefonoFacadeLocal telefonoFacadeEJB;
	@Inject protected TelefonoLogicLocal telefonoLogicEJB;
	@Inject protected RolFacadeLocal rolFacadeEJB;
	@Inject protected RolLogicLocal rolLogicEJB;
	@Inject protected EstadoFacadeLocal estadoFacadeEJB;
	@Inject protected EstadoLogicLocal estadoLogicEJB;
	@Inject protected PersonaFacadeLocal personaFacadeEJB;
	@Inject protected PersonaLogicLocal personaLogicEJB;
	@Inject protected SaldoAFavorFacadeLocal saldoAFavorFacadeEJB;
	@Inject protected SaldoAFavorLogicLocal saldoAFavorLogicEJB;
	@Inject protected CredencialesFacadeLocal credencialesFacadeEJB;
	@Inject protected CredencialesLogicLocal credencialesLogicEJB;
	@Inject protected ActorSistemaFacadeLocal actorSistemaFacadeEJB;
	@Inject protected ActorSistemaLogicLocal actorSistemaLogicEJB;
	@Inject protected TipoProductoFacadeLocal tipoProductoFacadeEJB;
	@Inject protected TipoProductoLogicLocal tipoProductoLogicEJB;
	@Inject protected CampaniasPromocionalesFacadeLocal campaniasPromocionalesFacadeEJB;
	@Inject protected CampaniasPromocionalesLogicLocal campaniasPromocionalesLogicEJB;
	@Inject protected FechaInFacadeLocal fechaInFacadeEJB;
	@Inject protected FechaInLogicLocal fechaInLogicEJB;
	@Inject protected FechaOutFacadeLocal fechaOutFacadeEJB;
	@Inject protected FechaOutLogicLocal fechaOutLogicEJB;
	@Inject protected BodegaFacadeLocal bodegaFacadeEJB;
	@Inject protected BodegaLogicLocal bodegaLogicEJB;
	@Inject protected ProductoFacadeLocal productoFacadeEJB;
	@Inject protected ProductoLogicLocal productoLogicEJB;
	@Inject protected EstadoEntregaFacadeLocal estadoEntregaFacadeEJB;
	@Inject protected EstadoEntregaLogicLocal estadoEntregaLogicEJB;
	@Inject protected EstadoVentaFacadeLocal estadoVentaFacadeEJB;
	@Inject protected EstadoVentaLogicLocal estadoVentaLogicEJB;
	@Inject protected AbonoFacadeLocal abonoFacadeEJB;
	@Inject protected AbonoLogicLocal abonoLogicEJB;
	@Inject protected VentaPendienteFacadeLocal ventaPendienteFacadeEJB;
	@Inject protected VentaPendienteLogicLocal ventaPendienteLogicEJB;
	@Inject protected ConsolidadoVtaDiaFacadeLocal consolidadoVtaDiaFacadeEJB;
	@Inject protected ConsolidadoVtaDiaLogicLocal consolidadoVtaDiaLogicEJB;
	@Inject protected ConsolidadoVentaFacadeLocal consolidadoVentaFacadeEJB;
	@Inject protected ConsolidadoVentaLogicLocal consolidadoVentaLogicEJB;
	@Inject protected DetalleVentaFacadeLocal detalleVentaFacadeEJB;
	@Inject protected DetalleVentaLogicLocal detalleVentaLogicEJB;
	@Inject protected EncargoFacadeLocal encargoFacadeEJB;
	@Inject protected EncargoLogicLocal encargoLogicEJB;
	
	
	public abstract Object converterEntityADTO(Object object)throws Exception;
	
	public void validaLong(Long pParametro,String campo)throws Exception,CreateException{
		Validacion.validaLongNull(pParametro, campo);
		Validacion.validaLongValorCero(pParametro, campo);
	}
	//Validacion Entity Bodega
	public void validaCampoCantidad(Long pParametro)throws Exception,CreateException{
		Validacion.validaLongNull(pParametro, "Cantidad");
		Validacion.validaLongSoloNumero(pParametro, "Cantidad");
		Validacion.validaLongSoloNumeroPositivo(pParametro, "Cantidad");
	}
	public void validaCampoTopeMax(Integer pParametro)throws Exception,CreateException{		
		validaInteger(pParametro,"Tope Maximo");		
	}
	public void validaCampoTopeMin(Integer pParametro)throws Exception,CreateException{		
		validaInteger(pParametro,"Tope Minimo");		
	}
	//Fin validacion EntityBodega
	
	//Validacion Entity Producto
	public void validaCampoNombre(String obj,int minCaracteres,int maxCaracteres)throws Exception,CreateException {
		validaString(obj, minCaracteres, maxCaracteres, "Nombre");
	}
	public void validaCampoValor(BigDecimal valor)throws Exception,CreateException{
		Validacion.validaBigDecimalNull(valor, "Valor");
	}
	public void validaBigDecimal(BigDecimal valor,String campo)throws Exception,CreateException{
		Validacion.validaBigDecimalNull(valor, campo);
	}
	//Fin validacion Producto
	
	public void validaInteger(Integer obj,String campo)throws Exception,CreateException{		
		Validacion.validaIntegerNull(obj, campo);
		Validacion.validaIntegerSoloNumeros(obj,campo);
		Validacion.validaIntegerSoloNumerosPositivosMayoresACero(obj,campo);		
	}
	public void validaFechaInicio(Date obj) throws Exception,CreateException{
		Validacion.validaDateNull(obj, "Fecha Inicio");
	}
	public void validaFechaFin(Date obj) throws Exception,CreateException{
		Validacion.validaDateNull(obj, "Fecha Fin");
	}
	public void validaString(String obj,int minCaracteres,int maxCaracteres,String campo) throws Exception{
		Validacion.validaStringNull(obj, campo);
		Validacion.validaStringVacio(obj, campo);
		Validacion.validaStringValorCero(obj, campo);
		Validacion.validaStringCantidadMinCaracteres(obj, minCaracteres, campo);
		Validacion.validaStringCantidadMaxCaracteres(obj, maxCaracteres, campo);
	}
	public void validaLogin(String obj,int minCaracteres,int maxCaracteres) throws Exception{
		Validacion.validaStringNull(obj, "Usuario");
		Validacion.validaStringVacio(obj, "Usuario");
		Validacion.validaStringValorCero(obj, "Usuario");
		Validacion.validaStringCantidadMinCaracteres(obj, minCaracteres, "Usuario");
		Validacion.validaStringCantidadMaxCaracteres(obj, maxCaracteres, "Usuario");
	}
	public void validaClave(String obj,int minCaracteres,int maxCaracteres) throws Exception{
		Validacion.validaStringNull(obj, "Clave");
		Validacion.validaStringVacio(obj, "Clave");
		Validacion.validaStringValorCero(obj, "Clave");
		Validacion.validaStringCantidadMinCaracteres(obj, minCaracteres, "Clave");
		Validacion.validaStringCantidadMaxCaracteres(obj, maxCaracteres, "Clave");
	}
	public void validaNombre(String nombre,int minCaracteres,int maxCaracteres) throws Exception{
		Validacion.validaStringNull(nombre, "Nombre");
		Validacion.validaStringVacio(nombre, "Nombre");
		Validacion.validaStringValorCero(nombre, "Nombre");
		Validacion.validaStringCantidadMinCaracteres(nombre, minCaracteres, "Nombre");
		Validacion.validaStringCantidadMaxCaracteres(nombre, maxCaracteres, "Nombre");
	}
	public void validaNumerotelefono(String numeroTelefono,int minCaracteres,int maxCaracteres)throws Exception{
		
		Validacion.validaStringNull(numeroTelefono, "Numero Telefono");
		Validacion.validaStringVacio(numeroTelefono, "Numero Telefono");
		Validacion.validaStringValorCero(numeroTelefono, "Numero Telefono");
		Validacion.validaStringCantidadMinCaracteres(numeroTelefono, minCaracteres, "Numero Telefono");
		Validacion.validaStringCantidadMaxCaracteres(numeroTelefono, maxCaracteres, "Numero Telefono");
		Validacion.validaStringSoloNumeros(numeroTelefono, "Numero Telefono");
	}
	public void validaEmail(String pParametro,int minCaracteres,int maxCaracteres) throws Exception,CreateException{
		Validacion.validaStringNull(pParametro, "Email");
		Validacion.validaStringVacio(pParametro, "Email");
		Validacion.validaStringValorCero(pParametro, "Email");
		Validacion.validaStringCantidadMinCaracteres(pParametro, minCaracteres, "Email");
		Validacion.validaStringCantidadMaxCaracteres(pParametro, maxCaracteres, "Email");
		Validacion.validaEmail(pParametro);
	}
	
	public void validaNumDocumento(String numDocumento,int minCaracteres,int maxCaracteres) throws Exception{
		
		Validacion.validaStringNull(numDocumento, "Numero Documento");
		Validacion.validaStringVacio(numDocumento, "Numero Documento");
		Validacion.validaStringValorCero(numDocumento, "Numero Documento");
		Validacion.validaStringCantidadMinCaracteres(numDocumento, minCaracteres, "Numero Documento");
		Validacion.validaStringCantidadMaxCaracteres(numDocumento, maxCaracteres, "Numero Documento");
	}
	
}