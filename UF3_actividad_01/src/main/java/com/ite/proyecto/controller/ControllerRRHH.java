package com.ite.proyecto.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.proyecto.beans.Departamento;
import com.ite.proyecto.beans.Empleado;
import com.ite.proyecto.beans.Perfil;
import com.ite.proyecto.repository.IntDepartamentoDao;
import com.ite.proyecto.repository.IntEmpleadoDao;
import com.ite.proyecto.repository.IntPerfilDao;

@Controller
@RequestMapping("/rrhh")
public class ControllerRRHH {
	
	@Autowired
	private IntEmpleadoDao iemp;
	@Autowired
	private IntPerfilDao iper;
	@Autowired
	private IntDepartamentoDao idep;

	// ----------------------------------------------------- DATA BINDER
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}

	// ----------------------------------------------------- GET - INICIO
	@GetMapping("/inicio")
	public String indexRRHH(Model model, HttpSession session) {
		
		Empleado empleado = (Empleado) session.getAttribute("empleado");
		model.addAttribute("listaEmpleados", iemp.findAll());
		model.addAttribute("empleado", empleado);
		
		
		return "rrhh";
	}

	// ----------------------------------------------------- GET - ALTA
	@GetMapping("/alta")
	public String altaEmpleado(Model model, HttpSession session) {
		Empleado empleado = (Empleado)session.getAttribute("empleado");
		
		model.addAttribute("empleado", empleado);
		model.addAttribute("listaPerfil", iper.findAll());
		model.addAttribute("listaDepart", idep.findAll());
		
		return "altaEmpleado";
	}

	// ----------------------------------------------------- POST - ALTA
	@PostMapping("/alta")
	public String proceAlta(HttpSession session, RedirectAttributes attr, Empleado empleado) {
		
		
		int idDep = empleado.getDepartamento().getIdDepar();
		int idPerf = empleado.getPerfil().getIdPerfil();
		
		Departamento departamento = idep.findById(idDep);
		Perfil perfil = iper.findById(idPerf);
		
		empleado.setDepartamento(departamento);
		empleado.setPerfil(perfil);
		
		iemp.altaEmpleado(empleado);
		
		attr.addFlashAttribute("listaEmpleados", iemp.findAll());
		
		return "redirect:/rrhh/inicio";
	}

	// ----------------------------------------------------- GET - ELIMINAR
	@GetMapping("/eliminar/{id}")
	public String eliminarEmp(Model model, HttpSession session, @PathVariable("id") int idEmpl) {
		
		Empleado empleado = iemp.findById(idEmpl);
		iemp.bajaEmpleado(empleado);
		
		Empleado empl = (Empleado) session.getAttribute("empleado");
		model.addAttribute("listaEmpleados", iemp.findAll());
		model.addAttribute("empleado", empl);
		
		return "rrhh";
	}

	// ----------------------------------------------------- GET - MODIFICAR
	@GetMapping("/modificar/{id}")
	public String modificarEmpleado(Model model, HttpSession session, @PathVariable("id") int id) {
		
		Empleado empleado = iemp.findById(id);
		
		Empleado empl = (Empleado) session.getAttribute("empleado");
		model.addAttribute("empleado", empl);
		model.addAttribute("empleadoEdit", empleado);
		
		return "rrhh";
	}
	
	

}
