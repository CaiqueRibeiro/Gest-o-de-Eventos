package classes.testes;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import classes.core.DAO.ProdutoDAO;
import dominio.produto.Fornecedor;
import dominio.produto.Produto;

public class TesteSalvarProduto {

	public static void main(String[] args) throws SQLException {
		
		Produto p1 = new Produto();
		p1.setNome("Maionese - Hellmanns");
		p1.setDescricao("Maionese em pote Hellmanns");
		p1.setDtCadastro(new Date());
		
		p1.setPerecivel(true);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.salvar(p1);

	}

}
