<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Empresa</title>
</head>
<body>
	<c:if test="${ not empty nomeEmpresa}">
		Empresa ${nomeEmpresa}, Cadastrada!
	</c:if>
	<c:if test="${ empty nomeEmpresa}">
		Nenhuma empresa cadastrada!
	</c:if>
</body>
</html>