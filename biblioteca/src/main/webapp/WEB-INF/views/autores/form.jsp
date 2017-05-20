<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Autor">
	<div class="page-header">
		<h1>Cadastro <small>de autor</small></h1>
	</div>
	<form action="/biblioteca/autores" method="POST"
		class="form-horizontal">
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Nome:</label>
			<div class="col-sm-10">
				<input type="text" name="nome" id="name" class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label for="nacionalidade" class="col-sm-2 control-label">Nacionalidade:</label>
			<div class="col-sm-10">
				<input type="text" name="nacionalidade" id="nacionalidade"
					class="form-control">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" value="Salvar" id="salvar"
					class="btn btn-success" />
			</div>
		</div>
	</form>

</tags:pageTemplate>

