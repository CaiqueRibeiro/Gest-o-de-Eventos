<%@page import="dominio.participantes.Participante"%>
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
<title>Participantes do Evento</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="../header.jsp" />
	
	<div class="container-fluid">		
	<%
	
	List<Participante> resultado = (List<Participante>) request.getAttribute("resultado");
	
	if(resultado != null) {
		  
	  	for(Participante ptc : resultado) {	
	%>
		<div class="card-image" id="box01">
			<input type="hidden" name="id" class="id" id="id" value="<%=ptc.getId()%>">
			<span><%=ptc.getNome()%></span>
			<button type="button" value="<%=ptc.getId()%>" style="margin-right: 1%" class="btn btn-success pago-button">PAGO</button>
			<button type="button" value="<%=ptc.getId()%>" class="btn btn-danger add-button">Remover</button>	
		</div>
		<%
		  	}
		}
		%>
		<a id="add-pago-button" class="btn btn-success" href="/gestao-eventos-web/evento/participantes-evento?evt-id=${param.evtid}&operacao=ATUALIZAR&id=">Confirmar pagamento</a><br/>			
		<a id="add-participantes-button" class="btn btn-danger" href="/gestao-eventos-web/evento/participantes-evento?evt-id=${param.evtid}&operacao=EXCLUIR&id=">Excluir participantes</a>		
		<a id="voltar-button" class="btn btn-primary" href="/gestao-eventos-web/evento/consultar?evt-id=${param.evtid}&editar=true&operacao=CONSULTAR">Voltar ao evento</a>
	</div>
	
	<script src="../bootstrap/js/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="../bootstrap/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="../js/participantes.js"></script>
</body>
</html>