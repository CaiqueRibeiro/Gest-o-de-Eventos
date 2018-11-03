package dominio.participantes;

public class Administrador extends Pessoa implements Usuario{
	
	private String email;
	private String senha;
	private Participante participante;

	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public String getSenha() {
		return this.senha;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}
	
	
}
