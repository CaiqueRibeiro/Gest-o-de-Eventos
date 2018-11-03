package dominio.viewmodels;

import java.util.ArrayList;
import java.util.List;

import dominio.evento.EntidadeDominio;
import dominio.evento.Evento;
import dominio.participantes.Participante;

public class ParticipanteEventoVM extends EntidadeDominio {
	
	public List<Participante> participantes;
	public Evento evento;
	
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
	
	
	

}
