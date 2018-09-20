package web.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dominio.participantes.Administrador;
import dominio.participantes.Usuario;


public class LoginService {
	
	HttpServletRequest request;
	HttpServletResponse response;
	
	public LoginService(HttpServletRequest request, HttpServletResponse response) {
		
		this.request = request;
		this.response = response;
		
	}
	
	public LoginService(HttpServletRequest request) {
		
		this.request = request;
		
	}
	
	public Usuario getLogin() {
		
		HttpSession session = request.getSession();
		
		Administrador usuario = (Administrador) session.getAttribute("usuarioLogado");
		
		return usuario;		
		
	}

}
