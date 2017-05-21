<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
	function excluir(id,a) {
		if(confirm("Deseja excluir o autor?"))
		a.href = "autores/delete?id="+id;
	}
</script>

<tags:pageTemplate titulo="Autor">
	<div class="page-header">
		<h1>
			Lista Autores <small></small>
		</h1>
	</div>
	<table class="table table-striped">
		<tr>
			<th>Código</th>
			<th>Nome</th>
			<th>Nacionalidade</th>
		</tr>
		<c:forEach var="autor" items="${autores}">
			<tr>
				<td>${autor.codigo}</td>
				<td>${autor.nome}</td>
				<td>${autor.nacionalidade}</td>
				<td>Alterar</td>
				<td><a><span class="glyphicon glyphicon-refresh" aria-hidden="true"></span></a></td>
				<td><a onclick="excluir(${autor.codigo}, this)"><span 
					class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
			</tr>
		</c:forEach>
	</table>
</tags:pageTemplate>