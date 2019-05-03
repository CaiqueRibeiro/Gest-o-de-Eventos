package dominio.evento;

import java.util.List;

import dominio.participantes.Participante;
import dominio.produto.ItemProduto;

public class RateioProduto extends Rateio {
	
	private List<ItemProduto> produtos;
	private Participante participante;
	private Evento evento;
	
	public List<ItemProduto> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(List<ItemProduto> produtos) {
		this.produtos = produtos;
	}
	
	public Participante getParticipante() {
		return participante;
	}
	
	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}		

}
