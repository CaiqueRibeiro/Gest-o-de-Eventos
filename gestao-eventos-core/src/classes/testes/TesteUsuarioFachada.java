package classes.testes;

import java.util.List;

import classes.core.DAO.UsuarioDAO;
import classes.facade.Facade;
import classes.util.Resultado;
import dominio.evento.IDominio;
import dominio.participantes.Administrador;

public class TesteUsuarioFachada {
	
	public static void main(String[] args) {
		
		Administrador adm = new Administrador();
		List<IDominio> listaDominio;
		List<Administrador> usuarios;
		Resultado resultado = new Resultado();
		Facade fachada = new Facade();
		
		adm.setEmail("caique.rodrigues2@fatec.sp.gov.br");
		adm.setSenha("8246xvix66");
		
		System.out.println("Email no teste: " + adm.getEmail());
		System.out.println("Senha no teste: " + adm.getSenha());
		
		resultado = fachada.consultar(adm);
		listaDominio = resultado.getEntidades();
		usuarios = (List<Administrador>) (Object) listaDominio;
		
		for(Administrador a : usuarios) {
			System.out.println("Email: " + a.getEmail());
			System.out.println("Senha: " + a.getSenha());
		}
	}
		
}

