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
		<div class="container-form">
			<h1>${resultado.getNome()}</h1>
			<br>
			
			<form action="consultar">
			<input type="hidden" name="evt-id" value="${resultado.getId()}">
			<input type="hidden" name="editar" value="true">
			
			  <div class="form-row">
			    <div class="form-group col-md-10">
			    	<label for="nome">Nome do Evento</label>
			    	<p name="nome">${resultado.getNome()}</p>
			    </div>
			    <div class="form-group col-md-2">
			      <label for="max-participantes">Participantes máximos</label>
			      <p name="max-participantes">${resultado.getQdtMaximaPessoas()}</p>
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="categoria">Categoria</label>
				  <p class="categoria" id="categoria">${resultado.getCatNome()}</p>
			    </div>
			    <div class="form-group col-md-3">
			      <label for="data">Data</label>
			      <p class="data" id="data">${resultado.getData()}</p>
			    </div>
			    <div class="form-group col-md-3">
			      <label for="hora">Hora</label>
			      <p class="hora" id="hora">${resultado.getHora()}</p>
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-4">
			      <label for="valor-total">Valor Total</label>
			      <p class="valor-total" id="valor-total">R$ ${resultado.getRateio().getValorPagar()}</p>
			    </div>
			    <div class="form-group col-md-4">
			      <label for="inicio-rateio">Início do rateio</label>
			      <p class="inicio-rateio" id="inicio-rateio">${resultado.getRateio().getInicioRateio()}</p>
			    </div>
			    <div class="form-group col-md-4">
			      <label for="final-rateio">Final do rateio</label>
			      <p class="inicio-rateio" id="inicio-rateio">${resultado.getRateio().getFimRateio()}</p>
			    </div>
			  </div>
			  <div class="form-row">
				<div class="form-group col-md-12">
			  		<label for="locacao">Locação</label>
			  		<p class="locacao" name="locacao">
						${resultado.getLocacao().getNome()}
			      	</p>
			 	</div>
			  </div>
			  <div class="form-row">
				  <div class="form-group col-md-10">
				    <label for="rua">Rua</label>
				    <p name="rua">${resultado.getEndereco().getRua() }</p>
				  </div>
				  <div class="form-group col-md-2">
				    <label for="bairro">Bairro</label>
				    <p name="bairro">${resultado.getEndereco().getBairro() }</p>
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
					<p name="cep">${resultado.getEndereco().getCEP() }</p>
			    </div>
			    <div class="form-group col-md-2">
			      <label for="numero">Número</label>
			      <p name="numero">${resultado.getEndereco().getNumero() }</p>
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-2">
			      <label for="cidade">Cidade</label>
			      <p name="cidade">${resultado.getEndereco().getCidade() }</p>
			    </div>
			    <div class="form-group col-md-2">
			      <label for="estado">Estado</label>
			      <p name="estado">${resultado.getEndereco().getEstado() }</p>
			    </div>
			    <div class="form-group col-md-3">
			      <label for="logradouro">Situação</label>
			      	<p name="situacao">AGENDADO</P>
			    </div>
			  </div>
			  <br/>
			  <input type="submit" class="btn btn-primary" value="ALTERAR DADOS">
			  <a href="rateio-evento.jsp" class="btn btn-success">RATEIO DO EVENTO</a>
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