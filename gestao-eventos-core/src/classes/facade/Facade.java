package classes.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import classes.core.IDAO;
import classes.core.IFacade;
import classes.core.IStrategy;
import classes.core.DAO.EventoDAO;
import classes.strategy.ValidarDados;
import classes.util.Resultado;
import dominio.evento.EntidadeDominio;
import dominio.evento.Evento;
import dominio.evento.IDominio;

public class Facade implements IFacade{
	
	private Resultado resultado;
	
	private Map<String, Map<String, List<IStrategy>>> rns;
	
	// mapa para os DAOS
	private Map<String, IDAO> daos;
	
	
	// construtor
	public Facade() {
		
		/* Intanciando o Map de DAOS */
		daos = new HashMap<String, IDAO>();
		/* Intanciando o Map de Regras de Negocio */
		rns = new HashMap<String, Map<String, List<IStrategy>>>();
		
		EventoDAO evtDAO = new EventoDAO();
		
		daos.put(Evento.class.getName(), evtDAO);
		
		ValidarDados vDados = new ValidarDados();
		
		List<IStrategy> rnsSalvarEvento = new ArrayList<IStrategy>();
		List<IStrategy> rnsAlterarEvento = new ArrayList<IStrategy>();
		List<IStrategy> rnsConsultarEvento = new ArrayList<IStrategy>();
		List<IStrategy> rnsExcluirEvento = new ArrayList<IStrategy>();
		
		rnsSalvarEvento.add(vDados);
		rnsAlterarEvento.add(vDados);
		rnsConsultarEvento.add(vDados);
		rnsExcluirEvento.add(vDados);
		
		Map<String, List<IStrategy>> rnsEvento = new HashMap<String, List<IStrategy>>();
		rnsEvento.put("SALVAR", rnsSalvarEvento);
		rnsEvento.put("ALTERAR", rnsSalvarEvento);
		rnsEvento.put("CONSULTAR", rnsSalvarEvento);
		rnsEvento.put("EXCLUIR", rnsSalvarEvento);
		
		rns.put(Evento.class.getName(), rnsEvento);

	}

	@Override
	public Resultado salvar(IDominio entidade) {
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();
		String msg = executarRegras(entidade, "SALVAR");
		
		if(msg == null ) {
			IDAO dao = daos.get(nmClasse);
			
			try {
				
				dao.salvar(entidade);
				List<IDominio> entidades = new ArrayList<IDominio>();
				entidades.add(entidade);
				resultado.setEntidades(entidades);
				System.out.println("obj gravado!");
			} catch(SQLException e) {
				e.printStackTrace();
				System.out.println("Fachada: Não foi possível realizar o registro!");
				resultado.setMensagem("Não foi possível realizar o registro!");
			}
		} else {
			resultado.setMensagem(msg);
		}
		
		return resultado;
	}

	@Override
	public Resultado consultar(IDominio entidade) {
		
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();
		IDAO dao = daos.get(nmClasse);
		
		try {
			
		List<IDominio> lista = dao.consultar(entidade);
		resultado.setEntidades(lista);
		
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Fachada: Não foi possível consultar o registro!");
			resultado.setMensagem("Não foi possível consultar o registro!");
		}
		
		return resultado;
		
	}

	@Override
	public Resultado alterar(IDominio entidade) {

		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();
		String msg = executarRegras(entidade, "SALVAR");
		
		if(msg == null ) {
			IDAO dao = daos.get(nmClasse);
			
			try {
				
				dao.alterar(entidade);
				List<IDominio> entidades = new ArrayList<IDominio>();
				entidades.add(entidade);
				resultado.setEntidades(entidades);
				System.out.println("obj alterado!");
			} catch(SQLException e) {
				e.printStackTrace();
				System.out.println("Fachada: Não foi possível atualizar o registro!");
				resultado.setMensagem("Não foi possível atualizar o registro!");
			}
		} else {
			resultado.setMensagem(msg);
		}
		
		return resultado;
		
	}

	@Override
	public Resultado excluir(IDominio entidade) {
		
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();
		String msg = executarRegras(entidade, "EXCLUIR");
		
		if(msg == null ) {
			IDAO dao = daos.get(nmClasse);
			
			try {
				
				dao.excluir(entidade);
				List<IDominio> entidades = new ArrayList<IDominio>();
				entidades.add(entidade);
				resultado.setEntidades(entidades);
				System.out.println("obj alterado!");
			} catch(SQLException e) {
				e.printStackTrace();
				System.out.println("Fachada: Não foi possível excluir o registro!");
				resultado.setMensagem("Não foi possível excluir o registro!");
			}
		} else {
			resultado.setMensagem(msg);
		}
		
		return resultado;		
		
	}
	
	private String executarRegras(IDominio entidade, String operacao) {
		
		String nmClasse = entidade.getClass().getName();
		StringBuilder msg = new StringBuilder();
		
		Map<String, List<IStrategy>> regrasOperacao = rns.get(nmClasse);
		
		if(regrasOperacao != null) {
			List<IStrategy> regras = regrasOperacao.get(operacao);
			
			if(regras != null) {
				for(IStrategy s : regras) {
					String m = s.processar(entidade);
					
					if(m != null) {
						msg.append(m);
						msg.append("\n");
					}
				}
			}
		}
		
		if(msg.length() > 0) {
			return msg.toString();
		} else {
			return null;
		}
		
	}

}
