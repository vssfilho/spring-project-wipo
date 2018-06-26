<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="/WEB-INF/views/common/common-libs.jsp" />
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
		<p>
			<a class="btn btn-primary btn-md" href="./patente/cadastro" role="button">Cadastrar</a>
			<a class="btn btn-primary btn-md" href="./patente/consultar" role="button">Consultar</a>
		</p>
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