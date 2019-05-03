package web.viewhelper.impl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.util.Resultado;
import dominio.evento.IDominio;
import dominio.produto.Fornecedor;
import dominio.produto.ItemProduto;
import dominio.produto.Produto;
import web.viewhelper.IViewHelper;

public class ItemProdutoVH implements IViewHelper {

	@Override
	public IDominio getData(HttpServletRequest request) {
		
		String operacao = request.getParameter("operacao");
		ItemProduto item = new ItemProduto();
		item.setProduto(new Produto());
		item.setFornecedor(new Fornecedor());
		
		if(operacao.equals("SALVAR") || operacao.equals("ATUALIZAR")) {
			
			int produtoId = Integer.parseInt(request.getParameter("pdt-id"));
			int fornecedorId = Integer.parseInt(request.getParameter("fnc-id"));
			double preco = Double.parseDouble(request.getParameter("preco"));
			double quantidade = Double.parseDouble(request.getParameter("quantidade"));
			
			item.getProduto().setId(produtoId);
			item.getFornecedor().setId(fornecedorId);
			item.setPreco(preco);
			item.setQuantidade(quantidade);
			
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
			try {
				
				item.setDtCadastro(new Date());
				String dtValidade = request.getParameter("dt-validade");
				
				if(dtValidade != null && dtValidade != "")
					item.setDtValidade(dt.parse(request.getParameter("dt-validade")));
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // fim da formatação de datas
			
		}
		
		if(operacao.equals("CONSULTAR") || operacao.equals("EXCLUIR")) {
			String pdt_id = request.getParameter("pdt-id");
			String fnc_id = request.getParameter("fnc-id");
			
			if(pdt_id != null && pdt_id != "") {
				item.getProduto().setId(Integer.parseInt(pdt_id));
			}
			
			if(pdt_id != null && pdt_id != "") {
				item.getFornecedor().setId(Integer.parseInt(fnc_id));
			}
		}
		
		return item;
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
			
			String estoqueEvento = request.getParameter("estoque-evento");
			
			if(estoqueEvento.equals("true")) {
				
				if(recebido == null || recebido.size() <= 0) {
					request.setAttribute("resultado", null);
					request.getRequestDispatcher("../evento/estoque-para-evento.jsp").forward(request, response);	
				} else {					
					request.setAttribute("resultado", pdtRecebidos);
					request.getRequestDispatcher("../evento/estoque-para-evento.jsp").forward(request, response);					
				}
				
			} else {
		
				if(recebido == null || recebido.size() <= 0) {
					request.setAttribute("resultado", null);
					request.getRequestDispatcher("estoque.jsp").forward(request, response);			
				} else if(recebido.size() > 1) {
					request.setAttribute("resultado", pdtRecebidos);
					request.getRequestDispatcher("estoque.jsp").forward(request, response);
				} else {				
					ItemProduto item = (ItemProduto) recebido.get(0);
					request.setAttribute("resultado", item);
					if(operacao.equals("ATUALIZAR") || operacao.equals("SALVAR")) {
						request.getRequestDispatcher("sucesso.jsp").forward(request, response);	
					} else if (operacao.equals("EXCLUIR")) {
						response.sendRedirect("consultar?operacao=CONSULTAR&editar=false");					
					} else {
						request.getRequestDispatcher("entrada-estoque.jsp").forward(request, response);
					}
				}
			}
		
		} // caso não tenha mensagem de erro
		
	}

}
