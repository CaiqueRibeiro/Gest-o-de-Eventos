package classes.strategy;

import java.sql.SQLException;
import java.util.List;

import classes.core.IStrategy;
import classes.core.DAO.ParticipanteEventoDAO;
import dominio.evento.IDominio;
import dominio.participantes.Participante;
import dominio.viewmodels.ParticipanteEventoVM;

public class ValidarExistenciaParticipanteEvento implements IStrategy {
	
	private String msg;

	@Override
	public String processar(IDominio entidade) {
		
		ParticipanteEventoVM participante = (ParticipanteEventoVM) entidade;
		participante.setIncluidos(true);
		ParticipanteEventoDAO dao = new ParticipanteEventoDAO();
		
		try {
			
			List<Participante> participantes = (List<Participante>) (Object) dao.consultar(participante);
			if(participantes.size() > 0) {
				
				for(Participante p : participantes) {
					
					for(Participante ptc : participante.getParticipantes()) {
							
							if(ptc.getId() == p.getId()) {
								this.msg = "Participante " + p.getNome() + " já cadastrado neste evento!";		
								return this.msg;
							}
					}				
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
