package net.itinajero.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Detalle;
import net.itinajero.app.repository.DetallesRepository;

@Service
public class DetallesServiceJPA implements IDetallesService 
{
	@Autowired //Inyeccion de dependencias de Spirng:  Estamos inyectando nuestro Root ApplicationContext una instancia de nuestro repositorio de JPA en una clase de servicio.
	private DetallesRepository detallesRepo; 

	@Override
	public void insertar(Detalle detalle) 
	{
		detallesRepo.save(detalle);	
	}

}
