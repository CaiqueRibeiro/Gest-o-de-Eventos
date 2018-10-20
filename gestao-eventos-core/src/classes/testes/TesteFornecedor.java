package classes.testes;

import java.util.List;

import classes.facade.Facade;
import classes.util.Resultado;
import dominio.evento.IDominio;
import dominio.produto.Fornecedor;

public class TesteFornecedor {
	
	public static void main(String[] args) {
		
		Facade fachada = new Facade();
		List<IDominio> listaDominio;
		List<Fornecedor> fornecedores;
		
		Resultado resultado = fachada.consultar(new Fornecedor());
		listaDominio =  resultado.getEntidades();
		fornecedores = (List<Fornecedor>) (Object) listaDominio;
		
		for(Fornecedor f : fornecedores) {
			System.out.println("Nome: " + f.getNome());
			System.out.println("CNPJ: " + f.getCnpj());
			
		}
		
		
		
	}

}
