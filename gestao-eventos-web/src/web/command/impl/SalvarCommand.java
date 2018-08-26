package web.command.impl;

import classes.util.Resultado;
import dominio.evento.IDominio;
import web.command.AbsCommand;

public class SalvarCommand extends AbsCommand {

	@Override
	public Resultado execute(IDominio entidade) {
		
		System.out.println("Classe no command: " + entidade.getClass().getName());
		
		return fachada.salvar(entidade);
		
	}

}
