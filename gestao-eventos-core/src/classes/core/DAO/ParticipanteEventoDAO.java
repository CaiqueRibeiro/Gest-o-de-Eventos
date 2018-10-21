package classes.core.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.evento.IDominio;
import dominio.participantes.Participante;
import dominio.viewmodels.ParticipanteEventoVM;

public class ParticipanteEventoDAO extends AbsDAO {

	@Override
	public void salvar(IDominio entidade) throws SQLException {
		
		conectar();
		PreparedStatement ps = null;
		
		ParticipanteEventoVM participantesVM = (ParticipanteEventoVM) entidade;
		List<Participante> participantes = null;
		
		try {
			
			participantes = (List<Participante>) (Object) this.consultarId();
			
			
			conexao.setAutoCommit(false);
			
			for(Participante p : participantes) {
				StringBuilder sql = new StringBuilder();
				sql.append("INSERT into participantes_evento (pe_ptc_id, pe_evt_id) values (?,?);");
				ps = conexao.prepareStatement(sql.toString());
				ps.setInt(1, p.getId());
				ps.setInt(2, participantesVM.getIdEvento());

				ps.executeUpdate();
				System.out.println(ps.toString());
			}	
			
			conexao.commit();
			
		} catch (SQLException e) {
			try {
				conexao.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} // fim do try/catch INTERNO
			
			e.printStackTrace();
			
		} /* fim do try/catch */ finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // final FINALLY	
		
	}

	@Override
	public void alterar(IDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IDominio> consultar(IDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(IDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	public List<IDominio> consultarId() {
		
		List<IDominio> ids = new ArrayList<IDominio>();
		PreparedStatement ps = null;
		
		try {
			
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder();
			
			sql.append("SELECT ptc_id from participantes WHERE 1=1");
			
			ps = conexao.prepareStatement(sql.toString());
			
			ResultSet resultado = ps.executeQuery();
			
			while(resultado.next()) {
				Participante p = new Participante();
				p.setId(resultado.getInt("ptc_id"));
				
				ids.add(p);
			}
			
			conexao.commit();
		
		} catch (SQLException e) {
			try {
				conexao.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} // fim do try/catch INTERNO
			
			e.printStackTrace();
			
		} /* fim do try/catch */ finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // final FINALLY	
		
		return ids;
		
	}

}
