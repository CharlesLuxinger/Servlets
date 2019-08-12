<%@page import="java.io.IOException"%>
<%@page import="br.com.alura.gerenciador.servlet.model.entity.Empresa"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Empresas Cadastradas</title>
</head>
<body>
	<c:import url="login.jsp"/>
	Empresas Cadastradas:
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/> 
				<a href = "/gerenciador/main?action=ShowEmpresa&id=${empresa.id}">edit</a>
				<a href = "/gerenciador/main?action=RemoveEmpresa&id=${empresa.id}">remove</a>
			</li>
		</c:forEach>
	</ul>
	<c:if test="${ empty empresas}"> Nenhuma empresa cadastrada! </c:if>
</body>
</html>