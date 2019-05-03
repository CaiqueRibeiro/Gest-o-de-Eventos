package dominio.endereco;

import dominio.evento.EntidadeDominio;

public class Locacao extends EntidadeDominio {
	
	private String nome;
	private Ambiente ambiente;
	private boolean acustica;
	private boolean possuiEstacionamento;
	private int vagasEstacionamento = 0;
	private int vagasEstacionamentoUsadas = 0;	
	private double valorAluguel = 0.0;
	
	public String getNome() {
		return nome;
	}	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Ambiente getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}
	public boolean isAcustica() {
		return acustica;
	}
	public void setAcustica(boolean acustica) {
		this.acustica = acustica;
	}
	public boolean isPossuiEstacionamento() {
		return possuiEstacionamento;
	}
	public void setPossuiEstacionamento(boolean possuiEstacionamento) {
		this.possuiEstacionamento = possuiEstacionamento;
	}
	public int getVagasEstacionamento() {
		return vagasEstacionamento;
	}
	public void setVagasEstacionamento(int vagasEstacionamento) {
		this.vagasEstacionamento = vagasEstacionamento;
	}
	public int getVagasEstacionamentoUsadas() {
		return vagasEstacionamentoUsadas;
	}
	public void setVagasEstacionamentoUsadas(int vagasEstacionamentoUsadas) {
		this.vagasEstacionamentoUsadas = vagasEstacionamentoUsadas;
	}
	public double getValorAluguel() {
		return valorAluguel;
	}
	public void setValorAluguel(double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}
	
	
	
}
