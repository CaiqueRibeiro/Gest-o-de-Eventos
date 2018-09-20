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
<title>Atualização de Evento</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="../header.jsp" />
	
	<div class="container-fluid">
		<div class="card-image" id="box01">
			<img src="https://via.placeholder.com/110x150"/>
			<span>Carlos Maria Aparecido</span>
			<h4 style="margin-right: 5px">Convidados</h4>
			<input type="number" min="0" style="margin-right: 10px">
			<a href="" class="btn btn-primary add-button">Adicionar</a>
		</div>
		<div class="card-image" id="box01 add-button">
			<img src="https://via.placeholder.com/110x150"/>
			<span>Márcia Rosatto</span>
			<h4 style="margin-right: 5px">Convidados</h4>
			<input type="number" min="0" style="margin-right: 10px">
			<a href="" class="btn btn-primary add-button">Adicionar</a>
		</div>
		<div class="card-image" id="box01">
			<img src="https://via.placeholder.com/110x150"/>
			<span>Leila Morrone</span>
			<h4 style="margin-right: 5px">Convidados</h4>
			<input type="number" min="0" style="margin-right: 10px">
			<a href="" class="btn btn-primary add-button">Adicionar</a>
		</div>
		<div class="card-image" id="box01">
			<img src="https://via.placeholder.com/110x150"/>
			<span><a href="consulta-participante.jsp">Caique Ribeiro Rodrigues</a></span>
			<h4 style="margin-right: 5px">Convidados</h4>
			<input type="number" min="0" style="margin-right: 10px">
			<a href="" class="btn btn-primary add-button">Adicionar</a>
		</div>
		
		<a id="voltar-button" class="btn btn-primary" href="/gestao-eventos-web/evento/consultar?evt-id=28&editar=true&locacao=1&logradouro=1&operacao=CONSULTAR">Selecionar Participantes</a>
	</div>
	
	<script src="../bootstrap/js/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="../bootstrap/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="../js/participantes.js"></script>
</body>
</html>