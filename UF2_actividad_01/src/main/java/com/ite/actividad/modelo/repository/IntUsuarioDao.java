package com.ite.actividad.modelo.repository;

import java.util.List;

import com.ite.actividad.modelo.beans.Usuario;


/**
 * Interfaz de métodos para gestionar objetos de tipo Usuario
 * 
 * @author pablofernandezsato
 *
 */
public interface IntUsuarioDao {

	//Interfaz de Usuario con métodos para ser implementados
	
	/**
	 * Método que devuelve una lista con todos los objetos de tipo Usuario que estén
	 * cargados en la lista 

	 * @return una lista con todos los objetos de tipo Usuario
	 */
	List<Usuario> findAll();
	/**
	 * Devuelve un objeto de tipo Usuario. Recibe como parámetro un integer que 
	 * representa una posible id de un Usuario. Lo primero que hace es crear un 
	 * un nuevo objeto de tipo Usuario auxiliar al que mediante el método setIdUsuario()
	 * se le pone como id el valor del parámetro de entrada. Mediante el método indexOf
	 * de la lista se comprueba si hay algun objeto con ese mismo id en la lista de Usuario.
	 * En caso de que no haya ninguno devolvería -1, en ese caso este método devuelve null.
	 * En caso de que si que haya un objeto Usuario con esa id, devuelve ese objeto
	 * 
	 * @param idUsuario
	 * @return El objeto de tipo Usuario que tiene ese id o en su defecto null
	 */
	Usuario findById(int idUsuario);
	/**
	 * Devuelve un objeto de tipo Usuario. Recibe como parámetro dos String, uno
	 * con el nickname del usuario y otro con el password del usuario. Comprueba si alguno
	 * de los Usuarios guardados en la lista coincide su nickname y su password con los
	 * pasados. En caso de que no haya ninguno devolvería -1, en ese caso este método devuelve null.
	 * En caso de que si que haya un objeto Usuario con esa id, devuelve ese objeto
	 * 
	 * @param idUsuario
	 * @return El objeto de tipo Usuario que tiene ese id o en su defecto null
	 */
	Usuario findByNomAndPass(String nomUser, String passUser);
	/**
	 * Devuelve un Integer, 1 en caso positivo o 0 en caso negativo. Es un método
	 * que sirve para editar un objeto Usuario de la lista de usuario. Recibimos como
	 * parámetro de entrada el objeto que queremos editar. Mediante el método
	 * indexOf de la lista se comprueba si el objeto se encuentra en la lista
	 * (devolvería -1 en caso contrario). Si está en la lista actualiza el estado
	 * del objeto mediante el método set() de la lista, devolviendo 1 si se ha
	 * podido realizar exitosamente esa actualización y 0 si no ha podido realizarse
	 * 
	 * @param recibe como parámetro de entrada un el objeto de tipo Usuario que
	 *               queremos editar
	 * @return devuelve 1 si se ha podido editar el objeto y 0 si no se ha podido
	 *         editar
	 */
	int altaUsuario(Usuario usuario);
	/**
	 * Devuelve un Integer, 1 en caso positivo o 0 en caso negativo. Es un método
	 * que sirve para editar un objeto Usuario de la lista de usuario. Recibimos como
	 * parámetro de entrada el objeto que queremos editar. Mediante el método
	 * indexOf de la lista se comprueba si el objeto se encuentra en la lista
	 * (devolvería -1 en caso contrario). Si está en la lista actualiza el estado
	 * del objeto mediante el método set() de la lista, devolviendo 1 si se ha
	 * podido realizar exitosamente esa actualización y 0 si no ha podido realizarse
	 * 
	 * @param recibe como parámetro de entrada un el objeto de tipo Usuario que
	 *               queremos editar
	 * @return devuelve 1 si se ha podido editar el objeto y 0 si no se ha podido
	 *         editar
	 */
	int editarUsuario(Usuario usuario);
	/**
	 * Devuelve un Integer, 1 en caso positivo o 0 en caso negativo. Es un método
	 * que sirve para eliminar un objeto Usuario de la lista de usuario. Recibimos
	 * como parámetro de entrada el objeto que queremos eliminar. Mediante el método
	 * remove() de la lista eliminamos el objeto, devolviendo 1 si se pudo eliminar
	 * correctamente y 0 si no pudo ser eliminado
	 * 
	 * @param recibe como parámetro de entrada un el objeto de tipo Usuario que
	 *               queremos eliminar
	 * @return devuelve 1 si se ha podido eliminar el objeto y 0 si no se ha podido
	 *         eliminar
	 */
	int bajaUsuario(Usuario usuario);
	/**
	 * Devuelve un Integer, 1 en caso positivo o 0 en caso negativo. Es un método
	 * que sirve para eliminar un objeto Usuario de la lista de Usuario. Recibimos
	 * como parámetro el id de la Usuario que queremos eliminar.Con el método findById()
	 * buscamos el objeto a eliminar y mediante el métodoremove() de la lista
	 *  eliminamos el objeto, devolviendo 1 si se pudo eliminar
	 * correctamente y 0 si no pudo ser eliminado
	 * 
	 * @param recibe como parámetro de entrada un el objeto Usuario que
	 *               queremos eliminar
	 * @return devuelve 1 si se ha podido eliminar el objeto y 0 si no se ha podido
	 *         eliminar
	 */
	int bajaUsuario(int idUsuario);
	/**
	 * Es un método que sirve para autogenerar una nueva id al objeto Usuario que la
	 * llama. Comprueba los valores de id usados por los otros objetos Usuario y devuelve
	 * el siguiente valor libre. Intenta imitar el autoincrement de las BBDD
	 * 
	 * @return nextId, un Integer con el primer valor libre
	 */
	int nextIdUsuario();

}
