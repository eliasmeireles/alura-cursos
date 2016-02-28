<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	<form action="/casadocodigo/produtos" method="POST">
		<label>Titulo</label> 
		<input class="inputtxt" type="text" name="titulo" placeholder="Titulo do livro"> 
		<label>Número de páginas</label> 
		<input class="inputtxt" type="number" name="paginas" placeholder="Ínforme o número de páginas do livro"> 
		<label>Descrição</label>
		<textarea class="inputtxt" name="descricao" rows="5" cols="10" placeholder="Descrição do livro"></textarea>
		<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
            <div>
                <label>${tipoPreco}</label>
                <input class="inputtxt" type="number" name="precos[${status.index}].valor">
                <input type="hidden" name="precos[${status.index}].tipo" value="${tipoPreco}">
            </div>
		</c:forEach>
		<input class="btn" type="submit" value="Cadastrar">
	</form>
</body>
</html>