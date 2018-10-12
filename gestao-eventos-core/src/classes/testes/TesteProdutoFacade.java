package classes.testes;

import java.sql.SQLException;
import java.util.List;

import classes.core.DAO.ProdutoDAO;
import classes.facade.Facade;
import classes.util.Resultado;
import dominio.produto.Produto;

public class TesteProdutoFacade {
	
	public static void main(String[] args) throws SQLException {
		
		Produto p1 = new Produto();
		
		Facade fachada = new Facade();
		Resultado resultado = fachada.consultar(p1);
		List<Produto> produtos = (List<Produto>) (Object) resultado.getEntidades();
		
		for (Produto produto : produtos) {
			
			System.out.println(produto.getNome());
			System.out.println(produto.isPerecivel());
			System.out.println(produto.getDtCadastro().toString());
			
		}
	}

}
