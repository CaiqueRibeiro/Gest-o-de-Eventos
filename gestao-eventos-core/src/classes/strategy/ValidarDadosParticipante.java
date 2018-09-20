package classes.strategy;

import classes.core.IStrategy;
import dominio.evento.IDominio;
import dominio.participantes.Participante;

public class ValidarDadosParticipante implements IStrategy{
	
	private String msg;

	@Override
	public String processar(IDominio entidade) {
		
		Participante participante = (Participante) entidade;
		
		if(participante.getNome() == null || participante.getNome() == "") {
			
			this.msg = "Não existe nome de participante!";		
			return this.msg;
			
		} else if(participante.getCpf() == null || participante.getCpf() == "") {
			
			this.msg = "O CPF do participante deve ser informado!";			
			return this.msg;
			
		} else if(participante.getDtNascimento() == null) {
			
			this.msg = "Informe a data de nascimento do participante!";			
			return this.msg;	
			
		} else if(participante.getGenero() == 0) {
			
			this.msg = "Selecione o gênero to participante";			
			return this.msg;
			
		} else if(participante.getTelefone() == null || participante.getTelefone() == "") {
			
			this.msg = "Informe o telefone do participante!";			
			return this.msg;	
			
		}
		
		return null;
	}

}