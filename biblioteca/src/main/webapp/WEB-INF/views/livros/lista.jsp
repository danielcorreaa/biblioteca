<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
	function excluir(id,a) {
		if(confirm("Deseja excluir o livro?"))
		a.href = "livros/delete?id="+id;
	}
</script>

<tags:pageTemplate titulo="Livros">
	<div class="page-header">
		<h1>Lista Livros <small></small></h1>
	</div>
	<table class="table table-striped">
		<tr>
			<th>Código</th>
			<th>Nome</th>
			<th>Nacionalidade</th>
			<th>Endereço</th>
			<th>Contato</th>
		</tr>
		<c:forEach var="livro" items="${livros}">
			<tr>
				<td>${livro.codigo}</td>
				<td>${livro.titulo}</td>
				<td>${livro.tituloOriginal}</td>
				<td>${livro.idiomaOriginal}</td>
				<td>${livro.situacao}</td>
				<td>${livro.editoraNome}</td>	
				<td>${livro.categoriaDescricao}</td>				
				<td><a><span class="glyphicon glyphicon-refresh" aria-hidden="true"></span></a></td>
				<td><a onclick="excluir(${livro.codigo}, this)"><span 
					class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="livros/form" class="button button-primary">Novo</a>
</tags:pageTemplate>
