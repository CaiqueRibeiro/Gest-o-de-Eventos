<%@page import="dominio.evento.Evento"%>
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
<title>Atualização de Evento</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="../header.jsp" />
	
		<%
			Resultado listaLocacoes = (Resultado) getServletContext().getAttribute("listaLocacoes");
			List<IDominio> lista = listaLocacoes.getEntidades();	
			List<Locacao> locacoes = (List<Locacao>) (Object) lista;
			
			Evento evento = (Evento) request.getAttribute("resultado");
		%>
	
	<div class="container-fluid" style="justify-content: flex-end;">
		<div class="container-form">
			<h1>Atualização de Evento</h1>
			
			<form action="alterar">
				<input type="hidden" name="evt-id" id="evt-id" value="${resultado.getId()}">
				<input type="hidden" name="rat-id" value="${resultado.getRateio().getId()}">
				<input type="hidden" name="end-id" value="${resultado.getEndereco().getId()}">
			  <div class="form-row">
			    <div class="form-group col-md-10">
			    	<label for="nome">Nome do Evento</label>
			    	<input type="text" required=true class="form-control" name="nome" value="${resultado.getNome()}">
			    </div>
			    <div class="form-group col-md-2">
			      <label for="max-participantes">Participantes máximos</label>
			      <input type="number" min="1" required class="max-participantes form-control" name="max-participantes" value="${resultado.getQdtMaximaPessoas()}">
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-3">
			      <label for="categoria">Categoria</label>
			      <select class="genero form-control" name="categoria" id="categoria">
			      	<option value="1" ${resultado.getCategoria() == 1 ? "selected" : "" }>Aniversário</option>
			      	<option value="2" ${resultado.getCategoria() == 2 ? "selected" : "" }>Casamento</option>
			      	<option value="3" ${resultado.getCategoria() == 3 ? "selected" : "" }>Festa empresarial</option>
			      	<option value="4" ${resultado.getCategoria() == 4 ? "selected" : "" }>Show</option>
			      </select>
			    </div>
			    <div class="form-group col-md-3">
			      <label for="tipo-evento">Tipo do evento</label>
			      <select class="tipo-evento form-control" name="tipo-evento" id="tipo-evento">
			      	<option value="GRATUITO" ${resultado.getTipoPagamento().equals("GRATUITO") ? "selected" : ""}>GRATUITO</option>
			      	<option value="PAGO-ENTRADA" ${resultado.getTipoPagamento().equals("PAGO-ENTRADA") ? "selected" : ""}>COBRANÇA DE ENTRADA</option>
			      	<option value="PAGO-PRODUTO" ${resultado.getTipoPagamento().equals("PAGO-PRODUTO") ? "selected" : ""}>COBRANÇA POR PRODUTO</option>
			      </select>
			    </div>
			    <div class="form-group col-md-3">
			      <label for="data">Data</label>
			      <input type="date" required class="data form-control" name="data" value="${resultado.getData()}">
			    </div>
			    <div class="form-group col-md-3">
			      <label for="hora">Hora</label>
			      <input type="time" required class="hora form-control" name="hora" value="${resultado.getHora()}">
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-4">
			      <label for="valor-entrada">Valor de entrada</label>
			      <input type="number" min="0" step="0.01" required class="valor-entrada form-control" name="valor-entrada" value="${resultado.getEntrada()}">
			    </div>
			    <div class="form-group col-md-4">
			      <label for="inicio-rateio">Início do rateio</label>
			      <input type="date" required class="inicio-rateio form-control" name="inicio-rateio" value="${resultado.getRateio().getInicioRateio()}">
			    </div>
			    <div class="form-group col-md-4">
			      <label for="final-rateio">Final do rateio</label>
			      <input type="date" required class="final-rateio form-control" name="final-rateio" value="${resultado.getRateio().getFimRateio()}">
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
			      	<option value="<%=l.getId()%>" <%if (evento.getLocacao().getId() == l.getId()) {%> selected <%} %>><%=l.getNome() %></option>
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
				    <input type="text" required class="rua form-control" name="rua" value="${resultado.getEndereco().getRua() }">
				  </div>
				  <div class="form-group col-md-2">
				    <label for="bairro">Bairro</label>
				    <input type="text" required class="bairro form-control" name="bairro" value="${resultado.getEndereco().getBairro() }">
				  </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="logradouro">Logradouro</label>
			      <select class="logradouro form-control" name="logradouro">
			      	<option value="1" ${resultado.getEndereco().getLogradouro().equals("1") ? "selected" : "" }>Rua</option>
			      	<option value="2" ${resultado.getEndereco().getLogradouro().equals("2") ? "selected" : "" }>Avenida</option>
			      	<option value="3" ${resultado.getEndereco().getLogradouro().equals("3") ? "selected" : "" }>Alameda</option>
			      </select>
			    </div>
			    <div class="form-group col-md-4">
					<label for="cep">CEP</label>
					<input type="text" required class="cep form-control" name="cep" value="${resultado.getEndereco().getCEP() }">
			    </div>
			    <div class="form-group col-md-2">
			      <label for="numero">Número</label>
			      <input type="text" required class="numero form-control" name="numero" value="${resultado.getEndereco().getNumero() }">
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-2">
			      <label for="cidade">Cidade</label>
			      <input type="text" required class="cidade form-control" name="cidade" value="${resultado.getEndereco().getCidade() }">
			    </div>
			    <div class="form-group col-md-2">
			      <label for="estado">Estado</label>
			      <input type="text" required class="estado form-control" name="estado" value="${resultado.getEndereco().getEstado() }">
			    </div>
			    <div class="form-group col-md-3">
			      <label for="situacao">Situação</label>
			      <select class="logradouro form-control" name="situacao">
			      	<option value="AGENDADO" ${resultado.getSituacao().equals("AGENDADO") ? "selected" : ""}>AGENDADO</option>
			      	<option value="FINALIZADO" ${resultado.getSituacao().equals("FINALIZADO") ? "selected" : ""}>FINALIZADO</option>
			      	<option value="CANCELADO" ${resultado.getSituacao().equals("CANCELADO") ? "selected" : ""}>CANCELADO</option>
			      	<option value="ADIADO" ${resultado.getSituacao().equals("ADIADO") ? "selected" : ""}>ADIADO</option>
			      </select>
			    </div>
			  </div>
			  <br/>
			  <button type="submit" required name="operacao" class="btn btn-primary" value="ATUALIZAR">ATUALIZAR</button>
			  <a href="/gestao-eventos-web/evento/consultar-participantes?operacao=CONSULTAR&evtid=${resultado.getId()}" id="add-participantes" class="btn btn-success">Adicionar Participantes</a>
			  <a href="/gestao-eventos-web/evento/participantes-evento?operacao=CONSULTAR&evtid=${resultado.getId()}" class="btn btn-success">Ver Participantes</a>
			  <a href="" class="btn btn-primary">Gerir Estoque</a>
			  <a href="excluir?&operacao=EXCLUIR&evt-id=${resultado.getId()}&rat-id=${resultado.getRateio().getId()}&end-id=${resultado.getEndereco().getId()}" class="btn btn-danger">EXCLUIR</a>
			</form>
		</div>
	</div>
	
	<script src="../bootstrap/js/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="../bootstrap/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="../js/visual.js"></script>
</body>
</html>