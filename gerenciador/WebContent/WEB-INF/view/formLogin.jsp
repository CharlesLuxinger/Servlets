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
	<form action="${linkMain}" method="post">
		Login:<input type="text" name="login" /> 
		Password:<input type="password" name="password" />
		<input type="hidden" name="action" value="Login"> 
		<input type="submit" />
	</form>

</body>
</html>