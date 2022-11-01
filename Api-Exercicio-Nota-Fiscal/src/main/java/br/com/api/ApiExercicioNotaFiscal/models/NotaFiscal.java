package br.com.api.ApiExercicioNotaFiscal.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="notas_fiscais")
public class NotaFiscal {
	
	@Id	
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long codigo;	
	private String emitente;	
	private String destinatario;
    private int numeroNota;	
	private double valor;	
	
			

	public NotaFiscal(String emitente, String destinatario, int numeroNota, double valor) {		
	this.emitente = emitente;	
	this.destinatario = destinatario;	
	this.numeroNota = numeroNota;
	this.valor = valor; 		
	}			
	
	public NotaFiscal() {}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getEmitente() {
		return emitente;
	}

	public void setEmitente(String emitente) {
		this.emitente = emitente;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public int getNumeroNota() {
		return numeroNota;
	}

	public void setNumeroNota(int numeroNota) {
		this.numeroNota = numeroNota;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}	
	
	

}
