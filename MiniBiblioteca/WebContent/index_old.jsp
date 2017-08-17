<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mini Biblioteca</title>
</head>
<body>
	<h1>Mini Biblioteca em JavaEE</h1>
	<form action="servletInsereLivro" method="get">
	<table>
		<tr>
			<td>Codigo do Livro:</td>
			<td><input type="text" name="id" placeholder="0000"></td>
		</tr>
		<tr>
			<td>Autor:</td>
			<td><input type="text" name="autor" placeholder="Nome do Autor"></td>
		</tr>
		<tr>
			<td>Titulo do Livro:</td>
			<td><input type="text" name="titulo" placeholder="Nome do Livro"></td>
		</tr>
		<tr>
			<td><input type="submit" value="Enviar"></td>
		</tr>
	</table>
	</form>
	
	<hr/>
	<a href="http://localhost:8080/MiniBiblioteca/ServletListaLivros">Ver livros</a>
</body>
</html>