package classes.testes;

import java.sql.SQLException;
import java.util.List;

import classes.core.DAO.UsuarioDAO;
import dominio.evento.IDominio;
import dominio.participantes.Administrador;

public class TesteUsuarioDAO {

	public static void main(String[] args) throws SQLException {
		Administrador adm = new Administrador();
		UsuarioDAO dao = new UsuarioDAO();
		List<IDominio> listaDominio;
		List<Administrador> usuarios;
		
		adm.setEmail("caique.rodrigues2@fatec.sp.gov.br");
		adm.setSenha("8246xvix66");
		
		System.out.println("Email no teste: " + adm.getEmail());
		System.out.println("Senha no teste: " + adm.getSenha());
		
		listaDominio = dao.consultar(adm);
		usuarios = (List<Administrador>) (Object) listaDominio;
		
		for(Administrador a : usuarios) {
			System.out.println("Email: " + a.getEmail());
			System.out.println("Senha: " + a.getSenha());
		}
	}

}
