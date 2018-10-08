package classes.core.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dominio.evento.IDominio;
import dominio.produto.ItemProduto;

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
		
		try {
			
			StringBuilder sql = new StringBuilder();

			sql.append("SELECT p.*, ip.quantidade, ip.preco_total f.*"
					+ "from produtos p inner join item_produto ip on ip.prd_id = p.prd_id"
					+ "inner join fornecedores f on f.fnc_id = ip.fnc_id;");
			sql.append(" where 1=1");
			
			if(itemProduto.getProduto().getId() != 0) {
				sql.append(" AND p.prd_id = ?");
			}
			
			ps = conexao.prepareStatement(sql.toString());
			
			if(itemProduto.getProduto().getId() != 0) {
				ps.setInt(1, itemProduto.getProduto().getId());
			}
			
			ResultSet resultado = ps.executeQuery();
			
			while(resultado.next()) {
				
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

		return null;
	}

	@Override
	public void excluir(IDominio entidade) throws SQLException {
		
	}

}
