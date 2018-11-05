package web.viewhelper.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.util.Resultado;
import dominio.evento.IDominio;
import dominio.produto.Produto;
import dominio.relatorios.Relatorio;
import dominio.relatorios.TipoRelatorio;
import web.viewhelper.IViewHelper;

public class RelatoriosVH implements IViewHelper {

	@Override
	public IDominio getData(HttpServletRequest request) {
		
		Relatorio relatorio = null;
		
		String tipoRelatorio = request.getParameter("tipo");
		
		if(tipoRelatorio.equals("EVENTO")) {
			relatorio = new Relatorio(TipoRelatorio.EVENTO);
		} else if(tipoRelatorio.equals("PARTICIPANTE")) {
			relatorio = new Relatorio(TipoRelatorio.PARTICIPANTE);
		} else if (tipoRelatorio.equals("PRODUTO")) {
			relatorio = new Relatorio(TipoRelatorio.PRODUTO);
		} else {
			relatorio = new Relatorio(TipoRelatorio.LOCACAO);
		}
		
		return relatorio;
	}

	@Override
	public void formataView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		List<IDominio> recebido = null;
		List<Relatorio> relRecebidos = null;
		String msgErro = "";
		
		if(resultado != null) {
			msgErro = resultado.getMensagem();
			
			recebido = resultado.getEntidades();
			relRecebidos = (List<Relatorio>) (Object) recebido;
		}
		
		if(msgErro != null && msgErro != "") {
			request.setAttribute("mensagem", msgErro);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		} else {
		
			if(recebido == null || recebido.size() <= 0) {
				request.setAttribute("erro", "Não há produtos");
				request.getRequestDispatcher("lista-produtos.jsp").forward(request, response);			
			} else {
				
				Relatorio rel = relRecebidos.get(0);
				
				request.setAttribute("resultado", rel);
				
				if (rel.getTpRelatorio() == TipoRelatorio.EVENTO)
					request.getRequestDispatcher("eventos.jsp").forward(request, response);
				else if (rel.getTpRelatorio() == TipoRelatorio.PARTICIPANTE)
					request.getRequestDispatcher("participantes.jsp").forward(request, response);					
				else if (rel.getTpRelatorio() == TipoRelatorio.PRODUTO)
					request.getRequestDispatcher("estoque.jsp").forward(request, response);
				else
					request.getRequestDispatcher("locacao.jsp").forward(request, response);

			}
			
		}
		
	}

}
