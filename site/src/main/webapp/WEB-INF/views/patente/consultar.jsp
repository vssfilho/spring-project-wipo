<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="/WEB-INF/views/common/common-libs.jsp" />
<script src="./resources/js/controller/patente/consulta_patente.js"></script>
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
		<h4>Buscar patente</h4>
		<div class="input-group mb-3">
			<input type="text" class="form-control" id="numero_patente"
				placeholder="Número da patente" aria-label="Número da patente"
				aria-describedby="basic-addon2"> <input type="text"
				class="form-control" id="requerente_patente"
				placeholder="Requerente da patente"
				aria-label="Requerente da patente" aria-describedby="basic-addon2">
			<div class="input-group-append">
				<button class="btn btn-outline-secondary" type="button"
					id="buscar_patente">Buscar</button>
			</div>
		</div>
	</div>
</div>

<div class="container">
	<div class="card" id="mensagem">
		<div class="card-body">
			<p class="card-text" id="texto"></p>
		</div>
	</div>
	<div class="card" id="resultado_consulta">
		<h5 class="card-header">Patentes cadastradas</h5>
		<div class="card-body">
			<div class="table-responsive-xl">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Nº Publicação</th>
							<th scope="col">Nº Ped. Internacional</th>
							<th scope="col">Data Publicação</th>
							<th scope="col">Requerentes</th>
							<th scope="col">Título</th>
						</tr>
					</thead>
					<tbody id="grid_patentes">
						<tr>
							<th scope="row">1</th>
							<td>Mark</td>
							<td>Otto</td>
							<td>@mdo</td>
							<td>Otto</td>
							<td>@mdo</td>
						</tr>
					</tbody>
				</table>
			</div>
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