<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Autor</title>
</head>
<body>

	<form action="/biblioteca/autores" method="POST">
		<div>
			<label id="name">Nome:</label>
			<input type="text" name="nome" id="name"/>
		</div>
		<div>
			<label id="label-1">Nacionalidade:</label>
			<input type="text" name="nacionalidade" id="nacionalidade">
		</div>
		<div>
			<input type="submit" value="Salvar" id="salvar"/>
		</div>
	</form>

</body>
</html>