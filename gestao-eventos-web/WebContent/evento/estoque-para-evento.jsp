<%@page import="dominio.produto.ItemProduto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="../css/visual.css"/>
<link type="text/css" rel="stylesheet" href="../css/participantes.css"/>


<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<title>Produtos para o evento</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="../header.jsp" />
	
	<div class="container-fluid">		
	<%
	
	List<ItemProduto> resultado = (List<ItemProduto>) request.getAttribute("resultado");
	
	if(resultado != null) {
		  
	  	for(ItemProduto itc : resultado) {	
	%>
		<div class="card-image" id="box<%=itc.getProduto().getId()%>">
			<input type="hidden" name="id" class="id" id="id" value="<%=itc.getProduto().getId()%>">
			<span><%=itc.getProduto().getNome()%></span>
			<span><%=itc.getQuantidade()%></span>
			<input style="width: 5em; margin-right: 5%" type="number" name="qtd-produto-rateio" id="number-<%=itc.getProduto().getId()%>" min="1" max="<%=itc.getQuantidade()%>" class="form-control qtd-produto-rateio">
			<button type="button" id="input-levar-produto" id="<%=itc.getProduto().getId() %>" style="margin-right: 1%" value="<%=itc.getProduto().getId() %>" class="btn btn-primary btn-add-estoque">ADICIONAR</button>		
		</div>
		<%
		  	}
		}
		%>	

		<a id="ver-estoque" class="btn btn-primary" href="../evento/estoque-evento?operacao=CONSULTAR&evtid=${param.evtid}">Ver produtos já adicionados</a><br/>		
		<a id="add-estoque" class="btn btn-success" href="../evento/estoque-evento?operacao=SALVAR&evt-id=${param.evtid}&">Atualizar Estoque Evento</a><br/>
	</div>
	
	<script src="../bootstrap/js/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="../bootstrap/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="../js/estoque.js"></script>
</body>
</html>