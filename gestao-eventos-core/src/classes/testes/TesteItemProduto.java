package classes.testes;

import java.sql.SQLException;
import java.util.List;

import classes.core.DAO.ItemProdutoDAO;
import dominio.produto.ItemProduto;
import dominio.produto.Produto;

public class TesteItemProduto {
	
	public static void main(String[] args) throws SQLException {
		
		ItemProduto itemProduto = new ItemProduto();
		ItemProdutoDAO dao = new ItemProdutoDAO();
		List<ItemProduto> produtos = (List<ItemProduto>) (Object) dao.consultar(itemProduto);
		
		for(ItemProduto pdt : produtos) {
			System.out.println("PRODUTO: " + pdt.getProduto().getNome());
			System.out.println("FORNECEDOR: " + pdt.getFornecedor().getNome());
			System.out.println("CATEGORIA: " + pdt.getProduto().getCategoria().getNome());
		}
		
	}

}
