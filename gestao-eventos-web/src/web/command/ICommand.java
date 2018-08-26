package web.command;

import classes.util.Resultado;
import dominio.evento.IDominio;

public interface ICommand {
	
	public Resultado execute(IDominio entidade);

}
