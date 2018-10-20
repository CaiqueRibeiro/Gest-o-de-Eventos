package dominio.evento;

import java.util.Date;
import java.util.List;

import dominio.endereco.Endereco;
import dominio.endereco.Locacao;
import dominio.participantes.Administrador;
import dominio.participantes.Participante;

public class Evento extends EntidadeDominio {
	
	private String nome;
	private Date data;
	private String hora;
	private int qdtMaximaPessoas = 0;
	private int categoria;
	private String catNome;
	private Endereco endereco;
	private Rateio rateio;
	private Administrador administrador;
	private List<Participante> participantes;
	private Locacao locacao;
	private String situacao;
	private double valorTotal = 0;
	private double lucro = 0;
	
	
	// Adiciona participante um por um na lista
	public void addParticipante(Participante participante) {
		this.participantes.add(participante);
	}
	
	
	
	public String getCatNome() {
		return catNome;
	}



	public void setCatNome(String catNome) {
		this.catNome = catNome;
	}



	public double getValorTotal() {
		return valorTotal;
	}



	public void setValorTotal(double valorTotal) {
		if(valorTotal >= 0)
			this.valorTotal = valorTotal;
	}



	public int getCategoria() {
		return categoria;
	}



	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}



	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public int getQdtMaximaPessoas() {
		return qdtMaximaPessoas;
	}
	public void setQdtMaximaPessoas(int qdtMaximaPessoas) {
		this.qdtMaximaPessoas = qdtMaximaPessoas;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Rateio getRateio() {
		return rateio;
	}
	public void setRateio(Rateio rateio) {
		this.rateio = rateio;
	}
	public Administrador getAdministrador() {
		return administrador;
	}
	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	public List<Participante> getParticipantes() {
		return participantes;
	}
	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}
	public Locacao getLocacao() {
		return locacao;
	}
	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public double getLucro() {
		return this.lucro;
	}

	public void setLucro(double lucro) {
		lucro = lucro * 0.1;
		
		if(lucro > 0)
			this.lucro = lucro;
		else
			this.lucro = 0;
	}
	
	
	
}
