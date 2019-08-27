<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <title>Livro bagarai aqui mano</title> -->
</head>
<body>
<!-- "/casadocodigo/produtos" -->
<%-- ${s:mvcUrl('PC#gravar').build()} --%>
	<form:form action="${s:mvcUrl('PC#grava').build() }" method="POST" commandName="produto">
		<div>
			<label> Título </label> 
			<input type="text" name="titulo" />
			<form:errors path="titulo"/>
		</div>
		<div>
			<label> Descrição</label>
			<textarea rows="10" cols="20" name="descricao">Digíte a descrição aqui</textarea>
			<form:errors path="descricao"/>
		</div>
		<div>
			<label> Páginas</label>
			<input type="text" name="paginas" /> 
			<form:errors path="paginas"/>
		</div>
		<div>
			<core:forEach items="${tipos }" var="tipoPreco" varStatus="status">
				<label>${tipoPreco }</label>
				<input type="text" name="precos[${status.index}].valor">
				<input type="hidden" name="precos[${status.index }].tipo"
					value="${tipoPreco }" />
			</core:forEach>
		</div>
		<button type="submit">Cadastrar</button>
	</form:form>
</body>
</html>