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
import dominio.produto.ItemProduto;
import dominio.produto.Produto;

public class EstoqueEventoDAO extends AbsDAO {

	@Override
	public void salvar(IDominio entidade) throws SQLException {
		
		conectar();
		PreparedStatement ps = null;
		Evento evento = (Evento) entidade;
		List<ItemProduto> lista = evento.getProdutos();
		
		try {
			
			conexao.setAutoCommit(false);
			
			
			for(ItemProduto ip : lista) {
				StringBuilder sql = new StringBuilder();
				sql.append("INSERT into produtos_evento (pre_evt_id, pre_prd_id, pre_quantidade_necessaria,pre_dt_entrada) values (?,?,?,?);");
				
				ps = conexao.prepareStatement(sql.toString());
				
				ps.setInt(1, evento.getId());
				ps.setInt(2, ip.getProduto().getId());
				ps.setDouble(3, ip.getQuantidade());
				
				Timestamp time = new Timestamp(new Date().getTime());
				ps.setTimestamp(4, time);
				
				System.out.println(ps.toString());
				
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
		Evento evento = (Evento) entidade;
		List<ItemProduto> lista = evento.getProdutos();
		
		try {
			
			conexao.setAutoCommit(false);
			
			
			for(ItemProduto ip : lista) {
				StringBuilder sql = new StringBuilder();
				sql.append("UPDATE produtos_evento SET pre_quantidade_necessaria=?,pre_dt_entrada=?  WHERE pre_evt_id=? AND pre_prd_id=?;");
				
				ps = conexao.prepareStatement(sql.toString());
				
				ps.setDouble(1, ip.getQuantidade());
				
				Timestamp time = new Timestamp(new Date().getTime());
				ps.setTimestamp(2, time);
				
				ps.setInt(3, evento.getId());
				ps.setInt(4, ip.getProduto().getId());
				
				System.out.println(ps.toString());
				
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
	public List<IDominio> consultar(IDominio entidade) throws SQLException {
		
		
		conectar();
		PreparedStatement ps = null;
		Evento evento = (Evento) entidade;
		List<IDominio> lista = new ArrayList<IDominio>();
		
		try {
			
			conexao.setAutoCommit(false);
			
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * from produtos_evento pe left join produtos p on p.prd_id = pe.pre_prd_id WHERE pe.pre_evt_id=?");
			ps = conexao.prepareStatement(sql.toString());
				
			ps.setInt(1, evento.getId());
				
			System.out.println(ps.toString());
			
			ResultSet resultado = ps.executeQuery();
			
			while(resultado.next()) {
				
				ItemProduto ip = new ItemProduto();
				Produto prd = new Produto();
				
				prd.setId(resultado.getInt("pe.pre_prd_id"));
				prd.setNome(resultado.getString("p.nome"));
				ip.setQuantidade(resultado.getDouble("pe.pre_quantidade_necessaria"));
				
				ip.setProduto(prd);
				
				lista.add(ip);				
			
			}
			
			System.out.println("TAMANHO DA LISTA: " + lista.size());
			
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
		
		return lista;
		
	}

	@Override
	public void excluir(IDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
