<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Autores</title>
<script type="text/javascript">
	function excluir(id,a) {
		if(confirm("Deseja excluir o autor"))
		a.href = "autores/delete?id="+id;
	}
</script>
</head>
<body>

<h3>Lista Autores</h3>
<table>
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
			<td><a onclick="excluir(${autor.codigo}, this)">Delete</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>