package com.ite.actividad.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.actividad.modelo.beans.Evento;
import com.ite.actividad.modelo.beans.Reserva;
import com.ite.actividad.modelo.beans.Usuario;
import com.ite.actividad.modelo.repository.IntEventoDao;
import com.ite.actividad.modelo.repository.IntReservasDao;
import com.ite.actividad.modelo.repository.IntUsuarioDao;

@Controller
@RequestMapping("/clientes")
public class GestionClientes {

	@Autowired
	private IntUsuarioDao iuser;

	@Autowired
	private IntEventoDao ieve;

	@Autowired
	private IntReservasDao ires;

	// ----------------------------------------------------- DATA BINDER
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}

	// ----------------------------------------------------- GET - LOGIN
	@GetMapping("/login")
	public String verLogin(HttpSession session) {

		session.invalidate();

		return "formLogin";
	}

	// ----------------------------------------------------- POST - LOGIN
	@PostMapping("/login")
	public String procesarLogin(Model model, Usuario usuario, HttpSession session) {

		Usuario user = iuser.findByNomAndPass(usuario.getUserName(), usuario.getPassword());

		if (user != null) {
			model.addAttribute(user);
			session.setAttribute("usuario", user);
			return "clientesIndex";
		} else {
			model.addAttribute("mensaje", "Usuario y/o password incorrectos");
			return "formLogin";
		}
	}

	// ----------------------------------------------------- CERRAR SESIÓN
	@GetMapping("/cerrarSesion")
	public String cerrarSesion(HttpSession session) {
		session.invalidate();
		return "formLogin";
	}

	// ----------------------------------------------------- ACTIVOS
	@GetMapping("/activos")
	public String eventosActivos(HttpSession session, Model model) {

		List<Evento> listaActivos = ieve.findActivos();
		model.addAttribute("listaActivos", listaActivos);

		return "activosCliente";
	}

	// ----------------------------------------------------- DESTACADOS
	@GetMapping("/destacados")
	public String eventosDestacados(HttpSession session, Model model) {

		List<Evento> listaDestacados = ieve.findDestacados();

		model.addAttribute("listaDestacados", listaDestacados);

		return "destacadosCliente";
	}

	// ----------------------------------------------------- DETALLE
	@GetMapping("/detalle/{id}")
	public String verDetalle(HttpSession session, Model model, @PathVariable("id") int idEvento) {

		Evento evento = ieve.findByIdEvento(idEvento);
		String fecha = dateToString(evento.getFechaInicio());
		Usuario user = (Usuario) session.getAttribute("usuario");
		int quedan = evento.getAforoMaximo();

		model.addAttribute("evento", evento);
		model.addAttribute("fecha", fecha);
		model.addAttribute("quedan", quedan);
		model.addAttribute("usuario", user);

		return "detalleCliente";
	}

	// ----------------------------------------------------- POST - RESERVAR
	@PostMapping("/reservar/{id}")
	public String procesarReserva(HttpSession session, RedirectAttributes attr, @RequestParam("cantidad") int cantidad,
			@PathVariable("id") int idEvento) {

		Reserva res = new Reserva();
		Usuario user = (Usuario) session.getAttribute("usuario");
		Evento eve = ieve.findByIdEvento(idEvento);
		int idRes = ires.nextIdReserva();
		int resTotal = ires.comprobarReservas(user, eve);

		String mensaje;
		String clase;

		double precioVenta = cantidad * eve.getPrecio();
		int quedanTotal = eve.getAforoMaximo();
		int teQuedan = 10 - resTotal;
		int peticion = quedanTotal - cantidad;

		res.setIdReserva(idRes);
		res.setEvento(eve);
		res.setUsuario(user);
		res.setPrecioVenta(precioVenta);
		res.setCantidad(cantidad);

		if (teQuedan > 0 && quedanTotal > 0 && peticion >= 0 && cantidad > 0) {
			if (cantidad > 10) {
				mensaje = "Reserva NO realizada (MAX 10 por reserva)";
				clase = "mal";
			} else {
				int cod = ires.altaReserva(res);
				if (cod > 0) {
					mensaje = "¡Reserva realizada!";
					clase = "bien";
					quedanTotal = eve.getAforoMaximo() - cantidad;
					eve.setAforoMaximo(quedanTotal);
				} else {
					mensaje = "Reserva NO realizada (prueba otra vez)";
					clase = "mal";
				}
			}

		} else if (teQuedan <= 0) {
			mensaje = "Reserva NO realizada (MAX 10 reservas)";
			clase = "mal";
		} else {
			mensaje = "Reserva NO realizada (aforo completo)";
			clase = "mal";
		}

		attr.addFlashAttribute("mensaje", mensaje);
		attr.addFlashAttribute("clase", clase);

		return "redirect:/clientes/detalle/" + idEvento;
	}

	// ----------------------------------------------------- GET - ALTA
	@GetMapping("/alta")
	public String altaCliente(HttpSession session) {

		session.invalidate();

		return "formAltaUser";
	}

	// ----------------------------------------------------- POST - ALTA
	@PostMapping("/alta")
	public String procesarAlta(Usuario user) {
		int id = iuser.nextIdUsuario();
		Date fecha = new Date();
		
		
		user.setIdUsuario(id);
		user.setFechaRegistro(fecha);
		iuser.altaUsuario(user);
		return "redirect:/clientes/login";
	}

	// ----------------------------------------------------- FECHAS
	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fecha = sdf.format(date);
		return fecha;
	}

}
