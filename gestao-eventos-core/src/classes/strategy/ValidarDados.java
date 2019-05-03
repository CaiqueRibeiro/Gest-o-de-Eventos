package classes.strategy;

import classes.core.IStrategy;
import dominio.evento.Evento;
import dominio.evento.IDominio;

public class ValidarDados implements IStrategy{
	
	private String msg;

	@Override
	public String processar(IDominio entidade) {
		
		Evento evento = (Evento) entidade;
		
		if(evento.getProdutos() != null) {
			return null;
		} else {
		
			if(evento.getNome() == null || evento.getNome() == "") {
				this.msg = "Não existe nome!";
				
				return this.msg;
			}
			
			return null;
		}
		
	}

}
