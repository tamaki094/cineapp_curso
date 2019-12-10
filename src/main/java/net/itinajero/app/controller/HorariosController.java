package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.itinajero.app.model.Contacto;
import net.itinajero.app.model.Horario;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IPeliculasService;

@Controller
@RequestMapping(value="/horarios")
public class HorariosController {
	
	@Autowired
	IPeliculasService servicePeliculas;
		
	/**
	 * Metodo para mostrar el formulario para crear un nuevo horario
	 * @return
	 */
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute Horario horario, Model model) //Necesito clase de modelo para Horario para el dataBinding, Necesito clase Model para poder renderizar los datos que le pase por la variable "model"
	{
		// Ejercicio: Recuperar lista de peliculas para poblar <select>
		List<Pelicula> lst_peliculas = new LinkedList<Pelicula>();
		lst_peliculas = servicePeliculas.buscarTodas();		
				
		// Ejercicio: agregar al modelo listado de peliculas
		model.addAttribute("peliculas", lst_peliculas);
		
		// Ejercicio: crear archivo formHorario.jsp y configurar el diseño utilizando el codigo HTML
		// del archivo formHorario.html de la plantilla (utilizar Form Tag Library)
		
		return "horarios/formHorario";	 
	}
		
	/**
	 * Metodo para guardar el registro del Horario
	 * @param horario
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Horario horario, BindingResult result, Model model) 
	{						
		// Ejercicio: Verificar si hay errores en el Data Binding
		if (result.hasErrors()){
			List<Pelicula> listaPeliculas = servicePeliculas.buscarTodas();
			model.addAttribute("peliculas", listaPeliculas);
			return "horarios/formHorario";
		}
		// Ejercicio: En caso de no haber errores, imprimir en consola el objeto de model Horario 
		// que ya debera de tener los datos del formulario
		System.out.println("Guardando el objeto Horario: " + horario);
		
		// De momento, hacemos un redirect al mismo formulario 
		return "redirect:/horarios/create";
	}
	
	/**
	 * Ejercicio: Crear metodo para personalizar el Data Binding para las todas las propiedades de tipo Date	
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false)); //para todas las propiedades de tipo Date, cuando se haga el DataBinding vas a crear un nuebo objeto de tipo [CustomDateEditor] que sirve para registrar le foormtato que sera utilizado para dar formato a las fechas que se usan unicamente en estre controlador
	}
	
}
