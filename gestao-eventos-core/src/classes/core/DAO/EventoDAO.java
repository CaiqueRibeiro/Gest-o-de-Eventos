package classes.core.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import dominio.endereco.Endereco;
import dominio.endereco.Locacao;
import dominio.evento.Evento;
import dominio.evento.IDominio;
import dominio.evento.Rateio;

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
			sql.append("INSERT INTO eventos (nome, data, hora, max_pessoas, situacao, cat_id, end_id, user_id, loc_id, rat_id, pct_lucro)");
			sql.append(" VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			
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
			if(evento.getEntrada() == -1)
				ps.setDouble(11, evento.getLucro());
			else
				ps.setDouble(11, evento.getEntrada());
			
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
		
		conectar();
		PreparedStatement ps = null;
		RateioDAO rateioDAO = new RateioDAO();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		
		// Converte a entidade genérica em evento
		Evento evento = (Evento) entidade;
		
		try {
			
			enderecoDAO.alterar(evento.getEndereco());
			//evento.getEndereco().setId(enderecoDAO.consultar());
			
			rateioDAO.alterar(evento.getRateio());
			
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder(); // variável para concatenar as Strings
			// inicia a declaração da query
			sql.append("UPDATE eventos set nome=?, data=?, hora=?, max_pessoas=?, situacao=?, cat_id=?, end_id=?, user_id=?, loc_id=?, pct_lucro=?");
			sql.append(" where evt_id=?");
			
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
			if(evento.getEntrada() == -1)
				ps.setDouble(10, evento.getLucro());
			else
				ps.setDouble(10, evento.getEntrada());
			
			ps.setInt(11, evento.getId());
			
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
		
		
	} // final ALTERAR

	@Override
	public List<IDominio> consultar(IDominio entidade) throws SQLException{
		
		conectar();
		PreparedStatement ps = null;
		RateioDAO rateioDAO = new RateioDAO();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		List<IDominio> eventos = new ArrayList<IDominio>();
		
		// Converte a entidade genérica em evento
		Evento evento = (Evento) entidade;
		
		try {
						
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder(); // variável para concatenar as Strings
			// inicia a declaração da query
			sql.append("SELECT * from eventos ev left join enderecos end on end.end_id = ev.end_id left join categorias c");
			sql.append(" on c.cat_id = ev.cat_id left join rateios r on r.rat_id = ev.rat_id left join locacoes l on l. loc_id = ev.loc_id where 1=1");
			
			if(evento.getId() != 0) {
				sql.append(" AND evt_id=?");
			}
			if(evento.getNome() != null && evento.getNome() != "") {
				sql.append(" AND nome=?");
			}
			
			ps = conexao.prepareStatement(sql.toString());
			
			if(evento.getId() != 0) {
				ps.setInt(1, evento.getId());
			}
			
			if(evento.getNome() != null && evento.getNome() != "") {
				ps.setString(2, evento.getNome());
			}
			
			System.out.println(ps.toString());
			
			ResultSet resultado = ps.executeQuery();
			
			while(resultado.next()) {
				
				Evento eventoBuscado = new Evento();
				Endereco enderecoBuscado = new Endereco();
				Rateio rateioBuscado = new Rateio();
				Locacao locacaoBuscada = new Locacao();
				
				eventoBuscado.setId(resultado.getInt("evt_id"));
				eventoBuscado.setNome(resultado.getString("nome"));
				eventoBuscado.setQdtMaximaPessoas(resultado.getInt("max_pessoas"));
				eventoBuscado.setData(resultado.getDate("data"));
				eventoBuscado.setHora(resultado.getString("hora"));
				eventoBuscado.setSituacao(resultado.getString("situacao"));
				eventoBuscado.setCategoria(resultado.getInt("c.cat_id"));
				eventoBuscado.setCatNome(resultado.getString("cat_nome"));
				if(eventoBuscado.getCatNome().equals("Show"))
					eventoBuscado.setEntrada(resultado.getDouble("pct_lucro"));
				else
					eventoBuscado.setLucro(resultado.getDouble("pct_lucro") * 100);
				
				enderecoBuscado.setId(resultado.getInt("end_id"));
				enderecoBuscado.setLogradouro(resultado.getString("logradouro"));
				enderecoBuscado.setBairro(resultado.getString("bairro"));
				enderecoBuscado.setRua(resultado.getString("rua"));
				enderecoBuscado.setCEP(resultado.getString("cep"));
				enderecoBuscado.setNumero(resultado.getString("numero"));
				enderecoBuscado.setCidade(resultado.getString("cidade"));
				enderecoBuscado.setEstado(resultado.getString("estado"));
				
				rateioBuscado.setId(resultado.getInt("rat_id"));
				rateioBuscado.setInicioRateio(resultado.getDate("dt_inicio"));
				rateioBuscado.setFimRateio(resultado.getDate("dt_final"));
				rateioBuscado.setValorPagar(resultado.getDouble("valor_pagar"));
				
				locacaoBuscada.setId(resultado.getInt("l.loc_id"));
				locacaoBuscada.setNome(resultado.getString("l.nome"));
				
				eventoBuscado.setEndereco(enderecoBuscado);
				eventoBuscado.setRateio(rateioBuscado);
				eventoBuscado.setLocacao(locacaoBuscada);
				
				eventos.add(eventoBuscado);
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
		
	return eventos;
		
	} // final CONSULTAR

	@Override
	public void excluir(IDominio entidade) throws SQLException {
		
		conectar();
		PreparedStatement ps = null;
		RateioDAO rateioDAO = new RateioDAO();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		
		// Converte a entidade genérica em evento
		Evento evento = (Evento) entidade;
		
		try {
					
			rateioDAO.excluir(evento.getRateio());
			
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder(); // variável para concatenar as Strings
			// inicia a declaração da query
			sql.append("DELETE from eventos where evt_id=?;");
			
			ps = conexao.prepareStatement(sql.toString());
			
			// insere os objetos na query:
			ps.setInt(1, evento.getId());
			
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
		
	} // final EXCLUIR

} // final da classe
