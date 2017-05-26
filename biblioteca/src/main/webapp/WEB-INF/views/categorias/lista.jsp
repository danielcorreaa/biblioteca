<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
	function excluir(id,a) {
		if(confirm("Deseja excluir a categoria?"))
		a.href = "categorias/delete?id="+id;
	}
</script>

<tags:pageTemplate titulo="Categoria">
	<div class="page-header">
		<h1>
			Lista Categorias <small></small>
		</h1>
	</div>
	<table class="table table-striped">
		<tr>
			<th>Código</th>
			<th>Nome</th>
		</tr>
		<c:forEach var="categoria" items="${categorias}">
			<tr>
				<td>${categoria.codigo}</td>
				<td>${categoria.descricao}</td>
				<td>Alterar</td>
				<td><a><span class="glyphicon glyphicon-refresh"
						aria-hidden="true"></span></a></td>
				<td><a onclick="excluir(${categoria.codigo}, this)"><span
						class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="categorias/form" class="button button-primary">Novo</a>
</tags:pageTemplate>