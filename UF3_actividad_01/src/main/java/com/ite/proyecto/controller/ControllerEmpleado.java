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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.proyecto.beans.Empleado;
import com.ite.proyecto.beans.Perfil;
import com.ite.proyecto.repository.IntEmpleadoDao;
import com.ite.proyecto.repository.IntPerfilDao;

@Controller
@RequestMapping("/empleados")
public class ControllerEmpleado {

	@Autowired
	IntEmpleadoDao iemp;
	@Autowired
	IntPerfilDao iper;

	// ----------------------------------------------------- DATA BINDER
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}

	// ----------------------------------------------------- GET - LOGIN
	@GetMapping("/login")
	public String getLogin() {
		return "index";
	}

	// ----------------------------------------------------- POST - LOGIN
	@PostMapping("/login")
	public String postLogin(Model model, Empleado empleado, HttpSession session, RedirectAttributes attr) {

		Empleado emp = iemp.login(empleado.getIdEmpl(), empleado.getCorreo(), empleado.getPassword());

		if (emp != null) {
			Perfil gestion = iper.findById(1);
			Perfil jefProy = iper.findById(2);
			Perfil operactivo = iper.findById(3);

			Perfil aux = emp.getPerfil();

			session.setAttribute("empleado", emp);
			attr.addFlashAttribute(emp);

			if (aux.equals(gestion)) {
				return "redirect:/gestion/inicio";
			} else if (aux.equals(jefProy)) {
				return "redirect:/jefe/inicio";
			} else if (aux.equals(operactivo)) {
				return "operaciones";
			} else {
				return "redirect:/rrhh/inicio";
			}

		} else {
			model.addAttribute("mensaje", "Datos incorrectos, prueba otra vez");
			return "index";
		}

	}

	// ----------------------------------------------------- CERRAR SESIÓN
	@GetMapping("/cerrarSesion")
	public String cerrarSesion(HttpSession session) {
		session.invalidate();
		return "forward:/inicio";
	}
}
