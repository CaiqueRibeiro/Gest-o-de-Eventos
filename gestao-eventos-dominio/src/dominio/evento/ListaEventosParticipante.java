package dominio.evento;

import java.util.List;

import dominio.participantes.Participante;

public class ListaEventosParticipante extends EntidadeDominio{
	
	private Participante participante;
	private List<Evento> eventos;
	
	public Participante getParticipante() {
		return participante;
	}
	
	public void setParticipante(Participante participante) {
		this.participante = participante;
	}
	
	public List<Evento> getEventos() {
		return eventos;
	}
	
	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	
	
}
