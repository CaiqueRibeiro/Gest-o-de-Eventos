package dominio.produto;

import java.util.Date;

import dominio.evento.EntidadeDominio;

public class Produto extends EntidadeDominio {
	
	private String nome;
	private boolean perecivel;
	private String descricao;
	private Categoria categoria;

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean isPerecivel() {
		return perecivel;
	}
	
	public void setPerecivel(boolean perecivel) {
		this.perecivel = perecivel;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	

}
