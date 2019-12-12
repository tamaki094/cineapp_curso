package net.itinajero.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.itinajero.app.model.Noticia;

//@Repository //Repositorio se añadira como un nuevo BEAN. Dara de alta el BEAN en el contedor de BEANS. Debera crear un BEAN relacionado con operaciones de bases de datos.
//public interface NoticiasRepository extends CrudRepository<Noticia, Integer> 
//{
//	
//}

@Repository //Repositorio se añadira como un nuevo BEAN. Dara de alta el BEAN en el contedor de BEANS. Debera crear un BEAN relacionado con operaciones de bases de datos.
public interface NoticiasRepository extends JpaRepository<Noticia, Integer> 
{
	//Palabras reservadas: find, By, And
	
	List<Noticia> findBy();
	
	List<Noticia> findByEstatus(String estatus); //declarando un metodo que regresara una Lista de Noticia, filtrada por [Estatus]
	
	List<Noticia> findByFecha(Date date);
	
	List<Noticia> findByEstatusAndFecha(String estatus, Date fecha); 
	
	List<Noticia> findByEstatusOrFecha(String estatus, Date fecha); 
	
	List<Noticia> findByFechaBetween(Date fechaI, Date fechaF); 
	
	
}

