package dominio.participantes;

public class Participante extends Pessoa {
	
	private String email;
	private int valorPagar;
	private int qtdConvidados;
	private String situacao;
	private boolean pago;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getValorPagar() {
		return valorPagar;
	}

	public void setValorPagar(int valorPagar) {
		this.valorPagar = valorPagar;
	}

	public int getQtdConvidados() {
		return qtdConvidados;
	}

	public void setQtdConvidados(int qtdConvidados) {
		this.qtdConvidados = qtdConvidados;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}
	
	

}
