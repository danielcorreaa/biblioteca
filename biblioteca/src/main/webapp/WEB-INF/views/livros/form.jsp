<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Autor">
	<div class="page-header">
		<h1>Cadastro <small>de Livro</small></h1>
	</div>
	<form action="/biblioteca/livros" method="POST" class="form-horizontal">		
		<div class="form-group">
			<label for="título" class="col-sm-2 control-label">Titulo:</label>
			<div class="col-sm-10">				
				<input type="text" name="titulo" id="titulo" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label for="tituloOriginal" class="col-sm-2 control-label">Titulo Original:</label>
			<div class="col-sm-10">				
				<input type="text" name="tituloOriginal" id="tituloOriginal" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label for="idiomaOriginal" class="col-sm-2 control-label">Idioma Original:</label>
			<div class="col-sm-10">
				<input type="text" name="idiomaOriginal" id="idiomaOriginal"  class="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label for="situacao" class="col-sm-2 control-label">Situação:</label>
			<div class="col-sm-10">
				<input type="text" name="situacao" id="situacao"  class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label for="editora" class="col-sm-2 control-label">Editora:</label>
			<div class="col-sm-10">
				<select name="editora">
					<c:forEach var="editora" items="${editoras }">
						<option>${editora.nome }</option>
					</c:forEach>
				</select>		
			</div>
		</div>
		<div class="form-group">
			<label for="categoria" class="col-sm-2 control-label">Categoria:</label>
			<div class="col-sm-10">
				<select name="categoria">
					<c:forEach var="categoria" items="${categorias}">
						<option>${categoria.descricao}</option>
					</c:forEach>
				</select>	
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" value="Salvar" id="salvar" class="btn btn-success"/>
			</div>
		</div>
	</form>
</tags:pageTemplate>