<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nova Empresa</title>
</head>
<body>
	<form action="${linkServletNovaEmpresa}" method="post">
		Nome:<input type="text" name="nome" /> 
		Data Abertura:<input type="text" name="data" />
		<input type="submit" />
	</form>

</body>
</html>