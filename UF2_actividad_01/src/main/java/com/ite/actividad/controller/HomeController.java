package com.ite.actividad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/inicio")
	public String inicio(Model model) {

		return "index";
	}
}
