package br.com.api.API.Alunos.H2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="alunos")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long codigo;
	private String nome;
	private int nota;
	
	public Aluno(long codigo, String nome, int qtd) {
		super();
		this.codigo=codigo;
		this.nome=nome;
		this.nota=qtd;
		
	}
	
	public Aluno() {}

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

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}
	
	@Override
	public String toString() {
		return "Aluno [codigo=" + codigo +",nome="+ nome + ", nota="+nota +"]";
	}
	
	
	
	
	

}
