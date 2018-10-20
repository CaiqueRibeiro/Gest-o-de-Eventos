package classes.core.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import dominio.evento.IDominio;
import dominio.produto.Categoria;
import dominio.produto.Fornecedor;
import dominio.produto.ItemProduto;
import dominio.produto.Produto;
import dominio.viewmodels.ItemProdutoVM;

public class ItemProdutoDAO extends AbsDAO {

	@Override
	public void salvar(IDominio entidade) throws SQLException {

		conectar();
		PreparedStatement ps = null;
		ItemProduto item = (ItemProduto) entidade;
		ProdutoDAO pDAO = new ProdutoDAO();
		
		try {
			
			List<Produto> produtos = (List<Produto>) (Object) pDAO.consultar(item.getProduto());
			Produto produto = produtos.get(0);
			
			System.out.println("Produto é perecível? " + produto.isPerecivel());
			
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder();
			
			if(produto.isPerecivel()) {
				sql.append("INSERT into item_produto values(?,?,?,?,?,?,?)");
			} else {
				sql.append("INSERT into item_produto (prd_id, fnc_id, quantidade, preco, preco_total, dt_entrada) values(?,?,?,?,?,?)");
			}
			
			ps = conexao.prepareStatement(sql.toString());
			
			ps.setInt(1, item.getProduto().getId());
			ps.setInt(2, item.getFornecedor().getId());
			ps.setDouble(3, item.getQuantidade());
			ps.setDouble(4, item.getPreco());
			ps.setDouble(5, item.getPrecoTotal());
			
			Timestamp entrada = new Timestamp(item.getDtCadastro().getTime());
			ps.setTimestamp(6, entrada);
			
			Timestamp validade = null;
			if(produto.isPerecivel()) {
				System.out.println("ENTROU no perecivel");
				validade = new Timestamp(item.getDtValidade().getTime());
				ps.setTimestamp(7, validade);
			}
			
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
		ItemProduto item = (ItemProduto) entidade;
		ProdutoDAO pDAO = new ProdutoDAO();
		
		try {
			
			List<Produto> produtos = (List<Produto>) (Object) pDAO.consultar(item.getProduto());
			Produto produto = produtos.get(0);
			
			System.out.println("Produto é perecível? " + produto.isPerecivel());
			
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder();
			
			if(produto.isPerecivel()) {
				sql.append("UPDATE item_produto set quantidade = ?, preco = ?, preco_total = ?, dt_entrada = ?, dt_validade = ?");
			} else {
				sql.append("UPDATE item_produto set quantidade = ?, preco = ?, preco_total = ?, dt_entrada = ?");
			}
			
			sql.append(" WHERE prd_id = ? AND fnc_id = ?");

			ps = conexao.prepareStatement(sql.toString());
			
			ps.setDouble(1, item.getQuantidade());
			ps.setDouble(2, item.getPreco());
			ps.setDouble(3, item.getPrecoTotal());
			
			Timestamp entrada = new Timestamp(item.getDtCadastro().getTime());
			ps.setTimestamp(4, entrada);
			
			Timestamp validade = null;
			if(produto.isPerecivel()) {
				System.out.println("ENTROU no perecivel");
				validade = new Timestamp(item.getDtValidade().getTime());
				ps.setTimestamp(5, validade);
				ps.setInt(6, item.getProduto().getId());
				ps.setInt(7, item.getFornecedor().getId());
			} else {
				ps.setInt(5, item.getProduto().getId());
				ps.setInt(6, item.getFornecedor().getId());				
			}
			
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
	public List<IDominio> consultar(IDominio entidade) throws SQLException {
		
		conectar();		
		PreparedStatement ps = null;
		
		ItemProduto itemProduto = (ItemProduto) entidade;
		List<IDominio> itens = new ArrayList<IDominio>();
		
		try {
			
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder();

			sql.append("SELECT p.*, ip.quantidade, ip.preco, ip.dt_entrada, ip.dt_validade, f.*, c.*"
					+ " from produtos p inner join item_produto ip on ip.prd_id = p.prd_id"
					+ " inner join fornecedores f on f.fnc_id = ip.fnc_id inner join categorias_produto c on c.cat_id = p.id_categoria");
			sql.append(" where 1=1");
			
			if(itemProduto.getProduto() != null && itemProduto.getProduto().getId() != 0) {
				sql.append(" AND p.prd_id = ?");
			}
			
			if(itemProduto.getFornecedor()!= null && itemProduto.getFornecedor().getId() != 0) {
				sql.append(" AND f.fnc_id = ?");
			}
			
			sql.append(" order by p.nome");
			
			ps = conexao.prepareStatement(sql.toString());
			
			if(itemProduto.getProduto() != null && itemProduto.getProduto().getId() != 0) {
				ps.setInt(1, itemProduto.getProduto().getId());
			}
			
			if(itemProduto.getFornecedor()!= null && itemProduto.getFornecedor().getId() != 0) {
				ps.setInt(2, itemProduto.getFornecedor().getId());
			}
			
			System.out.println(ps.toString());
			
			ResultSet resultado = ps.executeQuery();
			
			while(resultado.next()) {
				ItemProduto itemProcurado = new ItemProduto();
				Produto pdtProcurado = new Produto();
				Fornecedor fncProcurado = new Fornecedor();
				Categoria categoria = new Categoria();
				
				pdtProcurado.setCategoria(categoria);
				
				pdtProcurado.setId(resultado.getInt("p.prd_id"));
				pdtProcurado.setNome(resultado.getString("p.nome"));
				pdtProcurado.setPerecivel(resultado.getInt("p.perecivel") == 1 ? true : false);
				pdtProcurado.setDescricao(resultado.getString("p.descricao"));
				pdtProcurado.getCategoria().setId(resultado.getInt("p.id_categoria"));
				pdtProcurado.getCategoria().setNome(resultado.getString("c.nome"));
	
				fncProcurado.setId(resultado.getInt("f.fnc_id"));
				fncProcurado.setNome(resultado.getString("f.nome"));
				fncProcurado.setCnpj(resultado.getString("f.cnpj"));
				
				if(pdtProcurado.isPerecivel() == true)
					itemProcurado.setDtValidade(resultado.getDate("ip.dt_validade"));
				itemProcurado.setDtCadastro(resultado.getDate("ip.dt_entrada"));
				itemProcurado.setPreco(resultado.getDouble("ip.preco"));
				itemProcurado.setQuantidade(resultado.getDouble("ip.quantidade"));
				
				itemProcurado.setFornecedor(fncProcurado);
				itemProcurado.setProduto(pdtProcurado);
				
				itens.add(itemProcurado);
			}
			
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

		return itens;
	}

	@Override
	public void excluir(IDominio entidade) throws SQLException {
		conectar();
		PreparedStatement ps = null;		
		ItemProduto item = (ItemProduto) entidade;
		
		try {
			
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder();

			sql.append("DELETE from item_produto");
			sql.append(" where prd_id=? AND fnc_id=?");
			
			
			ps = conexao.prepareStatement(sql.toString());
			
				ps.setInt(1, item.getProduto().getId());
				ps.setInt(2, item.getFornecedor().getId());
				
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
