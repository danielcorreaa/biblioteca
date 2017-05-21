<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
	function excluir(id,a) {
		if(confirm("Deseja excluir o autor?"))
		a.href = "editoras/delete?id="+id;
	}
</script>

<tags:pageTemplate titulo="Editora">
	<div class="page-header">
		<h1>Lista Editoras <small></small></h1>
	</div>
	<table class="table table-striped">
		<tr>
			<th>Código</th>
			<th>Nome</th>
			<th>Nacionalidade</th>
			<th>Endereço</th>
			<th>Contato</th>
		</tr>
		<c:forEach var="editora" items="${editoras}">
			<tr>
				<td>${editora.codigo}</td>
				<td>${editora.nome}</td>
				<td>${editora.nacionalidade}</td>
				<td>${editora.endereco}</td>
				<td>${editora.contato}</td>			
				<td><a><span class="glyphicon glyphicon-refresh" aria-hidden="true"></span></a></td>
				<td><a onclick="excluir(${editora.codigo}, this)"><span 
					class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="form" class="button button-primary">Novo</a>
</tags:pageTemplate>
