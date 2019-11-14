package net.itinajero.app.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String guardar(Pelicula pelicula, BindingResult result, RedirectAttributes attributes,
							@RequestParam("archivoImagen") MultipartFile multipart, HttpServletRequest request) //param4: se pone el nombre del input file que suibira el archivo (representa este parametro un archivo Binario | param5: devuelve la ruta absoluta dle directorio donde se va guardar el archivo
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
			if(!multipart.isEmpty())
			{
				String nombreImagen = guardarImagen(multipart, request);
				pelicula.setImagen(nombreImagen);
				System.out.println("Nombre imagen: " + nombreImagen);
			}
			System.out.println("Recibiendo objeto pelicula: " + pelicula);
			
			System.out.println("Elementos en la lista antes de la insercion:  " +  servicePeliculas.buscarTodas().size());
			
			servicePeliculas.insertar(pelicula);
	
			System.out.println("Elementos en la lista despues de la insercion:  " +  servicePeliculas.buscarTodas().size());
			
			attributes.addFlashAttribute("mensaje", "El registro fue guardado");
			
			
			return "redirect:/peliculas/index";
		}
	}
	
	
	private String guardarImagen(MultipartFile multipart, HttpServletRequest request) {
		//Obtenemos el nombre original del archivo
		String nombreOriginal = multipart.getOriginalFilename();
		System.out.println("nombreOriginal: " + nombreOriginal);
		
		//Obtenemos la ruta ABSOLUTA del directorio img
		//apache-tomcat/webapps/cineapp/resources/img/
		String rutaFinal = request.getServletContext().getRealPath("/resources/img");
		
		try 
		{
			//Formamos el nombre del archivo para guardarlo en el disco duro
			File imageFile = new File(rutaFinal + nombreOriginal);
			
			//Aqui se guarda fiusicamente el archivo en el disco duro
			multipart.transferTo(imageFile);
			
			return nombreOriginal;
		} 
		catch (IOException e) 
		{
			System.out.println("Error " + e.getMessage());
			return null;
		}	
	}

	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false)); //para todas las propiedades de tipo Date, cuando se haga el DataBinding vas a crear un nuebo objeto de tipo [CustomDateEditor] que sirve para registrar le foormtato que sera utilizado para dar formato a las fechas que se usan unicamente en estre controlador
	}

}