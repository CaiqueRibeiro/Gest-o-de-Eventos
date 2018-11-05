package web.viewhelper.impl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.util.Resultado;
import dominio.endereco.Endereco;
import dominio.evento.IDominio;
import dominio.participantes.Administrador;
import dominio.participantes.Participante;
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
			
			if(operacao.equals("SALVAR") || operacao.equals("ALTERAR")) {
				
				Participante participante = new Participante();
				Endereco endereco = new Endereco();
				
				// insere informações sobre o evento
				participante.setNome(request.getParameter("nome"));
				participante.setEmail(request.getParameter("email"));
				participante.setTelefone(request.getParameter("telefone"));
				participante.setGenero(Integer.parseInt(request.getParameter("genero")));
				participante.setCpf(request.getParameter("cpf"));
				
				// insere informações sobre o endereço
				endereco.setLogradouro(request.getParameter("logradouro"));
				endereco.setRua(request.getParameter("rua"));
				endereco.setNumero(request.getParameter("numero"));
				endereco.setCEP(request.getParameter("cep"));
				endereco.setBairro(request.getParameter("bairro"));
				endereco.setCidade(request.getParameter("cidade"));
				endereco.setEstado(request.getParameter("estado"));
				
				// Formata a data
				SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");			
				try {
					
					participante.setDtNascimento(sd.parse(request.getParameter("data")));
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // fim da formatação de datas
				
				// insere o endereço dentro do obj participante
				participante.setEndereco(endereco);
				administrador.setParticipante(participante);
			}
		}
		
		return administrador;
	}

	@Override
	public void formataView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		List<IDominio> recebido = null;
		List<Administrador> usrRecebidos = null;
		String msgErro = "";
		String operacao = request.getParameter("operacao");
		
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
				
				if(operacao.equals("SALVAR")) {
					response.sendRedirect("login.jsp");					
				}
				
				LoginService service = new LoginService(request);
				service.setLogin(usrRecebidos.get(0));
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		
	}

}
