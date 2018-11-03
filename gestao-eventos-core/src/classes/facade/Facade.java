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
import classes.core.DAO.FornecedorDAO;
import classes.core.DAO.ItemProdutoDAO;
import classes.core.DAO.LocacaoDAO;
import classes.core.DAO.ParticipanteDAO;
import classes.core.DAO.ParticipanteEventoDAO;
import classes.core.DAO.ProdutoDAO;
import classes.core.DAO.RateioDAO;
import classes.core.DAO.UsuarioDAO;
import classes.strategy.ValidarDados;
import classes.strategy.ValidarDadosParticipante;
import classes.strategy.ValidarDadosProduto;
import classes.strategy.ValidarDadosUsuario;
import classes.strategy.ValidarEndereco;
import classes.strategy.ValidarExistencia;
import classes.strategy.ValidarExistenciaParticipanteEvento;
import classes.util.Resultado;
import dominio.endereco.Locacao;
import dominio.evento.Evento;
import dominio.evento.IDominio;
import dominio.evento.Rateio;
import dominio.participantes.Administrador;
import dominio.participantes.Participante;
import dominio.produto.Fornecedor;
import dominio.produto.ItemProduto;
import dominio.produto.Produto;
import dominio.viewmodels.ParticipanteEventoVM;

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
		ParticipanteDAO ptcDAO = new ParticipanteDAO();
		UsuarioDAO usrDAO = new UsuarioDAO();
		ProdutoDAO pdtDAO = new ProdutoDAO();
		ItemProdutoDAO itemDAO = new ItemProdutoDAO();
		FornecedorDAO fncDAO = new FornecedorDAO();
		LocacaoDAO locDAO = new LocacaoDAO();
		ParticipanteEventoDAO peDAO = new ParticipanteEventoDAO();
		RateioDAO ratDAO = new RateioDAO();
		
		daos.put(Evento.class.getName(), evtDAO);
		daos.put(Participante.class.getName(), ptcDAO);
		daos.put(Administrador.class.getName(), usrDAO);
		daos.put(Produto.class.getName(), pdtDAO);
		daos.put(ItemProduto.class.getName(), itemDAO);
		daos.put(Fornecedor.class.getName(), fncDAO);
		daos.put(Locacao.class.getName(), locDAO);
		daos.put(ParticipanteEventoVM.class.getName(), peDAO);
		daos.put(Rateio.class.getName(), ratDAO);
		
		// Instanciando strategies Evento
		ValidarDados vDados = new ValidarDados();
				
		// Instanciando strategies Participante
		ValidarExistencia vExistencia = new ValidarExistencia();
		ValidarDadosParticipante vDadosParticipante = new ValidarDadosParticipante();
		ValidarEndereco vEndereco = new ValidarEndereco();
		
		// Instanciando strategies Usuário
		ValidarDadosUsuario vDadosUsuario = new ValidarDadosUsuario();
		
		// Instanciando strategies Produto
		ValidarDadosProduto vDadosProduto = new ValidarDadosProduto();
		
		// Instanciando strategies dos participantes do evento
		ValidarExistenciaParticipanteEvento vParticipanteEvento = new ValidarExistenciaParticipanteEvento();
		
		// Listas de strategies para as operações do evento
		List<IStrategy> rnsSalvarEvento = new ArrayList<IStrategy>();
		List<IStrategy> rnsAlterarEvento = new ArrayList<IStrategy>();
		List<IStrategy> rnsConsultarEvento = new ArrayList<IStrategy>();
		List<IStrategy> rnsExcluirEvento = new ArrayList<IStrategy>();
		
		// Listas de strategies para as operações de participante
		List<IStrategy> rnsSalvarParticipante = new ArrayList<IStrategy>();
		List<IStrategy> rnsAlterarParticipante = new ArrayList<IStrategy>();
		List<IStrategy> rnsConsultarParticipante = new ArrayList<IStrategy>();
		List<IStrategy> rnsExcluirParticipante = new ArrayList<IStrategy>();
		
		// Lista de strategies para as operações de usuario
		List<IStrategy> rnsSalvarUsuario = new ArrayList<IStrategy>();
		List<IStrategy> rnsAlterarUsuario = new ArrayList<IStrategy>();
		List<IStrategy> rnsConsultarUsuario = new ArrayList<IStrategy>();
		List<IStrategy> rnsExcluirUsuario = new ArrayList<IStrategy>();
		
		// Lista de strategies para as operações de Produto
		List<IStrategy> rnsSalvarProduto = new ArrayList<IStrategy>();
		List<IStrategy> rnsAlterarProduto = new ArrayList<IStrategy>();
		
		// Lista de strategies para as operações do Participante do evento
		List<IStrategy> rnsSalvarPtcEvento = new ArrayList<IStrategy>();
		
		// Regras de negócio sendo inseridas para o evento
		rnsSalvarEvento.add(vDados);
		rnsAlterarEvento.add(vDados);
		
		// Regras de negócio sendo inseridas para o participante
		rnsSalvarParticipante.add(vExistencia);
		rnsSalvarParticipante.add(vDadosParticipante);
		rnsSalvarParticipante.add(vEndereco);
		rnsAlterarParticipante.add(vDadosParticipante);
		rnsAlterarParticipante.add(vEndereco);
		
		// Regras de negócio sendo inseridas para o usuario
		rnsConsultarUsuario.add(vDadosUsuario);
		
		// Regras de negócio sendo inseridas para o produto
		rnsSalvarProduto.add(vDadosProduto);
		rnsAlterarProduto.add(vDadosProduto);
		
		// Regras de negócio sendo inseridas para o participante do evento
		rnsSalvarPtcEvento.add(vParticipanteEvento);
		
		// Mapa para armazenar todas as operações do evento
		Map<String, List<IStrategy>> rnsEvento = new HashMap<String, List<IStrategy>>();
		rnsEvento.put("SALVAR", rnsSalvarEvento);
		rnsEvento.put("ALTERAR", rnsAlterarEvento);
		rnsEvento.put("CONSULTAR", rnsConsultarEvento);
		rnsEvento.put("EXCLUIR", rnsExcluirEvento);
		
		// Mapa para armazenar todas as operações do participante
		Map<String, List<IStrategy>> rnsParticipante = new HashMap<String, List<IStrategy>>();
		rnsParticipante.put("SALVAR", rnsSalvarParticipante);
		rnsParticipante.put("ALTERAR", rnsAlterarParticipante);
		rnsParticipante.put("CONSULTAR", rnsConsultarParticipante);
		rnsParticipante.put("EXCLUIR", rnsExcluirParticipante);
		
		// Mapa para armazenar todas as operações do usuário
		Map<String, List<IStrategy>> rnsUsuario = new HashMap<String, List<IStrategy>>();
		rnsUsuario.put("CONSULTAR", rnsConsultarUsuario);
		
		// Mapa para armazenar todas as operações do produto
		Map<String, List<IStrategy>> rnsProduto = new HashMap<String, List<IStrategy>>();
		rnsProduto.put("SALVAR", rnsSalvarProduto);
		rnsProduto.put("ALTERAR", rnsAlterarProduto);
		
		Map<String, List<IStrategy>> rnsPtcEvento = new HashMap<String, List<IStrategy>>();
		rnsPtcEvento.put("SALVAR", rnsSalvarPtcEvento);
		
		// Mapa para todas as regras de negócio de um determinado domínio
		rns.put(Evento.class.getName(), rnsEvento);
		rns.put(Participante.class.getName(), rnsParticipante);
		rns.put(Administrador.class.getName(), rnsUsuario);
		rns.put(Produto.class.getName(), rnsProduto);
		rns.put(ParticipanteEventoVM.class.getName(), rnsPtcEvento);

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
		System.out.println("NOME NA FACHADA: " + nmClasse);
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
		String msg = executarRegras(entidade, "ALTERAR");
		
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
				System.out.println("obj excluído!");
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
