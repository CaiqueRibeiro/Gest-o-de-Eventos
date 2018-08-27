package classes.core.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import dominio.evento.Evento;
import dominio.evento.IDominio;
import dominio.evento.Rateio;

public class RateioDAO extends AbsDAO {

	@Override
	public void salvar(IDominio entidade) throws SQLException {

		conectar();
		PreparedStatement ps = null;
		
		// Converte a entidade genérica em rateio
		Rateio rateio = (Rateio) entidade;
		
		try {
			
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder(); // variável para concatenar as Strings
			// inicia a declaração da query
			sql.append("INSERT INTO rateios (dt_inicio, dt_final, valor_pagar)");
			sql.append(" VALUES(?,?,?)");
			
			ps = conexao.prepareStatement(sql.toString());
			
			// insere os objetos na query:
			// converte a data
			Timestamp inicio = new Timestamp(rateio.getInicioRateio().getTime());
			ps.setTimestamp(1, inicio);
			
			Timestamp fim = new Timestamp(rateio.getFimRateio().getTime());
			ps.setTimestamp(2, fim);
			
			ps.setDouble(3, rateio.getValorPagar());
			
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
	public void alterar(IDominio entidade) throws SQLException {
		conectar();
		PreparedStatement ps = null;
		Rateio rateio = (Rateio) entidade;
		
		try {
			
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder(); // variável para concatenar as Strings
			// inicia a declaração da query
			sql.append("UPDATE rateios set dt_inicio=?, dt_final=?");
			sql.append(" where rat_id=?");
			
			ps = conexao.prepareStatement(sql.toString());
			
			// insere os objetos na query:
			// converte a data
			Timestamp inicio = new Timestamp(rateio.getInicioRateio().getTime());
			ps.setTimestamp(1, inicio);
			
			Timestamp fim = new Timestamp(rateio.getFimRateio().getTime());
			ps.setTimestamp(2, fim);
			
			ps.setDouble(3, rateio.getId());
			
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
		// TODO Auto-generated method stub
		return null;
	}
	
	public int consultar() {
		
		int id = 0;
		
		PreparedStatement ps = null;
		
		try {
			
			conexao.setAutoCommit(false);
			StringBuilder sql = new StringBuilder();
			sql.append("select last_insert_id() as id");
			ps = conexao.prepareStatement(sql.toString());
			ResultSet resultado = ps.executeQuery();
			
			while(resultado.next()) {
				id = resultado.getInt("id");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return id;
	}

	@Override
	public void excluir(IDominio entidade) throws SQLException {
		
		conectar();
		PreparedStatement ps = null;
		// Converte a entidade genérica em rateio
		Rateio rateio = (Rateio) entidade;
		System.out.println("ID no RateioDAO: " + rateio.getId());
		try {
						
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder(); // variável para concatenar as Strings
			// inicia a declaração da query
			sql.append("DELETE from rateios where rat_id=?");
			
			ps = conexao.prepareStatement(sql.toString());
			
			// insere os objetos na query:
			ps.setInt(1, rateio.getId());
			
			ps.executeUpdate();
			conexao.commit();
			
			
		} catch (SQLException e) {
			try {
				conexao.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} // fim do try/catch INTERNO
			
			e.printStackTrace();
			
		}  finally {

	} // final FINALLY
		
	}

}
