package controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.daos.EventoDaoImpl;
import modelo.daos.IntEventoDao;
import modelo.daos.IntTipoDao;
import modelo.daos.TipoDaoImpl;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/inicio")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

		// Desde este Servlet nos ponemos en contacto con la capa de datos

		/*
		 * Para poder compartir el acceso y la manipulación de los mismos datos desde
		 * cualquier parte de la web, creamos dos ATRIBUTOS DE APLICACIÓN (uno de
		 * Interfaz de Eventos y el otro Interfaz de Tipo) creando el objeto
		 * ServletContext al entrar en la aplicación web. Por eso los inicializamos en
		 * el init del HomeController
		 */

		super.init(config);// Para poder hacer uso del ServletContext, sobreescribimos la versión del
							// init()
		// Instanciamos los dos objetos de tipo Interfaz
		IntEventoDao ieve = new EventoDaoImpl();// Interfaz de tipo EventoDaoImpl (dónde están los metodos y los datos)
		IntTipoDao itipo = new TipoDaoImpl();// Interfaz de tipo TipoDatoImpl (dónde están los metodos y los datos)
		ServletContext sc = config.getServletContext(); // Obtenemos el objeto ServletContext
		sc.setAttribute("ieve", ieve);// Pasamos como atributos del ServletContext el objeto de tipo interfaz Evento
		sc.setAttribute("itipo", itipo);// Pasamos como atributos del ServletContext el objeto de tipo interfaz Tipo
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IntEventoDao ieve; // Creamos un objeto de tipo Interfaz de Evento sin Inicializar
		IntTipoDao itipo;// Creamos un objeto de tipo Interfaz de Tipo sin Inicializar

		ServletContext sc = this.getServletContext();// recogemos el ServletContext del init()
		ieve = (IntEventoDao) sc.getAttribute("ieve");// Recogemos los atributos de Interfaz de Evento del
														// ServletContext e inicializamos el objeto Interfaz de Evento
		itipo = (IntTipoDao) sc.getAttribute("itipo");// Recogemos los atributos de Interfaz de Evento del
														// ServletContext e inicializamos el objeto Interfaz de Tipo

		// Solicitamos la implementación del RequestDispatcher para traspasar la
		// petición al JSP de nuestra pagina index
		request.getRequestDispatcher("index.jsp").forward(request, response);// con el método forward() transferimos
																				// totalmente el control al componente
																				// de destino
	}

}
