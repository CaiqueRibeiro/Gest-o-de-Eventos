package classes.core.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dominio.evento.Evento;
import dominio.evento.IDominio;
import dominio.evento.Rateio;
import dominio.evento.RateioProduto;
import dominio.produto.ItemProduto;
import dominio.produto.Produto;

public class RateioProdutoDAO extends AbsDAO {

	@Override
	public void salvar(IDominio entidade) throws SQLException {
		
		conectar();
		PreparedStatement ps = null;
		RateioProduto rateio = (RateioProduto) entidade;
		List<ItemProduto> produtos = rateio.getProdutos();
		Evento evento = rateio.getEvento();
		
		try {
			
			conexao.setAutoCommit(false);
			
			for(ItemProduto ip : produtos) {
				StringBuilder sql = new StringBuilder();
				sql.append("INSERT into rateios_produto (rp_rat_id, rp_nome, rp_quantidade, rp_qtd_restante,rp_data_inclusao) values (?,?,?,?,?);");
				
				ps = conexao.prepareStatement(sql.toString());
				
				ps.setInt(1, evento.getRateio().getId());
				ps.setString(2, ip.getProduto().getNome());
				ps.setDouble(3, ip.getQuantidade());
				ps.setDouble(4, ip.getQuantidade());
				
				Timestamp time = new Timestamp(new Date().getTime());
				ps.setTimestamp(5, time);
				
				ps.executeUpdate();
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
		
	}

	@Override
	public void alterar(IDominio entidade) throws SQLException {
		
		conectar();
		PreparedStatement ps = null;
		RateioProduto ratProduto = (RateioProduto) entidade;
		
		try {
			
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder(); // variável para concatenar as Strings
			// inicia a declaração da query
			sql.append("INSERT INTO rateio_produtos_participantes values(?,?,?)");
			
			ps = conexao.prepareStatement(sql.toString());
			
			ps.setInt(1, ratProduto.getProdutos().get(0).getProduto().getId());
			ps.setInt(2, ratProduto.getParticipante().getId());
			ps.setDouble(3, 1);
			
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
	public List<IDominio> consultar(IDominio entidade) throws SQLException {
		
		conectar();
		PreparedStatement ps = null;
		RateioProduto rateio = (RateioProduto) entidade;
		Rateio rat = rateio.getEvento().getRateio();
		List<IDominio> produtos = new ArrayList<IDominio>();
		
		RateioProduto ratProduto = new RateioProduto();
		
		try {
			
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder();
			
			sql.append("SELECT * from rateios_produto");
			sql.append(" where 1=1");
			
			if(rat.getId() != 0) {
				sql.append(" AND rp_rat_id=?");
			}
			
			ps = conexao.prepareStatement(sql.toString());
			
			if(rat.getId() != 0) {
				ps.setInt(1, rat.getId());
			}
			
			System.out.println(ps.toString());
			
			ResultSet resultado = ps.executeQuery();
			
			
			while(resultado.next()) {
				ItemProduto ip = new ItemProduto();
				Produto prdProcurado = new Produto();
				
				prdProcurado.setId(resultado.getInt("rp_prd_id"));
				prdProcurado.setNome(resultado.getString("rp_nome"));
				ip.setQuantidade(resultado.getDouble("rp_quantidade"));
				ip.setQtdRestante(resultado.getDouble("rp_qtd_restante"));
				ip.setDtCadastro(resultado.getDate("rp_data_inclusao"));
				ip.setId(resultado.getInt("rp_rat_id"));
				
				ip.setProduto(prdProcurado);
				
				produtos.add(ip);				
			}
						
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
		
		return produtos;
	}

	@Override
	public void excluir(IDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
