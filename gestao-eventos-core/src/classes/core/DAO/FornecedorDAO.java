package classes.core.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.evento.IDominio;
import dominio.produto.Fornecedor;

public class FornecedorDAO extends AbsDAO {

	@Override
	public void salvar(IDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(IDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IDominio> consultar(IDominio entidade) throws SQLException {
		
		conectar();
		PreparedStatement ps = null;
		Fornecedor fornecedor = (Fornecedor) entidade;
		List<IDominio> fornecedores = new ArrayList<IDominio>();
		
		try {
			
			conexao.setAutoCommit(false);

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * from fornecedores where 1=1");
			
			if(fornecedor.getId() != 0) {
				sql.append(" AND fnc_id = ?");
			}
			
			ps = conexao.prepareStatement(sql.toString());
			
			if(fornecedor.getId() != 0) {
				ps.setInt(1, fornecedor.getId());
			}
			
			ResultSet resultado = ps.executeQuery();
			
			while(resultado.next()) {
				Fornecedor fProcurado = new Fornecedor();
				
				fProcurado.setId(resultado.getInt("fnc_id"));
				fProcurado.setCnpj(resultado.getString("cnpj"));
				fProcurado.setNome(resultado.getString("nome"));
				
				fornecedores.add(fProcurado);
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
		
		
		return fornecedores;
	}

	@Override
	public void excluir(IDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
