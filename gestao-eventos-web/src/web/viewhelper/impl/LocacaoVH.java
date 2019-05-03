package web.viewhelper.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.util.Resultado;
import dominio.endereco.Ambiente;
import dominio.endereco.Locacao;
import dominio.evento.IDominio;
import web.viewhelper.IViewHelper;

public class LocacaoVH implements IViewHelper {

	@Override
	public IDominio getData(HttpServletRequest request) {
		
		String operacao = request.getParameter("operacao");
		Locacao locacao = new Locacao();
		
		if(operacao.equals("SALVAR") || operacao.equals("ATUALIZAR")) {
			locacao.setNome(request.getParameter("nome"));
			locacao.setAcustica(request.getParameter("acustica") == "1" ? true : false);
			
			Ambiente a = request.getParameter("aberto-fechado").equals("1") ? Ambiente.ABERTO : Ambiente.FECHADO;
			locacao.setAmbiente(a);
			
			System.out.println("RECEBIDO: " + request.getParameter("aberto-fechado"));
			System.out.println("AMBIENTE: " + locacao.getAmbiente());
			
			locacao.setVagasEstacionamento(Integer.parseInt(request.getParameter("vagas-estacionamento")));
			locacao.setValorAluguel(Double.parseDouble(request.getParameter("aluguel")));
			
			if(operacao.equals("ATUALIZAR")) {
				
				String locId = request.getParameter("loc-id");
								
				if(locId != null && locId != "") {
					locacao.setId(Integer.parseInt(locId));
				}
				
			}
		} else if(operacao.equals("CONSULTAR") || operacao.equals("EXCLUIR")) {

			String locId = request.getParameter("loc-id");
			
			if(locId != null && locId != "") {
				locacao.setId(Integer.parseInt(locId));
			}
			
		}
		
		return locacao;
	}

	@Override
	public void formataView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		List<IDominio> recebido = null;
		List<Locacao> locRecebidos = null;
		String msgErro = "";
		
		if(resultado != null) {
			msgErro = resultado.getMensagem();
			
			recebido = resultado.getEntidades();
			locRecebidos = (List<Locacao>) (Object) recebido;
		}
		
		if(msgErro != null && msgErro != "") {
			request.setAttribute("mensagem", msgErro);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		} else {
		
			if(recebido == null || recebido.size() <= 0) {
				request.setAttribute("erro", "Não há locacões");
				request.getRequestDispatcher("lista-locacoes.jsp").forward(request, response);			
			} else if(recebido.size() > 1) {
				
				request.getSession().setAttribute("listaLocacoes", resultado);
				request.setAttribute("resultado", locRecebidos);
				request.getRequestDispatcher("lista-locacoes.jsp").forward(request, response);
				
			} else {
				
				Locacao locacao = (Locacao) recebido.get(0);
				request.setAttribute("resultado", locacao);
				
				request.getRequestDispatcher("alterar-locacao.jsp").forward(request, response);
				
				}
			}
		
		} // caso não tenha mensagem de erro

}
