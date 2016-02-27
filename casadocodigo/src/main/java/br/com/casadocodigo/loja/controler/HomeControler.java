package br.com.casadocodigo.loja.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeControler {
	
	@RequestMapping("/")
	public String home() {
		System.out.println("Conecting to the home page...");
		return "home";
	}
}
