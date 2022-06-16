package br.com.mvc.mudi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.mvc.mudi.model.Pedido;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(Model model) {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Nintendo Switch Lite Coral - Versão Nacional");
		pedido.setUrlImagem("https://m.media-amazon.com/images/I/61sfRoauZ8L._AC_SX385_.jpg");
		pedido.setUrlProduto("https://www.amazon.com.br/dp/B09BDP1JXX?aaxitk=2d540e64d0589f9c42d1ad3edab674df&pd_rd_plhdr=t&smid=A1ZZFT5FULY4LN&ref=dacx_dp_584567158933768536_587232257304055682");		
		pedido.setDescricao("nintendo switch");
		
		List<Pedido> pedidos = Arrays.asList(pedido);
		model.addAttribute("pedidos", pedidos);
		
		return "home";
	}

}
