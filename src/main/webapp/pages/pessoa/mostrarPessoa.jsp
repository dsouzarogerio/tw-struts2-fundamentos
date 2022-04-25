<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mostrar Pessoa</title>
</head>
<body>
	<h3>Pessoa id: <s:property value="pessoa.id"/></h3>
		<p><s:property value="pessoa.nome"/></p>
		<p><s:property value="pessoa.idade"/></p>
</body>
</html>