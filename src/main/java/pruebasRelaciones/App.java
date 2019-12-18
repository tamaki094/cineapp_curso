package pruebasRelaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Detalle;
import net.itinajero.app.model.Horario;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.repository.DetallesRepository;
import net.itinajero.app.repository.HorariosRepository;
import net.itinajero.app.repository.PeliculasRepository;

public class App {

	public static void main(String[] args) 
	{
		//Ejemplo 1--------------------------------------------------------------------------------------------------------
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
		
		//Ejemplo 2--------------------------------------------------------------------------------------------------------
		
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
//		
//		DetallesRepository repo = context.getBean("detallesRepository", DetallesRepository.class);
//		
//		List<Detalle> lista =repo.findAll();
//		
//		for (Detalle detalle : lista) 
//		{
//			System.out.println(detalle);
//		}
//		
//		context .close();
		
		//Ejemplo 3--------------------------------------------------------------------------------------------------------
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
//		
//		HorariosRepository repo = context.getBean("horariosRepository", HorariosRepository.class);
//		
//		List<Horario> lista = repo.findAll();
//		
//		for (Horario horario : lista) {
//			System.out.println(horario);
//		}
//		
//		context .close();
		
		//Ejemplo 4--------------------------------------------------------------------------------------------------------
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		PeliculasRepository repo = context.getBean("peliculasRepository", PeliculasRepository.class);
		
		
		Optional<Pelicula> optional = repo.findById(7);
		
		 System.out.println(optional.get().getHorarios().size() + " horarios para la pelicula.");
		 System.out.println(optional.get());
		
		context .close();

	}

}
