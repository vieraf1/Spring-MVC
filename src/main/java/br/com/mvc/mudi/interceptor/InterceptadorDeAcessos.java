package br.com.mvc.mudi.interceptor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class InterceptadorDeAcessos extends HandlerInterceptorAdapter {

	public static List<Acesso> acessos = new ArrayList<>();
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {	
		Acesso acesso = new Acesso();
		acesso.path = request.getRequestURI();
		acesso.data = LocalDateTime.now();
		
		request.setAttribute("acesso", acesso);	
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {	
		Acesso acesso = (Acesso) request.getAttribute("acesso");
		acesso.duracao = Duration.between(acesso.data, LocalDateTime.now());
		acessos.add(acesso);
	}
	
	public static class Acesso {
		private String path;
		private LocalDateTime data;
		private Duration duracao;
		
		public LocalDateTime getData() {
			return data;
		}
		
		public Duration getDuracao() {
			return duracao;
		}
		
		public String getPath() {
			return path;
		}
	}
	
}
