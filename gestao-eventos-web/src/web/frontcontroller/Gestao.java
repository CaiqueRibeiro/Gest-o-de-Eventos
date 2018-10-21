package web.frontcontroller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.util.Resultado;
import dominio.endereco.Locacao;
import dominio.evento.IDominio;
import dominio.produto.Fornecedor;
import dominio.produto.Produto;
import web.command.ICommand;
import web.command.impl.AlterarCommand;
import web.command.impl.ConsultarCommand;
import web.command.impl.ExcluirCommand;
import web.command.impl.SalvarCommand;
import web.viewhelper.IViewHelper;
import web.viewhelper.impl.EventoVH;
import web.viewhelper.impl.ItemProdutoVH;
import web.viewhelper.impl.ParticipanteVH;
import web.viewhelper.impl.ParticipantesEventoVH;
import web.viewhelper.impl.ProdutoVH;
import web.viewhelper.impl.UsuarioVH;

/**
 * Servlet implementation class Gestao
 */
@WebServlet("/Gestao")
public class Gestao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Map<String, ICommand> commands;
	private static Map<String, IViewHelper> vhs;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		
		ConsultarCommand command = new ConsultarCommand();
		Resultado rsProduto = command.execute(new Produto());
		config.getServletContext().setAttribute("listaProdutos", rsProduto);
		
		Resultado rsFornecedor = command.execute(new Fornecedor());
		config.getServletContext().setAttribute("listaFornecedores", rsFornecedor);
		
		Resultado rsLocacao = command.execute(new Locacao());
		config.getServletContext().setAttribute("listaLocacoes", rsLocacao);
		
	}
	
    public Gestao() {
    	
    	
    	commands = new HashMap<String, ICommand>();
    	
    	commands.put("SALVAR", new SalvarCommand());
    	commands.put("CONSULTAR", new ConsultarCommand());
    	commands.put("ATUALIZAR", new AlterarCommand());
    	commands.put("EXCLUIR", new ExcluirCommand());
    	
    	vhs = new HashMap<String, IViewHelper>();
    	vhs.put("/gestao-eventos-web/login", new UsuarioVH());
    	vhs.put("/gestao-eventos-web/cadastrar", new UsuarioVH());
    	
    	vhs.put("/gestao-eventos-web/evento/salvar", new EventoVH());
    	vhs.put("/gestao-eventos-web/evento/consultar", new EventoVH());
    	vhs.put("/gestao-eventos-web/evento/alterar", new EventoVH());
    	vhs.put("/gestao-eventos-web/evento/excluir", new EventoVH());
    	vhs.put("/gestao-eventos-web/evento/add-participante", new ParticipantesEventoVH());
    	vhs.put("/gestao-eventos-web/evento/consultar-participantes", new ParticipanteVH()); 
    	
    	vhs.put("/gestao-eventos-web/participantes/salvar", new ParticipanteVH());
    	vhs.put("/gestao-eventos-web/participantes/consultar", new ParticipanteVH());
    	vhs.put("/gestao-eventos-web/participantes/alterar", new ParticipanteVH());
    	vhs.put("/gestao-eventos-web/participantes/excluir", new ParticipanteVH());
    	
    	vhs.put("/gestao-eventos-web/produtos/salvar", new ProdutoVH());
    	vhs.put("/gestao-eventos-web/produtos/consultar", new ProdutoVH());
    	vhs.put("/gestao-eventos-web/produtos/alterar", new ProdutoVH());
    	vhs.put("/gestao-eventos-web/produtos/excluir", new ProdutoVH());
    	
    	vhs.put("/gestao-eventos-web/estoque/salvar", new ItemProdutoVH());
    	vhs.put("/gestao-eventos-web/estoque/consultar", new ItemProdutoVH());
    	vhs.put("/gestao-eventos-web/estoque/alterar", new ItemProdutoVH());
    	vhs.put("/gestao-eventos-web/estoque/excluir", new ItemProdutoVH());
   
    }


    protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {    	
    	
    	String uri = request.getRequestURI();
    	
    	String operacao = request.getParameter("operacao");
    			
		IViewHelper vh = vhs.get(uri);
		
		IDominio entidade =  vh.getData(request);
				
		ICommand command = commands.get(operacao);
				
		Resultado resultado = command.execute(entidade);
		
		vh.formataView(resultado, request, response);
    	
    }

}
