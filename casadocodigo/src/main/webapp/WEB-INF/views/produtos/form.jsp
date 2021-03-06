<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<core:url value="/resources/css" var="cssPath" />
<link rel="stylesheet" href="${cssPath}/bootstrap.min.css" />
<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css" />
<link href="${cssPath}/bootstrap.css" rel="stylesheet">

<style type="text/css">
body {
	padding: 0px 0px;
	padding-bottom: 10px;
	padding-right: 10px;
	padding-left: 10px;
}
</style>
<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${s:mvcUrl('HC#home').build()}">Casa
				do Código</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<security:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="${s:mvcUrl('PC#listar').build()}">Lista de
							Produtos</a></li>
					<li><a href="${s:mvcUrl('PC#form').build()}">Cadastro de
							Produtos</a></li>
				</security:authorize>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<%-- 			Variação:	<security:authentication property="principal.username"/> --%>
				<li><a href="#"><security:authentication
							property="principal" var="usuario" /> Usuário:
						${usuario.username } </a></li>
				<li><a href="/casadocodigo/logout">Sair</a></li>
			</ul>

		</div>
		<!-- /.navbar-collapse -->
	</div>
</nav>
<title>Livro bagarai aqui mano</title>
</head>
<body>

	<!-- "/casadocodigo/produtos" -->
	<%-- ${s:mvcUrl('PC#gravar').build()} --%>
	<form:form action="${ s:mvcUrl('PC#grava').build() }" method="post"
		commandName="produto" enctype="multipart/form-data">

		<div class="form-group">
			<label> Título </label>
			<form:input path="titulo" cssClass="form-control" />
			<form:errors path="titulo" />
		</div>
		<div class="form-group">
			<label> Descrição</label>
			<form:textarea path="descricao" cssClass="form-control"></form:textarea>
			<form:errors path="descricao" />
		</div>
		<div class="form-group">
			<label> Páginas</label>
			<form:input path="paginas" cssClass="form-control" />
			<form:errors path="paginas" />
		</div>
		<div class="form-group">
			<label> Data de Lançamento</label>
			<form:input path="dataLancamento" cssClass="form-control" />
			<form:errors path="dataLancamento" />
		</div>
		<div class="form-group">
			<core:forEach items="${tipos }" var="tipoPreco" varStatus="status">
				<label>${tipoPreco }</label>
				<form:input path="precos[${status.index}].valor"
					cssClass="form-control" />
				<form:hidden path="precos[${status.index }].tipo"
					value="${tipoPreco }" />
			</core:forEach>
		</div>
		<div class="form-group">
			<label>Sumário</label>
			<%-- 			<form:input path="sumario"/> --%>
			<input name="sumario" type="file" />
		</div>
		<button type="submit" class="btn btn-primary">Cadastrar</button>
	</form:form>
</body>
</html>