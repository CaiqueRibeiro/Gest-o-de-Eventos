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
<title>Cadastro de locação</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="../header.jsp" />
	
	<div class="container-fluid" style="justify-content: flex-end;">
		<div class="container-form">
			<h1>Cadastro de Locação</h1>
			
			<form action="salvar">
			  <div class="form-row">
				  <div class="form-group col-md-10">
				    <label for="rua">Nome da Locação</label>
				    <input type="text" required class="rua form-control" name="nome">
				  </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="categoria">Acústica</label>
			      <select class="genero form-control" name="categoria">
			      	<option value="1">Sim</option>
			      	<option value="2">Não</option>
			      </select>
			    </div>
			    <div class="form-group col-md-6">
			      <label for="categoria">Aberto/Fechado</label>
			      <select class="genero form-control" name="categoria">
			      	<option value="1">Aberto</option>
			      	<option value="2">Fechado</option>
			      </select>
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-4">
			      <label for="porcentagem-lucro">Capacidade do Estacionamento</label>
			      <input type="number" required class="porcentagem-lucro form-control" min="0" name="porcentagem-lucro">
			    </div>
			  </div>
			  <br/>
			  <a href="lista-locacoes.jsp"class="btn btn-primary">SALVAR</a>
			</form>
		</div>
	</div>
	
	<script src="../bootstrap/js/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="../bootstrap/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="../js/visual.js"></script>
</body>
</html>