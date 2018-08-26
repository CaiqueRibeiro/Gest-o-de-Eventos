package classes.core.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dominio.endereco.Endereco;
import dominio.evento.IDominio;

public class EnderecoDAO extends AbsDAO {

	@Override
	public void salvar(IDominio entidade) throws SQLException {

		conectar();
		PreparedStatement ps = null;
		
		// Converte a entidade genérica em rateio
		Endereco endereco = (Endereco) entidade;
		
		try {
			
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder(); // variável para concatenar as Strings
			// inicia a declaração da query
			sql.append("INSERT INTO enderecos (logradouro, rua, numero, bairro, cep, cidade, estado)");
			sql.append(" VALUES(?,?,?,?,?,?,?)");
			
			ps = conexao.prepareStatement(sql.toString());
			
			// insere os objetos na query:
			ps.setString(1, endereco.getLogradouro());
			ps.setString(2, endereco.getRua());
			ps.setString(3, endereco.getNumero());
			ps.setString(4, endereco.getBairro());
			ps.setString(5, endereco.getCEP());
			ps.setString(6, endereco.getCidade());
			ps.setString(7, endereco.getEstado());
			
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(IDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		
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

}
