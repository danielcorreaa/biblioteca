<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Autor">
	<div class="page-header">
		<h1>Cadastro <small>de categoria</small></h1>
	</div>
	<form action="/biblioteca/categorias" method="POST" class="form-horizontal">
		<div class="form-group">			
			<label for="descricao" class="col-sm-2 control-label">Descrição:</label>
			<div class="col-sm-10">
				<input type="text" name="descricao" id="descricao" class="form-control" />
			</div>			
		</div>		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" value="Salvar" id="salvar" class="btn btn-success"/>
			</div>
		</div>
	</form>
</tags:pageTemplate>