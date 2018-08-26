package classes.testes;

import java.util.Date;

import classes.core.DAO.EventoDAO;
import dominio.endereco.Endereco;
import dominio.endereco.Locacao;
import dominio.evento.Evento;
import dominio.evento.Rateio;
import dominio.participantes.Administrador;

public class TesteEventoDAO {
	
	public static void main(String[] args) {
		
		Evento evento = new Evento();
		Rateio rateio = new Rateio();
		Endereco endereco = new Endereco();
		Administrador administrador = new Administrador();
		Locacao locacao = new Locacao();
		
		endereco.setId(2);
		rateio.setInicioRateio(new Date());
		rateio.setFimRateio(new Date());
		rateio.setValorPagar(5000);
		administrador.setId(2);
		locacao.setId(2);
		
		evento.setNome("Segundo evento");
		evento.setCategoria(3);
		evento.setData(new Date());
		evento.setHora("18:00");
		evento.setQdtMaximaPessoas(200);
		evento.setSituacao("AGENDADO");
		
		evento.setRateio(rateio);
		evento.setEndereco(endereco);
		evento.setAdministrador(administrador);
		evento.setLocacao(locacao);
		
		EventoDAO dao = new EventoDAO();
		
		try {
		dao.salvar(evento);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
