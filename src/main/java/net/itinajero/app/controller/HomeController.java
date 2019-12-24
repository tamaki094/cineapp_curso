package net.itinajero.app.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.taglibs.standard.extra.spath.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.model.Detalle;
import net.itinajero.app.model.Horario;
import net.itinajero.app.service.IBannersService;
import net.itinajero.app.service.IHorariosService;
import net.itinajero.app.service.IPeliculasService;
import net.itinajero.app.util.Utileria;

@Controller
public class HomeController 
{
	@Autowired
	private IBannersService serviceBanners;

	@Autowired
	private IPeliculasService servicePeliculas; /*al arrancar nuestra aplicacion , spring va inyectar una instancia de clase de servicio, en esta variable */
	
	@Autowired
	private IHorariosService serviceHorarios;
	
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome()
	{		
		return "home";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String buscar(@RequestParam("fecha") String fecha, Model model)
	{
		List<String> listaFechas = Utileria.getNextDays(4);
		System.out.println(listaFechas);
				
		List<Pelicula> peliculas = servicePeliculas.buscarTodas();
		 
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechas", listaFechas);
		
		model.addAttribute("banners", serviceBanners.buscarTodos());

		
		System.out.println("Buscando todas las peliculas en exhibicion para la fecha: " + fecha);
		return "home";
	}
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model)
	{
//		List<String> peliculas = new LinkedList<>();
//		peliculas.add("Rapidos y furiosos");
//		peliculas.add("El aro 2");
//		peliculas.add("Aliens");
//		model.addAttribute("peliculas", peliculas);
//		   
//		return "home";
		
		List<String> listaFechas = Utileria.getNextDays(4);
		System.out.print(listaFechas);
				
		List<Pelicula> peliculas = servicePeliculas.buscarTodas();
		
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechas", listaFechas);
		
		model.addAttribute("banners", serviceBanners.buscarTodos());
		
		
		
		return "home";
	}	
	
//	@RequestMapping(value="/detail/{id}/{fecha}", method=RequestMethod.GET)
//	public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula, @PathVariable("fecha") String fecha)
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String mostrarDetalle(Model model, @RequestParam("id_movie") int idPelicula, @RequestParam("fecha_movie") Date fecha)
	{
		List<Horario> horarios = serviceHorarios.buscarPorIdPelicula(idPelicula, fecha);
		
		System.out.println("idPelicula: " + idPelicula);
  
		
		System.out.println("Horarios encontrados: " + horarios.size());
		
		for (Horario horario : horarios) {
			System.out.println(horario);
		}
		
		model.addAttribute("horarios", horarios);
		model.addAttribute("fechaBusqueda", dateFormat.format(fecha));
		model.addAttribute("pelicula", servicePeliculas.buscarPorId(idPelicula));
		
		//Pendiente: 	Buscar en la base de datos los horarios
				
//		String tituloPelicula = "Rapidos y furiosos";
//		int duracion = 136;
//		double precioEntrada = 50;
//		
//		model.addAttribute("titulo", tituloPelicula);
//		model.addAttribute("dracion", duracion);
//		model.addAttribute("precio", precioEntrada);
		
		return "detalle"; //crear archivo JSP con este nombre
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false)); //para todas las propiedades de tipo Date, cuando se haga el DataBinding vas a crear un nuebo objeto de tipo [CustomDateEditor] que sirve para registrar le foormtato que sera utilizado para dar formato a las fechas que se usan unicamente en estre controlador
	}
	
	
//	private List<Pelicula> getLista()
//	{
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//		List<Pelicula> lista = null;
//		
//		try 
//		{
//			lista = new LinkedList<>();
//			
//			Pelicula pelicula1 = new Pelicula();
//			pelicula1.set_id(1);
//			pelicula1.set_titulo("Power Rangers");
//			pelicula1.set_duracion(120);
//			pelicula1.set_clasificacion("B");
//			pelicula1.set_genero("Aventura");
//			pelicula1.set_fechaEstreno(formatter.parse("02-05-2017"));
//			pelicula1.set_estatus("Activa");
//			pelicula1.set_imagen("rangers.jpg");
//			
//			Pelicula pelicula2 = new Pelicula();
//			pelicula2.set_id(2);
//			pelicula2.set_titulo("La bella y la bestia");
//			pelicula2.set_duracion(132);
//			pelicula2.set_clasificacion("A");
//			pelicula2.set_genero("Infantil");
//			pelicula2.set_fechaEstreno(formatter.parse("20-05-2017"));
//			pelicula2.set_estatus("Activa");
//			pelicula2.set_imagen("bella.jpg");
//			
//			Pelicula pelicula3 = new Pelicula();
//			pelicula3.set_id(3);
//			pelicula3.set_titulo("Contra Tiempo");
//			pelicula3.set_duracion(106);
//			pelicula3.set_clasificacion("B");
//			pelicula3.set_genero("Thriller");
//			pelicula3.set_fechaEstreno(formatter.parse("28-05-2017"));
//			pelicula3.set_estatus("Activa");
//			pelicula3.set_imagen("tiempo.jpg");
//			
//			Pelicula pelicula4 = new Pelicula();
//			pelicula4.set_id(4);
//			pelicula4.set_titulo("King Kong");
//			pelicula4.set_duracion(145);
//			pelicula4.set_clasificacion("B");
//			pelicula4.set_genero("Aventura");
//			pelicula4.set_fechaEstreno(formatter.parse("22-05-2017"));
//			pelicula4.set_estatus("Inactiva");
//			pelicula4.set_imagen("kong.jpg");
//			
//			Pelicula pelicula5 = new Pelicula();
//			pelicula5.set_id(5);
//			pelicula5.set_titulo("LIFE: Vida Inteligente");
//			pelicula5.set_duracion(145);
//			pelicula5.set_clasificacion("B15");
//			pelicula5.set_genero("Horror");
//			pelicula5.set_fechaEstreno(formatter.parse("01-06-2017"));
//			pelicula5.set_estatus("Inactiva");
//			pelicula5.set_imagen("estreno5.png");
//			
//			lista.add(pelicula1);
//			lista.add(pelicula2);
//			lista.add(pelicula3);
//			lista.add(pelicula4);
//			lista.add(pelicula5);
//
//			return lista;
//		}
//		catch (java.text.ParseException e)
//		{
//			System.out.println("Error:" + e.getMessage());
//			return null;
//		}
//		
//		
//	}
	
}
