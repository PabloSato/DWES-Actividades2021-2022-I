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

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/activos")
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
		super.init(config);
		IntEventoDao ieve = new EventoDaoImpl();
		ServletContext sc = config.getServletContext();
		sc.setAttribute("ieve", ieve);
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IntEventoDao ieve;
		//recogemos el ServletContext
		ServletContext sc = this.getServletContext();
		ieve = (IntEventoDao)sc.getAttribute("ieve");
		
		
		//Creamos un objeto de Evento y sacamos la lista y se lo pasamos al index
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
