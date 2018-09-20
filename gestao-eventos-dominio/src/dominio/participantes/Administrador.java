package dominio.participantes;

public class Administrador extends Pessoa implements Usuario{
	
	private String email;
	private String senha;

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

	
	
}
