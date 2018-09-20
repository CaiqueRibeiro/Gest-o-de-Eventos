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
    <title>Cadastro de locações</title>
    </head>
    <body>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    	<c:import url="../header.jsp" />

    	<div class="container">
    		<center><h3>Busca de Locações</h3></center>  

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
			    <thead>
				    <tr>
				    	<th scope="col">Nome</th>
				    </tr>
			    </thead>
				    <tbody  id="corpo-lista">
				    	<tr>
				    		<td><a href="consulta-locacoes.jsp">Rose Festas</a></td>
				    	</tr>
				    	<tr>
				    		<td><a href="consulta-locacoes.jsp">Carlos Eventos</a></td>
				    	</tr>
				    	<tr>
				    		<td><a href="consulta-locacoes.jsp">Zezinho Festas</a></td>
				    	</tr>
				    </tbody>
			    </table>
		    </div>
		    
	<script src="../bootstrap/js/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script type="text/javascript" src="js/visual.js"></script>
    <script src="../bootstrap/js/bootstrap.min.js" ></script>
    </body>
</html>