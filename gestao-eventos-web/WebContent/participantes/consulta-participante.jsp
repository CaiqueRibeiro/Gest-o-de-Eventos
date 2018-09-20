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
			
			<form action="consultar">
			<input type="hidden" name="part-id" value="${resultado.getId()}">
			<input type="hidden" name="editar" value="true">
			  <div class="form-row">
			    <div class="form-group col-md-10">
			    	<label for="nome">Nome</label>
			    	<p name="nome">${resultado.getNome()}</p>
			    </div>
			    <div class="form-group col-md-2">
			      <label for="telefone">Telefone</label>
			      <p id="telefone">${resultado.getTelefone()}</p>
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="categoria">Gênero</label>
					<p>${resultado.getGenero() == 1 ? "Masculino" : "Feminino" }</p>
			    </div>
			    <div class="form-group col-md-3">
			      <label for="data">Data de Nascimento</label>
			      <p>${resultado.getDtNascimento()}</p>
			    </div>
			    <div class="form-group col-md-3">
			      <label for="porcentagem-lucro">CPF</label>
			      <p>${resultado.getCpf()}</p>
			    </div>
			  </div>
			  <div class="form-row">
				  <div class="form-group col-md-10">
				    <label for="rua">Rua</label>
				    <p>${resultado.getEndereco().getRua()}</p>
				  </div>
				  <div class="form-group col-md-2">
				    <label for="bairro">Bairro</label>
				    <p>${resultado.getEndereco().getBairro()}</p>
				  </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="logradouro">Logradouro</label>
				  <p>
				      <c:choose>
				         <c:when test = "${resultado.getEndereco().getLogradouro() == 1}">
				            Rua
				         </c:when>
				         <c:when test = "${resultado.getEndereco().getLogradouro() == 2}">
				           Avenida
				         </c:when>			         
				         <c:when test = "${resultado.getEndereco().getLogradouro() == 3}">
				           Avenida
				         </c:when>				         
				         <c:otherwise>
				            NÃO ESPECIFICADO
				         </c:otherwise>
				      </c:choose>
				  </p>
			    </div>
			    <div class="form-group col-md-4">
					<label for="cep">CEP</label>
					<p>${resultado.getEndereco().getCEP()}</p>
			    </div>
			    <div class="form-group col-md-2">
			      <label for="numero">Número</label>
			      <p>${resultado.getEndereco().getNumero()}</p>
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-2">
			      <label for="cidade">Cidade</label>
			      <p>${resultado.getEndereco().getCidade()}</p>
			    </div>
			    <div class="form-group col-md-2">
			      <label for="estado">Estado</label>
				  <p>${resultado.getEndereco().getEstado()}</p>
			    </div>
			  </div>
			  <br/>
			  <input type="submit" class="btn btn-primary" value="ALTERAR DADOS">
			  <input type="hidden" name="operacao" class="btn btn-primary" value="CONSULTAR">
			</form>
		</div>
	</div>
	
	<script src="../bootstrap/js/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="../bootstrap/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="../js/visual.js"></script>
</body>
</html>