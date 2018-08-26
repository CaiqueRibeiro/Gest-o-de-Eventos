package web.viewhelper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.util.Resultado;
import dominio.evento.IDominio;

public interface IViewHelper {
	
	public IDominio getData(HttpServletRequest request);
	public void formataView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException;


}
