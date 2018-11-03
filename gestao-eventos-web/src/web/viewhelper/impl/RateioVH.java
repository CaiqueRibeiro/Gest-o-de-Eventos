package web.viewhelper.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;

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
		
		
		return null;
	}

	@Override
	public void formataView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		
	}

}
