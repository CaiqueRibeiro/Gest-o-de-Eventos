package classes.strategy;

import java.sql.SQLException;
import java.util.List;

import classes.core.IStrategy;
import classes.core.DAO.ParticipanteDAO;
import dominio.evento.IDominio;
import dominio.participantes.Participante;

public class ValidarExistencia implements IStrategy {
	
	private String msg;

	@Override
	public String processar(IDominio entidade) {
		
		Participante participante = (Participante) entidade;
		
		ParticipanteDAO pDAO = new ParticipanteDAO();
		
		try {
			
			List<IDominio> participantes = pDAO.consultar(participante);
			System.out.println("Chegou na lista!!");
			if(participantes.size() > 0) {
				
				this.msg = "Participante já cadastrado!";		
				return this.msg;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
