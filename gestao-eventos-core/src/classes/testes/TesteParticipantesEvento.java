package classes.testes;

import java.sql.SQLException;

import classes.core.DAO.ParticipanteEventoDAO;
import dominio.evento.Evento;
import dominio.viewmodels.ParticipanteEventoVM;

public class TesteParticipantesEvento {

	public static void main(String[] args) throws SQLException {
		ParticipanteEventoDAO dao = new ParticipanteEventoDAO();
		ParticipanteEventoVM vm = new ParticipanteEventoVM();
		
		Evento evento = new Evento();
		evento.setId(30);
		vm.setEvento(evento);
		
		dao.salvar(vm);

	}

}
