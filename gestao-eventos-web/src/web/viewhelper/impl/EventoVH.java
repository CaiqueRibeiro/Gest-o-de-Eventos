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
import dominio.endereco.Locacao;
import dominio.evento.Evento;
import dominio.evento.IDominio;
import dominio.evento.Rateio;
import dominio.participantes.Administrador;
import web.viewhelper.IViewHelper;

public class EventoVH implements IViewHelper {

	@Override
	public IDominio getData(HttpServletRequest request) {
		
		String operacao = request.getParameter("operacao");
		Evento evento = new Evento();
		
		if(operacao.equals("SALVAR") || operacao.equals("ATUALIZAR")) {
			
			Rateio rateio = new Rateio();
			Endereco endereco = new Endereco();
			Administrador administrador = new Administrador();
			Locacao locacao = new Locacao();
			
			
			if(operacao.equals("ATUALIZAR")) {
				String eventoId = request.getParameter("evt-id");
				String enderecoId = request.getParameter("end-id");
				String rateioId = request.getParameter("rat-id");
				
				evento.setId(Integer.parseInt(eventoId));
				endereco.setId(Integer.parseInt(enderecoId));
				rateio.setId(Integer.parseInt(rateioId));
			}
			
			administrador.setId(2);
			locacao.setId(Integer.parseInt(request.getParameter("locacao")));
						
			// insere informações sobre o evento
			evento.setNome(request.getParameter("nome"));
			evento.setCategoria(Integer.parseInt(request.getParameter("categoria")));
			evento.setHora(request.getParameter("hora"));
			evento.setQdtMaximaPessoas(Integer.parseInt(request.getParameter("max-participantes")));
			evento.setSituacao(request.getParameter("situacao"));
			
			// insere informações sobre o endereço
			endereco.setLogradouro(request.getParameter("logradouro"));
			endereco.setRua(request.getParameter("rua"));
			endereco.setNumero(request.getParameter("numero"));
			endereco.setCEP(request.getParameter("cep"));
			endereco.setBairro(request.getParameter("bairro"));
			endereco.setCidade(request.getParameter("cidade"));
			endereco.setEstado(request.getParameter("estado"));
			
			rateio.setValorPagar(10000);
			
			// Formata as datas necessárias
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");			
			try {
				evento.setData(sd.parse(request.getParameter("data")));
				rateio.setInicioRateio(sd.parse(request.getParameter("inicio-rateio")));
				rateio.setFimRateio(sd.parse(request.getParameter("final-rateio")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // fim da formatação de datas
			
			// insere os objetos dentro de evento
			evento.setRateio(rateio);
			evento.setEndereco(endereco);
			evento.setAdministrador(administrador);
			evento.setLocacao(locacao);
		} // OPERACAO SALVAR E ALTERAR
		else if(operacao.equals("CONSULTAR") || operacao.equals("EXCLUIR")) {

			
			String eventoId = request.getParameter("evt-id");
			String eventoNome = request.getParameter("nome");
			
			if(eventoId != null && eventoId != "") {
				evento.setId(Integer.parseInt(eventoId));
			} else if(eventoNome != null && eventoNome != "") {
				evento.setNome(eventoNome);
			}
			
			if(operacao.equals("EXCLUIR")) {
				
				Rateio rateio = new Rateio();
				Endereco endereco = new Endereco();
				
				String enderecoId = request.getParameter("end-id");
				String rateioId = request.getParameter("rat-id");
				
				
				endereco.setId(Integer.parseInt(enderecoId));
				rateio.setId(Integer.parseInt(rateioId));
				
				evento.setEndereco(endereco);
				evento.setRateio(rateio);
				
				System.out.println("ID no VH: " + rateio.getId());
			}
		}
				
		return evento;		
		
	}

	@Override
	public void formataView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		List<IDominio> recebido = null;
		List<Evento> evtRecebidos = null;
		String msgErro = "";
		
		if(resultado != null) {
			msgErro = resultado.getMensagem();
			
			recebido = resultado.getEntidades();
			evtRecebidos = (List<Evento>) (Object) recebido;
		}
		
		if(msgErro != null && msgErro != "") {
			request.setAttribute("mensagem", msgErro);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		} else {
		
			if(recebido == null || recebido.size() <= 0) {
				request.setAttribute("erro", "Não há eventos");
				request.getRequestDispatcher("listar-eventos.jsp").forward(request, response);			
			} else if(recebido.size() > 1) {
				request.setAttribute("resultado", evtRecebidos);
				request.getRequestDispatcher("listar-eventos.jsp").forward(request, response);
			} else {
				String editavel = request.getParameter("editar");
				
				System.out.println("EDITAVEL: " + editavel + " ID: " + request.getParameter("evt-id"));
				Evento evento = (Evento) recebido.get(0);
				request.setAttribute("resultado", evento);
				if(editavel != "" && editavel != null) {
					if(editavel.equals("false"))
						request.getRequestDispatcher("consulta-evento.jsp").forward(request, response);
					else
						request.getRequestDispatcher("atualiza-evento.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("sucesso.jsp").forward(request, response);
				}
			}
		
		} // caso não tenha mensagem de erro
		
	}	// final do método
	

}
