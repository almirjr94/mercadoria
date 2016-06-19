package br.com.valemobi.model;

public class Mercadoria {

	public Mercadoria(Long codigo, String tipo, String nome, Long quantidade, double preco, TipoNegocio tipoNegocio) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
		this.tipoNegocio = tipoNegocio;
	}

	private Long codigo;
	private String tipo;
	private String nome;
	private Long quantidade;
	private double preco;
	private TipoNegocio tipoNegocio;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public TipoNegocio getTipoNegocio() {
		return tipoNegocio;
	}

	public void setTipoNegocio(TipoNegocio tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}

	public Long getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return "Mercadoria [codigo=" + codigo + ", tipo=" + tipo + ", nome=" + nome + ", quantidade=" + quantidade
				+ ", preco=" + preco + ", tipoNegocio=" + tipoNegocio + "]";
	}

}
