package net.itinajero.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.itinajero.app.model.Contacto;
import net.itinajero.app.service.IPeliculasService;

@Controller
public class ContactoController {
	
	@Autowired
	IPeliculasService servicePeliculas;

	@GetMapping("/contacto")
	public String mostrarFormulario(@ModelAttribute Contacto contacto, Model model) //al agregar anotacion @ModelAttribute antes de una Clase de modelo, lo que va pasar es qu eaql momento de realizarse una peticion al metodo mostrarFormulario() spring MVC automaticamente va crear una instancia de la clase Contacto utilizando el contructor por default, y va agregar esa instancia al Modelo
	{
		model.addAttribute("generos", servicePeliculas.buscarGeneros());
		model.addAttribute("tipos", tipoNotificaciones());
		return "formContacto";
	}
	
	@PostMapping("/contacto")
	public String guardar(@ModelAttribute Contacto contaco)
	{
		// Este objeto ya se podria almacenar.
		System.out.println(contaco);
		return "redirect:/contacto";
	}
	
	private List<String> tipoNotificaciones()
	{
		List<String> tipos = new LinkedList<>();
		tipos.add("Estrenos");
		tipos.add("Promociones");
		tipos.add("Noticas");
		tipos.add("Preventas");
		
		return tipos;
	}
	
}
