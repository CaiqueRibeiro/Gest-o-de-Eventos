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
import dominio.produto.Categoria;
import dominio.produto.Produto;
import web.viewhelper.IViewHelper;

public class ProdutoVH implements IViewHelper {

	@Override
	public IDominio getData(HttpServletRequest request) {
		
		String operacao = request.getParameter("operacao");
		Produto produto = new Produto();
		
		if(operacao.equals("SALVAR") || operacao.equals("ATUALIZAR")) {
			
			
			produto.setNome(request.getParameter("nome"));
			produto.setPerecivel(Boolean.parseBoolean(request.getParameter("perecivel")));
			produto.setDescricao(request.getParameter("descricao"));
			produto.setCategoria(new Categoria());
			String cat_id = request.getParameter("categoria");
			produto.getCategoria().setId(Integer.parseInt(cat_id));
			
			if(operacao.equals("ATUALIZAR")) {
				
				String pdt_id = request.getParameter("pdt-id");
				produto.setId(Integer.parseInt(pdt_id));	

			}
		}
		
		if(operacao.equals("CONSULTAR")) {
			String pdt_id = request.getParameter("pdt-id");
			
			if(pdt_id != null && pdt_id != "") {
				produto.setId(Integer.parseInt(pdt_id));
			}
		}
		
		if(operacao.equals("EXCLUIR")) {
			
			String pdt_id = request.getParameter("pdt-id");
			
				produto.setId(Integer.parseInt(pdt_id));
				System.out.println("ID no VH: " + produto.getId());
			
		}
		
		return produto;
	}

	@Override
	public void formataView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		List<IDominio> recebido = null;
		List<Produto> pdtRecebidos = null;
		String msgErro = "";
		
		if(resultado != null) {
			msgErro = resultado.getMensagem();
			
			recebido = resultado.getEntidades();
			pdtRecebidos = (List<Produto>) (Object) recebido;
		}
		
		if(msgErro != null && msgErro != "") {
			request.setAttribute("mensagem", msgErro);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		} else {
		
			if(recebido == null || recebido.size() <= 0) {
				request.setAttribute("erro", "Não há produtos");
				request.getRequestDispatcher("lista-produtos.jsp").forward(request, response);			
			} else if(recebido.size() > 1) {
				request.setAttribute("resultado", pdtRecebidos);
				request.getRequestDispatcher("lista-produtos.jsp").forward(request, response);
			} else {
				String editavel = request.getParameter("editar");
				System.out.println("Editável? " + editavel);
				
				Produto produto = (Produto) recebido.get(0);
				request.setAttribute("resultado", produto);
				if(editavel != "" && editavel != null) {
					if(editavel.equals("false"))
						request.getRequestDispatcher("consulta-produto.jsp").forward(request, response);
					else
						request.getRequestDispatcher("atualiza-produto.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("sucesso.jsp").forward(request, response);
				}
			}
		
		} // caso não tenha mensagem de erro
		
	}

}
