package modelo.daos;

import java.util.List;

import modelo.beans.Tipo;

/**
 * Interfaz de métodos para gestionar objetos de tipo Tipo
 * 
 * @author pablofernandezsato
 *
 */
public interface IntTipoDao {

	/**
	 * método que devueve una lista con todos los objetos cargados en la lista
	 * 
	 * @return un objeto de tipo lista con todos los objetos de tipo Tipo
	 */
	List<Tipo> findAll();// Devuelve una lista de todos los tipos

	/**
	 * Devuelve un objeto de tipo Tipo. Recibe un parámetro de tipo integer que
	 * representanuna posible id de un Tipo. Lo primero que hace es crear un nuevo
	 * objeto de tipo Tipo auxiliar al que, mediante el método setIdTipo(), se le
	 * pone como id el parámetro de entrada. Mediante el método indexOf de la lista
	 * se comprueba si hay algun objeto con ese id en la lista de Tipo. En caso de
	 * que no haya ninguno daría -1, en ese caso devuelve null. En caso de que si
	 * que haya un objeto Tipo con ese id, devuelve ese objeto
	 * 
	 * @param recibe como parámetro de entrada un integer que representa la id del
	 *               Tipo que buscamos
	 * 
	 * @return devuelve el Tipo cuya id coincide con el parámetro de entrada. En
	 *         caso de que no coincida ninguno, devuelve null
	 */
	Tipo findByIdTipo(int idTipo);// Devuelve un objeto de tipo Evento, tiene como parámetros un Integer que
									// repreenta el id

	/**
	 * Devuelve un Integer, 1 en caso positivo o 0 en caso negativo. Es un método
	 * que sirve para insertar en la lista de objetos un nuevo objeto que recibimos
	 * como parámetro de entrada Primero comprobamos con el método contains() si el
	 * objeto ya existe en la lista, en cuyo caso no lo insertaríamos y
	 * devolveríamos 0. En caso de que no exista pasaríamos a insertarlos
	 * devolviendo 1 si se ha insertado con éxito y 0 si no se ha podido insertar
	 * por algún motivo.
	 * 
	 * @param recibe como parámetro de entrada un el objeto de tipo Tipo que
	 *               queremos añadir
	 * 
	 * @return devuelve 1 si se ha podido insertar el objeto en la lista y 0 si no
	 *         se ha podido insertar
	 * 
	 */
	int altaTipo(Tipo tipo);// Inserta un nuevo objeto Tipo, tiene como parámetro el objeto que quiere ser
							// insertado

	/**
	 * Devuelve un Integer, 1 en caso positivo o 0 en caso negativo. Es un método
	 * que sirve para editar un objeto Tipo de la lista de Tipo. Recibimos como
	 * parámetro de entrada el objeto que queremos editar. Mediante el método
	 * indexOf de la lista se comprueba si el objeto se encuentra en la lista
	 * (devolvería -1 en caso contrario). Si está en la lista actualiza el estado
	 * del objeto mediante el método set() de la lista, devolviendo 1 si se ha
	 * podido realizar exitosamente esa actualización y 0 si no ha podido realizarse
	 * 
	 * @param recibe como parámetro de entrada un el objeto de tipo Tipo que
	 *               queremos editar
	 * @return devuelve 1 si se ha podido editar el objeto y 0 si no se ha podido
	 *         editar
	 */
	int editTipo(Tipo tipo);// Editar un objeto Tipo, tiene como parámetro el objeto que quiere ser editado

	/**
	 * Devuelve un Integer, 1 en caso positivo o 0 en caso negativo. Es un método
	 * que sirve para eliminar un objeto Tipo de la lista de Tipo. Recibimos como
	 * parámetro de entrada el objeto que queremos eliminar. Mediante el método
	 * remove() de la lista eliminamos el objeto, devolviendo 1 si se pudo eliminar
	 * correctamente y 0 si no pudo ser eliminado
	 * 
	 * @param recibe como parámetro de entrada un el objeto de tipo Tipo que
	 *               queremos eliminar
	 * @return devuelve 1 si se ha podido eliminar el objeto y 0 si no se ha podido
	 *         eliminar
	 */
	int elimiTipo(Tipo tipo);// Elimina un objeto Tipo, tiene como parámetro el objeto que quiere ser
								// eliminado

}
