package classes.testes;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import classes.facade.Facade;
import dominio.produto.Fornecedor;
import dominio.produto.Produto;

public class TesteSalvarFacade {
	
	public static void main(String[] args) throws SQLException {
		
		Produto p1 = new Produto();
		p1.setNome("Doce de leite");
		p1.setDescricao("Doce de leite que é doce e feito puramente de leite");
		p1.setDtCadastro(new Date());
		p1.setPreco(34.99);
		
		p1.setPerecivel(true);
		
		Facade fachada = new Facade();
		fachada.salvar(p1);

	}

}
