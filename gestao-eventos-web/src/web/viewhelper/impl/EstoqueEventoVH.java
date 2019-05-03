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
import dominio.produto.ItemProduto;
import dominio.produto.Produto;
import web.viewhelper.IViewHelper;

public class EstoqueEventoVH implements IViewHelper {

	@Override
	public IDominio getData(HttpServletRequest request) {
		
		System.out.println("ENTROU NO VH DE ESTOQUE");
		
		String operacao = request.getParameter("operacao");
		
		String produtos = request.getParameter("ids");
		String quantidades = request.getParameter("quantidades");
		int idEvento = 0;
		
		if(request.getParameter("evt-id") != null && request.getParameter("evt-id") != "") {
			idEvento = Integer.parseInt(request.getParameter("evt-id"));			
		} else {
			idEvento = Integer.parseInt(request.getParameter("evtid"));						
		}
		
		Evento evento = new Evento();
		evento.setId(idEvento);
		List<ItemProduto> lista = new ArrayList<ItemProduto>();
		System.out.println("OPERACAO: " + operacao);
		
		if(operacao.equals("SALVAR") || operacao.equals("ATUALIZAR") || operacao.equals("EXCLUIR")) {
			
			System.out.println("ENTROU NO IF");

			
			String[] arrPrd = produtos.split(",");
			String[] arrQtd = quantidades.split(",");
			int[] intIds = new int[arrPrd.length];
			double[] dbQtd = new double[arrQtd.length];
			
			for(int i = 0; i < arrQtd.length; i++) {
				intIds[i] = Integer.parseInt(arrPrd[i]);
				dbQtd[i] = Double.parseDouble(arrQtd[i]);
				ItemProduto item = new ItemProduto();
				Produto prd = new Produto();
				
				prd.setId(intIds[i]);
				item.setProduto(prd);
				item.setQuantidade(dbQtd[i]);
				
				lista.add(item);
			}
			
			evento.setProdutos(lista);
			
		} else if(operacao.equals("CONSULTAR")) {
			lista.add(new ItemProduto());
			evento.setProdutos(lista);
		}

		return evento;
	}

	@Override
	public void formataView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String operacao = request.getParameter("operacao");
		
		List<IDominio> recebido = null;
		List<ItemProduto> pdtRecebidos = null;
		String msgErro = "";
		
		if(resultado != null) {
			msgErro = resultado.getMensagem();
			
			recebido = resultado.getEntidades();
			pdtRecebidos = (List<ItemProduto>) (Object) recebido;
		}
		
		if(msgErro != null && msgErro != "") {
			request.setAttribute("mensagem", msgErro);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		} else {
		
				if(recebido == null || recebido.size() <= 0) {
					request.setAttribute("resultado", null);
					request.getRequestDispatcher("erro.jsp").forward(request, response);			
				} else {
					
					if(operacao.equals("CONSULTAR")) {
						request.setAttribute("resultado", pdtRecebidos);
						request.getRequestDispatcher("atualizar-estoque-evento.jsp").forward(request, response);						
					} else {
						request.setAttribute("resultado", pdtRecebidos);
						request.getRequestDispatcher("sucesso.jsp").forward(request, response);
					}
				}
			}
		
		} // caso não tenha mensagem de erro

}
