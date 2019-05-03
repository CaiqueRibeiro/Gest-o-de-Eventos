<%@page import="dominio.evento.Evento"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="../css/visual.css"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Eventos como participante</title>
    </head>
    <body>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    	<c:import url="../header.jsp" />

    	<div class="container">
    		<center><h3>Busca de Eventos Como Participante</h3></center>  

    		<table class="table">
	    		<thead>
	    			<tr>
	    				<th colspan="2" scope="col" style="width: 100%">Consultar</th>
	    			</tr>
	
	    		</thead>
	
	    		<tbody>
	    			<tr>
	    				<td  id="nome-filtro"><input type="text"style="width: 80%; margin-top: 0.5%" id="nome" name="nome"/></td>
	    				<td style="text-align: left"><input type="button" id="consultar" class="btn btn-primary" value="Filtrar" onclick="procuraNome()"/>
	    					<a href="cadastro-evento.jsp" class="btn btn-success">Cadastrar</a>
	    				</td>                       
	    			</tr>
	    		</tbody>
   		 	</table>


		    <table class="table table-light">
		    <colgroup>
		       <col span="1" style="width: 70%;">
		       <col span="1" style="width: 15%;">
		       <col span="1" style="width: 15%;">
		    </colgroup>
			    <thead>
				    <tr>
				    	<th scope="col">Nome</th>
				    </tr>
			    </thead>
				    <tbody  id="corpo-lista">
				    	<%
				    		List<Evento> resultado = (List<Evento>) request.getAttribute("resultado");
				    	
					    	if(resultado != null) {
					    		  
					    	  	for(Evento ev : resultado) {
				    	%>
				    	<tr>
				    		<td><a href="/gestao-eventos-web/evento/eventos-convidado?operacao=CONSULTAR&acao=CONSULTAR&evt-id=<%=ev.getId()%>&editar=false"><%=ev.getNome()%></a></td>
				    		<td><a class="btn btn-success btn-delete" href="/gestao-eventos-web/evento/eventos-convidado?operacao=ATUALIZAR&acao=CONFIRMAR&evt-id=<%=ev.getId()%>">CONFIRMAR</a></td>
				    		<td><a class="btn btn-danger btn-delete" href="/gestao-eventos-web/evento/eventos-convidado?operacao=ATUALIZAR&acao=REJEITAR&evt-id=<%=ev.getId()%>">REJEITAR</a></td>
				    	</tr>
				    	<%
					    	  	}
					    	}
				    	%>	
				    </tbody>
			    </table>
		    </div>
		    
	<script src="../bootstrap/js/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script type="text/javascript" src="js/visual.js"></script>
    <script src="../bootstrap/js/bootstrap.min.js" ></script>
    </body>
</html>