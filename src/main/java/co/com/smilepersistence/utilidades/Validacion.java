package co.com.smilepersistence.utilidades;

import java.math.BigDecimal;
import java.util.Date;

import javax.ejb.CreateException;

public class Validacion {

	//Validaciones Estring
	public static void validaStringNull(String obj,String campo) throws Exception,CreateException{
		
		if(obj==null){
			throw new CreateException("Campo "+campo+" No puede ser nulo");
		}

	}
	
	public static void validaStringVacio(String obj,String campo)throws Exception,CreateException{
	
		if(obj.isEmpty()){
			throw new CreateException("Campo "+campo+" No puede estar vacio");
		}
		
	}
	
	public static void validaStringValorCero(String obj, String campo) throws Exception,CreateException{
	
		int entero = new Integer(obj);
		if(entero==0){
			throw new CreateException("Campo "+campo+" debe ser diferente de cero");
		}
	}
	
	public static void validaStringCantidadMinCaracteres(String obj,int minCaracteres,String campo) throws Exception,CreateException{

		if(obj.length()<=minCaracteres){
			throw new CreateException("Campo "+campo+" Min "+minCaracteres+" caracteres");
		}
	}
	
	public static void validaStringCantidadMaxCaracteres(String obj,int maxCaracteres,String campo) throws Exception,CreateException{

		if(obj.length()>maxCaracteres){
			throw new CreateException("Campo "+campo+" Max "+maxCaracteres+" caracteres");
		}
	}
	
	public static void validaStringSoloNumeros(String obj,String campo) throws Exception,CreateException{

		try {
			new Integer(obj);
		} catch (Exception e) {
			throw new CreateException("Campo "+campo+" Solo Numeros");
		}
	}
	
	public static void validaEmail(String obj) throws Exception,CreateException{

		//Validacion de correo con expresiones regulares
		throw new CreateException("Campo Email no contiene un correo valido");
		
	}
	
	public static void validaLongNull(Long obj,String campo) throws Exception,CreateException{
		
		if(obj==null){
			throw new CreateException("Campo "+campo+" No puede ser nulo");
		}

	}
	
	public static void validaLongValorCero(Long obj, String campo) throws Exception,CreateException{
	
		if(obj==0){
			throw new CreateException("Campo "+campo+" debe ser diferente de cero");
		}
	}
	
	public static void validaLongSoloNumero(Long obj, String campo) throws Exception,CreateException{
		
		try {
			new Long(obj.longValue());
		} catch (Exception e) {
			throw new CreateException("Campo "+campo+" Solo numeros");
		}
		if(obj<=0){
			
		}
	}

	public static void validaLongSoloNumeroPositivo(Long obj, String campo) throws Exception,CreateException{
		
		if(obj<=0){
			throw new CreateException("Campo "+campo+" Solo numeros positivos mayores a cero");
		}
	}
	
	public static void validaIntegerNull(Integer obj, String campo) throws Exception , CreateException{
		if(obj == null){
			throw new CreateException("Campo "+campo+ " No puede ser nulo");
		}
	}
	
	public static void validaIntegerSoloNumeros(Integer obj, String campo) throws Exception , CreateException{
		
		try {
			new Integer (obj);
		} catch (Exception e) {
			throw new CreateException("Campo "+campo+ " Solo Numeros");
		}
	}
	public static void validaIntegerValorCero(Integer obj, String campo) throws Exception , CreateException{
		if(obj == 0){
			throw new CreateException("Campo "+campo+ " debe ser diferente de cero");
		}
	}
	public static void validaIntegerSoloNumerosPositivosMayoresACero(Integer obj, String campo) throws Exception , CreateException{
		if(obj<1){
			throw new CreateException("Campo "+campo+ " Solo numeros positivos mayores a cero");
		}
		
	}
	
	public static void validaDateNull(Date obj,String campo)throws Exception,CreateException{
		if(obj == null){
			throw new CreateException("Campo "+campo+ " No puede ser nulo");
		}
	}
	
	public static void validaBigDecimalNull(BigDecimal obj,String campo)throws Exception,CreateException{
		if(obj == null){
			throw new CreateException("Campo "+campo+ " No puede ser nulo");
		}
	}
	
}