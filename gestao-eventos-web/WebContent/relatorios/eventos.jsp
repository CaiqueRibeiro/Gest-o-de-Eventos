<%@page import="dominio.relatorios.DadosRelatorio"%>
<%@page import="java.util.List"%>
<%@page import="dominio.relatorios.Relatorio"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="../css/visual.css"/>
<link type="text/css" rel="stylesheet" href="../css/relatorios.css"/>
<title>Relatórios - Eventos</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="../header.jsp" />
	<div class="container container-grafico">
	<select id="opt-meses" class='lista-opcoes'>
 <option value='NENHUM' id="janeiro">TODOS OS MESES</option>
			<option value='01' id="janeiro">Janeiro</option>
			<option value='02' id="fevereiro">Fevereiro</option>
			<option value='03' id="marco">Março</option>
			<option value='04' id="abril">Abril</option>
			<option value='05' id="maio">Maio</option>
			<option value='06' id="junho">Junho</option>
			<option value='07' id="julho">Julho</option>
			<option value='08' id="agosto">Agosto</option>
			<option value='09' id="setembro">Setembro</option>
			<option value='10' id="outubro">Outubro</option>
			<option value='11' id="novembro">Novembro</option>
			<option value='12' id="dezembro">Dezembro</option>
        </select>
		<canvas id="myChart"></canvas>
	</div>


	<script src="../bootstrap/js/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="../bootstrap/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="../js/visual.js"></script>
    <script type="text/javascript" src="../chart/dist/Chart.bundle.min.js"></script>
<script>

<% 

	Relatorio relatorio = (Relatorio) request.getAttribute("resultado");
	List<DadosRelatorio> linhaA = relatorio.getDadosA();
	List<DadosRelatorio> linhaB = relatorio.getDadosB();
%>
var ctx = document.getElementById("myChart");
var MONTHS = ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'];
var dadosA = [
	<%
	for(int i = 1; i <= 12; i++) {
		boolean flag = false;
		for(DadosRelatorio dados : linhaA) {
			if(dados.getChave().equals(String.valueOf(i))) {	
				flag = true;
				out.print(dados.getValor());
			%>,
				<% }
			}
			if(!flag) {
				%>
				0,
				<%
				}
		}
	%>
];


var dadosB = [
	<%
	for(int i = 1; i <= 12; i++) {
		boolean flag = false;
		for(DadosRelatorio dados : linhaB) {
			if(dados.getChave().equals(String.valueOf(i))) {	
				flag = true;
				out.print(dados.getValor());
			%>,
				<% }
			}
			if(!flag) {
				%>
				0,
				<%
				}
		}
	%>
];
var myChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: MONTHS,
        datasets: [{
            label: 'EVENTOS AGENDADOS',
            data: dadosA,
            backgroundColor: [
                'rgba(255, 99, 132, 0)',
            ],
            borderColor: [
                'rgba(255,99,132,1)'
            ],
            borderWidth: 3
        }, {
            label: 'EVENTOS ADIADOS',
            yAxisID: 'B',
            data: dadosB,
            backgroundColor: [
                'rgba(123, 144, 229, 0)'
            ],
            borderColor: [
                'rgba(123, 144, 229, 1)'
            ],
            borderWidth: 3
        }]
    },
    options: {
        scales: {
          yAxes: [{
            id: 'A',
            type: 'linear',
            position: 'left',
          }, {
            id: 'B',
            type: 'linear',
            position: 'right',
            ticks: {
            	beginAtZero: true
            }
          }]
        }
      }
});
</script>

</body>
</html>