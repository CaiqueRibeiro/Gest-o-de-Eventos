package dominio.relatorios;

import dominio.evento.EntidadeDominio;

public class DadosRelatorio extends EntidadeDominio {
	
	private String chave;
	private int valor;
	private String situacao;
	
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	

}
