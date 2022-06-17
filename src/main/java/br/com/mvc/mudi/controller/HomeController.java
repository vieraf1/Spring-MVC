package br.com.mvc.mudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.mvc.mudi.repository.PedidoRepository;

@Controller
public class HomeController {
	
	@Autowired
	private PedidoRepository repositoy;
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("pedidos", repositoy.findAll());
		return "home";
	}

}
