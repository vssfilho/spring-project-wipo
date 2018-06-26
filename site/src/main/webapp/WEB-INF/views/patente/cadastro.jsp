<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="/WEB-INF/views/common/common-libs.jsp" />
<script src="./resources/js/controller/patente/cadastro_patente.js"></script>
<head>
<title>Controle de Patente</title>
</head>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Controle de Patente</a>
		</div>
	</div>
</nav>

<div class="jumbotron">
	<div class="container">
		<h4>Buscar patente para cadastro</h4>
		<div class="input-group mb-3">
			<input type="text" class="form-control" id="numero_patente"
				placeholder="Número da patente" aria-label="Número da patente"
				aria-describedby="basic-addon2">
			<div class="input-group-append">
				<button class="btn btn-outline-secondary" type="button" id="buscar_patente">Buscar</button>
			</div>
		</div>
	</div>
</div>

<div class="container">
	<div class="card" id="mensagem">
		<div class="card-body"><p class="card-text" id="texto"></p></div>
	</div>
	<div class="card" id="dados_patente">
		<h5 class="card-header">Cadastrar patente</h5>
		<div class="card-body">
			<p class="card-text"><div class="font-weight-bold">Nº de pub:</div> <span id="nro_pub"></span></p>
			<p class="card-text"><div class="font-weight-bold">Nº do pedido internacional:</div> <span id="nro_pedido_internacional"></span></p>
			<p class="card-text"><div class="font-weight-bold">Data de publicação:</div> <span id="data_publicacao"></span></p>
			<p class="card-text font-weight-bold">Requerentes:</p>
			<p>
				<ul class="list-group list-group-flush" id="requerentes"></ul>
			</p>
			<p class="card-text font-weight-bold">Títulos:</p>
			<p>
				<ul class="list-group list-group-flush" id="titulo"></ul>
			</p>
			<button type="button" class="btn btn-primary btn-lg btn-block" id="salvar">Salvar</button>
		</div>
	</div>
</div>

<div class="container">
	<hr>
	<footer>
		<p>Valter Filho</p>
	</footer>
</div>
</body>
</html>