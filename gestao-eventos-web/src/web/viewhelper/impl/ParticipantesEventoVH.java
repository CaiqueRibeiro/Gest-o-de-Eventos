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
import dominio.participantes.Participante;
import dominio.viewmodels.ParticipanteEventoVM;
import web.viewhelper.IViewHelper;

public class ParticipantesEventoVH implements IViewHelper {

	@Override
	public IDominio getData(HttpServletRequest request) {
		
		String operacao = request.getParameter("operacao");
		ParticipanteEventoVM participantes = new ParticipanteEventoVM();
		
		String requestIds = request.getParameter("id");
		
		if(operacao.equals("SALVAR") || operacao.equals("ATUALIZAR") || operacao.equals("EXCLUIR")) {
				String[] strId = requestIds.split(",");
				int[] ids = new int[strId.length];
				int idEvento = Integer.parseInt(request.getParameter("evt-id"));
				
				Evento evento = new Evento();
				evento.setId(idEvento);
				
				participantes.setEvento(evento);
				
				ArrayList<Participante> listaParticipantes = new ArrayList<Participante>();
				
				for(int i = 0; i < strId.length; i++) {
					ids[i] = Integer.parseInt(strId[i]);
					Participante p = new Participante();
					p.setId(ids[i]);
					
					listaParticipantes.add(p);
				}
				
				participantes.setParticipantes(listaParticipantes);
				
		} else if(operacao.equals("CONSULTAR")) {
			int idEvento = Integer.parseInt(request.getParameter("evtid"));
			boolean listaIncluidos = request.getParameter("incluidos").equals("true") ? true : false;
			
			System.out.println("Incluidos: " + listaIncluidos);
			
			Evento evento = new Evento();
			evento.setId(idEvento);
			participantes.setEvento(evento);
			participantes.setIncluidos(listaIncluidos);
		}
		
		
		return participantes;
	}

	@Override
	public void formataView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String operacao = request.getParameter("operacao");
		String uri = request.getRequestURI();
		
		List<IDominio> recebido = null;
		List<Participante> ptcRecebidos = null;
		String msgErro = "";
		
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
				request.setAttribute("erro", "Não há participantes");
				request.getRequestDispatcher("sucesso.jsp").forward(request, response);			
			} else {
				
				if(operacao.equals("CONSULTAR")) {
					
					if(uri.equals("/gestao-eventos-web/evento/consultar-participantes")) {
						System.out.println("CONSULTAR PARTICIPANTES");
						request.setAttribute("resultado", ptcRecebidos);
						request.getRequestDispatcher("seleciona-participantes.jsp").forward(request, response);	
					} else {
						request.setAttribute("resultado", ptcRecebidos);
						request.getRequestDispatcher("participantes-evento.jsp").forward(request, response);
					}
				} else {
						request.getRequestDispatcher("sucesso.jsp").forward(request, response);
				}
			}
		
		} // caso não tenha mensagem de erro		
		
		
	} // final do método
	

}
