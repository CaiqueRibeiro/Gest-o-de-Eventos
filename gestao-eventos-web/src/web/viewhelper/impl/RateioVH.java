package web.viewhelper.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.util.Resultado;
import dominio.evento.IDominio;
import dominio.evento.Rateio;
import web.viewhelper.IViewHelper;

public class RateioVH implements IViewHelper {

	@Override
	public IDominio getData(HttpServletRequest request) {
		
		String operacao = request.getParameter("operacao");
		Rateio rateio = new Rateio();
		
		rateio.setId(Integer.parseInt(request.getParameter("rat-id")));		
		
		return rateio;
	}

	@Override
	public void formataView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<IDominio> recebido = null;
		List<Rateio> relRecebidos = null;
		String msgErro = "";
		
		if(resultado != null) {
			msgErro = resultado.getMensagem();
			
			recebido = resultado.getEntidades();
			relRecebidos = (List<Rateio>) (Object) recebido;
			
		} 
		
		if(msgErro != null && msgErro != "") {
			request.setAttribute("mensagem", msgErro);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		} else {
				
				Rateio rateio = (Rateio) recebido.get(0);
				request.setAttribute("resultado", rateio);
				request.getRequestDispatcher("rateio-evento.jsp").forward(request, response);
		} // caso não tenha mensagem de erro		
		
	}

}
