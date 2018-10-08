package classes.strategy;

import classes.core.IStrategy;
import dominio.evento.IDominio;
import dominio.produto.Produto;

public class ValidarDadosProduto implements IStrategy {
	
	private String msg;

	@Override
	public String processar(IDominio entidade) {
		
		Produto produto = (Produto) entidade;
		
		if(produto.getNome() == null || produto.getNome() == "") {
			
			this.msg = "Não existe nome de participante!";		
			return this.msg;
			
		}  else if(produto.getDescricao() == null || produto.getDescricao() == "") {
			
			this.msg = "Insira a descrição do produto!";
			return this.msg;
			
		} else if(produto.getCategoria().getId() <= 0) {
			this.msg = "Não foi informada categoria";
			return this.msg;
		}
		
		return null;
		
		
	}

}
