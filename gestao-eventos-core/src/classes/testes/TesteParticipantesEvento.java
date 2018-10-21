package classes.testes;

import java.sql.SQLException;

import classes.core.DAO.ParticipanteEventoDAO;
import dominio.viewmodels.ParticipanteEventoVM;

public class TesteParticipantesEvento {

	public static void main(String[] args) throws SQLException {
		ParticipanteEventoDAO dao = new ParticipanteEventoDAO();
		ParticipanteEventoVM vm = new ParticipanteEventoVM();
		
		vm.setIdEvento(30);
		
		dao.salvar(vm);

	}

}
