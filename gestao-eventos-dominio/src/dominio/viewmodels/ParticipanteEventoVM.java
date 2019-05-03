package dominio.viewmodels;

import java.util.ArrayList;
import java.util.List;

import dominio.evento.EntidadeDominio;
import dominio.evento.Evento;
import dominio.participantes.Participante;

public class ParticipanteEventoVM extends EntidadeDominio {
	
	private List<Participante> participantes;
	private Evento evento;
	private boolean incluidos;
	
	public ParticipanteEventoVM(){
	}
	
	public ParticipanteEventoVM(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}

	public List<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	public int getIdEvento() {
		return evento.getId();
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	public Evento getEvento() {
		return this.evento;
	}

	public boolean isIncluidos() {
		return incluidos;
	}

	public void setIncluidos(boolean incluidos) {
		this.incluidos = incluidos;
	}
	
	
	

}
