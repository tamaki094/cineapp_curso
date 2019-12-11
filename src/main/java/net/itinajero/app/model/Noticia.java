package net.itinajero.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="noticias") //nombre en la base de datos
public class Noticia 
{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Indicamos que el valor de la llave primaria sera AUTO-INCREMENT. GenerationType.IDENTITY es para MySQL
	private int Id;
	private String titulo;
	private Date fecha;
	private String detalle;
	private  String estatus;
	
	public Noticia()
	{
		this.fecha = new Date();
		this.estatus = "Activa";
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	

	@Override
	public String toString() {
		return "Noticia [Id=" + Id + ", titulo=" + titulo + ", fecha=" + fecha + ", detalle=" + detalle + ", estatus="
				+ estatus + "]";
	}
	
	
}
