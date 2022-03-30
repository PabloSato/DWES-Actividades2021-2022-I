package modelo.beans;

import java.io.Serializable;

/**
 * Clase de tipo Tipo que implementa la interfaz Serializable. Tiene propiedades
 * y dos constructores (uno con todos las propiedades y el otro vacío). Tiene
 * los métodos getter y setter de todas las propiedades, así como el HashCode y
 * Equals del idTipo y un método toString
 * 
 * @author pablofernandezsato
 */
public class Tipo implements Serializable {

	// PROPIEDADES
	private static final long serialVersionUID = 1L;

	private int idTipo;
	private String nombre;
	private String descripcion;

	// CONSTRUCTORES
	public Tipo(int id, String nombre, String descripcion) {
		super();
		this.idTipo = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Tipo() {
		super();
	}

	// METODOS
	@Override
	public String toString() {
		return "Tipo [idTipo=" + idTipo + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}

	// GETTER & SETTER
	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int id) {
		this.idTipo = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	// HASHCODE & EQUALS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTipo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Tipo))
			return false;
		Tipo other = (Tipo) obj;
		if (idTipo != other.idTipo)
			return false;
		return true;
	}

}
