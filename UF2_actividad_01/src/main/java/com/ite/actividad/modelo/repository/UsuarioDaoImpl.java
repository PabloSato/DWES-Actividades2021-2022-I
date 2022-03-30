package com.ite.actividad.modelo.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.actividad.modelo.beans.Usuario;

@Repository
/**
 * Clase que implemente los métodos de la Interfaz @see IntUsuarioDao y que
 * carga de Datos la Lista de objetos de tipo Usuario Como propieadad únicamente
 * tiene un objeto de tipo List<Usuario>. Tiene un constructor sin parámetros
 * que inicializa como ArrayList<Usuario> la lista y llama al método @see
 * cargarDatos() que realiza la carga de datos en la lista
 * 
 * @author pablofernandezsato
 *
 */
public class UsuarioDaoImpl implements IntUsuarioDao {

	// Clase que implementa la Interfaz de IntUsuariosDao y que tiene como Propiedad
	// un objeto List de Usuario

	List<Usuario> lista;

	// Su constructor crea un nuevo objeto ArrayList de Usuario y llama al método
	// cargarDatos();
	public UsuarioDaoImpl() {
		super();
		this.lista = new ArrayList<Usuario>();
		cargarDatos();
	}

	// METODOS
	/**
	 * Metodo que no devuelve nada. Carga objetos en el arraylist de Usuarios
	 */
	private void cargarDatos() {
		Calendar cl = Calendar.getInstance();
		cl.set(Calendar.MONTH, 10);
		cl.set(Calendar.DAY_OF_MONTH, 15);
		cl.set(Calendar.YEAR, 2021);
		Date date1 = cl.getTime();

		lista.add(new Usuario(1, "pa", "asd", "pablo@info.com", "Pablo", "Calle", 1, date1));
		lista.add(new Usuario(2, "pe", "1234", "pablo@info.com", "Pepe", "Calle", 1, date1));
	}

	@Override
	public List<Usuario> findAll() {

		return lista;
	}

	@Override
	public Usuario findById(int idUsuario) {
		Usuario aux = new Usuario();
		aux.setIdUsuario(idUsuario);
		int pos = lista.indexOf(aux);
		if (pos == -1)
			return null;
		else
			return lista.get(pos);
	}

	@Override
	public Usuario findByNomAndPass(String nomUser, String passUser) {
		Usuario aux = new Usuario();
		int cantidad = 0;
		for (Usuario ele : findAll()) {
			if ((ele.getUserName().equals(nomUser)) && (ele.getPassword().equals(passUser))) {
				aux = ele;
				cantidad++;
			}
		}
		if (cantidad < 1)
			return null;
		else
			return aux;
	}

	@Override
	public int altaUsuario(Usuario usuario) {
		if (lista.contains(usuario))
			return 0;
		else
			return lista.add(usuario) ? 1 : 0;
	}

	@Override
	public int editarUsuario(Usuario usuario) {
		int pos = lista.indexOf(usuario);
		if (pos == -1)
			return 0;
		else
			return (lista.set(pos, usuario) != null) ? 1 : 0;
	}

	@Override
	public int bajaUsuario(Usuario usuario) {
		int pos = lista.indexOf(usuario);
		if (pos == -1)
			return 0;
		else
			return lista.remove(usuario) ? 1 : 0;
	}

	@Override
	public int bajaUsuario(int idUsuario) {
		Usuario aux = findById(idUsuario);
		return lista.remove(aux) ? 1 : 0;
	}

	@Override
	public int nextIdUsuario() {
		
		int nextId = 1;
		for(Usuario ele: findAll()) {
			nextId = ele.getIdUsuario();
			nextId++;
		}
		return nextId;
	}

}
