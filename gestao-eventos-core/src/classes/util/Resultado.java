package classes.util;

import java.util.List;

import dominio.evento.IDominio;

public class Resultado {
	
	public String mensagem;
	public List<IDominio> entidades;
	public IDominio entidade;
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public List<IDominio> getEntidades() {
		return entidades;
	}
	public void setEntidades(List<IDominio> entidades) {
		this.entidades = entidades;
	}
	
	public void setEntidade(IDominio entidade) {
		this.entidade = entidade;
	}
	
	public IDominio getEntidade() {
		return entidade;
	}

}
