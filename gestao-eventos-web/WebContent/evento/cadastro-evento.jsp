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
<title>Cadastro de evento</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="../header.jsp" />
	
	<div class="container-fluid" style="justify-content: flex-end;">
		<div class="container-form">
			<h1>Cadastro de Evento</h1>
			
			<form action="salvar">
			  <div class="form-row">
			    <div class="form-group col-md-10">
			    	<input type="hidden" name="situacao" value="AGENDADO">
			    	<label for="nome">Nome do Evento</label>
			    	<input type="text" class="form-control" name="nome" placeholder="Nome do evento">
			    </div>
			    <div class="form-group col-md-2">
			      <label for="max-participantes">Participantes máximos</label>
			      <input type="text" class="max-participantes form-control" name="max-participantes" placeholder="ex. 100, 5000">
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="categoria">Categoria</label>
			      <select class="genero form-control" name="categoria">
			      	<option value="1">Aniversário</option>
			      	<option value="2">Casamento</option>
			      	<option value="3">Festa empresarial</option>
			      </select>
			    </div>
			    <div class="form-group col-md-3">
			      <label for="data">Data</label>
			      <input type="date" class="data form-control" name="data">
			    </div>
			    <div class="form-group col-md-3">
			      <label for="hora">Hora</label>
			      <input type="time" class="hora form-control" name="hora">
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-4">
			      <label for="porcentagem-lucro">Porcentagem de lucro</label>
			      <input type="text" class="porcentagem-lucro form-control" name="porcentagem-lucro">
			    </div>
			    <div class="form-group col-md-4">
			      <label for="inicio-rateio">Início do rateio</label>
			      <input type="date" class="inicio-rateio form-control" name="inicio-rateio">
			    </div>
			    <div class="form-group col-md-4">
			      <label for="final-rateio">Final do rateio</label>
			      <input type="date" class="final-rateio form-control" name="final-rateio">
			    </div>
			  </div>
			  <div class="form-row">
				<div class="form-group col-md-12">
			  		<label for="locacao">Locação</label>
			  		<select class="genero form-control" name="locacao">
			      		<option value="1">Zezinho Festas</option>
			      		<option value="2">Residência Secreta da Maçonaria</option>
			      		<option value="3">Salão de Festas - Apartamento Boulevard</option>
			      	</select>
			 	</div>
			  </div>
			  <div class="form-row">
				  <div class="form-group col-md-10">
				    <label for="rua">Rua</label>
				    <input type="text" class="rua form-control" name="rua" placeholder="ex. Nove de Julho">
				  </div>
				  <div class="form-group col-md-2">
				    <label for="bairro">Bairro</label>
				    <input type="text" class="bairro form-control" name="bairro" placeholder="ex. centro">
				  </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="logradouro">Logradouro</label>
			      <select class="logradouro form-control" name="logradouro">
			      	<option value="1">Rua</option>
			      	<option value="2">Avenida</option>
			      	<option value="3">Alameda</option>
			      </select>
			    </div>
			    <div class="form-group col-md-4">
					<label for="cep">CEP</label>
					<input type="text" class="cep form-control" name="cep" placeholder="XXXXX-XXX">
			    </div>
			    <div class="form-group col-md-2">
			      <label for="numero">Número</label>
			      <input type="text" class="numero form-control" name="numero" placeholder="ex. 348, 193, 45">
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-2">
			      <label for="cidade">Cidade</label>
			      <input type="text" class="cidade form-control" name="cidade" placeholder="ex. Poá, Suzano, Mogi das Cruzes">
			    </div>
			    <div class="form-group col-md-2">
			      <label for="estado">Estado</label>
			      <input type="text" class="estado form-control" name="estado" placeholder="ex. São Paulo, Rio Grande do Sul, Paraná">
			    </div>
			  </div>
			  <br/>
			  <input type="submit" name="operacao" class="btn btn-primary" value="SALVAR">
			</form>
		</div>
	</div>
	
	<script type="text/javascript" src="js/visual.js"></script>
	<script src="../bootstrap/js/bootstrap.min.js" ></script>
</body>
</html>