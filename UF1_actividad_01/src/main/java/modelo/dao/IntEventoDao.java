package modelo.dao;

import java.util.List;

import modelo.beans.Evento;

/**
 * Interfaz de métodos para gestionar objetos de tipo Evento
 * 
 * @author pablofernandezsato
 *
 */
public interface IntEventoDao {

	// Interfaz de Eventos con métodos para ser implementados

	/**
	 * Método de devuelve una lista con todos los objetos de tipo Evento que esté
	 * activos. Para ello crea una nuva lista llamada listaActivos y una variabe de
	 * tipo int donde llevar la cuenta. Mediante un bucle for va comprobando si la
	 * propiedad Estado de cada objeto Evento es igual a "activo", en caso
	 * afirmativo añade dicho objeto a la lista listaActivo y suma uno a la variabe
	 * numérica. Finalmente comprueba si la variable numérica es menor que cero
	 * (querrá decir que no hay ningun objeto activo), en ese caso devuelve null, en
	 * caso contrario (la varible numérica es mayor que cero, hay objetos activos),
	 * devuelve la listaActivos
	 * 
	 * @return una lista con todos los objetos activos que hay. En caso de que no
	 *         haya ninguno, devueve null
	 */
	List<Evento> findActivos();// Devuelve una lista de todos los eventos activos

	/**
	 * método que devueve una lista con todos los objetos cargados en la lista
	 * 
	 * @return un objeto de tipo lista con todos los objetos de tipo Evento
	 */
	List<Evento> findAll(); // Devuelve una lista de todos los eventos

	/**
	 * Devuelve un objeto de tipo Evento. Recibe un parámetro de tipo integer que
	 * representanuna posible id de un Evento. Lo primero que hace es crear un nuevo
	 * objeto de tipo Evento auxiliar al que, mediante el método setIdEvento(), se
	 * le pone como id el parámetro de entrada. Mediante el método indexOf de la
	 * lista se comprueba si hay algun objeto con ese id en la lista de Eventos. En
	 * caso de que no haya ninguno daría -1, en ese caso devuelve null. En caso de
	 * que si que haya un objeto Evento con ese id, devuelve ese objeto
	 * 
	 * @param recibe como parámetro de entrada un integer que representa la id del
	 *               Evento que buscamos
	 * 
	 * @return devuelve el Evento cuya id coincide con el parámetro de entrada. En
	 *         caso de que no coincida ninguno, devuelve null
	 */
	Evento findByIdEvento(int idEvento); // Devuelve un objeto de tipo Evento, tiene como parámetros un Integer que
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
	 * @param recibe como parámetro de entrada un el objeto de tipo Evento que
	 *               queremos añadir
	 * 
	 * @return devuelve 1 si se ha podido insertar el objeto en la lista y 0 si no
	 *         se ha podido insertar
	 * 
	 */
	int altaEvento(Evento evento); // Inserta un nuevo objeto Evento, tiene como parámetro el objeto que quiere ser
									// insertado

	/**
	 * Devuelve un Integer, 1 en caso positivo o 0 en caso negativo. Es un método
	 * que sirve para editar un objeto Evento de la lista de evento. Recibimos como
	 * parámetro de entrada el objeto que queremos editar. Mediante el método
	 * indexOf de la lista se comprueba si el objeto se encuentra en la lista
	 * (devolvería -1 en caso contrario). Si está en la lista actualiza el estado
	 * del objeto mediante el método set() de la lista, devolviendo 1 si se ha
	 * podido realizar exitosamente esa actualización y 0 si no ha podido realizarse
	 * 
	 * @param recibe como parámetro de entrada un el objeto de tipo Evento que
	 *               queremos editar
	 * @return devuelve 1 si se ha podido editar el objeto y 0 si no se ha podido
	 *         editar
	 */
	int editarEvento(Evento evento);// Edita un objeto Evento, tiene como parámetro el objeto que quiere ser editado

	/**
	 * Devuelve un Integer, 1 en caso positivo o 0 en caso negativo. Es un método
	 * que sirve para eliminar un objeto Evento de la lista de evento. Recibimos
	 * como parámetro de entrada el objeto que queremos eliminar. Mediante el método
	 * remove() de la lista eliminamos el objeto, devolviendo 1 si se pudo eliminar
	 * correctamente y 0 si no pudo ser eliminado
	 * 
	 * @param recibe como parámetro de entrada un el objeto de tipo Evento que
	 *               queremos eliminar
	 * @return devuelve 1 si se ha podido eliminar el objeto y 0 si no se ha podido
	 *         eliminar
	 */
	int eliminarEvento(Evento evento);// Elimina un objeto Evento, tiene como parámetro el objeto que quiere ser
										// eliminado

	/**
	 * Devuelve un Integer, 1 en caso positivo o 0 en caso negativo. Es un método
	 * que sirve para cancelar un objeto Evento de la lista de evento. Recibimos
	 * como parámetro de entrada el objeto que queremos cancelar. Mediante el método
	 * indexOf de la lista se comprueba si el objeto se encuentra en la lista
	 * (devolvería -1 en caso contrario). Si está en la lista actuaiza el estado del
	 * objeto mediante el método setEstado() a "cancelado", devolviendo 1 si se ha
	 * podido realizar exitosamente esa actualización y 0 si no ha podido realizarse
	 * 
	 * @param recibe como parámetro de entrada un el objeto de tipo Evento que
	 *               queremos canelar
	 * @return devuelve 1 si se ha podido editar el objeto y 0 si no se ha podido
	 *         cancelar
	 */
	int cancelarEvento(Evento evento);// Cancela un objeto Evento, tiene como parámetro el objeto que quiere ser
										// cancelado
}
