package pruebasRelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Detalle;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.repository.DetallesRepository;
import net.itinajero.app.repository.PeliculasRepository;

public class App {

	public static void main(String[] args) 
	{
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
//		//Recuperar todas las entidades de tipo pelicula
//		
//		PeliculasRepository repo = context.getBean("peliculasRepository", PeliculasRepository.class);
//		
//		List<Pelicula> lista = repo.findAll();
//		
//		for (Pelicula pelicula : lista) 
//		{
//			System.out.println(pelicula);
//		}
//		
//		context .close();
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		DetallesRepository repo = context.getBean("detallesRepository", DetallesRepository.class);
		
		List<Detalle> lista =repo.findAll();
		
		for (Detalle detalle : lista) 
		{
			System.out.println(detalle);
		}
		
		context .close();


	}

}
