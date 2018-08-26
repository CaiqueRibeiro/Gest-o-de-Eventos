package classes.core;

import classes.util.Resultado;
import dominio.evento.IDominio;

public interface IFacade {
	
	public Resultado salvar(IDominio entidade);
	public Resultado consultar(IDominio entidade);
	public Resultado alterar(IDominio entidade);
	public Resultado excluir(IDominio entidade);

}
