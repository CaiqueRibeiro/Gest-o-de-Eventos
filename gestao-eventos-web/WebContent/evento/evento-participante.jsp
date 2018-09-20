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
			<h1>Aniversário do Zé</h1>
			<br>
			
			<form action="consultar">
			<input type="hidden" name="editar" value="true">
			
			  <div class="form-row">
			    <div class="form-group col-md-10">
			    	<label for="nome">Nome do Evento</label>
			    	<p name="nome">Aniversário do Zé</p>
			    </div>
			    <div class="form-group col-md-2">
			      <label for="max-participantes">Participantes máximos</label>
			      <p name="max-participantes">200</p>
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="categoria">Categoria</label>
				  <p class="categoria" id="categoria">Aniversário</p>
			    </div>
			    <div class="form-group col-md-3">
			      <label for="data">Data</label>
			      <p class="data" id="data">15/09/2018</p>
			    </div>
			    <div class="form-group col-md-3">
			      <label for="hora">Hora</label>
			      <p>08:00 PM</p>
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-4">
			      <label for="valor-total">Valor Total</label>
			      <p class="valor-total" id="valor-total">R$ 4000</p>
			    </div>
			    <div class="form-group col-md-4">
			      <label for="inicio-rateio">Início do rateio</label>
			      <p class="inicio-rateio" id="inicio-rateio">01/08/2018</p>
			    </div>
			    <div class="form-group col-md-4">
			      <label for="final-rateio">Final do rateio</label>
			      <p class="inicio-rateio" id="inicio-rateio">03/09/2018</p>
			    </div>
			  </div>
			  <div class="form-row">
				<div class="form-group col-md-12">
			  		<label for="locacao">Locação</label>
			  		<select class="genero form-control" readonly name="locacao">
			      		<option value="1" selected>Zezinho Festas</option>
			      		<option value="2">Residência Secreta da Maçonaria</option>
			      		<option value="3">Salão de Festas - Apartamento Boulevard</option>
			      	</select>
			 	</div>
			  </div>
			  <div class="form-row">
				  <div class="form-group col-md-10">
				    <label for="rua">Rua</label>
				    <p name="rua">Nove de Julho</p>
				  </div>
				  <div class="form-group col-md-2">
				    <label for="bairro">Bairro</label>
				    <p name="bairro">Centro</p>
				  </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="logradouro">Logradouro</label>
			      <select class="logradouro form-control" readonly name="logradouro">
			      	<option value="1">Rua</option>
			      	<option value="2" selected>Avenida</option>
			      	<option value="3">Alameda</option>
			      </select>
			    </div>
			    <div class="form-group col-md-4">
					<label for="cep">CEP</label>
					<p name="cep">05450-251</p>
			    </div>
			    <div class="form-group col-md-2">
			      <label for="numero">Número</label>
			      <p name="numero">99</p>
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-2">
			      <label for="cidade">Cidade</label>
			      <p name="cidade">Poá</p>
			    </div>
			    <div class="form-group col-md-2">
			      <label for="estado">Estado</label>
			      <p name="estado">São Paulo</p>
			    </div>
			  </div>
			  <br/>
			  <a href="sucesso.jsp" class="btn btn-primary" value="SAIR DO EVENTO">SAIR DO EVENTO</a>
			</form>
		</div>
	</div>
	
	<script src="../bootstrap/js/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="../bootstrap/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="../js/visual.js"></script>
</body>
</html>