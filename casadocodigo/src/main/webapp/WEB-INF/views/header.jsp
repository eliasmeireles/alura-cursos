<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC</title>
</head>
<style>
body {
	max-width: 1915px;
	width: 95%;
	margin: 0 auto;
}

h1 {
	text-align: center;
	font-size: 35px;
	padding-top: 1em;
	padding-bottom: 1em;
	background: green;
	color: #FFF;
}

ul {
	padding-bottom: 2em;
	padding-top: 2em;
	background-color: gray;
	text-align: center;
}

li {
	display: inline-block;
	width: 250px;
}

li a {
	text-decoration: none;
	color: #FFF;
	text-align: center;
	font-size: 15px;
}

li a:hover {
	color: black;
}

a:hover {
	cursor: pointer;
}
</style>
<body>
	<h1>Cada do código</h1>
	<nav>
		<ul>
			<li><a href="/casadocodigo">Home</a></li>
			<li><a href="/casadocodigo/produtos">Nossos Produtos</a></li>
			<li><a href="/casadocodigo/produtos">Livros Disponiveis</a></li>
			<li><a href="/casadocodigo/produtos/form">Cadastrar produto</a></li>
		</ul>
	</nav>
</body>
</html>