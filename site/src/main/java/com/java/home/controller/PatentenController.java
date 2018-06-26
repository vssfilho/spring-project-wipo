package com.java.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/patente")
public class PatentenController {

	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String cadastrar() {
		return "patente/cadastro";
	}
	
	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public String consultar() {
		return "patente/consultar";
	}
	
}
