package com.ite.proyecto.controller;

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

import com.ite.proyecto.beans.Empleado;
import com.ite.proyecto.beans.Producto;
import com.ite.proyecto.beans.Proyecto;
import com.ite.proyecto.beans.ProyectoConEmpleado;
import com.ite.proyecto.beans.ProyectoConProducto;
import com.ite.proyecto.repository.IntEmpleadoDao;
import com.ite.proyecto.repository.IntProductoDao;
import com.ite.proyecto.repository.IntProyConEmpl;
import com.ite.proyecto.repository.IntProyConProd;
import com.ite.proyecto.repository.IntProyectoDao;

@Controller
@RequestMapping("/jefe")
public class ControllerJefeProyecto {

	@Autowired
	private IntProyectoDao iproy;
	@Autowired
	private IntEmpleadoDao iemp;
	@Autowired
	private IntProyConEmpl ipCe;
	@Autowired
	private IntProyConProd ipcp;
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
	public String indexProy(HttpSession session, Model model) {

		Empleado emp = (Empleado) session.getAttribute("empleado");
		List<Proyecto> listaJefe = iproy.findByJefe(emp);

		model.addAttribute("empleado", emp);
		model.addAttribute("listaJefe", listaJefe);

		return "proyectos";
	}

	// ----------------------------------------------------- GET - DETALLE
	@GetMapping("/verDetalle/{id}")
	public String verDetalle(HttpSession session, Model model, @PathVariable("id") String idProy) {

		Empleado emp = (Empleado) session.getAttribute("usuario");
		Proyecto proyecto = iproy.findById(idProy);
		List<ProyectoConEmpleado> listaEmplProy = ipCe.findByProyecto(proyecto);
		List<ProyectoConProducto> listaProduc = ipcp.findByProyecto(proyecto);

		model.addAttribute("empleado", emp);
		model.addAttribute("proyecto", proyecto);
		model.addAttribute("listaEmplProy", listaEmplProy);
		model.addAttribute("listaProduc", listaProduc);

		return "detalleProyecto";
	}

	// ----------------------------------------------------- GET - ASIGNAR -
	// EMPLEADO
	@GetMapping("/asignarEmpleados/{id}")
	public String getEmpleados(HttpSession session, Model model, @PathVariable("id") String idProy) {

		Proyecto proyecto = iproy.findById(idProy);
		List<ProyectoConEmpleado> listaEmplProy = ipCe.findByProyecto(proyecto);
		List<Empleado> restoEmpleados = ipCe.findRestoEmpleados(proyecto);

		model.addAttribute("proyecto", proyecto);
		model.addAttribute("listaEmplProy", listaEmplProy);
		model.addAttribute("restoEmpleados", restoEmpleados);

		return "asignarEmpleados";
	}

	// ----------------------------------------------------- POST - ASIGNAR -
	// EMPLEADO
	@PostMapping("/asignarEmpleados/{id}")
	public String postEmpleados(HttpSession session, RedirectAttributes attr, @PathVariable("id") String idProy,
			@RequestParam("idEmpl") int idEmpl, @RequestParam("horasAsignadas") int horas,
			@RequestParam("fechaIncorporacion") Date fecha) {

		Empleado emp = iemp.findById(idEmpl);
		Proyecto proy = iproy.findById(idProy);
		int numOrden = ipCe.nextNumOrden();

		ProyectoConEmpleado pce = new ProyectoConEmpleado();
		pce.setNumeroOrden(numOrden);
		pce.setHorasAsignadas(horas);
		pce.setFechaIncorporacion(fecha);
		pce.setEmpleado(emp);
		pce.setProyecto(proy);

		ipCe.addProyConEmpl(pce);

		return "redirect:/jefe/asignarEmpleados/" + idProy;
	}

	// ----------------------------------------------------- GET - DESASIGNAR -
	// EMPLEADO
	@GetMapping("/desasignar/{idP}/{idE}") 
	public String desAsignar(Model model, @PathVariable("idP") String idProy, @PathVariable("idE") int idEmpl,
			HttpSession session) {
		Proyecto proyecto = iproy.findById(idProy);
		Empleado emp = iemp.findById(idEmpl);
		ProyectoConEmpleado pce = ipCe.findByEmplYProy(emp, proyecto);

		ipCe.delProyConEmpl(pce);

		List<ProyectoConEmpleado> listaEmplProy = ipCe.findByProyecto(proyecto);
		List<Empleado> restoEmpleados = ipCe.findRestoEmpleados(proyecto);

		model.addAttribute("proyecto", proyecto);
		model.addAttribute("listaEmplProy", listaEmplProy);
		model.addAttribute("restoEmpleados", restoEmpleados);
		return "asignarEmpleados";
	}

	// ----------------------------------------------------- GET - ASIGNAR -
	// PRODUCTO
	@GetMapping("/asignarProducto/{id}")
	public String getProucto(HttpSession session, Model model, @PathVariable("id") String idProy) {
		Proyecto proyecto = iproy.findById(idProy);
		List<ProyectoConProducto> pcp = ipcp.findByProyecto(proyecto);
		List<Producto> restoProd = ipcp.findRestoProductos(proyecto);

		model.addAttribute("proyecto", proyecto);
		model.addAttribute("productos", pcp);
		model.addAttribute("restoProd", restoProd);

		return "asignarProductos";
	}

	// ----------------------------------------------------- POST - ASIGNAR -
	// PRODUCTO
	@PostMapping("/asignarProducto/{id}")
	public String postProducto(HttpSession session, RedirectAttributes attr, @PathVariable("id") String idProy,
			@RequestParam("idProducto") int idProducto, @RequestParam("precioAsignado") double precioAsignado,
			@RequestParam("cantidad") int cantidad) {

		Proyecto proyecto = iproy.findById(idProy);
		Producto producto = iprod.findById(idProducto);
		int numOrden = ipcp.nextNumOrden();

		ProyectoConProducto pcp = new ProyectoConProducto();

		pcp.setNumeroOrden(numOrden);
		pcp.setCantidad(cantidad);
		pcp.setPrecioAsignado(precioAsignado);
		pcp.setProducto(producto);
		pcp.setProyecto(proyecto);

		ipcp.addProyConProdu(pcp);

		return "redirect:/jefe/asignarProducto/" + idProy;
	}

	// ----------------------------------------------------- GET - DESASIGNAR -
	// PRODUCTO
	@GetMapping("/desasignarProd/{idPry}/{idPrd}")
	public String desasignarProd(Model model, HttpSession session, 
			@PathVariable("idPry") String idProy, @PathVariable("idPrd") int idProd) {
		
		Proyecto proyecto = iproy.findById(idProy);
		Producto producto = iprod.findById(idProd);
		ProyectoConProducto pcp1 = ipcp.findByProdYProy(producto, proyecto);
		
		ipcp.delProyConProdu(pcp1);
		
		List<ProyectoConProducto> pcp = ipcp.findByProyecto(proyecto);
		List<Producto> restoProd = ipcp.findRestoProductos(proyecto);

		model.addAttribute("proyecto", proyecto);
		model.addAttribute("productos", pcp);
		model.addAttribute("restoProd", restoProd);
		
		return "asignarProductos";
	}

}
