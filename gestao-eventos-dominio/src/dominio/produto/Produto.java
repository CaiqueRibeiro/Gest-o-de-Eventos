package dominio.produto;

import java.util.Date;

import dominio.evento.EntidadeDominio;

public class Produto extends EntidadeDominio {
	
	private String nome;
	private double preco;
	private boolean perecivel;
	private Date validade;
	private String descricao;
	private Fornecedor fornecedor;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public boolean isPerecivel() {
		return perecivel;
	}
	
	public void setPerecivel(boolean perecivel) {
		this.perecivel = perecivel;
	}
	
	public Date getValidade() {
		return validade;
	}
	
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	

}
