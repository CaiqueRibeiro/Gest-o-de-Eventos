<%@page import="dominio.participantes.Participante"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="../css/visual.css"/>
<link type="text/css" rel="stylesheet" href="../css/participantes.css"/>


<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<title>Produtos - Rateio do evento</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="../header.jsp" />
	
	<div class="container-fluid">		
	
	    <form action="" id="form-add-produtos">
	        <label for="qtde-produto">Produto:</label>
	        <input type="text" id="produto" class="form-control" name="input-produto">
	        <label for="qtde-produto">Quantidade:</label>
	        <input type="number" step="0.01" id="qtde-produto" class="form-control" name="input-qtde">
	        <br>
	        <center><input type="button" id="button-add-produto" class="btn btn-primary" value="Adicionar"></center>
    	</form>
        
		<form action="rateio-evento" class="form-container-produtos" id="form-container-produtos" style="width: 100%">
			<div class="container-produtos" id="container-produtos">
			
				
			</div>
		
		<a id="add-produtos-rateio" class="btn btn-success" href="/gestao-eventos-web/evento/salvar-produtos-rateio?evt-id=${param.evtid}&rat-id=${param.ratid }&operacao=SALVAR">Salvar</a><br/>
	    </form>
	    
	
	</div>
	
	<script src="../bootstrap/js/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="../bootstrap/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="../js/rateios.js"></script>
</body>
</html>