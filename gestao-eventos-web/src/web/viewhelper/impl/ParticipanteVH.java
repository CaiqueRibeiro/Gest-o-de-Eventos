package web.viewhelper.impl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.util.Resultado;
import dominio.endereco.Endereco;
import dominio.evento.IDominio;
import dominio.participantes.Participante;
import web.viewhelper.IViewHelper;

public class ParticipanteVH implements IViewHelper {

	@Override
	public IDominio getData(HttpServletRequest request) {
		
		String operacao = request.getParameter("operacao");
		Participante participante = new Participante();
		
		if(operacao.equals("SALVAR") || operacao.equals("ATUALIZAR")) {
			
			Endereco endereco = new Endereco();			
			
			if(operacao.equals("ATUALIZAR")) {
				String participanteId = request.getParameter("part-id");
				String enderecoId = request.getParameter("end-id");
				
				participante.setId(Integer.parseInt(participanteId));
				
				endereco.setId(Integer.parseInt(enderecoId));
				
				System.out.println("ID do endereço no VH " + endereco.getId());
			}
			
						
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
			
		} // OPERACAO SALVAR E ALTERAR
		else if(operacao.equals("CONSULTAR") || operacao.equals("EXCLUIR")) {

			
			String participanteId = request.getParameter("part-id");
			String nomeParticipante = request.getParameter("nome");
			
			if(participanteId != null && participanteId != "") {
				participante.setId(Integer.parseInt(participanteId));
			} else if(nomeParticipante != null && nomeParticipante != "") {
				participante.setNome(nomeParticipante);
			}
			
			if(operacao.equals("EXCLUIR")) {
				
				Endereco endereco = new Endereco();
				
				String enderecoId = request.getParameter("end-id");				
				
				endereco.setId(Integer.parseInt(enderecoId));
				
				participante.setEndereco(endereco);
				
				System.out.println("ID do participante no VH: " + participante.getId());
			}
		}
				
		return participante;		
	}

	@Override
	public void formataView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		List<IDominio> recebido = null;
		List<Participante> ptcRecebidos = null;
		String msgErro = "";
		String uri = request.getRequestURI();
		
		
		if(resultado != null) {
			msgErro = resultado.getMensagem();
				
			recebido = resultado.getEntidades();
			ptcRecebidos = (List<Participante>) (Object) recebido;
		}
			
			if(msgErro != null && msgErro != "") {
				request.setAttribute("mensagem", msgErro);
				request.getRequestDispatcher("erro.jsp").forward(request, response);
			} else {
			
				if(recebido == null || recebido.size() <= 0) {
					request.setAttribute("erro", "Não há eventos");
					request.getRequestDispatcher("lista-participantes.jsp").forward(request, response);			
				} else if(recebido.size() > 1) {
					request.setAttribute("resultado", ptcRecebidos);
					request.getRequestDispatcher("lista-participantes.jsp").forward(request, response);
				} else {
					String editavel = request.getParameter("editar");
					System.out.println("Editável? " + editavel);
					
					Participante participante = (Participante) recebido.get(0);
					request.setAttribute("resultado", participante);
					if(editavel != "" && editavel != null) {
						if(editavel.equals("false"))
							request.getRequestDispatcher("consulta-participante.jsp").forward(request, response);
						else
							request.getRequestDispatcher("atualiza-participante.jsp").forward(request, response);
					} else {
						request.getRequestDispatcher("sucesso.jsp").forward(request, response);
					}
				}
			
			} // caso não tenha mensagem de erro
		
		
	}

}
