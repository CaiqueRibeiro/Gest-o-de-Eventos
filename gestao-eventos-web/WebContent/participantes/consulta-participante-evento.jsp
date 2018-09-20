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
<title>Cadastro de participante</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="../header.jsp" />
	
	<div class="container-fluid" style="justify-content: flex-end;">
		<div class="container-form">
			
			<form action="salvar">
			  <div class="form-row">
			    <div class="form-group col-md-10">
			    	<label for="nome">Nome</label>
			    	<p name="nome">Caique Ribeiro</p>
			    </div>
			    <div class="form-group col-md-2">
			      <label for="telefone">Telefone</label>
			      <p id="telefone">4638-3846</p>
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="categoria">Gênero</label>
					<p>Masculino</p>
			    </div>
			    <div class="form-group col-md-3">
			      <label for="data">Data de Nascimento</label>
			      <p>12/05/1994</p>
			    </div>
			    <div class="form-group col-md-3">
			      <label for="porcentagem-lucro">CPF</label>
			      <p>442.494.768-80</p>
			    </div>
			  </div>
			  <div class="form-row">
				  <div class="form-group col-md-10">
				    <label for="rua">Rua</label>
				    <p>Rua Hermógenes Lá Regina</p>
				  </div>
				  <div class="form-group col-md-2">
				    <label for="bairro">Bairro</label>
				    <p>Centro</p>
				  </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="logradouro">Logradouro</label>
				  <p>Rua</p>
			    </div>
			    <div class="form-group col-md-4">
					<label for="cep">CEP</label>
					<p>08220-230</p>
			    </div>
			    <div class="form-group col-md-2">
			      <label for="numero">Número</label>
			      <p>348</p>
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-2">
			      <label for="cidade">Cidade</label>
			      <p>Poá</p>
			    </div>
			    <div class="form-group col-md-2">
			      <label for="estado">Estado</label>
				  <p>São Paulo</p>
			    </div>
			  </div>
			  <br/>
			  <a href="seleciona-participantes.jsp" class="btn btn-primary">VOLTAR</a>
			</form>
		</div>
	</div>
	
	<script src="../bootstrap/js/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="../bootstrap/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="../js/visual.js"></script>
</body>
</html>