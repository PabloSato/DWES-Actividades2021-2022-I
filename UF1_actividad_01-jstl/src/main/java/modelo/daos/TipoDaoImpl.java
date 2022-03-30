package modelo.daos;

import java.util.ArrayList;
import java.util.List;

import modelo.beans.Tipo;

/**
 * Clase que implemente los métodos de la Interfaz @see IntTipoDao y que carga
 * de Datos la Lista de objetos de tipo Tipo Como propieadad únicamente tiene un
 * objeto de tipo List<Tipo>. Tiene un constructor sin parámetros que inicializa
 * como ArrayList<Tipo> la lista y llama al método @see cargarDatos() que
 * realiza la carga de datos en la lista
 * 
 * @author pablofernandezsato
 *
 */

public class TipoDaoImpl implements IntTipoDao {

	// Clase que implementa la Interfaz de IntTipoDao y que tiene como Propiedad un
	// objeto List de Tipo

	List<Tipo> lista;

	// Su constructor crea un nuevo objeto ArrayList de Tipo y llama al método
	// cargarDatos();
	public TipoDaoImpl() {
		this.lista = new ArrayList<Tipo>();
		cargarDatos();
	}

	/**
	 * Metodo que no devuelve nada. Carga objetos en el arraylist de Tipo
	 */
	private void cargarDatos() {
		lista.add(new Tipo(1, "Boda", "hippie"));
		lista.add(new Tipo(2, "Bautizo", "pija"));
		lista.add(new Tipo(3, "Comunión", "terrible"));
		lista.add(new Tipo(4, "Divorcio", "increible"));

	}

	@Override
	public List<Tipo> findAll() {

		return lista;
	}

	@Override
	public Tipo findByIdTipo(int idTipo) {

		Tipo aux = new Tipo();
		aux.setIdTipo(idTipo);
		int pos = lista.indexOf(aux);
		if (pos == -1)
			return null;
		else
			return lista.get(pos);
	}

	@Override
	public int altaTipo(Tipo tipo) {
		if (lista.contains(tipo))
			return 0;
		else
			return lista.add(tipo) ? 1 : 0;
	}

	@Override
	public int editTipo(Tipo tipo) {
		int pos = lista.indexOf(tipo);
		if (pos == -1)
			return 0;
		else
			return (lista.set(pos, tipo) != null) ? 1 : 0;
	}

	@Override
	public int elimiTipo(Tipo tipo) {

		return lista.remove(tipo) ? 1 : 0;
	}

}
