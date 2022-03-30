package com.ite.actividad.modelo.repository;

import java.util.List;

import com.ite.actividad.modelo.beans.Evento;
import com.ite.actividad.modelo.beans.Reserva;
import com.ite.actividad.modelo.beans.Usuario;



/**
 * Interfaz de métodos para gestionar objetos de tipo Reserva
 * 
 * @author pablofernandezsato
 *
 */
public interface IntReservasDao {
	
	//Interfaz de Rerserva con métodos para ser implementados
	
	/**
	 * Método que devuelve una lista con todos los objetos de tipo Reserva que estén
	 * cargados en la lista 

	 * @return una lista con todos los objetos de tipo Reserva
	 */
	List<Reserva> findAll();
	/**
	 * Devuelve un objeto de tipo Reserva. Recibe como parámetro un integer que 
	 * representa una posible id de una Reserva. Lo primero que hace es crear un 
	 * un nuevo objeto de tipo Reserva auxiliar al que mediante el método setIdReserva()
	 * se le pone como id el valor del parámetro de entrada. Mediante el método indexOf
	 * de la lista se comprueba si hay algun objeto con ese mismo id en la lista de Reserva.
	 * En caso de que no haya ninguno devolvería -1, en ese caso este método devuelve null.
	 * En caso de que si que haya un objeto Reserva con esa id, devuelve ese objeto
	 * 
	 * @param idReserva
	 * @return El objeto de tipo Reserva que tiene ese id o en su defecto null
	 */
	Reserva findById(int idReserva);
	/**
	 * Devuelve un integar, 1, en caso positivo o 0 en caso negativo.  Es un método
	 * que sirve para insertar en la lista de objetos un nuevo objeto que recibimos
	 * como parámetro de entrada Primero comprobamos con el método contains() si el
	 * objeto ya existe en la lista, en cuyo caso no lo insertaríamos y
	 * devolveríamos 0. En caso de que no exista pasaríamos a insertarlo
	 * devolviendo 1 si se ha insertado con éxito y 0 si no se ha podido insertar
	 * por algún motivo.
	 * 
	 * @param recibe como parámetro de entrada un el objeto de tipo Reserva que
	 *               queremos añadir
	 * 
	 * @return devuelve 1 si se ha podido insertar el objeto en la lista y 0 si no
	 *         se ha podido insertar
	 * 
	 * @param reserva
	 * @return
	 */
	int altaReserva(Reserva reserva);
	/**
	 * Devuelve un Integer, 1 en caso positivo o 0 en caso negativo. Es un método
	 * que sirve para editar un objeto Reserva de la lista de reserva. Recibimos como
	 * parámetro de entrada el objeto que queremos editar. Mediante el método
	 * indexOf de la lista se comprueba si el objeto se encuentra en la lista
	 * (devolvería -1 en caso contrario). Si está en la lista actualiza el estado
	 * del objeto mediante el método set() de la lista, devolviendo 1 si se ha
	 * podido realizar exitosamente esa actualización y 0 si no ha podido realizarse
	 * 
	 * @param recibe como parámetro de entrada un el objeto de tipo Reserva que
	 *               queremos editar
	 * @return devuelve 1 si se ha podido editar el objeto y 0 si no se ha podido
	 *         editar
	 */
	int editarReserva(Reserva reserva);
	/**
	 * Devuelve un Integer, 1 en caso positivo o 0 en caso negativo. Es un método
	 * que sirve para eliminar un objeto Reserva de la lista de reserva. Recibimos
	 * como parámetro de entrada el objeto que queremos eliminar. Mediante el método
	 * remove() de la lista eliminamos el objeto, devolviendo 1 si se pudo eliminar
	 * correctamente y 0 si no pudo ser eliminado
	 * 
	 * @param recibe como parámetro de entrada un el objeto de tipo Reserva que
	 *               queremos eliminar
	 * @return devuelve 1 si se ha podido eliminar el objeto y 0 si no se ha podido
	 *         eliminar
	 */
	int cancelarReserva(Reserva reserva);
	/**
	 * Devuelve un Integer, 1 en caso positivo o 0 en caso negativo. Es un método
	 * que sirve para eliminar un objeto Reserva de la lista de reserva. Recibimos
	 * como parámetro el id de la Reserva que queremos eliminar.Con el método findById()
	 * buscamos el objeto a eliminar y mediante el métodoremove() de la lista
	 *  eliminamos el objeto, devolviendo 1 si se pudo eliminar
	 * correctamente y 0 si no pudo ser eliminado
	 * 
	 * @param recibe como parámetro de entrada un el objeto de tipo Reserva que
	 *               queremos eliminar
	 * @return devuelve 1 si se ha podido eliminar el objeto y 0 si no se ha podido
	 *         eliminar
	 */
	int cancelarReserva(int idReserva);
	/**
	 * Es un método que sirve para autogenerar una nueva id al objeto Reserva que la
	 * llama. Comprueba los valores de id usados por los otros objetos Reserva y devuelve
	 * el siguiente valor libre. Intenta imitar el autoincrement de las BBDD
	 * 
	 * @return nextId, un Integer con el primer valor libre
	 */
	int nextIdReserva();
	/**
	 * Método que devuelve un entero. Este método comprueba la cantidad de reservas que ha realizado un
	 * Usuario en un mismo Evento y las devuelve Recibe como parámetro un objeto de tipo Usuario y otro
	 * objeto de tipo Evento
	 * @param user
	 * @param evento
	 * @return
	 */
	int comprobarReservas(Usuario user, Evento evento);

}
