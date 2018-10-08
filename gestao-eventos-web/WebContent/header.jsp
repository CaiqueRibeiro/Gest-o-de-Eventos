<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <meta charset="utf-8">
<nav class="navbar navbar-expand-lg navbar-dark bg-primary shadow p-3 mb-5">
  <a class="navbar-brand" href="/gestao-eventos-web/index.jsp">Eventos</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/gestao-eventos-web/index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true">
          Eventos
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/gestao-eventos-web/evento/cadastro-evento.jsp">Cadastrar</a>
          <a class="dropdown-item" href="/gestao-eventos-web/evento/consultar?operacao=CONSULTAR&editar=false">Meu Eventos</a>
          <a class="dropdown-item" href="/gestao-eventos-web/evento/eventos-como-participante.jsp">Eventos Como Convidado</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true">
          Locações
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/gestao-eventos-web/locacoes/cadastro-locacao.jsp">Cadastrar Locação</a>
          <a class="dropdown-item" href="/gestao-eventos-web/locacoes/lista-locacoes.jsp">Lista de Locações</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true">
          Participantes
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/gestao-eventos-web/participantes/cadastro-participante.jsp">Cadastrar Participante</a>
          <a class="dropdown-item" href="/gestao-eventos-web/participantes/consultar?operacao=CONSULTAR&editar=false">Lista de Participantes</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true">
          Produtos e Estoque
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/gestao-eventos-web/produtos/consultar?operacao=CONSULTAR&editar=false">Lista Produtos</a>
          <a class="dropdown-item" href="/gestao-eventos-web/produtos/cadastro-produto.jsp">Cadastrar Novo Produto</a>
          <a class="dropdown-item" href="/gestao-eventos-web/participantes/lista-participantes.jsp">Consulta de Estoque</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true">
          Relatórios
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/gestao-eventos-web/relatorios/eventos.jsp">Eventos</a>
          <a class="dropdown-item" href="/gestao-eventos-web/relatorios/participantes.jsp">Participantes</a>
          <a class="dropdown-item" href="/gestao-eventos-web/relatorios/locacoes.jsp">Locações</a>
          <a class="dropdown-item" href="/gestao-eventos-web/relatorios/estoque.jsp">Produtos</a>
        </div>
      </li>                
    </ul>
    <form class="form-inline my-2 my-lg-0">
   
      <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Logout</button>
    </form>
  </div>
</nav>