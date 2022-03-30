package modelo.daos;

import java.util.List;

import modelo.beans.Evento;

public interface IntEventoDao {

	List<Evento> findActivos();
	List<Evento> findAll();
	Evento findByIdEvento(int idEvento);
	int altaEvento(Evento evento);
	int editarEvento(Evento evento);
	int eliminarEvento(Evento evento);
	int cancelarEvento(Evento evento);
}
