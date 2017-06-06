<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="titulo" required="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:url value="/resources/css" var="cssPath" />
<link type="text/css" rel="stylesheet"
	href="${cssPath}/bootstrap.min.css" />
<link type="text/css" rel="stylesheet"
	href="${cssPath}/bootstrap-theme.min.css" />
<link type="text/css" rel="stylesheet" href="${cssPath}/estilo.css" />
<title>${titulo}</title>
</head>

<%@ include file="/WEB-INF/views/cabecalho.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-md-3">
			<ul class="list-group">
				<li class="list-group-item"><a href="/biblioteca/">Home</a></li>
				<li class="list-group-item"><a href="autores">Autor</a></li>
				<li class="list-group-item"><a href="categorias">Categoria</a></li>
				<li class="list-group-item"><a href="editoras">Editora</a></li>
				<li class="list-group-item"><a href="livros">Livro</a></li>
			</ul>
		</div>
		<div class="col-md-9">
			<jsp:doBody />
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/rodape.jsp"%>