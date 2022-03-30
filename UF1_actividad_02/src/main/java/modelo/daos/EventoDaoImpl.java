package modelo.daos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import modelo.beans.Evento;
import modelo.beans.Tipo;

public class EventoDaoImpl implements IntEventoDao {

	List<Evento> lista;

	public EventoDaoImpl() {
		super();
		this.lista = new ArrayList<Evento>();
		cargarDatos();
	}

	// METODOS
	private void cargarDatos() {

		Calendar cl = Calendar.getInstance();
		cl.set(Calendar.MONTH, 0);
		cl.set(Calendar.DAY_OF_MONTH, 15);
		cl.set(Calendar.YEAR, 2020);
		Date date1 = cl.getTime();

		lista.add(new Evento(1, "Boda", "pija", date1, 3, "C/Albaricoque", "activo", 's', 200, 100, 2500,
				new Tipo(1, "Boda", "hippie")));
		lista.add(new Evento(2, "Boda", "jipi", date1, 1, "C/Mazorca", "activo", 's', 50, 10, 500,
				new Tipo(2, "Boda", "pija")));
		lista.add(new Evento(3, "Boda", "tradicional", date1, 2, "C/Pomelo", "activo", 's', 150, 60, 1000,
				new Tipo(3, "Boda", "terrible")));
		lista.add(new Evento(4, "Boda", "tradicional", new Date(), 2, "C/Pomelo", "cancelado", 's', 150, 60, 1000,
				new Tipo(3, "Boda", "terrible")));
	}
	@Override
	public List<Evento> findAll() {
		return lista;
	}

	@Override
	public List<Evento> findActivos() {
		List<Evento> listActivos = new ArrayList<Evento>();
		int cantidad = 0;

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getEstado().equals("activo")) {
				listActivos.add(lista.get(i));
				cantidad++;
			}
		}
		if (cantidad < 0) {
			return null;
		} else {
			return listActivos;
		}
	}

	@Override
	public Evento findByIdEvento(int idEvento) {

		Evento aux = new Evento();
		aux.setIdEvento(idEvento);
		int pos = lista.indexOf(aux);
		if (pos == -1) {
			return null;
		} else {
			return lista.get(pos);
		}
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
		return lista.remove(evento) ? 1 : 0;
	}

	@Override
	public int cancelarEvento(Evento evento) {
		int pos = lista.indexOf(evento);
		if (pos == -1) {
			return 0;
		} else {
			evento.setEstado("cancelado");
			return (lista.set(pos, evento) != null) ? 1 : 0;
		}
	}

}
