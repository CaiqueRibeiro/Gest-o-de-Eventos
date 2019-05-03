package web.viewhelper.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.util.Resultado;
import dominio.evento.Evento;
import dominio.evento.IDominio;
import dominio.evento.ListaEventosParticipante;
import dominio.participantes.Administrador;
import dominio.participantes.Participante;
import web.viewhelper.IViewHelper;

public class EventosParticipanteVH implements IViewHelper {

	@Override
	public IDominio getData(HttpServletRequest request) {
		
		String operacao = request.getParameter("operacao");
		
		Administrador adm = (Administrador) request.getSession().getAttribute("usuarioLogado");
		

		Participante participante = adm.getParticipante();
		ListaEventosParticipante lista = new ListaEventosParticipante();
		lista.setParticipante(participante);
		
		if(operacao.equals("ATUALIZAR")) {
			String acao = request.getParameter("acao");
			if(acao.equals("CONFIRMAR")) {
				participante.setSituacao("CONFIRMADO");
			} else if(acao.equals("REJEITAR")) {
				participante.setSituacao("REJEITADO");				
			}
			
			int evtId = Integer.parseInt(request.getParameter("evt-id"));
			System.out.println("ID EVENTO::::: " + evtId);
			Evento evento = new Evento();
			evento.setId(evtId);
			List<Evento> listaEventos = new ArrayList<Evento>();
			listaEventos.add(evento);
			
			lista.setEventos(listaEventos);			
		} else if(operacao.equals("CONSULTAR")) {
			
			String evtId = request.getParameter("evt-id");
			
			List<Evento> listaEventos = new ArrayList<Evento>();
			Evento evento = new Evento();
			
			if(evtId != null && evtId != "") {
				evento.setId(Integer.parseInt(evtId));			
			}
			
			listaEventos.add(evento);	
			lista.setEventos(listaEventos);
						
		}		
		
		return lista;
		
	}

	@Override
	public void formataView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		List<IDominio> recebido = null;
		List<Evento> evtRecebidos = null;
		String msgErro = "";
		String operacao = request.getParameter("operacao");
		
		if(resultado != null) {
			msgErro = resultado.getMensagem();
			
			recebido = resultado.getEntidades();
			evtRecebidos = (List<Evento>) (Object) recebido;
		}
		
		if(msgErro != null && msgErro != "") {
			request.setAttribute("mensagem", msgErro);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		} else if(recebido.size() > 1) {
		
				request.setAttribute("resultado", evtRecebidos);
				request.getRequestDispatcher("listar-eventos-participante.jsp").forward(request, response);
		
		} else {
			if(operacao.equals("ATUALIZAR")) {
				response.sendRedirect("sucesso.jsp");
					
			} else {
				
				if(recebido == null || recebido.size() <= 0) {
					request.setAttribute("erro", "Não há eventos");
					request.getRequestDispatcher("listar-eventos-participante.jsp").forward(request, response);			
				} else {
					Evento evento = (Evento) recebido.get(0);
					request.setAttribute("resultado", evento);
					request.getRequestDispatcher("evento-como-participante.jsp").forward(request, response);
				}
			}
		}
		
		
	}
	
	

}
