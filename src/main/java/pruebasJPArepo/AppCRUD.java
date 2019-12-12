package pruebasJPArepo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppCRUD {

	public static void main(String[] args) 
	{

		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
		//Ejemplo 1: SELECT 
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); //Creamos una  instancia del [applicationContext] de SPRING  utulizando la implementacion [ClassPath...], lee la configuracion de los BEANS desde un archivo XML.
//		
//		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class); //nombre de la instancia lo tomara encuenta con el nombre de la interfaz(camel Case), en caso de que no lo hayamos especificado en la anotacion Repository	
//		
//		List<Noticia> lista = repo.findAll();
//		
//		for (Noticia noticia : lista) 
//		{
//			System.out.println(noticia);
//		}
//		
//		context.close();
		

		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
		//Ejemplo 2: DELETE 
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); //Creamos una  instancia del [applicationContext] de SPRING  utulizando la implementacion [ClassPath...], lee la configuracion de los BEANS desde un archivo XML.
//		
//		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class); //nombre de la instancia lo tomara encuenta con el nombre de la interfaz(camel Case), en caso de que no lo hayamos especificado en la anotacion Repository	
//		
//		repo.deleteAllInBatch(); //Ejecuta un DELETE por cada Registro a diferiencia del deleteAll();
//			
//		context.close();
		

		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
		//Ejemplo 3: SELECT ORDER BY 
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); //Creamos una  instancia del [applicationContext] de SPRING  utulizando la implementacion [ClassPath...], lee la configuracion de los BEANS desde un archivo XML.
//		
//		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class); //nombre de la instancia lo tomara encuenta con el nombre de la interfaz(camel Case), en caso de que no lo hayamos especificado en la anotacion Repository	
//		
//		List<Noticia> lista = repo.findAll(Sort.by("titulo")); //Ordenar por [titulo]
//		
//		for (Noticia noticia : lista) 
//		{
//			System.out.println(noticia.getTitulo());
//		}
//		
//		List<Noticia> lista2 = repo.findAll(Sort.by("titulo").descending()); //Ordenar por [titulo]
//		
//		for (Noticia noticia : lista2) 
//		{
//			System.out.println(noticia.getTitulo());
//		}
//			
//		context.close();
		
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
		//Ejemplo 4: SELECT ORDER BY 
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); //Creamos una  instancia del [applicationContext] de SPRING  utulizando la implementacion [ClassPath...], lee la configuracion de los BEANS desde un archivo XML.
//		
//		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class); //nombre de la instancia lo tomara encuenta con el nombre de la interfaz(camel Case), en caso de que no lo hayamos especificado en la anotacion Repository	
//		
//		List<Noticia> lista = repo.findAll(Sort.by("fecha").descending().and(Sort.by("titulo").ascending())); //Ordenar por [titulo]
//		
//		for (Noticia noticia : lista) 
//		{
//			System.out.println(noticia);
//		}
//		
//		
//		context.close();
		
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
		//Ejemplo 5: PAGINACION
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); //Creamos una  instancia del [applicationContext] de SPRING  utulizando la implementacion [ClassPath...], lee la configuracion de los BEANS desde un archivo XML.
		
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class); //nombre de la instancia lo tomara encuenta con el nombre de la interfaz(camel Case), en caso de que no lo hayamos especificado en la anotacion Repository	
		
//		Page<Noticia> noticias = repo.findAll(PageRequest.of(0, 2));
		
		Page<Noticia> noticias = repo.findAll(PageRequest.of(0, 3, Sort.by("titulo").ascending()));
		
		for (Noticia noticia : noticias) 
		{
			System.out.println(noticia);
		}
			
		context.close();

	}

}
