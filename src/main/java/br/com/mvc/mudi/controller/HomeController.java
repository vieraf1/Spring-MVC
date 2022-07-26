package br.com.mvc.mudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		Sort sort = Sort.by("dataEntrega").descending();
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		
		model.addAttribute("pedidos", repositoy.findByStatus(StatusPedidoEnum.ENTREGUE, paginacao));
		return "home";
	}
}
