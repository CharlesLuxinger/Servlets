<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url value="/main" var="linkMain"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nova Empresa</title>
</head>
<body>
	<c:import url="login.jsp"/>
	<form action="${linkMain}" method="post">
		Nome:<input type="text" name="nome" /> 
		Data Abertura:<input type="text" name="data" />
		<input type="hidden" name="action" value="AddEmpresa"> 
		<input type="submit" />
	</form>

</body>
</html>