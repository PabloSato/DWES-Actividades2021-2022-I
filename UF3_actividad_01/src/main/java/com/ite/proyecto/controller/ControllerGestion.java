package com.ite.proyecto.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

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

import com.ite.proyecto.beans.Cliente;
import com.ite.proyecto.beans.Empleado;
import com.ite.proyecto.beans.Perfil;
import com.ite.proyecto.beans.Producto;
import com.ite.proyecto.beans.Proyecto;
import com.ite.proyecto.beans.ProyectoConEmpleado;
import com.ite.proyecto.repository.IntClienteDao;
import com.ite.proyecto.repository.IntEmpleadoDao;
import com.ite.proyecto.repository.IntPerfilDao;
import com.ite.proyecto.repository.IntProductoDao;
import com.ite.proyecto.repository.IntProyConEmpl;
import com.ite.proyecto.repository.IntProyectoDao;

@Controller
@RequestMapping("/gestion")
public class ControllerGestion {
	
	@Autowired
	private IntClienteDao icli;
	@Autowired
	private IntEmpleadoDao iemp;
	@Autowired
	private IntProyectoDao iproy;
	@Autowired
	private IntProductoDao iprod;


	// ----------------------------------------------------- DATA BINDER
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}
	
	// ----------------------------------------------------- GET - INICIO
	@GetMapping("/inicio")
	public String indexGest(HttpSession session, Model model) {
		
		Empleado emp = (Empleado) session.getAttribute("empleado");
		List<Proyecto> listaProyectos = iproy.findAll();
		List<Producto> listaProductos = iprod.findAll();
		
		model.addAttribute("empleado", emp);
		model.addAttribute("listaProyectos", listaProyectos);
		model.addAttribute("listaProductos", listaProductos);
		
		return "gestion";
	}
	
	// ----------------------------------------------------- GET - ALTAProyecto
	@GetMapping("/altaProyecto")
	public String getAltaProyecto(HttpSession session, Model model) {
		
		List<Cliente> listaCliente = icli.findAll();
		List<Empleado> listaJefes = iemp.listaJefeProyecto();
		Empleado emp = (Empleado)session.getAttribute("empleado");
		
		
		model.addAttribute("listaCliente", listaCliente);
		model.addAttribute("listaJefes", listaJefes);
		model.addAttribute("empleado", emp);	
				
		return "altaproyecto";
	}
	
	// ----------------------------------------------------- POST - ALTAProyecto
	@PostMapping("/altaProyecto")
	public String postAltaProyecto(RedirectAttributes attr, Proyecto proyecto) {
		
		int idEmpl = proyecto.getJefeProyecto().getIdEmpl();
		String cif = proyecto.getCliente().getCif();
		
		Empleado jefeProyecto = iemp.findById(idEmpl);
		Cliente clienteProyecto = icli.findByCif(cif);
		
		proyecto.setEstado("activo");
		proyecto.setJefeProyecto(jefeProyecto);
		proyecto.setCliente(clienteProyecto);
		
		iproy.altaProyecto(proyecto);
				
		List<Proyecto> listaProyectos = iproy.findAll();
		attr.addFlashAttribute("listaProyectos", listaProyectos);
		
		return "redirect:/gestion/inicio";
	}
	// ----------------------------------------------------- GET - TerminarProyecto
	@GetMapping("/terminarProyecto/{id}")
	public String getTerminar(Model model, @PathVariable("id") String idProyecto) {
		
		Proyecto proy = iproy.findById(idProyecto);
		String fecha = dateToString(proy.getFechaInicio());
		
		model.addAttribute("proyecto", proy);
		model.addAttribute("fechaInicio", fecha);
		return "finproyecto";
	}
	
	// ----------------------------------------------------- POST - TerminarProyecto
	@PostMapping("/terminarProyecto")
	public String postTerminar(RedirectAttributes attr, Proyecto proyecto) {
		
		String idProy = proyecto.getIdProyecto();
		Proyecto proy = iproy.findById(idProy);
		proy.setEstado("terminado");
		proy.setFechaFinReal(proyecto.getFechaFinReal());
		proy.setCosteReal(proyecto.getCosteReal());
		
		iproy.editProyecto(proy);
		List<Proyecto> listaProyectos = iproy.findAll();
		attr.addFlashAttribute("listaProyectos", listaProyectos);
		
		return "redirect:/gestion/inicio";
	}
	
	// ----------------------------------------------------- GET - ALTAProducto
	@GetMapping("/altaProducto")
	public String getAltaProducto() {
		return "";
	}
	
	// ----------------------------------------------------- POST - ALTAProducto
	@PostMapping("/altaProducto")
	public String postAltaProducto() {
		return "";
	}

	// ----------------------------------------------------- MOSTRAR FECHA
		public static String dateToString(Date date) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String fecha = sdf.format(date);
			return fecha;
		}
	
}
