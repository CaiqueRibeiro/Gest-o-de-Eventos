package web.viewhelper.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.util.Resultado;
import dominio.evento.IDominio;
import dominio.participantes.Administrador;
import web.services.LoginService;
import web.viewhelper.IViewHelper;

public class UsuarioVH implements IViewHelper {

	@Override
	public IDominio getData(HttpServletRequest request) {
		
		String operacao = request.getParameter("operacao");
		
		Administrador administrador;
		
		if(operacao.equals("CONSULTAR")) {
			LoginService loginService = new LoginService(request);
			
			administrador = (Administrador) loginService.getLogin();
			
			if(administrador == null) {
				String email = request.getParameter("email");
				String senha = request.getParameter("senha");
				
				administrador = new Administrador();
				administrador.setEmail(email);
				administrador.setSenha(senha);
			}
			
		} else {
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			administrador = new Administrador();
			administrador.setEmail(email);
			administrador.setSenha(senha);			
		}
		
		return administrador;
	}

	@Override
	public void formataView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		List<IDominio> recebido = null;
		List<Administrador> usrRecebidos = null;
		String msgErro = "";
		
		if(resultado != null) {
			msgErro = resultado.getMensagem();
			
			recebido = resultado.getEntidades();
			usrRecebidos = (List<Administrador>) (Object) recebido;
		}
		
		if(msgErro != null && msgErro != "") {
			request.setAttribute("mensagem", msgErro);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		} else {
			if(recebido == null || recebido.size() <= 0) {
				request.setAttribute("erro", "Usuário ou senha inválidos");
				request.getRequestDispatcher("login.jsp").forward(request, response);			
			} else {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		
	}

}
