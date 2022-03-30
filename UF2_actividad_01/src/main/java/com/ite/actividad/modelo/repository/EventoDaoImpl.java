package com.ite.actividad.modelo.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.actividad.modelo.beans.Evento;

@Repository
/**
 * Clase que implemente los métodos de la Interfaz @see IntEventoDao y que carga
 * de Datos la Lista de objetos de tipo Evento Como propieadad únicamente tiene
 * un objeto de tipo List<Evento>. Tiene un constructor sin parámetros que
 * inicializa como ArrayList<Evento> la lista y llama al método @see
 * cargarDatos() que realiza la carga de datos en la lista
 * 
 * @author pablofernandezsato
 *
 */
public class EventoDaoImpl implements IntEventoDao {


	// Clase que implementa la Interfaz de IntEventosDao y que tiene como Propiedad un
	// objeto List de Evento

	List<Evento> lista;

	// Su constructor crea un nuevo objeto ArrayList de Evento y llama al método
	// cargarDatos();
	public EventoDaoImpl() {
		super();
		this.lista = new ArrayList<Evento>();
		cargarDatos();
	}

	// METODOS
	/**
	 * Metodo que no devuelve nada. Carga objetos en el arraylist de Eventos
	 */

	private void cargarDatos() {

		Calendar cl = Calendar.getInstance();
		cl.set(Calendar.MONTH, 0);
		cl.set(Calendar.DAY_OF_MONTH, 15);
		cl.set(Calendar.YEAR, 2020);
		Date date1 = cl.getTime();

		TipoDaoImpl itipo = new TipoDaoImpl();

		lista.add(new Evento(1, "Jose", "pija", date1, 3, "C/Albaricoque", "activo", 's', 200, 100, 2500,
				itipo.findByIdTipo(1)));
		lista.add(new Evento(2, "Pepe", "jipi", date1, 1, "C/Mazorca", "activo", 's', 50, 10, 500,
				itipo.findByIdTipo(2)));
		lista.add(new Evento(3, "Manuel", "tradicional", date1, 2, "C/Pomelo", "activo", 'n', 150, 60, 1000,
				itipo.findByIdTipo(3)));
		lista.add(new Evento(4, "Cris", "tradicional", new Date(), 2, "C/Pomelo", "cancelado", 's', 150, 60, 1000,
				itipo.findByIdTipo(4)));
	

	}

	@Override
	public List<Evento> findActivos() {
		List<Evento> listaActivos = new ArrayList<Evento>();
		int cantidad = 0;

		for (Evento ele : findAll()) {
			if (ele.getEstado().equals("activo")) {
				listaActivos.add(ele);
				cantidad++;
			}
		}
		if (cantidad < 1)
			return null;
		else
			return listaActivos;
	}

	@Override
	public List<Evento> findAll() {

		return lista;
	}

	@Override
	public Evento findByIdEvento(int idEvento) {
		Evento aux = new Evento();
		aux.setIdEvento(idEvento);
		int pos = lista.indexOf(aux);
		if (pos == -1)
			return null;
		else
			return lista.get(pos);
	}

	@Override
	public int altaEvento(Evento evento) {
		if (lista.contains(evento))
			return 0;
		else
			return lista.add(evento) ? 1 : 0;
	}

	@Override
	public int editarEvento(Evento evento) {
		int pos = lista.indexOf(evento);
		if (pos == -1)
			return 0;
		else
			return (lista.set(pos, evento) != null) ? 1 : 0;
	}

	@Override
	public int eliminarEvento(Evento evento) {
		int pos = lista.indexOf(evento);
		if (pos == -1)
			return 0;
		else
			return lista.remove(evento) ? 1 : 0;
	}

	@Override
	public int cancelarEvento(Evento evento) {
		int pos = lista.indexOf(evento);
		if (pos == -1)
			return 0;
		else
			evento.setEstado("cancelado");
		return (lista.set(pos, evento) != null) ? 1 : 0;
	}

	@Override
	public List<Evento> findDestacados() {
		List<Evento> listaDestacado = new ArrayList<Evento>();
		int cantidad = 0;
		for (Evento ele : findAll()) {
			if (ele.getDestacado() == 's') {
				listaDestacado.add(ele);
				cantidad++;
			}
		}
		if(cantidad < 1) 
			return null;
		else
			return listaDestacado;
	}

	@Override
	public int nextIdEvento() {
		int nextId = 1;
		for(Evento ele : findAll()) {
			nextId = ele.getIdEvento();
			nextId++;
		}
		return nextId;
	}

}
