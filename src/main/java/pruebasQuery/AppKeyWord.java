package pruebasQuery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppKeyWord {

	public static void main(String[] args) 
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); //Creamos una  instancia del [applicationContext] de SPRING  utulizando la implementacion [ClassPath...], lee la configuracion de los BEANS desde un archivo XML.
		
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class); //nombre de la instancia lo tomara encuenta con el nombre de la interfaz(camel Case), en caso de que no lo hayamos especificado en la anotacion Repository	
				
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		
		try 
		{
//			List<Noticia> lista = repo.findByEstatus("Activa");
//			List<Noticia> lista = repo.findByFecha(format.parse("2019-12-12"));
//			List<Noticia> lista = repo.findByEstatusAndFecha("Activa", format.parse("2019-12-11"));
//			List<Noticia> lista = repo.findByEstatusOrFecha("Activa", format.parse("2019-12-11"));
//			List<Noticia> lista = repo.findByFechaBetween(format.parse("2019-12-09"), format.parse("2019-12-11"));
			List<Noticia> lista = repo.findByFechaBetween(format.parse("2019-12-09"), format.parse("2019-12-11"));
			
			for (Noticia noticia : lista) 
			{	
				System.out.println(noticia);
			}

		} 
		catch (ParseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		context.close();

	}

}
