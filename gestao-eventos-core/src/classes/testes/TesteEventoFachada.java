package classes.testes;

import java.util.Date;

import classes.core.IFacade;
import classes.core.DAO.EventoDAO;
import classes.facade.Facade;
import dominio.endereco.Endereco;
import dominio.endereco.Locacao;
import dominio.evento.Evento;
import dominio.evento.Rateio;
import dominio.participantes.Administrador;

public class TesteEventoFachada {
	
	public static void main(String[] args) {
		
		Evento evento = new Evento();
		Rateio rateio = new Rateio();
		Endereco endereco = new Endereco();
		Administrador administrador = new Administrador();
		Locacao locacao = new Locacao();
		
		endereco.setId(2);
		rateio.setInicioRateio(new Date());
		rateio.setFimRateio(new Date());
		rateio.setValorPagar(10000);
		administrador.setId(1);
		locacao.setId(3);
		
		evento.setNome("Terceiro Evento");
		evento.setCategoria(3);
		evento.setData(new Date());
		evento.setHora("16:00");
		evento.setQdtMaximaPessoas(500);
		evento.setSituacao("AGENDADO");
		
		evento.setRateio(rateio);
		evento.setEndereco(endereco);
		evento.setAdministrador(administrador);
		evento.setLocacao(locacao);
		
		IFacade fachada = new Facade();
		
		try {
		fachada.salvar(evento);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
