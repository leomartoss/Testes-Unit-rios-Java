package br.com.api.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "eleitores")
public class Eleitor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigo;
	private String nome;
	private String cpf;
	private int titulo;

	public Eleitor(String nome, String cpf, int titulo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.titulo = titulo;
	}
	

	public Eleitor(long codigo, String nome, String cpf, int titulo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.titulo = titulo;
	}
	
	public Eleitor() {}

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getTitulo() {
		return titulo;
	}

	public void setTitulo(int titulo) {
		this.titulo = titulo;
	}

}
