<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="css/visual.css"/>
<link type="text/css" rel="stylesheet" href="css/login.css"/>

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<title>Login - Gestão de Eventos Fechados</title>
</head>
<body>
		
	<div class="container-fluid" style="justify-content: flex-end;">
		<div class="container-form-login">
			<h1 class="text-center">Login</h1>
			
			<form action="login">
			  <div class="form-row">
			    <div class="form-group col-md-12">
			    	<label for="nome">Nome</label>
			    	<input type="text" class="form-control" name="email" required placeholder="Email">
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-12">
			      <label for="telefone">Senha</label>
			      <input type="password" required class="telefone form-control" name="senha" placeholder="Senha">
			    </div>
			  </div>
			  <br/>
			  <div class="login-buttons">
			  	<input type="submit" name="operacao" class="btn btn-primary" value="CONSULTAR">
			  	<a href="index.jsp" name="operacao" class="btn btn-danger" value="CONSULTAR">ESQUECI A SENHA</a>
			  </div>
			</form>
		</div>
	</div>

	<script src="bootstrap/js/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="bootstrap/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="js/visual.js"></script>
</body>
</html>