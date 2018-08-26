package classes.core;

import dominio.evento.IDominio;

public interface IStrategy {
	
	public String processar(IDominio entidade);

}
