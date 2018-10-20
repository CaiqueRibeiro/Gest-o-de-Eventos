package classes.core.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Timestamp;

import dominio.evento.IDominio;
import dominio.produto.Categoria;
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
				
			sql.append("INSERT into produtos (nome, perecivel, descricao, id_categoria)");
			sql.append(" VALUES (?,?,?,?)");

			System.out.println("QUERIE: " + sql.toString());
			ps = conexao.prepareStatement(sql.toString());
			
			ps.setString(1, produto.getNome());
			ps.setBoolean(2, produto.isPerecivel());
			ps.setString(3, produto.getDescricao());
			ps.setInt(4, produto.getCategoria().getId());

			
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

		conectar();
		PreparedStatement ps = null;
		Produto produto = (Produto) entidade;
		
		try {
			
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder();
			
			sql.append("UPDATE produtos set nome=?, perecivel=?, descricao=?, id_categoria=?");
			sql.append(" WHERE prd_id=?");
			
			ps = conexao.prepareStatement(sql.toString());
			
			ps.setString(1, produto.getNome());
			ps.setBoolean(2, produto.isPerecivel());
			ps.setString(3, produto.getDescricao());
			ps.setInt(4, produto.getCategoria().getId());
			ps.setInt(5, produto.getId());
			
			ps.executeUpdate();
			conexao.commit();
			
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
		
	}

	@Override
	public List<IDominio> consultar(IDominio entidade) throws SQLException {
		
		conectar();
		PreparedStatement ps = null;
		List<IDominio> produtos = new ArrayList<IDominio>();
		
		Produto produto = (Produto) entidade;
		System.out.println("ID no DAO: " + produto.getId());
		
		try {
			
			int i = 1;
			
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder();

			sql.append("SELECT p.*, c.* from produtos p inner join categorias_produto c on c.cat_id = p.id_categoria");
			sql.append(" where 1=1");
			
			if(produto.getId() != 0) {
				sql.append(" AND prd_id = ?");
			}
			
			if(produto.getNome() != null && produto.getNome() != "") {
				sql.append(" AND nome = ?");
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
				Categoria ctgBuscada = new Categoria();
				
				pdtBuscado.setId(resultado.getInt("p.prd_id"));
				pdtBuscado.setNome(resultado.getString("p.nome"));
				pdtBuscado.setPerecivel(resultado.getInt("p.perecivel") == 1 ? true : false);
				pdtBuscado.setDescricao(resultado.getString("p.descricao"));
				
				ctgBuscada.setId(resultado.getInt("c.cat_id"));
				ctgBuscada.setNome(resultado.getString("c.nome"));
				pdtBuscado.setCategoria(ctgBuscada);
				
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
		conectar();
		PreparedStatement ps = null;		
		Produto produto = (Produto) entidade;
		System.out.println("ID no DAO: " + produto.getId());
		
		try {
			
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder();

			sql.append("DELETE from produtos");
			sql.append(" where prd_id=?");
			
			
			ps = conexao.prepareStatement(sql.toString());
			
				ps.setInt(1, produto.getId());
				
				ps.executeUpdate();
				conexao.commit();
			
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
		
	}

}
