<%
//Scriplet
String nomeEmpresa = (String)request.getAttribute("nomeEmpresa");
%>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Nova Empresa</title>
	</head>
	<body>
		Empresa	<%= nomeEmpresa %>, Cadastrada!
	</body>
</html>