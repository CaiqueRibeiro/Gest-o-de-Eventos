package dominio.relatorios;

import java.util.List;

import dominio.evento.EntidadeDominio;
import dominio.participantes.Administrador;

public class Relatorio extends EntidadeDominio {
	
	private Administrador usuario;
	private TipoRelatorio tpRelatorio;
	private List<DadosRelatorio> dadosA;
	private List<DadosRelatorio> dadosB;
	
	
	public Relatorio(TipoRelatorio tipo) {
		this.tpRelatorio = tipo;
	}
		
	
	public Administrador getUsuario() {
		return usuario;
	}


	public void setUsuario(Administrador usuario) {
		this.usuario = usuario;
	}



	public TipoRelatorio getTpRelatorio() {
		return tpRelatorio;
	}
	public void setTpRelatorio(TipoRelatorio tpRelatorio) {
		this.tpRelatorio = tpRelatorio;
	}

	public List<DadosRelatorio> getDadosA() {
		return dadosA;
	}

	public void setDadosA(List<DadosRelatorio> dados) {
		this.dadosA = dados;
	}
	
	public List<DadosRelatorio> getDadosB() {
		return dadosB;
	}

	public void setDadosB(List<DadosRelatorio> dados) {
		this.dadosB = dados;
	}
	
	
	
	

}
