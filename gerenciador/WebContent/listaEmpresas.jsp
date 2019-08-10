<%@page import="java.io.IOException"%>
<%@page import="br.com.alura.gerenciador.servlet.entity.Empresa"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Empresas Cadastradas</title>
</head>
<body>
	Empresas Cadastradas:
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>${empresa.nome}</li>
		</c:forEach>
	</ul>
</body>
</html>