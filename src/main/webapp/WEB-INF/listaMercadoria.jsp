<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>Mercadorias</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<link href="css/bootstrap.css" rel="stylesheet">
<link href="//cdn.datatables.net/1.10.12/css/dataTables.bootstrap.min.css" rel="stylesheet">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/rules.js"></script>

 
<script type="text/javascript" src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="//cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js"></script>





<style type="text/css">
#titulo {
	text-align: center;
	margin-top: 20px;
	margin-bottom: 20px;
	margin-left: auto;
	margin-right: auto;
}

.btn{
    padding: 6px;
}

th{
text-align:center;
}
</style>


</head>
<body>

	<div class="container">

		<div id="titulo">
			<h1>Lista de Mercadoria</h1>
		</div>

		<div class="col-sm-12">
		<div class="table-responsive">
		<table id="table01" class="table table-bordered table-hover table-striped">
		<thead>
		<tr>
		<th>Código</th>
		<th>Nome</th>
		<th>Tipo</th>
		<th>Quantidade</th>
		<th>Valor</th>
		<th>Tipo de Negocio</th>
		<th>Opções</th>
		</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${lista}" var="item">
		
		<tr>
			<td>${item.codigo}</td>
			<td>${item.nome}</td>
			<td>${item.tipo}</td>
			<td>${item.quantidade}</td>
			<td><fmt:setLocale value="pt_BR"/>
                 <fmt:formatNumber value="${item.preco}" type="currency"/></td>
			<td>${item.tipoNegocio}</td>
			
			<td>
			<input type="button" value="Editar" onclick="location.href='editmerc.do?cod=${item.codigo}'"
					class="btn btn-default" style="text-align:center">
			<input type="button" value="Excluir" onclick="confirmaExcluir(${item.codigo})"
					class="btn btn-danger"></td>
					
		</tr>
		
		</c:forEach>
		</tbody>
		
		</table>
		</div>
		<input type="button" value="Nova Mercadoria" onclick="location.href='mercadoria.do'"
					class="btn btn-primary">
		</div>
	</div>

</body>
<script type="text/javascript">
	$(document).ready(function(){
		 $('#table01').dataTable();	
		});
	
</script>
</html>

