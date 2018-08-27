package web.command.impl;

import classes.util.Resultado;
import dominio.evento.IDominio;
import web.command.AbsCommand;

public class AlterarCommand extends AbsCommand {

	@Override
	public Resultado execute(IDominio entidade) {
		
		return fachada.alterar(entidade);
		
	}

}
