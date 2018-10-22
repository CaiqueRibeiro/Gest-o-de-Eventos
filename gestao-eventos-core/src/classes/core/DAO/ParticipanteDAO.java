package classes.core.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import dominio.endereco.Endereco;
import dominio.evento.IDominio;
import dominio.participantes.Participante;

public class ParticipanteDAO extends AbsDAO {

	@Override
	public void salvar(IDominio entidade) throws SQLException {
		conectar();
		PreparedStatement ps = null;
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		
		// Converte a entidade genérica em evento
		Participante participante = (Participante) entidade;
		
		try {
			
			enderecoDAO.salvar(participante.getEndereco());
			participante.getEndereco().setId(enderecoDAO.consultar());
			
			
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder(); // variável para concatenar as Strings
			// inicia a declaração da query
			sql.append("INSERT INTO participantes (nome, dt_nascimento, genero, cpf, telefone, email, end_id)");
			sql.append(" VALUES(?,?,?,?,?,?,?)");
			
			ps = conexao.prepareStatement(sql.toString());
			
			// insere os objetos na query:
			ps.setString(1, participante.getNome());
			// converte a data
			Timestamp time = new Timestamp(participante.getDtNascimento().getTime());
			ps.setTimestamp(2, time);
			ps.setInt(3, participante.getGenero());
			ps.setString(4, participante.getCpf());
			ps.setString(5, participante.getTelefone());
			ps.setString(6, participante.getEmail());
			ps.setInt(7, participante.getEndereco().getId());
			
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
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		
		// Converte a entidade genérica em evento
		Participante participante = (Participante) entidade;
		
		try {
			
			enderecoDAO.alterar(participante.getEndereco());			
			
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder(); // variável para concatenar as Strings
			// inicia a declaração da query
			sql.append("UPDATE participantes set nome=?, dt_nascimento=?, genero=?, cpf=?, telefone=?, email=?");
			sql.append(" where ptc_id=?");
			
			ps = conexao.prepareStatement(sql.toString());
			
			// insere os objetos na query:
			ps.setString(1, participante.getNome());
			// converte a data
			Timestamp time = new Timestamp(participante.getDtNascimento().getTime());
			ps.setTimestamp(2, time);
			ps.setInt(3, participante.getGenero());
			ps.setString(4, participante.getCpf());
			ps.setString(5, participante.getTelefone());
			ps.setString(6, participante.getEmail());
			ps.setInt(7, participante.getId());
			
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
		List<IDominio> participantes = new ArrayList<IDominio>();
		
		// Converte a entidade genérica em evento
		Participante participante = (Participante) entidade;
		
		try {
			
			int i = 1;
						
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder(); // variável para concatenar as Strings
			// inicia a declaração da query
			sql.append("SELECT * from participantes p left join enderecos end on end.end_id = p.end_id");
			sql.append(" where 1=1");
			
			if(participante.getId() != 0) {
				sql.append(" AND ptc_id=?");
			}
			if(participante.getNome() != null && participante.getNome() != "") {
				sql.append(" AND nome=?");
			}
			
			ps = conexao.prepareStatement(sql.toString());
			
			if(participante.getId() != 0) {
				ps.setInt(i, participante.getId());
				i++;
			}
			if(participante.getNome() != null && participante.getNome() != "") {
				ps.setString(i, participante.getNome());
			}
			
			ResultSet resultado = ps.executeQuery();
			
			while(resultado.next()) {
				
				Participante ptcBuscado = new Participante();
				Endereco enderecoBuscado = new Endereco();
				
				ptcBuscado.setId(resultado.getInt("ptc_id"));
				ptcBuscado.setNome(resultado.getString("nome"));
				ptcBuscado.setDtNascimento(resultado.getDate("dt_nascimento"));
				ptcBuscado.setCpf(resultado.getString("cpf"));
				ptcBuscado.setEmail(resultado.getString("email"));
				ptcBuscado.setGenero(resultado.getInt("genero"));
				ptcBuscado.setTelefone(resultado.getString("telefone"));
				
				enderecoBuscado.setId(resultado.getInt("end_id"));
				enderecoBuscado.setLogradouro(resultado.getString("logradouro"));
				enderecoBuscado.setBairro(resultado.getString("bairro"));
				enderecoBuscado.setRua(resultado.getString("rua"));
				enderecoBuscado.setCEP(resultado.getString("cep"));
				enderecoBuscado.setNumero(resultado.getString("numero"));
				enderecoBuscado.setCidade(resultado.getString("cidade"));
				enderecoBuscado.setEstado(resultado.getString("estado"));
				
				
				ptcBuscado.setEndereco(enderecoBuscado);
				
				participantes.add(ptcBuscado);
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
		
		return participantes;
	}

	@Override
	public void excluir(IDominio entidade) throws SQLException {
		
		conectar();
		PreparedStatement ps = null;
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		
		Participante participante = (Participante) entidade;
				
		try {
			
			enderecoDAO.excluir(participante.getEndereco());

			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder();
			
			sql.append("DELETE from participantes where ptc_id=?");
			
			ps = conexao.prepareStatement(sql.toString());
			
			// insere os objetos na query:
			ps.setInt(1, participante.getId());
			
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

}
