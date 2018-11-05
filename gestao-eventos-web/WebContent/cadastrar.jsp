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
<title>Cadastro no Sistema</title>
</head>
<body>
		
	<div class="container-fluid" style="justify-content: flex-end;">
		<div class="container-form-login" style="width: 60% !important; margin-top: 5%; margin-bottom: 5%; padding: 2%">
			<h1 class="text-center">Cadastro</h1>
			
			<form action="cadastrar" method="post">
			  <div class="form-row">
			    <div class="form-group col-md-12">
			    	<label for="email">E-mail</label>
			    	<input type="text" required class="form-control" name="email" placeholder="ex: zeninguem@hotmail.com">
			    </div>
			    <div class="form-group col-md-12">
			    	<label for="email">Senha</label>
			    	<input type="password" required class="form-control" name="senha">
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-10">
			    	<label for="nome">Nome</label>
			    	<input type="text" required class="form-control" name="nome" placeholder="Nome inteiro do participante">
			    </div>
			    <div class="form-group col-md-2">
			      <label for="telefone">Telefone</label>
			      <input type="text" required class="telefone form-control" name="telefone">
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="genero">Gênero</label>
			      <select required class="genero form-control" name="genero">
			      	<option value="1">Masculino</option>
			      	<option value="2">Feminino</option>
			      </select>
			    </div>
			    <div class="form-group col-md-3">
			      <label for="data">Data de Nascimento</label>
			      <input type="date" required class="data form-control" name="data">
			    </div>
			    <div class="form-group col-md-3">
			      <label for="cpf">CPF</label>
			      <input type="number" required class="cpf form-control" min="0" name="cpf">
			    </div>
			  </div>
			  <div class="form-row">
				  <div class="form-group col-md-10">
				    <label for="rua">Rua</label>
				    <input type="text" required class="rua form-control" name="rua" placeholder="ex. Nove de Julho">
				  </div>
				  <div class="form-group col-md-2">
				    <label for="bairro">Bairro</label>
				    <input type="text" required class="bairro form-control" name="bairro" placeholder="ex. centro">
				  </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="logradouro">Logradouro</label>
			      <select class="logradouro form-control" required name="logradouro">
			      	<option value="1">Rua</option>
			      	<option value="2">Avenida</option>
			      	<option value="3">Alameda</option>
			      </select>
			    </div>
			    <div class="form-group col-md-4">
					<label for="cep">CEP</label>
					<input type="text" required class="cep form-control" name="cep" placeholder="XXXXX-XXX">
			    </div>
			    <div class="form-group col-md-2">
			      <label for="numero">Número</label>
			      <input type="text" required class="numero form-control" name="numero" placeholder="ex. 348, 193, 45">
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-2">
			      <label for="cidade">Cidade</label>
			      <input type="text" required class="cidade form-control" name="cidade" placeholder="ex. Poá, Suzano, Mogi das Cruzes">
			    </div>
			    <div class="form-group col-md-2">
			      <label for="estado">Estado</label>
			      <input type="text" required class="estado form-control" name="estado" placeholder="ex. São Paulo, Rio Grande do Sul, Paraná">
			    </div>
			  </div>
			  <br/>
				<input type="submit" name="operacao" class="btn btn-primary" value="SALVAR">
			</form>
		</div>
	</div>

	<script src="bootstrap/js/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="bootstrap/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="js/visual.js"></script>
</body>
</html>