<%@page import="dominio.endereco.Locacao"%>
<%@page import="dominio.evento.IDominio"%>
<%@page import="java.util.List"%>
<%@page import="classes.util.Resultado"%>
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
	
	<%
		Resultado resultado = (Resultado) getServletContext().getAttribute("listaLocacoes");
		List<IDominio> lista = resultado.getEntidades();	
		List<Locacao> locacoes = (List<Locacao>) (Object) lista;
	%>
		<div class="container-form">
			<h1>Cadastro de Evento</h1>
			
			<form action="salvar">
			  <div class="form-row">
			    <div class="form-group col-md-10">
			    	<input type="hidden" name="situacao" value="AGENDADO">
			    	<label for="nome">Nome do Evento</label>
			    	<input type="text" class="form-control" name="nome" required placeholder="Nome do evento">
			    </div>
			    <div class="form-group col-md-2">
			      <label for="max-participantes">Participantes máximos</label>
			      <input type="number" class="max-participantes form-control" required min="1" name="max-participantes" placeholder="ex. 100, 5000">
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="categoria">Categoria</label>
			      <select class="categoria form-control" name="categoria" id="categoria">
			      	<option value="1">Aniversário</option>
			      	<option value="2">Casamento</option>
			      	<option value="3">Festa empresarial</option>
			      	<option value="4">Show</option>
			      </select>
			    </div>
			    <div class="form-group col-md-3">
			      <label for="data">Data</label>
			      <input type="date" required class="data form-control" name="data">
			    </div>
			    <div class="form-group col-md-3">
			      <label for="hora">Hora</label>
			      <input type="time" required class="hora form-control" name="hora">
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-4">
			      <label for="porcentagem-lucro">Porcentagem de lucro / entrada</label>
			      <input type="number" required class="porcentagem-lucro form-control" min="0" id="porcentagem-lucro" name="porcentagem-lucro">
			    </div>
			    <div class="form-group col-md-4">
			      <label for="inicio-rateio">Início do rateio</label>
			      <input type="date" required class="inicio-rateio form-control" name="inicio-rateio">
			    </div>
			    <div class="form-group col-md-4">
			      <label for="final-rateio">Final do rateio</label>
			      <input type="date" required class="final-rateio form-control" name="final-rateio">
			    </div>
			  </div>
			  <div class="form-row">
				<div class="form-group col-md-12">
			  		<label for="locacao">Locação</label>
			  		<select class="genero form-control" name="locacao">
			      <%
			      if(locacoes != null) {
			    	for(Locacao l : locacoes) {  			      
			      %>
			      	<option value="<%=l.getId()%>"><%=l.getNome() %></option>
					<%
			    	}
			      }
					%>
			      	</select>
			 	</div>
			  </div>
			  <div class="form-row">
				  <div class="form-group col-md-10">
				    <label for="rua">Rua</label>
				    <input type="text" required class="rua form-control" name="rua" placeholder="ex. Nove de Julho">
				  </div>
				  <div class="form-group col-md-2">
				    <label for="bairro">Bairro</label>
				    <input type="text" required class="bairro form-control" name="bairro" placeholder="ex. centro">
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
					<input type="text" required class="cep form-control" name="cep" placeholder="XXXXX-XXX">
			    </div>
			    <div class="form-group col-md-2">
			      <label for="numero">Número</label>
			      <input type="text" required class="numero form-control" name="numero" placeholder="ex. 348, 193, 45">
			    </div>
			  </div>
			  <div class="form-row" id="cidade-estado">
			    <div class="form-group col-md-2">
			      <label for="cidade">Cidade</label>
			      <input type="text" required class="cidade form-control" name="cidade" id="cidade" placeholder="ex. Poá, Suzano, Mogi das Cruzes">
			    </div>
			    <div class="form-group col-md-2">
			      <label for="estado">Estado</label>
			      <input type="text" required class="estado form-control" name="estado" placeholder="ex. São Paulo, Rio Grande do Sul, Paraná">
			    </div>
			  </div>
			  <br/>
			  <input type="submit" name="operacao" class="btn btn-primary" value="SALVAR">
			</form>
		</div>
	</div>
	
	<script src="../bootstrap/js/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="../bootstrap/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="../js/visual.js"></script>
</body>
</html>