package br.com.mvc.mudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mvc.mudi.model.enums.StatusPedidoEnum;
import br.com.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PedidoRepository repositoy;
	
	@GetMapping
	public String home(Model model) {
		model.addAttribute("pedidos", repositoy.findAll());
		return "home";
	}
	
	@GetMapping("/{status}")
	public String porStatus(@PathVariable("status") String status, Model model) {
		model.addAttribute("pedidos", repositoy.findByStatus(
				StatusPedidoEnum.valueOf(status.toUpperCase())));
		model.addAttribute("status", status);
		return "home";
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
}
