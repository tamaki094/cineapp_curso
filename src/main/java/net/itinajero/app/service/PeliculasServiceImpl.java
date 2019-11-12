package net.itinajero.app.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.itinajero.app.model.Pelicula;

@Service
public class PeliculasServiceImpl implements IPeliculasService
{
	private List<Pelicula> lista = null;
	
	public PeliculasServiceImpl()
	{
		System.out.println("Creando una instancia de la clase PeliculasServiceImpl");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			
		try 
		{
			lista = new LinkedList<>();
			
			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Power Rangers");
			pelicula1.setDuracion(120);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Aventura");
			pelicula1.setFechaEstreno(formatter.parse("02-05-2017"));
			pelicula1.setEstatus("Activa");
			pelicula1.setImagen("rangers.jpg");
			
			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("La bella y la bestia");
			pelicula2.setDuracion(132);
			pelicula2.setClasificacion("A");
			pelicula2.setGenero("Infantil");
			pelicula2.setFechaEstreno(formatter.parse("20-05-2017"));
			pelicula2.setEstatus("Activa");
			pelicula2.setImagen("bella.jpg");
			
			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Contra Tiempo");
			pelicula3.setDuracion(106);
			pelicula3.setClasificacion("B");
			pelicula3.setGenero("Thriller");
			pelicula3.setFechaEstreno(formatter.parse("28-05-2017"));
			pelicula3.setEstatus("Activa");
			pelicula3.setImagen("tiempo.jpg");
			
			Pelicula pelicula4 = new Pelicula();
			pelicula4.setId(4);
			pelicula4.setTitulo("King Kong");
			pelicula4.setDuracion(145);
			pelicula4.setClasificacion("B");
			pelicula4.setGenero("Aventura");
			pelicula4.setFechaEstreno(formatter.parse("22-05-2017"));
			pelicula4.setEstatus("Inactiva");
			pelicula4.setImagen("kong.jpg");
			
			Pelicula pelicula5 = new Pelicula();
			pelicula5.setId(5);
			pelicula5.setTitulo("LIFE: Vida Inteligente");
			pelicula5.setDuracion(145);
			pelicula5.setClasificacion("B15");
			pelicula5.setGenero("Horror");
			pelicula5.setFechaEstreno(formatter.parse("01-06-2017"));
			pelicula5.setEstatus("Inactiva");
			pelicula5.setImagen("estreno5.png");
			
			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			lista.add(pelicula4);
			lista.add(pelicula5);
		}
		catch (java.text.ParseException e)
		{
			System.out.println("Error:" + e.getMessage());		
		}
		
	}
	
	
	
	@Override
	public List<Pelicula> buscarTodas() 
	{
		// TODO Auto-generated method stub
		return lista;
	}



	@Override
	public Pelicula buscarPorId(int idPelicula) {
		for (Pelicula pelicula : lista) 
		{
			if(pelicula.getId() == idPelicula)
			{
				return pelicula;
			}
		}
		return null;
	}



	@Override
	public void insertar(Pelicula pelicula) {
		lista.add(pelicula);	
	}

}
