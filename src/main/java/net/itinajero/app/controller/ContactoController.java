package net.itinajero.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.itinajero.app.model.Contacto;

@Controller
public class ContactoController {

	@GetMapping("/contacto")
	public String mostrarFormulario(@ModelAttribute Contacto contacto) //al agregar anotacion @ModelAttribute antes de una Clase de modelo, lo que va pasar es qu eaql momento de realizarse una peticion al metodo mostrarFormulario() spring MVC automaticamente va crear una instancia de la clase Contacto utilizando el contructor por default, y va agregar esa instancia al Modelo
	{
		return "formContacto";
	}
}
