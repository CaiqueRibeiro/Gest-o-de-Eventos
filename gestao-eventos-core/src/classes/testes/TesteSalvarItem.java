package classes.testes;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import classes.core.DAO.ItemProdutoDAO;
import dominio.produto.Fornecedor;
import dominio.produto.ItemProduto;
import dominio.produto.Produto;

public class TesteSalvarItem {
	
	public static void main(String[] args) throws ParseException, SQLException {
		
		ItemProdutoDAO ipDAO = new ItemProdutoDAO();
		ItemProduto item = new ItemProduto();
		item.setProduto(new Produto());
		item.setFornecedor(new Fornecedor());
		
		item.getProduto().setId(2);
		item.getFornecedor().setId(2);
		
		item.setDtCadastro(new Date());
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		item.setDtValidade(dt.parse("2020-02-03"));
		
		item.setPreco(47.89);
		item.setQuantidade(20);
		
		ipDAO.salvar(item);
	}

}
