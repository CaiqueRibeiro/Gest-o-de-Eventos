package dominio.evento;

import java.util.Date;
import java.util.List;

import dominio.endereco.Endereco;
import dominio.endereco.Locacao;
import dominio.participantes.Administrador;
import dominio.participantes.Participante;
import dominio.produto.ItemProduto;

public class Evento extends EntidadeDominio {
	
	private String nome;
	private Date data;
	private String hora;
	private int qdtMaximaPessoas = 0;
	private int categoria;
	private String tipoPagamento;
	private String catNome;
	private Endereco endereco;
	private Rateio rateio;
	private Administrador administrador;
	private List<Participante> participantes;
	private Locacao locacao;
	private String situacao;
	private double valorTotal = 0;
	private double entrada = -1;
	private boolean convidado = false;
	private List<ItemProduto> produtos;
	
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

	public double getEntrada() {
		return entrada;
	}

	public void setEntrada(double entrada) {
		this.entrada = entrada;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public boolean isConvidado() {
		return convidado;
	}

	public void setConvidado(boolean convidado) {
		this.convidado = convidado;
	}

	public List<ItemProduto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ItemProduto> produtos) {
		this.produtos = produtos;
	}
	
	
		
}
