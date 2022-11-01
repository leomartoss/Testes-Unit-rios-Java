package br.com.api.models;

public class Produto {
	
	private long codigo;
	private String nome;
	private int qtd;
	
	public Produto(long codigo, String nome, int qtd) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.qtd = qtd;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}	
	
}
