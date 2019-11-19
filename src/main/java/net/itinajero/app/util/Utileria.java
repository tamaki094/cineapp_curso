package net.itinajero.app.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author Arete
 *
 */
public class Utileria 
{
	/**
	 * Metodo que regresa una Lista de Strings con las fechas siguientes. segun el parametro count
	 * @param count
	 * @return
	 */
	public static List<String> getNextDays(int count)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		Date start = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, count);
		Date endDate = cal.getTime(); 
		
		GregorianCalendar gCal = new GregorianCalendar();
		gCal.setTime(start);
		List<String> nextDays = new ArrayList<String>();
		while(!gCal.getTime().after(endDate))
		{
			Date d = gCal.getTime();
			gCal.add(Calendar.DATE, 1);
			nextDays.add(sdf.format(d));
		}
		return nextDays;
		
	}
	
	/**
	 * Metodo para guardar imagen
	 * @param multipart Imagen MultiPart recibida desde el formulario
	 * @param request 
	 * @return nombre del archivo guardado
	 */
	public static String guardarImagen(MultipartFile multipart, HttpServletRequest request)
	{
		//Obtenemos el nombre original del archivo
		String nombreOriginal_Path = multipart.getOriginalFilename();
		System.out.println("nombreOriginal_Path:" + nombreOriginal_Path);
		String nombreOriginal = multipart.getName();
		System.out.println("nombreOriginal: " + nombreOriginal);
		
		String fileName = multipart.getOriginalFilename();
		int startIndex = fileName.replaceAll("\\\\", "/").lastIndexOf("/");
		fileName = fileName.substring(startIndex + 1);
		System.out.println("fileName:" + fileName);
		fileName = fileName.replace(" ", "");
		String nombreFinal = randomAlphaNumeric(8) + fileName;
		
		//Obtenemos la ruta ABSOLUTA del directorio img
		//apache-tomcat/webapps/cineapp/resources/img/
		String rutaFinal = request.getServletContext().getRealPath("/resources/img/");
		
		try 
		{
			//Formamos el nombre del archivo para guardarlo en el disco duro			
			File imageFile = new File(rutaFinal + nombreFinal);
			System.out.println("imageFile: " + imageFile.getAbsolutePath());
		
			
			//Aqui se guarda fiusicamente el archivo en el disco duro
			multipart.transferTo(imageFile);
			
			return nombreFinal;
		} 
		catch (IOException e) 
		{
			System.out.println("Error " + e.getMessage());
			return null;
		}	
	}
	
	/**
	 * Metodo que genera string aleatorio
	 * @param count Longitud del string que devolvera
	 * @return
	 */
	public static String randomAlphaNumeric(int count)
	{
		String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		
		while (count-- != 0) 
		{
			int character = (int)(Math.random() * CARACTERES.length());
			builder.append(CARACTERES.charAt(character));
		}
		
		return builder.toString();
	}
	
	
}
