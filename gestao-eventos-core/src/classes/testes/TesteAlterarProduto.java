package classes.testes;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import classes.facade.Facade;
import dominio.produto.Fornecedor;
import dominio.produto.Produto;

public class TesteAlterarProduto {
	
	public static void main(String[] args) throws SQLException {
		
		Produto p1 = new Produto();
		p1.setId(6);
		p1.setNome("Maionese - Hellmanns");
		p1.setDescricao("Maionese em pote Hellmanns");
		p1.setDtCadastro(new Date());
		p1.setPreco(4.60);
		
		p1.setPerecivel(false);
		
		/*ProdutoDAO dao = new ProdutoDAO();
		dao.alterar(p1);*/
		Facade fachada = new Facade();
		fachada.alterar(p1);

	}

}
