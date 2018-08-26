package classes.core;

import java.sql.SQLException;
import java.util.List;

import dominio.evento.IDominio;

public interface IDAO {
	
	public void salvar(IDominio entidade) throws SQLException;
	public void alterar(IDominio entidade)throws SQLException;
	public List<IDominio> consultar(IDominio entidade)throws SQLException;
	public void excluir(IDominio entidade)throws SQLException;

}
