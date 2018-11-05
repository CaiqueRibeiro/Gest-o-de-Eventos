package classes.testes;

import java.sql.SQLException;
import java.util.List;

import classes.core.DAO.RelatorioDAO;
import dominio.relatorios.DadosRelatorio;
import dominio.relatorios.Relatorio;
import dominio.relatorios.TipoRelatorio;

public class TesteRelatorios {
	
	public static void main(String[] args) throws SQLException {
		Relatorio relatorio = new Relatorio(TipoRelatorio.EVENTO);
		RelatorioDAO dao = new RelatorioDAO();
		
		List<Relatorio> lista = (List<Relatorio>) (Object) dao.consultar(relatorio);
		Relatorio r = lista.get(0);
		
		for(DadosRelatorio d : r.getDadosA()) {
			System.out.println("CHAVE: " + d.getChave());
			System.out.println("VALOR: " + d.getValor());
			System.out.println("SITUACAO: " + d.getSituacao());
			System.out.println("::::::::::");
		}
		
		for(DadosRelatorio d : r.getDadosB()) {
			System.out.println("CHAVE: " + d.getChave());
			System.out.println("VALOR: " + d.getValor());
			System.out.println("SITUACAO: " + d.getSituacao());
			System.out.println("::::::::::");
		}
	}

}
