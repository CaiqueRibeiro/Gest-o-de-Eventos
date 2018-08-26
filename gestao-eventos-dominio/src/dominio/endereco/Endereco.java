package dominio.endereco;

import dominio.evento.EntidadeDominio;

public class Endereco extends EntidadeDominio {
	
	private String logradouro;
	private String rua;
	private String numero;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
	
	public String getLogradouro() {
		return this.logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getRua() {
		return this.rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return this.numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return this.bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCEP() {
		return this.cep;
	}
	public void setCEP(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return this.cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return this.estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
