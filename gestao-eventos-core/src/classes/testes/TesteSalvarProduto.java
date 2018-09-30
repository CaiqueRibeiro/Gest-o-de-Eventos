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
		p1.setNome("Cerveja Heineken 600ml");
		p1.setDescricao("Cerveja Lager Heineken 600ml - garrafa");
		p1.setDtCadastro(new Date());
		p1.setPreco(6.28);
		
		SimpleDateFormat validade = new SimpleDateFormat("yyyy-MM-dd");
		try {
			p1.setValidade(validade.parse("2018-10-11"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Fornecedor f1 = new Fornecedor();
		f1.setId(1);
		p1.setFornecedor(f1);
		p1.setPerecivel(true);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.salvar(p1);

	}

}
