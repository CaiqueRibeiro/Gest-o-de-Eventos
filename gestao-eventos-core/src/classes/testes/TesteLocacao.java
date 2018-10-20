package classes.testes;

import java.util.List;

import classes.core.DAO.LocacaoDAO;
import classes.facade.Facade;
import classes.util.Resultado;
import dominio.endereco.Locacao;
import dominio.evento.IDominio;

public class TesteLocacao {

	public static void main(String[] args) {


		LocacaoDAO dao = new LocacaoDAO();
		Locacao locacao = new Locacao();
		Facade fachada = new Facade();
		
		/*locacao.setNome("Casa de Festas Rose");
		locacao.setAcustica(true);
		locacao.setAmbiente(Ambiente.FECHADO);
		locacao.setDtCadastro(new Date());
		locacao.setPossuiEstacionamento(true);
		locacao.setVagasEstacionamento(500);
		locacao.setVagasEstacionamentoUsadas(300);
		locacao.setValorAluguel(5.350);*/
		
		
		Resultado resultado = fachada.consultar(locacao);
		List<IDominio> lista = (List<IDominio>) resultado.getEntidades();
		List<Locacao> locacoes = (List<Locacao>) (Object) lista;
		
		for(Locacao l : locacoes) {
			System.out.println("Nome:" + l.getNome());
		}

	}

}
