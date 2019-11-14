package net.itinajero.app.controller;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IPeliculasService;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController 
{ 
	@Autowired
	private IPeliculasService servicePeliculas;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) 
	{
		List<Pelicula> lista = servicePeliculas.buscarTodas();
		model.addAttribute("peliculas", lista);
		
		return "peliculas/listPeliculas";
	}
	
	@GetMapping("/create")
	public String crear()
	{
		return "peliculas/formPelicula";
	}
	
	@PostMapping("/save")
	public String guardar(Pelicula pelicula, BindingResult result)
	{
		
		if(result.hasErrors())
		{
			for(ObjectError error : result.getAllErrors())
			{
				System.out.println(error.getDefaultMessage());
			}
			
			System.out.println("Existieron errores");
			return "peliculas/formPelicula";
		}
		else
		{
		System.out.println("Recibiendo objeto pelicula: " + pelicula);
		
		System.out.println("Elementos en la lista antes de la insercion:  " +  servicePeliculas.buscarTodas().size());
		
		servicePeliculas.insertar(pelicula);

		System.out.println("Elementos en la lista despues de la insercion:  " +  servicePeliculas.buscarTodas().size());
		
		return "peliculas/formPelicula";
		}
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false)); //para todas las propiedades de tipo Date, cuando se haga el DataBinding vas a crear un nuebo objeto de tipo [CustomDateEditor] que sirve para registrar le foormtato que sera utilizado para dar formato a las fechas que se usan unicamente en estre controlador
	
		
	
	}

}
