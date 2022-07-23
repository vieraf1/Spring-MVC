package br.com.mvc.mudi.controller;

import java.security.Principal;

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
@RequestMapping("usuario")
public class UserController {

	@Autowired
	private PedidoRepository repositoy;
	
	@GetMapping("pedido")
	public String home(Model model, Principal principal) {
		model.addAttribute("pedidos", repositoy.findByUserUsername(principal.getName()));
		return "usuario/home";
	}
	
	@GetMapping("pedido/{status}")
	public String porStatus(@PathVariable("status") String status, Model model, Principal principal) {
		model.addAttribute("pedidos", repositoy.findByStatusAndUser(
				StatusPedidoEnum.valueOf(status.toUpperCase()), principal.getName()));
		model.addAttribute("status", status);
		return "usuario/home";
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/usuario/home";
	}
	
}
