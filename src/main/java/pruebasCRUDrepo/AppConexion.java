package pruebasCRUDrepo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppConexion 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); //Creamos una  instancia del [applicationContext] de SPRING  utulizando la implementacion [ClassPath...], lee la configuracion de los BEANS desde un archivo XML.
		
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		List<Noticia> noticias = repo.findAll();
		
		for (Noticia noticia : noticias) {
			System.out.println(noticia);
		}
				
		
		
		context.close();

	}

}
