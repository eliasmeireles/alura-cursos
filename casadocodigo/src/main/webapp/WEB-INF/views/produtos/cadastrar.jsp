<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC</title>
</head>
<style>
form {
	width: 350px;
	margin: 0 auto;
}
label {
	font-size: 25px;
	padding-top: 1em;
}
.inputtxt {
	padding-bottom: .5em;
	padding-top: .5em;
}
label, input:not(:last-child), textarea {
	width: 100%;
	resize: none;
	display: block;
}
form .btn {
	text-align: center;
	font-size: 18px;
	padding-bottom: 1em;
	padding-top: 1em;
	margin-top: 1em;
}
</style>
<body>
	<%@include file="../header.jsp"%>
	<form action="/casadocodigo/ok">
		<label>Titulo</label> 
		<input class="inputtxt" type="text" name="titulo" placeholder="Titulo do livro"> 
		<label>Número de páginas</label> 
		<input class="inputtxt" type="number" name="paginas" placeholder="Ínforme o número de páginas do livro"> 
		<label>Descrição</label>
		<textarea class="inputtxt" name="descricao" rows="5" cols="10" placeholder="Descrição do livro"></textarea>
		<input class="btn" type="submit" value="Cadastrar">
	</form>
</body>
</html>