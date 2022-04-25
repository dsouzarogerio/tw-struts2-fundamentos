<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro</title>
</head>
<body>
	<h3>Cadastro de Pessoa</h3>
	<s:form action="inserirPessoa">
		<s:textfield label="Nome" name="pessoa.nome"></s:textfield>
		<s:textfield label="Idade" name="pessoa.idade"></s:textfield>
		<s:submit value="Salvar!"></s:submit>
	</s:form>
	<!-- Condição de erro, caso haja mensagem de erro na  action mensagemErro -->
	<s:if test="mensagemErro != ''">
		<p style="color: red;"><s:property value="mensagemErro"/></p>
	</s:if>
</body>
</html>