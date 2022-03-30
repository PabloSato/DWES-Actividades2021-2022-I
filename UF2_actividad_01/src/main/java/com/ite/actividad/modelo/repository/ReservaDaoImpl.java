package com.ite.actividad.modelo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.actividad.modelo.beans.Evento;
import com.ite.actividad.modelo.beans.Reserva;
import com.ite.actividad.modelo.beans.Usuario;

@Repository
/**
 * Clase que implemente los métodos de la Interfaz @see IntReservaDao y que
 * carga de Datos la Lista de objetos de tipo Reserva Como propieadad únicamente
 * tiene un objeto de tipo List<Reserva>. Tiene un constructor sin parámetros
 * que inicializa como ArrayList<Reserva> la lista y llama al método @see
 * cargarDatos() que realiza la carga de datos en la lista
 * 
 * @author pablofernandezsato
 *
 */
public class ReservaDaoImpl implements IntReservasDao {
	// Clase que implementa la Interfaz de IntEventosDao y que tiene como Propiedad
	// un objeto List de Reserva
	List<Reserva> lista;

	public ReservaDaoImpl() {
		super();
		this.lista = new ArrayList<Reserva>();
	}

	@Override
	public List<Reserva> findAll() {

		return lista;
	}

	@Override
	public Reserva findById(int idReserva) {
		Reserva aux = new Reserva();
		aux.setIdReserva(idReserva);
		int pos = lista.indexOf(aux);
		if (pos == -1)
			return null;
		else
			return lista.get(pos);
	}

	@Override
	public int altaReserva(Reserva reserva) {
		
		if(lista.contains(reserva))
			return 0;
		else
			return lista.add(reserva) ? 1: 0;
	}

	@Override
	public int editarReserva(Reserva reserva) {
		int pos = lista.indexOf(reserva);
		if (pos == -1)
			return 0;
		else
			return (lista.set(pos, reserva) != null) ? 1 : 0;
	}

	@Override
	public int cancelarReserva(Reserva reserva) {
		int pos = lista.indexOf(reserva);
		if (pos == -1)
			return 0;
		else
			return lista.remove(reserva) ? 1 : 0;
	}

	@Override
	public int cancelarReserva(int idReserva) {
		Reserva aux = findById(idReserva);
		if (aux == null)
			return 0;
		else
			return lista.remove(aux) ? 1 : 0;
	}

	@Override
	public int nextIdReserva() {

		int nextId = 1;
		for (Reserva ele : findAll()) {
			nextId = ele.getIdReserva();
			nextId++;
		}
		return nextId;
	}

	@Override
	public int comprobarReservas(Usuario user, Evento evento) {
		
		int cantidad = 0;
		
		for(Reserva ele: findAll()) {
			if(ele.getUsuario() == user && ele.getEvento() == evento) {
				cantidad += ele.getCantidad();
			}
		}
		
		return cantidad;
	}

}
