package dominio.participantes;

public class Participante extends Pessoa {
	
	private String email;
	private int valorPagar;
	private int qtdConvidados;

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

}
