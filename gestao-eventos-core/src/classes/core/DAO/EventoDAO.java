package classes.core.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import dominio.evento.Evento;
import dominio.evento.IDominio;

public class EventoDAO extends AbsDAO {

	@Override
	public void salvar(IDominio entidade) throws SQLException {
				
		conectar();
		PreparedStatement ps = null;
		RateioDAO rateioDAO = new RateioDAO();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		
		// Converte a entidade genérica em evento
		Evento evento = (Evento) entidade;
		
		try {
			
			enderecoDAO.salvar(evento.getEndereco());
			evento.getEndereco().setId(enderecoDAO.consultar());
			
			rateioDAO.salvar(evento.getRateio());
			evento.getRateio().setId(rateioDAO.consultar());
			
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder(); // variável para concatenar as Strings
			// inicia a declaração da query
			sql.append("INSERT INTO eventos (nome, data, hora, max_pessoas, situacao, cat_id, end_id, user_id, loc_id, rat_id)");
			sql.append(" VALUES(?,?,?,?,?,?,?,?,?,?)");
			
			ps = conexao.prepareStatement(sql.toString());
			
			// insere os objetos na query:
			ps.setString(1, evento.getNome());
			// converte a data
			Timestamp time = new Timestamp(evento.getData().getTime());
			ps.setTimestamp(2, time);
			ps.setString(3, evento.getHora());
			ps.setInt(4, evento.getQdtMaximaPessoas());
			ps.setString(5, evento.getSituacao());
			ps.setInt(6, evento.getCategoria());
			ps.setInt(7, evento.getEndereco().getId());
			ps.setInt(8, evento.getAdministrador().getId());
			ps.setInt(9, evento.getLocacao().getId());
			ps.setInt(10, evento.getRateio().getId());
			
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
		
	} // final SALVAR

	@Override
	public void alterar(IDominio entidade) throws SQLException {
		
	} // final ALTERAR

	@Override
	public List<IDominio> consultar(IDominio entidade) throws SQLException {
		return null;
	} // final CONSULTAR

	@Override
	public void excluir(IDominio entidade) throws SQLException {
		
	} // final EXCLUIR

} // final da classe
