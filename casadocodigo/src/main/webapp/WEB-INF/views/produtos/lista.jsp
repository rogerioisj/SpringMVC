<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livro bagarai aqui mano</title>
</head>
<body>
	<h1>Lista de Produtos</h1>
	<div>${sucesso }</div>
	<table>
		<tr>
			<td>Título</td>
			<td>Descrição</td>
			<td>Páginas</td>
		</tr>
		<core:forEach items="${produtos }" var="produto" >
			<tr>
				<td>${produto.titulo }</td>
				<td> ${produto.descricao } </td>
				<td> ${produto.paginas }</td>
			</tr>
		</core:forEach>
	</table>
</body>
</html>