function validar() {

	var nome = document.getElementById("nome");
	var tipo = document.getElementById("tipo");
	var quantidade = document.getElementById("quantidade");
	var preco = document.getElementById("preco");

	document.getElementById("erros").style.display = 'none';
	
	document.getElementById("nomeErro").innerHTML = "";
	document.getElementById("tipoErro").innerHTML = "";
	document.getElementById("quantidadeErro").innerHTML = "";
	document.getElementById("precoErro").innerHTML = "";
	
	document.getElementById("pNome").className = "";
	document.getElementById("pTipo").className = "";
	document.getElementById("pQtd").className = "";
	document.getElementById("pPreco").className = "";

	var flag = true;

	if (nome.value == "" || nome.value.length < 3 || nome.value.length > 50) {
		document.getElementById("nomeErro").innerHTML = "- Insira um nome válido!";
		document.getElementById("pNome").className = "has-error";
		flag = false;
	}

	if (tipo.value == "" || tipo.value.length > 50) {
		document.getElementById("tipoErro").innerHTML = "- Insira um tipo!";
		document.getElementById("pTipo").className = "has-error";
		flag = false;
	}
	if (quantidade.value == "" || quantidade.value < 0 || quantidade.value > 99999999) {
		document.getElementById("quantidadeErro").innerHTML = "- Insira uma quantidade válida!";
		document.getElementById("pQtd").className = "has-error";
		flag = false;
	}
	if (preco.value == "" || preco.value < 0 || preco.value > 99999999.99) {
		document.getElementById("precoErro").innerHTML = "- Insira um preço a mercadoria!";
		document.getElementById("pPreco").className = "has-error";
		flag = false;
	}

	if (flag == false) {
		document.getElementById("erros").style.display = 'block';
		return false;
	}

}

function confirmaExcluir(cod) {
	if (confirm("Deseja Confirmar a Exclusão ?")) {
		location.href = 'exmerc.do?cod=' + cod;
	}

}

function limpar(){
	
	document.getElementById("nome").value = "";
	document.getElementById("tipo").value = "";
	document.getElementById("quantidade").value = "";
	document.getElementById("preco").value = "";
}