package co.com.smilepersistence.utilidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 01/05/2018 9:46 PM
 * @author FABIO
 *
 */
public class Util {

	/**
	 * 
	 * @return Retorna fecha del sistema separado por slash de tipo String
	 * @throws Exception
	 */
	public static Date getDateFechaActualDDMMAAAA() throws Exception{
		Date date = new Date();
		DateFormat fechaActal = new SimpleDateFormat("dd/MM/yyyy");
		String strFechaActaul = fechaActal.format(date);		
		return new Date (strFechaActaul);
	}
	
	/**
	 * 
	 * @return Retorna hora, minutos y segundos del sistema, separado por dos puntos
	 * @throws Exception
	 */
	public static String getStringHoraActualHHMMSS() throws Exception{
		Date date = new Date();
		DateFormat horaActual = new SimpleDateFormat("HH:mm:ss");
		String strHoraActual = horaActual.format(date);
		return strHoraActual;
	}
	
}
