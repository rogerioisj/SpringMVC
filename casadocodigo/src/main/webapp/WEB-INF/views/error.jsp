<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<%-- <%@ include file = "/WEB-INF/views/cabecalho.jsp" %> --%>

<tags:pageTemplate
	titulo="Livros de Java, Android, IOs, Mobile e muito mais...">

	<section id="index-section" class="container middle">
		<h2>O produto informado não foi encontrado</h2>
	</section>

	<!-- 
        Mensagem: ${exception.message}
        <c:forEach items="${exception.stackTrace}" var="stk">
            ${stk}
        </c:forEach>    
    -->

</tags:pageTemplate>