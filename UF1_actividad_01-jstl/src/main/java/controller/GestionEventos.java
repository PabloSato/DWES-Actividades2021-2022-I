package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.beans.Evento;
import modelo.beans.Tipo;
import modelo.daos.EventoDaoImpl;
import modelo.daos.IntEventoDao;
import modelo.daos.IntTipoDao;
import modelo.daos.TipoDaoImpl;

/**
 * Servlet implementation class GestionEventos
 */
@WebServlet("/eventos")
public class GestionEventos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionEventos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Desde este Servlet realizamos la gestión de los Eventos que nos solicitan las
		// peticiones URL

		ServletContext sc = request.getServletContext();// Recuperamos el ServletContext creado en el HomeController
														// (donde vienen todos los datos)
		IntEventoDao ieve;// Creamos un objeto de tipo Interfaz de Eventos sin inicializar
		IntTipoDao itipo;// Creamos un objeto de tipo Interfaz de Tipo sin inicializar
		if (sc.getAttribute("ieve") != null) { // Preguntamos si el ServletContext tiene un atributo llamado "ieve"
			ieve = (IntEventoDao) sc.getAttribute("ieve");// En caso afirmativo, inicializamos el Objeto de Interfaz de
															// Eventos con él
		} else {
			ieve = new EventoDaoImpl();// En caso negativo, creamos una nueva interfaz de Evento
		}
		if (sc.getAttribute("itipo") != null) {// Preguntamos si el ServletContext tiene un atributo llamado "itipo"
			itipo = (IntTipoDao) sc.getAttribute("itipo");// En caso afirmativo, inicializamos el Objeto de Interfaz de
															// Tipo con él
		} else {
			itipo = new TipoDaoImpl();// En caso negativo, creamos una nueva interfaz de Tipo
		}

		String opcion = request.getParameter("opcion");// Recogemos el parámetro "opcion" de la petición insertado en la
														// URL

		// Usamos un switch para recoger todas las actuaciones posibles atribuidas a la
		// petición
		switch (opcion) {

		case "activos":// En caso que opcion sea "activos" lanzamos el método procActivos()
			procActivos(request, response, ieve);// Este método recibe tres atributo, el request, el response y un
													// atributo de tipo Interfaz de Evento
			break;
		case "alta":// En caso que opcion sea "alta" lanzamos el método procAlta()
			procAlta(request, response, ieve, itipo);// Este método recibe cuatro atributo, el request, el response, un
														// atributo de tipo Interfaz de Evento y un atributo de tipo
														// Interfaz de Tipo
			break;
		case "editar":// En caso que opcion sea "editar" lanzamos el método procEditar()
			procEditar(request, response, ieve, itipo);// Este método recibe cuatro atributo, el request, el response,
														// un atributo de tipo Interfaz de Evento y un atributo de tipo
														// Interfaz de Tipo
			break;
		case "eliminar":// En caso que opcion sea "eliminar" lanzamos el método procEliminar()
			procEliminar(request, response, ieve);// Este método recibe tres atributo, el request, el response y un
													// atributo de tipo Interfaz de Evento
			break;
		case "cancelar":// En caso que opcion sea "cancelar" lanzamos el método procCancelar()
			procCancelar(request, response, ieve);// Este método recibe tres atributo, el request, el response y un
													// atributo de tipo Interfaz de Evento
			break;
		case "todos":// En caso que opcion sea "todos" lanzamos el método procTodos()
			procTodos(request, response, ieve);// Este método recibe tres atributo, el request, el response y un
												// atributo de tipo Interfaz de Evento
			break;
		default:
			System.out.println("Opción incorrecta : " + opcion);

		}
	}

	private void procTodos(HttpServletRequest request, HttpServletResponse response, IntEventoDao ieve)
			throws ServletException, IOException {
		// El método procTodos crea una lista con todos los Eventos que hay cargados
		// (activos y cancelados)
		List<Evento> listaAll = ieve.findAll();
		request.setAttribute("listaEventos", listaAll);// Cargamos esa lista como atributo
		request.getRequestDispatcher("eventos.jsp").forward(request, response);// Traspasamos la lista a la página
																				// eventos.jsp

	}

	private void procCancelar(HttpServletRequest request, HttpServletResponse response, IntEventoDao ieve)
			throws ServletException, IOException {
		// El método procCancelar recoge en una variable de tipo Integer el parámetro id
		// (insertado en la URL de a petición)
		int id = Integer.parseInt(request.getParameter("id"));// Al devolver String el request, forzamos su conversión a
																// integer
		Evento ev = ieve.findByIdEvento(id);// Creamos un objeto de tipo evento y usamos el método findById() de la
											// interfaz
		ieve.cancelarEvento(ev);// Cancelamos el evento usando el método cancelarEvento() de la interfaz
		List<Evento> lista = ieve.findActivos(); // Creamos una lista con todos los eventos activos (excluimos los
													// "cancelados")
		request.setAttribute("listaActivos", lista);// Cargamos la lista como atributo
		request.getRequestDispatcher("activos.jsp").forward(request, response);// Traspasamos la lista a la página
																				// activos.jsp

	}

	private void procEliminar(HttpServletRequest request, HttpServletResponse response, IntEventoDao ieve)
			throws ServletException, IOException {
		// El método procEliminar recoge en una variable de tipo Integer el parámetro id
		// (insertado en la URL de a petición)
		int id = Integer.parseInt(request.getParameter("id"));// Al devolver String el request, forzamos su conversión a
																// integer
		Evento ev = ieve.findByIdEvento(id);// Creamos un objeto de tipo evento y usamos el método findById() de la
											// interfaz
		ieve.eliminarEvento(ev);// Eliminamos el evento usando el método eliminarEvento() de la interfaz
		List<Evento> lista = ieve.findActivos();// Creamos una lista con todos los eventos activos (excluimos los
												// "cancelados")
		request.setAttribute("listaActivos", lista);// Cargamos la lista como atributo
		request.getRequestDispatcher("activos.jsp").forward(request, response);// Traspasamos la lista a la página
																				// activos.jsp

	}

	private void procEditar(HttpServletRequest request, HttpServletResponse response, IntEventoDao ieve,
			IntTipoDao itipo) throws ServletException, IOException {
		// Preguntamos primero si hemos recibido un Parámetro llamado "submit"
		if (request.getParameter("submit") != null) {
			// En caso afirmativo recogemos todos los parámetros recibidos en variables
			// según su tipo (forzando la conversión donde corresponda)
			int id = Integer.parseInt(request.getParameter("id"));
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			String fecha = request.getParameter("fechaInicio");
			int duracion = Integer.parseInt(request.getParameter("duracion"));
			String dire = request.getParameter("direccion");
			String estado = request.getParameter("estado");
			String dest = request.getParameter("destacado");
			int aforoMax = Integer.parseInt(request.getParameter("aforoMaximo"));
			int minAsis = Integer.parseInt(request.getParameter("minimaAsistencia"));
			double precio = Double.parseDouble(request.getParameter("precio"));
			int idTipo = Integer.parseInt(request.getParameter("tipo"));

			Tipo tipo = itipo.findByIdTipo(idTipo);// Creamos un objeto de tipo Tipo y usamos el método findById() de la
			char destacado;// Creamos un objeto de tipo char
			if (dest != null) {// En caso que la variable dest sea distinta de null
				destacado = dest.charAt(0);// Convertimos a char (cogemos solo el primer caracter, y al haber sólo uno
											// no hay error posible
			} else {// En caso contrario, que dest sea null
				dest = "n"; // le damos el valos de "n"
				destacado = dest.charAt(0);// e inicializamos la variable char con el nuevo valor
			}
			// Convierto a Date el String fecha usando el método creado ad hoc
			Date date = stringToDate(fecha);
			// Creamos un objeto evento y le pasamos en el constructor todas las variables
			// recibidas
			Evento evento = new Evento(id, nombre, descripcion, date, duracion, dire, estado, destacado, aforoMax,
					minAsis, precio, tipo);
			// usamos el método editarEvento() de la interfaz de Evento para actualizar el
			// objeto Evento
			ieve.editarEvento(evento);
			List<Evento> listaAll = ieve.findAll();// Creamos una lista con todos los eventos (activos y cancelados
													// incluidos)
			request.setAttribute("listaEventos", listaAll);// Cargamos la lista como atributo
			request.getRequestDispatcher("eventos.jsp").forward(request, response);// Traspasamos la lista a la página
																					// eventos.jsp

		} else {// En caso de no recibir ningun paráetro "submit"

			// Recogemos en una variable de tipo Integer el parámetro "id"
			int id = Integer.parseInt(request.getParameter("id"));// Al devolver String el request, forzamos su
																	// conversión a integer
			Evento evento = ieve.findByIdEvento(id);// Creamos un objeto de tipo evento y usamos el método findById() de
			// la interfaz
			String fecha = dateToString(evento.getFechaInicio());// Convertimos a String la fecha
			request.setAttribute("evento", evento);// Cargamos como atributo el propio objeto
			request.setAttribute("fechaForm", fecha);// Cargamos como atributo la fecha
			List<Tipo> listaAll = itipo.findAll();// Creamos una lista con todos los objetos de tipo Tipo (activos y
													// cancelados incluidos)

			request.setAttribute("listaTipoFrom", listaAll);// Cargamos la lista como atributo
			request.getRequestDispatcher("editarEvento.jsp").forward(request, response);// Traspasamos la lista a la
																						// página editarEventos.jsp

		}

	}

	private void procAlta(HttpServletRequest request, HttpServletResponse response, IntEventoDao ieve, IntTipoDao itipo)
			throws ServletException, IOException {
		// Preguntamos primero si hemos recibido un Parámetro llamado "submit"
		if (request.getParameter("submit") != null) {
			// En caso afirmativo recogemos todos los parámetros recibidos en variables
			// según su tipo (forzando la conversión donde corresponda)
			int id = Integer.parseInt(request.getParameter("id"));
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			String fecha = request.getParameter("fechaInicio");
			int duracion = Integer.parseInt(request.getParameter("duracion"));
			String dire = request.getParameter("direccion");
			String estado = request.getParameter("estado");
			String dest = request.getParameter("destacado");
			int aforoMax = Integer.parseInt(request.getParameter("aforoMaximo"));
			int minAsis = Integer.parseInt(request.getParameter("minimaAsistencia"));
			double precio = Double.parseDouble(request.getParameter("precio"));
			int idTipo = Integer.parseInt(request.getParameter("tipo"));

			Tipo tipo = itipo.findByIdTipo(idTipo);// Creamos un objeto de tipo Tipo y usamos el método findById() de la
													// interfaz Tipo apra inicializarle con el objeto correcto
			char destacado;// Creamos un objeto de tipo char
			if (dest != null) {// En caso que la variable dest sea distinta de null
				destacado = dest.charAt(0);// Convertimos a char (cogemos solo el primer caracter, y al haber sólo uno
											// no hay error posible
			} else {// En caso contrario, que dest sea null
				dest = "n"; // le damos el valos de "n"
				destacado = dest.charAt(0);// e inicializamos la variable char con el nuevo valor
			}
			// Convierto a Date el String fecha usando el método creado ad hoc
			Date date = stringToDate(fecha);
			// Creamos un objeto evento y le pasamos en el constructor todas las variables
			// recibidas
			Evento nuevo = new Evento(id, nombre, descripcion, date, duracion, dire, estado, destacado, aforoMax,
					minAsis, precio, tipo);
			// usamos el método altaEvento() de la interfaz de Evento para añadir un nuevo
			// objeto de tipo Evento a los datos
			ieve.altaEvento(nuevo);
			List<Evento> listaAll = ieve.findAll();// Creamos una lista con todos los eventos (activos y cancelados
													// incluidos)
			request.setAttribute("listaEventos", listaAll);// Cargamos la lista como atributo
			request.getRequestDispatcher("eventos.jsp").forward(request, response);// Traspasamos la lista a la página
																					// eventos.jsp

		} else {
			// En caso de no recibir ningun paráetro "submit"
			List<Tipo> listaAll = itipo.findAll();// Creamos una lista con todos los objetos de tipo Tipo (activos y
													// cancelados incluidos)
			request.setAttribute("listaTipoFrom", listaAll);// Cargamos la lista como atributo
			request.getRequestDispatcher("formAltaEvento.jsp").forward(request, response);// Traspasamos la lista a la
																							// página formAltaEvento.jsp

		}

	}

	private void procActivos(HttpServletRequest request, HttpServletResponse response, IntEventoDao ieve)
			throws ServletException, IOException {
		// El método procActivos crea una lista con todos los Eventos que hay cargados
		// que sean activos
		List<Evento> lista = ieve.findActivos(); // Creamos una lista y la cargamos con todos los eventos activos,
													// usando el método de la interfaz findActivos()
		request.setAttribute("listaActivos", lista);// Cargamos la lista como atributo
		request.getRequestDispatcher("activos.jsp").forward(request, response);// Traspasamos la lista a la página
																				// activos.jsp
	}

	// CREO UNOS METODOS PARA DAR FORMATO A LA FECHA
	// Este Método recibe una fecha (tipo Date()) y la devuelve en formato String y
	// con un Formato definido y más manejable
	public static String dateToString(Date date) {
		String pattern = "dd/MM/yyyy";// Declaramos un string con el formato que queremos
		SimpleDateFormat simpleDate = new SimpleDateFormat(pattern); // Formateamos con el patron creado y
																		// simpleDateFormat
		String strDate = simpleDate.format(date);// Formateamos la fecha que recibimos y la guardamos en una variable
		return strDate;// devolvemos la fecha en formato String y formateada
	}

	// Este Método recibe una fecha en String y formateada y nos devuevle un objeto
	// Date();
	public static Date stringToDate(String fecha) {
		Date date = new Date();
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat simpleDate = new SimpleDateFormat(pattern);
		try {
			date = simpleDate.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return date;
	}

}
