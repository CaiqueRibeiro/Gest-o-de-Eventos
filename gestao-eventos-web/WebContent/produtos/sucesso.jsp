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
<title>Operação Realizada Com Sucesso</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="../header.jsp" />
	<center><h1>Operação Realizada Com Sucesso</h1></center>
	<br>
	<center><a href="/gestao-eventos-web/produtos/consultar?operacao=CONSULTAR&editar=false" name="operacao" class="btn btn-success">Início</a></center>
	
	<script type="text/javascript" src="js/visual.js"></script>
	<script src="../bootstrap/js/bootstrap.min.js" ></script>
</body>
</html>