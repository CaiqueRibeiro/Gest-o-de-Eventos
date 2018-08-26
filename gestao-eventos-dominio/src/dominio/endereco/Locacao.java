package dominio.endereco;

import dominio.evento.EntidadeDominio;

public class Locacao extends EntidadeDominio {
	
	private Endereco endereco;
	private Ambiente ambiente;
	private boolean acustica;
	private boolean possuiEstacionamento;
	private int vagasEstacionamento;
	private int vagasEstacionamentoUsadas;	
	private double valorAluguel;
}
