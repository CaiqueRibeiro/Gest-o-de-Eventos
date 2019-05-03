package classes.strategy;

import java.sql.SQLException;
import java.util.List;

import classes.core.IStrategy;
import classes.core.DAO.EventoDAO;
import dominio.evento.Evento;
import dominio.evento.IDominio;

public class ValidarExistenciaEvento implements IStrategy {
	
	private String msg;

	@Override
	public String processar(IDominio entidade) {
		
		Evento evento = (Evento) entidade;
		
		EventoDAO eDAO = new EventoDAO();
		
		try {
			
			List<IDominio> eventos = eDAO.consultar(evento);
			System.out.println("Chegou na lista!!");
			if(eventos.size() > 0) {
				
				this.msg = "Evento já cadastrado!";		
				return this.msg;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
