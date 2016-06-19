<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Mercadorias</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<link href="css/bootstrap.css" rel="stylesheet">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/rules.js">
	
</script>

<style type="text/css">
#titulo {
	text-align: center;
	margin-top: 20px;
	margin-bottom: 20px;
	margin-left: auto;
	margin-right: auto;
}

.col-sm-4 {
	margin-top: 20px;
	margin-bottom: 20px;
	margin-left: auto;
	margin-right: auto;
}

#erros {
	display: none;
	font-weight: bold;
	text-transform: uppercase;
}

span{
display:block;
}
</style>


</head>
<body>

	<div class="container">

		<div id="titulo">
			<h1>Salvar Mercadoria</h1>
		</div>

		<div class="col-sm-8">

			<div class="alert alert-danger" id="erros">

				<span id="nomeErro"></span> 
				<span id="tipoErro"></span> 
				<span id="quantidadeErro"></span> 
				<span id="precoErro"></span>
			</div>

			<form class="form-horizontal" id="frm" action="mercadoria.do"
				method="post">


				<input type="hidden" value="${mercadoria.codigo}" name="cod">
				<p class="" id="pNome">
					<label for="nome">Nome:</label> <br /> <input class="form-control"
						type="text" maxlength="50" name="txtNome" id="nome"
						value="${mercadoria.nome}">
				</p>

				<p class="" id="pTipo">
					<label for="tipo">Tipo:</label> <br /> <input class="form-control"
						type="text" name="txtTipo" id="tipo" value="${mercadoria.tipo}">
				</p >

				<p class="" id="pQtd">
					<label for="quantidade">Quantidade:</label> <br /> <input
						class="form-control" type="number" name="txtQtd" id="quantidade"
						min="0" value="${mercadoria.quantidade}">
				</p>

				<p class="" id="pPreco">
					<label for="preco">Preço:</label> <br /> <input
						class="form-control" type="number" maxlength="10" name="txtPreco"
						id="preco" step="0.01" min="0" value="${mercadoria.preco}">
				</p>

				<p>
					<label>Tipo de Negócio:</label> <br /> 
					
					<c:choose>
					<c:when test="${mercadoria.tipoNegocio == 'VENDA'}">
					<label
						class="checkbox-inline"><input type="radio"
						name="rNegocio" value="COMPRA" > Compra </label>
					<br /> <label class="checkbox-inline"><input type="radio"
						name="rNegocio" value="VENDA" checked="checked"> Venda </label>
					</c:when>	
					<c:otherwise>
					<label
						class="checkbox-inline"><input type="radio"
						name="rNegocio" value="COMPRA"  checked="checked"> Compra </label>
					<br /> <label class="checkbox-inline"><input type="radio"
						name="rNegocio" value="VENDA"> Venda </label>
					</c:otherwise>
					
					</c:choose>
						
				</p>

				<input type="submit" value="Salvar" onclick="return validar()"
					class="btn btn-primary"> 
				<input type="button" value="Limpar"
					class="btn btn-primary" onclick="limpar()">
					
				<input type="button" value="Lista de Mercadarias"
					class="btn btn-primary pull-right" onclick="location.href='listm.do'">
			</form>
		</div>


	</div>

</body>
</html>

