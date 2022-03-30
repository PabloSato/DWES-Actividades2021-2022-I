package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.beans.Evento;
import modelo.daos.EventoDaoImpl;
import modelo.daos.IntEventoDao;
 
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

		ServletContext sc = request.getServletContext();
		IntEventoDao ieve;
		if (sc.getAttribute("ieve") != null) {
			ieve = (IntEventoDao) sc.getAttribute("ieve");
		} else {
			ieve = new EventoDaoImpl();
		}

		String opcion = request.getParameter("opcion");

		switch (opcion) {

		case "activos":
			procActivos(request, response, ieve);
			break;
		case "alta":
			procAlta(request, response, ieve);
			break;
		case "editar":
			procEditar(request, response, ieve);
			break;
		case "eliminar":
			procEliminar(request, response, ieve);
			break;
		case "cancelar":
			procCancelar(request, response, ieve);
			break;
		case "todos":
			procTodos(request, response, ieve);
			break;
		default:
			System.out.println("Opción incorrecta : " + opcion);

		}
	}

	private void procTodos(HttpServletRequest request, HttpServletResponse response, IntEventoDao ieve)
			throws ServletException, IOException {

		List<Evento> listaAll = ieve.findAll();
		request.setAttribute("listaEventos", listaAll);
		request.getRequestDispatcher("eventos.jsp").forward(request, response);

	}

	private void procCancelar(HttpServletRequest request, HttpServletResponse response, IntEventoDao ieve)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Evento ev = ieve.findByIdEvento(id);
		ieve.cancelarEvento(ev);
		List<Evento> lista = ieve.findActivos();
		request.setAttribute("listaActivos", lista);
		request.getRequestDispatcher("activos.jsp").forward(request, response);

	}

	private void procEliminar(HttpServletRequest request, HttpServletResponse response, IntEventoDao ieve)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Evento ev = ieve.findByIdEvento(id);
		ieve.eliminarEvento(ev);
		List<Evento> lista = ieve.findActivos();
		request.setAttribute("listaActivos", lista);
		request.getRequestDispatcher("activos.jsp").forward(request, response);

	}

	private void procEditar(HttpServletRequest request, HttpServletResponse response, IntEventoDao ieve)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Evento evento = ieve.findByIdEvento(id);
		request.setAttribute("evento", evento);
		request.getRequestDispatcher("editarEvento.jsp").forward(request, response);

	}

	private void procAlta(HttpServletRequest request, HttpServletResponse response, IntEventoDao ieve)
			throws ServletException, IOException {
		request.getRequestDispatcher("formAltaEvento.jsp").forward(request, response);

	}

	private void procActivos(HttpServletRequest request, HttpServletResponse response, IntEventoDao ieve)
			throws ServletException, IOException {

		List<Evento> lista = ieve.findActivos();
		request.setAttribute("listaActivos", lista);
		request.getRequestDispatcher("activos.jsp").forward(request, response);
	}

}
