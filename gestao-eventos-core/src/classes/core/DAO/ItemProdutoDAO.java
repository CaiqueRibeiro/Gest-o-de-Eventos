package classes.core.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	}

	@Override
	public void alterar(IDominio entidade) throws SQLException {

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
		
	}

}
