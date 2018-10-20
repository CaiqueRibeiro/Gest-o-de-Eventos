package classes.core.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.endereco.Ambiente;
import dominio.endereco.Locacao;
import dominio.evento.IDominio;

public class LocacaoDAO extends AbsDAO {

	@Override
	public void salvar(IDominio entidade) throws SQLException {

		conectar();
		PreparedStatement ps = null;
		
		Locacao locacao = (Locacao) entidade;
		
		try {
			
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder(); // variável para concatenar as Strings
			
			sql.append("INSERT into locacoes (nome, ambiente, acustica, estacionamento, vagas_estacionamento, vagas_usadas, valor_aluguel)");
			sql.append(" values (?, ?, ?, ?, ?, ?, ?)");
						
			ps = conexao.prepareStatement(sql.toString());
			
			ps.setString(1, locacao.getNome());
			ps.setString(2, locacao.getAmbiente().name());
			ps.setBoolean(3, locacao.isAcustica());
			ps.setBoolean(4, locacao.isPossuiEstacionamento());
			ps.setInt(5, locacao.getVagasEstacionamento());
			ps.setInt(6, locacao.getVagasEstacionamentoUsadas());
			ps.setDouble(7, locacao.getValorAluguel());
			
			System.out.println(ps.toString());
			
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
		List<IDominio> locacoes = new ArrayList<IDominio>();
		
		Locacao locacao = (Locacao) entidade;
		
		try {
			
			int i = 1;
			
			conexao.setAutoCommit(false);

			StringBuilder sql = new StringBuilder();
			
			sql.append("SELECT * from locacoes WHERE 1=1");
			
			if(locacao.getId() != 0) {
				sql.append(" AND loc_id = ?");
			}
			
			if(locacao.getNome() != null && locacao.getNome() != "") {
				sql.append(" AND nome = ?");
			}
			
			ps = conexao.prepareStatement(sql.toString());
			
			if(locacao.getId() != 0) {
				ps.setInt(i, locacao.getId());
				i++;
			}
			
			if(locacao.getNome() != null && locacao.getNome() != "") {
				ps.setString(i, locacao.getNome());
				i++;
			}
			
			System.out.println(ps.toString());
			
			ResultSet resultado = ps.executeQuery();
			
			while(resultado.next()) {
				
				Locacao locBuscado = new Locacao();
				
				locBuscado.setId(resultado.getInt("loc_id"));
				locBuscado.setNome(resultado.getString("nome"));
				locBuscado.setAcustica(resultado.getInt("acustica") == 1 ? true : false);
				locBuscado.setPossuiEstacionamento(resultado.getInt("acustica") == 1 ? true : false);
				locBuscado.setVagasEstacionamento(resultado.getInt("vagas_estacionamento"));
				locBuscado.setVagasEstacionamentoUsadas(resultado.getInt("vagas_usadas"));
				locBuscado.setValorAluguel(resultado.getDouble("valor_aluguel"));
				locBuscado.setAmbiente(resultado.getString("ambiente").equals("ABERTO") ? Ambiente.ABERTO : Ambiente.FECHADO);
				
				locacoes.add(locBuscado);
			}
			
		} catch (SQLException e) {
			try {
				conexao.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} // fim do try/catch INTERNO
			
			e.printStackTrace();
			
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // final FINALLY
		
		return locacoes;
	}

	@Override
	public void excluir(IDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
