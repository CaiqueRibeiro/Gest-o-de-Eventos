package classes.core.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Timestamp;

import dominio.evento.IDominio;
import dominio.produto.Fornecedor;
import dominio.produto.Produto;

public class ProdutoDAO extends AbsDAO {

	@Override
	public void salvar(IDominio entidade) throws SQLException {
		conectar();
		
		PreparedStatement ps = null;
		
		Produto produto = (Produto) entidade;
		
		try {
			
			conexao.setAutoCommit(false);
			StringBuilder sql = new StringBuilder();
			
			sql.append("INSERT into produtos (nome, preco, perecivel, dt_validade, dt_entrada, descricao, id_fornecedor)");
			sql.append(" VALUES (?,?,?,?,?,?,?)");
			
			ps = conexao.prepareStatement(sql.toString());
			
			ps.setString(1, produto.getNome());
			ps.setDouble(2, produto.getPreco());
			ps.setBoolean(3, produto.isPerecivel());
			// Converte as datas
			Timestamp entrada = new Timestamp(produto.getDtCadastro().getTime());
			Timestamp validade = new Timestamp(produto.getValidade().getTime());
			
			ps.setTimestamp(4, entrada);
			ps.setTimestamp(5, validade);
			ps.setString(6, produto.getDescricao());
			ps.setInt(7, produto.getFornecedor().getId());
			
			ps.executeUpdate();
			conexao.commit();
			
		} catch (SQLException e) {
			try {
				conexao.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		} finally {
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
		List<IDominio> produtos = new ArrayList<IDominio>();
		
		Produto produto = (Produto) entidade;
		
		try {
			
			int i = 1;
			
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder();

			sql.append("SELECT * from produtos p left join fornecedores f on f.fnc_id = p.id_fornecedor");
			sql.append(" where 1=1");
			
			if(produto.getId() != 0) {
				sql.append(" AND p.prd_id = ?");
			}
			
			if(produto.getNome() != null && produto.getNome() != "") {
				sql.append(" AND p.nome = ?");
			}
			
			ps = conexao.prepareStatement(sql.toString());
			
			if(produto.getId() != 0) {
				ps.setInt(i, produto.getId());
				i++;
			}
			
			if(produto.getNome() != null && produto.getNome() != "") {
				ps.setString(i, produto.getNome());
				i++;
			}
			
			ResultSet resultado = ps.executeQuery();
			
			while(resultado.next()) {
				Produto pdtBuscado = new Produto();
				Fornecedor fncBuscado = new Fornecedor();
				
				pdtBuscado.setNome(resultado.getString("p.nome"));	
				pdtBuscado.setDtCadastro(resultado.getDate("p.dt_entrada"));
				pdtBuscado.setValidade(resultado.getDate("p.dt_validade"));
				pdtBuscado.setPerecivel(Boolean.getBoolean(1));
				
				produtos.add(pdtBuscado);
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
		
		return produtos;
	}

	@Override
	public void excluir(IDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
