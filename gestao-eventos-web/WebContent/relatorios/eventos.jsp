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
var ctx = document.getElementById("myChart");
var MONTHS = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
var myChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: MONTHS,
        datasets: [{
            label: 'EVENTOS CONCLUÍDOS',
            data: [12, 19, 3, 5, 2, 3, 9, 15, 8, 19, 10, 9],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255,99,132,1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero:true
                }
            }]
        }
    }
});
</script>

</body>
</html>