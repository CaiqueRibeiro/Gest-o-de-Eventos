<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="../css/visual.css"/>
<link type="text/css" rel="stylesheet" href="../css/relatorios.css"/>
<title>Relatórios - ITENS PARA EVENTOS</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="../header.jsp" />
	<div class="container container-grafico">
	<select id="opt-meses" class='lista-opcoes'>
 			<option value='1' id="entradas">Entradas</option>
			<option value='2' id="saídas">Saídas</option>
        </select>
		<canvas id="myChart"></canvas>
	</div>


	<script src="../bootstrap/js/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="../bootstrap/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="../js/visual.js"></script>
    <script type="text/javascript" src="../chart/dist/Chart.bundle.min.js"></script>
<script>
var ctx = document.getElementById("myChart");
var MONTHS = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
var myChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: MONTHS,
        datasets: [{
            label: 'MÉDIA DE ENTRADAS E SAÍDAS NO ESTOQUE',
            data: [300, 201, 340, 49, 126, 413, 250, 383, 328, 507, 116, 95],
            backgroundColor: [
                'rgba(255, 99, 132, 0)',
            ],
            borderColor: [
                'rgba(255,99,132,1)'
            ],
            borderWidth: 3
        }, {
            label: 'MÉDIA DE PRODUTOS PERECIVEIS',
            yAxisID: 'B',
            data: [302, 101, 300, 40, 146, 313, 280, 303, 328, 510, 100, 100],
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