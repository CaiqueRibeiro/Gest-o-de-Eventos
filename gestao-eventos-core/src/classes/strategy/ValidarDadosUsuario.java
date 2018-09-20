package classes.strategy;

import dominio.participantes.Usuario;
import classes.core.IStrategy;
import dominio.evento.IDominio;


public class ValidarDadosUsuario implements IStrategy {
	
	private String msg;
	
	public String processar(IDominio entidade) {
		
		Usuario usuario = (Usuario) entidade;
		
		if(usuario.getEmail() == null || usuario.getEmail() == "") {
			this.msg = "Informe o email.";
			
			return this.msg;
		} else if(usuario.getSenha() == null || usuario.getSenha() == "") {
			this.msg = "Informe a senha.";
			
			return this.msg;			
		}
		
		return null;
	}

}
