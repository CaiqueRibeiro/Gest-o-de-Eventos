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
import dominio.evento.Rateio;
import dominio.evento.RateioProduto;
import dominio.participantes.Administrador;
import dominio.participantes.Participante;
import dominio.produto.ItemProduto;
import dominio.produto.Produto;
import web.viewhelper.IViewHelper;

public class RateioProdutoVH implements IViewHelper {

	@Override
	public IDominio getData(HttpServletRequest request) {
		
		String operacao = request.getParameter("operacao");
		List<ItemProduto> itens = new ArrayList<ItemProduto>();
		RateioProduto rateioProduto = new RateioProduto();
		
		if(operacao.equals("SALVAR")) {
			
			String produtos = request.getParameter("produtos");
			String quantidades = request.getParameter("quantidades");
			int idEvento = Integer.parseInt(request.getParameter("evt-id"));
			int idRateio = Integer.parseInt(request.getParameter("rat-id"));
			
			Evento evento = new Evento();
			evento.setId(idEvento);
			
			Rateio rateio = new Rateio();
			rateio.setId(idRateio);
			evento.setRateio(rateio);
			
			rateioProduto.setEvento(evento);
			
			String[] arrPrd = produtos.split(",");
			String[] arrQtd = quantidades.split(",");
			double[] dbQtd = new double[arrQtd.length];
			
			for(int i = 0; i < arrQtd.length; i++) {
				dbQtd[i] = Double.parseDouble(arrQtd[i]);
				ItemProduto item = new ItemProduto();
				Produto prd = new Produto();
				
				prd.setNome(arrPrd[i]);
				item.setProduto(prd);
				item.setQuantidade(dbQtd[i]);
				
				itens.add(item);
			}
			
			rateioProduto.setProdutos(itens);
			
		} else if (operacao.equals("CONSULTAR")) {
			
			int idEvento = Integer.parseInt(request.getParameter("evt-id"));
			int idRateio = Integer.parseInt(request.getParameter("rat-id"));
			
			Evento evento = new Evento();
			evento.setId(idEvento);
			
			Rateio rateio = new Rateio();
			rateio.setId(idRateio);
			evento.setRateio(rateio);
			
			rateioProduto.setEvento(evento);
			
		} else if(operacao.equals("ATUALIZAR")) {
			
			Administrador adm = (Administrador) request.getSession().getAttribute("usuarioLogado");
			
			Participante participante = adm.getParticipante();
			
			int idRateio = Integer.parseInt(request.getParameter("rat-id"));
			int idProduto = Integer.parseInt(request.getParameter("prd-id"));
			
			ItemProduto item = new ItemProduto();
			Produto produto = new Produto();
			produto.setId(idProduto);
			item.setProduto(produto);
			
			itens.add(item);
			
			rateioProduto.setProdutos(itens);
			rateioProduto.setParticipante(participante);
			
			Evento evento = new Evento();
			
			Rateio rateio = new Rateio();
			rateio.setId(idRateio);
			evento.setRateio(rateio);
			
			rateioProduto.setEvento(evento);
			
			
		}
		
		return rateioProduto;
	}

	@Override
	public void formataView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String operacao = request.getParameter("operacao");
		String uri = request.getRequestURI();
		
		List<IDominio> recebido = null;
		List<ItemProduto> itcRecebidos = null;
		String msgErro = "";
		
		if(resultado != null) {
			msgErro = resultado.getMensagem();
			
			recebido = resultado.getEntidades();
			itcRecebidos = (List<ItemProduto>) (Object) recebido;
		}
		
		if(msgErro != null && msgErro != "") {
			request.setAttribute("mensagem", msgErro);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		} else {
		
			if(recebido == null || recebido.size() <= 0) {
				request.setAttribute("erro", "Não há produtos para este rateio");
				request.getRequestDispatcher("sucesso.jsp").forward(request, response);			
			} else if(recebido.size() > 1) {
				
				request.setAttribute("resultado", itcRecebidos);
				request.getRequestDispatcher("produtos-para-evento.jsp").forward(request, response);
				
			} else {
				
				if(operacao.equals("SALVAR") || operacao.equals("ATUALIZAR")) {
					request.getRequestDispatcher("sucesso.jsp").forward(request, response);
				} else {
				
					RateioProduto item = (RateioProduto) recebido.get(0);
					request.setAttribute("resultado", item);
					request.getRequestDispatcher("produtos-para-evento.jsp").forward(request, response);
					
				}
				
			}
		}
		
	}

}
