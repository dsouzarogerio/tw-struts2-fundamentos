<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Pessoas</title>
</head>
<body>
	<h3>Listar Pessoas</h3>
	
	<!-- Link para a página de cadastro de pessoas -->
	<s:url action="paginaCadastroPessoa" var="paginaCadastroPessoaUrl"></s:url>
	<s:a href="%{paginaCadastroPessoaUrl}">Cadastrar nova pessoa...</s:a>
	
	<!-- Interface de pesquisa do usuário -->
	<p>
		<input type="text" id="txt-nome">
		<button id="btn-pesquisar">Pesquisar</button>
	</p>
	
	<!-- Início tabela -->
	<table border="1" id="tbl-pessoas">
	<!-- Cabeçalho -->
		<thead>
			<tr>
				<th>Nome</th>
				<th>Idade</th>
				<th>Ações</th>
			</tr>
		</thead>
		<!-- Corpo da tabela -->
		<tbody>
		<!-- Iteração da lista de pessoas -->
			<s:iterator value="pessoas">
				<tr>
					<td><s:property value="nome"/></td>
					<td><s:property value="idade"/></td>
					<td>
						<!--link para detalhe de pessoa: ex.: mostrarPessoa?id=1 -->
						<s:url action="mostrarPessoa" var="mostrarPessoaUrl">
							<s:param name="id"><s:property value="id"/></s:param>
						</s:url>
						<s:a href="%{mostrarPessoaUrl}">Mostrar</s:a>
					</td>
				</tr>
			</s:iterator>
		</tbody>
		<!-- Condição de erro, caso haja mensagem de erro na  action mensagemErro -->
		<s:if test="mensagemErro != ''">
			<p style="color: red;"><s:property value="mensagemErro"/></p>
		</s:if>
	</table>
	<!-- Final tabela -->
	<!-- CDN do jQuery -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous">
	</script>
	<!-- Funcionalidades JavaScript -->
	<script> 
		$(document).ready(function() {
			$('#btn-pesquisar').click(function() {
			var nome = $('#txt-nome').val();
			$.ajax({
				method: 'GET',
				url: 'pesquisarPessoaPorNome.action?nome=' + nome,
						success: function(dados) {
							$('#tbl-pessoas > tbody tr').remove();
							$.each(dados, function(idx, pessoa) {
								$('#tbl-pessoas > tbody').append(
										'<tr>' +
										'	<td>' + pessoa.nome + '</td>' +
										'	<td>' + pessoa.idade + '</td>' +
										'	<td></td>' +
										'</tr>'		
								);
							});
						},
						error: function() {
							alert('Deu erro!');
						}
			});
		});
	});
	</script>
</body>
</html>