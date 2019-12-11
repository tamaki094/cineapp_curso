package pruebasJpa;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppCreate 
{

	public static void main(String[] args) 
	{
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------		
		//Ejemplo 1: INSERT
		
//		Noticia noticia = new Noticia();
//		noticia.setTitulo("Proximo Estreno: SAO 3");
//		noticia.setDetalle("El mes siguiente habra lanzamiento de nueva temporada de este anime");
//		
//		
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); //Creamos una  instancia del [applicationContext] de SPRING  utulizando la implementacion [ClassPath...], lee la configuracion de los BEANS desde un archivo XML.
//		
//		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class); //nombre de la instancia lo tomara encuenta con el nombre de la interfaz(camel Case), en caso de que no lo hayamos especificado en la anotacion Repository
//		
//		repo.save(noticia); //Insert
//			
//		context.close();
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
		//Ejemplo 2: SELECT WHERE [id]
		
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); //Creamos una  instancia del [applicationContext] de SPRING  utulizando la implementacion [ClassPath...], lee la configuracion de los BEANS desde un archivo XML.
//		
//		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class); //nombre de la instancia lo tomara encuenta con el nombre de la interfaz(camel Case), en caso de que no lo hayamos especificado en la anotacion Repository	
//		
////		Noticia noticia = repo.findById(1).get();
//		Optional<Noticia> noticia = repo.findById(1); //ventaja de clase Optional: No lanza Excepciones con NULL's
//		
//		System.out.println(noticia);
//		
//		context.close();
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
		//Ejemplo 3: UPDATE
		
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); //Creamos una  instancia del [applicationContext] de SPRING  utulizando la implementacion [ClassPath...], lee la configuracion de los BEANS desde un archivo XML.
//		
//		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class); //nombre de la instancia lo tomara encuenta con el nombre de la interfaz(camel Case), en caso de que no lo hayamos especificado en la anotacion Repository	
//		
//		Optional<Noticia> optional = repo.findById(1);
//		
//		if(optional.isPresent() == true) //si encuentra la noticia...
//		{
//			Noticia noticia = optional.get();
//			System.out.println(noticia);
//			
//			noticia.setEstatus("Inactiva");
//			repo.save(noticia); //Tambien para Actualizacion se usa el metodo SAVE, si ya existe el [Id] hace un UPDATE en vez de un INSERT, si el campo [Id] ES 0 hace un INSERT
//			
//		}
//		
//		context.close();
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
		//Ejemplo 4: SELECT WHERE ID [EXIST]
				
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); //Creamos una  instancia del [applicationContext] de SPRING  utulizando la implementacion [ClassPath...], lee la configuracion de los BEANS desde un archivo XML.
//		
//		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class); //nombre de la instancia lo tomara encuenta con el nombre de la interfaz(camel Case), en caso de que no lo hayamos especificado en la anotacion Repository	
//		
//		int IdNoticia = 500;
//		
//		System.out.println("Existe la Noticia con el id " + IdNoticia + "?: " + repo.existsById(IdNoticia));
//		
//		context.close();
		
//		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
//		//Ejemplo 5: DELETE WHERE id
//				
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); //Creamos una  instancia del [applicationContext] de SPRING  utulizando la implementacion [ClassPath...], lee la configuracion de los BEANS desde un archivo XML.
//		
//		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class); //nombre de la instancia lo tomara encuenta con el nombre de la interfaz(camel Case), en caso de que no lo hayamos especificado en la anotacion Repository	
//		
//		int IdNoticia = 1;
//		
//		repo.deleteById(IdNoticia); //Lanza Exception si se manda un [Id] que no existe
//		
//		context.close();
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
		//Ejemplo 6: SELECT COUNT()
				
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); //Creamos una  instancia del [applicationContext] de SPRING  utulizando la implementacion [ClassPath...], lee la configuracion de los BEANS desde un archivo XML.
//		
//		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class); //nombre de la instancia lo tomara encuenta con el nombre de la interfaz(camel Case), en caso de que no lo hayamos especificado en la anotacion Repository	
//		
//		long num = repo.count();
//		
//		System.out.println("Se encontraron: " + num + " registros.");
//		
//		Noticia noticia = new Noticia();
//		noticia.setTitulo("Proximo Estreno: SAO 3");
//		noticia.setDetalle("El mes siguiente habra lanzamiento de nueva temporada de este anime");
//		
//		repo.save(noticia); //Insert
//		
//		num = repo.count();
//		
//		System.out.println("Se encontraron: " + num + " registros.");
//		
//		context.close();
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
		//Ejemplo 7: SELECT 
				
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); //Creamos una  instancia del [applicationContext] de SPRING  utulizando la implementacion [ClassPath...], lee la configuracion de los BEANS desde un archivo XML.
		
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class); //nombre de la instancia lo tomara encuenta con el nombre de la interfaz(camel Case), en caso de que no lo hayamos especificado en la anotacion Repository	
		
		Iterable<Noticia> noticias = repo.findAll();
		
		for (Noticia noticia : noticias) 
		{
			System.out.println(noticia);
		}
			
		context.close();

	}

}
