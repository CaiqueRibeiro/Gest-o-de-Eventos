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
			<h1>Cadastro de Participante</h1>
			
			<form action="alterar">
				<input type="hidden" name="part-id" value="${resultado.getId()}">
				<input type="hidden" name="end-id" value="${resultado.getEndereco().getId()}">
			  <div class="form-row">
			    <div class="form-group col-md-12">
			    	<label for="nome">Nome</label>
			    	<input type="text" class="form-control" name="nome" required value="${resultado.getNome()}">
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-10">
			    	<label for="email">E-mail</label>
			    	<input type="text" class="form-control" name="email" required value="${resultado.getEmail()}">
			    </div>
			    <div class="form-group col-md-2">
			      <label for="telefone">Telefone</label>
			      <input type="text" required class="telefone form-control" name="telefone" value="${resultado.getTelefone()}">
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="genero">Gênero</label>
			      <select class="genero form-control" name="genero">
			      	<option value="1" selected>Masculino</option>
			      	<option value="2">Feminino</option>
			      </select>
			    </div>
			    <div class="form-group col-md-3">
			      <label for="data">Data de Nascimento</label>
			      <input type="date" required class="data form-control" name="data" value="${resultado.getDtNascimento()}">
			    </div>
			    <div class="form-group col-md-3">
			      <label for="porcentagem-lucro">CPF</label>
			      <input type="text" required class="porcentagem-lucro form-control" name="cpf" value="${resultado.getCpf()}">
			    </div>
			  </div>
			  <div class="form-row">
				  <div class="form-group col-md-10">
				    <label for="rua">Rua</label>
				    <input type="text" required class="rua form-control" name="rua" value="${resultado.getEndereco().getRua()}">
				  </div>
				  <div class="form-group col-md-2">
				    <label for="bairro">Bairro</label>
				    <input type="text" required class="bairro form-control" name="bairro" value="${resultado.getEndereco().getBairro()}">
				  </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="logradouro">Logradouro</label>
			      <select class="logradouro form-control" name="logradouro">
			      	<option value="1" selected>Rua</option>
			      	<option value="2">Avenida</option>
			      	<option value="3">Alameda</option>
			      </select>
			    </div>
			    <div class="form-group col-md-4">
					<label for="cep">CEP</label>
					<input type="text" required class="cep form-control" name="cep" value="${resultado.getEndereco().getCEP()}">
			    </div>
			    <div class="form-group col-md-2">
			      <label for="numero">Número</label>
			      <input type="text" required class="numero form-control" name="numero" value="${resultado.getEndereco().getNumero()}">
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-2">
			      <label for="cidade">Cidade</label>
			      <input type="text" required class="cidade form-control" name="cidade" value="${resultado.getEndereco().getCidade()}">
			    </div>
			    <div class="form-group col-md-2">
			      <label for="estado">Estado</label>
			      <input type="text" required class="estado form-control" name="estado" value="${resultado.getEndereco().getEstado()}">
			    </div>
			  </div>
			  <br/>
			  <button type="submit" required name="operacao" class="btn btn-primary" value="ATUALIZAR">ATUALIZAR</button>
			  <a href="excluir?&operacao=EXCLUIR&part-id=${resultado.getId()}&end-id=${resultado.getEndereco().getId()}" class="btn btn-danger">EXCLUIR</a>
			</form>
		</div>
	</div>
	
	<script src="../bootstrap/js/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="../bootstrap/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="../js/visual.js"></script>
</body>
</html>