<%@page import="dominio.produto.Fornecedor"%>
<%@page import="dominio.produto.Produto"%>
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
<title>Atualização de Estoque</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="../header.jsp" />
	
	<div class="container-fluid" style="justify-content: flex-end;">
		<div class="container-form">
			<h1>Atualização de Estoque</h1>
			
			<form action="salvar">
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="pdt-id">Produto</label>
			      <select class="form-control" name="pdt-id" id="pdt-id">
			      	<option value="${resultado.getProduto().getId() }">${resultado.getProduto().getNome()}</option>
			      </select>
			    </div>
			    <div class="form-group col-md-6">
			      <label for="fnc-id">Fornecedor</label>
			      <select class="form-control" name="fnc-id" id="fnc-id">
			      	<option value="${resultado.getFornecedor().getId() }">${resultado.getFornecedor().getNome()}</option>
			      </select>
			    </div>
			    </div>
			  <div class="form-row">
			    <div class="form-group col-md-4">
			      <label for="data">Data de validade</label>
			      <input type="date" class="data form-control" value="${resultado.getDtValidade()}" name="dt-validade">
			    </div>
			    <div class="form-group col-md-4">
			      <label for="preco">Preco unitário</label>
			      <input type="number" step="0.01" min="0" required class="preco form-control"  value="${resultado.getPreco()}" name="preco">
			    </div>
			    <div class="form-group col-md-4">
			      <label for="quantidade">Quantidade</label>
			      <input type="number" step="0.01" min="0" required class="preco form-control" value="${resultado.getQuantidade()}" name="quantidade">
			    </div>
			  </div>
			  <br/>
			  <input type="submit" name="operacao" class="btn btn-primary" value="ATUALIZAR">
			</form>
		</div>
	</div>
	
	<script src="../bootstrap/js/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="../bootstrap/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="../js/visual.js"></script>
</body>
</html>