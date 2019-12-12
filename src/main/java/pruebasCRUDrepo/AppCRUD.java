package pruebasCRUDrepo;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppCRUD 
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
				
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); //Creamos una  instancia del [applicationContext] de SPRING  utulizando la implementacion [ClassPath...], lee la configuracion de los BEANS desde un archivo XML.
//		
//		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class); //nombre de la instancia lo tomara encuenta con el nombre de la interfaz(camel Case), en caso de que no lo hayamos especificado en la anotacion Repository	
//		
//		Iterable<Noticia> noticias = repo.findAll();
//		
//		for (Noticia noticia : noticias) 
//		{
//			System.out.println(noticia);
//		}
//			
//		context.close();
		
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
		//Ejemplo 8: DELETE 
//				
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); //Creamos una  instancia del [applicationContext] de SPRING  utulizando la implementacion [ClassPath...], lee la configuracion de los BEANS desde un archivo XML.
//		
//		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class); //nombre de la instancia lo tomara encuenta con el nombre de la interfaz(camel Case), en caso de que no lo hayamos especificado en la anotacion Repository	
//			
//		repo.deleteAll(); //Borra todos los datos de la tabla
//			
//		context.close();
		
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
		//Ejemplo 9:  SELECT WHERE id IN (1 , 2, 3 .... n)
		
		List<Noticia> noticias = new LinkedList<Noticia>();
				
		Noticia noticia = new Noticia();
		noticia.setTitulo("Frozen II' incluye un guiño a Big Hero 6");
		noticia.setDetalle("Tras semanas en la cartelera, el último estreno de Disney sigue sorprendiendo con referencias a la película de Baymax.");
		noticias.add(noticia);
		
		Noticia noticia2 = new Noticia();
		noticia2.setTitulo("En un barrio de Nueva York: Tráiler en español de la adaptación del musical de Lin Manuel-Miranda");
		noticia2.setDetalle("La cinta, dirigida por Jon M. Chu, está protagonizada por Dascha Polanco, Corey Hawkins y Anthony Ramos. ¡Estreno el 31 de julio de 2020!.");
		noticias.add(noticia2);
		
		Noticia noticia3 = new Noticia();
		noticia3.setTitulo("Eva Green (Próxima): Fue realmente fascinante descubrir lo chiflados que están los astronautas");
		noticia3.setDetalle("El último trabajo de la directora y guionista francesa Alice Winocour (Augustine, Disorder: El protector, Mustang) se estrena en cines este viernes 13 de diciembre.");
		noticias.add(noticia3);
		
		Noticia noticia4 = new Noticia();
		noticia4.setTitulo("La censura de los 70 al ritmo de Raffaella Carrá. Visitamos el rodaje de Explota explota");
		noticia4.setDetalle("Nacho Álvarez dirige su ópera prima, una nueva comedia musical protagonizada por Ingrid García-Jonsson.");
		noticias.add(noticia4);
		
		Noticia noticia5 = new Noticia();
		noticia5.setTitulo("La extraña conexión entre Midway y Star Wars");
		noticia5.setDetalle("El Ascenso de Skywalker, dirigida por J.J. Abrams, se estrena el 19 de diciembre en España.");
		noticias.add(noticia5);
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); //Creamos una  instancia del [applicationContext] de SPRING  utulizando la implementacion [ClassPath...], lee la configuracion de los BEANS desde un archivo XML.
		
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class); //nombre de la instancia lo tomara encuenta con el nombre de la interfaz(camel Case), en caso de que no lo hayamos especificado en la anotacion Repository	
		
		for (Noticia item : noticias) 
		{
			repo.save(item);
		}
		
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(1);
		ids.add(3);
		ids.add(6);
		
		Iterable<Noticia> it = repo.findAllById(ids);
		
		for (Noticia item : it) 
		{
			System.out.println(item.getTitulo());
		}
			
		context.close();

	}

}
