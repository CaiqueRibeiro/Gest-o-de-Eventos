package classes.core.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.evento.IDominio;
import dominio.participantes.Administrador;
import dominio.participantes.Participante;

public class UsuarioDAO extends AbsDAO {

	@Override
	public void salvar(IDominio entidade) throws SQLException {
		
		conectar();
		PreparedStatement ps = null;
		ParticipanteDAO pDAO = new ParticipanteDAO();
		
		Administrador usuario = (Administrador) entidade;
		
		try {
			
			pDAO.salvar(usuario.getParticipante());
			usuario.getParticipante().setId(pDAO.consultar());
			
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT into usuarios (email, senha, ptc_id) VALUES (?,?,?)");
			
			ps = conexao.prepareStatement(sql.toString());
			
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getSenha());
			ps.setInt(3, usuario.getParticipante().getId());
			
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IDominio> consultar(IDominio entidade) throws SQLException {
		
		conectar();
		PreparedStatement ps = null;
		
		Administrador usuario = (Administrador) entidade;
		List<IDominio> usuarios = new ArrayList<IDominio>();
				
		try {
			
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder(); // variável para concatenar as Strings
			// inicia a declaração da query
			sql.append("SELECT * from usuarios u left join participantes p  on p.ptc_id = u.ptc_id where u.email=? AND u.senha=?");
			
			ps = conexao.prepareStatement(sql.toString());
			
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getSenha());
			
			System.out.println(ps.toString());
			
			ResultSet resultado = ps.executeQuery();
			
			while(resultado.next()) {
				Administrador adm = new Administrador();
				adm.setEmail(resultado.getString("u.email"));
				adm.setSenha(resultado.getString("u.senha"));
				adm.setId(resultado.getInt("u.usr_id"));
				
				Participante p = new Participante();
				p.setId(resultado.getInt("p.ptc_id"));
				p.setNome(resultado.getString("p.nome"));
				p.setCpf(resultado.getString("p.cpf"));
				p.setTelefone(resultado.getString("p.telefone"));
				
				usuario.setParticipante(p);
				adm.setParticipante(p);
				
				System.out.println("PARTICIPANTE NO DAO: " + adm.getParticipante().getId());
				System.out.println("NOME DO PARTICIPANTE NO DAO: " + adm.getParticipante().getNome());
				
				usuarios.add(adm);
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
		
		return usuarios;
	}

	@Override
	public void excluir(IDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
