<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livro bagarai aqui mano</title>
</head>
<body>
	<h1>Lista de Produtos</h1>
	<div>${sucesso }</div>
	<div>${falha }</div>
	<table>
		<tr>
			<td>Título</td>
			<td>Descrição</td>
			<td>Páginas</td>
		</tr>
		<core:forEach items="${produtos }" var="produto">
			<tr>
				<td><a href= "${s:mvcUrl('PC#detalhe').arg(0,produto.id).build() }">${produto.titulo }</a></td>
				<td>${produto.descricao }</td>
				<td>${produto.paginas }</td>
			</tr>
		</core:forEach>
	</table>
</body>
</html>