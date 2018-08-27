package dominio.evento;

import java.util.Date;

public abstract class EntidadeDominio implements IDominio{
	
	protected int id = 0;
	protected Date dtCadastro;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
}
