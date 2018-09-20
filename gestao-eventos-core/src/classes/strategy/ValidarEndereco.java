package classes.strategy;

import classes.core.IStrategy;
import dominio.evento.IDominio;
import dominio.participantes.Participante;

public class ValidarEndereco implements IStrategy {
	
	private String msg;

	@Override
	public String processar(IDominio entidade) {
		
		Participante participante = (Participante) entidade;
		
		if(participante.getEndereco().getLogradouro() == null || participante.getEndereco().getLogradouro() == "") {
			
			this.msg = "O logradouro não foi informado!";		
			return this.msg;
			
		} else if(participante.getEndereco().getRua() == null || participante.getEndereco().getRua() == "") {
			
			this.msg = "Informe a rua!";
			return this.msg;
			
		} else if (participante.getEndereco().getNumero() == null || participante.getEndereco().getNumero() == "") {
			
			this.msg = "Informe o número da residência!";
			return this.msg;
			
		} else if (participante.getEndereco().getCEP() == null || participante.getEndereco().getCEP() == "") {
			
			this.msg = "Informe o número da residência!";
			return this.msg;
			
		} else if(participante.getEndereco().getBairro() == null || participante.getEndereco().getBairro() == "") {
			
			this.msg = "Informe o bairro!";
			return this.msg;	
			
		} else if (participante.getEndereco().getCidade() == null || participante.getEndereco().getCidade() == "") {

			this.msg = "Informe a cidade!";
			return this.msg;
			
		} else if (participante.getEndereco().getEstado() == null || participante.getEndereco().getEstado() == "") {

			this.msg = "Informe o estado!";
			return this.msg;
			
		}
		
		return null;
	}

}
