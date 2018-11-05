package classes.core.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.evento.IDominio;
import dominio.relatorios.DadosRelatorio;
import dominio.relatorios.Relatorio;
import dominio.relatorios.TipoRelatorio;

public class RelatorioDAO extends AbsDAO {

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
		Relatorio relatorio = (Relatorio) entidade;
		List<IDominio> listaRelatorios = new ArrayList<IDominio>();
		List<DadosRelatorio> listaDadosA = new ArrayList<DadosRelatorio>();
		List<DadosRelatorio> listaDadosB = new ArrayList<DadosRelatorio>();
		
		Relatorio relProcurado = null;
		
		try {
			
			conexao.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder();
			
			if(relatorio.getTpRelatorio() == TipoRelatorio.EVENTO) {
				
				relProcurado = new Relatorio(TipoRelatorio.EVENTO);
				
				sql.append("select MONTH(data) as data, count(evt_id) quantidade, situacao from eventos where situacao='AGENDADO' OR situacao='ADIADO' group by MONTH(data), situacao order by situacao, data");
				ps = conexao.prepareStatement(sql.toString());
				System.out.println(ps.toString());
				
				ResultSet resultado = ps.executeQuery();
				
				while(resultado.next()) {
					DadosRelatorio dados = new DadosRelatorio();
					
					dados.setChave(resultado.getString("data"));
					dados.setValor(resultado.getInt("quantidade"));
					dados.setSituacao(resultado.getString("situacao"));
					
					if(dados.getSituacao().equals("AGENDADO"))
						listaDadosA.add(dados);
					else
						listaDadosB.add(dados);
				}
				
				relProcurado.setDadosA(listaDadosA);
				relProcurado.setDadosB(listaDadosB);
				listaRelatorios.add(relProcurado);								
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
		
		return listaRelatorios;
	}

	@Override
	public void excluir(IDominio entidade) throws SQLException {
		// TODO Auto-generated method stub

	}

}
