package net.itinajero.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Noticia;

@Controller
@RequestMapping("/noticias")
public class NoticiasController 
{
	@GetMapping(value="/create")
	public String crear()
	{
		return "noticias/formNoticia";
	}

	
	@PostMapping(value="/save")
	public String guardar(Noticia noticia) 
	{
		System.out.println(noticia.toString());
		
		//Pendiente: Guardar Objeto noticia en la BD
		
		System.out.println("Titulo" + noticia.getTitulo());
		System.out.println("Estatus" + noticia.getEstatus());
		System.out.println("Detalle" + noticia.getDetalle());
		
		return "noticias/formNoticia";
	}
	
	
//	@PostMapping(value="/save")
//	public String guardar(@RequestParam("titulo") String titulo, @RequestParam("estatus") String estatus, @RequestParam("detalle")  String detalle) 
//	{
//		Noticia noticia = new Noticia();
//		noticia.setTitulo(titulo);
//		noticia.setEstatus(estatus);
//		noticia.setDetalle(detalle);
//		
//		System.out.println(noticia.toString());
//		
//		//Pendiente: Guardar Objeto noticia en la BD
//		
//		System.out.println("Titulo" + titulo);
//		System.out.println("Estatus" + estatus);
//		System.out.println("Detalle" + detalle);
//		
//		return "noticias/formNoticia";
//	}
}
