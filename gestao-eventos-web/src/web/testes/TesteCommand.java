package web.testes;

import java.util.List;

import classes.util.Resultado;
import dominio.produto.Produto;
import web.command.impl.ConsultarCommand;

public class TesteCommand {

	public static void main(String[] args) {
		ConsultarCommand command = new ConsultarCommand();
		Resultado rs = command.execute(new Produto());
		List<Produto> produtos = (List<Produto>) (Object) rs.getEntidades();
		
		for(Produto p : produtos) {
			System.out.println(p.getNome());
		}

	}

}
