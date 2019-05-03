package classes.core.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.evento.Evento;
import dominio.evento.IDominio;
import dominio.evento.ListaEventosParticipante;
import dominio.evento.Rateio;
import dominio.participantes.Participante;

public class EventosParticipanteDAO extends AbsDAO {

	@Override
	public void salvar(IDominio entidade) throws SQLException {
		
	}

	@Override
	public void alterar(IDominio entidade) throws SQLException {
		
		conectar();
		PreparedStatement ps = null;
		
		ListaEventosParticipante lista = (ListaEventosParticipante) entidade;
		
		try {	
			
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder();
			
			sql.append("UPDATE participantes_evento SET pe_situacao=? WHERE pe_ptc_id=? AND pe_evt_id=?");
			
			ps = conexao.prepareStatement(sql.toString());
			
			ps.setString(1, lista.getParticipante().getSituacao());
			ps.setInt(2, lista.getParticipante().getId());
			ps.setInt(3, lista.getEventos().get(0).getId());
			
			System.out.println(sql.toString());
			
			ps.executeUpdate();
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
	public List<IDominio> consultar(IDominio entidade) throws SQLException {
		
		conectar();
		PreparedStatement ps = null;
		
		ListaEventosParticipante lista = (ListaEventosParticipante) entidade;
		List<IDominio> eventos = new ArrayList<IDominio>();
		
		try {
			
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder();
			sql.append("select * from eventos e left join participantes_evento pe on pe.pe_evt_id = e.evt_id WHERE 1=1 AND pe.pe_situacao != 'REJEITADO' AND pe.pe_ptc_id=?");
			
			if(lista.getEventos().get(0).getId() != 0) {
				sql.append(" AND pe.pe_evt_id = ?");
			}
			
			ps = conexao.prepareStatement(sql.toString());
			
			ps.setInt(1, lista.getParticipante().getId());
			
			if(lista.getEventos().get(0).getId() != 0) {
				ps.setInt(2, lista.getEventos().get(0).getId());
			}
			
			System.out.println(ps.toString());
			
			ResultSet resultado = ps.executeQuery();
			
			while(resultado.next()) {
				Evento evtProcurado = new Evento();
				Rateio ratProcurado = new Rateio();
				Participante pProcurado = new Participante();
				List<Participante> ptcEvento = new ArrayList<Participante>();
				
				pProcurado.setSituacao(resultado.getString("pe.pe_situacao"));
				ptcEvento.add(pProcurado);
				
				ratProcurado.setId(resultado.getInt("e.rat_id"));
				
				evtProcurado.setId(resultado.getInt("e.evt_id"));
				evtProcurado.setNome(resultado.getString("e.nome"));
				evtProcurado.setParticipantes(ptcEvento);
				evtProcurado.setRateio(ratProcurado);
				
				eventos.add(evtProcurado);
			}
			
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
		
		return eventos;
	}

	@Override
	public void excluir(IDominio entidade) throws SQLException {

		
	}

}
