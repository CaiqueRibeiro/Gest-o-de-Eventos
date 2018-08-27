package classes.testes;

import java.sql.SQLException;
import java.util.List;

import classes.core.DAO.EventoDAO;
import classes.facade.Facade;
import classes.util.Resultado;
import dominio.endereco.Endereco;
import dominio.evento.Evento;
import dominio.evento.IDominio;

public class TesteConsultarEventos {
	
	public static void main(String[] args) {
		
		Evento evento = new Evento();
		Endereco endereco = new Endereco();
		EventoDAO dao = new EventoDAO();
		List<IDominio> listaDominio;
		List<Evento> eventos;
		Resultado resultado;
		Facade fachada = new Facade();
		
		evento.setId(0);
			// eventos = (List<Evento>) (Object) dao.consultar(evento);
			resultado = fachada.consultar(evento);
			listaDominio =  resultado.getEntidades();
			eventos = (List<Evento>) (Object) listaDominio;
			
			for(Evento e : eventos) {
				System.out.println(e.getNome());
				System.out.println(e.getEndereco().getRua());
			}
		
		
	}

}
