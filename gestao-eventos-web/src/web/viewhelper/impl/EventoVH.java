package web.viewhelper.impl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.util.Resultado;
import dominio.endereco.Endereco;
import dominio.endereco.Locacao;
import dominio.evento.Evento;
import dominio.evento.IDominio;
import dominio.evento.Rateio;
import dominio.participantes.Administrador;
import web.viewhelper.IViewHelper;

public class EventoVH implements IViewHelper {

	@Override
	public IDominio getData(HttpServletRequest request) {
		
		String operacao = request.getParameter("operacao");
		Evento evento = new Evento();
		
		if(operacao.equals("SALVAR") || operacao.equals("ALTERAR")) {
			Rateio rateio = new Rateio();
			Endereco endereco = new Endereco();
			Administrador administrador = new Administrador();
			Locacao locacao = new Locacao();
			
			administrador.setId(2);
			locacao.setId(Integer.parseInt(request.getParameter("locacao")));
						
			// insere informações sobre o evento
			evento.setNome(request.getParameter("nome"));
			evento.setCategoria(Integer.parseInt(request.getParameter("categoria")));
			evento.setHora(request.getParameter("hora"));
			evento.setQdtMaximaPessoas(Integer.parseInt(request.getParameter("max-participantes")));
			evento.setSituacao(request.getParameter("situacao"));
			
			// insere informações sobre o endereço
			endereco.setLogradouro(request.getParameter("logradouro"));
			endereco.setRua(request.getParameter("rua"));
			endereco.setNumero(request.getParameter("numero"));
			endereco.setCEP(request.getParameter("cep"));
			endereco.setBairro(request.getParameter("bairro"));
			endereco.setCidade(request.getParameter("cidade"));
			endereco.setEstado(request.getParameter("estado"));
			
			rateio.setValorPagar(10000);
			
			// Formata as datas necessárias
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");			
			try {
				evento.setData(sd.parse(request.getParameter("data")));
				rateio.setInicioRateio(sd.parse(request.getParameter("inicio-rateio")));
				rateio.setFimRateio(sd.parse(request.getParameter("final-rateio")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // fim da formatação de datas
			
			// insere os objetos dentro de evento
			evento.setRateio(rateio);
			evento.setEndereco(endereco);
			evento.setAdministrador(administrador);
			evento.setLocacao(locacao);
		} // OPERACAO SALVAR E ALTERAR
		//
		//
				
		return evento;		
		
	}

	@Override
	public void formataView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
	}
	
	

}
