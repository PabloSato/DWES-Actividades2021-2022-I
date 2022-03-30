package com.ite.actividad.controller;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

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
import com.ite.actividad.modelo.beans.Tipo;
import com.ite.actividad.modelo.repository.IntEventoDao;
import com.ite.actividad.modelo.repository.IntTipoDao;

@Controller
@RequestMapping("/eventos")
public class GestionEventos {

	@Autowired
	private IntTipoDao itipoDao;

	@Autowired
	private IntEventoDao ieveDao;

	// ----------------------------------------------------- DATA BINDER
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}

	// ----------------------------------------------------- TODOS
	@GetMapping("/todos")
	public String eventos(Model model) {
		List<Evento> lista = ieveDao.findAll();
		model.addAttribute("listaEventos", lista);
		return "eventos";
	}

	// ----------------------------------------------------- ACTIVOS
	@GetMapping("/activos")
	public String activos(Model model) {

		List<Evento> listaActivos = ieveDao.findActivos();
		model.addAttribute("listaActivos", listaActivos);
		return "activos";
	}

	// ----------------------------------------------------- GET - ALTA
	@GetMapping("/alta")
	public String altaEvento(Model model) {

		List<Tipo> listaTipo = itipoDao.findAll();
		model.addAttribute("listaTipo", listaTipo);
		return "formAltaEvento";
	}

	// ----------------------------------------------------- POST - ALTA
	@PostMapping("/alta")
	public String procesarAlta(RedirectAttributes attr, Evento evento) {

		int idTipo = evento.getTipo().getIdTipo();
		Tipo tipoEven = itipoDao.findByIdTipo(idTipo);
		int idEvento = ieveDao.nextIdEvento();
		evento.setIdEvento(idEvento);
		evento.setEstado("activo");
		evento.setTipo(tipoEven);
		ieveDao.altaEvento(evento);

		List<Evento> listaActivos = ieveDao.findActivos();
		attr.addFlashAttribute("listaActivos", listaActivos);
		return "redirect:/eventos/activos";
	}

	// ----------------------------------------------------- ELIMINAR
	// Con Path Dinámica
	@GetMapping("/eliminar")
	public String eliminar(Model model, @RequestParam("id") int idEvento) {

		Evento eve = ieveDao.findByIdEvento(idEvento);
		ieveDao.eliminarEvento(eve);

		List<Evento> lista = ieveDao.findAll();
		model.addAttribute("listaEventos", lista);

		return "eventos";
	}

	// ----------------------------------------------------- GET - EDITAR
	// Con Path Variable
	@GetMapping("/editar/{id}")
	public String editarEvento(Model model, @PathVariable("id") int idEvento) {

		Evento eve = ieveDao.findByIdEvento(idEvento);
		String fecha = dateToString(eve.getFechaInicio());
		List<Tipo> listaTipo = itipoDao.findAll();

		model.addAttribute("evento", eve);
		model.addAttribute("fecha", fecha);
		model.addAttribute("listaTipo", listaTipo);

		return "editarEvento";
	}

	// ----------------------------------------------------- POST - EDITAR
	@PostMapping("/editar")
	public String procesarEditar(RedirectAttributes attr, Evento evento) {

		ieveDao.editarEvento(evento);

		List<Evento> listaActivos = ieveDao.findActivos();
		attr.addFlashAttribute("listaActivos", listaActivos);

		return "redirect:/eventos/activos";
	}

	// ----------------------------------------------------- CANCELAR
	// Path Dinámica
	@GetMapping("/cancelar")
	public String cancelarEvento(Model model, @RequestParam("id") int idEvento) {

		Evento eve = ieveDao.findByIdEvento(idEvento);
		ieveDao.cancelarEvento(eve);

		List<Evento> listaActivos = ieveDao.findActivos();
		model.addAttribute("listaActivos", listaActivos);

		return "activos";
	}

	// ----------------------------------------------------- MOSTRAR FECHA
	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fecha = sdf.format(date);
		return fecha;
	}

}
