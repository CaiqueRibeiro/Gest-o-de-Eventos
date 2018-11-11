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
	<div class="container container-grafico" id="container-grafico">

	<div class="form-row">
		<div class="form-group col-md-6">	
			<select class="seletores form-control" id="selecao-inicio">
			    <option value="1">Janeiro</option>
			    <option value="2">Fevereiro</option>
			    <option value="3">Março</option>
			    <option value="4">Abril</option>
			    <option value="5">Maio</option>
			    <option value="6">Junho</option>
			    <option value="7">Julho</option>
			    <option value="8">Agosto</option>
			    <option value="9">Setembro</option>
			    <option value="10">Outubro</option>
			    <option value="11">Novembro</option>
			    <option value="12">Dezembro</option>
			</select>
		</div>
		<div class="form-group col-md-6">
			<select class="seletores form-control" id="selecao-fim">
			    <option value="1">Janeiro</option>
			    <option value="2">Fevereiro</option>
			    <option value="3">Março</option>
			    <option value="4">Abril</option>
			    <option value="5">Maio</option>
			    <option value="6">Junho</option>
			    <option value="7">Julho</option>
			    <option value="8">Agosto</option>
			    <option value="9">Setembro</option>
			    <option value="10">Outubro</option>
			    <option value="11">Novembro</option>
			    <option value="12">Dezembro</option>
			</select>
		</div>
	</div>
	
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

let inicio = document.querySelector("#selecao-inicio")
let fim = document.querySelector("#selecao-fim")
let param1 = []
let param2 = []


var ctx = document.getElementById("myChart");
var MONTHS = ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'];
var mesesSelecionados = []

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

window.onload = criaGrafico(MONTHS, dadosA, dadosB)

let valorInicial = 0;

inicio.onchange = e => {
    valorInicial = e.target.value
    let ind = parseInt(valorInicial)

    mesesSelecionados[0] = MONTHS[ind-1]
    param1[0] = dadosA[ind-1]
    param2[0] = dadosB[ind-1]
}

fim.onchange = e => {
	let inicial = parseInt(valorInicial) - 1
	
    let indice = e.target.value
    let ind = parseInt(indice)
    
    for(let j = 1; j < dadosA.length; j++) {
    	
		mesesSelecionados[j] = null
        param1[j] = null
        param2[j] = null
    }
    	
	var ms = []
	ms[0] = mesesSelecionados[0]
	
	cont = 1
	for(let i = inicial+1; i < ind; i++,cont++) {
    	ms[cont] = MONTHS[i]
        param1[cont] = dadosA[i]
		param2[cont] = dadosB[i]
    }    
		
    criaGrafico(ms, param1,param2)
}

function criaGrafico(meses, dadoA, dadoB) {
	
	ctx.parentNode.removeChild(ctx)
	
	let container = document.querySelector("#container-grafico")
	let grafico = document.createElement("canvas")
	grafico.id = "myChart"
	container.appendChild(grafico)
	
	ctx = document.getElementById("myChart")


	new Chart(ctx, {
	    type: 'line',
	    data: {
	    		  labels: meses,
	    		  datasets: [{
	    		      label: "PRODUTOS PERECIVEIS",
	    		      fill: false,
	    		      lineTension: 0.1,
	    		      borderColor: 'rgba(255,99,132,1)', // The main line color
	    		      borderCapStyle: 'square',
	    		      borderDash: [], // try [5, 15] for instance
	    		      borderDashOffset: 0.0,
	    		      borderJoinStyle: 'miter',
	    		      pointBorderColor: "black",
	    		      pointBackgroundColor: "white",
	    		      pointBorderWidth: 1,
	    		      pointHoverRadius: 8,
	    		      pointHoverBackgroundColor: "yellow",
	    		      pointHoverBorderColor: "brown",
	    		      pointHoverBorderWidth: 2,
	    		      pointRadius: 4,
	    		      pointHitRadius: 10,
	    		      // notice the gap in the data and the spanGaps: true
	    		      data: dadoA,
	    		      spanGaps: true,
	    		    }, {
	    		      label: "PRODUTO NÃO PERECÍVEIS",
	    		      fill: false,
	    		      lineTension: 0.1,
	    		      borderColor: 'rgba(123, 144, 229, 1)', // The main line color
	    		      borderCapStyle: 'square',
	    		      borderDash: [], // try [5, 15] for instance
	    		      borderDashOffset: 0.0,
	    		      borderJoinStyle: 'miter',
	    		      pointBorderColor: "black",
	    		      pointBackgroundColor: "white",
	    		      pointBorderWidth: 1,
	    		      pointHoverRadius: 8,
	    		      pointHoverBackgroundColor: "yellow",
	    		      pointHoverBorderColor: "brown",
	    		      pointHoverBorderWidth: 2,
	    		      pointRadius: 4,
	    		      pointHitRadius: 10,
	    		      // notice the gap in the data and the spanGaps: false
	    		      data: dadoB,
	    		      spanGaps: false,
	    		    }
	
	    		  ]
	    		},
	    options: {
	        scales: {
	            yAxes: [{
	                ticks: {
	                    beginAtZero:true
	                },
	                scaleLabel: {
	                     display: true,
	                     fontSize: 20 
	                  }
	            }],
	          scaleLabel: {
	              display: true,
	              fontSize: 20 
	           }
	        }
	      }
	});
}
</script>

</body>
</html>