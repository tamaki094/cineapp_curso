package net.itinajero.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.itinajero.app.model.Noticia;

@Repository //Repositorio se añadira como un nuevo BEAN. Dara de alta el BEAN en el contedor de BEANS. Debera crear un BEAN relacionado con operaciones de bases de datos.
public interface NoticiasRepository extends CrudRepository<Noticia, Integer> 
{
	
}
