package classes.testes;

import java.sql.SQLException;
import java.util.List;

import classes.core.DAO.ProdutoDAO;
import dominio.produto.Produto;

public class TesteConsultaProduto {
	
	public static void main(String[] args) throws SQLException {
		
		Produto p1 = new Produto();
		p1.setId(3);
		
		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> produtos = (List<Produto>) (Object) dao.consultar(p1);
		
		for (Produto produto : produtos) {
			
			System.out.println(produto.getNome());
			System.out.println(produto.isPerecivel());
			System.out.println(produto.getDtCadastro().toString());
			
		}
	}

}
